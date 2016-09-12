// Home component controller
(function() {
    'use strict';
    angular
        .module('todo.components.login')
        .controller('loginController', loginController);

    function loginController($http, $rootScope, $cookies, $state, userservice, globals) {
        $rootScope.$emit('updateHeader', 'user');
        var vm = this;

        vm.registrationMode = false;

        vm.login = function() {

            var u = {};

            vm.message = "logging in";
            if (vm.email) {
                u.email = vm.email;
                if (vm.password) {
                    u.password = vm.password;
                    vm.processing = true;
                    userservice.login(u).then(
                        function(data) {
                            $cookies.putObject('user', data);
                            var auth = "Basic " + btoa(u.email + ":" + u.password);
                            $cookies.put('Auth', auth);
                            $state.go('main-default.home');
                            vm.processing = false;
                        }
                    ).catch(
                      function () {
                        vm.errors = 'email/password is incorrect';
                      }
                    );
                } else {
                    vm.processing = false;
                    vm.errors = 'password is missing';
                }
            } else {
                vm.processing = false;
                vm.errors = 'email is invalid';
            }
        };
        vm.register = function() {
            vm.processing = true;
            vm.message = "creating user account";
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
                        vm.processing = false;
                    }
                ).catch(
                  function () {
                    vm.errors = 'please try again';
                  }
                )

            } else {
              vm.errors = 'please complete the form';
            }

        };

        vm.hideLoader = function(message) {
            vm.message = message;
            vm.processing = false;
        };


    }

})();
