<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/12/3 0003
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>头像</title>
</head>
<body>
    <form action="http://localhost:8080/01_servlet/upLoadServlet" method="post" enctype="multipart/form-data">
        用户名：<input type="text" name="username"/><br/>
        头像文件：<input type="file" name="photo"/><br/>
        <input type="submit" value="上传"/>
    </form>
</body>
</html>
