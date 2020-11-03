<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"/>
    <title>员工 - (更改员工信息)OA管理系统</title>
    <link rel="icon" href="../../images/favicon.ico" type="image/ico">
    <meta name="keywords" content="OA,光年OA管理系统">
    <meta name="description" content="光年OA管理系统">
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
                            更新员工信息
                        </div>
                        <div class="card-body">
                            <form class="form-horizontal" action="${pageContext.request.contextPath}/employee/update"
                                  method="post">
                                <input type="hidden" name="empId" value="${employee.empId}">
                                <div class="form-group">
                                    <label class="col-md-3 control-label" for="example-hf-day">员工姓名</label>
                                    <div class="col-md-7">
                                        <input class="form-control" type="text" id="example-hf-day" name="empName"
                                               value="${employee.empName}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label" for="example-manage">角色名称</label>
                                    <div class="col-md-7">
                                        <select style="padding: 10px 0;" class="form-control" id="example-manage"
                                                name="role.roleId" size="1">
                                            <c:forEach items="${roles}" var="r">
                                                <option
                                                        <c:if test="${employee.role.roleId eq r.roleId}">selected</c:if>
                                                        value="${r.roleId}">${r.roleName}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label" for="example-manager">所属部门</label>
                                    <div class="col-md-7">
                                        <select style="padding: 10px 0;" class="form-control" id="example-manager"
                                                name="dept.deptId" size="1">
                                            <c:forEach items="${departments}" var="dept">
                                                <option
                                                        <c:if test="${employee.dept.deptId eq dept.deptId}">selected</c:if>
                                                        value="${dept.deptId}">${dept.deptName}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label">性别</label>
                                    <div class="col-md-7">
                                        <label class="radio-inline" for="example-inline-radio1">
                                            <input type="radio"
                                                   <c:if test="${employee.gender eq '男'}">checked</c:if>
                                                   id="example-inline-radio1" name="gender" value="男">
                                            男
                                        </label>
                                        <label class="radio-inline" for="example-inline-radio2">
                                            <input type="radio"
                                                   <c:if test="${employee.gender eq '女'}">checked</c:if>
                                                   id="example-inline-radio2" name="gender" value="女">
                                            女
                                        </label>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label" for="example-hf-email">邮箱</label>
                                    <div class="col-md-7">
                                        <input class="form-control" type="email" id="example-hf-email" name="email"
                                               value="${employee.email}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label" for="example-hf-phone">手机</label>
                                    <div class="col-md-7">
                                        <input class="form-control" type="text" id="example-hf-phone" name="phone"
                                               value="${employee.phone}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label" for="example-hf-qq">QQ</label>
                                    <div class="col-md-7">
                                        <input class="form-control" type="text" id="example-hf-qq" name="qq"
                                               value="${employee.qq}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label" for="example-hf-hire">入职日期</label>
                                    <div class="col-md-7">
                                        <input class="form-control" type="date" id="example-hf-hire" name="hireTime"
                                               value='<fmt:formatDate pattern="yyyy-MM-dd" value="${employee.hireTime}"/>'>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-md-9 col-md-offset-3">
                                        <button class="btn btn-primary" type="submit">更新</button>
                                    </div>
                                </div>
                            </form>
                            <form class="form-horizontal" action="${pageContext.request.contextPath}/employee/update"
                                  method="post">
                                <input type="hidden" name="empId" value="${employee.empId}">
                                <div class="form-group">
                                    <label class="col-md-3 control-label" for="example-hf-pwd">设置密码</label>
                                    <div class="col-md-7">
                                        <input class="form-control" type="text" id="example-hf-pwd" name="empPassword"
                                               value="${employee.empPassword}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-md-9 col-md-offset-3">
                                        <button class="btn btn-warning" type="submit">重置员工密码</button>
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