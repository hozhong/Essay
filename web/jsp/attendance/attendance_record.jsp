<%@ page import="entity.User" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>北青云尚自动化办公系统</title>
    <link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="action  divaction">
    <div class="t">
        员工打卡
    </div>
    <%

            User u = (User) session.getAttribute("user");


    %>
    <div class="pages">
        <table width="90%" border="0" cellspacing="0" cellpadding="0"
               class="addform-base">
            <tr>
                <td colspan="4" class="submit">
                    <input type="button" value="上班打卡" onclick="javascript:location.href='<%=request.getContextPath() %>/AttendanceControllor?in=attendance_record&id=<%=u.getId()%>'" class="submit_01"/>
                </td>
                <td colspan="4" class="submit">
                    <input type="button" value="下班打卡" onclick="javascript:location.href='<%=request.getContextPath() %>/AttendanceControllor?out=attendance_record&id=<%=u.getId()%>'" class="submit_01"/>
                </td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
