
let DataShow = {
    name: "DataShow",
    props: {
        columns: {
            required: true,
            type: Array,
        },
        queryParams: {}
    },
    mounted() {
        $("#table").bootstrapTable({
            url: '../queryCompanyInfoTable/',
            method: 'post',                      //请求方式（*）
            toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: false,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            queryParams: this.queryParams,           //传递参数（*）
            sidePagination: "client",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber: 1,                       //初始化加载第一页，默认第一页
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [10, 25, 50, 100, 'all'],        //可供选择的每页的行数（*）
            search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            contentType: "application/x-www-form-urlencoded",
            strictSearch: true,
            showColumns: true,                  //是否显示所有的列
            showRefresh: true,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            clickToSelect: true,                //是否启用点击选中行
            // height: 700,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "no",                     //每一行的唯一标识，一般为主键列
            showToggle: true,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            detailView: false,                   //是否显示父子表
            fixedColumns: true,                  // 从左开始固定列
            fixedNumber: 1,                        // 固定1列

            columns: this.columns,
            showExport: true,              //是否显示导出按钮
            exportDataType: "all",              //basic', 'all', 'selected'.
            exportTypes:['excel','xml', 'json', 'txt', 'csv', 'sql'],	    //导出类型
            //exportButton: $('#btn_export'),     //为按钮btn_export  绑定导出事件  自定义导出按钮(可以不用)
            exportOptions: {
                //ignoreColumn: [0,0],            //忽略某一列的索引
                fileName: '数据导出',              //文件名称设置
                worksheetName: 'Sheet1',          //表格工作区名称
                tableName: '公司信息',
                excelstyles: ['background-color', 'color', 'font-size', 'font-weight'],
                //onMsoNumberFormat: DoOnMsoNumberFormat
            },
        });
    },
    template:
        "<div id=\"data-table\">\n" +
        "        <table id=\"table\">\n" +
        "        </table>\n" +
        "</div>"
}