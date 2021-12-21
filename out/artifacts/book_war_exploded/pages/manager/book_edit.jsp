<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>编辑图书</title>
    <%--静态包含base标签，css样式，jquery文件--%>
    <%@ include file="/pages/commond/head.jsp" %>
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }

        h1 a {
            color: red;
        }

        input {
            text-align: center;
        }
    </style>
</head>
<body>
<div id="header">
    <img class="logo_img" alt="" src="../../static/img/logo.gif">
    <span class="wel_word">编辑图书</span>
    <%@ include file="/pages/commond/manager_menu.jsp" %>
</div>

<div id="main">
    <form action="manager/bookServlet" method="post">
        <input type="hidden"  name="pageNo" value="${param.pageNo}"> <%--param是给request域数据--%>
        <input type="hidden" name="action" value="${param.method}"/>
        <input type="hidden" name="id" value="${requestScope.book.id}"/> <%--a标签等get方法能直接设置name=value,比如id=1,但from标签需要name="",value=""但在request域中都是键值对存储--%>
<%--修改图书判断方法二
        <input type="hidden" name="action" value="${empty param.id ? "add":"update"}">
--%>
        <table>
            <tr>
                <td>名称</td>
                <td>价格</td>
                <td>作者</td>
                <td>销量</td>
                <td>库存</td>
                <td colspan="2">操作</td>
            </tr>
            <tr>
                <td><input name="name" type="text" value="${requestScope.book.name}"/></td>
                <td><input name="price" type="text" value="${requestScope.book.price}"/></td>
                <td><input name="author" type="text" value="${requestScope.book.author}"/></td>
                <td><input name="sales" type="text" value="${requestScope.book.sales}"/></td>
                <td><input name="stock" type="text" value="${requestScope.book.stock}"/></td>
                <td><input type="submit" value="提交"/></td>
            </tr>
        </table>
    </form>


</div>

<%@ include file="/pages/commond/footer.jsp" %>
</body>
</html>