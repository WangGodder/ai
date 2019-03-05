let ExcelUpload = {
    name: "ExcelUpload",
    methods: {
        download_template: function () {
            const url = "/user/downloadFile/";
            window.location = url;
        },
        submit: function () {
            $('submit-btn').attr('disabled', true);
            // upload
            $("#uploadForm").ajaxSubmit(
                {
                    url:"/user/evaluation/",
                    dataType:"json",
                    resetForm:true,
                    success: function (data) {
                        var json = data.status;
                        if (json == 1) {
                            sv2.warn("上传成功");
                        } else {
                            sv2.warn("上传失败:" + data.message);
                        }
                    },
                    error: function () {
                        sv2.warn("上传失败");
                    }
                }
            );
            $('submit-btn').attr('disabled', false);
        }
    },
    template:
        "<form enctype=\"multipart/form-data\" id=\"uploadForm\"name=\"uploadForm\" method=\"post\">\n" +
        "<div id=\"upload-excel\" class=\"jumbotron \">\n" +
        "        <label for=\"excel-input\" class=\"text-left h3\">上传Excel文件</label>\n" +
        "        <div id=\"download-template\" v-on:click=\"download_template()\" class=\"btn btn-warning btn-lg\">Excel模板下载</div>\n" +
        "        <div class=\"input-group input-group-lg\">\n" +
        "            <span class=\"input-group-addon\">文件路径</span>\n" +
        "            <input id=\"excel-input\" type=\"file\" class=\"form-control\" name=\"file\" multiple>\n" +
        "        </div>\n" +
        "        <label for=\"prove-input\" class=\"text-left h3\">上传相关证明文件</label>\n" +
        "        <div class=\"input-group input-group-lg\">\n" +
        "            <span class=\"input-group-addon\">文件路径</span>\n" +
        "            <input id=\"prove-input\" type=\"file\" class=\"form-control\" name=\"file\" multiple>\n" +
        "        </div>\n" +
        "        <div id=\"submit-btn\" v-on:click=\"submit()\" class=\"btn btn-lg btn-primary margin-top-sm\">\n" +
        "            上传\n" +
        "        </div>\n" +
        "    </div>\n"+
        "</form>",

}