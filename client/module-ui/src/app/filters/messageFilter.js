(function() {
    'use strict';
    angular.module('carModule')
        .filter('messageFilter', messageFilter);

    function messageFilter() {
        var current = new Date();
        console.log(current);
        return function (message) {
            var k = message;
            return k;
        }

        };

})();