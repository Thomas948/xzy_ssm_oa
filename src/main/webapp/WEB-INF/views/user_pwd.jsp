<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/31
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"/>
    <title>修改密码 - 半个橙子(1998)</title>
    <link rel="icon" href="${pageContext.request.contextPath}/images/favicon.ico" type="image/ico">
    <meta name="keywords" content="后台模板,后台管理系统,光年HTML模板">
    <meta name="description" content="一个基于Bootstrap v3.3.7的后台管理系统的HTML模板。">
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
                        <span class="navbar-page-title"> 示例页面 - 修改密码 </span>
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
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-body">

                                <form method="post" action="${pageContext.request.contextPath}/updatePwd" class="site-form">
                                    <input type="hidden" name="empId" value="${current.empId}">
                                    <div class="form-group">
                                        <label for="new-pwd">新密码</label>
                                        <input type="text" class="form-control" id="new-pwd" name="empPassword"
                                               placeholder="输入新的密码">
                                    </div>
                                    <input class="btn btn-warning" type="submit" value="修改密码">
                                    <%--<button onclick="updatePwd()" class="btn btn-warning">修改密码</button>--%>
                                    <div class="form-group">
                                        <span style="color: green">${msg}</span>
                                    </div>
                                </form>
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

</body>
</html>
