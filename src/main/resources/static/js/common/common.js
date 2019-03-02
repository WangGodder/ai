var common={
	//表单校验
	postFormData:function(obj){
		var formData = {};
		var _isSubmit = false;
		$(obj).find("input[isValidate='true']").each(function(){
			var _isNotNull = $(this).attr("isNotNull");
			var _val = $(this).val();
			if(typeof(_isNotNull) !== 'undefined' && '' != _isNotNull && _val == ''){
				_dialog.tips($(this).attr('data-tips'));
				_isSubmit = false;
				return false;
			}
			formData[$(this).attr('name')] = $.trim(_val);
			_isSubmit = true;
		});
		
		if(!_isSubmit) return null;
		
		return formData ;
	},
	// post 请求跳转
	forward:function(url,data,target){
		var form = $("#submitForm");
		if(form && form.length > 0 ) form.remove();
		if(typeof(target) === 'undefined' || target == ''){
			target = "_blank";
		}
		form = "<form id='submitForm' target='"+ target +"' action='"+url+"' enctype='multipart/form-data' method='post'>";
		for(i in data){
			form += '<input type="hidden"  name="'+i+'" value="'+data[i]+'"/>';
		}
		form+= "</form>";
		$("body").append(form);
		$("#submitForm").submit();
	},
	//验证数字
	isDigits:function(num){
		var pattern =  /^\d+$/;
		return pattern.test(num);
	},
	isAmount:function(num){
		// 验证金额
		var exp = /^([1-9][\d]{0,10}|0)(\.[\d]{1,2})?$/;
		return exp.test(num);
	},
	isPrice:function(num){
		// 验证价格
		var exp = /^([1-9][\d]{0,10}|0)(\.[\d]{1,4})?$/;
		return exp.test(num);
	},
	//验证中文名称(20位以内的英文+字母。10位以内的汉字)
	isChinaName:function(name){
		var patternChina = /^[\u4E00-\u9FA5+\·]{1,20}$/;
		return patternChina.test(name);
	},
	//检查手机号
	checkMobile:function(value){
		var length = value.length;
		return (length == 11 && /^(((13[0-9]{1})|(14[0-9]{1})|(15[0-9]{1})|(16[0-9]{1})|(17[0-9]{1})|(18[0-9]{1})|(19[0-9]{1}))+\d{8})$/.test(value));
	}
};

// eg: var repString = "test{0} test{1}"; repString.format("aa", "bb");
String.prototype.format = function() {
	var e = this, f = arguments.length;
	if (f > 0) {
		for ( var d = 0; d < f; d++) {
			e = e.replace(new RegExp("\\{" + d + "\\}", "g"), arguments[d])
		}
	}
	return e;
};

// 数字格式化
String.prototype.getAns = function() {
  var pattern = /(?=((?!\b)\d{3})+$)/g;
  return this.replace(pattern, ',');
};

// 对Date的扩展，将 Date 转化为指定格式的String 
// 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符， 
// 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字) 
// 例子： 
// (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423 
// (new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18 
Date.prototype.dateFormat = function(fmt) 
{ 
   var o = { 
    "M+" : this.getMonth()+1,                 //月份 
    "d+" : this.getDate(),                    //日 
    "h+" : this.getHours(),                   //小时 
    "m+" : this.getMinutes(),                 //分 
    "s+" : this.getSeconds(),                 //秒 
    "q+" : Math.floor((this.getMonth()+3)/3), //季度 
    "S"  : this.getMilliseconds()             //毫秒 
  }; 
  if(/(y+)/.test(fmt)){
    fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
  }
  for(var k in o){
    if(new RegExp("("+ k +")").test(fmt)){
		fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
	}
  }
  return fmt; 
};
Array.prototype.removeByValue = function(val) {
	for (var i = 0; i < this.length; i++) {
		if (this[i] == val) {
			this.splice(i, 1);
			break;
		}
	}
};
var _dialog={
	tips:function(msg){
		easyDialog.open({
		  container : {
			content : msg
		  },
		  autoClose : 2000
		});
	},
	confirm:function(title, content, btnFn){
		easyDialog.open({
		  container : {
			header : title,
			content : content,
			yesFn : btnFn,
			noFn : true
		  }
		});
	}
};

