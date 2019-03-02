// 图表组件
let ChartComponent = {
    props: {
        name: {
            type: String,
            default: ""
        },
        data: {
            type: Object,
            default: null,
            required: false
        },
        type: {
            type: String,
            required: true
        },
        show: {
            type: Boolean,
            default: true,
            required: true
        }
    },
    data: function () {
        return{
            canvasChart: null,
            value_is_show: true,
            legend_positions: legendPositions,
            current_legend_position: 'top',
            // color: []
        }
    },
    template: "<div v-bind:id=\"name\" v-show=\"this.show\" class=\"well well-lg ChartComponent center-block\">\n" +
        "        <!--<h2>{{$t('message.person.name')}}</h2>-->\n" +
        "        <canvas v-bind:id=\"'canvas_' + name\" ref=\"chartCanvas\"></canvas>\n" +
        "        <div v-bind:id=\"'options_'+this.name\">\n" +
        "            <div class=\"btn-group\">\n" +
        // "                <button v-on:click=\"random_data()\" class=\"btn-default btn-sm\">random data</button>\n" +
        "                <button v-on:click=\"show_value()\" class=\"btn-default btn-sm\">{{ $t('chart.' + value_show)}}</button>\n" +
        "                <button v-on:click=\"enlarge()\" class=\"btn-default btn-sm\">{{$t('chart.enlarge')}}</button>\n" +
        "                <button v-on:click=\"shrink()\" class=\"btn-default btn-sm\">{{$t('chart.shrink')}}</button>\n" +
        "                <label>{{$t('chart.change_legend_position')}}:</label>\n" +
        "                <select ref=\"legendSelect\" v-on:change=\"change_legend_position()\" v-model=\"current_legend_position\">\n" +
        "                    <option v-for=\"(value, index) in legend_positions\" v-bind:value=\"value\" v-bind:key=\"index\">{{ $t('chart.legend_position[' + (index) + ']' )}}</option>\n" +
        "                </select>\n" +
        "            </div>\n" +
        "            <div>\n" +
        "            </div>\n" +
        "            \n" +
        "        </div>\n" +
        "    </div>",
    // created: function() {
    //     // for ()
    // },
    mounted: function () {
        // for test to get fake chart config
        // let config = createRandomChart(this.type, this.name);
        let config = baseDataToChartConfig(this.data, this.type);
        // draw the chart
        let canvas = this.$refs.chartCanvas;
        this.canvasChart = new Chart(canvas, JSON.parse(config));
        // this.change_color = true;
        // console.log(this.canvasChart.data.datasets[0].label);
        // legend position select init
        // alert("mounted");
        // alert(this.config);
        // this.chart = new Chart($("#canvas_" + this.name), JSON.parse(this.config));
    },
    methods:{
        random_data: function () {
            randomData(this.canvasChart);
        },
        show_value: function () {
            showValue(this.canvasChart);
            this.value_is_show = !this.value_is_show;
        },
        change_legend_position: function () {
            changeLegendPosition(this.canvasChart, this.current_legend_position);
        },
        // change_legend_position: function (position) {
        //     changeLegendPosition(this.canvasChart, position);
        // },
        enlarge: function () {
            $('#' + this.name).width($('#' + this.name).width() +  $('#' + this.name).width() / 0.4 * 0.05);
            // $('#' + this.name).width(40 + 1 + '%')
            this.canvasChart.resize();
        },
        shrink: function () {
            $('#' + this.name).width($('#' + this.name).width() -  $('#' + this.name).width() / 0.4 * 0.05);
            this.canvasChart.resize();
        }
    },
    computed: {
        value_show: function () {
            if (this.value_is_show) {
                return 'hide_value';
            }
            return 'show_value';
        }
    }
};