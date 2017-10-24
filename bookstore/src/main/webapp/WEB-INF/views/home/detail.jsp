<%@ include file="../app/header.jspf"%>

<script type="text/javascript"
	src='<spring:url value="/resource/js/addbooktocart.js"></spring:url>'></script>
<script type="text/javascript"
	src='<spring:url value="/resource/js/removebookfromcart.js"></spring:url>'></script>

<!-- Page Content -->
<div class="container">

	<div class="row">

		<div class="col-lg-3">
			<h1 class="my-4">Book Store</h1>
			<div class="list-group">


				<c:forEach items="${categoryList}" var="category">
					<div class="list-group">

						<a href="/bookstore/home/${category.id}" class="list-group-item">${category.name}</a>
					</div>
				</c:forEach>



			</div>
		</div>
		<!-- /.col-lg-3 -->

		<div class="col-lg-9">

			<div class="card mt-4">
				<img class="card-img-top"
					src="<spring:url value='/resource/${book.imagePath} '/>" alt="">
				<div class="card-body">
					<h3 class="card-title">${book.title}</h3>
					<h4>$${book.price}</h4>
					<p class="card-text">${book.description}</p>

					<hr>

					<div id="${book.id}" class="btn btn-success addBookToCart">Add
						to cart</div>

				</div>
			</div>
			<!-- /.card -->


			<!-- /.card -->

		</div>
		<!-- /.col-lg-9 -->

	</div>

</div>
<!-- /.container -->

<%@ include file="../app/footer.jspf"%>
