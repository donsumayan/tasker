// Home component controller
(function() {
    'use strict';
    angular
        .module('todo.components.user')
        .controller('userController', userController);

    function userController($scope, $rootScope,$state,$cookies, userservice) {
        $rootScope.$emit('updateHeader', 'user');
        var vm = this;
        var user = $cookies.getObject('user');
        vm.user = user;

        vm.sync = function(data) {
            data.id = user.id;

            userservice.updateUser(data).then(
                function(data) {
                    vm.user = data;
                    $cookies.putObject('user', data);
                    $rootScope.$emit('updateUser', data);
                }
            );
            console.log(data);
        };
        vm.deleteAccount = function() {
            userservice.deleteUser(user.id).then(
                function() {
                    if (data.status===200) {
                        $cookies.removeObject('user');
                        $state.go('main-default.login');
                    }                   
                }   
            );
        };


    }

})();
