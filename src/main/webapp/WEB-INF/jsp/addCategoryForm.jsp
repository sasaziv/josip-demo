<%@include file="includes.jsp"%>
<%@include file="header.jsp"%>
<c:set var="pageTitle">Add category</c:set>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="mainMenu.jsp" %>	

	
	<form:form action="addcategoryform" method="post"
		 commandName="addCategory" modelAttribute="addCategory">
		<table>
			<tr>
				<td>New category name:</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Add new Category" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>