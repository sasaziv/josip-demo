<%@include file="includes.jsp"%>
<%@include file="header.jsp"%>
<c:set var="pageTitle">Kategorije</c:set>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="mainMenu.jsp"%>

<div>
	<a href="/addcategory">Add category</a> <a href="/addcategoryform">Add
		category s-form</a>
</div>
<div class="table-wrapper">
	<table class="fl-table">
		<tr>
			<th>Naziv</th>
			<th></th>
			<th></th>
		</tr>
		<c:forEach items="${categories}" var="category">
			<tr>
				<td>${category.name}</td>
				<td><a
					href="${pageContext.request.contextPath }/${category.name}/products?categoryId=${category.id}">Products</a>
					(${category.numberOfProducts})</td>
				<td><button
						onclick="location.href='http://localhost:8081/categories/${category.id}'">Edit</button></td>
				<td><a
					href="${pageContext.request.contextPath }/categories/delete/${category.id}"
					onclick="return confirm('Are you sure?')">Delete</a></td>
			</tr>

		</c:forEach>
	</table>
</div>

</body>
</html>
<script>
	
</script>