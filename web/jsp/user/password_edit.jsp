<%@ page import="entity.User" %>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../common/taglib.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>北青云尚自动化办公系统</title>
    <link href="<%=request.getContextPath() %>/css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.0.min.js"></script>
    <script type="text/javascript">
        function check(){
            if($("#oldPwd").val()=="" || $("#newPwd1").val() =="" || $("#newPwd2").val()==""){
                alert("请输入完整信息！");
                return false;
            }
            if($("#newPwd1").val() != $("#newPwd2").val()){
                alert("两次输入的密码不一致！");
                return false;
            }
            return true;
        }

        function clear(){
            $("#oldPwd").val("");
            $("#newPwd1").val("");
            $("#newPwd2").val("");
        }
    </script>
</head>
<body>
<%
    User u = (User) session.getAttribute("user");
%>
<div class="action divaction">
    <div class="t">重置密码</div>
    <div class="pages">
        <!--员工信息区域 开始-->
        <form action="<%=request.getContextPath() %>/passwordControllor?&id=<%=u.getId()%>&pwd=<%=u.getP()%>" name="" method="post" onsubmit="return check()" >
            <table class="leave">
                <tr>
                    <td class="width1"><label>原始密码：</label></td>
                    <td class="width2"><input type="text" id="oldPwd" name="oldPwd"/></td>
                </tr>
                <tr>
                    <td class="width1"><label>新密码：</label></td>
                    <td class="width2"><input type="text" id="newPwd1" name="newPwd1"/></td>
                </tr>
                <tr>
                    <td class="width1"><label>确认新密码：</label></td>
                    <td class="width2"><input type="text" id="newPwd2" name="newPwd2"/></td>
                </tr>
            </table>
            <div>
                <p class="marg">
                    <input name="button" type="submit"  value="提交" class="submit_01"/>
                    <input name="" type="reset"  value="取消"  class="submit_01"/>
                </p>
            </div>
         </form>
            <!--员工信息 区域 结束-->
    </div>
</div>
</body>
</html>
