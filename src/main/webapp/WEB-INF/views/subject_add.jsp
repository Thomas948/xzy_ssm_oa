<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
<title>首页 - 光年(添加学科)OA管理系统</title>
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
					新增学科
				</div>
				<div class="card-body">
					<form class="form-horizontal" action="${pageContext.request.contextPath}/subject/add" method="post">
					  <div class="form-group">
						<label class="col-md-3 control-label" for="example-hf-day">学科名称</label>
						<div class="col-md-7">
						  <input class="form-control" type="text" id="example-hf-day" name="subjectName" placeholder="学科名称">
						</div>
					  </div>
					  <div class="form-group">
						<label class="col-md-3 control-label" for="example-hf-hire">成立日期</label>
						<div class="col-md-7">
						  <input class="form-control" type="date" id="example-hf-hire" name="createTime">
						</div>
					  </div>
					  <div class="form-group">
						<label class="col-md-3 control-label" for="example-hf-qq">学科周期</label>
						<div class="col-md-7">
						  <input class="form-control" type="text" id="example-hf-qq" name="subjectLife" placeholder="学科周期">
						</div>
					  </div>
					  <div class="form-group">
						  <label class="col-md-3 control-label" for="example-manager">学科类型</label>
						  <div class="col-md-7">
							<select style="padding: 10px 0;" class="form-control" id="example-manager" name="subjectType.subjectTypeId" size="1">
							  <c:forEach items="${subjectTypes}" var="type">
								  <option value="${type.subjectTypeId}">${type.subjectTypeName}</option>
							  </c:forEach>
							</select>
						  </div>
					  </div>
					  <div class="form-group">
						<div class="col-md-9 col-md-offset-3">
						  <button class="btn btn-primary" type="submit">新增学科</button>
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
\
</body>
</html>