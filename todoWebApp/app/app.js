// Main App module
(function() {
    'use strict';
    angular.module('todo', ['ui.router',
        'ngCookies',
        'ngMaterial',
        'ngAnimate',
        'xeditable',
        'todo.components'
    ]);
})();
