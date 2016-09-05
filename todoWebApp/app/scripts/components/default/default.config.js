(function () {
  angular
      .module("todo")
      .config(appConfig);

      function appConfig($stateProvider, $urlRouterProvider) {
          $urlRouterProvider.otherwise('/');

          $stateProvider
              .state('main-default', {
                  abstract: true,
                  templateUrl: 'scripts/components/default/default.tmpl.html'
              });
      }
})();
