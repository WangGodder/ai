let FormUpload = {
    name: "FormUpload",
    methods: {
        submit: function () {
            // let form = document.getElementById("form-data")
            // let inputs = form.getElementsByTagName("input");

            // let elements = [];
            // alert(inputs[0].value.data);
            // alert(typeof inputs[0].value.data);
            // for (let i = 0; i < inputs.length; i++) {
            //     elements.push(inputs[i]);
            //     console.log(inputs[i]);
            // }
            let formData = new FormData();
            // for (let i = 0; i < elements.length; i++) {
            //     console.log(elements[i].value);
            //     if (elements[i] == null || elements[i] === '' || elements[i] === undefined) {
            //         console.log("is null");
            //         formData.set(elements[i].name, 0);
            //     } else {
            //         formData.set(elements[i].name, elements[i].value);
            //     }
            // }

            $('#submit-form-btn').attr('disabled', true);
            $("#data-form").ajaxSubmit(
                {
                    url:"/user/formSubmit/",
                    dataType:"json",
                    resetForm:true,
                    // async: false,
                    success: function (data) {
                        var json = data.status;
                        if (json == 1) {
                            sv2.warn("上传成功");
                        } else {
                            sv2.warn("上传失败:");
                        }
                    },
                    error: function () {
                        alert("wrong");
                        sv2.warn("上传失败");
                    }
                }
            );
            $('#submit-form-btn').attr('disabled', false);

            // $.ajax({
            //     data: formData,
            //
            // })
        }
    },
    template:
        " <div id=\"form-data\" class=\"row\">\n" +
        "<form id='data-form' type='multipart/form-data' method='post' name='data-form'>\n" +
        "        <div class=\"panel panel-danger\">\n" +
        "            <!--录入批次-->\n" +
        "            <div class=\"panel-heading\">\n" +
        "                <h3 class=\"panel-title\">录入批次(必填)</h3>\n" +
        "            </div>\n" +
        "            <div class=\"panel-body row\">\n" +
        "                <div class=\"block-show col-lg-3 col-md-3 col-sm-3 col-xs-3\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">年</span>\n" +
        "                        <input id=\"year\" name=\"year\" type=\"number\" min=\"2000\" max=\"3000\" class=\"form-control\">\n" +
        "                        <span class=\"input-group-addon\">不得低于2000年</span>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "                <div class=\"block-show col-lg-3 col-md-3 col-sm-3 col-xs-3\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">季度</span>\n" +
        "                        <input id=\"quarter\" name=\"quarter\" type=\"number\" min=\"1\" max=\"4\" class=\"form-control\">\n" +
        "                        <span class=\"input-group-addon\">1-4季度</span>\n" +
        "                    </div>\n" +
        "                </div>" +
        "               <div class=\"col-lg-6 col-md-6 col-sm-6 col-xs-6 block-show\">\n"+
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">公司名称</span>\n" +
        "                        <input id=\"company-name\" name=\"companyname\" type=\"text\" class=\"form-control\">\n" +
        "                        <span class=\"input-group-addon\"></span>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "                <div class=\"block-show  col-lg-6 col-md-6 col-sm-6 col-xs-6\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">公司所在行业</span>\n" +
        "                        <input id=\"company-industry\" name=\"industry\" type=\"text\" class=\"form-control\">\n" +
        "                        <span class=\"input-group-addon\"></span>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "                <div class=\"col-lg-6 col-md-6 col-sm-6 col-xs-6 block-show\">\n" +
        "                    <div class=\"input-group input-group-lg \">\n" +
        "                        <span class=\"input-group-addon\">公司所在地区</span>\n" +
        "                        <input id=\"company-region\" name=\"region\" type=\"text\" class=\"form-control\">\n" +
        "                        <span class=\"input-group-addon\"></span>\n" +
        "                    </div>\n" +
        "                </div>" +
        "            </div>\n" +
        "        </div>\n" +
        "        <!--1-->\n" +
        "        <div class=\"panel panel-info\">\n" +
        "            <!--开票收入-->\n" +
        "            <div class=\"panel-heading\">\n" +
        "                <h3 class=\"panel-title\">已开发票收入</h3>\n" +
        "            </div>\n" +
        "            <div class=\"panel-body row\">\n" +
        "                <div class=\"block-show  col-lg-3 col-md-3 col-sm-3 col-xs-3\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">软件产品</span>\n" +
        "                        <input id=\"ticket-income-software\" name=\"ticketincomesoftware\" type=\"number\" class=\"form-control\">\n" +
        "                        <span class=\"input-group-addon\">万元</span>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "\n" +
        "                <div class=\"block-show  col-lg-3 col-md-3 col-sm-3 col-xs-3\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">硬件产品</span>\n" +
        "                        <input id=\"ticket-income-hardware\" name=\"ticketincomehardware\" type=\"number\" class=\"form-control\">\n" +
        "                        <span class=\"input-group-addon\">万元</span>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "\n" +
        "                <div class=\"block-show  col-lg-3 col-md-3 col-sm-3 col-xs-3\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">咨询服务</span>\n" +
        "                        <input id=\"ticket-income-consult\" name=\"ticketincomeconsult\" type=\"number\" class=\"form-control\">\n" +
        "                        <span class=\"input-group-addon\">万元</span>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "\n" +
        "                <div class=\"block-show  col-lg-3 col-md-3 col-sm-3 col-xs-3\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">其他</span>\n" +
        "                        <input id=\"ticket-income-other\" name=\"ticketincomeother\" type=\"number\" class=\"form-control\">\n" +
        "                        <span class=\"input-group-addon\">万元</span>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "            </div>\n" +
        "            <!--合同收入-->\n" +
        "            <div class=\"panel-heading\">\n" +
        "                <h3 class=\"panel-title\">未开发票收入(合同收入)</h3>\n" +
        "            </div>\n" +
        "            <div class=\"panel-body row\">\n" +
        "                <div class=\"block-show  col-lg-3 col-md-3 col-sm-3 col-xs-3\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">软件产品</span>\n" +
        "                        <input id=\"contract-income-software\" name=\"contractincomesoftware\" type=\"number\" class=\"form-control\">\n" +
        "                        <span class=\"input-group-addon\">万元</span>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "                <div class=\"block-show  col-lg-3 col-md-3 col-sm-3 col-xs-3\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">硬件产品</span>\n" +
        "                        <input id=\"contract-income-hardware\" name=\"contractincomehardware\" type=\"number\" class=\"form-control\">\n" +
        "                        <span class=\"input-group-addon\">万元</span>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "                <div class=\"block-show  col-lg-3 col-md-3 col-sm-3 col-xs-3\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">咨询服务</span>\n" +
        "                        <input id=\"contract-income-consult\" name=\"contractincomeconsult\" type=\"number\" class=\"form-control\">\n" +
        "                        <span class=\"input-group-addon\">万元</span>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "                <div class=\"block-show  col-lg-3 col-md-3 col-sm-3 col-xs-3\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">其他</span>\n" +
        "                        <input id=\"contract-income-other\" name=\"contractincomeother\" type=\"number\" class=\"form-control\">\n" +
        "                        <span class=\"input-group-addon\">万元</span>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "            </div>\n" +
        "        </div>\n" +
        "        <!--2-->\n" +
        "        <div>\n" +
        "            <!--企业所得税-->\n" +
        "            <div class=\"panel panel-info col-lg-4 col-md-4 col-sm-4 col-xs-4\">\n" +
        "                <div class=\"panel-heading \">\n" +
        "                    <h3 class=\"panel-title\">企业所得税</h3>\n" +
        "                </div>\n" +
        "                <div class=\"panel-body row\">\n" +
        "                    <div class=\"block-show \">\n" +
        "                        <div class=\"input-group input-group-lg\">\n" +
        "                            <span class=\"input-group-addon\">应纳税值</span>\n" +
        "                            <input id=\"income-taxable\" name=\"incometaxable\" type=\"number\" class=\"form-control\">\n" +
        "                            <span class=\"input-group-addon\">万元</span>\n" +
        "                        </div>\n" +
        "                    </div>\n" +
        "                    <div class=\"block-show \">\n" +
        "                        <div class=\"input-group input-group-lg\">\n" +
        "                            <span class=\"input-group-addon\">税收减免</span>\n" +
        "                            <input id=\"income-tax-deduction\" name=\"incometaxdeduction\" type=\"number\" class=\"form-control\">\n" +
        "                            <span class=\"input-group-addon\">万元</span>\n" +
        "                        </div>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "            </div>\n" +
        "            <!--企业个人所得税-->\n" +
        "            <div class=\"panel panel-info col-lg-4 col-md-4 col-sm-4 col-xs-4\">\n" +
        "                <div class=\"panel-heading\">\n" +
        "                    <h3 class=\"panel-title\">企业个人所得税(总和)</h3>\n" +
        "                </div>\n" +
        "                <div class=\"panel-body row\">\n" +
        "                    <div class=\"block-show \">\n" +
        "                        <div class=\"input-group input-group-lg\">\n" +
        "                            <span class=\"input-group-addon\">应纳税值</span>\n" +
        "                            <input id=\"personal-taxable\" name=\"pensonaltaxable\" type=\"number\" class=\"form-control\">\n" +
        "                            <span class=\"input-group-addon\">万元</span>\n" +
        "                        </div>\n" +
        "                    </div>\n" +
        "                    <div class=\"block-show \">\n" +
        "                        <div class=\"input-group input-group-lg\">\n" +
        "                            <span class=\"input-group-addon\">税收减免</span>\n" +
        "                            <input id=\"personal-tax-deduction\" name=\"pensonaltaxdedection\" type=\"number\" class=\"form-control\">\n" +
        "                            <span class=\"input-group-addon\">万元</span>\n" +
        "                        </div>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "            </div>\n" +
        "            <!--增值税-->\n" +
        "            <div class=\"panel panel-info col-lg-4 col-md-4 col-sm-4 col-xs-4\">\n" +
        "                <div class=\"panel-heading\">\n" +
        "                    <h3 class=\"panel-title\">企业增值税</h3>\n" +
        "                </div>\n" +
        "                <div class=\"panel-body row\">\n" +
        "                    <div class=\"block-show\">\n" +
        "                        <div class=\"input-group input-group-lg\">\n" +
        "                            <span class=\"input-group-addon\">应纳税值</span>\n" +
        "                            <input id=\"add-value-taxable\" name=\"addvaluetaxable\" type=\"number\" class=\"form-control\">\n" +
        "                            <span class=\"input-group-addon\">万元</span>\n" +
        "                        </div>\n" +
        "                    </div>\n" +
        "                    <div class=\"block-show \">\n" +
        "                        <div class=\"input-group input-group-lg\">\n" +
        "                            <span class=\"input-group-addon\">税收减免</span>\n" +
        "                            <input id=\"add-value-tax-deduction\" name=\"addvaluetaxdecution\" type=\"number\" class=\"form-control\">\n" +
        "                            <span class=\"input-group-addon\">万元</span>\n" +
        "                        </div>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "            </div>\n" +
        "        </div>\n" +
        "        <!--3-->\n" +
        "        <div class=\"panel panel-info\">\n" +
        "            <!--股权类融资-->\n" +
        "            <div class=\"panel-heading\">\n" +
        "                <h3 class=\"panel-title\">股权类融资</h3>\n" +
        "            </div>\n" +
        "            <div class=\"panel-body\">\n" +
        "                <div class=\"block-show col-lg-4 col-md-4 col-sm-4 col-xs-4\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">风投机构</span>\n" +
        "                        <input id=\"stock-finance-vc\" name=\"stockfinancevc\" type=\"number\" class=\"form-control\">\n" +
        "                        <span class=\"input-group-addon\">万元</span>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "                <div class=\"block-show col-lg-4 col-md-4 col-sm-4 col-xs-4\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">政府企业</span>\n" +
        "                        <input id=\"stock-finance-government\" name=\"stockfinancegovenment\" type=\"number\" class=\"form-control\">\n" +
        "                        <span class=\"input-group-addon\">万元</span>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "                <div class=\"block-show col-lg-4 col-md-4 col-sm-4 col-xs-4\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">个人&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>\n" +
        "                        <input id=\"stock-finance-person\" name=\"stockfinancepensonal\" type=\"number\" class=\"form-control\">\n" +
        "                        <span class=\"input-group-addon\">万元</span>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "            </div>\n" +
        "            <!--债务类融资-->\n" +
        "            <div class=\"panel-heading\">\n" +
        "                <h3 class=\"panel-title\">债务类融资</h3>\n" +
        "            </div>\n" +
        "            <div class=\"panel-body row\">\n" +
        "                <div class=\"block-show col-lg-3 col-md-3 col-sm-3 col-xs-3\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">银行&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>\n" +
        "                        <input id=\"debt-finance-bank\" name=\"debtfinancebank\" type=\"number\" class=\"form-control\">\n" +
        "                        <span class=\"input-group-addon\">万元</span>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "                <div class=\"block-show col-lg-3 col-md-3 col-sm-3 col-xs-3\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">新型贷款机构</span>\n" +
        "                        <input id=\"debt-finance-li\" name=\"debtfinanceli\" type=\"number\" class=\"form-control\">\n" +
        "                        <span class=\"input-group-addon\">万元</span>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "                <div class=\"block-show col-lg-3 col-md-3 col-sm-3 col-xs-3\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">企业拆借</span>\n" +
        "                        <input id=\"debt-finance-company\" name=\"debtfinancecompany\" type=\"number\" class=\"form-control\">\n" +
        "                        <span class=\"input-group-addon\">万元</span>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "                <div class=\"block-show col-lg-3 col-md-3 col-sm-3 col-xs-3\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">个人&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>\n" +
        "                        <input id=\"debt-finance-person\" name=\"debtfinancepensonal\" type=\"number\" class=\"form-control\">\n" +
        "                        <span class=\"input-group-addon\">万元</span>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "            </div>\n" +
        "        </div>\n" +
        "        <!--4-->\n" +
        "        <div class=\"panel panel-info\">\n" +
        "            <!--净资产-->\n" +
        "            <div class=\"panel-heading\">\n" +
        "                <h3 class=\"panel-title\">净资产</h3>\n" +
        "            </div>\n" +
        "            <div class=\"panel-body row\">\n" +
        "                <div class=\"block-show col-lg-3 col-md-3 col-sm-3 col-xs-3\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">流动资产</span>\n" +
        "                        <input id=\"current-asset\" name=\"currentasset\" type=\"number\" class=\"form-control\">\n" +
        "                        <span class=\"input-group-addon\">万元</span>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "                <div class=\"block-show col-lg-3 col-md-3 col-sm-3 col-xs-3\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">非流动资产</span>\n" +
        "                        <input id=\"nocurrent-asset\" name=\"nocurrentasset\" type=\"number\" class=\"form-control\">\n" +
        "                        <span class=\"input-group-addon\">万元</span>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "                <div class=\"block-show col-lg-3 col-md-3 col-sm-3 col-xs-3\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">流动负债</span>\n" +
        "                        <input id=\"current-debt\" name=\"currentdebt\" type=\"number\" class=\"form-control\">\n" +
        "                        <span class=\"input-group-addon\">万元</span>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "                <div class=\"block-show col-lg-3 col-md-3 col-sm-3 col-xs-3\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">非流动负债</span>\n" +
        "                        <input id=\"nocurrent-debt\" name=\"nocurrentdebt\" type=\"number\" class=\"form-control\">\n" +
        "                        <span class=\"input-group-addon\">万元</span>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "            </div>\n" +
        "            <!--实际估值额-->\n" +
        "            <div class=\"panel-heading\">\n" +
        "                <h3 class=\"panel-title\">实际估值额</h3>\n" +
        "            </div>\n" +
        "            <div class=\"panel-body row\">\n" +
        "                <div class=\"block-show col-lg-4 col-md-4 col-sm-4 col-xs-4\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">首次融资估值</span>\n" +
        "                        <input id=\"first-finance-value\" name=\"firstfinancevalue\" type=\"number\" class=\"form-control\">\n" +
        "                        <span class=\"input-group-addon\">万元</span>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "                <div class=\"block-show col-lg-4 col-md-4 col-sm-4 col-xs-4\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">最近一次融资估值</span>\n" +
        "                        <input id=\"last-finance-value\" name=\"lastfinancevalue\" type=\"number\" class=\"form-control\">\n" +
        "                        <span class=\"input-group-addon\">万元</span>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "                <div class=\"block-show col-lg-4 col-md-4 col-sm-4 col-xs-4\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">现在准备融资估值</span>\n" +
        "                        <input id=\"current-finance-value\" name=\"currentfinancevalue\" type=\"number\" class=\"form-control\">\n" +
        "                        <span class=\"input-group-addon\">万元</span>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "            </div>\n" +
        "        </div>\n" +
        "        <!--5-->\n" +
        "        <div class=\"panel panel-info\">\n" +
        "            <!--兼职员工数-->\n" +
        "            <div class=\"panel-heading\">\n" +
        "                <h3 class=\"panel-title\">兼职员工数(未缴纳社保人员)</h3>\n" +
        "            </div>\n" +
        "            <div class=\"panel-body row\">\n" +
        "                <div class=\"block-show col-lg-3 col-md-3 col-sm-3 col-xs-3\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">兼职开发</span>\n" +
        "                        <input id=\"parttime-development\" name=\"parttimedevelopment\" type=\"number\" class=\"form-control\">\n" +
        "                        <span class=\"input-group-addon\">人</span>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "                <div class=\"block-show col-lg-3 col-md-3 col-sm-3 col-xs-3\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">兼职管理</span>\n" +
        "                        <input id=\"parttime-manager\" name=\"parttimemanager\" type=\"number\" class=\"form-control\">\n" +
        "                        <span class=\"input-group-addon\">人</span>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "                <div class=\"block-show col-lg-3 col-md-3 col-sm-3 col-xs-3\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">兼职行政</span>\n" +
        "                        <input id=\"parttime-admin\" name=\"parttimeadmin\" type=\"number\" class=\"form-control\">\n" +
        "                        <span class=\"input-group-addon\">人</span>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "                <div class=\"block-show col-lg-3 col-md-3 col-sm-3 col-xs-3\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">兼职销售</span>\n" +
        "                        <input id=\"parttime-sell\" name=\"parttimesell\" type=\"number\" class=\"form-control\">\n" +
        "                        <span class=\"input-group-addon\">人</span>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "            </div>\n" +
        "            <!--专职员工数-->\n" +
        "            <div class=\"panel-heading\">\n" +
        "                <h3 class=\"panel-title\">专职员工数(缴纳社保人员)</h3>\n" +
        "            </div>\n" +
        "            <div class=\"panel-body\">\n" +
        "                <div class=\"block-show col-lg-3 col-md-3 col-sm-3 col-xs-3\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">开发</span>\n" +
        "                        <input id=\"development\" name=\"development\" type=\"number\" class=\"form-control\">\n" +
        "                        <span class=\"input-group-addon\">人</span>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "                <div class=\"block-show col-lg-3 col-md-3 col-sm-3 col-xs-3\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">高管</span>\n" +
        "                        <input id=\"manager\" name=\"manamger\" type=\"number\" class=\"form-control\">\n" +
        "                        <span class=\"input-group-addon\">人</span>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "                <div class=\"block-show col-lg-3 col-md-3 col-sm-3 col-xs-3\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">行政</span>\n" +
        "                        <input id=\"admin\" name=\"administrator\" type=\"number\" class=\"form-control\">\n" +
        "                        <span class=\"input-group-addon\">人</span>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "                <div class=\"block-show col-lg-3 col-md-3 col-sm-3 col-xs-3\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">销售</span>\n" +
        "                        <input id=\"sell\" name=\"sell\" type=\"number\" class=\"form-control\">\n" +
        "                        <span class=\"input-group-addon\">人</span>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "            </div>\n" +
        "            <!--高学历员工数-->\n" +
        "            <div class=\"panel-heading\">\n" +
        "                <h3 class=\"panel-title\">高学历员工数</h3>\n" +
        "            </div>\n" +
        "            <div class=\"panel-body\">\n" +
        "                <div class=\"block-show col-lg-4 col-md-4 col-sm-4 col-xs-4\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">博士</span>\n" +
        "                        <input id=\"doctor\" name=\"doctor\" type=\"number\" class=\"form-control\">\n" +
        "                        <span class=\"input-group-addon\">人</span>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "                <div class=\"block-show col-lg-4 col-md-4 col-sm-4 col-xs-4\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">硕士</span>\n" +
        "                        <input id=\"master\" name=\"master\" type=\"number\" class=\"form-control\">\n" +
        "                        <span class=\"input-group-addon\">人</span>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "                <div class=\"block-show col-lg-4 col-md-4 col-sm-4 col-xs-4\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">学士</span>\n" +
        "                        <input id=\"bachelor\" name=\"bachelor\" type=\"number\" class=\"form-control\">\n" +
        "                        <span class=\"input-group-addon\">人</span>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "            </div>\n" +
        "        </div>\n" +
        "        <!--6-->\n" +
        "        <div class=\"panel col-lg-12 col-md-12 col-sm-12 col-xs-12\">\n" +
        "            <!--申请专利数-->\n" +
        "            <div class=\"panel-info panel col-lg-2 col-md-2 col-sm-2 col-xs-2\" style=\"width: 20%\">\n" +
        "                <div class=\"panel-heading\">\n" +
        "                    <h3 class=\"panel-title\">申请专利数</h3>\n" +
        "                </div>\n" +
        "                <div class=\"panel-body\">\n" +
        "                    <div class=\"block-show \">\n" +
        "                        <div class=\"input-group input-group-lg\">\n" +
        "                            <span class=\"input-group-addon\">发明&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>\n" +
        "                            <input id=\"apply-patent-invent\" name=\"applypatentinvent\" type=\"number\" class=\"form-control\">\n" +
        "                            <span class=\"input-group-addon\">个</span>\n" +
        "                        </div>\n" +
        "                    </div>\n" +
        "                    <div class=\"block-show \">\n" +
        "                        <div class=\"input-group input-group-lg\">\n" +
        "                            <span class=\"input-group-addon\">实业新型</span>\n" +
        "                            <input id=\"apply-patent-industry\" name=\"applypatentindustry\" type=\"number\" class=\"form-control\">\n" +
        "                            <span class=\"input-group-addon\">个</span>\n" +
        "                        </div>\n" +
        "                    </div>\n" +
        "                    <div class=\"block-show \">\n" +
        "                        <div class=\"input-group input-group-lg\">\n" +
        "                            <span class=\"input-group-addon\">外观设计</span>\n" +
        "                            <input id=\"apply-patent-design\" name=\"applypatentdesign\" type=\"number\" class=\"form-control\">\n" +
        "                            <span class=\"input-group-addon\">个</span>\n" +
        "                        </div>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "            </div>\n" +
        "            <!--专利授权数-->\n" +
        "            <div class=\"panel-info panel col-lg-2 col-md-2 col-sm-2 col-xs-2\" style=\"width: 20%\">\n" +
        "                <div class=\"panel-heading\">\n" +
        "                    <h3 class=\"panel-title\">专利授权数</h3>\n" +
        "                </div>\n" +
        "                <div class=\"panel-body\">\n" +
        "                    <div class=\"block-show \">\n" +
        "                        <div class=\"input-group input-group-lg\">\n" +
        "                            <span class=\"input-group-addon\">发明&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>\n" +
        "                            <input id=\"patent-invent\" name=\"patentinvent\" type=\"number\" class=\"form-control\">\n" +
        "                            <span class=\"input-group-addon\">个</span>\n" +
        "                        </div>\n" +
        "                    </div>\n" +
        "                    <div class=\"block-show \">\n" +
        "                        <div class=\"input-group input-group-lg\">\n" +
        "                            <span class=\"input-group-addon\">实业新型</span>\n" +
        "                            <input id=\"patent-industry\" name=\"patentindustry\" type=\"number\" class=\"form-control\">\n" +
        "                            <span class=\"input-group-addon\">个</span>\n" +
        "                        </div>\n" +
        "                    </div>\n" +
        "                    <div class=\"block-show \">\n" +
        "                        <div class=\"input-group input-group-lg\">\n" +
        "                            <span class=\"input-group-addon\">外观设计</span>\n" +
        "                            <input id=\"patent-design\" name=\"patentdesign\" type=\"number\" class=\"form-control\">\n" +
        "                            <span class=\"input-group-addon\">个</span>\n" +
        "                        </div>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "            </div>\n" +
        "            <!--申请著作权数-->\n" +
        "            <div class=\"panel-info panel col-lg-2 col-md-2 col-sm-2 col-xs-2\" style=\"width: 20%\">\n" +
        "                <div class=\"panel-heading\">\n" +
        "                    <h3 class=\"panel-title\">申请著作权数</h3>\n" +
        "                </div>\n" +
        "                <div class=\"panel-body\">\n" +
        "                    <div class=\"block-show \">\n" +
        "                        <div class=\"input-group input-group-lg\">\n" +
        "                            <span class=\"input-group-addon\">软件&nbsp;&nbsp;&nbsp;</span>\n" +
        "                            <input id=\"apply-author-software\" name=\"applyauthorsoftware\" type=\"number\" class=\"form-control\">\n" +
        "                            <span class=\"input-group-addon\">个</span>\n" +
        "                        </div>\n" +
        "                    </div>\n" +
        "                    <div class=\"block-show \">\n" +
        "                        <div class=\"input-group input-group-lg\">\n" +
        "                            <span class=\"input-group-addon\">非软件</span>\n" +
        "                            <input id=\"apply-author-other\" name=\"applyauthorother\" type=\"number\" class=\"form-control\">\n" +
        "                            <span class=\"input-group-addon\">个</span>\n" +
        "                        </div>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "            </div>\n" +
        "\n" +
        "            <!--著作权授权数-->\n" +
        "            <div class=\"panel-info panel col-lg-2 col-md-2 col-sm-2 col-xs-2\" style=\"width: 20%\">\n" +
        "                <div class=\"panel-heading\">\n" +
        "                    <h3 class=\"panel-title\">著作权授权数</h3>\n" +
        "                </div>\n" +
        "                <div class=\"panel-body\">\n" +
        "                    <div class=\"block-show \">\n" +
        "                        <div class=\"input-group input-group-lg\">\n" +
        "                            <span class=\"input-group-addon\">软件&nbsp;&nbsp;&nbsp;</span>\n" +
        "                            <input id=\"author-software\" name=\"authorsoftware\" type=\"number\" class=\"form-control\">\n" +
        "                            <span class=\"input-group-addon\">个</span>\n" +
        "                        </div>\n" +
        "                    </div>\n" +
        "                    <div class=\"block-show\">\n" +
        "                        <div class=\"input-group input-group-lg\">\n" +
        "                            <span class=\"input-group-addon\">非软件</span>\n" +
        "                            <input id=\"author-other\" name=\"authorother\" type=\"number\" class=\"form-control\">\n" +
        "                            <span class=\"input-group-addon\">个</span>\n" +
        "                        </div>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "            </div>\n" +
        "            <!--新产品服务数-->\n" +
        "            <div class=\"panel-info panel col-lg-2 col-md-2 col-sm-2 col-xs-2\" style=\"width: 20%\">\n" +
        "                <div class=\"panel-heading\">\n" +
        "                    <h3 class=\"panel-title\">新产品/服务数</h3>\n" +
        "                </div>\n" +
        "                <div class=\"panel-body\">\n" +
        "                    <div class=\"block-show \">\n" +
        "                        <div class=\"input-group input-group-lg\">\n" +
        "                            <span class=\"input-group-addon\">专利类&nbsp;&nbsp;&nbsp;</span>\n" +
        "                            <input id=\"service-patent\" name=\"servicepatent\" type=\"number\" class=\"form-control\">\n" +
        "                            <span class=\"input-group-addon\">个</span>\n" +
        "                        </div>\n" +
        "                    </div>\n" +
        "                    <div class=\"block-show\">\n" +
        "                        <div class=\"input-group input-group-lg\">\n" +
        "                            <span class=\"input-group-addon\">专用技术</span>\n" +
        "                            <input id=\"service-skill\" name=\"serviceskill\" type=\"number\" class=\"form-control\">\n" +
        "                            <span class=\"input-group-addon\">个</span>\n" +
        "                        </div>\n" +
        "                    </div>\n" +
        "                    <div class=\"block-show \">\n" +
        "                        <div class=\"input-group input-group-lg\">\n" +
        "                            <span class=\"input-group-addon\">商业模式</span>\n" +
        "                            <input id=\"service-sell\" name=\"servicesell\" type=\"number\" class=\"form-control\">\n" +
        "                            <span class=\"input-group-addon\">个</span>\n" +
        "                        </div>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "            </div>\n" +
        "        </div>\n" +
        "        <!--7-->\n" +
        "        <div class=\"panel-info panel\">\n" +
        "            <!--员工工资额-->\n" +
        "            <div class=\"panel-heading\">\n" +
        "                <h3 class=\"panel-title\">员工工资额</h3>\n" +
        "            </div>\n" +
        "            <div class=\"panel-body row\">\n" +
        "                <div class=\"block-show col-lg-4 col-md-4 col-sm-4 col-xs-4\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">1万元以上工资总额</span>\n" +
        "                        <input id=\"salary-high\" name=\"salaryhigh\" type=\"number\" class=\"form-control\">\n" +
        "                        <span class=\"input-group-addon\">万元</span>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "                <div class=\"block-show col-lg-4 col-md-4 col-sm-4 col-xs-4\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">5k-10k之间工资总额</span>\n" +
        "                        <input id=\"salary-middle\" name=\"salarymiddle\" type=\"number\" class=\"form-control\">\n" +
        "                        <span class=\"input-group-addon\">万元</span>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "                <div class=\"block-show col-lg-4 col-md-4 col-sm-4 col-xs-4\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">5k以下工资总额</span>\n" +
        "                        <input id=\"salary-low\" name=\"salarylow\" type=\"number\" class=\"form-control\">\n" +
        "                        <span class=\"input-group-addon\">万元</span>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "            </div>\n" +
        "            <!--员工贡献率-->\n" +
        "            <div class=\"panel-heading\">\n" +
        "                <h3 class=\"panel-title\">员工贡献率</h3>\n" +
        "            </div>\n" +
        "            <div class=\"panel-body row\">\n" +
        "                <div class=\"block-show col-lg-6 col-md-6 col-sm-6 col-xs-6\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">人均销售额</span>\n" +
        "                        <input id=\"per-sell\" name=\"persell\" type=\"number\" class=\"form-control\">\n" +
        "                        <span class=\"input-group-addon\">万元</span>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "                <div class=\"block-show col-lg-6 col-md-6 col-sm-6 col-xs-6\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">人均纳税额</span>\n" +
        "                        <input id=\"per-tax\" name=\"pertax\" type=\"number\" class=\"form-control\">\n" +
        "                        <span class=\"input-group-addon\">万元</span>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "            </div>\n" +
        "        </div>\n" +
        "        <!--8-->\n" +
        "        <div class=\"panel panel-info\">\n" +
        "            <!--参加培训的次数-->\n" +
        "            <div class=\"panel-heading\">\n" +
        "                <h3 class=\"panel-title\">参与培训的次数</h3>\n" +
        "            </div>\n" +
        "            <div class=\"panel-body\">\n" +
        "                <div class=\"block-show col-lg-4 col-md-4 col-sm-4 col-xs-4\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">管理类</span>\n" +
        "                        <input id=\"train-manage\" name=\"trainmanage\" type=\"number\" class=\"form-control\">\n" +
        "                        <span class=\"input-group-addon\">次</span>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "                <div class=\"block-show col-lg-4 col-md-4 col-sm-4 col-xs-4\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">政策法规类</span>\n" +
        "                        <input id=\"train-legal\" name=\"trainlegal\" type=\"number\" class=\"form-control\">\n" +
        "                        <span class=\"input-group-addon\">次</span>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "                <div class=\"block-show col-lg-4 col-md-4 col-sm-4 col-xs-4\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">技能类</span>\n" +
        "                        <input id=\"train-skill\" name=\"trainskill\" type=\"number\" class=\"form-control\">\n" +
        "                        <span class=\"input-group-addon\">次</span>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "            </div>\n" +
        "            <!--接受咨询的次数-->\n" +
        "            <div class=\"panel-heading\">\n" +
        "                <h3 class=\"panel-title\">接受咨询的次数</h3>\n" +
        "            </div>\n" +
        "            <div class=\"panel-body\">\n" +
        "                <div class=\"block-show col-lg-4 col-md-4 col-sm-4 col-xs-4\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">管理类</span>\n" +
        "                        <input id=\"consult-manage\" name=\"consultmanage\" type=\"number\" class=\"form-control\">\n" +
        "                        <span class=\"input-group-addon\">次</span>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "                <div class=\"block-show col-lg-4 col-md-4 col-sm-4 col-xs-4\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">政策法规类</span>\n" +
        "                        <input id=\"consult-legal\" name=\"consultlegal\" type=\"number\" class=\"form-control\">\n" +
        "                        <span class=\"input-group-addon\">次</span>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "                <div class=\"block-show col-lg-4 col-md-4 col-sm-4 col-xs-4\">\n" +
        "                    <div class=\"input-group input-group-lg\">\n" +
        "                        <span class=\"input-group-addon\">技能类</span>\n" +
        "                        <input id=\"consult-skill\" name=\"consultskill\" type=\"number\" class=\"form-control\">\n" +
        "                        <span class=\"input-group-addon\">次</span>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "            </div>\n" +
        "        </div>\n" +
        "        <!--9-->\n" +
        "        <div class=\"panel col-lg-12 col-md-12 col-sm-12 col-xs-12\">\n" +
        "            <!--企业获奖次数-->\n" +
        "            <div class=\"panel panel-info col-lg-4 col-md-4 col-sm-4 col-xs-4\">\n" +
        "                <div class=\"panel-heading\">\n" +
        "                    <h3 class=\"panel-title\">企业获奖次数</h3>\n" +
        "                </div>\n" +
        "                <div class=\"panel-body\">\n" +
        "                    <div class=\"block-show col-lg-6 col-md-6 col-sm-6 col-xs-6\">\n" +
        "                        <div class=\"input-group input-group-lg\">\n" +
        "                            <span class=\"input-group-addon\">区级</span>\n" +
        "                            <input id=\"award-district\" name=\"awarddistrict\" type=\"number\" class=\"form-control\">\n" +
        "                            <span class=\"input-group-addon\">次</span>\n" +
        "                        </div>\n" +
        "                    </div>\n" +
        "                    <div class=\"block-show col-lg-6 col-md-6 col-sm-6 col-xs-6\">\n" +
        "                        <div class=\"input-group input-group-lg\">\n" +
        "                            <span class=\"input-group-addon\">市级&nbsp;&nbsp;&nbsp;</span>\n" +
        "                            <input id=\"award-city\" name=\"awardcity\" type=\"number\" class=\"form-control\">\n" +
        "                            <span class=\"input-group-addon\">次</span>\n" +
        "                        </div>\n" +
        "                    </div>\n" +
        "                    <div class=\"block-show col-lg-6 col-md-6 col-sm-6 col-xs-6\">\n" +
        "                        <div class=\"input-group input-group-lg\">\n" +
        "                            <span class=\"input-group-addon\">省级</span>\n" +
        "                            <input id=\"award-province\" name=\"awardprovince\" type=\"number\" class=\"form-control\">\n" +
        "                            <span class=\"input-group-addon\">次</span>\n" +
        "                        </div>\n" +
        "                    </div>\n" +
        "                    <div class=\"block-show col-lg-6 col-md-6 col-sm-6 col-xs-6\">\n" +
        "                        <div class=\"input-group input-group-lg\">\n" +
        "                            <span class=\"input-group-addon\">国家级</span>\n" +
        "                            <input id=\"award-nation\" name=\"awardnation\" type=\"number\" class=\"form-control\">\n" +
        "                            <span class=\"input-group-addon\">次</span>\n" +
        "                        </div>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "            </div>\n" +
        "            <!--企业认定-->\n" +
        "            <div class=\"panel panel-info col-lg-4 col-md-4 col-sm-4 col-xs-4\">\n" +
        "                <div class=\"panel-heading\">\n" +
        "                    <h3 class=\"panel-title\">企业认定次数</h3>\n" +
        "                </div>\n" +
        "                <div class=\"panel-body\">\n" +
        "                    <div class=\"block-show col-lg-6 col-md-6 col-sm-6 col-xs-6\">\n" +
        "                        <div class=\"input-group input-group-lg\">\n" +
        "                            <span class=\"input-group-addon\">区级</span>\n" +
        "                            <input id=\"confirm-district\" name=\"comfirmdistrict\" type=\"number\" class=\"form-control\">\n" +
        "                            <span class=\"input-group-addon\">次</span>\n" +
        "                        </div>\n" +
        "                    </div>\n" +
        "                    <div class=\"block-show col-lg-6 col-md-6 col-sm-6 col-xs-6\">\n" +
        "                        <div class=\"input-group input-group-lg\">\n" +
        "                            <span class=\"input-group-addon\">市级&nbsp;&nbsp;&nbsp;</span>\n" +
        "                            <input id=\"confirm-city\" name=\"confirmcity\" type=\"number\" class=\"form-control\">\n" +
        "                            <span class=\"input-group-addon\">次</span>\n" +
        "                        </div>\n" +
        "                    </div>\n" +
        "                    <div class=\"block-show col-lg-6 col-md-6 col-sm-6 col-xs-6\">\n" +
        "                        <div class=\"input-group input-group-lg\">\n" +
        "                            <span class=\"input-group-addon\">省级</span>\n" +
        "                            <input id=\"confirm-province\" name=\"comfirmprovince\" type=\"number\" class=\"form-control\">\n" +
        "                            <span class=\"input-group-addon\">次</span>\n" +
        "                        </div>\n" +
        "                    </div>\n" +
        "                    <div class=\"block-show col-lg-6 col-md-6 col-sm-6 col-xs-6\">\n" +
        "                        <div class=\"input-group input-group-lg\">\n" +
        "                            <span class=\"input-group-addon\">国家级</span>\n" +
        "                            <input id=\"confirm-nation\" name=\"comfirmnation\" type=\"number\" class=\"form-control\">\n" +
        "                            <span class=\"input-group-addon\">次</span>\n" +
        "                        </div>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "            </div>\n" +
        "            <!--人才资助-->\n" +
        "            <div class=\"panel panel-info col-lg-4 col-md-4 col-sm-4 col-xs-4\">\n" +
        "                <div class=\"panel-heading\">\n" +
        "                    <h3 class=\"panel-title\">人才资助</h3>\n" +
        "                </div>\n" +
        "                <div class=\"panel-body\">\n" +
        "                    <div class=\"block-show col-lg-6 col-md-6 col-sm-6 col-xs-6\">\n" +
        "                        <div class=\"input-group input-group-lg\">\n" +
        "                            <span class=\"input-group-addon\">区级</span>\n" +
        "                            <input id=\"support-district\" name=\"supportdistrict\" type=\"number\" class=\"form-control\">\n" +
        "                            <span class=\"input-group-addon\">人</span>\n" +
        "                        </div>\n" +
        "                    </div>\n" +
        "                    <div class=\"block-show col-lg-6 col-md-6 col-sm-6 col-xs-6\">\n" +
        "                        <div class=\"input-group input-group-lg\">\n" +
        "                            <span class=\"input-group-addon\">市级&nbsp;&nbsp;&nbsp;</span>\n" +
        "                            <input id=\"support-city\" name=\"supportcity\" type=\"number\" class=\"form-control\">\n" +
        "                            <span class=\"input-group-addon\">人</span>\n" +
        "                        </div>\n" +
        "                    </div>\n" +
        "                    <div class=\"block-show col-lg-6 col-md-6 col-sm-6 col-xs-6\">\n" +
        "                        <div class=\"input-group input-group-lg\">\n" +
        "                            <span class=\"input-group-addon\">省级</span>\n" +
        "                            <input id=\"support-province\" name=\"supportprovince\" type=\"number\" class=\"form-control\">\n" +
        "                            <span class=\"input-group-addon\">人</span>\n" +
        "                        </div>\n" +
        "                    </div>\n" +
        "                    <div class=\"block-show col-lg-6 col-md-6 col-sm-6 col-xs-6\">\n" +
        "                        <div class=\"input-group input-group-lg\">\n" +
        "                            <span class=\"input-group-addon\">国家级</span>\n" +
        "                            <input id=\"support-nation\" name=\"supportnation\" type=\"number\" class=\"form-control\">\n" +
        "                            <span class=\"input-group-addon\">人</span>\n" +
        "                        </div>\n" +
        "                    </div>\n" +
        "                </div>\n" +
        "            </div>\n" +
        "        </div>\n" +
        "        <!--相关文件-->\n" +
        "        <div class=\"panel panel-info\">\n" +
        "            <div class=\"panel-heading\">\n" +
        "                <h3 class=\"panel-title\">相关证明文件</h3>\n" +
        "            </div>\n" +
        "            <div class=\"panel-body\">\n" +
        "                <div class=\"input-group input-group-lg\">\n" +
        "                    <span class=\"input-group-addon\">文件路径</span>\n" +
        "                    <input id=\"prove-input\" name=\"prove\" type=\"file\" class=\"form-control\">\n" +
        "                </div>\n" +
        "            </div>\n" +
        "        </div>\n" +
        "\n" +
        "        <div id=\"submit-form-btn\" class=\"btn btn-warning btn-lg btn-block\" v-on:click=\"submit()\">\n" +
        "            已确认无误并上传\n" +
        "        </div>\n" +
        "    </form>\n" +
        // "<iframe name='hidden_frame' id=\"hidden_frame\" style=\"display:none\"></iframe>   \n" +
        "</div>" ,
}