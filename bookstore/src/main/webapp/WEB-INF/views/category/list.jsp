

<%@ include file="../admin/header.jspf"%>



<div class="col-sm-12 main">

	<%@ include file="../common/errors.jspf"%>

	<h2 class="sub-header">
		Category List <a class="btn btn-primary pull-right"
			href="<spring:url value="/category/new" />" tabindex="4">New </a>



		<form class="search_form pull-right form-inline" role="form"
			method="get" action="<spring:url value="/category/query" />">

			<button class="btn btn-primary pull-right" type="submit" tabindex="3">Search</button>

			<input class="form-control pull-right" type="text" placeholder=""
				name="q" value="" tabindex="2" />

		</form>

	</h2>

	<div class="table-responsive">

		<table class="table table-striped">

			<thead>

				<tr>

					<th>#</th>

					<th>Name</th>

					<th>Description</th>

					<th>Edit</th>

					<th>Delete</th>

				</tr>

			</thead>

			<tbody>

				<c:forEach items="${list}" var="category">

					<tr>

						<td>${category.id}</td>

						<td><a href=""></a> ${category.name}</td>

						<td>${category.description}</td>


						<td><a
							href="<spring:url value="/category/edit/${category.id}" />"
							class="btn btn-primary"> Edit </a></td>

						<td><form
								action="<spring:url value="/category/delete/${category.id}" />"
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