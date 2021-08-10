app.controller("order-ctrl", function ($scope, $http) {
    $scope.order = [];
    // $scope.cates = [];
    $scope.form = {};

    $scope.initialize = function () {
        //load order
        $http.get("/rest/orders").then(resp => {
            $scope.order = resp.data;
        })
    }
    //khởi đầu
    $scope.initialize();

    $scope.detail = function () {
        alert("đang phát triển. Hãy đăng nhập tài khoản người đặt để xem !");
    };

    $scope.pager = {
        page: 0,
        size: 10,
        get order() {
            var start = this.page * this.size;
            return $scope.order.slice(start, start + this.size);
        },
        get count() {
            return Math.ceil(1.0 * $scope.order.length / this.size);
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
})