<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"/>
    <title>首页 - 光年(我的列表)OA管理系统</title>
    <link rel="icon" href="../../images/favicon.ico" type="image/ico">
    <meta name="keywords" content="LightYear,光年,后台模板,后台管理系统,光年HTML模板">
    <meta name="description" content="LightYear是一个基于Bootstrap v3.3.7的后台管理系统的HTML模板。">
    <meta name="author" content="yinqi">
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <link href="../../css/materialdesignicons.min.css" rel="stylesheet">
    <link href="../../css/style.min.css" rel="stylesheet">
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
                <!-- 内容区 -->
                <div class="row">
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th>序号</th>
                                        <th>申请人</th>
                                        <th>类型</th>
                                        <th>起始日期</th>
                                        <th>终止日期</th>
                                        <th>天数</th>
                                        <th>描述</th>
                                        <th>结果</th>
                                        <th colspan="2" class="text-center">操作</th>
                                    </tr>
                                    </thead>
                                    <tbody id="tbody">

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- 内容区结束 -->
                <div class="row">
                    <div class="col-lg-4 text-left">
                        <a class="btn btn-success" href="${pageContext.request.contextPath}/attendance/toAdd">添加申请</a>
                    </div>
                    <div class="col-lg-4 text-center">
                        <nav>
                            <ul class="pagination">

                            </ul>
                        </nav>
                    </div>
                    <div class="col-lg-4 text-center">
                        <a class="btn btn-info"
                           href="${pageContext.request.contextPath}/attendance/download">导出Excel</a>
                    </div>
                </div>
            </div>

        </main>
        <!--End 页面主要内容-->
    </div>
</div>

<script type="text/javascript" src="../../js/jquery.min.js"></script>
<script type="text/javascript" src="../../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../js/perfect-scrollbar.min.js"></script>
<script type="text/javascript" src="../../js/main.min.js"></script>

<!--图表插件-->
<script type="text/javascript" src="../../js/Chart.js"></script>
<script type="text/javascript">
    const pageNum = 1;
    const pageSize = 4;
    let pages = 1;
    const hasPre = false;
    const hasNext = false;

    getData(pageNum, pageSize, hasPre, hasNext);

    function getData(pageNum, pageSize, hasPre, hasNext) {

        $.getJSON("${pageContext.request.contextPath}/attendance/getPage", {
            "pageNum": pageNum,
            "pageSize": pageSize
        }, function (d) {
            pageNum = d.pageNum;
            pageSize = d.pageSize;
            pages = d.pages;
            hasPre = d.hasPre;
            hasNext = d.hasNext;
            const list = d.obj;
            let content = "";
            for (let i = 0; i < list.length; i++) {
                content += "<tr>\n" +
                    "<th>" + list[i].attendanceId + "</th>\n" +
                    "<td>" + list[i].applicant.empName + "</td>\n" +
                    "<td>" + list[i].workType.workTypeName + "</td>\n" +
                    "<td>" + list[i].startTime + "</td>\n" +
                    "<td>" + list[i].endTime + "</td>\n" +
                    "<td>" + list[i].days + "</td>\n" +
                    "<td>" + list[i].reason + "</td>\n" +
                    "<td>" + showStatus(list[i].resultStatus) + "</td>\n";
                if (list[i].resultStatus == 0) {
                    content +=
                        "<td class='text-right'><a class='btn btn-success' href='${pageContext.request.contextPath}/attendance/approval/" + list[i].attendanceId + "/" + 1 + "'>通过</a></td>\n" +
                        "<td class='text-left'><a class='btn btn-danger' href='${pageContext.request.contextPath}/attendance/approval/" + list[i].attendanceId + "/" + 2 + "'>不通过</a></td>\n" +
                        "</tr>";
                } else {
                    content += "<td class='text-right'><button onclick=\"alert('已审批');\" class='btn btn-info'>已审批</button></td>\n" +
                        "<td class='text-left'><button onclick=\"alert('已审批');\" class='btn btn-info'>已审批</button></td>\n" +
                        "</tr>";
                }
            }
            $("#tbody").html(content);
            joinPages(pageNum, pages, hasPre, hasNext);
            bindPages(pageNum, pageSize, hasPre, hasNext);
        });
    }

    function joinPages(pageNum, pages, hasPre, hasNext) {
        let i;
        let content = "";
        if (!hasPre) {
            content += "<li class='disabled'><span>«</span></li>";
        } else {
            content += "<li><a id='pre' href='#'>«</a></li>";
        }
        if (pages <= 5) {
            for (i = 1; i <= pages; i++) {
                if (pageNum == i) {
                    content += "<li class='active'><span>" + i + "</span></li>";
                } else {
                    content += "<li><a class='middlePage' href='#'>" + i + "</a></li>";
                }
            }
        } else {
            if (pageNum <= 3) {
                for (i = 1; i <= 5; i++) {
                    if (pageNum == i) {
                        content += "<li class='active'><span>" + i + "</span></li>";
                    } else {
                        content += "<li><a class='middlePage' href='#'>" + i + "</a></li>";
                    }
                }
            } else if (pageNum >= pages - 2) {
                for (i = pages - 4; i <= pages; i++) {
                    if (pageNum == i) {
                        content += "<li class='active'><span>" + i + "</span></li>";
                    } else {
                        content += "<li><a class='middlePage' href='#'>" + i + "</a></li>";
                    }
                }
            } else {
                for (i = pageNum - 2; i <= pageNum + 2; i++) {
                    if (pageNum == i) {
                        content += "<li class='active'><span>" + i + "</span></li>";
                    } else {
                        content += "<li><a class='middlePage' href='#'>" + i + "</a></li>";
                    }
                }
            }
        }
        if (!hasNext) {
            content += "<li class='disabled'><span>»</span></li>";
        } else {
            content += "<li><a id='next' href='#'>»</a></li>";
        }
        $(".pagination").html(content);
    }

    function bindPages(pageNum, pageSize, hasPre, hasNext) {
        $("#pre").click(function () {
            pageNum -= 1;
            getData(pageNum, pageSize, hasPre, hasNext);
        });
        $("#next").click(function () {
            pageNum += 1;
            getData(pageNum, pageSize, hasPre, hasNext);
        });
        const mps = $(".middlePage");
        for (let i = 0; i <= mps.length; i++) {
            $(mps[i]).click(function () {
                pageNum = parseInt(this.innerHTML);
                getData(pageNum, pageSize, hasPre, hasNext);
            });
        }
    }

    function showStatus(status) {
        if (status == 0) {
            return "已提交,待审批";
        } else if (status == 1) {
            return "已通过";
        } else if (status == 2) {
            return "未通过";
        } else {
            return "已结束";
        }
    }
</script>
</body>
</html>