/**
 * 收集查询条件
 */

(function($){

    var _cache = {}
    function cache(key, value) {
        if (value === undefined) {
            return cache[key];
        }
        cache[key] = value;
    }

    var _id = 0;
    function get_id(){
        _id ++;
        return 'q'+_id;
    }

    function is_empty(val) {
        return val == '' || val == null || val == {} || val == [] || val == undefined
    }

    /**
     * 获取参数
     */
    function get_params(filter_list){
        var param = {};
        for (var i=0;i<filter_list.length;i++) {
            var v = filter_list[i];
            if (param[v.key] === undefined) {
                param[v.key] = [];
            }
            if (v.type == '4') {
                param[v.key] = v.val;
            }else{
                param[v.key].push(v.val);
            }
        }
        return param;
    }

    /**
     * 收集查询参数
     */
    function Q(filter_list, fn){
        var self = this;

        self.filters = filter_list;

        self.add = function(obj, isNoRender, isNoRun){
            self.filters.push(obj);
            !isNoRender && self.render();
            !isNoRun && self.run();
        };

        self.get_params = function(){
            return get_params(self.filters)
        }

        self.get_filters = function(){
            return self.filters;
        }

        self.run = function(){
            fn(get_params(self.filters), self.filters);
        }

        self.update = function(key, obj, isNoRender, isNoRun){
            for (var i=0;i<self.filters.length;i++) {
                var v = self.filters[i];
                if (v.key == key) {
                    v.name = obj.name;
                    v.val = obj.val;
                }
            }
            !isNoRender && self.render();
            !isNoRun && self.run();
        };

        self.removekey = function(key, isNoRender, isNoRun){
            var l = [];
            for (var i=0;i<self.filters.length;i++) {
                var v = self.filters[i];
                if (v.key != key) {
                    l.push(v);
                }
            }
            self.filters = l;
            !isNoRender && self.render();
            !isNoRun && self.run();
        };

        self.removefilterbykey = function(key){
            var l = [];
            for (var i=0;i<self.filters.length;i++) {
                var v = self.filters[i];
                if (v.key != key) {
                    l.push(v);
                }
            }
            self.filters = l;
        };

        self.removeval = function(obj, isNoRender, isNoRun){
            var l = [];
            for (var i=0;i<self.filters.length;i++) {
                var v = self.filters[i];
                if (!(v.key == obj.key && v.val == obj.val)) {
                    l.push(v);
                }
            }
            self.filters = l;
            !isNoRender && self.render();
            !isNoRun && self.run();
        };

        self.has = function(key){
            for (var i=0;i<self.filters.length;i++) {
                var v = self.filters[i];
                if (v.key == key) {
                    return true;
                }
            }
            return false;
        };

        self.clear = function (isNoRender, isNoRun) {
            self.filters = [];
            $('[q-type=2]').removeClass('current');
            $('[q-type=4]').val('');
            $('[q-type=1]').val('');
            $('[q-type=3]').attr('checked', false);
            $('[q-type=5]').attr('checked', false);
            $('[q-type=6] option[value=""]').attr('selected', 'selected');

            !isNoRender && self.render();
            !isNoRun && self.run();
        }

        self.render = function(){

            var lis = $('.filter-list-li');
            lis.html('');
            for (var i=0;i<self.filters.length;i++) {
            	if(self.filters[i].type == '6'){continue;}
                var li = $('<li '+get_id()+'>'+self.filters[i].name+'<i class="icon iconfont icon-delete"></i></li>');
                li.data('v', self.filters[i]);
                li.find('i.icon-delete').click(function(){
                    var v = $(this).closest('li').data('v');
                    if (v.type == '1') {
                        $('[q-key='+v.key+']').val('');
                        self.removekey(v.key);
                    }

                    if (v.type == '2') {
                        $('[q-key='+v.key+'][q-val='+v.val+']').removeClass('current');
                        self.removekey(v.key);
                    }

                    if (v.type == '3') {
                    }

                    if (v.type == '4') {
                        $('[q-key='+v.key+']').val('');
                        self.removekey(v.key);
                    }

                    if (v.type == '5') {
                        $('[q-key='+v.key+'][q-val='+v.val+']').prop('checked', false);
                        self.removeval(v);
                    }

                });

                lis.append(li);

            }

            $('a:contains(清除条件)').unbind('click').bind('click', function () {
                self.clear();
            })
        }



        self.render();
    }

    /**
     * 模版渲染
     */
    function render(selector) {

        var data = selector.data('q');
        var data_aggregation = data['data_aggregation'];
        var query_list = data['query_param'];
        var _render = cache(data['template_url']);

        if (_render === undefined) {
            _render = window.template.compile(data['template_html']);
            cache(data['template_url'], _render);
        }

        selector.html(_render(data_aggregation));

    }

    function one(data) {
        return function(key, val){
            for (var i=0;i<data.length;i++) {
                if (val === undefined) {
                    if (data[i].key == key)
                        return data[i]
                }
                if (data[i].key == key && data[i].val == val)
                    return data[i]
            }
        }
    }

    // 检测是否是日期格式，如果是需要检查日期的合法值 如果没有问题，返回对应值
    var dateFormat = {
        'yy-mm-dd': /^(\d{4})-(0\d{1}|1[0-2])-(0\d{1}|[12]\d{1}|3[01])$/,
        'yy-mm': /^(\d{4})-(0\d{1}|1[0-2])$/
    }
    function checkDate(el) {
        var value = el.val();

        if (value == null || value == '')
            return {valid: true, val: ''}

        if (el.attr('q-format')) {
            var format = el.attr('q-format');
            if (!dateFormat[format].test(value)) {
                alert('日期格式不正确，不能进行查询');
                return {valid: false, val: ''}
            }
        }
        return {valid: true, val: value};
    }

    /**
     * @q-type
     *     1: 文本输入
     *     2: 文本选择
     *     3: 文本复选 通过确定按钮
     *     4: 上下限
     *     5: 文本复选不通过确定按钮
     */
    function bind_event(selector){

        var dom = selector.find('[q-type]');
        var data = selector.data('q');
        var q = new Q(data['query_param'], data['callback']);
        var for_selectors = {}
        var onehas = one(data['query_param']);

        data['q'] = q;
        selector.data('q', data);

        dom.each(function(){
            var _this = $(this);

            var t = _this.attr('q-type');

            if (t == '1') { // 文本输入搜索
                var _selector = _this.attr('q-for');
                var _key = _this.attr('q-key');

                var _v = onehas(_key);
                if (_v) {
                    _this.val(_v.val);
                }

                function _fn1 (){
                    var _val = _this.val();
                    if (!is_empty(_this.val())) {
                        if (q.has(_key)) {
                            q.update(_key, {'type': '1', 'name': _val, 'val': _val, 'key': _this.attr('q-key')});
                        }else {
                            q.add({'type': '1', 'name': _val, 'val': _val, 'key': _this.attr('q-key')});
                        }
                    }else{
                        q.removekey(_key);
                    }
                }

                if (_selector === undefined) {
                    _this.keypress(function(event){
                        var keycode = (event.keyCode ? event.keyCode : event.which);
                        if(keycode == '13'){
                            _fn1()
                        }
                    });
                }else{
                    $(_selector).click(function(){
                        _fn1();
                    });
                }

            }

            if (t == '2') { // 文本选择（单选）
                var _key = _this.attr('q-key');

                if (onehas(_this.attr('q-key'), _this.attr('q-val'))) {
                    _this.addClass('current');
                }

                _this.click(function(){
                    if (!_this.hasClass('current')) {
                        var _key = _this.attr('q-key');
                        var _val = _this.attr('q-val');
                        $('[q-key='+_key+']').removeClass('current');
                        _this.addClass('current');
                        q.removefilterbykey(_key);
                        q.add({'type': '2', 'name': _this.attr('q-name'), 'key': _key, 'val': _val});
                    }
                });
            }

            if (t == '3') { // 文本复选
                var _key = _this.attr('q-key');

                var _v = onehas(_key);
                if (_v && _v.val == _this.val()) {
                    _this.prop('checked', true);
                }

                var _selector = _this.attr('q-for');
                $(_selector).click(function(){
                    if (_this.is(':checked')) {
                        q.add(_this.attr('q-key'), _this.val());
                    }else{
                        q.removeval(_this.attr('q-key'), _this.val());
                    }
                });
            }

            if (t == '4') { //上下限
                var ext = _this.attr('q-range');
                var key = _this.attr('q-key');
                var name = _this.attr('q-name');
                var _selector = _this.attr('q-for');
                var _selector_key = _selector + key;
                var _v = onehas(key);

                if (_v) {
                    if (ext == 's') {
                        _this.val(_v.val[0])
                    }else{
                        _this.val(_v.val[1])
                    }
                }

                if (for_selectors[_selector_key] === undefined) {
                    for_selectors[_selector_key] = {'selector': _selector, 'key': key, 'name': name};
                }
                for_selectors[_selector_key][ext] = {'key': key, 'el': _this}
            }

            if (t == '5') {
                if (onehas(_this.attr('q-key'), _this.attr('q-val'))) {
                    _this.prop('checked', true);
                }

                _this.change(function(){
                    if (_this.is(':checked')) {
                        q.add({'type': '5', name: _this.attr('q-name'), 'val': _this.attr('q-val'), 'key': _this.attr('q-key')})
                    }else{
                        q.removeval({'type': '5', name: _this.attr('q-name'), 'val': _this.attr('q-val'), 'key': _this.attr('q-key')});
                    }
                });
            }

            if (t == '6'){
                var _key = _this.attr('q-key');
                var _currentVal = _this.find("option:selected").val();

            	if (onehas(_key, _currentVal)) {
                    _this.find("option[value='"+ _currentVal +"']").prop('selected', true);
                }

            	function _fn6 (){
                    var _val = _this.find("option:selected").val();
                    if (!is_empty(_val)) {
                        if (q.has(_key)) {
                            q.update(_key, {'type': '6', 'name': _val, 'val': _val, 'key': _key});
                        }else {
                            q.add({'type': '6', 'name': _val, 'val': _val, 'key': _key});
                        }
                    }else{
                        q.removekey(_key);
                    }
                }

            	_this.change(function(){
            		_fn6();
                });
            }

        });

        var _for = {};
        for (var _s in for_selectors) {
            var _o = for_selectors[_s];
            if (_for[_o.selector]) {
                _for[_o.selector].push(_o);
            }else{
                _for[_o.selector] = [_o];
            }
        }

        for (var _selector in _for) {
            $(_selector).click(function(){
                var _ol = _for[_selector];
                for (var i=0; i < _ol.length; i++) {
                    var o = _ol[i];

                    var sv = checkDate(o.s.el);
                    if (!sv.valid) return;

                    var ev = checkDate(o.e.el);
                    if (!ev.valid) return;

                    var v = [sv.val, ev.val];
                    var d = {key: o.key, name: o.name + ':' + v.join('~'), type: '4', val: v};
                    if (q.has(o.key)) {
                        if (v[0] == '' && v[1] == '') {
                            q.removekey(o.key);
                        }else{
                            q.update(o.key, d);
                        }
                    }else{
                        if (v[0] == '' && v[1] == '') {
                            // q.run();
                        }else{
                            q.add(d, true, true);
                        }
                    }
                }
                q.render();
                q.run();
            });
        }

        $('.datepicker').each(function () {
            var self=$(this);
            var format = self.attr('q-format');
            if (format == undefined) {
                format = 'yy-mm-dd';
                self.attr('q-format', format);
            }
            self.datepicker({dateFormat:format})
        })

        $('.datepicker').datepicker();

        var filter_link = $('.filter_link').filter(function(){
            return $(this).find('[q-type="2"]').length > 0;
        }); //.closest('td').append('');

        filter_link.each(function(){
            var self = $(this);
            var height = self.attr('q-height');
            var id = get_id();
            var _this = this;
            self.css('height', height || '30px');
            self.after('<span class="list_more" id="'+id+'"></span>')
            // self.after('<span class="list_more" id="'+id+'"><button type="button" class="btn_gray_min">多选+</button></span>')
            if (_this.offsetHeight < _this.scrollHeight) {
                $('#'+id).append('<a class="more">更多<i class="icon iconfont icon-jt-down vm"></i></a>')
            }

            $('#'+id + ' a.more').click(function(){
                if (self.hasClass('q-show')) {
                    self.css('height', height || '30px');
                    self.removeClass('q-show');
                    $(this).html('更多<i class="icon iconfont icon-jt-down vm"></i>');
                }else{
                    self.removeAttr('style');
                    self.addClass('q-show');
                    $(this).html('收起<i class="icon iconfont icon-jt-up vm"></i>');
                }
            });
        });
    }

    /**
     * @param query_list 所选参数
     * @param data 需要渲染页面的数据
     * @param search 回调函数，通常是搜索函数
     * @param isSearch 是否调用搜索函数
     * @q-type
     *     1: 文本输入
     *     2: 文本选择
     *     3: 文本复选 通过确定按钮
     *     4: 上下限
     *     5: 文本复选不通过确定按钮
     *     6: 单选
     */
    $.fn.query = function(options){

        var self = $(this);
        var opts = $.extend({
            query_list: [],
            data: {},
            search: function(){},
            isSearch: false
        }, options);

        var self_data = {};
        if (self.data('q') === undefined) {
            self_data = {};
        }else{
            self_data = self.data('q');
        }

        self_data['callback'] = opts.search;
        self_data['data_aggregation'] = opts.data;
        self_data['query_param'] = opts.query_list;

        var template_html = self_data['template_html'];

        function dorender(iscall) {
            render(self);
            bind_event(self);
            iscall && self.data('q').q.run();
        }

        if (template_html === undefined) {
            var template_url = self.attr('q-src');
            if (template_url === undefined) {
                throw new Error('没有找到模版文件');
            }

            $.get(template_url).success(function(content){
                template_html = content;
                self_data['template_html'] = template_html;
                self_data['template_url'] = template_url;
                self.data('q', self_data);
                dorender(opts.isSearch);
            });
        }else{
            self.data('q', self_data);

            dorender(opts.isSearch);
        }

        self.bind('update_data', function(e, _data){
            var _d = self.data('q');
            _d['data_aggregation'] = _data;
            _d['query_param'] = _d.q.get_filters();
            self.data('q', _d);
            dorender(false);
        })

    }

})(jQuery);
