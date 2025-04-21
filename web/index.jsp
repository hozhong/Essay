  <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html xmlns="http://www.w3.org/1999/xhtml"> 
  <head>
    <base target="rightFrame" href="<%=basePath%>">
    
    <title>北青云尚自动化办公系统</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="<%=basePath %>css/style.css" rel="stylesheet" type="text/css" />
  </head>
  <%
  	String images=request.getContextPath()+"/images";
  	session.setAttribute("images",images);
  %>
  <body>
  	<jsp:include page="/jsp/common/indexTop.jsp"></jsp:include>
		<div class="main">
			<div class="global-width">
				<jsp:include page="/jsp/common/indexSidebar.jsp" />
				<jsp:include page="/jsp/common/indexRightbar.jsp" />
			</div>
		</div>
	<jsp:include page="/jsp/common/indexBottom.jsp"></jsp:include>
  </body>
</html>
