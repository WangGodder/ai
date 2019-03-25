<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户登录</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <script type="text/javascript" src="/js/jquery/jquery-3.2.1.min.js"></script>
    <script  src="/js/vue/vue.js"></script>
    <script type = text/javascript src="/js/vue/vue_common.js"></script>
    <script type = text/javascript src="/js/utils.js"></script>
    <script type = text/javascript src="/js/layui/layui.all.js"></script>
    <script type = text/javascript src="/js/common/sv2.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="/css/login.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="login_box">
    <div class="login_l_img"><img src="/img/index_logo.jpg" /></div>
    <div class="login">
        <div class="login_logo"><a href="#"><img src="/img/login_logo.png" /></a></div>
        <div class="login_name">
            <p>企业评估系统</p>
        </div>
        <form method="post" id="userLogin">
            <input name="username" type="text" placeholder="用户名" v-model="username">
            <input name="password" type="password" id="password" placeholder="密码" v-model="password">
            <input value="登录" style="width:100%;" type="button" @click="login">
            <div style="width: 100%">
                <span ><a href="/user/index/" style="">找回密码</a></span>
                <span ><a href="/user/register/" style="padding-left: 190px">立即注册</a></span>
            </div>
        </form>
    </div>
    <div class="navbar-fixed-bottom copyright">
        <span style="width: 33%;text-align: left">版权：上海万事登信息科技有限公司版权所有</span>
        <span style="width: 33%;text-align: center">地址：上海市杨浦区加嘴路3805号3093室</span>
        <span style="width: 33%;text-align: right">邮编：200434</span>
    </div>
</div>
<script type="text/javascript" src="/js/user/login.js"></script>
</body>
</html>