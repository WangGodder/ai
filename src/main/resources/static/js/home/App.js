let App = {
    name: 'app',
    el: '#app',
    components: {
        EvaluatePage,
        DataPage,
        UploadPage,
        IndexPage,
    },
    data() {
        return {
            timer: null,  // 定时刷新时间
            page_index: ['index-page','upload-page', 'data-page', 'evaluate-page'],
            page_show: [true, false, false, false],

        }
    },
    mounted() {
        setInterval(this.flushTime, 1000);
    },
    methods: {
        flushTime: function () {
            $('#time').html(timeStamp2String(new Date().getTime()));
        },
        change_page: function (page_index) {
            for (let i = 0; i < this.page_show.length; i++) {
                if (this.page_show[i]) {
                    const original_btn = $('#' + this.page_index[i] + '-btn');
                    original_btn.removeClass('btn-success');
                    original_btn.addClass('btn-info');
                    // this.page_show[i] = false;  // 错误的方式，数组内容修改不会被监听
                    this.$set(this.page_show, i, false);  // 正确的方式，强制监听
                    break;
                }
            }
            const active_btn = $('#' + this.page_index[page_index] + '-btn');
            active_btn.removeClass('btn-info');
            active_btn.addClass('btn-success');
            this.$set(this.page_show, page_index, true);

        }
    },

}
