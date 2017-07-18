(function () {
    'use strict';

    angular.module('carModule')
        .controller('chartController', chartController);

    chartController.$inject = ['chartService', '$routeParams'];

    function chartController(chartService, $routeParams) {
        var chartVm = this;

        ( function init() {

            chartVm.showChart = false;
            chartVm.showError = false;
            chartService
                .getByVin($routeParams.vin)
                .then(function (readings) {

                    var xData = [],

                        yData = [{"name": "Fuel Volume", "data": []},
                            {"name": "Speed", "data": []},
                            {"name": "EngineRpm", "data": []},
                            {"name": "EngineHP", "data": []}];
                    setData(readings, xData, yData);
                    function setData(readings, xData, yData) {

                        angular.forEach(readings, function (reading) {
                            xData.push(new Date(reading.timestamp));
                            yData[0].data.push(reading.fuelVolume);
                            yData[1].data.push(reading.speed);
                            yData[2].data.push(reading.engineRpm);
                            yData[3].data.push(reading.engineHp);
                        });

                        chartVm.lineChartYData = yData;
                        chartVm.lineChartXData = xData;

                        if (xData.length > 0 && yData.length >0) {
                            chartVm.showChart = true;

                        }
                    }
                }, function (error) {
                    console.log(error);
                });
        })();


    }
})();


(function () {
    'use strict';

    angular.module('carModule')
        .controller('chartTimeController', chartTimeController);

    chartTimeController.$inject = ['chartService', '$routeParams'];

    function chartTimeController(chartService, $routeParams) {
        var chartVm = this;

        ( function init() {

            chartVm.showChart = false;
            chartVm.showError = false;
             chartService
                .getByTime($routeParams.vin,$routeParams.from, $routeParams.to)
                .then(function (readings) {

                    var xData = [],

                        yData = [{"name": "Fuel Volume", "data": []},
                            {"name": "Speed", "data": []},
                            {"name": "EngineRpm", "data": []},
                            {"name": "EngineHP", "data": []}];
                    setData(readings, xData, yData);
                    function setData(readings, xData, yData) {

                        angular.forEach(readings, function (reading) {
                            xData.push(new Date(reading.timestamp));
                            yData[0].data.push(reading.fuelVolume);
                            yData[1].data.push(reading.speed);
                            yData[2].data.push(reading.engineRpm);
                            yData[3].data.push(reading.engineHp);
                        });

                        chartVm.lineChartYData = yData;
                        chartVm.lineChartXData = xData;

                        if (xData.length > 0 && yData.length >0) {
                            chartVm.showChart = true;

                        }
                    }
                }, function (error) {
                    console.log(error);
                });
        })();


    }
})();