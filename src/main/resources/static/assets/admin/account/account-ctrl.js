app.controller("account-ctrl", function ($scope, $http, $location) {

	$scope.accounts = [];
	$scope.form = {};

	$scope.initialize = function () {
		//load all account
		$http.get("/rest/accounts").then(resp => {
			$scope.accounts = resp.data
		})


	}

	//Xóa form
	$scope.reset = function () {
		$scope.form = {
			username: '',
			fullname: '',
			password: '',
			email: '',
			photo: ''
		}
		// document.getElementById("id").disabled = false;
		// document.getElementById("update").disabled = true;
		// document.getElementById("delete").disabled = true;
		// document.getElementById("create").disabled = false;
	}
	//Hiện thị lên form
	$scope.edit = function (item) {
		$scope.form = angular.copy(item);
		$(".nav-tabs a:eq(0)").tab('show');
		document.getElementById("id").disabled = true;
		document.getElementById("update").disabled = false;
		document.getElementById("create").disabled = true;
		document.getElementById("delete").disabled = false;
	}
	//Thêm mới sản phẩm
	$scope.create = function () {
		var item = angular.copy($scope.form);
		$http.post('/rest/accounts', item).then(resp => {
			$scope.accounts.push(resp.data);
			$scope.reset();
			alert("Thêm mới tài khoản thành công");
			$(".nav-tabs a:eq(1)").tab('show');
		}).catch(error => {
			alert("Lỗi thêm mới tài khoản")
			console.log("Error", error);
		})
	}
	//Cập nhật sản phẩm
	$scope.update = function () {
		var item = angular.copy($scope.form);
		$http.put(`/rest/accounts/${item.id}`, item).then(resp => {
			var index = $scope.accounts.findIndex(p => p.id == item.id);
			$scope.accounts[index] = item;
			alert("Cập nhật tài khoản thành công");
			$(".nav-tabs a:eq(1)").tab('show');
		}).catch(error => {
			alert("Lỗi cập nhật tài khoản")
			console.log("Error", error);
		})
	}
	//Xóa sản phẩm 
	$scope.delete = function (item) {
		var item = angular.copy($scope.form);
		$http.delete(`/rest/accounts/${item.id}`).then(resp => {
			var index = $scope.accounts.findIndex(p => p.id == item.id);
			$scope.accounts.splice(index, 1);
			$scope.reset();
			alert("Xóa tài khoản thành công");
			$(".nav-tabs a:eq(1)").tab('show');
		}).catch(error => {
			alert("Xóa tài khoản lỗi")
			console.log("Error", error);
		})
	}
	//Upload hình 
	$scope.imageChanged = function (files) {
		var data = new FormData();
		data.append('file', files[0]);
		$http.post('/rest/upload/images', data, {
			transformRequest: angular.identity,
			headers: { 'Content-Type': undefined }
		}).then(resp => {
			$scope.form.photo = resp.data.name;
		}).catch(error => {
			alert("Lỗi upload hình ảnh")
			console.log("Error", error)
		})
	}

	$scope.pager = {
		page: 0,
		size: 10,
		get accounts() {
			var start = this.page * this.size;
			return $scope.accounts.slice(start, start + this.size);
		},
		get count() {
			return Math.ceil(1.0 * $scope.accounts.length / this.size);
		},
		first() {
			this.page = 0;
		},
		prev() {
			this.page--;
			if (this.page < 0) {
				this.last();
			}
		},
		next() {
			this.page++;
			if (this.page >= this.count) {
				this.first();
			}
		},
		last() {
			this.page = this.count - 1;
		}
	}

	$scope.initialize();
})