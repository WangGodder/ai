let ChartConfig = {
    name: "ChartConfig",
    methods: {
        create_chart1: function () {
            const formList = $('#form1').serializeArray();
            let param = {};
            $.each(formList, function () {
                param[this.name] = this.value;
                window.localStorage.setItem(this.name, String(this.value));
            })
            if (window.localStorage.getItem("beginYear") == null || window.localStorage.getItem("beginYear") == '' ||
                window.localStorage.getItem("endYear") == null || window.localStorage.getItem("endYear") == '') {
                sv2.warn("请填写年份");
                return;
            }
            window.open('/user/charts/');
        },
        create_chart2: function () {
            const formList = $('#form2').serializeArray();
            let param = {};
            $.each(formList, function () {
                param[this.name] = this.value;
                window.localStorage.setItem(this.name, String(this.value));
            })
            window.open('/user/charts/');
        }
    },




    template:
        " <div>\n" +
        "        <div class=\"center-block row\">\n" +
        "            <div class=\"center-block\"><h3>单指标时间序列展示</h3></div>\n" +
        "            <form id=\"form1\">\n" +
        "            <div class=\"row col-lg-10 col-md-10 col-sm-10 col-xs-10\">\n" +
        "                <div class=\"row col-lg-4 col-md-4 col-sm-4 col-xs-4\">\n" +
        "                    <label for=\"fieldSelect\" class=\"col-lg-3 col-md-3 col-sm-3 col-xs-3\">指标选择</label>\n" +
        "                    <div id=\"fieldSelect\" class=\"col-lg-9 col-md-9 col-sm-9 col-xs-9\">\n" +
        "                        <select id=\"field1\" name=\"figureShow\" class=\"form-control\">\n" +
        "                            <option value=\"figureAll\">总体指标</option>\n" +
        "                            <option value=\"figureSale\">销售指标</option>\n" +
        "                            <option value=\"figureTax\">纳税指标</option>\n" +
        "                            <option value=\"figureFinance\">融资指数</option>\n" +
        "                            <option value=\"figureValuation\">估值指数</option>\n" +
        "                            <option value=\"figureHr\">人力资源指数</option>\n" +
        "                            <option value=\"figureInnovate\">创新指数</option>\n" +
        "                            <option value=\"figureSalary\">薪酬指数</option>\n" +
        "                            <option value=\"figureLearn\">学习指数</option>\n" +
        "                            <option value=\"figureBrand\">品牌指数</option>\n" +
        "                        </select>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "                <div class=\"col-lg-4 col-md-4 col-sm-4 col-xs-4\" style=\"display: block;\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">起始年份</span>\n" +
        "                        <input id=\"beginYear1\" type=\"number\" name=\"beginYear\" class=\"form-control\">\n" +
        "                        <span class=\"input-group-addon\">年</span>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "                <div class=\"col-lg-4 col-md-4 col-sm-4 col-xs-4\" style=\"display: block;\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">截至年份</span>\n" +
        "                        <input id=\"endYear1\" type=\"number\" name=\"endYear\" class=\"form-control\">\n" +
        "                        <span class=\"input-group-addon\">年</span>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "                <div class=\"col-lg-6 col-md-6 col-sm-6 col-xs-6\" style=\"display: block;\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">所在行业</span>\n" +
        "                        <input id=\"industry1\" type=\"text\" name=\"industry\" class=\"form-control\">\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "                <div class=\"col-lg-6 col-md-6 col-sm-6 col-xs-6\" style=\"display: block;\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">所在地区</span>\n" +
        "                        <input id=\"region1\" type=\"text\" name=\"region\" class=\"form-control\">\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "            </div>\n" +
        "            <div class=\"col-lg-2 col-md-2 col-sm-2 col-xs-2\">\n" +
        "                <div class=\"row\">\n" +
        "                    <label for=\"typeSelect1\" class=\"col-lg-3 col-md-3 col-sm-3 col-xs-3\">评估方式</label>\n" +
        "                    <div id=\"typeSelect1\" class=\"col-lg-9 col-md-9 col-sm-9 col-xs-9\">\n" +
        "                        <select id=\"evaluateType1\" name=\"evaluateType\" class=\"form-control\">\n" +
        "                            <option value=\"avg\">均值</option>\n" +
        "                            <option value=\"max\">最大值</option>\n" +
        "                            <option value=\"min\">最小值</option>\n" +
        "                            <option value=\"firstQ\">第一四分位</option>\n" +
        "                            <option value=\"median\">中位数</option>\n" +
        "                            <option value=\"thirdQ\">第三四分位</option>\n" +
        "                        </select>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "                <div id=\"chart-btn1\"  v-on:click=\"create_chart1()\" class=\"btn btn-lg btn-success btn-block\">生成图表</div>\n" +
        "            </div>\n" +
        "            </form>\n" +
        "        </div>\n" +
        "        <div class=\"center-block row\">\n" +
        "            <div class=\"center-block\"><h3>多指标多公司横向对比</h3></div>\n" +
        "            <form id=\"form2\" method=\"post\">\n" +
        "            <div class=\"row col-lg-10 col-md-10 col-sm-10 col-xs-10\">\n" +
        "                <div class=\"col-lg-3 col-md-3 col-sm-3 col-xs-3\" style=\"display: block;\">\n" +
        "                <div class=\"input-group input-group-lg\">\n" +
        "                    <span class=\"input-group-addon\">起始年份</span>\n" +
        "                    <input id=\"beginYear2\" type=\"number\" name=\"beginYear\" class=\"form-control\">\n" +
        "                    <span class=\"input-group-addon\">年</span>\n" +
        "                </div>\n" +
        "            </div>\n" +
        "                <div class=\"col-lg-3 col-md-3 col-sm-3 col-xs-3\" style=\"display: block;\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">截至年份</span>\n" +
        "                        <input id=\"endYear2\" type=\"number\" name=\"endYear\" class=\"form-control\">\n" +
        "                        <span class=\"input-group-addon\">年</span>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "                <div class=\"col-lg-3 col-md-3 col-sm-3 col-xs-3\" style=\"display: block;\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">起始季度</span>\n" +
        "                        <input id=\"beginQuarter2\" type=\"number\" name=\"beginQuater\" class=\"form-control\">\n" +
        "                        <span class=\"input-group-addon\">年</span>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "                <div class=\"col-lg-3 col-md-3 col-sm-3 col-xs-3\" style=\"display: block;\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">截至季度</span>\n" +
        "                        <input id=\"endQuarter2\" type=\"number\" name=\"endQuarter\" class=\"form-control\">\n" +
        "                        <span class=\"input-group-addon\">年</span>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "                <div class=\"col-lg-6 col-md-6 col-sm-6 col-xs-6\" style=\"display: block;\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">所在行业</span>\n" +
        "                        <input id=\"industry2\" type=\"text\" name=\"industry\" class=\"form-control\">\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "                <div class=\"col-lg-6 col-md-6 col-sm-6 col-xs-6\" style=\"display: block;\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">所在地区</span>\n" +
        "                        <input id=\"region2\" type=\"text\" name=\"region\" class=\"form-control\">\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "            </div>\n" +
        "            <div class=\"col-lg-2 col-md-2 col-sm-2 col-xs-2\">\n" +
        "                <div class=\"row\">\n" +
        "                    <label for=\"typeSelect2\" class=\"col-lg-3 col-md-3 col-sm-3 col-xs-3\">评估方式</label>\n" +
        "                    <div id=\"typeSelect2\" class=\"col-lg-9 col-md-9 col-sm-9 col-xs-9\">\n" +
        "                        <select id=\"evaluateType2\" name=\"evaluateType\" class=\"form-control\">\n" +
        "                            <option value=\"avg\">均值</option>\n" +
        "                            <option value=\"max\">最大值</option>\n" +
        "                            <option value=\"min\">最小值</option>\n" +
        "                            <option value=\"firstQ\">第一四分位</option>\n" +
        "                            <option value=\"median\">中位数</option>\n" +
        "                            <option value=\"thirdQ\">第三四分位</option>\n" +
        "                        </select>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "                <div v-on:click=\"create_chart2()\" class=\"btn btn-lg btn-success btn-block\">生成图表</div>\n" +
        "            </div>\n" +
        "            </form>\n" +
        "        </div>\n" +
        "    </div>"
};