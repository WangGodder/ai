

/*
* ajax call
* */

function ajaxWrap(url, data, success_fn, err_fn){

    var param = $.extend({
        isLoading: false,
        loading:true,
        msg:'请稍候'
    }, data);

    var shadeIndex;

    if (param.isLoading) {
        try {
            shadeIndex = layer.load(3, {shade: [0.3, '#393D49']});
        }catch (e) {}
    }

    if(param.loading){
    	sv2.loading(param.msg);
    }

    $.ajax({
        url: url,
        type: 'POST',
        dataType: "json",
        data: data || {},
        success: function(resp){
        	if(param.loading){
            	sv2.closeLoading();
            }
            if (resp.status == -1){
        	    var currentPage = $("input[name='currentPage']"); //当前页面是否是登录页
        	    if(currentPage.length == 0 || $(currentPage).val() != 'loginPage'){
        	        if(null != resp.data && resp.data != ''){
                        //location.href = resp.data;
                    }
                }
            }else if (resp.status == 1){
                if(success_fn){}
                    success_fn(resp);
            }else{
                if (err_fn)
                    err_fn(resp.message);
            }

        },
        error: function(resp){
        	if(param.loading){
            	sv2.closeLoading();
            }
            if (err_fn){
                var res = {};
                try{
                    res = JSON.parse(resp.responseText);
                }
                catch (e){
                }

                if (res.message != undefined) {
                    err_fn(res.message);
                }else{
                    err_fn('服务器错误');
                }
            }
        }
    }).always(function () {
        if (shadeIndex != undefined) {
            layer.close(shadeIndex);
        }
    });
}
function ajaxWrap_async(url, data, success_fn, err_fn){

    var param = $.extend({
        isLoading: false
    }, data);

    var shadeIndex;

    if (param.isLoading) {
        try {
            shadeIndex = layer.load(3, {shade: [0.3, '#393D49']});
        }catch (e) {}
    }

    if(param.loading){
        sv2.loading(param.msg);
    }

    $.ajax({
        url: url,
        type: 'POST',
        dataType: "json",
        data: data || {},
        success: function(resp){
            if(param.loading){
                sv2.closeLoading();
            }
            if (resp.status == -1){
                var currentPage = $("#currentPage"); //当前页面是否是登录页
                if(currentPage.length == 0 || $(currentPage).val() != 'loginPage'){
                    if(null != resp.data && resp.data != ''){
                        //location.href = resp.data;
                    }
                }
            }else if (resp.status == 1){
                success_fn(resp);
            }else{
                if (err_fn)
                    err_fn(resp.message);
            }

        },
        error: function(resp){
            if(param.loading){
                sv2.closeLoading();
            }
            if (err_fn){
                var res = {};
                try{
                    res = JSON.parse(resp.responseText);
                }
                catch (e){
                }

                if (res.message != undefined) {
                    err_fn(res.message);
                }else{
                    err_fn('服务器错误');
                }
            }
        }
    }).always(function () {
        if (shadeIndex != undefined) {
            layer.close(shadeIndex);
        }
    });
}
/**
 * 如果提交参数有数组的，添加traditional
 * @param url
 * @param data
 * @param success_fn
 * @param err_fn
 * @returns
 */
function ajaxWrap_arr(url, data, success_fn, err_fn){
	
	var param = $.extend({
		isLoading: false,
		loading:true,
		msg:'请稍候'
	}, data);
	
	var shadeIndex;
	
	if (param.isLoading) {
		try {
			shadeIndex = layer.load(3, {shade: [0.3, '#393D49']});
		}catch (e) {}
	}
	
	if(param.loading){
		sv2.loading(param.msg);
	}
	
	$.ajax({
		url: url,
		type: 'POST',
		dataType: "json",
		traditional:true,
		data: data || {},
		success: function(resp){
			if(param.loading){
				sv2.closeLoading();
			}
            if (resp.status == -1){
                var currentPage = $("#currentPage"); //当前页面是否是登录页
                if(currentPage.length == 0 || $(currentPage).val() != 'loginPage'){
                    if(null != resp.data && resp.data != ''){
                        //location.href = resp.data;
                    }
                }
            }else if (resp.status == 1){
				success_fn(resp);
			}else{
				if (err_fn)
					err_fn(resp.message);
			}
			
		},
		error: function(resp){
			if(param.loading){
				sv2.closeLoading();
			}
			if (err_fn){
                var res = {};
                try{
                    res = JSON.parse(resp.responseText);
                }
                catch (e){
                }

                if (res.message != undefined) {
					err_fn(res.message);
				}else{
					err_fn('服务器错误');
				}
			}
		}
	}).always(function () {
		if (shadeIndex != undefined) {
			layer.close(shadeIndex);
		}
	});
}



