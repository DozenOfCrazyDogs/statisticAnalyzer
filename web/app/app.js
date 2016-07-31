'use strict';
    angular.module('ngApp', ['ngAnimate'])
        .controller('MatrixCtrl', ['$scope', '$http', function($scope, $http) {

            console.log("init App JS");

            // DEFAULTS INIT AND GLOBAL VARIABLES
            let matrixMaxLength = 5; // Max matrix 5x5
            let matrixMinLength = 2; // Min matrix 2x2

            $scope.options = [];
            $scope.matrix = {};
            $scope.rows = `${matrixMinLength}`;
            $scope.columns = `${matrixMinLength}`;
            $scope.showBlock = true;
            let rows = [];
            let columns = [];

            for (let k = matrixMinLength; k <= matrixMaxLength; k++) {
                $scope.options.push({
                    select: `${k}`,
                    value: `${k}`
                });
            }

            // Init function

            onInit();

            function onInit() {
                select($scope.rows, $scope.columns);
                checkTitle();
            }

            // SELECT FUNCTION

            $scope.select = function() {
                select($scope.rows, $scope.columns);
            };

            function select(rowsValue, columnsValue, callback) {
                rows=[];
                columns=[];

                for (let i = 0; i < parseInt(rowsValue); i++) {
                    rows[i] = {
                        index: `${i}`,
                        value: ""
                    };
                    for (let j = 0; j < parseInt(columnsValue); j++) {
                        columns[j] = {
                            index: `${j}`,
                            value: ""
                        };
                    }
                }
                $scope.rowsMatrix = rows;
                $scope.columnsMatrix = columns;

                if (callback !== undefined && callback != "") callback();
            }

            // SEND POST REQUEST FUNCTION

            function sendData(data){
                $http({
                    method: 'POST',
                    url: 'http://77.90.246.249:8082/Deploy/normalize',
                    data: data
                }).then(function successCallback(response) {
                    $scope.showBlock = false;
                    checkTitle();
                    $scope.data = recieveData(response.data);
                }, function errorCallback(response) {
                    console.log( "failure message: " + JSON.stringify({data: response}));
                });
            }

            // SUBMIT BUTTON FUNCTION

            $scope.submit = function() {
                if ($scope.showBlock){
                    var input = document.getElementsByClassName('js-f-input');

                    var data = {};
                    var i = 0;
                    for (var j = 0; j < $scope.rows; j++) {
                        for (var k = 0; k < $scope.columns; k++) {
                            data["a"+j+k] = input[i++].value;
                        }
                    }
                    sendData(data);
                }else{
                    backButton();
                }
            };

            // BACK BUTTON FUNCTION

            function backButton(){
                $scope.showBlock = true;
                checkTitle();
                select($scope.rows, $scope.columns)
            }

            // PARSE JSON OBJECT AND PRINT INTO TABLE

            function recieveData(data){
                var sortByKey = Object.keys(data).sort();
                var lastKey = sortByKey[sortByKey.length - 1];
                var output = [];
                for (var i = 0; i < lastKey.length; i += 1) {
                    output.push(lastKey.charAt(i));
                }
                var finalArray = [];
                for (var i = 0; i < parseInt(output[1]) + 1; i++) {
                    var rowArray = [];
                    for (var j = 0; j < parseInt(output[2]) + 1; j++) {
                        rowArray.push(data["a" + i + j]);
                    }
                    finalArray.push(rowArray);
                }
                return finalArray;
            }

            // Function for title and text button

            function checkTitle(){
               var title = document.getElementsByClassName('js-title');
               var btn_text = document.getElementsByClassName('js-t-btn');
               if($scope.showBlock){
                   title[0].innerHTML = 'Normalize Matrix';
                   btn_text[0].innerHTML = 'Resolve';
               }else{
                   title[0].innerHTML = 'The answer is:';
                   btn_text[0].innerHTML = 'Again!';
               }
            }
        }]);




