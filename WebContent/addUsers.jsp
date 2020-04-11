<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.family.oa.entity.UserEntity" %>
<%@ page import="java.util.List" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=basePath%>/static/bootstrap-3.3.5/dist/css/bootstrap.min.css">
<link rel="shortcut icon" href="./img/favicon.png" type="image/x-icon" />
<script  type="text/javascript" src="<%=basePath%>/static/WEB_INF/bootstrap-3.3.5/dist/js/jquery-1.12.1.js"></script>
<script  type="text/javascript" src="<%=basePath%>/static/WEB_INF/bootstrap-3.3.5/dist/js/bootstrap.js"></script>
<!-- href：里面的路径是你导入在static文件夹里面下面bootstrap.min.css所在的路径，下面两个属性一样 -->
<script type="text/javascript" src="<%=basePath%>/static/bootstrap-3.3.5/dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/static/bootstrap-3.3.5/js/tests/vendor/jquery.min.js"></script>
<title>用户管理</title>
</head> 
<body>
<div class="row">
	<div class="col-md-12">
	<h2 class="text-center">欢迎<%=request.getSession().getAttribute("userName").toString()%>登录家庭金融管理系统</h2>
	</div>
</div>
<h1></h1>
	<div class="row">
	 <div class="col-md-2">
	  	<ul class="nav nav-pills nav-stacked">
		  <li><a href="./manager.jsp"><span class="glyphicon glyphicon-home"></span> 首页</a></li>
		  <li><a href="findRepaymentByPageServlet.out"><span class="glyphicon glyphicon-credit-card"></span> 支出管理</a></li>
		  <li ><a href="loans.go"><span class="glyphicon glyphicon-cutlery"></span> 贷款管理</a></li>
		  <li class="active"><a href="findUserByPageServlet.do"><span class="glyphicon glyphicon-user"></span> 用户管理</a></li>
		  <li><a href="logOut.do"><span class="glyphicon glyphicon-cog"></span> 退出</a></li>
		</ul>
	  </div>
	  <div class="col-md-10">
				<div class="row">
				 	 <div class="col-md-3">
			 	 		<form action="addUser.do" method="get" role="form">
			 	 		<div class="form-group">
							<label for="user_loginName">用户名:</label>
							<input type="text" class="form-control input-sm" name="user_loginName">
						</div>
						<div class="form-group">
							<label for="user_name">姓名:</label>
							<input type="text" class="form-control input-sm" name="user_name">
						</div>
						<div class="form-group">
							<label for="user_password">密码:</label>
							<input class="form-control input-sm" type="text" name="user_password">
						</div>
						<div class="form-group">
							<label for="user_birthday">生日:</label>
							<input class="form-control input-sm" type="date" name="user_birthday">
						</div>
						<div class="form-group">
							<label for="user_tel">电话:</label>
							<input type="text" class="form-control input-sm" name="user_tel">
						</div>
						<div class="form-group">
							<label for="remarks">备注:</label>
							<input type="text" class="form-control input-sm" name="remarks">
						</div>
		
						<input type="submit" class="btn btn-success btn-sm form-control" value="保存">
						</form>
				 	</div>
				 </div>
	  <div class="row">
</div>


	
</body>
</html>