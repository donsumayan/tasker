// Main App configuration
(function () {
  angular
      .module("todo")
      .config(appConfig);

      function appConfig($stateProvider, $urlRouterProvider) {
          $urlRouterProvider.otherwise('/login');

          $stateProvider
              .state('main-default', {
                  abstract: true,
                  templateUrl: 'scripts/components/_main/main.tmpl.html'
              });
      }
})();
