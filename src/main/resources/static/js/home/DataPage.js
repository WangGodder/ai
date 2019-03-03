let DataPage = {
    name: "DataPage",
    components: {WeightQuery, UserQuery, SelfCompany},
    data() {
        return {
            function_show: [false, false, false, false],
            function_index: ['show-self-region-btn', 'show-weight-btn', 'show-self-company-btn','show-user-btn']
        }
    },
    props: {
        user_type: {
            type: Number,
            required: true
        }
    },
    created() {
        if (this.user_type === 1 || this.user_type === 2 || this.user_type === 3) {
            this.function_show[0] = true;
        }
        if (this.user_type === 4) {
            this.function_show[2] = true;
        }
        if (this.user_type === 5) {
            this.function_show[3] = true;
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
    template :
        "<div id=\"data-page\">\n" +
        "        <!--侧边工具条-->\n" +
        "        <div id=\"side-nav\" class=\"col-lg-2 col-md-2 col-sm-2 col-xs-2\" style=\"padding-right: 0%\">\n" +
        "            <h3>数据查看页面</h3>\n" +
        "            <div>\n" +
        "                <!--政府人员、专家、投资人操作-->\n" +
        "                <div v-if=\"this.user_type === 1 || this.user_type === 2 || this.user_type === 3\">\n" +
        "                    <div id=\"show-self-region-btn\" v-on:click=\"change_function(0)\" class=\"btn btn-block btn-default btn-lg active\">查看公司信息</div>\n" +
        "                    <div id=\"show-weight-btn\" v-on:click=\"change_function(1)\" class=\"btn btn-block btn-default btn-lg\">查看权重信息</div>\n" +
        "                </div>\n" +
        "                <!--公司用户操作-->\n" +
        "                <div v-if=\"this.user_type === 4\">\n" +
        "                    <div id=\"show-self-company-btn\" v-on:click=\"change_function(2)\" class=\"btn btn-block btn-default btn-lg active\">查看本公司信息</div>\n" +
        "                </div>\n" +
        "                <!--管理员操作-->\n" +
        "                <div v-if=\"this.user_type === 5\">\n" +
        "                    <div id=\"show-user-btn\" v-on:click=\"change_function(3)\" class=\"btn btn-block btn-default btn-lg\">查看用户信息</div>\n" +
        "                </div>\n" +
        "            </div>\n" +
        "        </div>\n" +
        "        <!--工作区-->\n" +
        "        <div id=\"workspace\" class=\"col-lg-10 col-md-10 col-sm-10 col-xs-10 well\">\n" +
        "            <div v-show=\"this.function_show[0]\" class=\"embed-responsive embed-responsive-16by9\">\n" +
        "                <iframe class=\"embed-responsive-item\" src=\"http://www.leetcode.com\"></iframe>\n" +
        "            </div>\n" +
        "            <weight-query v-show=\"this.function_show[1]\"></weight-query>\n" +
        "            <self-company v-show=\"this.function_show[2]\"></self-company>\n" +
        "            <user-query v-show=\"this.function_show[3]\"></user-query>\n" +
        "        </div>\n" +
        "    </div>",

}