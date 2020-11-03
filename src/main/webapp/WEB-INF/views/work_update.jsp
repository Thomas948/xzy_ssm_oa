<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"/>
    <title>首页 - 光年(工作申请)OA管理系统</title>
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
                <div class="col-lg-12">
                    <div class="card">
                        <div class="card-header text-center">
                            请假/加班
                        </div>
                        <div class="card-body">
                            <form class="form-horizontal" action="${pageContext.request.contextPath}/attendance/update"
                                  method="post">
                                <input type="hidden" name="attendanceId" value="${attendance.attendanceId}">
                                <input type="hidden" name="applicant.empId" value="${attendance.applicant.empId}">
                                <div class="form-group">
                                    <label class="col-md-3 control-label" for="example-hf-start">起始日期</label>
                                    <div class="col-md-7">
                                        <input class="form-control" type="date" id="example-hf-start" name="startTime" <c:if test="${attendance.resultStatus != 0}">disabled</c:if>
                                               value='<fmt:formatDate pattern="yyyy-MM-dd" value="${attendance.startTime}"/>'>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label" for="example-hf-end">结束日期</label>
                                    <div class="col-md-7">
                                        <input class="form-control" type="date" id="example-hf-end" name="endTime" <c:if test="${attendance.resultStatus != 0}">disabled</c:if>
                                               value='<fmt:formatDate pattern="yyyy-MM-dd" value="${attendance.endTime}"/>'>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label" for="example-hf-day">涉及天数</label>
                                    <div class="col-md-7">
                                        <input class="form-control" type="text" id="example-hf-day" name="days" <c:if test="${attendance.resultStatus != 0}">disabled</c:if>
                                               value="${attendance.days}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label" for="example-select">操作类型</label>
                                    <div class="col-md-7">
                                        <select style="padding: 10px 0;" class="form-control" id="example-select" <c:if test="${attendance.resultStatus != 0}">disabled</c:if>
                                                name="workType.workTypeId" size="1">
                                            <c:forEach items="${workTypes}" var="wtp">
                                                <option
                                                        <c:if test="${attendance.workType.workTypeId eq wtp.workTypeId}">selected</c:if>
                                                        value="${wtp.workTypeId}">${wtp.workTypeName}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label" for="example-hf-why">说明信息</label>
                                    <div class="col-md-7">
                                        <input class="form-control" type="text" id="example-hf-why" name="reason" <c:if test="${attendance.resultStatus != 0}">disabled</c:if>
                                               value="${attendance.reason}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-md-9 col-md-offset-3">
                                        <button class="btn btn-primary" type="submit">更改申请</button>
                                    </div>
                                </div>
                            </form>
                        </div>
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

</body>
</html>