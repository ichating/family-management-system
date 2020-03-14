<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎登录</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/static/bootstrap-3.3.5/dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>/static/bootstrap-3.3.5/dist/css/style.css">
<script  type="text/javascript" src="<%=basePath%>/static/bootstrap-3.3.5/dist/js/jquery-1.12.1.js"></script>
<script  type="text/javascript" src="<%=basePath%>/static/bootstrap-3.3.5/dist/js/bootstrap.js"></script>
<!-- href：里面的路径是你导入在static文件夹里面下面bootstrap.min.css所在的路径，下面两个属性一样,test -->
<script type="text/javascript" src="<%=basePath%>/static/bootstrap-3.3.5/dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/static/bootstrap-3.3.5/js/tests/vendor/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/static/bootstrap-3.3.5/js/supersized.3.2.7.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/static/bootstrap-3.3.5/js/supersized-init.js"></script>
<link rel="icon" href="/family/img/favicon.png" type="image/x-icon" />
<link rel="shortcut icon" href="/family/img/favicon.png" type="image/x-icon" />
<link rel="bookmark" href="/family/img/favicon.png" type="image/x-icon" />
<script>
    $("body").keydown(function (event) {
        if (event.keyCode == 13) {
            $("#login_but").click();
        }
    });
</script>
</head>
<body>
<div class="container">
    <div class="login-box">
        <div class="header title">
            <h2>家庭OA管理系统</h2> 
        </div>
        <form action="loginUser.do" method="post" id="loginForm">
            <div class="row">
                <div class="col-md-12">
                    <div class="form-group ">
                        <input type="test" id="user_name" name="user_name" class="form-control" placeholder="请输入用户名" required="required" autofocus="autofocus" />
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="form-group">
                        <input type="password" id="user_password" name="user_password" class="form-control" placeholder="输入密码" required="required" oncontextmenu="return false" onpaste="return false" />
                    </div>
                </div>
            </div>  
            <div class="row">
                <div class="col-md-8">
                    <div class="form-group">
                        <div class="rember-checkbox">
                            <label class="checkbox pull-left">
                                <input type="checkbox" value="remember-me"/>
                                <span class="rember-item">记住登录帐号</span>
                            </label>
                        </div> 
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div class="form-group login">
                        <button type="submit" class="btn btn-primary btn-lg btn-block " name="login">登录</button>
                    </div>
                </div>
            </div>   
    </div>
  <%--   <h4><%=request.getAttribute("info") %></h4> --%>
    <div class="text-center">
        <div class="form-group">
            <a href="#" class="d-block small mt-3">注册</a>
        </div>
        <div class="form-group">
            <a href="#" class="d-block small">忘记密码？找回密码</a>
        </div>
    </div>
</div>
</body>
</html>