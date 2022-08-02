<%@include file="includes.jsp"%>
<%@include file="header.jsp"%>
<c:set var="pageTitle">kategorija</c:set>
<%@include file="mainMenu.jsp" %>

	
	<!--  	<form:form action="category" method="post" modelAttribute="addCategory">
	</form:form>-->

	<form method="POST">
		<table>
			<tr>
				<td>Name</td>
				<td><input value="${category.name}" name="editCategoryName"></td>
			</tr>
		</table>
		<button type="submit">Save</button>
	</form>
</body>
</html>
