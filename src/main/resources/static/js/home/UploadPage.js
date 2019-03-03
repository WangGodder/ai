let UploadPage = {
    name: "UploadPage",
    components: {ImageUpload, VoiceUpload, FormUpload, ExcelUpload},
    data() {
        return {
            function_show: [true, false, false, false],
            function_index: ['upload-excel-btn', 'upload-form-btn', 'upload-voice-btn', 'upload-image-btn']
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
        "    <div id=\"upload-page\" class=\"row\">\n" +
        "        <!--侧边工具条-->\n" +
        "        <div id=\"side-nav\" class=\"col-lg-2 col-md-2 col-sm-2 col-xs-2\" style=\"padding-right: 0%\">\n" +
        "            <h3>数据上传页面</h3>\n" +
        "            <div>\n" +
        "                <div id=\"upload-excel-btn\" v-on:click=\"change_function(0)\" class=\"btn btn-block btn-default btn-lg active\">上传Excel文件</div>\n" +
        "                <div id=\"upload-form-btn\" v-on:click=\"change_function(1)\" class=\"btn btn-block btn-default btn-lg\">在线填写数据</div>\n" +
        "                <div id=\"upload-voice-btn\" v-on:click=\"change_function(2)\" class=\"btn btn-block btn-default btn-lg\">声音输入</div>\n" +
        "                <div id=\"upload-image-btn\" v-on:click=\"change_function(3)\" class=\"btn btn-block btn-default btn-lg\">图像输入</div>\n" +
        "            </div>\n" +
        "\n" +
        "        </div>\n" +
        "        <!--工作区-->\n" +
        "        <div id=\"workspace\" class=\"col-lg-10 col-md-10 col-sm-10 col-xs-10 well\">\n" +
        "            <excel-upload v-show=\"this.function_show[0]\"></excel-upload>\n" +
        "            <form-upload v-show=\"this.function_show[1]\"></form-upload>\n" +
        "            <voice-upload v-show=\"this.function_show[2]\"></voice-upload>\n" +
        "            <image-upload v-show=\"this.function_show[3]\"></image-upload>\n" +
        "        </div>\n" +
        "\n" +
        "    </div>",

}