var _timer={
	init:function(obj){
		var _data = $(obj).attr("data-timer");
		// _data seconds
		if(typeof(_data) !== 'undefined' && _data != ""){
			function timeFn(){
    		    var _html = _timer.format(_data);
    		    $(obj).html(_html);
    		    
    		    if(_data>0){
    		      _data--;
    		      _countDown = setTimeout(timeFn, 1000);
    		    }else{
    		    	clearTimeout(_countDown);
    		    }
			}
			timeFn();
		}
	},
	format:function(_data){
		var d=0;
	    var h=0;
	    var m=0;
	    var s=0;
	    var _html ="00分00秒";
	    if(_data>0){
	      d=Math.floor(_data/60/60/24);
	      h=Math.floor(_data/60/60%24);
	      m=Math.floor(_data/60%60);
	      s=Math.floor(_data%60);
	      
	      if(d>0){
	    	  _html = "{0}天{1}时".format(d>9?d:"0"+d,h>9?h:"0"+h);
	      }else{
	    	  if(h>0){
	    		  _html = "{0}时{1}分".format(h>9?h:"0"+h,m>9?m:"0"+m);
	    	  }else{
	    		  if(m>0){
	    			  _html = "{0}分{1}秒".format(m>9?m:"0"+m,s>9?s:"0"+s);
	    		  }else{
	    			  _html = "{0}秒".format(s>9?s:"0"+s);
	    		  }
	    	  }
	      }
	    }
	    return _html;
	}
};

//域名判断备案号
$(function(){
	var url = location.hostname;
	var ip=document.getElementById('icp');
	if(ip!=null){
		if(url.indexOf("devopsteel.cn")>=0){
			ip.innerHTML = "粤ICP备10028739号-8";
		}else {
			ip.innerHTML = "粤ICP备10028739号-1";
		}
	}
});


var laydate = layui.laydate;
var laydateStart = null;
var laydateEnd = null;
/**
 * 日期控件
 * @param startDateId 开始日期id
 * @param endDateId 结束日期id
 */
function setDate(startDateId, endDateId){
    var currentDate = new Date();
    if(laydateStart){
        laydateStart.config.max = {
            year:currentDate.getFullYear(),
            month:currentDate.getMonth(),
            date:currentDate.getDate(),
            hours:0,
            minutes:0,
            second:0
        };

    }else{
        laydateStart = laydate.render({
            elem: "#" + startDateId,
            istime: true, //是否开启时间选择
            istoday: false,
            trigger:'click',
            format: 'yyyy-MM-dd',
            min:'2005-01-01',
            max:new Date().dateFormat("yyyy-MM-dd"),
            ready: function(dates){
                var endDate = $("#end_date").val();
                if(endDate && endDate != "" && typeof(endDate) != 'undefined'){
                    laydateStart.config.max = endDate;
                    endDate = new   Date(Date.parse(endDate.replace(/-/g,   "/")));
                    laydateStart.config.max = {
                        year:endDate.getFullYear(),
                        month:endDate.getMonth(),
                        date:endDate.getDate(),
                        hours:0,
                        minutes:0,
                        second:0
                    };
                }else{
                    var currentDate = new Date();
                    laydateStart.config.max = {
                        year:currentDate.getFullYear(),
                        month:currentDate.getMonth(),
                        date:currentDate.getDate(),
                        hours:0,
                        minutes:0,
                        second:0
                    };

                }
            },
            done:function (value, dates) {
                //配置结束日期的最小值
                laydateEnd.config.min = {
                    year:dates.year,
                    month:dates.month-1,
                    date:dates.date,
                    hours:0,
                    minutes:0,
                    second:0
                };

            }
        });
    }
    if(laydateEnd){
        laydateEnd.config.max = {
            year:currentDate.getFullYear(),
            month:currentDate.getMonth(),
            date:currentDate.getDate(),
            hours:0,
            minutes:0,
            second:0
        };
        laydateEnd.config.min = {
            year:2005,
            month:0,
            date:1,
            hours:0,
            minutes:0,
            second:0
        };

    }else{
        laydateEnd =  laydate.render({
            elem: "#" + endDateId,
            istime: true, //是否开启时间选择
            istoday: false,
            trigger:'click',
            format: 'yyyy-MM-dd',
            min:"2005-01-01",
            max:new Date().dateFormat("yyyy-MM-dd"),
            ready: function(date){
                var startDate = $("#start_date").val();
                if(startDate && startDate != '' && typeof(startDate) != 'undefined' && startDate != null){
                    startDate = new   Date(Date.parse(startDate.replace(/-/g, "/")));
                    laydateEnd.config.min = {
                        year:startDate.getFullYear(),
                        month:startDate.getMonth(),
                        date:startDate.getDate(),
                        hours:0,
                        minutes:0,
                        second:0
                    };
                }else{
                    laydateEnd.config.min = {
                        year:2005,
                        month:0,
                        date:1,
                        hours:0,
                        minutes:0,
                        second:0
                    };
                }

            },
            done:function (value, dates) {
                //配置开始日期的最大值
                laydateStart.config.max = {
                    year:dates.year,
                    month:dates.month-1,
                    date:dates.date,
                    hours:0,
                    minutes:0,
                    second:0
                };

            }
        });
    }
}