function ajaxWrap_v3(url, data, success_fn, err_fn){

    var param = $.extend({
        isLoading: false
    }, data);

    var shadeIndex;

    if (param.isLoading) {
        try {
            shadeIndex = layer.load(3, {shade: [0.3, '#393D49']});
        }catch (e) {}
    }

    $.ajax({
        url: url,
        type: 'POST',
        headers:{
            Accept:"application/json",
            "Content-Type":"application/json"
        },
        dataType: "json",
        data: data || {},
        success: function(resp){
            if(resp.status == -1) {
                var currentPage = $("#currentPage"); //当前页面是否是登录页
                if (currentPage.length == 0 || $(currentPage).val() != 'loginPage') {
                    if(null != resp.data && resp.data != ''){
                        //location.href = resp.data;
                    }
                }
            }else if (resp.status == 1){
                if(success_fn){}
                success_fn(resp);
            }else if(resp.status==100){
                if(success_fn){
                    success_fn(resp);
                }
            }else{
                if (err_fn)
                    err_fn(resp.message);
            }

        },
        error: function(resp){
            if (err_fn)
                err_fn('服务器错误');
        }
    }).always(function () {
        if (shadeIndex != undefined) {
            layer.close(shadeIndex);
        }
    });
}

function ajaxWrap_v3_async(url, data, async,success_fn, err_fn){

    var param = $.extend({
        isLoading: false
    }, data);

    var shadeIndex;

    var _async = $.extend({_v:false},{_v:async});

    if (param.isLoading) {
        try {
            shadeIndex = layer.load(3, {shade: [0.3, '#393D49']});
        }catch (e) {}
    }

    $.ajax({
        url: url,
        type: 'POST',
        headers:{
            Accept:"application/json",
            "Content-Type":"application/json"
        },
        dataType: "json",
        async:_async._v,
        data: data || {},
        success: function(resp){
            if (resp.status == 1){
                if(success_fn){}
                success_fn(resp);
            }else if(resp.status == -1){
                var currentPage = $("#currentPage"); //当前页面是否是登录页
                if(currentPage.length == 0 || $(currentPage).val() != 'loginPage'){
                    if(null != resp.data && resp.data != ''){
                        //location.href = resp.data;
                    }
                }
            } else{
                if (err_fn)
                    err_fn(resp.message);
            }

        },
        error: function(resp){
            if (err_fn)
                err_fn('服务器错误');
        }
    }).always(function () {
        if (shadeIndex != undefined) {
            layer.close(shadeIndex);
        }
    });
}

function ajaxWrap_v3_loading(url, data, success_fn, err_fn){

    var shadeIndex = layer.load(3, {shade: [0.3, '#393D49']});

    $.ajax({
        url: url,
        type: 'POST',
        headers:{
            Accept:"application/json",
            "Content-Type":"application/json"
        },
        dataType: "json",
        data: data || {},
        success: function(resp){
            if (resp.status == 1){
                success_fn(resp);
            }else if(resp.status == -1) {
                var currentPage = $("#currentPage"); //当前页面是否是登录页
                if(currentPage.length == 0 || $(currentPage).val() != 'loginPage'){
                    if(null != resp.data && resp.data != ''){
                        //location.href = resp.data;
                    }
                }
            }else{
                if (err_fn)
                    err_fn(resp.message);
            }

        },
        error: function(resp){
            if (err_fn)
                err_fn('服务器错误');
        }
    }).always(function () {
        if (shadeIndex != undefined) {
            layer.close(shadeIndex);
        }
    });
}


function ajaxWrap_v2(url, data, success_fn, err_fn){
    $.ajax({
        url: url,
        type: 'POST',
        dataType: "json",
        data: data || {},
        success: function(resp){
            if(resp.status == -1) {
                var currentPage = $("#currentPage"); //当前页面是否是登录页
                if(currentPage.length == 0 || $(currentPage).val() != 'loginPage'){
                    if(null != resp.data && resp.data != ''){
                         //location.href = resp.data;
                    }
                }
            }else{
                success_fn(resp);
            }
        },
        error: function(resp){
            if (err_fn)
                err_fn('服务器错误');
        }
    });
}

