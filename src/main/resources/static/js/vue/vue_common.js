

// 如果是为空取默认
Vue.filter("ifNull", function(value, then){
    if (!value || value == '') return then;
    else return value;
});


// 取固定长度，超过的后面追加...
Vue.filter("maxLen", function(value, len){
    if (typeof (value) === "string"){
        if (!value) return "";
        else if (value.length <= len) return value;
        else if (value.length > len) return value.substr(0, len) + "...";
    }
    else{
        return value;
    }
});


// 数字格式化
Vue.filter("round", function(value, ln){
    var _value = parseFloat(value);
    return isNaN(_value) ? 0 : _value.toFixed(ln);
});


// Unix timestamp格式化
Vue.filter("unixTimeFormat", function(value, format){
    if (!value || value == '') return '';
    else return new Date(parseInt(value)).dateFormat(format);
});


//格式化日期时间
Vue.filter("extendTimeFormat", function(value, format){
    if (!value || value == '') return '';

    var date = new Date(parseInt(value));

    var o = {
        "M+" : date.getMonth()+1,                 //月份
        "d+" : date.getDate(),                    //日
        "h+" : date.getHours(),                   //小时
        "m+" : date.getMinutes(),                 //分
        "s+" : date.getSeconds(),                 //秒
        "q+" : Math.floor((date.getMonth()+3)/3), //季度
        "S"  : date.getMilliseconds()             //毫秒
    };

    if(/(y+)/.test(format)){
        format=format.replace(RegExp.$1, (date.getFullYear()+"").substr(4 - RegExp.$1.length));
    }
    for(var k in o) {
        if (new RegExp("(" + k + ")").test(format)) {
            format = format.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        }
    }

    return format;
});


//更多
Vue.filter("word", function(obj){
    if (typeof(obj.showAll) === 'undefined'){
    	return "";
    }else{
    	if(obj.showAll){
    		return "收起";
    	}else{
    		return "更多";
    	}
    }
});

