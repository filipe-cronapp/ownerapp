angular.module('ui-notification',[]);

angular.module('ui-notification').provider('Notification', function() {

    this.options = {
    };

    this.setOptions = function(options) {

    };

    this.$get = ["$translate", function($translate) {

        var notify = function(args, t){

            if (typeof args !== 'object' || args === null) {
                args = {message:args};
            }

            if (navigator.notification && navigator.notification.alert) {
              navigator.notification.alert(
                  args.message,
                  null,
                  $translate.instant(t),
                  'Ok'
              );
            } else {
              window.alert(args.message);
            }

            
            return null;
        };

        notify.primary = function(args) {
            return this(args, 'primary');
        };
        notify.error = function(args) {
            return this(args, 'error');
        };
        notify.success = function(args) {
            return this(args, 'success');
        };
        notify.info = function(args) {
            return this(args, 'info');
        };
        notify.warning = function(args) {
            return this(args, 'warning');
        };

        notify.clearAll = function() {
            
        };

        return notify;
    }];
});
