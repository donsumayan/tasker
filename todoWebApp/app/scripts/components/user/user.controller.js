// Home component controller
(function() {
    'use strict';
    angular
        .module('todo.components.user')
        .controller('userController', userController);

    function userController($scope,$rootScope,userservice) {
        var vm = this;

        $rootScope.$emit('updateHeader','user');

        vm.user = userservice.getUser();
        vm.sync = function (data,id) {
          // TODO: ADD SYNC LOGIC
        };


    }

})();
