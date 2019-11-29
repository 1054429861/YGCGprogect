<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019-11-27
  Time: 8:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        function resetsrc(t) {
            t.src="<%=request.getContextPath()%>/userloginimgcheck?t="+new Date().getTime();
        }
    </script>
</head>
<body>

<fieldset><legend>登陆</legend>
<form action="<%=request.getContextPath()%>/userlogin">
    用户名:<input name="username"><br>
    密码:<input type="password" name="userpwd"><br>
    验证码:<input name="userloginimgcheck" style="width: 80px"><img src="<%=request.getContextPath()%>/userloginimgcheck" onclick="resetsrc(this)"><br>
    <input type="submit" value="登陆">
</form>
</fieldset>


</body>
</html>
