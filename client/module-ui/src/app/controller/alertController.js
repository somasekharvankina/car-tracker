(function(){
    'use strict';
    angular.module('carModule')
        .controller('alertController',alertController);

    alertController.$inject = ['alertService','$location','$scope'];

    function alertController(alertService,$location,$scope) {

        var alertVm = this;

        alertService.getAlerts()
            .then(function (alerts) {
                alertVm.alerts = alerts;
            }, function (error) {
                console.log(error);
            });

        $scope.alertsByVin = function () {
            $location.url('/alerts/'+ alertVm.searchByVin);
        }
    }
})();


