/**
 * Created by somasekhar on 6/6/2017.
 */
(function() {
    'use strict';
    angular.module('carModule')
        .service('vehicleService', vehicleService);

    vehicleService.$inject = ['$q', '$http'];

    function vehicleService($q, $http) {
        var vehicleVm = this;

        vehicleVm.getVehicles = getVehicles;
        vehicleVm.getByVin = getByVin;

        function getVehicles() {
            return $http.get('http://localhost:8081/api/vehicles')
                .then(successFn, errorFn);
        }

        function getByVin(vin) {
            return $http.get('http://localhost:8081/api/vehicles/' + vin)
                .then(successFn, errorFn)
        }

        function successFn(response) {
            return response.data;
        }

        function errorFn(error) {
            return $q.reject(error);
        }
    }

})();