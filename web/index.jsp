<%--
  Created by IntelliJ IDEA.
  User: 29542
  Date: 2023/12/18
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <!--jsp基础配置-->
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>论坛首页面</title>
  <!--链入素材-->
  <link rel="stylesheet" href="CSS/BackGround.css">
</head>
<body>
<form action="/ForumWeb/SessionServlet" method="post">
<div class="container">
  <div class="title">太原理工大学论坛</div>
  <button type="submit">进入论坛</button>
</div>
</form>
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
