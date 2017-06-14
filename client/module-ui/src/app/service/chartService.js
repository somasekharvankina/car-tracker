(function() {
    'use strict';

    angular.module('carModule')
        .service('chartService', chartService);

    chartService.$inject = ['$http', '$q'];

    function chartService($http, $q) {

        var chartVm = this;

        chartVm.getByVin = getByVin;
        chartVm.getByTime = getByTime;
        chartVm.getLatest = getLatest;

        function getByVin(vin) {
            return $http.get('http://localhost:8081/api/readings/' + vin )
                .then(successFn, errorFn);
        }

        function getByTime(vin,from,to){
            return $http.get('http://localhost:8081/api/readings/' + vin + '/'+ from + '/'+ to)
                .then(successFn,errorFn);
        }

        function getLatest(vin,latest){
            return $http.get('http:localhost:8081/api/readings'+ vin + latest)
                .then(successFn,errorFn);
        }
        function successFn(response) {
            return response.data;
        }

        function errorFn(response) {
            return $q.reject('ERROR: ' + response.statusText);
        }
    }

})();