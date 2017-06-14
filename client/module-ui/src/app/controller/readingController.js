(function(){
    'use strict';
    angular.module('carModule')
        .controller('readingsController',readingsController);

    readingsController.$inject = ['readingsService'];

    function readingsController(readingsService){

        var readingsVm = this;

        readingsService.getall()
            .then(function(readings){
                readingsVm.readings = readings;
            }, function (error){
                console.log(error);
            })
    }

})();


(function(){
    'use strict';
    angular.module('carModule')
        .controller('readingsByVin',readingsByVin);

    readingsByVin.$inject = ['$scope','readingsService','$routeParams','$location'];

    function readingsByVin($scope,readingsService,$routeParams,$location) {
        var readingsVm = this;

        readingsService.getByVin($routeParams.vin)
            .then(function(readings) {
                readingsVm.readings = readings;
            },function (error) {
                console.log(error);
            });

        readingsVm.vinValue = $routeParams.vin;


       $scope.timeRange=  function () {
           var from = new Date(readingsVm.fromDate);
           var to = new Date(readingsVm.toDate);
           if(from == 0 || to == NaN || from == NaN || to==0){
               $location.url('/vehicles');
           }
           else{
               $location.url('/charts/' +$routeParams.vin +'/'+ from.getTime() + '/'+ to.getTime());
           }

        }
    }
})();