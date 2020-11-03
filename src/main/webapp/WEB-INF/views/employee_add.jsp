<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"/>
    <title>首页 - 光年(添加员工)OA管理系统</title>
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
                            添加员工
                        </div>
                        <div class="card-body">
                            <form class="form-horizontal" action="${pageContext.request.contextPath}/employee/add"
                                  method="post">
                                <div class="form-group">
                                    <label class="col-md-3 control-label" for="example-hf-day">员工姓名</label>
                                    <div class="col-md-7">
                                        <input class="form-control" type="text" id="example-hf-day" name="empName">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label" for="example-hf-pwd">设置密码</label>
                                    <div class="col-md-7">
                                        <input class="form-control" type="text" id="example-hf-pwd" name="empPassword">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label" for="example-manage">角色名称</label>
                                    <div class="col-md-7">
                                        <select style="padding: 10px 0;" class="form-control" id="example-manage"
                                                name="role.roleId" size="1">
                                            <c:forEach items="${roles}" var="role">
                                                <option value="${role.roleId}">${role.roleName}</option>
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
                                                <option value="${dept.deptId}">${dept.deptName}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label">性别</label>
                                    <div class="col-md-7">
                                        <label class="radio-inline" for="example-inline-radio1">
                                            <input type="radio" checked id="example-inline-radio1" name="gender"
                                                   value="男">
                                            男
                                        </label>
                                        <label class="radio-inline" for="example-inline-radio2">
                                            <input type="radio" id="example-inline-radio2" name="gender" value="女">
                                            女
                                        </label>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label" for="example-hf-email">邮箱</label>
                                    <div class="col-md-7">
                                        <input class="form-control" type="email" id="example-hf-email" name="email"
                                               placeholder="邮箱">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label" for="example-hf-phone">手机</label>
                                    <div class="col-md-7">
                                        <input class="form-control" type="text" id="example-hf-phone" name="phone"
                                               placeholder="手机号">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label" for="example-hf-qq">QQ</label>
                                    <div class="col-md-7">
                                        <input class="form-control" type="text" id="example-hf-qq" name="qq"
                                               placeholder="QQ">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-3 control-label" for="example-hf-hire">入职日期</label>
                                    <div class="col-md-7">
                                        <input class="form-control" type="date" id="example-hf-hire" name="hireTime">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-md-9 col-md-offset-3">
                                        <button class="btn btn-primary" type="submit">添加员工</button>
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