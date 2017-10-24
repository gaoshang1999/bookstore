<%@ include file="../app/header.jspf"%>

<!-- Page Content -->
<div class="container">

	<div class="row">


		<div class="col-lg-12">


			<div class="card card-outline-secondary my-4">
				<div class="card-header">Change Password</div>
				<form:form class="form-horizontal" modelAttribute="password"
					role="form" method="post"
					action="/bookstore/profile/changePassword">
					<spring:hasBindErrors name="password">
						<div class="alert alert-danger">
							<form:errors path="*" element="div" />
						</div>
					</spring:hasBindErrors>
					<c:if test="${param.success != null}">
						<div class="alert alert-success">
							<p>Your password have been changed successfully.</p>
						</div>
					</c:if>
					<div class="card-body">
						<table class="table ">

							<tbody>
								<tr>
									<td>Old Password</td>
									<td colspan="4" class="text-left"><form:input
											type="password" class="form-control" path="old_password"
											value="" /></td>
								</tr>
								<tr>
									<td>New Password</td>
									<td colspan="4" class="text-left"><form:input
											type="password" class="form-control" path="new_password"
											value="" /></td>
								</tr>
								<tr>
									<td>Confirm Password</td>
									<td colspan="4" class="text-left"><form:input
											type="password" class="form-control" path="confirm_password"
											value="" /></td>
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
						<button type="submit" class="btn btn btn-success">Save</button>
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
