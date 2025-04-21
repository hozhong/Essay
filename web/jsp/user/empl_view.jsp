<%@ page import="entity.User" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>北青云尚自动化办公系统</title>
    <link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>

<div class="action  divaction">
    <div class="t">
        员工信息
    </div>
    <div class="pages">
        <table width="90%" border="0" cellspacing="0" cellpadding="0"
               class="addform-base">
            <caption>
                基本信息
            </caption>
            <tr>

                <td width="36%">
                    姓名：${user.name}
                </td>
                <td width="64%">
                    工号：${user.e}
                </td>
            </tr>
            <tr>
                <td>
                    部门: ${user.deptid}
                </td>
                <td>
                    职位：<c:if test="${user.positionid==1}">
                    人力资源
                </c:if>
                </td>
            </tr>
            <tr>
                <td>
                    入职时间：${user.entryTime}
                </td>
                <td>
                    邮箱：${(user.email!=null && user.email!="")?user.email:"空"}
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    员工照片：
                    <c:choose>
                        <c:when test="${requestScope.employee.photo ne null}">
                            <img src="<%=request.getContextPath() %>/${requestScope.employee.photo}" width="96"
                                 height="96" style="filter: alpha(opacity=50); vertical-align: middle;" alt=""/>
                        </c:when>
                        <c:otherwise>
                            <img src="${images}/headImg.jpg" width="96" height="96"
                                 style="filter: alpha(opacity=50); vertical-align: middle;" alt=""/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
            <tr>
                <td colspan="4" class="submit">
                    <input type="button" value="返回" onclick="window.history.go(-1)" class="submit_01"/>
                </td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
