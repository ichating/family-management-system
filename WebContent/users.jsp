<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.family.oa.entity.UserEntity" %>
<%@ page import="com.family.oa.entity.PageBean" %>
<%@ page import="java.util.List" %>
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
<link rel="stylesheet" type="text/css" href="<%=basePath%>/static/bootstrap-3.3.5/dist/css/bootstrap.min.css">
<link rel="bookmark" href="./img/favicon.png" type="image/x-icon" />
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
		  <li ><a href="./manager.jsp"><span class="glyphicon glyphicon-home"></span> 首页</a></li>
		  <li><a href="findRepaymentByPageServlet.out"><span class="glyphicon glyphicon-credit-card"></span> 支出管理</a></li>
		  <li ><a href="loans.go"><span class="glyphicon glyphicon-cutlery"></span> 贷款管理</a></li>
		  <li class="active"><a href="findUserByPageServlet.do"><span class="glyphicon glyphicon-user"></span> 用户管理</a></li>
		  <li><a href="logOut.do"><span class="glyphicon glyphicon-cog"></span> 退出</a></li>
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
		  <a href="./addUsers.jsp" class="btn btn-primary btn-sm">添加</a></div>
	    </div>
	    
  		<%
  		PageBean<UserEntity> pageBean = (PageBean<UserEntity>)request.getAttribute("pageBean");
		List<UserEntity> list = pageBean.getList();
		Integer sumCount=pageBean.getTotalPage();
	    %>
	    
	    <div class="table-responsive">
		<table  class="table table-striped table-hover table-condensed table-bordered">
			<thead>
				<tr>
					<th>序号</th><th>用户名</th><th>姓名</th><th>密码</th><th>生日</th><th>电话</th><th>备注</th><th>更新日期</th><th>操作</th>
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
						<a class="btn btn-danger btn-sm" href="delUser.do?userId=<%=user.getId() %>">删除</a>
						<a class="btn btn-warning btn-sm" href="findOne.do?userId=<%=user.getId() %>">修改</a>
					</td>
				</tr>
				<% 
					} 
				%>
			</tbody>
		</table>
		
		 <div style="float: left">
                <nav>
                    <ul class="pagination pagination-sm">
                        <%-- 判断是否是第一页--%>
                        <c:if test="${pageBean.currentPage==1}">
                        <li class="disabled">
                            </c:if>
                            <c:if test="${pageBean.currentPage!=1}">
                        <li>
                            </c:if>
                            <a href="findUserByPageServlet.do?currentPage=${pageBean.currentPage-1}&rows=8"
                               aria-label="Previous">
                                <span aria-hidden="true">上一页</span>
                            </a>
                        </li>
                       
                       <c:forEach var="i" varStatus="s" step="1" begin="1" end="${pageBean.totalPage}">
                            <c:if test="${pageBean.currentPage == i}">
                                <li class="active">

                                    <a href="findUserByPageServlet.do?currentPage=${i}&rows=8"

                                       name="li">${i}</a></li>
                            </c:if>
                            <c:if test="${pageBean.currentPage != i}">
                                <li>
                                    <a href="findUserByPageServlet.do?currentPage=${i}&rows=8"
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
                            <a href="findUserByPageServlet.do?currentPage=${pageBean.currentPage+1}&rows=8"
                               aria-label="Next">
                                <span aria-hidden="true">下一页</span>
                            </a>
                        </li>
                        <span style="font-size: 25px ;margin-left: 5px">共${pageBean.totalCount}条数据，共${pageBean.totalPage}页</span>
                    </ul>
                </nav>
            </div>
        </div>
		
</div>
</body>
</html>