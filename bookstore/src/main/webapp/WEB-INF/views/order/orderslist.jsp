<%@ include file="/WEB-INF/views/app/header.jspf"%>


<div class="container">
	<div class="header">

		<header class="jumbotron my-4">
			<h1 class="display-4">
				<spring:message code="order.history" />
			</h1>
		</header>
	</div>
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-md-9">
				<div class="ibox-title">
					<span class="pull-right">(<strong>${numberOfOrders}</strong>)
						<spring:message code="order" />
					</span>
					<h5>
						<spring:message code="order.items" />
						
					</h5>
				</div>
				<c:forEach var="order" items="${orders}">
					<div class="ibox">

						<div class="ibox-content">
							<div class="table-responsive">
								<table class="table shoping-cart-table">
									<tbody>
										<tr>
											<td width="10"></td>
											<td class="desc">
												<h3>
													<a href="#" class="text-navy">No: ${order.orderNo} |
														${order.time} </a>
												</h3>
												<dl class="small m-b-none">
													<dt>
														<spring:message code="order.shippinginfo" />
													</dt>
													<dd>
														<p>
															<spring:message code="order.address" />
															: ${order.address}
														</p>
														<p>
															<spring:message code="order.zipcode" />
															: ${order.zipcode}
														</p>
														<p>
															<spring:message code="order.phone" />
															: ${order.phone}
														</p>
													</dd>
												</dl>
											</td>
											<td>
												<div class="btn pull-right">
													<a href="<spring:url value='/order/${order.orderNo}' />"
														class="btn btn-primary btn-sm"><i class="fa fa-info"></i>
														<spring:message code="details" /></a>
												</div>
											</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>

			<div class="col-md-3 ">

				<div class="ibox">
					<div class="ibox-title">
						<h5>Support <i class="fa fa-language pull-right" aria-hidden="true"></i> <span
							class="pull-right"><a href="?language=en_US">English</a> |
							<a href="?language=fr_FR">French</a></span></h5>
					</div>
					<div class="ibox-content text-center">
						<h3>
							<i class="fa fa-phone"></i> +12 345 6789
						</h3>
						<span class="small"> <spring:message code="cart.msg" /></span>
					</div>
				</div>

				<div class="ibox">
					<div class="ibox-content">

						<p class="font-bold">
							<spring:message code="otherbooks.msg" />
						</p>
						<hr>
						<c:forEach var="anotherbook" items="${otherBooks}">
							<div>
								<a href="<spring:url value='/detail/${anotherbook.id}' />"
									class="product-name"> ${anotherbook.title} </a>
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
						<hr>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>



<!-- Footer -->


<!-- /.container -->
<%@ include file="/WEB-INF/views/app/footer.jspf"%>