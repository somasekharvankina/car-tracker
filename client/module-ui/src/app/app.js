(function() {
    'use strict';

    angular.module('carModule', ['ngRoute'])
        .config(moduleConfig);

     moduleConfig.$inject = ['$routeProvider'];

    function moduleConfig($routeProvider) {
        $routeProvider
            // .when('/',{
            //     templateUrl:'defaulttheme.html'
            // })
            .when('/vehicles', {
                templateUrl: 'app/views/vehicleList.html',
                controller: 'vehicleController',
                controllerAs: 'vehicleVm'
            })


            .when('/alerts',{
                templateUrl : 'app/views/alertList.html',
                controller : 'alertController',
                controllerAs:'alertVm'
            })

            .when('/alerts/:vin',{
                templateUrl : 'app/views/alertsByVin.html',
                controller : 'alertsByVin',
                controllerAs : 'alertVm'
            })

            .when('/readings',{
                templateUrl: 'app/views/readings.html',
                controller :'readingsController',
                controllerAs :'readingsVm'
            })

            .when('/readings/:vin',{
                templateUrl:'app/views/readingsbyVin.html',
                controller: 'readingsByVin',
                controllerAs:'readingsVm'
            })
            .when('/latestalerts',{

                templateUrl: 'app/views/latestAlerts.html',
                controller : 'latestAlertController',
                controllerAs : 'alertVm'
            })
            .when('/charts/:vin/:latest', {
                templateUrl: '/app/views/chart.html',
                controller: 'chartController',
                controllerAs: 'chartVm'
            })

            .when('/charts/:vin/:from/:to',{
                templateUrl:'/app/views/chart.html',
                controller:'chartTimeController',
                controllerAs:'chartVm'
            })

            .when('/maps/:vin',{
                templateUrl:'/app/views/maps.html',
                controller:'mapsController'
            })

            .otherwise({
                redirectTo: '/vehicles'
            });
    }

})();