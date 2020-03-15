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
<link rel="stylesheet" type="text/css" href="<%=basePath%>static/bootstrap-3.3.5/dist/css/bootstrap.min.css">
<script  type="text/javascript" src="<%=basePath%>static/bootstrap-3.3.5/dist/js/jquery-1.12.1.js"></script>
<script  type="text/javascript" src="<%=basePath%>static/bootstrap-3.3.5/dist/js/bootstrap.js"></script>
<script  type="text/javascript" src="<%=basePath%>static/bootstrap-3.3.5/js/tests/vendor/jquery.min.js"></script>
<script  type="text/javascript" src="<%=basePath%>static/bootstrap-3.3.5/dist/js/echarts-all.js"></script>
<link rel="icon" href="/family/img/favicon.png" type="image/x-icon" />
<link rel="shortcut icon" href="./img/favicon.png" type="image/x-icon" />
<link rel="bookmark" href="./img/favicon.png" type="image/x-icon" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>家庭OA管理系统</title>
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
			  <li class="active"><a href="./manager.jsp"><span class="glyphicon glyphicon-home"></span> 首页</a></li>
			  <li><a href="repayments.out"><span class="glyphicon glyphicon-credit-card"></span> 支出管理</a></li>
			  <li ><a href="loans.go"><span class="glyphicon glyphicon-cutlery"></span> 贷款管理</a></li>
			  <li ><a href="users.do"><span class="glyphicon glyphicon-user"></span> 用户管理</a></li>
			  <li><a href="logOut.do"><span class="glyphicon glyphicon-cog"></span> 退出</a></li>
			</ul>
		  </div>
		  <div class="col-md-10">
		  	  <!-- 占比图 -->
			  <div  id="main" style="width: 600px;height:400px;"></div>
	      </div>
	 </div>

<script type="text/javascript">
       // 占比图
       var myChart = echarts.init(document.getElementById('main'));
       // 指定图表的配置项和数据
	   option = {
		    title : {
		        text: '开支占比图',
		        subtext: '日常开支',
		        x:'center'
		    },
		    tooltip : {
		        trigger: 'item',
		        formatter: "{a} <br/>{b} : {c} ({d}%)"
		    },
		    legend: {
		        orient : 'vertical',
		        x : 'left',
		        data:['直接访问','邮件营销','联盟广告','视频广告','搜索引擎']
		    },
		    toolbox: {
		        show : true,
		        feature : {
		            mark : {show: true},
		            dataView : {show: true, readOnly: false},
		            magicType : {
		                show: true, 
		                type: ['pie', 'funnel'],
		                option: {
		                    funnel: {
		                        x: '25%',
		                        width: '50%',
		                        funnelAlign: 'left',
		                        max: 1548
		                    }
		                }
		            },
		            restore : {show: true},
		            saveAsImage : {show: true}
		        }
		    },
		    calculable : true,
		    series : [
		        {
		            name:'访问来源',
		            type:'pie',
		            radius : '55%',
		            center: ['50%', '60%'],
		            data:[
		                {value:335, name:'直接访问'},
		                {value:310, name:'邮件营销'},
		                {value:234, name:'联盟广告'},
		                {value:135, name:'视频广告'},
		                {value:1548, name:'搜索引擎'}
		            ]
		        }
		    ]
		};

      // 使用刚指定的配置项和数据显示图表。
      myChart.setOption(option);
</script>
</body>
</html>