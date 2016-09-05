(function() {
    'use strict';
    angular
        .module('todo.components.common.header')
        .config(headerConfig);

    function headerConfig($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise('/');

        $stateProvider
            .state('main-default.common.header', {
                templateUrl: 'scripts/components/_common/header/header.tmpl.html',
                controller: 'headerController',
                controllerAs:'vm'
            });
    }

})();
