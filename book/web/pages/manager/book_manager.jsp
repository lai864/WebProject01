<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>图书管理</title>
    <%--静态包含base标签，css样式，jquery文件--%>
    <%@ include file="/pages/commond/head.jsp" %>
    <script type="text/javascript">
        $(function () {
            $("a.deleteBook").click(function () {
                return confirm("你确定要删除" + $(this).parent().parent().find("td:first").text() + "吗?");
            })
        })
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="../../static/img/logo.gif">
    <span class="wel_word">图书管理系统</span>
    <%@ include file="/pages/commond/manager_menu.jsp" %>
</div>

<div id="main">
    <table>
        <tr>
            <td>名称</td>
            <td>价格</td>
            <td>作者</td>
            <td>销量</td>
            <td>库存</td>
            <td colspan="2">操作</td>
        </tr>
        <c:forEach items="${requestScope.page.items}" var="book"> <%--这里有books集合，从数据库查询的，包括book所有属性。是BookServlet程序实现的--%>
            <tr>
                <td>${book.name}</td>
                <td>${book.author}</td>
                <td>${book.price}</td>
                <td>${book.sales}</td>
                <td>${book.stock}</td>
                <td><a href="manager/bookServlet?action=getBook&id=${book.id}&method=update&pageNo=${requestScope.page.pageNo}">修改</a></td>
                <td><a class="deleteBook" href="manager/bookServlet?action=delete&id=${book.id}&pageNo=${requestScope.page.pageNo}">删除</a></td>
            </tr>
        </c:forEach>


        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td><a href="pages/manager/book_edit.jsp?method=add&pageNo=${requestScope.page.pageTotal}">添加图书</a></td>
        </tr>
    </table>

    <%--静态包含分页条--%>
    <%@include file="/pages/commond/pag_nav.jsp"%>

</div>

<%@ include file="/pages/commond/footer.jsp" %>
</body>
</html>