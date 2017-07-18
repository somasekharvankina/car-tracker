/**
 * Created by somasekhar on 6/7/2017.
 */
(function() {
    'use strict';
    angular.module('carModule')
        .service('alertService', alertService);

    alertService.$inject = ['$q', '$http'];

    function alertService($q, $http) {
        var alertVm = this;

        alertVm.getAlerts = getAlerts;
        alertVm.getAlertsByVin = getAlertsByVin;
        alertVm.getLatestAlerts = getLatestAlerts;

        function getAlerts() {
            return $http.get('http://localhost:8081/api/alerts')
                .then(successFn, errorFn);
        }

        function getAlertsByVin(vin) {
            return $http.get('http://localhost:8081/api/alerts/' + vin)
                .then(successFn, errorFn)
        }

        function getLatestAlerts(){
            return $http.get('http://localhost:8081/api/alerts/dummy/latest')
                .then(successFn,errorFn);
        }

        function successFn(response) {
            return response.data;
        }

        function errorFn(error) {
            return $q.reject(error);
        }
    }

})();