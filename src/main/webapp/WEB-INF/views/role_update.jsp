<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zh">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
<title>首页 - 光年(角色添加)OA管理系统</title>
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
					更新角色
				</div>
				<div class="card-body">
					<form class="form-horizontal" action="${pageContext.request.contextPath}/role/update" method="post">
						<input type="hidden" name="roleId" value="${role.roleId}">
					  <div class="form-group">
						<label class="col-md-3 control-label" for="example-hf-role">角色名称</label>
						<div class="col-md-7">
						  <input class="form-control" type="text" id="example-hf-role" name="roleName" value="${role.roleName}">
						</div>
					  </div>
					  <div class="form-group">
						<label class="col-md-3 control-label">是否有效</label>
						<div class="col-md-7">
						  <label class="radio-inline" for="example-inline-radio1">
							  <input type="radio" <c:if test="${role.status eq '有效'}">checked</c:if> id="example-inline-radio1" name="status" value="有效">
						    有效
						  </label>
						  <label class="radio-inline" for="example-inline-radio2">
						    <input type="radio" <c:if test="${role.status eq '无效'}">checked</c:if> id="example-inline-radio2" name="status" value="无效">
						    无效
						  </label>
						</div>
					  </div>
					  <div class="form-group">
						<div class="col-md-9 col-md-offset-3">
						  <button class="btn btn-lg btn-info" type="submit">更新</button>
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