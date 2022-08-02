<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="includes.jsp"%>
<c:set var="pageTitle">Products from ${category.name}</c:set>
<%@include file="header.jsp"%>
<%@include file="mainMenu.jsp" %>

<button type="button" name="back" onclick="location.href='/categories';">back</button>

<table>
<c:forEach items="${products}" var="product">
<tr>
<td>${product.name}</td>
<tr>
</c:forEach>
</table>
</body>
</html>