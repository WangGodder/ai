(function (win) {
    var app = new Vue({
        el: '#userLogin',
        data: {
            url:{
                addUserUrl:"/user/addUser/",
                loginUrl:"/user/checkLogin/"
            },
            username:"",
            password:""
        },
        methods: {
            login: function () {
                var param = {userId: app.username, pwd: app.password}
                win.ajaxWrap_v3(app.url.loginUrl, JSON.stringify(param), app.initResult, app.errorHandle);
            },
            addUser: function () {
                var param = {username:app.username, password:app.password}
                //    $.post(app.url.loginUrl, param, app.initResult);
                win.ajaxWrap_v3(app.url.addUserUrl,JSON.stringify(param),app.addUserSuccess,app.errorHandle);
            },

            initResult: function (json) {
                var user = json.data.userName;
                if (user != null) {
                    window.location = "/user/index/";
                }
            },

            addUserSuccess:function(json){
                alert(json.message)
            },
            errorHandle:function (msg) {
                sv2.warn(msg);
            }
        }
    });


})(window||{});