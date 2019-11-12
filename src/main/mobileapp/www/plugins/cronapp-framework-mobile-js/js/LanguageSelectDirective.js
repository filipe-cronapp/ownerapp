angular.module('MyApp')
  .directive('ngTranslateLanguageSelect', function(LocaleService) {
    'use strict';
    return {
      restrict: 'A',
      replace: true,
      template: '' +
        '<div class="language-select" ng-if="visible">' +
        '<label>' +
        '<select ' +
        'ng-init="currentLocaleDisplayName = localesDisplayNames[0]"' +
        'ng-model="currentLocaleDisplayName" ' +
        'ng-options="localesDisplayName for localesDisplayName in localesDisplayNames" ' +
        'ng-change="changeLanguage(currentLocaleDisplayName)">' +
        'aria-label="Language Selector"' +
        '</select>' +
        '</label>' +
        '</div>' +
        '',
      controller: function($scope) {
        $scope.currentLocaleDisplayName = LocaleService.getLocaleDisplayName();
        $scope.localesDisplayNames = LocaleService.getLocalesDisplayNames();
        $scope.visible = $scope.localesDisplayNames &&
          $scope.localesDisplayNames.length > 1;
        $scope.changeLanguage = function(locale) {
          LocaleService.setLocaleByDisplayName(locale);
        };
      }
    };
  });
