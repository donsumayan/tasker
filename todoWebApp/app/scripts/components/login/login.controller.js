// Home component controller
(function() {
    'use strict';
    angular
        .module('todo.components.login')
        .controller('loginController', loginController);

    function loginController($http, $rootScope, $cookies, $state, userservice, globals) {
        $rootScope.$emit('updateHeader', 'user');
        var vm = this;
        vm.email = "vincent@gmail.com";
        vm.password = "12345";

        vm.registrationMode = false;

        vm.login = function() {
            var u = {};
            if (vm.email) {
                u.email = vm.email;
                if (vm.password) {
                    u.password = vm.password;
                    userservice.login(u).then(
                        function(data) {
                            $cookies.putObject('user', data);
                            var auth = "Basic " + btoa(u.email + ":" + u.password);
                            $cookies.put('Auth', auth);
                            $state.go('main-default.home');
                        }
                    );
                } else {
                    console.log('password field missing');
                }
            } else {
                console.log('username field missing');
            }
        };
        vm.register = function() {
            var u = {};
            u.firstName = vm.firstName;
            u.lastName = vm.lastName;
            u.email = vm.email;
            if (vm.password === vm.vpassword) {
                u.password = vm.password;
            }
            u.role = {};
            u.role.id = 2;
            u.role.name = "User";
            if (u.firstName && u.lastName && u.email && u.password && u.role.id && u.role.name) {
              userservice.createUser(u).then(
                  function(data) {
                      console.log('succesfully registered');
                  }
              );
            }
            else {
              console.log('something is missing');
            }

        };


    }

})();
