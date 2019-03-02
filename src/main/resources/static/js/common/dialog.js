
// 方法 userDefined 参数说明
    // opts {} 包含type,title,content,area,cancel
        // :type 弹出框类型 参数类型:Int 0,1,2,3,4, 目前我们只需要1类型的弹出框
        // :title 弹出框标题 参数类型:String/Boolean fasle的话就没有标题
        // :content 弹出框内容 参数类型:String/DOM 可以是dom元素或者html字符串 $('#id'),'<div>look</div>'
        // :area 弹出框大小 参数类型:Array ['400px', '200px'];

    // callback 回调函数 参数类型:function

    // 返回值 int 该弹出框的唯一表示id
    // 使用方法:
    // var index = Window.dialog.userDefinedDialog({type:1, title:'上传文件', area:['200px','100px']},function(){console.log(111111)});
    // layer.close(index) 手动关闭

// 方法 fail, error, success 参数说明
    // content 消息内容 参数类型:String
    // callback 回调函数 参数类型:function

    // 返回值 int 该弹出框的唯一表示id

    // 使用方法:
    // var index1 = Window.dialog.success('执行成功')
    // var index2 = Window.dialog.fail('执行失败')
    // var index3 = Window.dialog.error('程序报错')
    // layer.close(index1) 手动关闭
    // layer.close(index2) 手动关闭
    // layer.close(index3) 手动关闭

;(function(win, layui){
    var layer = layui.layer;
    var icon = {
        yellow: 0,
        green: 1,
        red: 2
    }

    win.dialog = {
        success: success,
        fail: fail,
        error: error,
        userDefined: userDefined
    }

    function userDefined (opts, callback) {
        var _opts = {
            type: 4>= opts.type >0 ? opts.type:1,
            title: opts.title != undefined && opts.title != '' ? opts.title: '提示',
            content: opts.content != undefined ? opts.content:'',
            area: ['400px', '200px'],
            cancel: callback != undefined ? callback:null
        }

        if (opts.width) _opts.area[0] = opts.width;
        if (opts.height) _opts.area[1] = opts.height;

        return layer.open(_opts);
    };

    function success (content, callback) {
        return layerOpen(content, "green", callback);
    };

    function fail(content, callback) {
        return layerOpen(content, "yellow", callback);
    };

    function error(content, callback) {
        return layerOpen(content, "red", callback);
    };

    function layerOpen(content, color, callback) {
        var opts = {
            type:0,
            title: false,
            content: content,
            shadeClose:true,
            time: 2000,
            area: ['inherit', '60px'],
            icon:icon[color],
            btn:[],
            closeBtn: 0,
            skin: 'layui-ext-msg',
            end: callback != undefined ? callback:null
        }

        return layer.open(opts);
    };
})(window, layui);