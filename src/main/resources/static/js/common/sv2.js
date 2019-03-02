
var sv2 = {

    define: function(name, dependence, callback){
        sv2[name] = callback();
    },

    eventer: {
        events: {},
        on: function (event_name, fn){
            var e = sv2.eventer.events[event_name];
            if (e === undefined) {
                sv2.eventer.events[event_name] = [fn];
            }else{
                e.push(fn);
            }
        },
        trigger: function(event_name, data){
            var e = sv2.eventer.events[event_name];
            if (e) {
                for (var i=0; i<e.length; i ++) {
                    var fn = e[i];
                    if (data) {
                        fn(data);
                    }else{
                        fn();
                    }
                }
            }
        }
    }

};

(function (win) {

    win.sv2.define('error',[], function () {
        return function (msg, fn) {
            return win.layer.open({
                skin:'sv2-dialog-layer',
                content: msg,
                zIndex: win.layer.zIndex,
                title: '错误',
                cancel: fn
            });
        }
    });

    win.sv2.define('success', [], function () {
        return function (msg, fn) {
            var text = '<div><i class="icon iconfont icon-correct_bg mr5" style="font-size: 22px;"></i>' + msg + '</div>';
            return win.layer.msg(text, {
                skin: 'sv2-msg-success-layer',
                shade: 0.3,
                time: 800
            },fn);
        }
    });

    win.sv2.define('warn', [], function () {
        return function (msg, icon) {
            return win.layer.open({
                type: 1,
                btn: '确定',
                skin:'sv2-dialog-layer',
                zIndex: win.layer.zIndex,
                content: '<div class="warn">'+msg+'</div>',
                title: '提示'
            });
        }
    });

    win.sv2.define('confirm', [], function () {
        return function (msg, fn) {
            return win.layer.open({
                type:1,
                skin:'sv2-dialog-layer',
                content: msg,
                title: '提示',
                btn:['确定', '取消'],
                zIndex: win.layer.zIndex,
                yes: function (index) {
                    win.layer.close(index);
                    fn();
                }
            });
        }
    });

    win.sv2.define('loginWarn',[], function () {
        return function (msg, fn) {
            return win.layer.open({
                skin:'sv2-dialog-layer',
                content: msg,
                zIndex: win.layer.zIndex,
                title: '提示',
                cancel: fn
            });
        }
    });


    /**
     * 弹出框 参考 http://www.layui.com/doc/modules/layer.html#content
     * @param selector 选择器、内容
     * @param option
     */
    function _dialog(selector, option) {

        var opt = $.extend({
            type: 1,
            skin:'sv2-dialog-layer',
            title: '提示',
            zIndex: win.layer.zIndex,
            content: selector
        }, option);

        return win.layer.open(opt);

    }

    win.sv2.define('dialog', [], function(){
        return _dialog
    });

    // 关闭弹出层
    win.sv2.define('closeDialog', [], function () {
        return function (index) {
            if (index === undefined) {
                win.layer.closeAll()
            }else{
                win.layer.close(index);
            }
        }
    });

    win.sv2.define('get_request_param', [], function () {
        return function (name) {
            function GetRequest() {
                var url = location.search; //获取url中"?"符后的字串
                var theRequest = {};
                if (url.indexOf("?") != -1) {
                    var str = url.substr(1);
                    var strs = str.split("&");
                    for(var i = 0; i < strs.length; i ++) {
                        theRequest[strs[i].split("=")[0]]=unescape(strs[i].split("=")[1]);
                    }
                }
                return theRequest;

            }
            return GetRequest()[name];
        }
    });


    win.sv2.define('get_id', [], function () {

        var dic = {}

        return function (v) {
            v = v === undefined? 'sv-': v;

            if (!dic[v]) {
                dic[v] = 0;
            }
            dic[v] += 1;
            return v + '' + dic[v];
        }

    });
    
    win.sv2.define('loading', [], function () {
        return function (msg) {
        	$("#loader-init") && $("#loader-init").remove();
            var _html = ['<div id="loader-init" class="loader-wrap">'];
				_html.push('<div class="full"></div>');
				_html.push('   <div class="loader">');
				_html
						.push('       <div class="loader-inner ball-spin-fade-loader">');
				_html.push('           <div></div>');
				_html.push('          <div></div>');
				_html.push('        <div></div>');
				_html.push('       <div></div>');
				_html.push('        <div></div>');
				_html.push('      <div></div>');
				_html.push('      <div></div>');
				_html.push('     <div></div>');
				_html.push('  </div>');
				_html.push('  <span class="f14">' + (typeof(msg) === 'undefined' ? '请稍候' : msg) + '</span>');
				_html.push('  </div>');
				_html.push('  </div>');
            $('body').append(_html.join(" "));
        }
    });
    
    win.sv2.define('closeLoading', [], function () {
        return function () {
        	$("#loader-init") && $("#loader-init").remove();
        }
    });

})(window || {})

