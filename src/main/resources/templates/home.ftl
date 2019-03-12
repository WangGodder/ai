<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>人才企业智能评估平台</title>
    <link rel="stylesheet" href="/css/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/home.css">
    <script type="text/javascript" src="/js/jquery/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="/js/bootstrap/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/vue/vue.js"></script>
    <script type="text/javascript" src="/js/vue/vue-i18n.js"></script>
    <script type="text/javascript" src="/js/home/data/SelfCompany.js"></script>
    <script type="text/javascript" src="/js/home/data/UserQuery.js"></script>
    <script type="text/javascript" src="/js/home/data/WeightQuery.js"></script>
    <script type="text/javascript" src="/js/home/upload/ExcelUpload.js"></script>
    <script type="text/javascript" src="/js/home/upload/FormUpload.js"></script>
    <script type="text/javascript" src="/js/home/upload/ImageUpload.js"></script>
    <script type="text/javascript" src="/js/home/upload/VoiceUpload.js"></script>
    <script type="text/javascript" src="/js/home/evaluate/ChartConfig.js"></script>
    <script type="text/javascript" src="/js/home/DataPage.js"></script>
    <script type="text/javascript" src="/js/home/EvaluatePage.js"></script>
    <script type="text/javascript" src="/js/home/IndexPage.js"></script>
    <script type="text/javascript" src="/js/home/UploadPage.js"></script>
    <script type="text/javascript" src="/js/home/utils.js"></script>
    <script type="text/javascript" src="/js/home/App.js"></script>
    <script type = text/javascript src="/js/lib/jquery.form.js"></script>
    <script type = text/javascript src="/js/utils.js"></script>
    <script type = text/javascript src="/js/layui/layui.all.js"></script>
    <script type = text/javascript src="/js/common/sv2.js"></script>
</head>
<body>
<div id="app">
    <div id="head">
        <div id="title" class="row">
            <!--左侧系统图标与名称-->
            <div id="title-show" class="col-lg-9 col-md-9 col-sm-8 col-xs-8 container-fluid">
                <div id="log" class="col-lg-4 col-md-4 col-sm-4 col-xs-4"><img src="/img/logo.jpg" class="img-responsive img-circle"></div>
                <div id="title-name" class="col-lg-8 col-md-8 col-sm-8 col-xs-8">
                    <p class="h1" style="font-size: 54px;">人才企业智能评估平台</p>
                    <p class="h3 ">Intelligent Evaluation Platform for Enterprises</p>
                    <!--时间显示-->
                    <div id="time-show">
                        <div class="bg-info well well-sm block-show">
                            <span id="time" class="text-success h3"></span>
                        </div>
                    </div>
                </div>
            </div>
            <!--右侧用户状态操作面板 -->
            <div id="title-option" class="col-lg-offset-1 col-md-offset-1 col-sm-offset-1 col-xs-offset-1 col-lg-2 col-md-2 col-sm-2 col-xs-2">
                <!--用户信息展示-->
                <div class="row">
                    <img id="user-avater" src="/img/user-avater.png" class="img-responsive img-circle col-lg-4 col-md-4 col-sm-4 col-xs-4">
                    <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8 text-left">
                        <p>, 你好</p>
                        <p></p>
                    </div>
                </div>
                <!--用户操作列表-->
                <div class="row">
                    <div class="col-lg-offset-2 col-md-offset-2 col-sm-offset-2 col-xs-offset-2 col-lg-8 col-md-8 col-sm-8 col-xs-8">
                        <div class="btn btn-block btn-primary">查看消息 <span class="badge">4</span></div>
                        <div class="btn btn-block btn-primary">帮助</div>
                        <div class="btn btn-block btn-primary">用户管理</div>
                        <div class="btn btn-block btn-primary">退出登录</div>
                    </div>

                </div>
            </div>
        </div>
        <!--功能导航-->
        <div id="navigation" class="row">

            <!--具体功能导航-->
            <div id="function-navigation" class="col-lg-12 col-md-12 col-sm-12 col-xs-12 row">
                <div id="index-page-btn" v-on:click="change_page(0)" class="btn btn-success btn-lg col-lg-3 col-md-3 col-sm-3 col-xs-3">首页</div>
                <div id="upload-page-btn" v-on:click="change_page(1)" class="btn btn-info btn-lg col-lg-3 col-md-3 col-sm-3 col-xs-3">数据上传</div>
                <div id="data-page-btn" v-on:click="change_page(2)" class="btn btn-info btn-lg col-lg-3 col-md-3 col-sm-3 col-xs-3">数据查看</div>
                <div id="evaluate-page-btn" v-on:click="change_page(3)" class="btn btn-info btn-lg col-lg-3 col-md-3 col-sm-3 col-xs-3">数据评估</div>
            </div>
        </div>
    </div>
    <!--不同功能的子页面-->
    <div id="pages">
        <index-page v-if="this.page_show[0]"></index-page>
        <upload-page v-show="this.page_show[1]"></upload-page>
        <data-page v-show="this.page_show[2]" v-bind:user_type="1"></data-page>
        <evaluate-page v-show="this.page_show[3]"></evaluate-page>
    </div>

    <!--底部导航条-->
    <div class="bg-info row navbar-fixed-bottom">
        <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3"></div>
        <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3 h5">copyright: 上海万事登信息科技有限公司版权所有</div>
        <div class="col-lg-3 col-md-3 col-sm-3 col-xs-3 h5">地址:上海市杨浦区加嘴路3805号3093室</div>
        <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2 h5">邮编:200434</div>
    </div>
</div>
</body>
<script type="text/javascript" src="/js/home/main.js"></script>
</html>