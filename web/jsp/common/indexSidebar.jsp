<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="taglib.jsp"%>
<div class="nav" id="nav">
	<div class="t"></div>
   		<dl class="open">
	       	<dt onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">考勤</dt>
	           <dd><a href="jsp/attendance/attendance_record.jsp">每日打卡</a></dd>
	       </dl>
       <dl>
       		<dt onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">员工档案</dt>
		       <dd><a href="jsp/user/empl_view.jsp">查看个人信息</a></dd>
		       <dd><a href="jsp/user/password_edit.jsp">重置密码</a></dd>
       </dl>
       <c:if test = "${sessionScope.user.positionid eq 11 || (sessionScope.user.deptid eq 1 && sessionScope.user.positionid eq 1)}">
	   <dl>
       		<dt onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">员工管理</dt>
		       <dd><a href="DepartmentServlet">新增员工</a></dd>
		       <dd><a href="jsp/user/empl_list.jsp">查询员工</a></dd>
       </dl>
		<dl>
			<dt onclick="this.parentNode.className=this.parentNode.className=='open'?'':'open';">考勤管理</dt>
			<dd><a href="<%=request.getContextPath()%>/AttendanceControllor?ro=b-list">考勤记录</a></dd>
		</dl>
	   </c:if>
</div>
