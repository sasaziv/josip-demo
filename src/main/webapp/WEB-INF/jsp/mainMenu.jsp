<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="main-menu">
	<div>
		<a href="/">Home</a>
	</div>

	<ul class="menu-picker">
		<li><a href="/products">Products</a></li>
		<li><a href="/categories">Categories</a></li>
		<!--    <li>${request.getAttribute("javax.servlet.forward.request_uri")}</li>
		<li>URL is: <font color="red"><%=request.getRequestURL()%></li>
		<li>${requestScope['javax.servlet.forward.request_uri']}</li>
		${pageContext.request.contextPath}
		${requestScope['javax.servlet.forward.request_uri']}
		request.getRequestURL().toString()
		request.getRequestURI().substring(request.getContextPath().length()).toLowerCase().trim()
		<li> -->
		<button type="button" id="btnModal"">Login</button>
		</li>
	</ul>
	<div id="modal">

		<div id="modal-content">
			<form method="POST" action="http://localhost:8081/login">
				<%
				String contextRelativePath = request.getRequestURI();
				String queryString = request.getQueryString();
				if (queryString != null) {
					contextRelativePath = contextRelativePath + "?" + queryString.substring(queryString.indexOf(".jsp") + 4);
				}
				%>
				<input id="currentUrl" type="hidden" name="url">
				<table>
					<tr>
						<td>Name:</td>
						<td><input name="userName"></td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><input type="password" name="password"></td>
					</tr>
					<tr>
						<td><button type="submit">Login</button></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</div>


<script>
	let mymodal = document.getElementById("modal");

	let btn = document.getElementById("btnModal");
	
	let url  = window.location.href;
	
	document.getElementById("currentUrl").value = url;

	btn.onclick = function() {
		mymodal.style.display = "flex"
	}

	window.onclick = function(event) {
		if (event.target == mymodal) {
			modal.style.display = "none";
		}
	}
</script>