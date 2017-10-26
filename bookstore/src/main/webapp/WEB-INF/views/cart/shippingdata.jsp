<%@ include file="/WEB-INF/views/app/header.jspf"%>



<div class="container">
	<div class="header">
		<header class="jumbotron my-4">
			<h1 class="display-3">
				<spring:message code="cart.header" />
			</h1>
		</header>
	</div>
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-md-9">
				<div class="text m-t-xs pull-right"></div>
				<div class="ibox">
					<div class="ibox-title">

						<span class="pull-right">(<strong id="bookCartCount">${bookCartCount}</strong>)
							<spring:message code="cart.books" />
						</span>
						<h5>
							<spring:message code="cart.items" />
						</h5>

					</div>
					<form:form modelAttribute="order"
						action="/bookstore/order/${order.orderNo}" method="post">
						<div class="ibox-content">
							<h3>
								<a href="<spring:url value='/order' />" class="text-navy">No:
									${order.orderNo} | ${order.time} </a>
							</h3>
							<dl class="medium m-b-none">
								<dt class="text ">
									<spring:message code="order.shippinginfo" />
								</dt>
								<dd class="text lead">
									<div>
										<spring:message code="order.address" />
										:
										<form:input path="address" />
										<form:errors class="alert alert-danger" path="address" />
									</div>
									<div>
										<spring:message code="order.zipcode" />
										:
										<form:input path="zipcode" />
										<form:errors class="alert alert-danger" path="zipcode" />
									</div>
									<div>
										<spring:message code="order.phone" />
										:
										<form:input path="phone" />
									</div>
								</dd>
							</dl>
							</td>
							<div class="ibox-content">
								<button type="submit"
									class="btn btn-primary pull-right decrementCart">
									<i class="fa fa fa-shopping-cart "></i>
									<spring:message code="cart.checkout" />
								</button>s
							</div>
						</div>
					</form:form>
				</div>
			</div>

			<div class="col-md-3">
				<div class="ibox">
					<div class="ibox-title">
						<h5>
							<spring:message code="cart.sammary" />
							<i class="fa fa-language pull-right" aria-hidden="true"></i> <span
								class="pull-right"><a href="?language=en_US">English</a>
								| <a href="?language=fr_FR">French</a></span>
						</h5>
					</div>
					<div class="ibox-content">
						<span> Total </span>
						<h2 class="font-bold" id="totalCost">$${bookCartTotalCost}</h2>

						<hr>
						<span class="text-muted small"> *<spring:message
								code="cart.paymentnotice" /></span>

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
						<span class="small"> <spring:message code="cart.msg" />
						</span>
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