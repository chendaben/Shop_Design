<%--
  Created by IntelliJ IDEA.
  User: chenyanqiu
  Date: 2016/9/20
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>跳转</title>
</head>
<body>
登录超时，<span id="time">3</span>秒后跳转到登录页面
<script>
    var time=parseInt(document.getElementById("time").innerText);
    console.log("the time is :"+time);
    function timeout(){
        time--;
        document.getElementById("time").innerText (time);
    }
    if(time>0){
        setInterval(timeout,1000);
    }else{
        window.location.href="${pageContext.request.contextPath}/jsp/userLogin.jsp";
    }


</script>
</body>
</html>
