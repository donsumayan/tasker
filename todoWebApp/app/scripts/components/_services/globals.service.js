// User Services
(function() {
    'use strict';
    angular
        .module('todo.components.services')
        .factory('globals', globalsservice);


    function globalsservice(userservice) {
        var state;
        var todoMode;
        var user;
        return {
            getUser: getUser,
            setUser: setUser,
            getTodoMode: todoMode,
            setTodoMode: setTodoMode,
            getState: !state? 'home':state,
            setState: setState
        };

        function setState(newState) {
          tate=newState;
        }
        function setTodoMode(newMode) {
          todoMode=newMode;
        }
        function getUser() {
          return user;
        }
        function setUser(newUser) {
          console.log(newUser);
          user=newUser;
          console.log(user);
        }
    }

})();
