

<%@ include file="../admin/header.jspf"%>



<div class="col-sm-12 main">

	<%@ include file="../common/errors.jspf"%>

	<h2 class="sub-header">
		User List <a class="btn btn-primary pull-right"
			href="<spring:url value="/user/new" />" tabindex="4">New </a>



		<form class="search_form pull-right form-inline" role="form"
			method="get" action="<spring:url value="/user/query" />">

			<button class="btn btn-primary pull-right" type="submit" tabindex="3">Search</button>

			<input class="form-control pull-right" type="text" placeholder=""
				name="q" value="" tabindex="2" />
			<!--  
    <select class="form-control pull-right" id="field" name="field" tabindex="1"> <?php $field = isset($field) ? $field : ""; ?>

      <option value="name" {{ $field==='name' ? 'selected' : '' }}>username</option>

      <option value="phone" {{ $field==='phone' ? 'selected' : '' }}>phone</option>


    </select>  
-->
		</form>

	</h2>

	<div class="table-responsive">

		<table class="table table-striped">

			<thead>

				<tr>

					<th>#</th>

					<th>Username</th>

					<th>First Name</th>

					<th>Last Name</th>

					<th>Role</th>

					<th>Address</th>

					<th>Zipcode</th>

					<th>Phone</th>

					<th>Edit</th>

					<th>Delete</th>

				</tr>

			</thead>

			<tbody>

				<c:forEach items="${list}" var="user">

					<tr>

						<td>${user.id}</td>

						<td><a href=""></a> ${user.username}</td>

						<td>${user.lastName}</td>

						<td>${user.firstName}</td>

						<td>${user.getRoleDescription()}</td>

						<td>${user.address}</td>

						<td>${user.zipcode}</td>

						<td>${user.phone}</td>

						<td><a href="<spring:url value="/user/edit/${user.id}" />"
							class="btn btn-primary"> Edit </a></td>

						<td><form
								action="<spring:url value="/user/delete/${user.id}" />"
								method="post">
								<button type="submit" onclick="return del();"
									class="btn btn-primary">Delete</button>
							</form></td>


					</tr>

				</c:forEach>

			</tbody>

		</table>



	</div>

</div>



<%@ include file="../admin/footer.jspf"%>