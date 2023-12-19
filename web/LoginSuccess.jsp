<%@ page import="Entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!--jsp基础配置-->
    <title>论坛主页</title>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!--链入素材-->
    <link rel="stylesheet" href="CSS/TGTool.css">
    <link rel="stylesheet" href="CSS/BackGround.css">
    <script src="JS/TGTool.js" type="text/javascript" ></script>
    <script src="JS/Alert.js" type="text/javascript" ></script>
    <script>
        window.onload=function (){
            var tg=TGTool()
            tg.success("登入成功!")
        }
    </script>
</head>
<body>
<%!
    //获取登入Session,User信息
    HttpSession session;
    User user;
%>
<%
    //获取信息
    session=request.getSession();
    user=(User)session.getAttribute("Forum_username");
    //输出信息
    out.print("您好,"+user.getUsername()+"!欢迎您登入论坛!");
%>
<div class="square">
    <ul>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
    </ul>
</div>
<div class="circle">
    <ul>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
        <li></li>
    </ul>
</div>
</body>
</html>