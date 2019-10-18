<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
	<head>

		<title>top</title>
		<link href="css/style.css" rel="stylesheet" type="text/css" />
		<script language="JavaScript" src="js/jquery.js"></script>
		<script type="text/javascript">
$(function(){	
	//顶部导航切换
	$(".nav li a").click(function(){
		$(".nav li a.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
})	
</script>


	</head>

	<body style="background: url(images/topbg.gif) repeat-x;">

		<div class="topleft">
			<a href="main.jsp" target="_parent"><img src="images/logo.png"
					title="系统首页" /> </a>
		</div>

		<ul class="nav">
			<%
				//超级管理员权限
				if ("0".equals(session.getAttribute("level"))) {
			%>
			<li>
				<a href="user/userSearch.jsp" target="rightFrame" class="selected"><img
						src="images/icon01.png" title="用户管理" />
					<h2>
						用户管理
					</h2> </a>
			</li>
			<li>
				<a href="dept/deptSearch.jsp" target="rightFrame"><img
						src="images/icon02.png" title="部门管理" />
					<h2>
						部门管理
					</h2> </a>
			</li>
			
			<%
				}
			%>

			<%
				//部门主管权限
				if ("1".equals(session.getAttribute("level"))) {
			%>
			<li>
				<a href="user/userSearch.jsp" target="rightFrame" class="selected"><img
						src="images/icon01.png" title="用户管理" />
					<h2>
						用户管理
					</h2> </a>
			</li>
			<li>
				<a href="report/reportSearch.jsp" target="rightFrame"><img
						src="images/icon03.png" title="日报管理" />
					<h2>
						日报管理
					</h2> </a>
			</li>
			<li>
				<a href="worksyouninn/worksyouninnSearch.html" target="rightFrame"><img
						src="images/icon06.png" title="审批管理" />
					<h2>
						审批管理
					</h2> </a>
			</li>
			<%
				}
			%>

			<%
				//普通员工权限
				if ("2".equals(session.getAttribute("level"))) {
			%>
			<li>
				<a href="report/reportSearch.jsp" target="rightFrame"><img
						src="images/icon03.png" title="日报管理" />
					<h2>
						日报管理
					</h2> </a>
			</li>
			<li>
				<a href="workmanager/workSearch.jsp" target="rightFrame"><img
						src="images/icon04.png" title="加班管理" />
					<h2>
						加班管理
					</h2> </a>
			</li>
			<li>
				<a href="restmanager/restSearch.jsp" target="rightFrame"><img
						src="images/ico01.png" width="58" height="44" title="休假管理" />
					<h2>
						休假管理
					</h2> </a>
			</li>
			<%
				}
			%>


		</ul>

		<div class="topright">
			<ul>
				<li>
					<a href="login.jsp" target="_parent">退出</a>
				</li>
			</ul>

		</div>
	</body>
</html>
