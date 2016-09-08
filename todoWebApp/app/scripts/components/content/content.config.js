// Home component configuration
(function() {
    'use strict';
    angular
        .module('todo.components.content')
        .config(contentConfig);

    function contentConfig($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise('/');

        $stateProvider
            .state('main-default.home', {
                url: '/',
                views: {
                    header: {
                        templateUrl: 'scripts/components/_common/header/header.tmpl.html',
                        controller: 'headerController',
                        controllerAs:'vm'
                    },
                    content: {
                        templateUrl: 'scripts/components/content/content.tmpl.html',
                        controller: 'contentController',
                        controllerAs:'vm'
                    }
                }
            });
    }

})();
