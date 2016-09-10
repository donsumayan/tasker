// Home component configuration
(function() {
    'use strict';
    angular
        .module('todo.components.login')
        .config(loginConfig);

    function loginConfig($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise('/');

        $stateProvider
            .state('main-default.login', {
                url: '/login',
                views: {
                    content: {
                        templateUrl: 'scripts/components/login/login.tmpl.html',
                        controller: 'loginController',
                        controllerAs:'vm'
                    }
                }
            });
    }

})();
