<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Signup Page</title>
<%@include file="all_component/all_css.jsp"%>
</head>
<body style="background-color:#f0f1f2;">
	<%@include file="all_component/navbar.jsp"%>
	<div class="container-fluid">
		<div class="row p-4">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<div >
							<div class="text-center">
							<i class="fa fa-user-plus fa-2x" aria-hidden="true"></i>
							<h5>Registration</h5>
							</div>
							<div>
							<c:if test="${not empty succMsg }">
						<div class="alert alert-success" role="alert">${succMsg}</div>
						<c:remove var="succMsg"/>
						</c:if>
							<form action="add_user" method="post">
							<div class="form-group">
										<label for="exampleInputEmail1">Full Name</label> <input
											type="text" class="form-control" id="exampleInputEmail1"
											aria-describedby="emailHelp" placeholder="name"
											name="name">
										
									</div>
									<div class="form-group">
										<label for="exampleInputEmail1">Enter Qualifacation</label> <input
											type="text" class="form-control" id="exampleInputEmail1"
											aria-describedby="emailHelp" placeholder="Qualifacation"
											name="qua">
										
									</div>
									<div class="form-group">
										<label for="exampleInputEmail1">Email address</label> <input
											type="email" class="form-control" id="exampleInputEmail1"
											aria-describedby="emailHelp" placeholder="Enter email"
											name="em">
									</div>
									
									<div class="form-group">
										<label for="exampleInputPassword1">Password</label> <input
											type="password" class="form-control"
											id="exampleInputPassword1" placeholder="Password" name="ps">
									</div>
									
									<button type="submit" class="btn btn-primary badge-pill btn-block">Register</button>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>