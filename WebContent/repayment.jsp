<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.family.oa.entity.RepaymentEntity" %>
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
<title>支出管理</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/static/bootstrap-3.3.5/dist/css/bootstrap.min.css">
<script  type="text/javascript" src="<%=basePath%>/static/WEB_INF/bootstrap-3.3.5/dist/js/jquery-1.12.1.js"></script>
<script  type="text/javascript" src="<%=basePath%>/static/WEB_INF/bootstrap-3.3.5/dist/js/bootstrap.js"></script>
<!-- href：里面的路径是你导入在static文件夹里面下面bootstrap.min.css所在的路径，下面两个属性一样 -->
<script type="text/javascript" src="<%=basePath%>/static/bootstrap-3.3.5/dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/static/bootstrap-3.3.5/js/tests/vendor/jquery.min.js"></script>
</head>
<body>
<div class="row">
	<div class="col-md-4"></div>
	<div class="col-md-4">
	<h2>欢迎<%=request.getSession().getAttribute("userName").toString()%>登录家庭金融管理系统</h2>
	</div>
	<div class="col-md-4"></div>
</div>
<h1></h1>
	<div class="row">
	 <div class="col-md-2">
	  	<ul class="nav nav-pills nav-stacked">
		  <li ><a href="./manager.jsp"><span class="glyphicon glyphicon-home"></span> 首页</a></li>
		  <li class="active"><a href="repayments.out"><span class="glyphicon glyphicon-credit-card"></span> 支出管理</a></li>
		  <li ><a href="loans.go"><span class="glyphicon glyphicon-cutlery"></span> 贷款管理</a></li>
		  <li ><a href="users.do"><span class="glyphicon glyphicon-user"></span> 用户管理</a></li>
		  <li><a href="logOut.do"><span class="glyphicon glyphicon-cog"></span> 退出</a></li>
		</ul>
	  </div>
	  
	  <div class="col-md-10">
	  			<div class="row">
					  <div class="col-md-11">
					  	<form action="repayments.out" method="post">
					  	<span class="glyphicon glyphicon-th-list"></span> 名称:<input type="text" name="name">&nbsp;&nbsp;&nbsp;&nbsp;
					  	<span class="glyphicon glyphicon-user"></span> 支付人:<input type="text" name="repayment_user">&nbsp;&nbsp;&nbsp;&nbsp;
					  	<span class="glyphicon glyphicon-edit"></span> 备注:<input type="text" name="remarks">&nbsp;&nbsp;&nbsp;&nbsp;
					  	<span class="glyphicon glyphicon-search"></span> <input type="submit" value="查 询">
					  	</form>
					  </div>
					  <div class="col-md-1">
					  <a href="dispatcherType.out" class="btn btn-primary btn-default btn-sm">添 加</a></div>
				</div>
			<%
				List<RepaymentEntity> list = (List<RepaymentEntity>)request.getAttribute("findAll"); 
			%>
	  		<div class="table-responsive">
			<table class="table table-hover table-bordered table-condensed table-responsive" >
				<thead>
					<tr>
						<th>编号</th><th>名称</th><th>金额</th><th>支付日期</th><th>支付人</th><th>记账人</th><th>备注</th><th>更新日期</th><th>操 &nbsp;作</th>
					</tr>
				</thead>
				<tbody>
					<% 
						for(RepaymentEntity repay :list){
					%>
					<tr>
						<td><%= repay.getId() %></td>
						<td><%= repay.getName().substring(1, repay.getName().length()-3) %></td>
						<td><%= repay.getRepayment_amount() %></td>
						<td><%= repay.getUpdate_time() %></td>
						<td><%= repay.getRepayment_user().substring(1, repay.getRepayment_user().length()-3) %></td>
						<td><%= repay.getUser_name() %></td>
						<td><%= repay.getRemarks().substring(1, repay.getRemarks().length()-3) %></td>
						<td><%= repay.getRepayment_time() %></td>
						<td><a href="delRepayment.out?repaymentId=<%=repay.getId() %>">删除</a></td>
					</tr>
					<% 
						} 
					%>
				</tbody>
			</table>
			</div>
	  </div>
	</div>
	
</body>
</html>