(function() {
    'use strict';
    angular.module('carModule')
        .controller('vehicleController', vehicleController);

    vehicleController.$inject = ['$scope','vehicleService','$location'];

    function vehicleController($scope,vehicleService,$location) {

        var vehicleVm = this;

        vehicleService.getVehicles()
            .then(function(vehicles){
                vehicleVm.vehicles = vehicles;
            }, function (error){
                console.log(error);
            });

        $scope.goClick = function(vin) {
            $location.url('/readings/'+ vin);
        };
    }
})();