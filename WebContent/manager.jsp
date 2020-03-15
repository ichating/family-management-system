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
<link rel="shortcut icon" href="/family/img/favicon.png" type="image/x-icon" />
<link rel="bookmark" href="/family/img/favicon.png" type="image/x-icon" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>家庭OA管理系统</title>
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
			  <li class="active"><a href="/family/manager.jsp"><span class="glyphicon glyphicon-home"></span> 首页</a></li>
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
	 <div class="row">
	     <div class="col-md-2">
	      
	     </div>
	     <div class="col-md-10">
	          <!-- 开支折线图-->
			  <div id="repayments" style="width: 600px;height:400px;"></div>
	      </div>
     </div>

<script type="text/javascript">
       // 占比图
       var myChart = echarts.init(document.getElementById('main'));
       // 开支折线图
       var repaymentsChart = echarts.init(document.getElementById('repayments'));

       // 指定图表的配置项和数据
	   option = {
		    title : {
		        text: '某站点用户访问来源',
		        subtext: '纯属虚构',
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
       
	   repaymentsOption = {
			    title : {
			        text: '开支变化',
			        subtext: '日常生活记录'
			    },
			    tooltip : {
			        trigger: 'axis'
			    },
			    legend: {
			        data:['最高气温','最低气温']
			    },
			    toolbox: {
			        show : true,
			        feature : {
			            mark : {show: true},
			            dataView : {show: true, readOnly: false},
			            magicType : {show: true, type: ['line', 'bar']},
			            restore : {show: true},
			            saveAsImage : {show: true}
			        }
			    },
			    calculable : true,
			    xAxis : [
			        {
			            type : 'category',
			            boundaryGap : false,
			            data : ['周一','周二','周三','周四','周五','周六','周日']
			        }
			    ],
			    yAxis : [
			        {
			            type : 'value',
			            axisLabel : {
			                formatter: '{value} °C'
			            }
			        }
			    ],
			    series : [
			        {
			            name:'最高气温',
			            type:'line',
			            data:[11, 11, 15, 13, 12, 13, 10],
			            markPoint : {
			                data : [
			                    {type : 'max', name: '最大值'},
			                    {type : 'min', name: '最小值'}
			                ]
			            },
			            markLine : {
			                data : [
			                    {type : 'average', name: '平均值'}
			                ]
			            }
			        },
			        {
			            name:'最低气温',
			            type:'line',
			            data:[1, -2, 2, 5, 3, 2, 0],
			            markPoint : {
			                data : [
			                    {name : '周最低', value : -2, xAxis: 1, yAxis: -1.5}
			                ]
			            },
			            markLine : {
			                data : [
			                    {type : 'average', name : '平均值'}
			                ]
			            }
			        }
			    ]
			};
       
      // 使用刚指定的配置项和数据显示图表。
      myChart.setOption(option);
      repaymentsChart.setOption(repaymentsOption);
</script>
</body>
</html>