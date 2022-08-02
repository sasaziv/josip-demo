<%@include file="includes.jsp" %>
<c:set var="pageTitle">Dodaj kategoriju</c:set>
<%@include file="header.jsp" %>
<%@include file="mainMenu.jsp" %>


<form method="POST">
		<table>
			<tr>
				<td>Naziv</td>
				<td><input name="newCategoryName"></td>
			</tr>
		</table>
		<button type="submit">Add category</button>
	</form>
</body>
</html>