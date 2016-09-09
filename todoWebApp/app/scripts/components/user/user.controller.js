// Home component controller
(function() {
    'use strict';
    angular
        .module('todo.components.user')
        .controller('userController', userController);

    function userController($scope,userservice) {
        var vm = this;

        vm.user = userservice.getUser()
        

    }

})();
