// Home component configuration
(function() {
    'use strict';
    angular
        .module('todo.components.user')
        .config(userConfig);

    function userConfig($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise('/');

        $stateProvider
            .state('main-default.user', {
                url: '/user',
                views: {
                    header: {
                        templateUrl: 'scripts/components/_common/header/header.tmpl.html',
                        controller: 'headerController',
                        controllerAs:'vm'
                    },
                    content: {
                        templateUrl: 'scripts/components/user/user.tmpl.html',
                        controller: 'userController',
                        controllerAs:'vm'
                    }
                }
            });
    }

})();
