/**
 * Created by НОЗДОРМУ on 16.07.2016.
 */
(function(angular) {
    'use strict';
    angular.module('ngIndexApp', ['ngAnimate'])
        .controller('ExampleController', ['$scope', '$http', function($scope, $http) {
            
            // DEFAULTS INIT AND GLOBAL VARIABLES
            $scope.data = {
                availableOptions: [
                    {id: '2', name: '2'},
                    {id: '3', name: '3'},
                    {id: '4', name: '4'},
                    {id: '5', name: '5'}
                ]
            };
            $scope.a={};
            for(var i = 0; i<5; i++){
                for(var j = 0; j<5;j++){
                    $scope.a[""+i+j]="";
                }
            }
            $scope.showRow = [true, false, false];
            $scope.showCol = [true, false, false];
            $scope.rows = "3";
            $scope.columns = "3";
            $scope.showBlocks = true;
            $scope.myStyleColumns = [];
            
            // SELECT FUNCTION
            $scope.displayMatrix = function() {
                switch ($scope.rows) {
                    case "2":
                        $scope.showRow[0] = false;
                        $scope.showRow[1] = false;
                        $scope.showRow[2] = false;
                        $scope.myStyleRows = "90px";
                        break;
                    case "3":
                        $scope.showRow[0] = true;
                        $scope.showRow[1] = false;
                        $scope.showRow[2] = false;
                        $scope.myStyleRows = "60px";
                        break;
                    case "4":
                        $scope.showRow[0] = true;
                        $scope.showRow[1] = true;
                        $scope.showRow[2] = false;
                        $scope.myStyleRows = "45px";
                        break;
                    case "5":
                        $scope.showRow[0] = true;
                        $scope.showRow[1] = true;
                        $scope.showRow[2] = true;
                        $scope.myStyleRows = "36px";
                }
                switch ($scope.columns){
                    case "2":
                        $scope.showCol[0]=false;
                        $scope.showCol[1]=false;
                        $scope.showCol[2]=false;
                        $scope.myStyleColumns[0] = "213px";
                        $scope.myStyleColumns[1] = "45px";
                        break;
                    case "3":
                        $scope.showCol[0]=true;
                        $scope.showCol[1]=false;
                        $scope.showCol[2]=false;
                        $scope.myStyleColumns[0] = "142px";
                        $scope.myStyleColumns[1] = "40px";
                        break;
                    case "4":
                        $scope.showCol[0]=true;
                        $scope.showCol[1]=true;
                        $scope.showCol[2]=false;
                        $scope.myStyleColumns[0] = "106px";
                        $scope.myStyleColumns[1] = "35px";
                        break;
                    case "5":
                        $scope.showCol[0]=true;
                        $scope.showCol[1]=true;
                        $scope.showCol[2]=true;
                        $scope.myStyleColumns[0] = "84px";
                        $scope.myStyleColumns[1] = "30px";
                }
                $scope.myStyle = {
                    width : $scope.myStyleColumns[0],
                    'font-size' : $scope.myStyleColumns[1]
                    //height : $scope.myStyleRows
                };
            };

            // ### START OF POST BLOCK
            // CHECK FOR NUMERICAL VALUES AND BUILD JSON OF NUMBERS
            var collectInfo = function(){
                var matrixJSON = {};
                var trigger = true;
                for (var i=0; i < $scope.rows; i++){
                    for (var j=0; j<$scope.columns;j++){
                        var check = Number($scope.a[""+i+j]);
                        if (isNaN(check) || $scope.a[""+i+j]==""){
                            trigger = false;
                        } else {
                            matrixJSON["a" + i + j] = $scope.a[""+i+j];
                        }
                    }
                }
                if (trigger) {
                    return matrixJSON;
                } else {return trigger}
            };

            // SEND POST REQUEST FUNCTION
            var sendJSON = function(matrixJSON){
                var res = $http.post("/normalize", matrixJSON);
                res.success(function(data, status, headers, config){ 
                    $scope.showBlocks = false;
                    return data;
                });
                res.error(function(data, status, headers, config) {
                    alert( "failure message: " + JSON.stringify({data: data}));
                });
            };
            
            // PARSE JSON OBJECT AND PRINT INTO TABLE
            var parseJSON = function(receivedJSON){
                var sortByKey = Object.keys(receivedJSON).sort();
                var lastKey = sortByKey[sortByKey.length - 1];
                var output = [];
                for (var i = 0; i < lastKey.length; i += 1) {
                    output.push(lastKey.charAt(i));
                }
                var finalArray = [];
                for (var i = 0; i < parseInt(output[1]) + 1; i++) {
                    var rowArray = [];
                    for (var j = 0; j < parseInt(output[2]) + 1; j++) {
                        rowArray.push(receivedJSON["a" + i + j]);
                    }
                    finalArray.push(rowArray);
                }
                return finalArray;
            };
            
            // SUBMIT BUTTON FUNCTION
            $scope.newSubmit = function() {
                var objectMatrix = collectInfo();
                if (objectMatrix == false) {
                    alert("Please enter numerical values!");
                } else {
                    var sendData = {};
                    sendData["matrix"] = parseJSON(objectMatrix);
                    var message = sendJSON(sendData);
                    //$scope.fromJSON = parseJSON(sendData); // change sendData -> message and uncomment line above
                    $scope.fromJSON = message;
                    //$scope.showBlocks = false; // remove this
                }
            };
            // ### END OF SUBMIT BLOCK

            // BACK BUTTON FUNCTION
            $scope.backButton = function(){
                $scope.showBlocks=true;
                for (var i=0; i < 5; i++){
                    for (var j=0; j<5;j++){
                        $scope.a[""+i+j] = "";
                    }
                }
            };

        }]);
})(window.angular);