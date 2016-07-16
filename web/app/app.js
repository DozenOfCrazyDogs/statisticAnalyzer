/**
 * Created by НОЗДОРМУ on 16.07.2016.
 */
(function(angular) {
    'use strict';
    angular.module('ngrepeatSelect', [])
        .controller('ExampleController', ['$scope', '$http', function($scope, $http) {
            $scope.data = {
                rows: null,
                columns: null,
                availableOptions: [
                    {id: '2', name: '2'},
                    {id: '3', name: '3'},
                    {id: '4', name: '4'}
                ],
            };
            
            $scope.dimensions=[
                {text: [1, 2, 3, 4]},
                {text: [2, 3, 4]},
                {text: [3, 4]},
                {text: [4]}
            ];
            
            $scope.submitMyForm=function(){
                
                //wrap matrix date to JSON
                var total=angular.element( document.querySelector( '.table' ) ).find('tr');
                var coll = {};
                for(var i=0; i < total.length; i++) {
                    var tr = total[i];
                    var tdColl = $(tr).find('td');
                    for(var y = 0; y < tdColl.length; y++ ){
                        var td = tdColl.eq(y);
                        var input = td.find('input');
                        if (input.length) {
                            coll["a"+i+y]=input.val();
                        } else {
                            coll["a"+i+y]=input.val();
                        }
                    }
                }

                /* post to server*/
                /*$http.post(url, data);*/
                var res = $http.post("/statisticAnalyzer_json", coll);
                res.success(function(data, status, headers, config) {
                    $scope.message = data;
                });
                res.error(function(data, status, headers, config) {
                    alert( "failure message: " + JSON.stringify({data: data}));
                });

                //parse incoming JSON message
                var keys = Object.keys($scope.message).sort();
                var last = keys[keys.length-1];
                var output = [];
                for (var i = 0; i < last.length; i += 1) {
                    output.push(last.charAt(i));
                }
                var final = [];
                for (var i=0; i<parseInt(output[1])+1;i++) {
                    var pref = [];
                    for (var j=0; j<parseInt(output[2])+1;j++){
                        pref.push($scope.message["a"+i+j]);
                    }
                    final.push(pref);
                }
                $scope.fromJSON=final;
            }
        }]);
})(window.angular);