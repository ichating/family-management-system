<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.family.oa.entity.RepaymentEntity" %>
<%@ page import="java.util.List" %>
<%@ page import="com.family.oa.entity.PageBean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		  <li class="active"><a href="findRepaymentByPageServlet.out"><span class="glyphicon glyphicon-credit-card"></span> 支出管理</a></li>
		  <li ><a href="loans.go"><span class="glyphicon glyphicon-cutlery"></span> 贷款管理</a></li>
		  <li ><a href="findUserByPageServlet.do"><span class="glyphicon glyphicon-user"></span> 用户管理</a></li>
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
					  <a href="dispatcherType.out" class="btn btn-primary btn-sm">添 加</a></div>
				</div>
			  	<%
			  		PageBean<RepaymentEntity> pageBean = (PageBean<RepaymentEntity>)request.getAttribute("pageBean");
					List<RepaymentEntity> list = pageBean.getList();
					Integer sumCount=pageBean.getTotalPage();
				    %>
	  		<div class="table-responsive">
			<table class="table table-striped table-hover table-condensed table-bordered" >
				<thead>
					<tr>
						<th>序号</th><th>名称</th><th>金额</th><th>支付日期</th><th>支付人</th><th>记账人</th><th>备注</th><th>更新日期</th><th>操 &nbsp;作</th>
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
						<td><a class="btn btn-danger" href="delRepayment.out?repaymentId=<%=repay.getId() %>">删除</a></td>
					</tr>
					<% 
						} 
					%>
				</tbody>
			</table>
			
			<div style="float: left">
                <nav>
                    <ul class="pagination">
                        <%-- 判断是否是第一页--%>
                        <c:if test="${pageBean.currentPage==1}">
                        <li class="disabled">
                            </c:if>
                            <c:if test="${pageBean.currentPage!=1}">
                        <li>
                            </c:if>
                            <a href="findRepaymentByPageServlet.out?currentPage=${pageBean.currentPage-1}&rows=8"
                               aria-label="Previous">
                                <span aria-hidden="true">上一页</span>
                            </a>
                        </li>
                       
                       <c:forEach var="i" varStatus="s" step="1" begin="1" end="${pageBean.totalPage}">
                            <c:if test="${pageBean.currentPage == i}">
                                <li class="active">

                                    <a href="findRepaymentByPageServlet.out?currentPage=${i}&rows=8"

                                       name="li">${i}</a></li>
                            </c:if>
                            <c:if test="${pageBean.currentPage != i}">
                                <li>
                                    <a href="findRepaymentByPageServlet.out?currentPage=${i}&rows=8"
                                       name="li">${i}</a></li>
                            </c:if>
                        </c:forEach>
                        
                        <%-- 判断是否是最后页--%>
                        <c:if test="${pageBean.currentPage >= pageBean.totalPage}">
                        <li class="disabled">
                            </c:if>
                            <c:if test="${pageBean.currentPage!=pageBean.totalPage}">
                        <li>
                            </c:if>
                            <a href="findRepaymentByPageServlet.out?currentPage=${pageBean.currentPage+1}&rows=8"
                               aria-label="Next">
                                <span aria-hidden="true">下一页</span>
                            </a>
                        </li>
                        <span style="font-size: 22px ;margin-left: 0px">共${pageBean.totalCount}条数据，共${pageBean.totalPage}页</span>
                    </ul>
                </nav>
            </div>
			
			</div>
	  </div>
	</div>
	
</body>
</html>