<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.family.oa.entity.LoanEntity" %>
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
<title>贷款管理</title>
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
	  <div class="col-md-10">
	  
 	  <div class="row">
			  <div class="col-md-11">
			  	<form action="loans.go" method="post">
			  	<span class="glyphicon glyphicon-th-list"></span> 名称:<input type="text" name="types">&nbsp;&nbsp;&nbsp;&nbsp;
			  	<span class="glyphicon glyphicon-user"></span> 支付人:<input type="text" name="user">&nbsp;&nbsp;&nbsp;&nbsp;
			  	<span class="glyphicon glyphicon-edit"></span> 备注:<input type="text" name="remark">&nbsp;&nbsp;&nbsp;&nbsp;
			  	<span class="glyphicon glyphicon-search"></span> <input type="submit" value="查 询">
			  	</form>
			  </div>
			  <div class="col-md-1">
			  <a href="./addLoan.jsp" class="btn btn-primary btn-sm">添加</a></div>
		</div>
	  		<%
				List<LoanEntity> loanList = (List<LoanEntity>)request.getAttribute("findLoanList"); 
			%>
			
			<div class="table-responsive">
			<table  class="table table-striped table-hover table-condensed">
				<thead>
					<tr>
						<th>序号</th><th>机构名称</th><th>贷款人</th><th>贷款金额</th><th>期数</th><th>贷款日期</th><th>还款金额</th><th>还款日期</th><th>记账人</th><th>更新日期</th><th>备注</th><th>操作</th>
					</tr>
				</thead>
				<tbody>
					<% 
						for(LoanEntity loan :loanList){
					%>
					<tr>
						<td><%= loan.getId() %></td>
						<td><%= loan.getTypes().substring(1, loan.getTypes().length()-3) %></td>
						<td><%= loan.getUser().substring(1, loan.getUser().length()-3) %></td>
						<td><%= loan.getInMoney() %></td>
						<td><%= loan.getRepaymentDay() %></td>
						<td><%= loan.getRepaymentInDate() %></td>
						<td><%= loan.getOutMoney() %></td>
						<td><%= loan.getRepaymentOutDate() %></td>
						<td><%= loan.getUser_name().substring(1, loan.getUser_name().length()-1) %></td>
						<td><%= loan.getRepayment_time() %></td>
						<td><%= loan.getRemark().substring(1, loan.getRemark().length()-3) %></td>
						<td>
							<a href="delLoan.go?loanId=<%=loan.getId() %>">删除</a>
						</td>
					</tr>
					<% 
						} 
					%>
				</tbody>
			</table>
			</div>
	  <div class="row">
</div>
</body>
</html>