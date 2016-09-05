(function() {
    'use strict';
    angular.module('todo', ['ui.router',
        'ngMaterial',
        'ngAnimate',
        'ngMdIcons'
        // 'todo.directives',
        // 'todo.modules',
        // 'todo.common'
    ])

    .config(mainConfig);

    function mainConfig($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise('/');

        $stateProvider
            .state('main-default', {
                url:"/",
                templateUrl: 'templates/home.html'
            });
    }


})();
