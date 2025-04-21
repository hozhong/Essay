<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../common/taglib.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>北青云尚自动化办公系统</title>
    <link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script type="text/javascript">
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
    <div class="t">添加员工</div>
    <div class="pages">
        <!--员工信息区域 开始-->
        <form action="<%=request.getContextPath()%>/AddControllor?add=empl_add" enctype="multipart/form-data" name="form1" method="post"  onsubmit="return check()">
            <table class="leave">
                <tr>
                    <td class="width1"><label>姓名：</label></td>
                    <td class="width2"><input type="text" id="name" name="name" /></td>
                    <td class="width1"><label>工号：</label></td>
                    <td class="width2"><input type="text" id="employeeNo" name="employeeNo" onchange="query()" /></td>
                </tr>
                <tr>
                    <td class="width1"><label>email：</label></td>
                    <td class="width2"><input type="text" id="email" name="email" /></td>
                    <td class="width1"><label>入职时间：</label></td>
                    <td class="width2"><input class="Wdate" onFocus="WdatePicker({lang:'zh-cn'})" name="entryTime" id="entryTime"/></td>
                </tr>
                <tr>
                    <td class="width1"><label>部门：</label></td>
                    <td class="width2"><select name="department" theme="simple" cssClass="nwselect">
                        <c:forEach var="department" items="${departmentList}">
                            <option value="${department.id}">${department.deptName}</option>
                        </c:forEach>
                    </select></td>
                    <td class="width1"><label>职位：</label></td>
                    <td class="width2"><select name="position" theme="simple" cssClass="nwselect">
                        <c:forEach var="position" items="${positionList}">
                            <option value="${position.id}">${position.posName}</option>
                        </c:forEach>
                    </select></td>
                </tr>
                <tr>
                    <td class="width1"><label>上传照片：</label>
                    </td>
                    <td colspan="3">
                        <input type="file" name="fileField" id="fileField"/>
                    </td>
                </tr>
            </table>
            <div>
                <p class="marg">
                    <input name="button" type="submit"  value="提交" class="submit_01" />
                    <input name="" type="reset"  value="取消"  class="submit_01"/>
                </p>
            </div>
         </form>
            <!--员工信息 区域 结束-->
    </div>
</div>
<script>
    function query() {
        $.ajax({
            url: "<%=request.getContextPath()%>/AddControllor",
            type: "get",
            data: {
                "add": "op",
                "employeeNo": $("#employeeNo").val()
            },
            dataType: "text",
            // 回调，使用匿名函数接收 data 并传入 show()
            success: function(data) {
                show(data);
            },
            error: function() {
                alert("接口错误");
            }
        });
    }

    function show(data) {
        if (data === "1") {
            alert("工号已存在");
        } else {
            alert("工号可用");
        }
    }

</script>
</body>
</html>
