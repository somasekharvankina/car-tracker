(function() {
    'use strict';
    angular.module('carModule')
        .controller('alertsByVin', alertsByVin);

    alertsByVin.$inject = ['alertService', '$routeParams','vehicleService'];

    function alertsByVin(alertService, $routeParams,vehicleService) {
        var alertVm = this;

        alertService.getAlertsByVin($routeParams.vin)
            .then(function (alerts){
                alertVm.alerts =alerts;
            }, function (error){
                console.log(error);
            });

        vehicleService.getByVin($routeParams.vin)
            .then(function (vehicles) {
                alertVm.vehicle = vehicles;
            },function (error) {
                console.log(error);
            });
    }

})();

(function(){
    'use strict';

    angular.module('carModule')
        .controller('latestAlertController',latestAlertController);
    latestAlertController.$inject = ['alertService'];

    function  latestAlertController(alertService) {

        var alertVm = this;

        alertService.getLatestAlerts()
            .then(function (alerts) {
                alertVm.alerts = alerts;
            },function (error) {
                console.log(error);
            })
    }

})();