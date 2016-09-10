// Home component controller
(function() {
    'use strict';
    angular
        .module('todo.components.login')
        .controller('loginController', loginController);

    function loginController($scope,$rootScope,userservice) {
        var vm = this;

        $rootScope.$emit('updateHeader','user');
        
        vm.user = userservice.getUser();
        vm.sync = function (data,id) {
          // TODO: ADD SYNC LOGIC
        };


    }

})();
