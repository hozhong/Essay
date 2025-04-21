<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../common/taglib.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>北青云尚自动化办公系统</title>
    <link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.0.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript">
        console.log("${requestScope.three_link_table_inquire}")
        function check(){
            if($("#name").val() == ""){
                alert("请输入员工姓名！");
                return false;
            }
            if($("#employeeNo").val() == ""){
                alert("请输入员工工号！");
                return false;
            }
            if($("#entryTime").val() == ""){
                alert("请选择员工入职时间！");
                return false;
            }
            if($("#email").val()!= ""){
                if($("#email").val().match(/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/)==null){
                    alert("请输入正确的邮箱！");
                    return false;
                }
            }
            return true;
        }

    </script>
</head>
<body>
<div class="action divaction">
    <div class="t">修改员工信息</div>
    <div class="pages">
        <!--员工信息区域 开始-->
        <form action="<%=request.getContextPath() %>/seseltControllor?doseselt=update2&id=${requestScope.id}" enctype="multipart/form-data" name="form1" method="post"  onsubmit="return check()">
            <table class="leave"  >
                <tr>
                    <td class="width1"><label>姓名：</label></td>
                    <td class="width2"><input type="text" id="name" name="name" value="${requestScope.three_link_table_inquire.userlist[0].name}"/></td>
                    <td class="width1"><label>工号：</label></td>
                    <td class="width2"><input type="text" id="employeeNo" name="employeeNo" value="${requestScope.three_link_table_inquire.userlist[0].name}" readonly/></td>
                </tr>
                <tr>
                    <td class="width1"><label>email：</label></td>
                    <td class="width2"><input type="text" id="email" name="email" value="${requestScope.three_link_table_inquire.userlist[0].email}"/></td>
                    <td class="width1"><label>入职时间：</label></td>
                    <td class="width2"><input class="Wdate" onFocus="WdatePicker({lang:'zh-cn'})" name="entryTime" value="${requestScope.three_link_table_inquire.userlist[0].entryTime}"/></td>
                </tr>
                <tr>
                    <td class="width1"><label>部门：</label></td>
                    <td class="width2"><select name="department" theme="simple" cssClass="nwselect">
                        <c:forEach var="department" items="${requestScope.three_link_table_inquire.departmentList}">

                            <c:choose>
                                <c:when test="${three_link_table_inquire.userlist[0].deptid eq department.id}">
                                    <option value="${department.id}" selected="selected">${department.deptName}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${department.id}">${department.deptName}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select></td>
                    <td class="width1"><label>职位：</label></td>
                    <td class="width2"><select name="position" theme="simple" cssClass="nwselect">
                        <c:forEach var="position" items="${requestScope.three_link_table_inquire.positionList}">
                            <c:choose>
                                <c:when test="${requestScope.three_link_table_inquire.userlist[0].positionid eq position.id}">
                                    <option value="${position.id}" selected="selected">${position.posName}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${position.id}">${position.posName}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select></td>
                </tr>
                <tr>
                    <td class="width1"><label>上传照片：</label>
                    </td>
                    <td colspan="3">
                        <c:choose>
                            <c:when test="${employee.photo ne null}">
                                <img src="<%=request.getContextPath() %>/${employee.photo}" width="96" height="96" style="filter: alpha(opacity=50); vertical-align: middle;"  alt=""/>
                            </c:when>
                            <c:otherwise>
                                <img src="${images}/headImg.jpg" width="96" height="96" style="filter: alpha(opacity=50); vertical-align: middle;"  alt=""/>
                            </c:otherwise>
                        </c:choose>
                        <input type="file" name="fileField" id="fileField"/>
                    </td>
                </tr>
            </table>
            <div>
                <p class="marg">
                    <input name="button" type="submit"  value="提交" class="submit_01" />
                    <input type="button" value="返回" onclick="window.history.go(-1)" class="submit_01"/>
                </p>
            </div>
         </form>
            <!--员工信息 区域 结束-->
    </div>
</div>
</body>
</html>
