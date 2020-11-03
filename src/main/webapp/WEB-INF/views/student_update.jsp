<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"/>
    <title>首页 - 光年(添加学生)OA管理系统</title>
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
                            更新学生信息
                        </div>
                        <div class="card-body">
                            <form class="form-horizontal" action="${pageContext.request.contextPath}/student/update"
                                  method="post">
                                <input type="hidden" name="studentId" value="${student.studentId}">
                                <div class="form-group">
                                    <label class="col-md-3 control-label" for="studentName">学员姓名</label>
                                    <div class="col-md-7">
                                        <input class="form-control" type="text" id="studentName" name="studentName"
                                               value="${student.studentName}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label" for="classes">所属班级</label>
                                    <div class="col-md-7">
                                        <select style="padding: 10px 0;" class="form-control" id="classes"
                                                name="classes.classId" size="1">
                                            <c:forEach items="${classList}" var="cls">
                                                <option
                                                        <c:if test="${student.classes.classId eq cls.classId}">selected</c:if>
                                                        value="${cls.classId}">${cls.className}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label">性别</label>
                                    <div class="col-md-7">
                                        <label class="radio-inline" for="gender1">
                                            <input type="radio"
                                                   <c:if test="${student.stuGender eq '男'}">checked</c:if> id="gender1"
                                                   name="stuGender" value="男">
                                            男
                                        </label>
                                        <label class="radio-inline" for="gender2">
                                            <input type="radio"
                                                   <c:if test="${student.stuGender eq '女'}">checked</c:if> id="gender2"
                                                   name="stuGender" value="女">
                                            女
                                        </label>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label" for="stuEmail">邮箱</label>
                                    <div class="col-md-7">
                                        <input class="form-control" type="email" id="stuEmail" name="stuEmail"
                                               value="${student.stuEmail}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label" for="stuPhone">手机</label>
                                    <div class="col-md-7">
                                        <input class="form-control" type="text" id="stuPhone" name="stuPhone"
                                               value="${student.stuPhone}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label" for="stuQq">QQ</label>
                                    <div class="col-md-7">
                                        <input class="form-control" type="text" id="stuQq" name="stuQq"
                                               value="${student.stuQq}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label" for="cardNum">身份证号</label>
                                    <div class="col-md-7">
                                        <input class="form-control" type="text" id="cardNum" name="cardNum"
                                               value="${student.cardNum}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label" for="graduateSchool">毕业学校</label>
                                    <div class="col-md-7">
                                        <input class="form-control" type="text" id="graduateSchool"
                                               name="graduateSchool" value="${student.graduateSchool}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label" for="education">学历</label>
                                    <div class="col-md-7">
                                        <select style="padding: 10px 0;" class="form-control" id="education"
                                                name="education.educationId" size="1">
                                            <c:forEach items="${educationList}" var="edu">
                                                <option
                                                        <c:if test="${student.education.educationId eq edu.educationId}">selected</c:if>
                                                        value="${edu.educationId}">${edu.educationName}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label" for="birthday">出生日期</label>
                                    <div class="col-md-7">
                                        <input class="form-control" type="date" id="birthday" name="createTime"
                                               value='<fmt:formatDate pattern="yyyy-MM-dd" value="${student.createTime}"/>'>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label" for="AdmissionTime">入学日期</label>
                                    <div class="col-md-7">
                                        <input class="form-control" type="date" id="AdmissionTime" name="inTime"
                                               value='<fmt:formatDate pattern="yyyy-MM-dd" value="${student.inTime}"/>'>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label" for="teacher">招生老师</label>
                                    <div class="col-md-7">
                                        <select style="padding: 10px 0;" class="form-control" id="teacher"
                                                name="teacher.empId" size="1">
                                            <c:forEach items="${employees}" var="emp">
                                                <option
                                                        <c:if test="${student.teacher.empId eq emp.empId}">selected</c:if>
                                                        value="${emp.empId}">${emp.empName}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-md-9 col-md-offset-3">
                                        <button class="btn btn-primary" type="submit">更新</button>
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