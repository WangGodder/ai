(function (win) {
        $(document).ready(function() {
            search(1);
        })

        function search(page) {
            var param = {
                page: page,
                limit: $('.pageSize').val() || 10,
            }

            ajaxWrap('/notice/List/', param, function (json){
                if (json.status == 1) {
                    //alert(json)
                    $('#search_list').html(json.data);
                } else {
                    sv2.error("查询异常");
                }
            });
/*
            ajaxWrap({
                type: "post",
                url: "/notice/List/",//请求的后台地址
                data: param,//前台传给后台的参数
                success: function (json) {//msg:返回值
                    if (json.status == 1) {
                        $('#search_list').html(json.data);
                    } else {
                        sv2.error("查询异常");
                    }
                },
                error: function () {
                    alert("error")
                }
        });
*/

        }
       win.search = function(page){
            search(page);
        }
    })(window || {});


