<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="includes.jsp"%>
<c:set var="pageTitle">Proizvodi</c:set>
<%@include file="header.jsp"%>
<%@include file="mainMenu.jsp" %>

<body>
	<a href="/product">Add new product</a>
	<div class="table-wrapper">
		<table class="fl-table">
			<tr>
				<th>Name</th>
				<th>Price</th>
				<th>Category</th>
				<th></th>
				<th></th>
			</tr>
			<c:forEach items="${products}" var="product">
				<tr>
					<td>${product.name}</td>
					<td>${product.price}</td>
					<td>${product.category.name}</td>
					<td><a href="/product/${product.id}">Edit</a></td>
					<td><a href="${pageContext.request.contextPath }/products/delete/${product.id}" onclick="return confirm('Are you sure?')">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>