<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/29
  Time: 18:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"/>
    <title>首页 - 光年OA管理系统</title>
    <link rel="icon" href="${pageContext.request.contextPath}/images/favicon.ico" type="image/ico">
    <meta name="keywords" content="OA,光年OA管理系统">
    <meta name="description" content="光年OA管理系统">
    <meta name="author" content="yinqi">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/materialdesignicons.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.min.css" rel="stylesheet">
</head>

<body>
<div class="lyear-layout-web">
    <div class="lyear-layout-container">
        <!--左侧导航-->
        <jsp:include page="common/menus.jsp"/>
        <!--End 左侧导航-->

        <!--头部信息-->
        <header class="lyear-layout-header">

            <nav class="navbar navbar-default">
                <div class="topbar">

                    <div class="topbar-left">
                        <div class="lyear-aside-toggler">
                            <span class="lyear-toggler-bar"></span>
                            <span class="lyear-toggler-bar"></span>
                            <span class="lyear-toggler-bar"></span>
                        </div>
                        <span class="navbar-page-title"> 后台首页 </span>
                    </div>

                    <jsp:include page="common/header.jsp"/>

                </div>
            </nav>

        </header>
        <!--End 头部信息-->

        <!--页面主要内容-->
        <main class="lyear-layout-content">

            <div class="container-fluid">

                <div class="row">
                    <div class="col-sm-6 col-lg-3">
                        <div class="card bg-primary">
                            <div class="card-body clearfix">
                                <div class="pull-right">
                                    <p class="h6 text-white m-t-0">总访问量</p>
                                    <p class="h3 text-white m-b-0">102,32500</p>
                                </div>
                                <div class="pull-left"><span class="img-avatar img-avatar-48 bg-translucent"><i
                                        class="mdi mdi-currency-cny fa-1-5x"></i></span></div>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-6 col-lg-3">
                        <div class="card bg-danger">
                            <div class="card-body clearfix">
                                <div class="pull-right">
                                    <p class="h6 text-white m-t-0">学员总数</p>
                                    <p class="h3 text-white m-b-0">23,415</p>
                                </div>
                                <div class="pull-left"><span class="img-avatar img-avatar-48 bg-translucent"><i
                                        class="mdi mdi-account fa-1-5x"></i></span></div>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-6 col-lg-3">
                        <div class="card bg-success">
                            <div class="card-body clearfix">
                                <div class="pull-right">
                                    <p class="h6 text-white m-t-0">全年营收</p>
                                    <p class="h3 text-white m-b-0">34,005,000</p>
                                </div>
                                <div class="pull-left"><span class="img-avatar img-avatar-48 bg-translucent"><i
                                        class="mdi mdi-arrow-down-bold fa-1-5x"></i></span></div>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-6 col-lg-3">
                        <div class="card bg-purple">
                            <div class="card-body clearfix">
                                <div class="pull-right">
                                    <p class="h6 text-white m-t-0">新增学员</p>
                                    <p class="h3 text-white m-b-0">153</p>
                                </div>
                                <div class="pull-left"><span class="img-avatar img-avatar-48 bg-translucent"><i
                                        class="mdi mdi-comment-outline fa-1-5x"></i></span></div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">

                    <div class="col-lg-6">
                        <div class="card">
                            <div class="card-body">
                                <div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-6">
                        <div class="card">
                            <div class="card-body">
                                <div id="container2" style="max-width:800px;height:400px"></div>
                            </div>
                        </div>
                    </div>

                </div>

            </div>

        </main>
        <!--End 页面主要内容-->
    </div>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/perfect-scrollbar.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/main.min.js"></script>

<!--图表插件-->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/Chart.js"></script>
<script src="https://code.highcharts.com.cn/highcharts/highcharts.js"></script>
<script src="https://code.highcharts.com.cn/highcharts/modules/exporting.js"></script>
<script src="https://code.highcharts.com.cn/highcharts/modules/drilldown.js"></script>
<script src="https://img.hcharts.cn/highcharts-plugins/highcharts-zh_CN.js"></script>
<script type="text/javascript">


    Highcharts.chart('container', {
        chart: {
            type: 'column'
        },
        title: {
            text: '每周用户'
        },
        subtitle: {
            text: ''
        },
        xAxis: {
            type: 'category'
        },
        yAxis: {
            title: {
                text: '每天用户总数'
            }
        },
        legend: {
            enabled: false
        },
        plotOptions: {
            series: {
                borderWidth: 0,
                dataLabels: {
                    enabled: true,
                    format: '{point.y:.0f}'
                }
            }
        },
        tooltip: {
            headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
            pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.0f}</b><br/>'
        },
        series: [{
            name: '每周新增人数',
            colorByPoint: true,
            data: [{
                name: '周一',
                y: 98,
                drilldown: '周一新增'
            }, {
                name: '周二',
                y: 136,
                drilldown: '周二新增'
            }, {
                name: '周三',
                y: 60,
                drilldown: '周三新增'
            }, {
                name: '周四',
                y: 49,
                drilldown: '周四新增'
            }, {
                name: '周五',
                y: 202,
                drilldown: '周五新增'
            }, {
                name: '周六',
                y: 298,
                drilldown: '周六新增'
            }, {
                name: '周日',
                y: 100,
                drilldown: '周日新增'
            }]
        }],
        drilldown: {}
    });


    Highcharts.chart('container2', {
        title: {
            text: '交易历史记录'
        },
        subtitle: {
            text: ''
        },
        yAxis: {
            title: {
                text: '交易总量'
            }
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle'
        },
        plotOptions: {
            series: {
                label: {
                    connectorAllowed: false
                },
                pointStart: 2015
            }
        },
        series: [{
            name: '交易记录',
            data: [22624, 32503, 47177, 49658, 47031, 36931]
        }],
        responsive: {
            rules: [{
                condition: {
                    maxWidth: 500
                },
                chartOptions: {
                    legend: {
                        layout: 'horizontal',
                        align: 'center',
                        verticalAlign: 'bottom'
                    }
                }
            }]
        }
    });


</script>
</body>
</html>
