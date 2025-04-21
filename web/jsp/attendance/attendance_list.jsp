<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/taglib.jsp"%>
<%@ taglib uri="http://mycompany.com" prefix="util" %>
<link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>

<div class="action  divaction">
    <div class="t">考勤列表</div>
    <div class="pages">
        <div class="forms">
            <form action="AttendanceControllor" name="" method="post">
                <input type="hidden" value="b-list" name="ro">
                <label>姓名</label>
                <input id="name" name="empName" value="${searchName}"/> <!-- 回显查询条件 -->
                <label>日期</label>
                <input class="Wdate" onFocus="WdatePicker({lang:'zh-cn'})" id="searchDate" name="searchDate" value="${searchDate}" />
                <input type="hidden" name="opr" value="list"/>
                <input type="submit" cssClass="submit_01" value="查询"/>
            </form>
        </div>
        <!-- 列表展示 -->
        <table width="90%" border="0" cellspacing="0" cellpadding="0" class="list items">
            <tr class="even">
                <td>编号</td>
                <td>工号</td>
                <td>姓名</td>
                <td>上班打卡时间</td>
                <td>下班打卡时间</td>
            </tr>
            <c:forEach items="${pageInfo.list}" var="attendance"> <!-- 使用 PageInfo 中的数据 -->
                <tr>
                    <td><a href="">${attendance.id}</a></td>
                    <td>${attendance.employeeNo}</td>
                    <td>${attendance.name}</td>
                    <td>${attendance.signInTime}</td>
                    <td>${attendance.signOutTime}</td>
                </tr>
            </c:forEach>
        </table>
        <!-- 分页导航（使用 EL 表达式获取分页信息） -->
        <div class="page-bar">
            <c:if test="${pageInfo.currentPage > 1}">
                <a href="AttendanceControllor?ro=b-list&empName=${searchName}&searchDate=${searchDate}&page=1">首页</a>
                <a href="AttendanceControllor?ro=b-list&empName=${searchName}&searchDate=${searchDate}&page=${pageInfo.currentPage - 1}">上一页</a>
            </c:if>
            <c:if test="${pageInfo.currentPage <= 1}">
                首页&nbsp;&nbsp;上一页（不可用）
            </c:if>

            <c:if test="${pageInfo.currentPage < pageInfo.totalPage}">
                <a href="AttendanceControllor?ro=b-list&empName=${searchName}&searchDate=${searchDate}&page=${pageInfo.currentPage + 1}">下一页</a>
                <a href="AttendanceControllor?ro=b-list&empName=${searchName}&searchDate=${searchDate}&page=${pageInfo.totalPage}">最后一页</a>
            </c:if>
            <c:if test="${pageInfo.currentPage >= pageInfo.totalPage}">
                下一页（不可用）&nbsp;&nbsp;最后一页（不可用）
            </c:if>

            &nbsp;&nbsp;第 ${pageInfo.currentPage} 页/共 ${pageInfo.totalPage} 页&nbsp;&nbsp;共 ${pageInfo.totalRecord} 条记录
        </div>
    </div>
</div>