<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
//	String path = request.getContextPath();
//	String basePath = request.getScheme() + "://"
//			+ request.getServerName() + ":" + request.getServerPort()
//			+ path + "/";
%>
<html>
	<head>
		<title>菜单树</title>
		<link href="css/style.css" rel="stylesheet" type="text/css" />
		<script language="JavaScript" src="js/jquery.js"></script>

		<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active")
		$(this).addClass("active");
	});
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
})	
</script>


	</head>



	<body style="background: #f0f9fd;">
<%

//if ("0".equals(session.getAttribute("level"))) {
  %>
		<div class="lefttop">
			<span></span>用户管理
		</div>

		<dl class="leftmenu">

			<dd>
				<div class="title">
					<span><img src="images/leftico01.png" /> </span>用户管理
				</div>
				<ul class="menuson">
					<li>
						<cite></cite><a href="index.html" target="rightFrame">首页</a><i></i>
					</li>
					<li class="active">
						<cite></cite><a href="user/userSearch.jsp" target="rightFrame">用户管理</a><i></i>
					</li>
				</ul>
			</dd>

			<dd>
				<div class="title">
					<span><img src="images/leftico03.png" /> </span>部门管理
				</div>
				<ul class="menuson">
					<li>
						<cite></cite><a href="dept\deptSearch.html" target="rightFrame">部门管理</a><i></i>
					</li>
				</ul>
			</dd>
			<dd>
				<div class="title">
					<span><img src="images/leftico02.png" /> </span><a
						href="user/userPasswordUpdate.jsp" target="rightFrame">个人信息修改</a>
				</div>
			</dd>
		</dl>
<%--		<%--%>
<%--<% }; %>--%>
<%--		%>--%>

<%--		<%--%>
<%--			//部门主管权限--%>
<%if ("1".equals(session.getAttribute("level"))) {%>

		<div class="lefttop">
			<span></span>用户管理
		</div>

		<dl class="leftmenu">

			<dd>
				<div class="title">
					<span><img src="images/leftico01.png" /> </span>用户管理
				</div>
				<ul class="menuson">
					<li>
						<cite></cite><a href="index.html" target="rightFrame">首页</a><i></i>
					</li>
					<li class="active">
						<cite></cite><a href="/UserListServlet" target="rightFrame">用户管理</a><i></i>
					</li>
				</ul>
			</dd>

			<dd>
				<div class="title">
					<span><img src="images/leftico03.png" /> </span>日报管理
				</div>
				<ul class="menuson">
					<li>
						<cite></cite><a href="report/reportSearch.html"
							target="rightFrame">日报管理</a><i></i>
					</li>
				</ul>
			</dd>
			<dd>
				<div class="title">
					<span><img src="images/leftico04.png" /> </span>审批
				</div>
				<ul class="menuson">
					<li>
						<cite></cite><a href="restsyouninn\restsyouninnSearch.html"
							target="rightFrame">加班审批</a><i></i>
					</li>
					<li>
						<cite></cite><a href="worksyouninn\worksyouninnSearch.html"
							target="rightFrame">休假审批</a><i></i>
					</li>
				</ul>
			</dd>
			<dd>
				<div class="title">
					<span><img src="images/leftico02.png" /> </span><a
						href="user/userPasswordUpdate.jsp" target="rightFrame">个人信息修改</a>
				</div>
			</dd>
		</dl>


<%		}%>
<%--		%>--%>


<%--			//普通员工权限--%>
<%			if ("2".equals(session.getAttribute("level"))) {%>
<%--		%>--%>


		<dl class="leftmenu">

			<dd>
				<div class="title">
					<span><img src="images/leftico03.png" /> </span>日报管理
				</div>
				<ul class="menuson">
					<li>
						<cite></cite><a href="report/reportSearch.html"
							target="rightFrame">日报管理</a><i></i>
					</li>
				</ul>
			</dd>
			<dd>
				<div class="title">
					<span><img src="images/leftico01.png" /> </span>加班管理
				</div>
				<ul class="menuson">
					<li>
						<cite></cite><a href="workmanager\workSearch.html"
							target="rightFrame">加班管理</a><i></i>
					</li>
				</ul>
			</dd>
			<dd>
				<div class="title">
					<span><img src="images/leftico01.png" /> </span>休假管理
				</div>
				<ul class="menuson">
					<li>
						<cite></cite><a href="restmanager\restSearch.html"
							target="rightFrame">休假管理</a><i></i>
					</li>
				</ul>
			</dd>
			<dd>
				<div class="title">
					<span><img src="images/leftico02.png" /> </span><a
						href="user/userPasswordUpdate.jsp" target="rightFrame">个人信息修改</a>
				</div>
			</dd>
		</dl>

		<%
			}
		%>

	</body>
</html>
