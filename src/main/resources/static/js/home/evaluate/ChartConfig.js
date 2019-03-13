let ChartConfig = {
    name: "ChartConfig",





    template:
        "<div>\n" +
        "        <div class=\"center-block row\">\n" +
        "            <div class=\"center-block\"><h3>单指标时间序列展示</h3></div>\n" +
        "            <div class=\"row col-lg-10 col-md-10 col-sm-10 col-xs-10\">\n" +
        "                <div class=\"row col-lg-4 col-md-4 col-sm-4 col-xs-4\">\n" +
        "                    <label for=\"fieldSelect\" class=\"col-lg-3 col-md-3 col-sm-3 col-xs-3\">指标选择</label>\n" +
        "                    <div id=\"fieldSelect\" class=\"col-lg-9 col-md-9 col-sm-9 col-xs-9\">\n" +
        "                        <select id=\"field1\" class=\"form-control\">\n" +
        "                            <option value=\"0\">总体指标</option>\n" +
        "                        </select>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "                <div class=\"col-lg-4 col-md-4 col-sm-4 col-xs-4\" style=\"display: block;\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">起始年份</span>\n" +
        "                        <input id=\"beginYear1\" type=\"number\" class=\"form-control\">\n" +
        "                        <span class=\"input-group-addon\">年</span>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "                <div class=\"col-lg-4 col-md-4 col-sm-4 col-xs-4\" style=\"display: block;\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">截至年份</span>\n" +
        "                        <input id=\"endYear1\" type=\"number\" class=\"form-control\">\n" +
        "                        <span class=\"input-group-addon\">年</span>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "                <div class=\"col-lg-6 col-md-6 col-sm-6 col-xs-6\" style=\"display: block;\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">所在行业</span>\n" +
        "                        <input id=\"industry1\" type=\"text\" class=\"form-control\">\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "                <div class=\"col-lg-6 col-md-6 col-sm-6 col-xs-6\" style=\"display: block;\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">所在地区</span>\n" +
        "                        <input id=\"region1\" type=\"text\" class=\"form-control\">\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "            </div>\n" +
        "            <div class=\"col-lg-2 col-md-2 col-sm-2 col-xs-2\">\n" +
        "                <div class=\"row\">\n" +
        "                    <label for=\"typeSelect1\" class=\"col-lg-3 col-md-3 col-sm-3 col-xs-3\">评估方式</label>\n" +
        "                    <div id=\"typeSelect1\" class=\"col-lg-9 col-md-9 col-sm-9 col-xs-9\">\n" +
        "                        <select id=\"evaluateType1\" class=\"form-control\">\n" +
        "                            <option value=\"avg\">均值</option>\n" +
        "                        </select>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "                <div id=\"chart-btn1\" class=\"btn btn-lg btn-success btn-block\">生成图表</div>\n" +
        "            </div>\n" +
        "        </div>\n" +
        "        <div class=\"center-block row\">\n" +
        "            <div class=\"center-block\"><h3>多指标多公司横向对比</h3></div>\n" +
        "            <div class=\"row col-lg-10 col-md-10 col-sm-10 col-xs-10\">\n" +
        "                <div class=\"col-lg-3 col-md-3 col-sm-3 col-xs-3\" style=\"display: block;\">\n" +
        "                <div class=\"input-group input-group-lg\">\n" +
        "                    <span class=\"input-group-addon\">起始年份</span>\n" +
        "                    <input id=\"beginYear2\" type=\"number\" class=\"form-control\">\n" +
        "                    <span class=\"input-group-addon\">年</span>\n" +
        "                </div>\n" +
        "            </div>\n" +
        "                <div class=\"col-lg-3 col-md-3 col-sm-3 col-xs-3\" style=\"display: block;\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">截至年份</span>\n" +
        "                        <input id=\"endYear2\" type=\"number\" class=\"form-control\">\n" +
        "                        <span class=\"input-group-addon\">年</span>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "                <div class=\"col-lg-3 col-md-3 col-sm-3 col-xs-3\" style=\"display: block;\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">起始季度</span>\n" +
        "                        <input id=\"beginQuarter2\" type=\"number\" class=\"form-control\">\n" +
        "                        <span class=\"input-group-addon\">年</span>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "                <div class=\"col-lg-3 col-md-3 col-sm-3 col-xs-3\" style=\"display: block;\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">截至季度</span>\n" +
        "                        <input id=\"endQuarter2\" type=\"number\" class=\"form-control\">\n" +
        "                        <span class=\"input-group-addon\">年</span>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "                <div class=\"col-lg-6 col-md-6 col-sm-6 col-xs-6\" style=\"display: block;\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">所在行业</span>\n" +
        "                        <input id=\"industry2\" type=\"text\" class=\"form-control\">\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "                <div class=\"col-lg-6 col-md-6 col-sm-6 col-xs-6\" style=\"display: block;\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">所在地区</span>\n" +
        "                        <input id=\"region2\" type=\"text\" class=\"form-control\">\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "            </div>\n" +
        "            <div class=\"col-lg-2 col-md-2 col-sm-2 col-xs-2\">\n" +
        "                <div class=\"row\">\n" +
        "                    <label for=\"typeSelect2\" class=\"col-lg-3 col-md-3 col-sm-3 col-xs-3\">评估方式</label>\n" +
        "                    <div id=\"typeSelect2\" class=\"col-lg-9 col-md-9 col-sm-9 col-xs-9\">\n" +
        "                        <select id=\"evaluateType2\" class=\"form-control\">\n" +
        "                            <option value=\"avg\">均值</option>\n" +
        "                        </select>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "                <div class=\"btn btn-lg btn-success btn-block\">生成图表</div>\n" +
        "            </div>\n" +
        "        </div>\n" +
        "    </div>"
};