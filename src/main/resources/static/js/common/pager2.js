
(function (win) {

    var html2 = '<div class="page_list clear">\
        {{if pageNo!=1}}\
        <a page="1" class="top_page">首页</a><a page="{{pageNo-1}}" class="page_prev">上一页</a>\
        {{/if}}\
        {{each pages as iPage}}\
            <a page="{{iPage}}" {{if iPage==pageNo}}class="current"{{/if}}>{{iPage}}</a>\
        {{/each}}\
        {{if pageNo < totalPage }}<a page="{{pageNo+1}}" class="page_next">下一页</a><a page="{{totalPage}}" class="end_page">尾页</a>{{/if}}\
        <span class="ml10" style="margin-left: 5px;">共{{ totalPage }}页</span>\
        <span style="margin-left: 10px;display: none;">每页显示</span>\
        <select class="pageSize" style="display: none;">\
        <option value="5" {{if pageSize==5 }} selected {{/if}}>5</option>\
        <option value="10" {{if pageSize==10 }} selected {{/if}}>10</option>\
        <option value="20" {{if pageSize==20 }} selected {{/if}}>20</option>\
        <option value="50" {{if pageSize==50 }} selected {{/if}}>50</option>\
        <option value="100" {{if pageSize==100 }} selected {{/if}}>100</option>\
        <option value="500" {{if pageSize==500 }} selected {{/if}}>500</option>\
        </select>\
    </div>';

    var render2 = template.compile(html2);

    function pageRender2(pageInfo) {
        var opts = $.extend({
            pageNo: 1,
            pageSize: 20,
            totalPage: 1,
            showPages: 2,
            pages:[],
            callback:function(page,pageSize){}
        }, pageInfo);

        opts.pageNo = parseInt(opts.pageNo);
        opts.pageSize = parseInt(opts.pageSize);
        opts.totalPage = parseInt(opts.totalPage);
        opts.pages = [];

        if (opts.totalPage > 1) {

            var s = (opts.pageNo - opts.showPages) > 0 ? (opts.pageNo - opts.showPages) : 1;
            var d = (opts.totalPage - opts.showPages) > opts.pageNo ? (opts.pageNo + opts.showPages) : opts.totalPage;

            for (var i=s; i <= d; i++) {
                opts.pages.push(i);
            }
        }

        return render2(opts);
    }

    win.page2 = function(selector, pageInfo){
        var $page2 = $(pageRender2(pageInfo));
        $page2.find('.pageSize').val(pageInfo.pageSize);

        $(selector).html($page2);

        var fn = pageInfo.callback;
        if (fn) {
            $page2.find('a[page]:not(.current)').click(function(){
                fn($(this).attr('page'), $(this).closest('div').find('.pageSize').val());
                $("html,body").animate({scrollTop: 470});
            });

            $page2.find('.pageSize').change(function(){
                fn(1, $(this).val());
                $("html,body").animate({scrollTop: 470});
            });
        }

    }

})(window || {});
