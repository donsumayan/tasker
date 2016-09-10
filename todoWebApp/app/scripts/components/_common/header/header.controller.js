// Header module controller
(function() {
    'use strict';
    angular
        .module('todo.components.common.header')
        .controller('headerController', headerController);

    function headerController($scope,$rootScope, $state, globals) {
        var vm = this;
        vm.header = "Tasker";
        vm.user = globals.getUser;
        vm.selected = globals.getState;
        vm.subSelected='all';

        vm.setState = function (state) {
          vm.selected=state;
          globals.setState(state);
        };
        vm.loadTodo = function (mode) {
          vm.subSelected = mode;
          $rootScope.$emit('updateTodoList',mode);
        };

        $rootScope.$on('updateHeader',function (evt,data) {
            vm.state=data;
        });

    }

})();
