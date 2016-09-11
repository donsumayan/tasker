// Header module controller
(function() {
    'use strict';
    angular
        .module('todo.components.common.header')
        .controller('headerController', headerController);

    function headerController($scope, $rootScope, $cookies, $state, constants, globals) {
        var vm = this;
        vm.header = constants.APP_NAME;
        vm.user = $cookies.getObject('user');
        vm.selected = globals.getState;
        vm.subSelected = 'all';

        checkUser(vm.user);

        vm.setState = function(state) {
            vm.selected = state;
            globals.setState(state);
        };

        vm.loadTodo = function(mode) {
            vm.subSelected = mode;
            $rootScope.$emit('updateTodoList', mode);
        };

        vm.logout = function() {
            $cookies.remove('user');
            $state.go('main-default.login');
        };

        $rootScope.$on('updateHeader', function(evt, data) {
            vm.state = data;
        });
        $rootScope.$on('updateUser', function(evt, data) {
            vm.user = data;
        });

        function checkUser(user) {
            if (!user) {
                $state.go('main-default.login');
            }
        }

    }

})();
