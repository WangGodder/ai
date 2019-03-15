WeightQuery = {
    name: "WeightQuery",
    data() {
        return {
            trees: [],
            weight: null,
        }
    },
    created() {
        let getData = [];
        $.ajax({
            url: '../figureWeightTree/',
            type: 'post',
            dataType: 'json',
            async: false,
            success: function (data) {
                let status = data.status;
                if (status == 1) {
                    for (let i = 0; i < data.data.length; i++){
                        getData[i] = data.data[i];
                    }
                    // console.log(data.data);
                }
                else {
                    sv2.warn("获取权重信息失败");
                }
            },
            error: function () {
                sv2.warn("获取权重信息失败，请询问管理员")
            }
        });
        this.trees = getData;
    },
    methods: {
        change_weight: function () {
            $('#weightForm').ajaxSubmit({
                url: '/user/addFigureWeight/',
                dataType: 'json',
                resetForm: false,
                success: function (data) {
                    let status = data.status;
                    if (status == 1) {
                        sv2.warn("添加成功");
                    } else {
                        sv2.warn("添加失败:" + data.message);
                    }
                },
                error: function () {
                    sv2.warn("上传失败");
                }
            });
        }
    },
    template:
        "<div id=\"weight-query\">\n" +
        "        <form id=\"weightForm\" method=\"post\">\n" +
        "        <ul v-for=\"tree of this.trees\" class=\"tree\">\n" +
        "            <li>\n" +
        "                <span>{{tree['title']}}</span>\n" +
        "                <input type=\"number\" v-bind:id=\"tree['field']\" :name=\"tree['field']\" v-model=\"tree['value']\">\n" +
        "            </li>\n" +
        "            <ul v-for=\"tree of tree.children\" class=\"\" style=\"margin-left: 15%; \">\n" +
        "                <li>\n" +
        "                    <span>{{tree['title']}}</span>\n" +
        "                    <input type=\"number\" v-bind:id=\"tree['field']\" :name=\"tree['field']\" v-model=\"tree['value']\">\n" +
        "                </li>\n" +
        "                <ul style=\"margin-left: 15%; \">\n" +
        "                   <li v-for=\"tree of tree.children\">\n" +
        "                       <span>{{tree['title']}}</span>\n" +
        "                       <input type=\"number\" v-bind:id=\"tree['field']\" :name=\"tree['field']\" v-model=\"tree['value']\">\n" +
        "                   </li>\n" +
        "                </ul>\n" +
        "            </ul>\n" +
        "        </ul>\n" +
        "        </form>\n" +
        "        <div class=\"btn btn-warning btn-lg\" v-on:click=\"change_weight()\">修改权重</div>\n" +
        "    </div>"
    
}