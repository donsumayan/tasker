// Home component controller
(function() {
    'use strict';
    angular
        .module('todo.components.user')
        .controller('userController', userController);

    function userController($scope, $rootScope, $cookies, userservice) {
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


    }

})();
