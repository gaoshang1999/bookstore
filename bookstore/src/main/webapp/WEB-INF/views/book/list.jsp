

<%@ include file="../admin/header.jspf"%>



<div class="col-sm-12 main">

	<%@ include file="../common/errors.jspf"%>

	<h2 class="sub-header">
		Book List <a class="btn btn-primary pull-right"
			href="<spring:url value="/book/new" />" tabindex="4">New </a>



		<form class="search_form pull-right form-inline" role="form"
			method="get" action="<spring:url value="/book/query" />">

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

					<th>Title</th>

					<th>Description</th>
					<th>Category</th>
					<th>Price</th>

					<th>Edit</th>

					<th>Delete</th>

				</tr>

			</thead>

			<tbody>

				<c:forEach items="${bookList}" var="book">

					<tr>

						<td>${book.id}</td>

						<td><a href=""></a> ${book.title}</td>

						<td>${book.description}</td>
						<td>${book.category.name}</td>
						<td>${book.price}</td>


						<td><a href="<spring:url value="/book/edit/${book.id}" />"
							class="btn btn-primary"> Edit </a></td>

						<td><form
								action="<spring:url value="/book/delete/${book.id}" />"
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