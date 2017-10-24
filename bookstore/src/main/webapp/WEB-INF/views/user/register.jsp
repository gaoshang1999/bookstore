<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Book Store - Group1</title>
</head>
<body>
	<section>
		<div class="narrow-jumbotron">
			<div class="container text-center">
				<h1>Welcome !!</h1>
			</div>
		</div>
	</section>
	<div class="container">
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Register</h3>
					</div>
					<div class="panel-body">
						<%-- <c:if test="${not empty error}">
							<div class="alert alert-danger">
								<spring:message
									code="AbstractUserDetailsAuthenticationProvider.badCredentials" />
								<br />
							</div>
						</c:if> --%>
						<c:url var="loginUrl" value="/login" />
						<form:form modelAttribute="user" action="/bookstore/register"
							method="post" class="form-horizontal">

							<spring:hasBindErrors name="user">
								<div class="alert alert-danger">
									<form:errors path="*" element="div" />
								</div>
							</spring:hasBindErrors>

							<c:if test="${param.success != null}">
								<div class="alert alert-success">
									<p>
										You have been registered successfully. Please <a
											href="<spring:url value="/login" />" class="text-center">Login</a>
										.
									</p>
								</div>
							</c:if>
							<div class="form-group row">
								<label class="col-sm-3 col-form-label" for="username"><span
									style="color: red">*</span>Username </label>
								<div class="col-sm-9">
									<form:input type="text" class="form-control" id="username"
										path="username" placeholder="Enter Username" />
								</div>
							</div>
							<div class="form-group row">
								<label class="col-sm-3 col-form-label" for="password"><span
									style="color: red">*</span>Password</label>
								<div class="col-sm-9">
									<form:input type="password" class="form-control" id="password"
										path="password" placeholder="Enter Password" />
								</div>
							</div>
							<div class="form-group row">
								<label class="col-sm-3 col-form-label" for="firstName"><span
									style="color: red">*</span>First Name</label>
								<div class="col-sm-9">
									<form:input type="text" class="form-control" id="firstName"
										path="firstName" placeholder="Enter First Name" />
								</div>
							</div>
							<div class="form-group row">
								<label class="col-sm-3 col-form-label" for="lastName"><span
									style="color: red">*</span>Last Name</label>
								<div class="col-sm-9">
									<form:input type="text" class="form-control" id="lastName"
										path="lastName" placeholder="Enter Last Name" />
								</div>
							</div>
							<div class="form-group row">
								<label class="col-sm-3 col-form-label" for="address"><span
									style="color: red">*</span>Address</label>
								<div class="col-sm-9">
									<form:input type="text" class="form-control" id="address"
										path="address" placeholder="Enter Address" />
								</div>
							</div>
							<div class="form-group row">
								<label class="col-sm-3 col-form-label" for="zipcode"><span
									style="color: red">*</span>Zipcode</label>
								<div class="col-sm-9">
									<form:input type="number" class="form-control" id="zipcode"
										path="zipcode" placeholder="Enter Zipcode" />
								</div>
							</div>
							<div class="form-group row">
								<label class="col-sm-3 col-form-label" for="phone"><span
									style="color: red">*</span>Phone</label>
								<div class="col-sm-9">
									<form:input type="number" class="form-control" id="phone"
										path="phone" placeholder="Enter Phone" />
								</div>
							</div>

							<div class="form-actions">
								<input type="submit"
									class="btn btn-block btn-primary btn-default" value="Register">
							</div>
						</form:form>
						<div class="modal-footer">
							<a href="<spring:url value="/login" />" class="text-center">Login</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>