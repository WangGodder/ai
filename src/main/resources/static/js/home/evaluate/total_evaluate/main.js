(function (win) {
    new Vue({
        name: 'app',
        el: '#app',
        components: {
            DataShow,
        },
        data: function() {
            return {
                url: '../evaluateTotal/',
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
                this.columns = [];
                this.queryParams.industry = $('#industry').val();
                this.queryParams.region = $('#region').val();
                this.queryParams.beginYear = $('#beginYear').val();
                this.queryParams.endYear = $('#endYear').val();
                this.queryParams.evaluateType = $('#evaluateType').val();
                console.log(this.queryParams);
                if (this.queryParams.beginYear == null || this.queryParams.beginYear == ''){
                    sv2.warn("请选择起始年份");
                    return;
                }
                if (this.queryParams.endYear == null || this.queryParams.endYear == '') {
                    sv2.warn("请选择截至年份")
                    return;
                }
                this.showData = false;
                this.$nextTick(() => {
                    this.showData = true;
                })
                let headCol = [{
                    field: 'companyName',
                    title: '公司名称 ',
                    rowspan: 2,
                    align: 'center'
                }, {
                    field: 'industry',
                    title: '所在行业',
                    rowspan: 2,
                    align: 'center'
                }, {
                    field: 'region',
                    title: '所在地区',
                    rowspan: 2,
                    align: 'center'
                }];
                contentCol = [];
                for (let i = 0; i < Math.max(parseInt(this.queryParams.endYear) - parseInt(this.queryParams.beginYear) + 1, 0); i++) {
                    headCol.push({
                        title: parseInt(this.queryParams.beginYear) + i + "",
                        colspan: 10,
                        align: 'center'
                    })
                    contentCol.push({
                        field: 'figureAll' + i,
                        title: '综合指标'
                    }, {
                        field: 'figureSale' + i,
                        title: '销售指标'
                    }, {
                        field: 'figureTax' + i,
                        title: '税收指数'
                    }, {
                        field: 'figureFinance' + i,
                        title: '融资指数'
                    }, {
                        field: 'figureValuation' + i,
                        title: '估值指数'
                    }, {
                        field: 'figureHr' + i,
                        title: '人力资源指数'
                    }, {
                        field: 'figureInnovate' + i,
                        title: '创新指数'
                    }, {
                        field: 'figureSalary' + i,
                        title: '薪酬指数'
                    }, {
                        field: 'figureLearn' + i,
                        title: '学习指数'
                    }, {
                        field: 'figureBrand' + i,
                        title: '品牌指数'
                    })
                }
                this.columns.push(headCol, contentCol);
            }
        }
    })
})(window || {})