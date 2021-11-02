<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<%@include file="all_component/all_css.jsp"%>
</head>
<body style="background-color:#f7f7f7;">
	<%@include file="all_component/navbar.jsp"%>
	<div class="container-fluid">
		<div class="row p-4">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<div >
							<div class="text-center">
							<i class="fa fa-user-plus fa-2x" aria-hidden="true"></i>
							<h5>Edit Profile</h5>
							</div>
							<div>
							<%-- <c:if test="${not empty succMsg }">
						<div class="alert alert-success" role="alert">${succMsg}</div>
						<c:remove var="succMsg"/>
						</c:if> --%>
							<form action="Update_profile" method="post">
							<input type="hidden" name="id" value="${userobj.id}">
							<div class="form-group">
										<label for="exampleInputEmail1"> Enter Full Name</label> <input
											type="text" class="form-control" id="exampleInputEmail1"
											aria-describedby="emailHelp" value="${userobj.name}"
											name="name">
										
									</div>
									<div class="form-group">
										<label for="exampleInputEmail1">Enter Qualifacation</label> <input
											type="text" class="form-control" id="exampleInputEmail1"
											aria-describedby="emailHelp" value="${userobj.qualification}"
											name="qua">
										
									</div>
									<div class="form-group">
										<label for="exampleInputEmail1">Email address</label> <input
											type="email" class="form-control" id="exampleInputEmail1"
											aria-describedby="emailHelp" value="${userobj.email}"
											name="em">
									</div>
									
									<div class="form-group">
										<label for="exampleInputPassword1">Password</label> <input
											type="password" class="form-control"
											id="exampleInputPassword1" value="${userobj.password}" name="ps">
									</div>
									
									<button type="submit" class="btn btn-primary badge-pill btn-block">Update</button>
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