function ajaxWrap_v2_async(url, data, success_fn, err_fn){
    $.ajax({
        url: url,
        type: 'POST',
        async: false,
        dataType: "json",
        data: data || {},
        success: function(resp){
            if(resp.status == -1) {
                var currentPage = $("#currentPage"); //当前页面是否是登录页
                if(currentPage.length == 0 || $(currentPage).val() != 'loginPage'){
                   location.href = resp.data;
                }
            }else{
                success_fn(resp);
            }
        },
        error: function(resp){
            if (err_fn)
                err_fn('服务器错误');
        }
    });
}


function ajaxWrap_v4(url, data, success_fn, err_fn){

    var param = $.extend({
        isLoading: false,
        loading:true,
        msg:'请稍候'
    }, data);

    var shadeIndex;

    if (param.isLoading) {
        try {
            shadeIndex = layer.load(3, {shade: [0.3, '#393D49']});
        }catch (e) {}
    }

    if(param.loading){
        sv2.loading(param.msg);
    }

    $.ajax({
        url: url,
        type: 'POST',
        dataType: "json",
        data: data || {},
        success: function(resp){
            if(param.loading){
                sv2.closeLoading();
            }
            if(resp.status == -1) {
                var currentPage = $("#currentPage"); //当前页面是否是登录页
                if(currentPage.length == 0 || $(currentPage).val() != 'loginPage'){
                   //location.href = resp.data;
                }
            }else if(resp.status > 0){
                success_fn(resp);
            }else {
                if (err_fn)
                    err_fn(resp);
            }

        },
        error: function(resp){
            if(param.loading){
                sv2.closeLoading();
            }
            if (err_fn){
                var res = {};
                try{
                    res = JSON.parse(resp.responseText);
                }
                catch (e){
                }

                if (res.message != undefined) {
                    err_fn(res.message);
                }else{
                    err_fn('服务器错误');
                }
            }
        }
    }).always(function () {
        if (shadeIndex != undefined) {
            layer.close(shadeIndex);
        }
    });
}


function ajaxWrap_v5(url, data, success_fn, err_fn){
    $.ajax({
        url: url,
        type: 'POST',
        dataType: "json",
        data: data || {},
        success: function(resp){
            if(success_fn){}
            success_fn(resp);
        },
        error: function(resp){
            if (err_fn)
                err_fn('服务器错误');
        }
    });
}





function is_empty(val) {
    return val == '' || val == null || val == {} || val == [] || typeof(val) == undefined;
}

var CT = {
    toNumber: function(val, format) {
        var value = Number(val);
        if (isNaN(value)) {
            return 0;
        }
        return value;
    }
};

var utils = {
    /**
     * 对指定的一批<a href="XXXX"></a> 的href进行encodeURI编码，解决某些浏览器的兼容问题
     * @param jqObj_a_list 一批jQuery的<a>的对象，如：var jqObj_a_list = $(".head-position a,.op-home-nav a");
     */
    hrefEncodeURI: function(jqObj_a_list){
        jqObj_a_list.each(function () {
            var that = $(this);
            if (that.attr("href")) {
                that.attr("href", encodeURI(that.attr("href")));
            }
        });
    },

    getFileName: function(filepath){
        if (filepath) {
            var name = filepath.replace(/^.+?\\([^\\]+?)(\.[^\.\\]*?)?$/gi,"$1");
            var ext = filepath.replace(/.+\./,"");
            return name + "." + ext;
        }
        return "";
    },

    getFileExt: function(filepath) {
        if (filepath) {
            return filepath.replace(/.+\./,"");
        }
        return "";
    },

    // 简化query中searchKeys字段的处理
    searchKeysUtil: function (param) {
        var _p = {};
        if (param.searchKeys && param.searchKeys.trim().length > 0) {
            if (param.keywordsCond) {
                _p[param.keywordsCond] = param.searchKeys.trim().split(' ')
            }else{
                _p.searchKeys = param.searchKeys;
            }
        }
        return _p;
    },

    // 把一个字符串分解成数组
    parseArray: function(v, re) {
        re = re || ',';
        if (typeof v === 'string') {
            return v.split(re)
        }
        return null;
    },

    nvl: function(v, d){
        return v ? v : d;
    }
};

