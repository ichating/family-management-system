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
<title>贷款记录管理</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/static/bootstrap-3.3.5/dist/css/bootstrap.min.css">
<link rel="shortcut icon" href="./img/favicon.png" type="image/x-icon" />
<script  type="text/javascript" src="<%=basePath%>/static/WEB_INF/bootstrap-3.3.5/dist/js/jquery-1.12.1.js"></script>
<script  type="text/javascript" src="<%=basePath%>/static/WEB_INF/bootstrap-3.3.5/dist/js/bootstrap.js"></script>
<!-- href：里面的路径是你导入在static文件夹里面下面bootstrap.min.css所在的路径，下面两个属性一样 -->
<script type="text/javascript" src="<%=basePath%>/static/bootstrap-3.3.5/dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/static/bootstrap-3.3.5/js/tests/vendor/jquery.min.js"></script>
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
			  <li ><a href="./manager.jsp"><span class="glyphicon glyphicon-home"></span> 首页</a></li>
			  <li><a href="findRepaymentByPageServlet.out"><span class="glyphicon glyphicon-credit-card"></span> 支出管理</a></li>
			  <li class="active"><a href="loans.go"><span class="glyphicon glyphicon-cutlery"></span> 贷款管理</a></li>
			  <li ><a href="findUserByPageServlet.do"><span class="glyphicon glyphicon-user"></span> 用户管理</a></li>
			  <li><a href="logOut.do"><span class="glyphicon glyphicon-cog"></span> 退出</a></li>
			</ul>
		  </div>
		  <div class="col-md-3">
				
				<form class="form-horizontal" action="addLoan.go" method="get" role="form">
					  <div class="form-group">
					    <label for="types">名称</label>
    					 <select name="types" class="form-control">
						  			<option>请选择名称</option>
									<option value="百度钱包">百度钱包</option>
									<option value="京东白条">京东白条</option>
									<option value="蚂蚁花呗">蚂蚁花呗</option>
									<option value="蚂蚁借呗">蚂蚁借呗</option>
									<option value="下街气费">下街气费</option>
									<option value="下街水费">下街水费</option>
									<option value="下街电费">下街电费</option>
									<option value="东升">东升</option>
									<option value="超娃">超娃</option>
									<option value="房贷本金">房贷本金</option>
									<option value="房贷利息">房贷利息</option>
									<option value="工行信使展期">工行信使展期</option>
									<option value="米">米</option>
						 </select> 
					  </div>
					  <div class="form-group">
					    <label for="user">贷款人</label>
					    <select name="user" class="form-control" >
					 		<option>请选择贷款人</option>
							<option value="朱晓武">朱晓武</option>
							<option value="朱泽明">朱泽明</option>
							<option value="邓凌">邓凌</option>
							<option value="毛雪华">毛雪华</option>
						</select>
					  </div>
					  <div class="form-group">
					    <label for="inMoney">贷款金额</label>
					    <input class="form-control" type="text" name="inMoney" placeholder="请输入贷款金额">
					  </div>
					  <div class="form-group">
					    <label for="repaymentDay">期数</label>
					    <input class="form-control" type="text" name="repaymentDay" placeholder="请输入贷款期数">
					  </div>
 					 <div class="form-group">
						  <label for="repaymentInDate">贷款日期</label>
						  <input type="date" name="repaymentInDate" class="form-control">
					  </div>
					  <div class="form-group">
					    <label for="outMoney">每月还款金额</label>
					    <input class="form-control" type="text" name="outMoney" placeholder="请输入每月还款金额">
					  </div>
					  <div class="form-group">
						  <label for="repaymentOutDate">还款日期</label>
						  <input type="date" name="repaymentOutDate" class="form-control">
					  </div>
					  <div class="form-group">
							<label for="remark">备注</label>
							<input class="form-control"  type="text" name="remark" >
					  </div>
					  <input type="submit" value="保存" class="btn btn-success btn-sm form-control">
				</form>
			</div>
</body>
</html>