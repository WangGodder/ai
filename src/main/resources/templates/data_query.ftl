<!DOCTYPE html>
<html lang="en" xmlns:v-on="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="/css/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/bootstrap/css/bootstrap-table.css">
    <script type="text/javascript" src="/js/jquery/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="/js/bootstrap/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/bootstrap/bootstrap-table.js"></script>
    <script type="text/javascript" src="/js/common/tableExport.min.js"></script>
    <script type="text/javascript" src="/js/common/xlsx.core.min.js"></script>
    <script type="text/javascript" src="/js/common/FileSaver.min.js"></script>
    <script type="text/javascript" src="/js/vue/vue.js"></script>
    <script type="text/javascript" src="/js/home/data_query/DataShow.js"></script>
</head>
<body>
<div id="app">
    <div>
        <div class="row col-lg-10 col-md-10 col-sm-10 col-xs-10">
            <div class="block-show col-lg-6 col-md-6 col-sm-6 col-xs-6">
                <div class="input-group input-group-lg">
                    <span class="input-group-addon">公司所在行业</span>
                    <input id="industry" type="text" name="industry" class="form-control">
                </div>
            </div>
            <div class="block-show col-lg-6 col-md-6 col-sm-6 col-xs-6">
                <div class="input-group input-group-lg">
                    <span class="input-group-addon">公司所在地</span>
                    <input id="region" type="text" name="region" class="form-control">
                </div>
            </div>
            <div class="block-show col-lg-3 col-md-3 col-sm-3 col-xs-3">
                <div class="input-group input-group-lg ">
                    <span class="input-group-addon">起始年份</span>
                    <input id="beginYear" type="number" name="beginYear" class="form-control">
                    <span class="input-group-addon">年</span>
                </div>
            </div>
            <div class="block-show col-lg-3 col-md-3 col-sm-3 col-xs-3">
                <div class="input-group input-group-lg ">
                    <span class="input-group-addon">截至年份</span>
                    <input id="endYear" type="number" name="endYear" class="form-control">
                    <span class="input-group-addon">年</span>
                </div>
            </div>
            <div class="block-show col-lg-3 col-md-3 col-sm-3 col-xs-3">
                <div class="input-group input-group-lg ">
                    <span class="input-group-addon">起始季度</span>
                    <input id="beginQuarter" type="number" name="beginQuarter" class="form-control">
                </div>
            </div>
            <div class="block-show col-lg-3 col-md-3 col-sm-3 col-xs-3">
                <div class="input-group input-group-lg ">
                    <span class="input-group-addon">截至季度</span>
                    <input id="endQuarter" type="number" name="endQuarter" class="form-control">
                </div>
            </div>
        </div>
        <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2" style="margin-top: 1%; margin-bottom: 1%;">
            <div id="query-btn" class="btn btn-primary btn-lg btn-block" v-on:click="query()">查询</div>
        </div>
    </div>
    <div class="">
        <data-show ref="table" v-if="this.showData" v-bind:query-params="this.queryParams" v-bind:columns="this.columns"></data-show>
    </div>
</div>
</body>
<script type="text/javascript" src="/js/home/data_query/main.js"></script>
</html>