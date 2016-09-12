(function() {
    angular.module('todo.components.admin')
        .config(adminConfig);

    function adminConfig($stateProvider, $urlRouterProvider) {
        $urlRouterProvider.otherwise('/');

        $stateProvider
            .state('main-default.admin', {
                url: '/admin',
                views: {
                    header: {
                        templateUrl: 'scripts/components/_common/header/header.tmpl.html',
                        controller: 'headerController',
                        controllerAs:'vm'
                    },
                    content: {
                        templateUrl: 'scripts/components/admin/admin.tmpl.html',
                        controller: 'adminController',
                        controllerAs: 'vm'
                    }
                }
            });
    }
})();
