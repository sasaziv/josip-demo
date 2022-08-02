<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="includes.jsp"%>
<c:set var="pageTitle">Proizvod</c:set>
<%@include file="header.jsp"%>
<%@include file="mainMenu.jsp" %>


	<a href="products"></a>
	<form:form action="product" method="post" modelAttribute="product">
		<form:hidden path="id" />
		<table>

			<tr>
				<td>Name:</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>Price:</td>
				<td><form:input path="price" /></td>
			</tr>
			<tr>
				<td>Category:</td>
				<td><form:select path="category">

						<c:forEach items="${categoryList}" var="category">
							<option value="${category.id}"
								${product.category.id == category.id ? 'selected="selected"' : ''}>${category.name}</option>
						</c:forEach>

					</form:select></td>
			</tr>
			<tr>
				<td><button type="submit">Save</button></td>
			</tr>
		</table>

	</form:form>
</body>
</html>