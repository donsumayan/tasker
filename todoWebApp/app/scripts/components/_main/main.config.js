// Main App configuration
(function () {
  angular
      .module("todo")
      .config(appConfig);

      function appConfig($stateProvider, $urlRouterProvider,$locationProvider) {
          $urlRouterProvider.otherwise('/dashboard');

          

          $stateProvider
              .state('main-default', {
                  abstract: true,
                  templateUrl: 'scripts/components/_main/main.tmpl.html'
              });

        // $locationProvider.html5Mode(true);
      }
})();
