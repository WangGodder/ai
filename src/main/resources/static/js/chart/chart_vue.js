// 读取i18n信息
// function loadLocaleMessages () {
//     const locales = .context('./locales', true, /[A-Za-z0-9-_,\s]+\.json$/i);
//     const messages = {}
//     locales.keys().forEach(key => {
//         const matched = key.match(/([A-Za-z0-9-_]+)\./i)
//         if (matched && matched.length > 1) {
//             const locale = matched[1]
//             messages[locale] = locales(key)
//         }
//     })
//     return messages
// };

(function (win) {

    // 语言种类读取
    const languages = {};
    for (let language in messages) {
        languages[language] = messages[language].language;
    };

    // i18n 创建
    const i18n = new VueI18n({
        locale: 'zh',
        fallbackLocale: 'zh',
        // messages: loadLocaleMessages()
        messages
    });

    new Vue({
        i18n,
        el: '#app',
        components: {
            'ChartComponent': ChartComponent
        },
        data: function() {
            return {
                // 图表的标题
                title: '评估结果',
                // 所有的语言
                languages: languages,
                // 当前的语言
                language: '',
                // 所有图表的类型
                chart_types: chartTypes,
                // 各类型的图表是否已经显示
                chart_type: {
                    line: false,
                    bar: false,
                    radar: false,
                    pie: false,
                    doughnut: false
                },
                // 各个图表控件的ref值
                chart_ref: {
                    line: 'lineChart',
                    bar: 'barChart',
                    radar: 'radarChart',
                    pie: 'pieChart',
                    doughnut: 'doughnutChart'
                },
                // 数据信息，prop传给子控件
                base_data: null
            }
        },
        template: "<div>\n" +
            "    <nav id=\"nav\" class=\"navbar navbar-inverse navbar-fixed-top\">\n" +
            "      <div class=\"container\">\n" +
            "        <div class=\"navbar-header\">\n" +
            "          <h3 class=\"navbar-text\">{{title}}</h3>\n" +
            "        </div>\n" +
            "        <div id=\"navbar\" class=\"collapse navbar-collapse\">\n" +
            "          <ul class=\"nav navbar-nav\">\n" +
            "            <li role=\"presentation\" class=\"dropdown\">\n" +
            "              <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\" role=\"button\">\n" +
            "                {{$t('choose_chart_type')}}<span class=\"caret\"></span>\n" +
            "              </a>\n" +
            "              <ul ref=\"chartTypeDropdown\" class=\"dropdown-menu\">\n" +
            "                <li v-for=\"(item, key) in this.chart_types\"><a v-on:click=\"choose_chart_type($event, item)\" v-bind:key=\"key\">{{$t('chart_types[' + (key) + ']')}}</a></li>\n" +
            "              </ul>\n" +
            "            </li>\n" +
            "            <li><a v-on:click=\"choose_all_chart_type\">{{$t('choose_all_chart_type')}}</a></li>\n" +
            "            <li><a v-on:click=\"clear_all_chart\">{{$t('clear_all_chart')}}</a></li>\n" +
            "            <li><a v-on:click=\"enlarge_all_chart\">{{$t('enlarge_all_chart')}}</a></li>\n" +
            "            <li><a v-on:click=\"shrink_all_chart\">{{$t('shrink_all_chart')}}</a></li>\n" +
            "          </ul>\n" +
            "          <ul class=\"nav navbar-nav navbar-right\">\n" +
            "            <li role=\"presentation\" class=\"dropdown \">\n" +
            "              <a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\" role=\"button\">\n" +
            "                {{$t('choose_language')}}<span class=\"caret\"></span>\n" +
            "              </a>\n" +
            "              <ul ref=\"languageDropdown\" class=\"dropdown-menu\">\n" +
            "                <li v-for=\"(item, key) in this.languages\"><a v-on:click=\"choose_language(key)\">{{item}}</a></li>\n" +
            "              </ul>\n" +
            "            </li>\n" +
            "          </ul>\n" +
            "\n" +
            "        </div>\n" +
            "\n" +
            "      </div>\n" +
            "    </nav>\n" +
            "    <div id=\"chartContainer\" class=\"container-fluid\">\n" +
            "      <chart-component v-if=\"this.chart_type.line\" ref=\"lineChart\" name=\"lineChart\" v-bind:show=\"true\" type=\"line\" v-bind:data=\"base_data\"></chart-component>\n" +
            "      <chart-component v-if=\"this.chart_type.bar\" ref=\"barChart\" name=\"barChart\" v-bind:show=\"true\" type=\"bar\" v-bind:data=\"base_data\"></chart-component>\n" +
            "      <chart-component v-if=\"this.chart_type.radar\" ref=\"radarChart\" name=\"radarChart\" v-bind:show=\"true\" type=\"radar\" v-bind:data=\"base_data\"></chart-component>\n" +
            "      <chart-component v-if=\"this.chart_type.pie\" ref=\"pieChart\" name=\"pieChart\" v-bind:show=\"true\" type=\"pie\" v-bind:data=\"base_data\"></chart-component>\n" +
            "      <chart-component v-if=\"this.chart_type.doughnut\" ref=\"doughnutChart\" name=\"doughnutChart\" v-bind:show=\"true\" type=\"doughnut\" v-bind:data=\"base_data\"></chart-component>\n" +
            "    </div>\n" +
            "  </div>",
        created: function () {
            // this.$i18n.locale = 'zh';
            this.language = i18n.locale;
            // this.base_data = getBaseData('http://localhost:9666/random_data');
            // 临时测试使用随机生成的数据
            this.base_data = getRandomBaseData(3, 10);
        },
        mounted() {

        },
        methods: {
            /**
             * 选择语言
             * @param language 所选择的语言
             */
            choose_language: function (language) {
                this.language = language;
                i18n.locale = this.language;
            },
            /**
             * 显示所选类型图表
             * @param event 传来的事件，用来修改button active状态
             * @param type 显示的类型
             */
            choose_chart_type: function (event, type) {
                this.chart_type[type] = !this.chart_type[type];
                let li = $(event.srcElement.parentElement);
                if (this.chart_type[type])
                    li.addClass('active');
                else
                    li.removeClass('active');

                // event.style('active');
            },
            // 显示所有类型图表
            choose_all_chart_type: function () {
                for (let type in this.chart_type) {
                    this.chart_type[type] = true;
                }
                // console.log(this.$refs.chartTypeDropdown.children.length[0])
                for (let i = 0; i < this.$refs.chartTypeDropdown.children.length; i++) {
                    this.$refs.chartTypeDropdown.children[i].classList.add('active');
                }
            },
            // 清空所有图表
            clear_all_chart: function () {
                for (let type in this.chart_type) {
                    this.chart_type[type] = false;
                }
                // console.log(this.$refs.chartTypeDropdown.children.length[0])
                for (let i = 0; i < this.$refs.chartTypeDropdown.children.length; i++) {
                    this.$refs.chartTypeDropdown.children[i].classList.remove('active');
                }
            },
            // 扩大所有图表
            enlarge_all_chart: function () {
                for (let type in this.chart_type) {
                    if (this.chart_type[type]) {
                        this.$refs[this.chart_ref[type]].enlarge();
                    }
                }
            },
            // 所有所有图表
            shrink_all_chart: function () {
                for (let type in this.chart_type) {
                    if (this.chart_type[type]) {
                        this.$refs[this.chart_ref[type]].shrink();
                    }
                }
            }
        }
    });
})(window||{})

