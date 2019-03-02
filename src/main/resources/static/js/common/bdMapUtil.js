;(function (win, func) {
    "use strict";
    var ak = "SKxePqhsNnClIzjoqD5oIBlBAvGPv0Kw";
    //加载百度地图脚本
    var script = window.document.createElement("script");
    script.type = "text/javascript";
    script.src = "http://api.map.baidu.com/api?v=2.0&ak=" + ak + "&callback=__bdmap_init__";
    win["__bdmap_init__"] = function () {
        win.bdMapUtil.action("load");
    };
    win.bdMapUtil = func.apply(win, [
        win,
        //我的工具
        (function (win) {
            return {
                /**
                 * 用于判断是否为true，如果为true执行第一个func，如果为false执行第二个func
                 * @param val
                 * @param trueFunc
                 * @param falseFunc
                 */
                ifTrue: function (val, trueFunc, falseFunc) {
                    if (val && typeof trueFunc == 'function') {
                        trueFunc.apply();
                    } else if (!val && typeof falseFunc === 'function') {
                        falseFunc.apply();
                    }
                },
                /**
                 * 判断是否为数组
                 * @param arr
                 * @returns {boolean}
                 */
                isArray: function (arr) {
                    return Object.prototype.toString.call(arr) === '[object Array]';
                },
                /**
                 * 判断数组或字符串是否为空
                 * @param arr
                 * @returns {*}
                 */
                isEmpty: function (arr) {
                    if (arr == null) return true;
                    if (typeof arr === 'string') {
                        return this.isEmpty(arr.split(""));
                    }
                    if (this.isArray(arr)) {
                        return arr.length == 0;
                    }
                    return undefined;
                },
                /**
                 * 判断是否为布尔值
                 * @param val
                 * @returns {boolean}
                 */
                isBoolean: function (val) {
                    return Object.prototype.toString.call(val) === '[object Boolean]';
                },
                /**
                 * 判断是否为数字
                 * @param num
                 * @returns {boolean}
                 */
                isNumber: function (num) {
                    return Object.prototype.toString.call(num) === '[object Number]';
                },
                isString: function (str) {
                    return Object.prototype.toString.call(str) === "[object String]";
                },
                /**
                 * 判断是否为function
                 * @param func
                 * @returns {boolean}
                 */
                isFunction: function (func) {
                    return Object.prototype.toString.call(func) === '[object Function]';
                },
                /**
                 * 判断是否为普通的object
                 * @param obj
                 * @returns {boolean}
                 */
                isObject: function (obj) {
                    return Object.prototype.toString.call(obj) === '[object Object]';
                },
                /**
                 * 判断是否为html元素
                 * @param dom
                 * @returns {boolean}
                 */
                isHtmlDom: function (dom) {
                    var str = Object.prototype.toString.call(dom);
                    return /\bHTML[a-zA-Z]*Element\b/.test(str);
                },
                /**
                 * 判断是否为html集合
                 * @param col
                 * @returns {boolean}
                 */
                isHtmlColOrList: function (col) {
                    var str = Object.prototype.toString.call(col);
                    return str === "[object HTMLCollection]" || str === "[object NodeList]";
                },
                /**
                 * 遍历数组或字符串
                 * @param arr
                 * @param func
                 * @returns {*}
                 */
                forEach: function (arr, func) {
                    if (typeof func !== 'function') return;
                    if (typeof arr === 'string') {
                        return this.forEach(arr.split(""), func);
                    } else if (this.isArray(arr)) {
                        for (var i = 0; i < arr.length; i++) {
                            var result = func.apply(arr[i], [i
                                //     , {
                                //     isFirst: i === 0,
                                //     isLast: i === arr.length - 1,
                                //     isOdd: i % 2 === 0,
                                //     isEven: i % 2 === 1,
                                //     last: (function () {
                                //         if (i === 0) return undefined;
                                //         else return arr[i - 1]
                                //     })(),
                                //     next: (function () {
                                //         if (i === arr.length - 1) return undefined;
                                //         else return arr[i + 1]
                                //     })()
                                // }
                            ]);
                            if (result !== undefined && result === false) {
                                break;
                            }
                        }
                    }
                },
                /**
                 * 从数组的结尾开始遍历
                 * @param arr
                 * @param func
                 * @returns {*}
                 */
                forEachFromTail: function (arr, func) {
                    if (typeof func !== 'function') return;
                    if (typeof arr === 'string') {
                        return this.forEachFromTail(arr.split(""), func);
                    } else if (this.isArray(arr)) {
                        for (var i = arr.length - 1; i >= 0; i--) {
                            var result = func.apply(arr[i], [i - arr.length + 1]);
                            if (result !== undefined && result == false) {
                                break;
                            }
                        }
                    }
                },
                /**
                 * 如果val为null或underfine返回def
                 * @param val
                 * @param def
                 * @returns {*}
                 */
                nvl: function (val, def) {
                    if (val == null) return def;
                    return val;
                },
                /**
                 * 遍历对象的属性
                 * @param obj 要遍历的对象
                 * @param isDeep 是否将深层的属性也进行遍历
                 * @param func 要执行的函数
                 */
                forEachKey: function (obj, isDeep, func) {
                    if (typeof func !== 'function') return;
                    isDeep = this.nvl(this.getBoolean(isDeep), false);
                    for (var k in obj) {
                        if (isDeep || obj.hasOwnProperty(k)) {
                            this.applyMethod(obj, func, [k, obj[k]]);
                        }
                    }
                },
                /**
                 * 转换成布尔值，可以是字符串的yes/no
                 * @param val
                 * @returns {*}
                 */
                getBoolean: function (val) {
                    if (typeof val === 'boolean') return val;
                    if (typeof val === 'string') {
                        val = val.toLowerCase();
                        if (val === 'yes' || val == 'true') return true;
                        else if (val == 'no' || val == 'false') return false;
                    }
                    return undefined;
                },
                /**
                 * 将参数转换成数组
                 * @param args
                 * @returns {*}
                 */
                argsToArr: function (args) {
                    return this.applyMethod(args, Array.prototype.splice, [0]);
                },
                /**
                 * 调用方法
                 * @param target
                 * @param name 方法名，也可以是函数
                 * @param args
                 * @returns {*}
                 */
                applyMethod: function (target, name, args) {
                    if (typeof name === 'function') {
                        return name.apply(target, args)
                    }
                    if (target && this.isFunction(target[name])) {
                        return target[name].apply(target, args);
                    }
                },
                /**
                 * 调用方法，同applyMethod，但是这个方式的能数写法不同
                 * @param target
                 * @param name 方法名，也可以是函数
                 * @param arg1
                 * @param arg2
                 * @param arg3
                 * @returns {*}
                 */
                callMethod: function (target, name, arg1, arg2, arg3) {
                    var args = Array.prototype.slice.apply(arguments, [2]);
                    return this.applyMethod(target, name, args);
                },
                /**
                 * 创建新的对象，即new的过程
                 * @param constructor
                 * @param args
                 * @returns {*}
                 */
                applyNew: function (constructor, args) {
                    if (typeof constructor !== 'function') return undefined;
                    var result = {};
                    result.__proto__ = constructor.prototype;
                    constructor.apply(result, args);
                    return result;
                },
                /**
                 * 创建新的对象，即new的过程
                 * @param constructor
                 * @param arg1
                 * @param arg2
                 * @returns {*}
                 */
                callNew: function (constructor, arg1, arg2) {
                    var args = Array.prototype.slice.apply(arguments, [1]);
                    return this.applyNew(constructor, args);
                },
                /**
                 * 统计字符串的长度
                 * @param targetStr
                 * @param str
                 * @returns {number}
                 */
                strCount: function (targetStr, str) {
                    if (this.isEmpty(str) || this.isEmpty(targetStr)) return 0;
                    var count = 0;
                    var i;
                    while ((i = targetStr.indexOf(str)) >= 0) {
                        targetStr = targetStr.substr(i + str.length);
                        count++;
                    }
                    return count;
                },
                /**
                 * 模式化数字
                 */
                formatNum: (function () {
                    /**
                     * 在数字前补0
                     * @param num
                     * @param len
                     * @returns {string}
                     */
                    var preFillWithZero = function (num, len) {
                        var str = Math.abs(num).toString();
                        while (len > str.length) {
                            str = "0" + str;
                        }
                        if (num < 0) {
                            str = "-" + str;
                        }
                        return str;
                    };
                    var subFillWithZero = function (num, len) {
                        var numStr = num.toString();
                        if (num.length < len) {
                            while (numStr.length < len) {
                                numStr += '0';
                            }
                        } else {
                            numStr = Math.round(num / (Math.pow(10, numStr.length - len))) + "";
                        }

                        return numStr;
                    };
                    /**
                     * 整数中添加逗号
                     * @param num
                     * @returns {string}
                     */
                    var addComma = function (num) {
                        if (typeof num == 'number') {
                            var numStr = Math.abs(num).toString();
                            var result = "";
                            for (var i = numStr.length - 1; i >= 0; i--) {
                                if ((numStr.length - i) % 3 == 0 && i != 0) {
                                    result = "," + numStr[i] + result;
                                } else {
                                    result = numStr[i] + result;
                                }
                            }
                            if (num < 0) {
                                result = "-" + result;
                            }
                            return result;
                        } else {
                            var result = "";
                            for (var i = num.length - 1; i >= 0; i--) {
                                if ((num.length - i) % 3 == 0 && i != 0 && num[i] != '-') {
                                    result = "," + num[i] + result;
                                } else {
                                    result = num[i] + result;
                                }
                            }
                            return result;
                        }

                    };
                    var results = {};
                    var formatters = {};
                    return function (num, formatString) {
                        var key = "num:" + num + ";formatString:" + formatString;
                        if (results[key] === undefined) {
                            var formatter = formatters[formatString];
                            if (!formatter) {
                                formatter = formatters[formatString] = {};
                                formatter.decimalFillZero = false;    //小数是否要补0
                                formatter.integerFillZero = false;    //整数是否要在前面补0
                                formatter.useComma = false;           //整数是否要使用逗号分开
                                formatter.decimalLen = 0;             //小数的位数
                                formatter.integerLen = 0;             //整数的位数
                                formatter.integerFixLen = 0;          //整数四写五入到第几位
                                if (formatString.indexOf('.') > 0) {
                                    formatter.decimalLen = formatString.length - formatString.indexOf(".") - 1;
                                    formatter.integerLen = formatString.indexOf(".");
                                    formatter.integerLen -= this.strCount(formatString.substr(0, formatter.integerLen), ",");
                                    if (formatString.indexOf(",") != -1 && formatString.indexOf(",") < formatString.indexOf(".")) {
                                        formatter.useComma = true;
                                    }
                                    if (formatString[0] == '0') formatter.integerFillZero = true;
                                    if (formatString[formatString.length - 1] == 0) formatter.decimalFillZero = true;
                                } else {
                                    formatter.integerLen = formatString.length - this.strCount(formatString, ",");
                                    if (formatString.indexOf(",") != -1) {
                                        formatter.useComma = true;
                                    }
                                    if (formatString[0] == '0') {
                                        formatter.integerFillZero = true;
                                    }
                                    if (formatString.indexOf('#' >= 0)) {
                                        this.forEachFromTail(formatString, function () {
                                            if (this == '0') {
                                                formatter.integerFixLen++;
                                            } else {
                                                return false;
                                            }
                                        });
                                    }
                                }
                            }
                            var strNum = num.toString();
                            var result;
                            if (formatter.decimalLen == 0) {
                                result = Math.round(Math.abs(num));
                            } else {
                                result = Math.floor(Math.abs(num));
                            }
                            //整数四写五入
                            if (formatter.integerFixLen > 0) {
                                result = Math.round(Number(result) / Math.pow(10, formatter.integerFixLen)) * Math.pow(10, formatter.integerFixLen);
                            }
                            //在前面补0
                            if (formatter.integerFillZero) {
                                result = preFillWithZero(result, formatter.integerLen);
                            }
                            //使用逗号
                            if (formatter.useComma) {
                                result = addComma(result);
                            }
                            //小数部分
                            if (formatter.decimalLen > 0) {
                                if (strNum.indexOf('.') >= 0) {
                                    if (formatter.decimalFillZero) {
                                        result += "." + subFillWithZero(strNum.substr(strNum.indexOf('.') + 1), formatter.decimalLen);
                                    } else {
                                        result += "." + strNum.substr(strNum.indexOf('.') + 1);
                                    }
                                } else {
                                    result += "." + subFillWithZero('', formatter.decimalLen);
                                }
                            }
                            if (num < 0) {
                                result = '-' + result;
                            }
                            results[key] = result;
                        }
                        return results[key];
                    }
                })(),
                /**
                 * 类似于$.extend()
                 * @returns {*}
                 */
                extend: function () {
                    var args = this.argsToArr(arguments);
                    if (args[0] == null) args[0] = {};
                    var isDeepCopy = false;
                    if (this.isBoolean(args[0])) {
                        isDeepCopy = args[0];
                        args = args.splice(1);
                    } else {
                        //回调本方法
                        return this.applyMethod(this, this.extend, [false].concat(args));
                    }
                    var result = args[0] == null ? {} : args[0];
                    var that = this;
                    for (var i = 1; i < args.length; i++) {
                        this.forEachKey(args[i], true, function (key, val) {
                            if (val === undefined) return;
                            if (val === null && result[key] === undefined) {
                                result[key] = null;
                                return;
                            }
                            if (isDeepCopy && that.isObject(val)) {
                                if (result[key] == null) {
                                    result[key] = that.extend(isDeepCopy, {}, val);
                                } else {
                                    result[key] = that.extend(isDeepCopy, result[key], val);
                                }
                            } else {
                                result[key] = val;
                            }
                        });
                    }
                    return result;
                },
                /**
                 * 给一个对象以事件驱动
                 */
                eventAble: (function () {
                    //事件对象
                    var FuncObj = function (target, func, args) {
                        this.target = target;
                        this.job = func;
                        this.args = args;
                        var that = this;
                        this.do = function (args) {
                            var util = this;
                            if (typeof that.job === 'function') {
                                return that.job.apply(that.target, [util.extend(true, {}, that, that.args, args)]);
                            }
                        };
                    };
                    //
                    var objAddEventControl = function (target) {
                        var on = {};
                        var util = this;
                        /**
                         * 注册事件
                         * @param name  事件名
                         * @param func  要调用的方法
                         * @param args  默认的参数对象
                         */
                        target.on = function (name, func, args) {
                            if (!on[name]) {
                                on[name] = [];
                            }
                            on[name].push(new FuncObj(target, func, args));
                            return target;
                        };
                        /**
                         * 执行这个方法以触发事件
                         * @param name  事件名
                         * @param args  要传递的参数
                         * @param callback  每当执行一个事件方法后执行，参数为方法返回的结果
                         */
                        target.action = function (name, args, callback) {
                            if (!name) return;
                            if (!args) args = [];
                            util.forEach(on[name], function () {
                                var result = this.do.apply(util, [{
                                    args: args,
                                    eventArgs: util.extend({
                                        name: name
                                    }, this.args)
                                }]);
                                if (typeof callback === 'function') {
                                    util.applyMethod(name, callback, [result]);
                                }
                            });
                            return target;
                        }
                    };
                    return function (target) {
                        // that=this;
                        if (target == null) return;
                        this.applyMethod(this, objAddEventControl, [target]);
                        return target;
                    }
                })(),
                /**
                 * 选择或创建元素
                 */
                selectElement: function (el) {
                    var util = this;
                    if (util.isString(el)) {
                        try {
                            return win.document.querySelectorAll(el);
                        } catch (e) {
                            var tmpDiv = win.document.createElement("div");
                            tmpDiv.innerHTML = el;
                            return tmpDiv.children[0];
                        }
                    }
                },
                /////////////////以下方法主要用于前端生成一些对象
                /**
                 * 创建一个弹出标签
                 */
                createLabel: (function () {
                    var defArgs = {
                        text: "标签",
                        fontSize: 11,
                        color: "#000000",
                        pointOffset: 0,
                        padding: "0px"
                    };
                    return function (args) {
                        args = this.extend({}, defArgs, args);
                        var html = "<div style=\"background: white;padding: " + args.padding + ";margin: 0px;position: absolute;box-shadow: 1px 1px 2px #5d5b5b;border-radius: 4px;text-align: center;\">\n" +
                            "    <span style='color: " + args.color + "; font-size: " + args.fontSize + "px;'>" + args.text + "</span>\n" +
                            "    <i style=\"display: block;position: absolute;margin: 0px;padding: 0px;left: " + args.pointOffset + "px;float: left;bottom: -8px;\">\n" +
                            "        <svg version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" x=\"0px\" y=\"0px\"\n" +
                            "             width=\"9px\" height=\"5px\" viewBox=\"0 0 9 5\" enable-background=\"new 0 0 9 5\" xml:space=\"preserve\">\n" +
                            "        <line fill=\"none\" stroke=\"#808184\" x1=\"9.199\" y1=\"2.207\" x2=\"4.7\" y2=\"5.206\"/>\n" +
                            "        <rect fill=\"#FFFFFF\" width=\"9\" height=\"2\"/>\n" +
                            "        <polygon fill=\"#FFFFFF\" points=\"9,1.999 4.5,5 0,1.999 \"/>\n" +
                            "        </svg>\n" +
                            "    </i>\n" +
                            "</div>";
                        return this.selectElement(html);
                    }
                })(),
                /**
                 * 创建一个标记
                 */
                createMarker: (function () {
                    var defArgs = {
                        num: 0,  //数字部分的内容
                        text: "文字",
                        // fontSize:11,
                        color: "#339933",   //背景及白色部分文字颜色
                        activeColor: undefined
                    };
                    return function (args) {
                        args = this.extend({}, defArgs, args);
                        args.text = args.text.substr(0, 3);
                        var html = "<svg version=\"1.1\" id=\"图层_1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" x=\"0px\" y=\"0px\"\n" +
                            "\t width=\"87.619px\" height=\"39.292px\" viewBox=\"0 0 87.619 39.292\" enable-background=\"new 0 0 87.619 39.292\" xml:space=\"preserve\">\n" +
                            "<path fill=\"#BBBDBF\" d=\"M16.14,37.382\"/>\n" +
                            "<path fill=\"#BBBDBF\" d=\"M7.057,18.938c0,8.073,3.465,14.619,13.01,14.619h53.066c9.543,0,14.486-6.546,14.486-14.619l0,0\n" +
                            "\tc0-8.083-4.943-14.627-14.486-14.627H24.338C14.793,4.311,7.057,10.856,7.057,18.938L7.057,18.938z\"/>\n" +
                            "<path fill=\"#FFFFFF\" d=\"M7.054,17.675c0,8.074,4.384,14.621,13.929,14.621h52.148c9.543,0,14.486-6.547,14.486-14.621l0,0\n" +
                            "\tc0-8.075-4.943-14.621-14.486-14.621H20.694C11.15,3.055,7.054,9.601,7.054,17.675L7.054,17.675z\"/>\n" +
                            "<ellipse fill=\"#BBBDBF\" cx=\"14.728\" cy=\"37.062\" rx=\"5.811\" ry=\"2.23\"/>\n" +
                            "<path class='drop' fill=\"" + args.color + "\" d=\"M29.456,16.169c0,8.988-14.729,20.892-14.729,20.892S0,25.157,0,16.169S6.593-0.105,14.728-0.105\n" +
                            "\tC22.861-0.105,29.456,7.181,29.456,16.169z\"/>";
                        if (args.num < 10) {
                            html += "<text transform=\"matrix(1 0 0 1 11.2622 22.0879)\" fill=\"#FFFFFF\" font-family=\"'MicrosoftYaHei'\" font-size=\"14\">" + args.num + "</text>";
                        } else if (args.num < 100) {
                            html += "<text transform=\"matrix(1 0 0 1 7.0542 22.4209)\" fill=\"#FFFFFF\" font-family=\"'MicrosoftYaHei'\" font-size=\"14\">" + args.num + "</text>";
                        } else if (args.num > 99) {
                            html += "<text transform=\"matrix(1 0 0 1 6.1543 19.6455)\" fill=\"#FFFFFF\" font-family=\"'MicrosoftYaHei'\" font-size=\"11\">99+</text>";
                        }
                        html += "<text class='text' transform=\"matrix(1 0 0 1 35.2295 21.7549)\" fill=\"" + args.color + "\" font-family=\"'MicrosoftYaHei'\" font-size=\"14\">" + args.text + "</text>";
                        var el = this.selectElement(html);
                        if (args.activeColor) {
                            var drop = el.querySelector(".drop");
                            var text = el.querySelector(".text")
                            el.addEventListener("mouseover", function () {
                                drop.attributes.fill.value = args.activeColor;
                                text.attributes.fill.value = args.activeColor;
                            });
                            el.addEventListener("mouseout", function () {
                                drop.attributes.fill.value = args.color;
                                text.attributes.fill.value = args.color;
                            })
                        }
                        return el;
                    }
                })(),
                /**
                 * 用于测试我的工具
                 * @param str
                 * @returns {boolean}
                 */
                test: function (str) {
                    console.log(str);
                    return true;
                }
            }
        })(win)
    ]);
    win.addEventListener("load",function(){
        win.bdMapUtil.action("preload");
        win.document.head.appendChild(script);
    });
})(window, function (win, utils) {
    var bdUtil = utils.eventAble({
        /**
         * 创建一个点
         * @param lng 径度或一个包含lng和lat的对象
         * @param lat 纬度
         * @returns {BMap.Point}
         */
        createPoint: function (lng, lat) {
            if (utils.isNumber(lng) && utils.isNumber(lat)) {
                return new BMap.Point(lng, lat);
            } else if (utils.isObject(lng)) {
                if (utils.isNumber(lng.lng) && utils.isNumber(lng.lat)) {
                    return new BMap.Point(lng.lng, lng.lat);
                }
            }
            throw new {
                msg: '创建Point时出错，参数错误'
            }
        },
        //创建一个map对象
        createMap: (function () {
            var defArgs = {
                el: "body",                 //放地图的元素，可以是元素或选择器
                markers: undefined,
                center: undefined,           //地图的中心，如果不设置默认自动获取
                map: {
                    enableScrollWheelZoom: true  //是否启用滚轮

                },
                controls: {
                    navigation: {        //平移缩放控件,具体设置请参考：http://lbsyun.baidu.com/cms/jsapi/reference/jsapi_reference.html#a2b3
                        show: false,
                        controlName: "NavigationControl",
                        anchor: undefined,
                        offset: undefined,
                        type: undefined,
                        showZoomInfo: false,      //是否显示级别提示信息
                        enableGeolocation: false     //控件是否集成定位功能，默认为false
                    },
                    geolocation: {       //责进行地图定位的控件,具体设置请参考：http://lbsyun.baidu.com/cms/jsapi/reference/jsapi_reference.html#a2b6
                        show: false,
                        controlName: "GeolocationControl",
                        anchor: undefined,
                        offset: undefined,
                        showAddressBar: true,         //是否显示定位信息面板。默认显示定位信息面板
                        enableAutoLocation: false,       //添加控件时是否进行定位。默认添加控件时不进行定位
                        locationIcon: undefined          //可自定义定位中心点的Icon样式
                    },
                    overviewMap: {               //缩略地图控件,http://lbsyun.baidu.com/cms/jsapi/reference/jsapi_reference.html#a2b7
                        show: false,
                        controlName: "OverviewMapControl",
                        anchor: undefined,       //控件的停靠位置
                        offset: undefined,       //控件的偏移值
                        size: undefined,          //缩略地图控件的大小
                        isOpen: false            //缩略地图添加到地图后的开合状态，默认为关闭
                    },
                    scale: {                     //比例尺控件:http://lbsyun.baidu.com/cms/jsapi/reference/jsapi_reference.html#a2b9
                        show: false,
                        controlName: "ScaleControl",
                        anchor: undefined,       //控件的停靠位置
                        offset: undefined       //控件的偏移值
                    },
                    copyright: {                 //版权控件:http://lbsyun.baidu.com/cms/jsapi/reference/jsapi_reference.html#a2b12
                        show: false,
                        controlName: "CopyrightControl",
                        anchor: undefined,
                        offset: undefined
                    },
                    mapType: {               //切换地图类型的控件:http://lbsyun.baidu.com/cms/jsapi/reference/jsapi_reference.html#a2b15
                        show: false,
                        controlName: "MapTypeControl",
                        type: undefined,          //控件样式
                        mapTypes: undefined      //控件展示的地图类型，默认为普通图、卫星图、卫星加路网混合图和三维图。通过此属性可配置控件展示的地图类型
                    },
                    panorama: {              //切换至全景地图的控件:http://lbsyun.baidu.com/cms/jsapi/reference/jsapi_reference.html#a2b18
                        show: false,
                        controlName: "PanoramaControl"
                    }
                }
            };
            return function (args) {
                var that = this;
                var mapHandle = utils.eventAble(utils.extend(true, {}, defArgs, args));
                //放百度地图的元素
                var el = win.document.querySelector(mapHandle.el);
                if (el == null) return; //如果没有这个元素就不再继续
                //百度地图对象
                var map = new BMap.Map(el);
                var getReady = function () {
                    mapHandle.isReady = true;//更新状态
                    mapHandle.action("ready");
                };
                //调试用：
                // win.map=map;
                /////////////////
                //设置中心位置
                if (!mapHandle.center) {
                    //获取浏览器的ip地址，如果失败就使用默认的地址
                    this.getLocalCity(function (result) {
                        //这句是初始化必须执行的
                        map.centerAndZoom(result.center, result.level);
                        getReady();
                    });
                } else {
                    if (mapHandle.center.addr) {
                        bdUtil.createPointByAddr(mapHandle.center.addr, function (point) {
                            console.log(arguments);
                            map.centerAndZoom(point, utils.isNumber(mapHandle.center.zoom) ? mapHandle.center.zoom : 13);
                            getReady();
                        });
                    } else if (utils.isNumber(mapHandle.center.lng) && utils.isNumber(mapHandle.center.lat)) {
                        map.centerAndZoom(bdUtil.createPoint(mapHandle.center.lng, mapHandle.center.lat),
                            utils.isNumber(mapHandle.center.zoom) ? mapHandle.center.zoom : 13);
                        getReady();
                    } else {
                        //获取浏览器的ip地址，如果失败就使用默认的地址
                        this.getLocalCity(function (result) {
                            //这句是初始化必须执行的
                            map.centerAndZoom(result.center, result.level);
                            getReady();
                        });
                    }
                }

                //map的所有方法
                var mapFunctions = {};
                //map的事件名
                var events = {};
                //初始化map的所有方法
                utils.forEach([
                    "enableDragging",
                    "disableDragging",
                    "enableScrollWheelZoom",
                    "disableScrollWheelZoom",
                    "enableDoubleClickZoom",
                    "disableDoubleClickZoom",
                    "enableKeyboard",
                    "disableKeyboard",
                    "enableInertialDragging",
                    "disableInertialDragging",
                    "enableContinuousZoom",
                    "disableContinuousZoom",
                    "enablePinchToZoom",
                    "disablePinchToZoom",
                    "enableAutoResize",
                    "disableAutoResize",
                    "setDefaultCursor",
                    "getDefaultCursor",
                    "setDraggingCursor",
                    "getDraggingCursor",
                    "setMinZoom",
                    "setMaxZoom",
                    "setMapStyle",
                    "setPanorama",
                    "getBounds",
                    "getCenter",
                    "getDistance",
                    "getMapType",
                    "getSize",
                    "getViewport",
                    "getZoom",
                    "getPanorama",
                    "centerAndZoom",
                    "panTo",
                    "panBy",
                    "reset",
                    "setCenter",
                    "setCurrentCity",
                    "setMapType",
                    "setViewport",
                    "setZoom",
                    "highResolutionEnabled",
                    "zoomIn",
                    "zoomOut",
                    "addHotspot",
                    "removeHotspot",
                    "clearHotspots",
                    "addControl",
                    "removeControl",
                    "getContainer",
                    "addContextMenu",
                    "removeContextMenu",
                    "addOverlay",
                    "removeOverlay",
                    "clearOverlays",
                    "openInfoWindow",
                    "closeInfoWindow",
                    "pointToOverlayPixel",
                    "overlayPixelToPoint",
                    "getInfoWindow",
                    "getOverlays",
                    "getPanes",
                    "addTileLayer",
                    "removeTileLayer",
                    "getTileLayer",
                    "pixelToPoint",
                    "pointToPixel"

                ], function () {
                    var name = this.toString();
                    mapFunctions[name] = function () {
                        var result = utils.applyMethod(map, name, arguments);
                        if (result) return result;
                        return mapHandle;
                    }
                });
                //初始化map的事件方法
                utils.forEach([
                    "click",
                    "dblclick",
                    "rightclick",
                    "rightdblclick",
                    "maptypechange",
                    "mousemove",
                    "mouseover",
                    "mouseout",
                    "movestart",
                    "moving",
                    "moveend",
                    "zoomstart",
                    "zoomend",
                    "addoverlay",
                    "addcontrol",
                    "removecontrol",
                    "removeoverlay",
                    "clearoverlays",
                    "dragstart",
                    "dragging",
                    "dragend",
                    "addtilelayer",
                    "removetilelayer",
                    "load",
                    "resize",
                    "hotspotclick",
                    "hotspotover",
                    "hotspotout",
                    "tilesloaded",
                    "touchstart",
                    "touchmove",
                    "touchend",
                    "longpress"], function () {
                    var name = this.toString();
                    events[name] = function (func) {
                        mapHandle.on(name, func);
                        return mapHandle;
                    }
                    utils.applyMethod(map, "addEventListener", [name, function () {
                        mapHandle.action(name, arguments);
                    }]);
                });
                utils.extend(mapHandle, {
                    //初始化
                    init: function () {
                        if (this.map.enableScrollWheelZoom) {
                            map.enableScrollWheelZoom();
                        }
                        return mapHandle;
                    }
                }, mapFunctions, events);

                //当前地图准备好后执行
                mapHandle.on("ready", function () {
                    utils.extend(this, {
                        /**
                         * 设置中心点
                         * @param point
                         */
                        setCenter: function (point) {
                            map.setCenter(point);
                        },
                        /**
                         * 添加一上标记
                         * @param marker
                         */
                        addMarker: function (marker) {
                            map.addOverlay(marker);
                            return marker;
                        },
                        /**
                         * 通过一个点添加标记
                         * @param point
                         */
                        addMarkerByPoint: function (point) {
                            var marker = new BMap.Marker(point);

                            return this.addMarker(marker);
                        },
                        //添加自定义的标记
                        addSpecialMarker: function (args) {
                            var myMarker = bdUtil.createSpecialMarker(args);
                            this.addMarker(myMarker);
                        },
                        /**
                         * 刷新标记物
                         * @returns {*}
                         */
                        refreshMarkers: function (markers) {
                            if (utils.isArray(markers)) this.markers = markers;
                            var that = this;
                            map.clearOverlays();
                            if (!utils.isEmpty(this.markers)) {
                                var pointArr = [];
                                var refreshCenter = function () {
                                    if (pointArr.length == that.markers.length) {
                                        bdUtil.getCenter(pointArr, function (centerPoint) {
                                            mapHandle.setCenter(centerPoint);
                                            autoZoom();
                                            //console.log("OK!!!!");
                                        });
                                    }
                                };
                                var autoZoom = function () {
                                    //zoom的范围为3到18
                                    var i = 18;
                                    mapHandle.setZoom(i);
                                    while (!bdUtil.boundsContailsAllPoints(mapHandle.getBounds(), pointArr) && i > 2) {
                                        i--;
                                        mapHandle.setZoom(i);
                                    }
                                    mapHandle.zoomOut();
                                }
                                utils.forEach(this.markers, function (idx) {
                                    var point = utils.eventAble(this.point);
                                    var marker = this;
                                    if (point.addr) {
                                        bdUtil.geocodeSearch(point.addr, function (p) {
                                            utils.extend(point, p);
                                            point.action("ready");
                                        });
                                    } else if (point.lng != null && point.lat != null) {
                                        bdUtil.getLocation(point, function (rs) {
                                            point.addr = rs.address;
                                            utils.extend(point, rs.point);
                                            point.action("ready");
                                        });
                                    }
                                    point.on("ready", function () {
                                        // that.addMarkerByPoint(point);
                                        // console.log(that.addMarkerByPoint(point));
                                        that.addSpecialMarker(marker);
                                        pointArr.push(point);
                                        refreshCenter();
                                    });
                                })
                            }
                            return mapHandle;
                        }
                    }).refreshMarkers();
                    //设置所有控件
                    utils.forEachKey(mapHandle.controls, false, function (key, control) {
                        if (control.show) {
                            var objControl = new BMap[control.controlName](control);
                            map.addControl(objControl);
                        }
                    });
                });
                return mapHandle.init();
            }
        })(),
        /**
         * 创建一个默认的普通的标记
         * @param point
         * @returns {BMap.Marker}
         */
        createMarker: function (point) {
            return new BMap.Marker(point);
        },
        /**
         * 创建一个点数组
         * @param points 点数组
         */
        createPoints: function (points, callback) {
            var pointObj = [];
            var bdUtil = this;
            var finish = (function () {
                var count = 0;
                return function () {
                    count++;
                    if (count == points.length) {
                        utils.applyMethod(null, callback, [pointObj]);
                    }
                }
            })();
            utils.forEach(points, function () {
                if (this.addr) {
                    bdUtil.createPointByAddr(this.addr, function (point) {
                        if (point) {
                            pointObj.push(point);
                        }
                        finish();
                    });
                } else {
                    if (utils.isNumber(this.lng) && utils.isNumber(this.lat)) {
                        pointObj.push(bdUtil.createPoint(this));
                    }
                    finish();
                }
            });
        },
        /**
         * 获得所有点的中心
         * @param points 点的数组
         * @param callback 回调函数
         */
        getCenter: function (points, callback) {
            var bdUtil = this;
            bdUtil.createPoints(points, function (pointArr) {
                if (!utils.isArray(pointArr) || pointArr.length == 0) {
                    return;
                }
                var X = 0, Y = 0, Z = 0;
                utils.forEach(pointArr, function () {
                    var lat = this.lat * Math.PI / 180;
                    var lng = this.lng * Math.PI / 180;
                    X += Math.cos(lat) * Math.cos(lng);
                    Y += Math.cos(lat) * Math.sin(lng);
                    Z += Math.sin(lat);
                });
                X /= pointArr.length;
                Y /= pointArr.length;
                Z /= pointArr.length;
                var lng = Math.atan2(Y, X);
                var hpy = Math.sqrt(X * X + Y * Y);
                var lat = Math.atan2(Z, hpy);
                if (utils.isFunction(callback)) {
                    utils.applyMethod(null, callback, [bdUtil.createPoint(lng * 180 / Math.PI, lat * 180 / Math.PI)]);
                }
            });
        },
        /**
         * 判断点是否在范围对象中
         * @param bounds 范围对象
         * @param point 点
         * @returns {*}
         */
        boundsContainsPoint: function (bounds, point) {
            return utils.applyMethod(bounds, BMap.Bounds.prototype.containsPoint, [point]);
        },
        /**
         * 判断一个范围内是否包含了所有的点
         * @param bounds
         * @param pointArr
         */
        boundsContailsAllPoints: function (bounds, pointArr) {
            if (!utils.isArray(pointArr) || !pointArr.length) return false;
            var result = true;
            var bdUtil = this;
            utils.forEach(pointArr, function () {
                try {
                    if (!bdUtil.boundsContainsPoint(bounds, bdUtil.createPoint(this))) {
                        result = false;
                        return false;
                    }
                } catch (e) {
                    result = false;
                    console.error(e);
                    return false;
                }

            });
            return result;
        }

    }).on("load", function () {
        /**
         * 获取地址的解释结果，一共有两个参数，第一个参数为地址，即详细的地址，第二个参数为回调函数，当成功返回时调用
         */
        this.geocodeSearch = (function () {
            var myGeo = new BMap.Geocoder();
            var getPoint = function (addr, callback) {
                myGeo.getPoint(addr, callback);
            }
            return function (address, callback) {
                if (utils.isArray(address)) {
                    var result = [];
                    utils.forEach(address, function (idx) {
                        getPoint(this, function (point) {
                            result[idx] = point;
                            if (idx == address.length - 1 && typeof callback === 'function') {
                                utils.applyMethod(null, callback, [result]);
                            }
                        })
                    })
                } else {
                    getPoint(address, callback);
                }
            }
        })();
        //通过地址来获取点，参数同geocodeSearch
        this.createPointByAddr = this.geocodeSearch;
        /**
         * 获取当前位置
         */
        this.getLocation = (function () {
            var myGeo = new BMap.Geocoder();
            return function (point, callback) {
                myGeo.getLocation(this.createPoint(point.lng, point.lat), callback);
            }
        })();
        /**
         * 通过浏览器的ip地址来获取位置
         */
        this.getCurrentPosition = (function () {
            var geolocation = new BMap.Geolocation();
            return function (success, fail) {
                geolocation.getCurrentPosition(function (r) {
                    if (this.getStatus() == BMAP_STATUS_SUCCESS) {
                        if (typeof success === 'function') {
                            // console.log(arguments)
                            utils.applyMethod(null, success, [r.point]);
                        }
                    } else {
                        if (typeof fail === 'function') {
                            utils.applyMethod(null, fail, [this.getStatus(),
                                (function (status) {
                                    switch (status) {
                                        case BMAP_STATUS_CITY_LIST:
                                            return "城市列表";
                                        case BMAP_STATUS_UNKNOWN_LOCATION:
                                            return "位置结果未知";
                                        case BMAP_STATUS_UNKNOWN_ROUTE:
                                            return "导航结果未知";
                                        case BMAP_STATUS_INVALID_KEY:
                                            return "非法密钥";
                                        case BMAP_STATUS_INVALID_REQUEST:
                                            return "非法请求";
                                        case BMAP_STATUS_PERMISSION_DENIED:
                                            return "没有权限";
                                        case BMAP_STATUS_SERVICE_UNAVAILABLE:
                                            return "服务不可用";
                                        case BMAP_STATUS_TIMEOUT:
                                            return "请求超时";
                                    }
                                })(this.getStatus())
                            ])
                        }
                    }
                });
            }
        })();
        /**
         * 获得当前的城市
         */
        this.getLocalCity = (function () {
            var myCity = new BMap.LocalCity();
            return function (callback) {
                myCity.get(callback);
            }
        })();
        /**
         * 创建一个自定义的覆盖物
         */
        this.createSpecialMarker = (function () {
            var defArgs = {
                el: undefined,
                point: new BMap.Point(0, 0),
                offset: {    //偏移的像素值
                    x: 0,
                    y: 0
                },
                label: undefined,     //当鼠标在覆盖物上时显示的信息
                content: {       //在标签中显示的内容
                    text: "",
                    num: 0
                },
                events: {}       //需要绑定的事件
            };
            var SpecialMarker = function (args) {
                args = utils.extend(true, {}, defArgs, args);
                var point = args.point;     //标记所使用的点
                var el = args.el;           //标记对象
                var label;      //要显示的标签，需要设置label
                // console.log("new")
                var map = undefined;        //被绑定的map
                //初始化el
                el = utils.selectElement(el);
                if (utils.isHtmlColOrList(el)) {
                    el = el[0];
                }
                if (el == null) {
                    el = utils.selectElement("<div style='cursor: pointer;'></div>");
                    el.appendChild(utils.createMarker(args.content));
                    args.offset.x = -10;
                    args.offset.y = -52;
                }
                //初始化label
                if (args.label) {
                    var fontSize = 11;
                    var len = args.label.length;
                    label = utils.createLabel({
                        text: args.label,
                        padding: "2px 5px",
                        pointOffset: Math.round((fontSize * len + 20) / 2)
                    });
                    label.style.display = "none";
                    label.style.width = fontSize * len + 20 + "px";
                    label.style.left = -(fontSize * len + 20) / 2 + 10 + "px";
                    // label.style.bottom = -args.offset.y + "px"
                    el.appendChild(label);
                    el.addEventListener("mouseover", function () {
                        label.style.bottom = el.offsetHeight + 8 + "px";
                        label.style.display = "block";
                    });
                    el.addEventListener("mouseout", function () {
                        label.style.display = "none";
                    });
                }
                //绑定事件
                utils.forEachKey(args.events, false, function (key, val) {
                    el.addEventListener(key, function () {
                        if (utils.isFunction(val)) {
                            utils.applyMethod(el, val, [key, args]);
                        }
                    });
                })
                //抽象方法，当地图状态发生变化时，由系统调用对覆盖物进行绘制。自定义覆盖物需要实现此方法
                this.draw = function () {
                    el.style.position = "absolute";   //必须设置成absolute
                    var offsetWidth = el.offsetWidth;
                    var offsetHeight = el.offsetHeight;
                    var pixel = map.pointToOverlayPixel(point);
                    el.style.left = pixel.x + args.offset.x + "px";
                    el.style.top = pixel.y + args.offset.y + "px";
                };
                //抽象方法，用于初始化覆盖物，当调用map.addOverlay时，API将调用此方法。自定义覆盖物时需要实现此方法。自定义覆盖物时需要将覆盖物对应的HTML元素返回
                this.initialize = function (mp) {
                    map = mp;
                    mp.getPanes().markerPane.appendChild(el);
                    return el;
                }
            };
            SpecialMarker.prototype = BMap.Overlay.prototype;
            return function (args) {

                return new SpecialMarker(args);
            };
        })()
    });
    return bdUtil;
});
//一个默认的设置
var __defMapConfig__ = {
    el: "#bdMap",
    controls: {
        navigation: {
            show: true,
            type: 3 //BMAP_NAVIGATION_CONTROL_ZOOM
        },
        scale: {
            show: true
        }
    }
    //center:{} 设置地图的中心
};
(function (bdUtil, win) {
    var mapConfig = win["mapConfig"] || {};
    for (var key in __defMapConfig__) {
        if (!mapConfig[key]) {
            mapConfig[key] = __defMapConfig__[key];
        }
    }
    var pool = [];
    var isReady = false;
    bdUtil.on("load", function () {
        win.mapHandle = bdUtil.createMap(mapConfig);
        win.mapHandle.on("ready", function () {
            isReady = true;
            if (pool.length) {
                for (var i = 0; i < pool.length; i++) {
                    var job = pool[i];
                    if (job.name) {
                        mapHandle[job.name].apply(mapHandle, job.args);
                    }
                }
            }
        });
    });

    win.refreshMarkers = (function () {
        return function (markers) {
            if (win.mapHandle) {
                win.mapHandle.refreshMarkers(markers);
            } else {
                pool.push({
                    name: "refreshMarkers",
                    args: [markers]
                })
            }
        }
    })();
    /**
     * 通过一个点来创建标记
     * point：一个表示点的对象，这个对象有两个属性：lng,lat。lng和lat分别是经度和纬度，point也可以是string,表示一个详细地址名
     * args:参数，包含label及content，点击事件的参数
     *      label是一个标签，而content是一个对象，
     *      content对象应该设置num和text这两个属性，
     *      num表示在水滴中显示的数字，
     *      text表示在白条中显示的文字（最多只能显示三个字符），
     *      color和activeColor是可选的，,也可以放其它的属性，这些
     */
    win.createMarker = (function () {
        var defArgs = {
            label: "",
            content: {
                num: 0,              //表示在水滴中显示的数字
                text: "",            //表示在白条中显示的文字（最多只能显示三个字符）
                color: undefined,    //默认显示的属性
                activeColor: undefined   //当鼠标中上面时显示的颜色
            }
        }

        return function (point, args, clickEvent) {
            if (typeof point === 'string') {
                point = {
                    addr: point
                }
            } else if (!point.lng) {
                throw new {
                    msg: "createMarker：请设置第一个参数的经度(lng)属性"
                }
            } else if (!point.lat) {
                throw new {
                    msg: "createMarker：请设置第一个参数的纬度(lat)属性"
                }
            }
            var myArgs = {};
            for (var key in defArgs) {
                myArgs[key] = args[key] || defArgs[key];
            }
            return {
                point: point,
                content: myArgs.content,
                label: myArgs.label,
                events: {
                    click: function (event, argsInfo) {
                        if (typeof clickEvent === 'function') {
                            clickEvent.apply(null, [argsInfo.content]);
                        }
                    }
                }
            }
        }
    })();
})(bdMapUtil, this);