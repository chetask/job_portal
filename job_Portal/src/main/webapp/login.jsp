<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<%@include file="all_component/all_css.jsp"%>
</head>
<body>
	<%@include file="all_component/navbar.jsp"%>
	<div class="container-fluid">
		<div class="row p-5">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<div class="text-center">
							<i class="fa fa-user-plus fa-2x" aria-hidden="true"></i>
							<h5>Login Page</h5>
							<div>
							
							<c:if test="${not empty succMsg }">
						<div class="alert alert-success" role="alert">${succMsg}</div>
						<c:remove var="succMsg"/>
						</c:if>
							
							<%-- <c:if test="${not empty succMsg }">
						<h4 class="text-center text-danger">${succMsg}</h4>
						<c:remove var="succMsg"/>
						</c:if> --%>
							
								<form action="login" method="post">
									<div class="form-group">
										<label for="exampleInputEmail1">Email address</label> <input
											type="email" class="form-control" id="exampleInputEmail1"
											aria-describedby="emailHelp" placeholder="Enter email"
											name="email">
										
									</div>
									<div class="form-group">
										<label for="exampleInputPassword1">Password</label> <input
											type="password" class="form-control"
											id="exampleInputPassword1" placeholder="Password" name="password">
									</div>
									<div class="form-check">
										<input type="checkbox" class="form-check-input"
											id="exampleCheck1"> <label class="form-check-label"
											for="exampleCheck1">Check me out</label>
									</div>
									<button type="submit" class="btn btn-primary">Login</button>
								</form>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
	<%-- <%@include file="all_component/footer.jsp"%> --%>
</body>
</html>