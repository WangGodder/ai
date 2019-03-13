(function (win) {
    new Vue({
        name: 'app',
        el: '#app',
        components: {
            DataShow,
        },
        data: function() {
            return {
                url: '../evaluateDetail/',
                columns: [],
                queryParams: {
                    industry: "",
                    region: "",
                    beginYear: 0,
                    endYear: 0,
                    beginQuarter: 0,
                    endQuarter: 0,
                    evaluateType: ""
                },
                showData: false,
            }
        },
        mounted() {
            let col = [];
            $.ajax({
                url: "../../data/evaluateDetailTableColumn/",
                type: 'post',
                dataType: 'json',
                success: function (data) {
                    let status = data.status;
                    if (status == 1) {
                        for (let i = 0; i < data.data.titles.length; i++) {
                            col.push({
                                title: data.data.titles[i],
                                field: data.data.fields[i]
                            })
                        }
                    } else {
                        sv2.warn('获取表格信息失败, 5xx')
                    }
                },
                error: function () {
                    sv2.warn("获取表格属性失败，4xx");
                }
            });
            this.columns = col;
        },
        methods: {
            query: function () {
                this.queryParams.industry = $('#industry').val();
                this.queryParams.region = $('#region').val();
                this.queryParams.beginYear = $('#beginYear').val();
                this.queryParams.beginQuarter = $('#beginQuarter').val();
                this.queryParams.endYear = $('#endYear').val();
                this.queryParams.endQuarter = $('#endQuarter').val();
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