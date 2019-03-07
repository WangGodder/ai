(function (win) {
    new Vue({
        name: 'app',
        el: '#app',
        components: {DataShow},
        data: function() {
            return {
                queryParams: {
                    industry: "",
                    region: "",
                    beginYear: 0,
                    endYear: 0,
                    beginQuarter: 0,
                    endQuarter: 0,
                },
                showData: false,
                process_num: 60,
            }
        },
        methods: {
            query: function () {
                this.queryParams.industry = $('#industry').val();
                this.queryParams.region = $('#region').val();
                this.queryParams.beginYear = $('#beginYear').val();
                this.queryParams.beginQuarter = $('#beginQuarter').val();
                this.queryParams.endYear = $('#endYear').val();
                this.queryParams.endQuarter = $('#endQuarter').val();
                this.showData = false;
                this.$nextTick(() => {
                    this.showData = true;
                })
            }
        },
        // template:
        //     "<div id='app'>" +
        //     "   <div>\n" +
        //     "        <div class=\"row col-lg-10 col-md-10 col-sm-10 col-xs-10\">\n" +
        //     "            <div class=\"block-show col-lg-6 col-md-6 col-sm-6 col-xs-6\">\n" +
        //     "                <div class=\"input-group input-group-lg\">\n" +
        //     "                    <span class=\"input-group-addon\">公司所在行业</span>\n" +
        //     "                    <input id=\"industry\" type=\"text\" name=\"industry\" class=\"form-control\">\n" +
        //     "                </div>\n" +
        //     "            </div>\n" +
        //     "            <div class=\"block-show col-lg-6 col-md-6 col-sm-6 col-xs-6\">\n" +
        //     "                <div class=\"input-group input-group-lg\">\n" +
        //     "                    <span class=\"input-group-addon\">公司所在地</span>\n" +
        //     "                    <input id=\"region\" type=\"text\" name=\"region\" class=\"form-control\">\n" +
        //     "                </div>\n" +
        //     "            </div>\n" +
        //     "            <div class=\"block-show col-lg-3 col-md-3 col-sm-3 col-xs-3\">\n" +
        //     "                <div class=\"input-group input-group-lg \">\n" +
        //     "                    <span class=\"input-group-addon\">起始年份</span>\n" +
        //     "                    <input id=\"beginYear\" type=\"number\" name=\"beginYear\" class=\"form-control\">\n" +
        //     "                    <span class=\"input-group-addon\">年</span>\n" +
        //     "                </div>\n" +
        //     "            </div>\n" +
        //     "            <div class=\"block-show col-lg-3 col-md-3 col-sm-3 col-xs-3\">\n" +
        //     "                <div class=\"input-group input-group-lg \">\n" +
        //     "                    <span class=\"input-group-addon\">截至年份</span>\n" +
        //     "                    <input id=\"endYear\" type=\"number\" name=\"endYear\" class=\"form-control\">\n" +
        //     "                    <span class=\"input-group-addon\">年</span>\n" +
        //     "                </div>\n" +
        //     "            </div>\n" +
        //     "            <div class=\"block-show col-lg-3 col-md-3 col-sm-3 col-xs-3\">\n" +
        //     "                <div class=\"input-group input-group-lg \">\n" +
        //     "                    <span class=\"input-group-addon\">起始季度</span>\n" +
        //     "                    <input id=\"beginQuarter\" type=\"number\" name=\"beginQuarter\" class=\"form-control\">\n" +
        //     "                </div>\n" +
        //     "            </div>\n" +
        //     "            <div class=\"block-show col-lg-3 col-md-3 col-sm-3 col-xs-3\">\n" +
        //     "                <div class=\"input-group input-group-lg \">\n" +
        //     "                    <span class=\"input-group-addon\">截至季度</span>\n" +
        //     "                    <input id=\"endQuarter\" type=\"number\" name=\"endQuarter\" class=\"form-control\">\n" +
        //     "                </div>\n" +
        //     "            </div>\n" +
        //     "        </div>\n" +
        //     "        <div class=\"col-lg-2 col-md-2 col-sm-2 col-xs-2\" style=\"margin-top: 1%\">\n" +
        //     "            <div id=\"query-btn\" class=\"btn btn-primary btn-lg btn-block\" v-on:click=\"query()\">查询</div>\n" +
        //     "        </div>\n" +
        //     "    </div>\n" +
        //     "    <div class=\"row\">\n" +
        //     "        <data-show ref=\"table\" v-if=\"this.showData\" v-bind:query-params=\"this.queryParams\"></data-show>\n" +
        //     "    </div>" +
        //     "</div>"
    })
})(window||{});
