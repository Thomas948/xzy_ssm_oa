<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/31
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"/>
    <title>个人信息-更改</title>
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
                        <span class="navbar-page-title"> 员工 - 个人信息 </span>
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

                                <div class="edit-avatar">
                                    <img id="tx" <c:if test="${current.icon==null}">src='${pageContext.request.contextPath}/images/users/avatar.jpg'</c:if> src="${current.icon}" alt="..." class="img-avatar">
                                    <div class="avatar-divider"></div>
                                    <div class="edit-avatar-content">
                                        <button class="btn btn-default" onclick="openFile()">修改头像</button>
                                        <p class="m-0">选择一张你喜欢的图片，裁剪后会自动生成264x264大小，上传图片大小不能超过2M。</p>
                                    </div>
                                </div>
                                <hr>
                                <form method="post" action="${pageContext.request.contextPath}/updateInfo" class="site-form">
                                    <input type="hidden" name="empId" value="${current.empId}">
                                    <input type="file" id="file" onchange="upload()" style="display: none">
                                    <input type="hidden" name="icon" id="icon" value="${current.icon }">
                                    <div class="form-group">
                                        <label for="phone">手机</label>
                                        <input type="text" class="form-control" id="phone" name="phone" value="${current.phone}"/>
                                    </div>
                                    <div class="form-group">
                                        <label for="qq">QQ</label>
                                        <input type="text" class="form-control" id="qq" name="qq" value="${current.qq}">
                                    </div>
                                    <div class="form-group">
                                        <label for="email">邮箱/用户名</label>
                                        <input type="email" class="form-control" id="email"
                                               aria-describedby="emailHelp" name="email"
                                               value="${current.email}">
                                        <small id="emailHelp" class="form-text text-muted">请保证您填写的邮箱地址是正确的。</small>
                                        <div class="row">
                                            <span style='color: green'>${msg}</span>
                                        </div>
                                    </div>
                                    <input type="submit" class="btn btn-primary" value="保存">
                                    <%--<button onclick="saveInfo()" class="btn btn-primary">保存</button>--%>
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
<script type="text/javascript">
    function openFile() {
        $("#file").click();
    }

    function upload() {
        var fd = new FormData();
        fd.append("file", $("#file")[0].files[0]);

        $.ajax({
            url: "${pageContext.request.contextPath}/imageUpload",
            type: "post",
            data: fd,
            contentType: false,
            processData: false,
            dataType: "json",
            success: function (d) {
                $("#tx").attr("src", d.data);
                $("#icon").val(d.data);
            }
        })
    }

</script>
</body>
</html>
