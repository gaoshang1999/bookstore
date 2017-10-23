

<%@ include file="../admin/header.jspf"%>



<div class="col-sm-10 col-sm-offset-1 main">

	<%@ include file="../common/errors.jspf"%>

	<h2 class="page-header">Edit User</h2>

	<form:form class="form-horizontal" modelAttribute="user" role="form"
		method="post" action="/bookstore/user/save/${user.id} ">

		<div class="form-group">

			<label for="username" class="col-sm-2 control-label"><span
				style="color: red">*</span>Username</label>

			<div class="col-sm-9">

				<form:input type="input" class="form-control" path="username"
					placeholder="username" value="${user.username}" />
				<form:input type="hidden" class="form-control" path="password"
					value="${user.password}" />

			</div>

		</div>

		<div class="form-group">

			<label for="lastName" class="col-sm-2 control-label"><span
				style="color: red">*</span>Last Name</label>

			<div class="col-sm-9">

				<form:input type="input" class="form-control" path="lastName"
					placeholder="lastName" value="${user.lastName}" />

			</div>

		</div>

		<div class="form-group">

			<label for="firstName" class="col-sm-2 control-label"><span
				style="color: red">*</span>First Name</label>

			<div class="col-sm-9">

				<form:input type="input" class="form-control" path="firstName"
					placeholder="firstName" value="${user.firstName}" />

			</div>

		</div>



		<div class="form-group">

			<label for="address" class="col-sm-2 control-label"><span
				style="color: red">*</span>Adress</label>

			<div class="col-sm-9">

				<form:input type="input" class="form-control" path="address"
					placeholder="address" value="${user.address}" />

			</div>

		</div>

		<div class="form-group">

			<label for="zipcode" class="col-sm-2 control-label"><span
				style="color: red">*</span>Zipcode</label>

			<div class="col-sm-9">

				<form:input type="number" class="form-control" path="zipcode"
					placeholder="zipcode" value="${user.zipcode}" />

			</div>

		</div>


		<div class="form-group">

			<label for="phone" class="col-sm-2 control-label"><span
				style="color: red">*</span>Phone</label>

			<div class="col-sm-9">

				<form:input type="phone" class="form-control" path="phone"
					placeholder="phone" value="${user.phone}" />

			</div>

		</div>



		<div class="form-group">

			<div class="col-sm-offset-2 col-sm-10">

				<button type="submit" class="btn btn-primary">Save</button>
				<button type="button" class="btn btn-primary"
					onclick="javascript :history.back(-1)">Back</button>

			</div>

		</div>



	</form:form>

</div>



<%@ include file="../admin/footer.jspf"%>