(function (win) {
    var app = new Vue({
        el:'#index',
        data:{
            url:{
                uploadFileUrl:"/user/uploadFile/",
                evaluationUrl:"/user/evaluation/"
            },
            fileName:"mmm",
            company:"",
            resultList:[],
        },
        methods:{
          changeFile:function () {
              app.fileName = $('input[id=loadFile]').val()
          },
            uploadFile:function () {
                $("#loadFileForm").ajaxSubmit(
                    {
                        url:app.url.uploadFileUrl,
                        dataTpye:"json",
                        resetForm:true,
                        success: function (data) {
                            var json = data.status;
                            if (json == 1) {
                                sv2.warn("上传成功");
                            } else {
                                sv2.warn("上传失败");
                            }
                        },
                        error: function () {
                            alert("上传失败，请重新选择文件");
                        }
                    }
                )
            },
            evaluation:function () {
                $("#loadFileForm").ajaxSubmit(
                    {
                        url:app.url.evaluationUrl,
                        dataTpye:"json",
                        resetForm:true,
                        success: function (json) {
                            app.resultList = json.data;
                        },
                        error: function () {
                            alert("上传失败，请重新选择文件");
                        }
                    }
                )
            }
        },

    });


})(window||{});