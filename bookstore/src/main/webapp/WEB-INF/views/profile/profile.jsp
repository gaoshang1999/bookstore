<%@ include file="../app/header.jspf"%>

<!-- Page Content -->
<div class="container">

	<div class="row">


		<div class="col-lg-12">


			<div class="card card-outline-secondary my-4">
				<div class="card-header">Profile Reviews</div>
				<div class="card-body">
					<table class="table ">
						<tbody>
							<tr>
								<td>Username</td>
								<td colspan="4" class="text-left">${user.username}</td>
							</tr>
							<tr>
								<td>First Name</td>
								<td colspan="4">${user.firstName}</td>
							</tr>
							<tr>
								<td>Last Name</td>
								<td colspan="4">${user.lastName}</td>
							</tr>
							<tr>
								<td>Address</td>
								<td colspan="4">${user.address}</td>
							</tr>
							<tr>
								<td>Zipcode</td>
								<td colspan="4">${user.zipcode}</td>
							</tr>
							<tr>
								<td>Phone</td>
								<td colspan="4">${user.phone}</td>
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
					<a href="<spring:url value='/profile/edit' />"
						class="btn btn-success">Edit Profile</a> <a
						href="<spring:url value='/profile/changePassword' />"
						class="btn btn-success">Change Password</a>
				</div>
			</div>
			<!-- /.card -->

		</div>
		<!-- /.col-lg-9 -->

	</div>

</div>
<!-- /.container -->

<%@ include file="../app/footer.jspf"%>