/**
 * 去字符串中空格，回车，换行
 * @param str
 * @returns
 */
function replaceAll(str){
	if(is_empty(str)){
		return "";
	}
	str = str.replace(/\s+/g,"");//去掉空格
	str = str.replace(/[ ]/g,"");    //去掉空格
	str = str.replace(/[\r\n]/g,"");//去掉回车换行
	return str;
}


/**
 * 验证税号
 * 15或者17或者18或者20位字母、数字组成
 * @param obj
 * @returns {Boolean}
 */
function checkTax(obj){
  if(/^[A-Z0-9]{15}$|^[A-Z0-9]{17}$|^[A-Z0-9]{18}$|^[A-Z0-9]{20}$/.test(obj)){
    return true;
  }
}
/**
 * 判断数组中是否有重复值
 * @param arr
 * @returns {boolean} 有重复返回true；否则返回false
 */
function isArrRepeat(arr){
    var hash = {};
    for(var i in arr) {
        if(hash[arr[i]]){
            return true;
        }
        hash[arr[i]] = true;
    }
    return false;
}

/**
 * 数字千位符格式化方法
 * @param num
 * @returns {string}
 */
function toThousands(num) {
    return formatNumber(num,2);
}

//对多位小数进行四舍五入
//num是要处理的数字  v为要保留的小数位数
function decimal(num,v){
    var vv = Math.pow(10,v);
    return Math.round(num*vv)/vv;
}


/**
 * 数字格式化
 * @param num
 * @param precision
 * @param separator
 * @returns {*}
 *=======================================================
 *     formatNumber(10000)="10,000"
 *     formatNumber(10000, 2)="10,000.00"
 *     formatNumber(10000.123456, 2)="10,000.12"
 *     formatNumber(10000.123456, 2, ' ')="10 000.12"
 *     formatNumber(.123456, 2, ' ')="0.12"
 *     formatNumber(56., 2, ' ')="56.00"
 *     formatNumber(56., 0, ' ')="56"
 *     formatNumber('56.')="56"
 *     formatNumber('56.a')=NaN
 *=======================================================
 */
function formatNumber(num, precision, separator) {
    var parts;
    // 判断是否为数字
    if (is_empty(num) || isNaN(parseFloat(num)) || !isFinite(num)) {
        num = 0;
    }
    // 把类似 .5, 5. 之类的数据转化成0.5, 5, 为数据精度处理做准, 至于为什么
    // 不在判断中直接写 if (!isNaN(num = parseFloat(num)) && isFinite(num))
    // 是因为parseFloat有一个奇怪的精度问题, 比如 parseFloat(12312312.1234567119)
    // 的值变成了 12312312.123456713
    num = Number(num);
    // 处理小数点位数
    num = (typeof precision !== 'undefined' ? num.toFixed(precision) : num).toString();
    // 分离数字的小数部分和整数部分
    parts = num.split('.');
    // 整数部分加[separator]分隔, 借用一个著名的正则表达式
    parts[0] = parts[0].toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, '$1' + (separator || ','));
    return parts.join('.');
}


/**
 * 把数字转换成货币的格式
 * @param decimals
 * @param dec_point
 * @param thousands_sep
 * @returns {string}
 */
Number.prototype.format=function(decimals, dec_point, thousands_sep){
    var num = (this + '')
        .replace(/[^0-9+\-Ee.]/g, '');
    var n = !isFinite(+num) ? 0 : +num,
        prec = !isFinite(+decimals) ? 0 : Math.abs(decimals),
        sep = (typeof thousands_sep === 'undefined') ? ',' : thousands_sep,
        dec = (typeof dec_point === 'undefined') ? '.' : dec_point,
        s = '',
        toFixedFix = function(n, prec) {
            var k = Math.pow(10, prec);
            return '' + (Math.round(n * k) / k)
                    .toFixed(prec);
        };
    // Fix for IE parseFloat(0.55).toFixed(0) = 0;
    s = (prec ? toFixedFix(n, prec) : '' + Math.round(n))
        .split('.');
    if (s[0].length > 3) {
        s[0] = s[0].replace(/\B(?=(?:\d{3})+(?!\d))/g, sep);
    }
    if ((s[1] || '')
            .length < prec) {
        s[1] = s[1] || '';
        s[1] += new Array(prec - s[1].length + 1)
            .join('0');
    }
    return s.join(dec);
}
