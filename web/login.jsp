<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="entity.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>北青云尚自动化办公系统</title>

<style type="text/css">
	* {
		margin: 0;
		padding: 0;
	}
	
	body {
		font: 12px 宋体;
		background: #4BB8EF url(images/bg.gif) repeat-x;
	}
	
	img {
		border: 0;
	}
	
	.login-top {
		width: 100%;
		height: 186px;
		margin: 147px auto 0;
		text-align: center;
	}
	
	.login-area {
		width: 100%;
		height: 140px;
		margin: 0 auto;
		background: url(images/login_02.gif) no-repeat center 0;
	}
	
	.login-area form {
		width: 290px;
		margin: 0 auto;
	}
	
	.login-area label {
		clear: left;
		float: left;
		margin-top: 13px;
		width: 60px;
		font: 600 14px 宋体;
	}
	
	.login-area  input {
		width: 122px;
		height: 16px;
		margin-top: 11px;
		border: 1px #767F94 solid;
		font: 12px/ 16px 宋体;
	}
	
	input.login-sub {
		width: 104px;
		height: 34px;
		border: 0;
		background: url(images/login_sub.gif) no-repeat 0px 1px; *
		margin-top: 5px;
	}
	
	.login-copyright {
		width: 100%;
		height: 30px;
		margin: 18px auto 0;
		background: url(images/copyright.gif) no-repeat center 0;
	}

	.login-top .titlearea{
		font-size: 60px;
	}
</style>
<script type="text/javascript">
	function check() {
		var msg = document.getElementById("msg").value;
		if (msg.length != 0) {
			alert(msg);
			document.getElementById("msg").value = "";
		}
	}
</script>
</head>
<body onload="check()">
	<div class="login-top"><label class="titlearea">北青云尚自动化办公系统</label></div>
	<div class="login-area">
		<form  action="<%=request.getContextPath()%>/logservlet?log=login" method="post">
			<label>
				工&nbsp;&nbsp;号：
			</label>
			<input type="text" name="employeeNo" maxlength="10"/>
			<label>
				密&nbsp;&nbsp;码：
			</label>
			<input type="password" name="password"   maxlength="10" />
			<input type="submit" class="login-sub" value="" />
			<input type="hidden" id="msg" value="${sessionScope.error}" />
		</form>
	</div>
	<div class="login-copyright"></div>
	<c:if test="${user.id==1}">
	关注
	</c:if>
<%--<%--%>
<%--	User u = new User();--%>
<%--	u.setName("江钞");--%>
<%--	session.setAttribute("user",u);--%>
<%--%>--%>
<%--名字=${user.name}--%>
<%--姓名=<c:out value="${user.name}" default="xxxxxxxx"/>--%>

</body>
</html>