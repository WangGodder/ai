(function (win) {
    new Vue({
        name: 'app',
        el: '#app',
        components: {
            DataShow,
        },
        data: function() {
            return {
                url: '',
                columns : [],
                queryParams: {
                    industry: "",
                    region: "",
                    beginYear: 0,
                    endYear: 0,
                    evaluateType: ""
                },
                showData: false,
            }
        },
        methods: {
            query: function () {
                this.queryParams.industry = $('#industry').val();
                this.queryParams.region = $('#region').val();
                this.queryParams.beginYear = $('#beginYear').val();
                this.queryParams.endYear = $('#endYear').val();
                this.queryParams.evaluateType = $('#evaluateType').val();
                console.log(this.queryParams);
                this.showData = false;
                this.$nextTick(() => {
                    this.showData = true;
                })
            }
        }
    })
})(window || {})