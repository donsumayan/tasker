(function() {
    'use strict';
    angular
        .module('todo.components.home')
        .config(homeConfig);

    function homeConfig($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise('/');

        $stateProvider
            .state('main-default.home', {
                url: '/',
                views: {
                    sidebar: {
                        templateUrl: 'scripts/components/_common/sidebar/sidebar.tmpl.html',
                        controller: 'sidebarController',
                        controllerAs:'vm'
                    },
                    header: {
                        templateUrl: 'scripts/components/_common/header/header.tmpl.html',
                        controller: 'headerController',
                        controllerAs:'vm'
                    },
                    content: {
                        templateUrl: 'scripts/components/home/home.tmpl.html',
                        controller: 'homeController',
                        controllerAs:'vm'
                    }
                }
            });
    }

})();
