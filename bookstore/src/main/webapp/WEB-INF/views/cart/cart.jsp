<%@ include file="/WEB-INF/views/app/header.jspf"%>


<script type="text/javascript"
	src='<spring:url value="/resource/js/cart.js"></spring:url>'></script>
<script type="text/javascript"
	src='<spring:url value="/resource/js/removebookfromcart.js"></spring:url>'></script>




<div class="container">
	<div class="header">
		<header class="jumbotron my-4">
			<h1 class="display-3">Shopping cart</h1>
		</header>
	</div>
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-md-9">
				<div class="ibox">
					<div class="ibox-title">
						<span class="pull-right">(<strong id="bookCartCount">${bookCartCount}</strong>)
							books
						</span>
						<h5>Items in your cart</h5>
					</div>
					<form:form modelAttribute="orderItemList" action="order/neworder"
						method="get">
						<div class="ibox-content">
							<c:forEach var="book" items="${books}" varStatus="status">
								<div class="ibox-content">
									<div class="table-responsive">
										<table class="table shoping-cart-table">
											<tbody>
												<tr>
													<td width="90">
														<div class="img">
															<img alt="${book.title}"
																src="<spring:url value='/resource/${book.imagePath}'/>"
																class="img-responsive">
														</div>
													</td>
													<td class="desc">
														<h3>
															<a href="<spring:url value='/detail/${book.id}' />"
																class="text-navy"> ${book.title} </a>
														</h3>
														<dl class="small m-b-none">
															<dt>Description</dt>
															<dd>${book.description}</dd>
														</dl>

														<div class="m-t-sm">
															<a href="" class="text-muted"><i
																class="fa fa fa-shopping-cart"></i> Checkout</a> | <a
																id="${book.id}" href=""
																class="text-muted removeBookFromCart"><i
																class="fa fa-trash"></i> Remove item</a>
														</div>
													</td>

													<td><h4 class="unitPrice">$${book.price}</h4></td>
													<td width="65"><form:input type="text"
															path="orderItems[${status.index}].quantity"
															class="form-control quantities" placeholder="1"
															name="quantity" value="1"></form:input></td>
													<td></td>
												</tr>
											</tbody>
										</table>
									</div>

								</div>
								<form:input type="text" hidden="true"
									path="orderItems[${status.index}].book.id" value="${book.id}"></form:input>
							</c:forEach>
							<div class="ibox-content">
								<button class="btn btn-primary pull-right decrementCart">
									<i class="fa fa fa-shopping-cart "></i> Checkout
								</button>
								<a class="btn btn-white" href="home"> <i
									class="fa fa-arrow-left"></i> Continue shopping
								</a>
							</div>
						</div>
					</form:form>
				</div>
			</div>

			<div class="col-md-3">
				<div class="ibox">
					<div class="ibox-title">
						<h5>Cart Summary</h5>
					</div>
					<div class="ibox-content">
						<span> Total </span>
						<!-- ${totalprice} -->
						<h2 class="font-bold" id="totalCost">$${bookCartTotalCost}</h2>

						<hr>
						<span class="text-muted small"> *For United States, France
							and Germany applicable sales tax will be applied </span>
						<!-- <div class="m-t-sm">
							<div class="btn-group">
								<a href="#" class="btn btn-primary btn-sm"><i
									class="fa fa-shopping-cart"></i> Checkout</a> <a href="home"
									class="btn btn-white btn-sm"> Cancel</a>
							</div>
						</div> -->
					</div>
				</div>

				<div class="ibox">
					<div class="ibox-title">
						<h5>Support</h5>
					</div>
					<div class="ibox-content text-center">
						<h3>
							<i class="fa fa-phone"></i> +12 345 6789
						</h3>
						<span class="small"> Please contact with us if you have any
							questions. We are available 24/7. </span>
					</div>
				</div>

				<div class="ibox">
					<div class="ibox-content">

						<p class="font-bold">Other products you may be interested</p>
						<hr>
						<c:forEach var="anotherbook" items="${otherBooks}">
							<div>
								<a href="<spring:url value='/detail/${anotherbook.id}' />"
									class="product-name"> ${anotherbook.title} 1 </a>
								<div class="small m-t-xs">${anotherbook.description}</div>
								<div class="m-t text-righ">

									<a href="<spring:url value='/detail/${anotherbook.id}' />"
										class="btn btn-xs btn-outline btn-primary">Info <i
										class="fa fa-long-arrow-right"></i>
									</a>
								</div>
							</div>
							<hr>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>



<!-- /.container -->
<%@ include file="/WEB-INF/views/app/footer.jspf"%>