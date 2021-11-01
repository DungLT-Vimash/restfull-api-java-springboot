var app = angular.module("EmployeeManagement",[]);

// Controller Part
app.controller("EmployeeController",function($scope,$http){
	$scope.employees = [];
	$scope.employeeForm = {
		empId: 1,
		empNo: "",
		empName: ""
	};
	
	//now load the data from server
	_refreshEmployeeData();
	
	//HTTP POST/PUT method for add/edit employee
	//call http://localhost:8080/rest/employees
	$scope.submitEmployee = function(){
		var method = "";
		var url = "";
		
		if($scope.employeeForm.empId == -1){
			method = "POST";
			url = '/rest/employees';
		}else {
			method = "PUT";
			url = '/rest/employees';
		}
		
		$http({
			method: method,
			url: url,
			data: angular.toJson($scope.employeeForm),
			headers: {
				'Content-Type': 'application/json'
			}
		}).then( _success, _error);
	};
	$scope.createEmployee = function() {
		_clearFormData();
	}
	// HTTP DELETE- delete employee by Id
	// Call: http://localhost:8080/rest/employee/{empId}
	$scope.deleteEmployee = function(employee) {
		$http({
			method: 'DELETE',
			url: '/rest/employees/' + employee.empId,
		}).then(_success,_success);
	};
	//In case of edit
	$scope.editEmployee = function(employee) {
		$scope.employeeForm.empId = employee.empId;
		$scope.employeeForm.empNo = employee.empNo;
		$scope.employeeForm.empName = employee.empName;
	};
	//Private Method
	// HTTP GET- get all employees collection
	// Call: http://localhost:8080/rest/employees
	function _refreshEmployeeData(){
		$http({
			method: 'GET',
			url: '/rest/employees'
		}).then(
			function(res){//success
				$scope.employees = res.data;
				console.log($scope.employees);
			},
			function(res) {//error
				console.log("Error: " + res.status + " : " + res.data);
			}
		);
				
	};
	function _success(res) {
		_refreshEmployeeData();
		_clearFormData();
		
	};
	function _error(res){
		var data = res.data;
		var status = res.status;
		var header = res.header;
		var config = res.config;
		alert("Error: " + status + ":" + data);
		console.log(res);
	};
	//clear the form
	function _clearFormData(){
		$scope.employeeForm.empId = -1;
		$scope.employeeForm.empNo = "";
		$scope.employeeForm.empName = "";
	}
	
});