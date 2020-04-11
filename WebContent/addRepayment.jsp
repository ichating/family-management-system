<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.family.oa.entity.RepaymentEntity" %>
<%@ page import="com.family.oa.entity.TypesEntity" %>
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
<title>支出记录管理</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/static/bootstrap-3.3.5/dist/css/bootstrap.min.css">
<link rel="shortcut icon" href="./img/favicon.png" type="image/x-icon" />
<script  type="text/javascript" src="<%=basePath%>/static/WEB_INF/bootstrap-3.3.5/dist/js/jquery-1.12.1.js"></script>
<script  type="text/javascript" src="<%=basePath%>/static/WEB_INF/bootstrap-3.3.5/dist/js/bootstrap.js"></script>
<!-- href：里面的路径是你导入在static文件夹里面下面bootstrap.min.css所在的路径，下面两个属性一样 -->
<script type="text/javascript" src="<%=basePath%>/static/bootstrap-3.3.5/dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/static/bootstrap-3.3.5/js/tests/vendor/jquery.min.js"></script>
</head>
<body>
		  	<%
				List<TypesEntity> typesList = (List<TypesEntity>)request.getAttribute("findAllTypes"); 
		  	    List<UserEntity> userList = (List<UserEntity>)request.getAttribute("findAllUsers");
			%>
<div class="row">
	<div class="col-md-12">
	<h2 class="text-center">欢迎<%=request.getSession().getAttribute("userName").toString()%>登录家庭金融管理系统</h2>
	</div>
</div>
<h1></h1>
	<div class="row">
		 <div class="col-md-2">
		  	<ul class="nav nav-pills nav-stacked">
			  <li ><a href="./manager.jsp"><span class="glyphicon glyphicon-home"></span> 首页</a></li>
			  <li class="active"><a href="findRepaymentByPageServlet.out"><span class="glyphicon glyphicon-credit-card"></span> 支出管理</a></li>
			  <li ><a href="loans.go"><span class="glyphicon glyphicon-cutlery"></span> 贷款管理</a></li>
			  <li ><a href="findUserByPageServlet.do"><span class="glyphicon glyphicon-user"></span> 用户管理</a></li>
			  <li><a href="logOut.do"><span class="glyphicon glyphicon-cog"></span> 退出</a></li>
			</ul>
		  </div>
		  <div class="col-md-3">
				<form class="form-horizontal" action="addRepayment.out" method="get" role="form">
					  <div class="form-group">
					    <label for="name">名称</label>
    					 <select name="name" class="form-control input-sm">
						  		<% 
									for(TypesEntity type :typesList){
								%>       <option value=<%=type.getName() %>><%=type.getName() %></option>
								<% 
									} 
								%>
						 </select> 
					  </div>
					  <div class="form-group">
					    <label for="repayment_user">支付人</label>
					    <select name="repayment_user" class="form-control input-sm" >
							<% 
									for(UserEntity user :userList){
								%>       <option value=<%=user.getName() %>><%=user.getName() %></option>
								<% 
									} 
								%>
						</select>
					  </div>
					   <div class="form-group">
					    <label for="repayment_amount">支出金额</label>
					    <input class="form-control input-sm" type="text" name="repayment_amount" placeholder="请输入支出金额">
					  </div>
 					 <div class="form-group">
						  <label for="update_time">支出日期</label>
						  <input type="date" name="update_time" class="form-control input-sm">
					  </div>
					  <div class="form-group">
							<label for="remarks">备注</label>
							<input class="form-control input-sm"  type="text" name="remarks" >
					  </div>
					  <input type="submit" value="保存" class="btn btn-success btn-sm form-control">
				</form>
			</div>
</body>
</html>