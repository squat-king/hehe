﻿<%@ page import="com.attendance.bean.UserBean" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>欢迎登录公司员工考勤管理平台</title>
		<link href="css/style.css" rel="stylesheet" type="text/css" />
		<script language="JavaScript" src="js/jquery.js"></script>
		<script src="js/cloud.js" type="text/javascript"></script>
		<script language="javascript">
	$(function(){
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
    })  
});  
</script>
		<script>
//登录
 function loginButton(){
  document.forms[0].action="${pageContext.request.contextPath}/LoginServlet";
  document.forms[0].submit();
 }

</script>

	</head>

	<body
		style="background-color: #1c77ac; background-image: url(images/light.png); background-repeat: no-repeat; background-position: center top; overflow: hidden;">
<%
	String userId = "";
	String password ="";
	Cookie[] cookies = request.getCookies();
	for (int i = 0; i < cookies.length; i++) {//对cookies中的数据进行遍历，找到用户名、密码的数据
		    if ("userId".equals(cookies[i].getName())) {
				userId = cookies[i].getValue();
			        } else if ("password".equals(cookies[i].getName())) {
			    password = cookies[i].getValue();
			        }

		   }


%>
<form name="loginForm" method="post">

		<div id="mainBody">
			<div id="cloud1" class="cloud"></div>
			<div id="cloud2" class="cloud"></div>
		</div>


		<div class="logintop">
			<span>欢迎登录公司员工考勤管理平台</span>

		</div>
<div>
<font color="red"> ${msg}</font>
</div>
		<div class="loginbody">

			<span class="systemlogo"></span>

			<div class="loginbox">

				<ul>
					<li>
						<input name="userId" type="text" class="loginuser" value="<%=userId%>"
							onclick="JavaScript:this.value=''" />
					</li>
					<li>
						<input name="password" type="password" class="loginpwd" value="<%=password%>"
							onclick="JavaScript:this.value=''" />
					</li>
					<li>
						<input name="" type="button" class="loginbtn" value="登录"
							onclick="loginButton()" />
						<label>
							<input name="rememberPwd" type="checkbox" value="yes" checked="checked"defaultChecked="no"	 />
							记住密码
						</label>
						<label>
							<input type="checkbox" name="autoLogin" value="auto" >
							自动登录
						</label>
					</li>
				</ul>
			</div>
		</div>
		</form>
	</body>
</html>
