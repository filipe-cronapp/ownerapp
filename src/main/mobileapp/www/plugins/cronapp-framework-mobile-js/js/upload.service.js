(function ($app) {
  angular.module('upload.services', []).service('UploadService', function ($http, $compile, $ionicModal) {

    let body = $('body');
    let $scope = angular.element(body.get(0)).scope();

    this.upload = function (data) {
      $scope.data = data;

      $ionicModal.fromTemplateUrl('plugins/cronapp-framework-mobile-js/components/upload/upload.html', {
        scope: $scope,
        animation: 'slide-in-up',
        resolve: {
          data: function () {
            return data;
          }
        }
      }).then(function (modal) {
        $scope.modal = modal;
        $scope.modal.show();
      });

    }.bind(this);
  });

  function strFormat(str) {
    let args = [].slice.call(arguments, 1),
      i = 0;

    return str.replace(/%s/g, () => {
      return args[i++];
    });
  }

  angular.module('custom.controllers').controller('UploadController',
    function ($scope, $translate, $stateParams, $location, $http, Upload, $timeout) {

      app.registerEventsCronapi($scope, $translate);

      // save state params into scope
      $scope.params = $stateParams;
      $scope.$http = $http;

      // Query string params
      let queryStringParams = $location.search();
      for (let key in queryStringParams) {
        if (queryStringParams.hasOwnProperty(key)) {
          $scope.params[key] = queryStringParams[key];
        }
      }

      $scope.uploading = false;
      $scope.uploaded = true;
      $scope.progress = 0;
      $scope.message = $translate.instant('Upload.oneFile');

      if ($scope.data.multiple === "true") {
        $scope.message = $translate.instant('Upload.multipleFile');
      }

      if ($scope.data.description) {
        $scope.message = $scope.data.description;
      }

      $scope.safeApply = safeApply;

      $scope.imagesSelected = function (files) {
        $scope.files = files;
        if (files && files.length) {
          Upload.upload({
            url: '/upload_image',
            method: 'POST',
            data: {
              files: files
            }
          }).then(function (response) {
            $timeout(function () {
              $scope.result = response.data;
            });
          }, function (response) {
            if (response.status > 0) {
              $scope.errorMsg = response.status + ': ' + response.data;
            }
          }, function (evt) {
            $scope.progress =
              Math.min(100, parseInt(100.0 * evt.loaded / evt.total));
          });
        }
      };

      $scope.uploadFile = function (files) {
        let pageScope = $scope.data.scope;
        let uploadUrl = 'api/cronapi/upload/' + $scope.data.id;
        let formData = new FormData();
        if (files.length === 0) {
          this.Notification.error(strFormat($translate.instant('Upload.errorValidation'), $scope.data.maxSize, $scope.data.filter));
        } else {
          for (let i = 0; i < files.length; i++) {
            formData.append("file", files[i]);
          }
          let _u = JSON.parse(localStorage.getItem('_u'));
          this.$promise = $http({
            method: 'POST',
            url: (window.hostApp || "") + uploadUrl,
            data: formData,
            headers: {
              'Content-Type': undefined,
              'X-AUTH-TOKEN': (_u ? _u.token : '')
            },
            onProgress: function (event) {
              this.safeApply(function () {
                if (event.lengthComputable) {
                  let complete = (event.loaded / event.total * 100 | 0);
                  $scope.progress = complete;
                }
                $scope.uploading = true;
              });
            }.bind(this)
          }).success(function (data, status, headers, config) {
            let result = pageScope.cronapi.evalInContext(JSON.stringify(data));
            $scope.uploaded = true;
            $scope.uploading = false;
            $scope.close();
          }.bind(this)).error(function (data, status, errorThrown) {
            this.Notification.error(data.error);
            $scope.uploading = false;
            $scope.close();
          }.bind(this));
        }
      }.bind($scope);

      $scope.close = function () {
        $scope.modal.hide();
      };

    });
}(app));