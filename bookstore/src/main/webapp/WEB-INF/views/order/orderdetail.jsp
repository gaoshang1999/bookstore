<%@ include file="/WEB-INF/views/app/header.jspf"%>

<link href='<spring:url value="/resource/css/cart.css"></spring:url>'
	rel="stylesheet">

<script type="text/javascript"
	src='<spring:url value="/resource/js/cart.js"></spring:url>'></script>
<link
	href='<spring:url value="/resource/css/orderdetail.css"></spring:url>'
	rel="stylesheet">

<div class="container">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-md-9">
				<div class="ibox">
					<div class="ibox-title">
						<h5>Books in order</h5>
					</div>
					<div class="ibox-content">
						<div class="table-responsive">
							<table class="table shoping-cart-table">
								<tbody>
									<tr>
										<td width="90">
											<div class="cart-product-imitation">
												<!-- <img class="card-img-top" src="http://placehold.it/80x120"
													alt=""> -->
											</div>
										</td>
										<td class="desc">
											<h3>
												<a href="#" class="text-navy">No: ${order.orderNo} |
													${order.time} </a>
											</h3>
											<dl class="small m-b-none">
												<dt>Shipping information</dt>
												<dd>
													<p>Address : ${order.address}</p>
													<p>Zip Code : ${order.zipcode}</p>
													<p>Phone : ${order.phone}</p>
												</dd>
											</dl>
										</td>
										<td>
											<div class="btn pull-right">
												<a href="#" class="btn btn-primary btn-sm"><i
													class="fa fa-long-arrow-left"></i>Order List</a>
											</div>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<c:forEach var="book" items="${books}">
					<div class="ibox">
						<div class="ibox-content product-box">
							<div class="product-desc">
								<small class="text-muted">Category : ${book.category.name}</small> <a
									href="<spring:url value='/detail/${book.id}' />"
									class="product-name"> ${book.title}</a>

								<div class="small m-t-xs">${book.description}</div>
								<div class="m-t text-righ">

									<a href="<spring:url value='/detail/${book.id}' />"
										class="btn btn-xs btn-outline btn-primary"> Info <i
										class="fa fa-long-arrow-right"></i>
									</a>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
			<div class="col-md-3">
				<div class="ibox">
					<div class="ibox-title">
						<h5>Cart Summary</h5>
					</div>
					<div class="ibox-content">
						<span> Total </span>
						<h2 class="font-bold">$${totalprice}</h2>

						<hr>
						<span class="text-muted small"> *For United States, France
							and Germany applicable sales tax will be applied </span>
						<div class="m-t-sm"></div>
					</div>
				</div>

				<div class="ibox">
					<div class="ibox-title">
						<h5>Support</h5>
					</div>
					<div class="ibox-content text-center">
						<h3>
							<i class="fa fa-phone"></i> +00 00 0000 00000
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
										class="btn btn-xs btn-outline btn-primary"> Info <i
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
<%@ include file="/WEB-INF/views/app/footer.jspf"%>