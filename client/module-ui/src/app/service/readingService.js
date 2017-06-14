/**
 * Created by somasekhar on 6/6/2017.
 */
(function(){
    angular.module('carModule')
        .service('readingsService',readingsService);

    readingsService.$inject = ['$q','$http'];

    function readingsService($q,$http){
        var readingsVm = this;

        readingsVm.getall = getall;
        readingsVm.getByVin = getByVin;

        function getall(){
            return $http.get('http://localhost:8081/api/readings')
                .then(success,errorFn);
        }

        function getByVin(vin){
            return $http.get('http://localhost:8081/api/readings/' + vin)
                .then(success,errorFn);
        }


        function success(response){
            return response.data;
        }

        function errorFn(error){
            return $q.reject(error);
        }

    }
})();