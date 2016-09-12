// Main App configuration
(function() {
    angular
        .module("todo")
        .constant('constants', {
            SERVICE_URL:'http://104.199.192.74/tasker-services/',
            APP_NAME: 'Tasker'
        });
})();
