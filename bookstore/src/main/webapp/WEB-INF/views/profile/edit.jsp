<%@ include file="../app/header.jspf"%>

<!-- Page Content -->
<div class="container">

	<div class="row">


		<div class="col-lg-12">


			<div class="card card-outline-secondary my-4">
				<div class="card-header">Profile Reviews</div>
				<form:form class="form-horizontal" modelAttribute="user" role="form"
					method="post" action="/bookstore/profile/edit ">
					<spring:hasBindErrors name="user">
						<div class="alert alert-danger">
							<form:errors path="*" element="div" />
						</div>
					</spring:hasBindErrors>
					<div class="card-body">
						<table class="table ">
							<form:input type="hidden" class="form-control" path="id"
								value="${user.id}" />
							<form:input type="hidden" class="form-control" path="password"
								value="${user.password}" />
							<tbody>
								<tr>
									<td>Username</td>
									<td colspan="4" class="text-left"><form:input type="input"
											class="form-control" path="username" placeholder="firstName"
											value="${user.username}" readonly="true" /></td>
								</tr>
								<tr>
									<td>First Name</td>
									<td colspan="4"><form:input type="input"
											class="form-control" path="firstName" placeholder="firstName"
											value="${user.firstName}" /></td>
								</tr>
								<tr>
									<td>Last Name</td>
									<td colspan="4"><form:input type="input"
											class="form-control" path="lastName" placeholder="lastName"
											value="${user.lastName}" /></td>
								</tr>
								<tr>
									<td>Address</td>
									<td colspan="4"><form:input type="input"
											class="form-control" path="address" placeholder="address"
											value="${user.address}" /></td>
								</tr>
								<tr>
									<td>Zipcode</td>
									<td colspan="4"><form:input type="number"
											class="form-control" path="zipcode" placeholder="zipcode"
											value="${user.zipcode}" /></td>
								</tr>
								<tr>
									<td>Phone</td>
									<td colspan="4"><form:input type="phone"
											class="form-control" path="phone" placeholder="phone"
											value="${user.phone}" /></td>
								</tr>
								<tr>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
								</tr>
							</tbody>

						</table>
						<hr>
						<button type="submit" class="btn btn btn-success">Save
							Profile</button>
						<a href="<spring:url value="/profile" />"
							class="btn btn btn-success">Back</a>
					</div>
				</form:form>
			</div>
			<!-- /.card -->

		</div>
		<!-- /.col-lg-9 -->

	</div>

</div>
<!-- /.container -->

<%@ include file="../app/footer.jspf"%>
