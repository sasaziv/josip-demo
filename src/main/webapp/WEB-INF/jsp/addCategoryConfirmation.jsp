<%@include file="includes.jsp" %>
<c:set var="pageTitle">Successfully added category</c:set>
<%@include file="header.jsp" %>
<%@include file="mainMenu.jsp" %>

You just added  category <strong>${savedCategory.name}</strong>!
<a href="/categories">Back to categories</a>
</body>
</html>