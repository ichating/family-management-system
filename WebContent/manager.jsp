<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<base href="<%=basePath%>">
<head>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/static/bootstrap-3.3.5/dist/css/bootstrap.min.css">
<script  type="text/javascript" src="<%=basePath%>/static/WEB_INF/bootstrap-3.3.5/dist/js/jquery-1.12.1.js"></script>
<script  type="text/javascript" src="<%=basePath%>/static/WEB_INF/bootstrap-3.3.5/dist/js/bootstrap.js"></script>
<!-- href：里面的路径是你导入在static文件夹里面下面bootstrap.min.css所在的路径，下面两个属性一样 -->
<%-- <script type="text/javascript" src="<%=basePath%>/static/bootstrap-3.3.5/dist/js/bootstrap.min.js"></script> --%>
<script type="text/javascript" src="<%=basePath%>/static/bootstrap-3.3.5/js/tests/vendor/jquery.min.js"></script>
<link rel="icon" href="/family/img/favicon.png" type="image/x-icon" />
<link rel="shortcut icon" href="/family/img/favicon.png" type="image/x-icon" />
<link rel="bookmark" href="/family/img/favicon.png" type="image/x-icon" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>家庭OA管理系统</title>
</head>
<body>
	<div class="row">
	 <div class="col-md-2">
	  	<ul class="nav nav-pills nav-stacked">
		  <li class="active"><a href="/family/manager.jsp"><span class="glyphicon glyphicon-home"></span> 首页</a></li>
		  <li><a href="repayments.out"><span class="glyphicon glyphicon-credit-card"></span> 支出管理</a></li>
		  <li ><a href="loans.go"><span class="glyphicon glyphicon-cutlery"></span> 贷款管理</a></li>
		  <li ><a href="users.do"><span class="glyphicon glyphicon-user"></span> 用户管理</a></li>
		  <li><a href="/family"><span class="glyphicon glyphicon-cog"></span> 退出</a></li>
		</ul>
	  </div>
	  <div class="col-md-10">
	  	  <h1>欢迎<%=request.getSession().getAttribute("userName").toString().substring(1, (request.getSession().getAttribute("userName").toString().length()-1)) %>登录</h1>
	  </div>
	  <img src="/family/img/index.png" alt="..." class="img-circle">
</body>
</html>