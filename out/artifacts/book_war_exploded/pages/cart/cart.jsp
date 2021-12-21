<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
	<%--静态包含base标签，css样式，jquery文件--%>
	<%@ include file="/pages/commond/head.jsp"%>
	<script type="text/javascript">
		$(function () {
			//删除商品绑上单击事件
			$("a.deleteItem").click(function () {
				return confirm("你确定要删除【"+$(this).parent().parent().find("td:first").text()+"】吗?")
			});

			//给清空购物车绑上单击事件
			$("#clearCart").click(function () {
				return confirm("你确定要清空购物车吗?");
			});

			$(".updateCount").change(function () {
				//获取商品名称
				var name = $(this).parent().parent().find("td:first").text();
				//获取商品数量
				var count = this.value;
				//获取商品id
				var id = $(this).attr("bookId");/*$(this)转为jquery对象*/
				if (count>0 && confirm("你确定要将【"+name+"】的数量改为【"+count+"】吗?")){
					location.href="http://localhost:8080/book/cartServlet?action=updateCount&id="+id+"&count="+count;
				}else {
					this.value = this.defaultValue;
				}

			})

		});
	</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>
		<%@ include file="/pages/commond/login_success_commond.jsp"%>
	</div>
	
	<div id="main">
	
		<table>

			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>

			<%--如果购物车非空才遍历--%>
			<c:if test="${not empty sessionScope.cart.items}">
				<c:forEach items="${sessionScope.cart.items}" var="entry"><%--键值对--%>
					<tr>
						<td>${entry.value.name}</td><%--cartItem.getName,是EL表达式GETName方法--%>
						<td><input style="width: 80px" type="text" class="updateCount" value="${entry.value.count}" bookId="${entry.value.id}"></td>
						<td>${entry.value.price}</td>
						<td>${entry.value.totalPrice}</td>
						<td><a class="deleteItem" href="cartServlet?action=deleteItem&id=${entry.value.id}">删除</a> </td>
					</tr>
				</c:forEach>
			</c:if>
			<%--如果购物车空，提醒用户--%>
			<c:if test="${empty sessionScope.cart.items}">
				<tr>
					<td colspan="5"><a href="index.jsp">亲，购物车是空的，快来首页逛逛吧!!!</a></td>
				</tr>
			</c:if>

		</table>

		<%--如果购物车非空才输出--%>
		<c:if test="${not empty sessionScope.cart.items}">
			<div class="cart_info">
				<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
				<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
				<span class="cart_span"><a id="clearCart" href="cartServlet?action=clear">清空购物车</a></span>
				<span class="cart_span"><a href="orderServlet?action=createOrder">去结账</a></span>
			</div>
		</c:if>

	
	</div>
	
	<%@ include file="/pages/commond/footer.jsp"%>
</body>
</html>