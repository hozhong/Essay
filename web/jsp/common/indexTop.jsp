<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../common/taglib.jsp"%>
<div class="top">
	<div class="global-width">
		<label class="titlearea">北青云尚自动化办公系统</label>
	</div>
</div>

<div class="status">
	<div class="global-width">
		<span class="usertype"><c:if test="${user.positionid>=1}">
			人力资源
		</c:if></span>${sessionScope.user.name}你好！欢迎访问北青云尚自动化办公系统！
		<span><a href="control/logout">【退出系统】</a></span>
	</div>
</div>
