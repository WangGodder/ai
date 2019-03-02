(function (win) {
    var app={
        url:{
            preferenceSave:"/account/preference/save/",
            searchPreference:"/account/preference/search/",
            preferenceInit:"/account/preference/init/",
            clearPreference:"/account/preference/clear/",
            accountLogin:"/account/login/"
        },

        init:function () {
            $("#prefer_pop").on("click","input[name='menu']",function () {
                if($(this).prop("checked")){
                    $("#sortable").append('<dt data-columnName='+$(this).attr("data-columnName")+'>'+$(this).attr("data-columnName")+'<a class="fr mr20">X</a></dt>');
                }else{
                    $("#sortable dt[data-columnName='"+$(this).attr("data-columnName")+"']").remove();
                }
            }).on("click","#sortable dt a",function () {
                $("input[name='menu'][data-columnName='"+ $(this).closest("dt").attr("data-columnName") +"']").prop("checked", false);
                $(this).closest("dt").remove();
            });

        },
		preference:function () {
            ajaxWrap(
                app.url.preferenceInit,
                {},
                function(resp){
                    if (resp.status == 1) {
                        sv2.dialog(resp.data,{
                            title:"全局搜索偏好设置",
                            area:['750px','530px'],
                            zIndex:1,
                            end:function (index,layerA) {
                                $("#prefer_pop").hide();
                            },
                            yes:function (index) {
                                return false;
                            }
                        });
                        app.init();
                    }
                },
                function(err){
                    //跳转到登录页
                   window.location.href = app.url.accountLogin;
                }
            );
        },

        preferSave:function () {
            var selected = [];

            $("input[name='menu']:checked").each(function () {
                selected.push($(this).val());
            });

            if(selected.length>5){
                sv2.warn("您最多可选五家公司！");
                return false;
            }
            ajaxWrap(
                app.url.preferenceSave,
                {
                    userPreference:selected.join(",")
                },
                function(resp){
                    if (resp.status == 1) {
                        sv2.closeDialog();
                        win.sv2.success('保存成功！');
                    }
                },
                function(err){
                    sv2.error(err);
                }
            );
        },

        preferCancel:function () {
            sv2.closeDialog();
        },
        cancelSelected:function () {
            $("input[name='menu']").removeProp('checked');
            $("#sortable").html("");
        },
        searchPreference:function () {
            var companyName = $("input[name='companyName']").val();
            ajaxWrap(
                app.url.searchPreference,
                {
                    companyName:companyName
                },
                function(resp){
                    if (resp.status == 1) {
                        $("#selectCompany").html(resp.data);
                    }
                },
                function(err){
                    sv2.error(err);
                }
            );
        },
        clearPreference:function () {
            sv2.confirm('确定恢复默认设置吗？', function(){
                ajaxWrap(
                    app.url.clearPreference,
                    {},
                    function(resp){
                        if (resp.status == 1) {
                            sv2.success("成功");
                        }
                    },
                    function(err){
                        sv2.error(err);
                    }
                );
            });
        }

    };

    win.preference = app.preference;
    win.preferSave = app.preferSave;
    win.preferCancel = app.preferCancel;
    win.cancelSelected = app.cancelSelected;
    win.searchPreference = app.searchPreference;
    win.clearPreference = app.clearPreference;

})(window||{});