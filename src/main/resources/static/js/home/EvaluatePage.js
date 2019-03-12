let EvaluatePage = {
    name: "EvaluatePage",
    components: {ChartConfig},
    data() {
        return {
            function_show: [true, false, false],
            function_index: ['total-evaluate-btn', 'detail-evaluate-btn', 'chart-evaluate-btn']
        }
    },
    methods: {
        change_function: function (function_index) {
            for (let i = 0; i < this.function_show.length; i++) {
                if (this.function_show[i]) {
                    const origin_button = document.getElementById(this.function_index[i]);
                    origin_button.classList.remove('active');
                    this.$set(this.function_show, i, false);
                    break;
                }
            }
            const active_button = document.getElementById(this.function_index[function_index]);
            active_button.classList.add('active');
            this.$set(this.function_show, function_index, true);
        }
    },
    template:
        " <div id=\"evaluate-page\">\n" +
        "        <div id=\"side-nav\" class=\"col-lg-2 col-md-2 col-sm-2 col-xs-2\" style=\"padding-right: 0%\">\n" +
        "            <h3>评估页面</h3>\n" +
        "            <div id=\"total-evaluate-btn\" v-on:click=\"change_function(0)\" class=\"btn btn-block btn-default btn-lg active\">总体评估</div>\n" +
        "            <div id=\"detail-evaluate-btn\" v-on:click=\"change_function(1)\" class=\"btn btn-block btn-default btn-lg\">详细评估</div>\n" +
        "            <div id=\"chart-evaluate-btn\" v-on:click=\"change_function(2)\" class=\"btn btn-block btn-default btn-lg\">图表展示</div>\n" +
        "        </div>\n" +
        "        <div id=\"workspace\" class=\"col-lg-10 col-md-10 col-sm-10 col-xs-10 well\">\n" +
        "            <div v-show=\"this.function_show[0]\" class=\"embed-responsive embed-responsive-16by9\">\n" +
        "                <iframe class=\"embed-responsive-item\" src=\"http://www.leetcode.com\"></iframe>\n" +
        "            </div>\n" +
        "            <div v-show=\"this.function_show[1]\" class=\"embed-responsive embed-responsive-16by9\">\n" +
        "                <iframe class=\"embed-responsive-item\" src=\"http://www.baidu.com\"></iframe>\n" +
        "            </div>\n" +
        "            <chart-config v-show=\"this.function_show[2]\"></chart-config>\n" +
        "        </div>\n" +
        "    </div>"
}