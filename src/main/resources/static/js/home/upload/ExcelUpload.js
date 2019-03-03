let ExcelUpload = {
    name: "ExcelUpload",
    methods: {
        download_template : function () {

        },
        submit: function () {
            $('submit-btn').attr('disabled', true);
            // upload
            alert("上传成功");
            $('submit-btn').attr('disabled', false);
        }
    },
    template:
        "<div id=\"upload-excel\" class=\"jumbotron \">\n" +
        "        <label for=\"excel-input\" class=\"text-left h3\">上传Excel文件</label>\n" +
        "        <div id=\"download-template\" v-on:click=\"download_template()\" class=\"btn btn-warning btn-lg\">Excel模板下载</div>\n" +
        "        <div class=\"input-group input-group-lg\">\n" +
        "            <span class=\"input-group-addon\">文件路径</span>\n" +
        "            <input id=\"excel-input\" type=\"file\" class=\"form-control\">\n" +
        "        </div>\n" +
        "        <label for=\"prove-input\" class=\"text-left h3\">上传相关证明文件</label>\n" +
        "        <div class=\"input-group input-group-lg\">\n" +
        "            <span class=\"input-group-addon\">文件路径</span>\n" +
        "            <input id=\"prove-input\" type=\"file\" class=\"form-control\">\n" +
        "        </div>\n" +
        "        <div id=\"submit-btn\" v-on:click=\"submit()\" class=\"btn btn-lg btn-primary margin-top-sm\">\n" +
        "            上传\n" +
        "        </div>\n" +
        "    </div>",

}