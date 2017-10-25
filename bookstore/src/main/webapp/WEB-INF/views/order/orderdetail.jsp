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

										<td class="desc">
											<h3>
												<a href="<spring:url value='/order' />" class="text-navy">No:
													${order.orderNo} | ${order.time} </a>
											</h3>
											<dl class="medium m-b-none">
												<dt class="text ">Shipping information</dt>
												<dd class="text lead">
													<div>Address : ${order.address}</div>
													<div>Zip Code : ${order.zipcode}</div>
													<div>Phone : ${order.phone}</div>
												</dd>
											</dl>
										</td>
										<td>
											<div class="btn pull-right">
												<a href="<spring:url value='/order' />"
													class="btn btn-primary btn-sm"><i
													class="fa fa-arrow-left"></i> Order List</a>
											</div>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<c:forEach var="orderitem" items="${orderitemlist}">
					<div class="ibox">
						<div class="ibox-content product-box ">
							<div class="text text-right">Quantity :
								${orderitem.quantity} | Unit price : $${orderitem.book.price}</div>
							<div class="col-md-4 col-sm-4 col-xs-4 box box-left">
								<img alt="${orderitem.book.title}"
									src="<spring:url value='/resource/${orderitem.book.imagePath}'/>"
									class="card-img-left img-responsive col-md-5 col-sm-5 col-xs-5 ">
							</div>
							<small class="text-muted">Category :
								${orderitem.book.category.name}</small> <a
								href="<spring:url value='/detail/${book.id}' />"
								class="product-name"> ${orderitem.book.title}</a>
							<div class="small m-t-xs">${orderitem.book.description}</div>
							<div class="m-t text-righ">
								<a href="<spring:url value='/detail/${orderitem.book.id}' />"
									class="btn btn-xs btn-outline btn-primary"> <i
									class="fa fa-info"></i> Info
								</a>
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
						<h2 class="font-bold">$ ${totalprice}</h2>

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