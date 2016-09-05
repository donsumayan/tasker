(function() {
    'use strict';
    angular
        .module('todo.components.common.sidebar')
        .config(sidebarConfig);

    function sidebarConfig($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise('/');

        $stateProvider
            .state('main-default.common.sidebar', {
                templateUrl: 'scripts/components/_common/header/header.tmpl.html',
                controller: 'headerController',
                controllerAs:'vm'
            });
    }

})();
