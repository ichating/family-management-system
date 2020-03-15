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
<script  type="text/javascript" src="<%=basePath%>/static/WEB_INF/bootstrap-3.3.5/dist/js/jquery-1.12.1.js"></script>
<script  type="text/javascript" src="<%=basePath%>/static/WEB_INF/bootstrap-3.3.5/dist/js/bootstrap.js"></script>
<!-- href：里面的路径是你导入在static文件夹里面下面bootstrap.min.css所在的路径，下面两个属性一样 -->
<script type="text/javascript" src="<%=basePath%>/static/bootstrap-3.3.5/dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/static/bootstrap-3.3.5/js/tests/vendor/jquery.min.js"></script>
<title>用户管理</title>
</head> 
<body>
	<div class="row">
	 <div class="col-md-2">
	  	<ul class="nav nav-pills nav-stacked">
		  <li ><a href="/family/manager.jsp"><span class="glyphicon glyphicon-home"></span> 首页</a></li>
		  <li><a href="repayments.out"><span class="glyphicon glyphicon-credit-card"></span> 支出管理</a></li>
		  <li ><a href="loans.go"><span class="glyphicon glyphicon-cutlery"></span> 贷款管理</a></li>
		  <li class="active"><a href="users.do"><span class="glyphicon glyphicon-user"></span> 用户管理</a></li>
		  <li><a href="/family"><span class="glyphicon glyphicon-cog"></span> 退出</a></li>
		</ul>
	  </div>

	  <div class="col-md-10">
	  		   <div class="row">
					  <div class="col-md-11">
					  	<form action="findUserByNameOrTel.do" method="post">
					  	<span class="glyphicon glyphicon-user"></span> 姓名:<input type="text" name="name">&nbsp;&nbsp;&nbsp;&nbsp;
					  	<label for="user_name"><span class="glyphicon glyphicon-earphone"></span> 电话:<input type="text" name="tel">&nbsp;&nbsp;&nbsp;&nbsp;
					  	<span class="glyphicon glyphicon-search"></span> <input type="submit" value="查 询">
					  	</form>
					  </div>
					  <div class="col-md-1">
					  <a href="/family/addUsers.jsp" class="btn btn-primary btn-default btn-sm">添加</a></div>
				</div>
	  		<%
				List<UserEntity> list = (List<UserEntity>)request.getAttribute("findAll");
			%>
			<table  class="table table-hover table-bordered table-condensed table-responsive">
				<thead>
					<tr>
						<th>编号</th><th>用户名</th><th>姓名</th><th>密码</th><th>生日</th><th>电话</th><th>备注</th><th>更新日期</th><th>操作</th>
					</tr>
				</thead>
				<tbody>
					<% 
						for(UserEntity user :list){
					%>
					<tr>
						<td><%= user.getId() %></td>
						<td><%= user.getUser_name() %></td>
						<td><%= user.getName()%></td>
						<td><%= user.getUser_password() %></td>
						<td><%= user.getBirthday() %></td>
						<td><%= user.getTel()%></td>
						<td><%= user.getRemarks() %></td>
						<td><%= user.getUpdate_time() %></td>
						<td>
							<a href="delUser.do?userId=<%=user.getId() %>">删除</a>
							<a href="findOne.do?userId=<%=user.getId() %>">修改</a>
						</td>
					</tr>
					<% 
						} 
					%>
				</tbody>
			</table>
	  <div class="row">
</div>
</body>
</html>