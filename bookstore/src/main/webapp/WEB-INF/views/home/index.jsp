<%@ include file="../app/header.jspf"%>

<!-- Page Content -->
<div class="container">

	<div class="row">

		<div class="col-lg-3">

			<h1 class="my-4">Category</h1>


			<div class="list-group">
				<c:forEach items="${categoryList}" var="category">
					<a href="/bookstore/home/${category.id}" class="list-group-item">${category.name}</a>
				</c:forEach>

			</div>



		</div>
		<!-- /.col-lg-3 -->

		<div class="col-lg-9">

			<div id="carouselExampleIndicators" class="carousel slide my-4"
				data-ride="carousel">
				<ol class="carousel-indicators">
					<li data-target="#carouselExampleIndicators" data-slide-to="0"
						class="active"></li>
					<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
					<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
				</ol>
				<div class="carousel-inner" role="listbox">
					<div class="carousel-item active">
						<img class="d-block img-fluid"
							src="<spring:url value='/resource/images/p1.png' />"
							alt="First slide">
					</div>
					<div class="carousel-item">
						<img class="d-block img-fluid"
							src="<spring:url value='/resource/images/p2.png' />"
							alt="Second slide">
					</div>
					<div class="carousel-item">
						<img class="d-block img-fluid"
							src="<spring:url value='/resource/images/p3.png' />"
							alt="Third slide">
					</div>
				</div>
				<a class="carousel-control-prev" href="#carouselExampleIndicators"
					role="button" data-slide="prev"> <span
					class="carousel-control-prev-icon" aria-hidden="true"></span> <span
					class="sr-only">Previous</span>
				</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
					role="button" data-slide="next"> <span
					class="carousel-control-next-icon" aria-hidden="true"></span> <span
					class="sr-only">Next</span>
				</a>
			</div>

			<div class="row">



				<c:forEach items="${bookList}" var="book">
					<div class="col-lg-4 col-md-6 mb-4">
						<div class="card h-100">
							<a href="<spring:url value='/detail/${book.id}' />"><img
								class="card-img-top"
								src="<spring:url value='/resource/${book.imagePath} '/>" alt=""></a>
							<div class="card-body">
								<h4 class="card-title">
									<a href="<spring:url value='/detail/${book.id}' />">${book.title}</a>
								</h4>
								<h5>$${book.price}</h5>
								<p class="card-text">${book.description}</p>
							</div>
							<div class="card-footer">
								<a href="#" class="btn btn-success">Buy</a>
							</div>
						</div>
					</div>
				</c:forEach>










			</div>
			<!-- /.row -->

		</div>
		<!-- /.col-lg-9 -->

	</div>
	<!-- /.row -->

</div>
<!-- /.container -->


<%@ include file="../app/footer.jspf"%>