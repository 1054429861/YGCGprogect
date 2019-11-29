<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" language="java" isELIgnored="false"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>Hello World!</h2>
<c:forEach items="${goods}" var="v">
    ${v.id}===${v.goodsname}====${v.myorderid}<br>
</c:forEach>
当前第${pageInfo.pageNum}页
<a href="/ssm2019_11_21_war_exploded/testc?page=1">首页</a>
<a href="/ssm2019_11_21_war_exploded/testc?page=${pageInfo.prePage}">上一页</a>
<a href="/ssm2019_11_21_war_exploded/testc?page=${pageInfo.nextPage}">下一页</a>
<a href="/ssm2019_11_21_war_exploded/testc?page=${pageInfo.pages}">末页</a>
<br>
<c:forEach items="${pageInfo.navigatepageNums}" var="v">
    <a style="border: 1px solid salmon" href="/ssm2019_11_21_war_exploded/testc?page=${v}">${v}</a>
</c:forEach>



</body>
</html>
