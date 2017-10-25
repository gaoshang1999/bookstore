<%@ include file="../admin/header.jspf"%>


<div class="col-sm-12 main">
	<%@ include file="../common/errors.jspf"%>
	<h2 class="sub-header">
		Order List <i class="fa fa-language pull-right  small m-t-xs" aria-hidden="true"></i>
		<span class="pull-right  small m-t-xs"><a href="?language=en_US">English</a>
			| <a href="?language=fr_FR">French</a></span>
	</h2>
	<div class="table-responsive">
		<div class="col-sm-12 main"></div>


		<div class="panel-body">
			<table class="table table-condensed table-striped"
				style="border-collapse: collapse;">

				<thead>
					<tr>
						<th>&nbsp;</th>
						<th>#</th>
						<th><spring:message code="allorder.number" /></th>
						<th><spring:message code="allorder.date" /></th>
						<th><spring:message code="allorder.username" /></th>
						<th><spring:message code="allorder.shipping.address" /></th>
						<th><spring:message code="order.zipcode" /></th>
						<th><spring:message code="order.phone" /></th>
					</tr>

				</thead>

				<tbody>
					<c:forEach items="${orders}" var="order">
						<tr data-toggle="collapse" data-target="#${order.orderNo}"
							class="accordion-toggle">
							<td><button class="btn btn-default btn-xs">
									<span class="fa fa-plus"></span>
								</button></td>

							<td>${order.id}</td>
							<td>${order.orderNo}</td>
							<td>${order.time}</td>
							<td>${order.user.username}</td>
							<td>${order.address}</td>
							<td>${order.zipcode}</td>
							<td>${order.phone}</td>
						</tr>
						<tr>
							<td colspan="12" class="hiddenRow"><div
									class="accordian-body collapse" id="${order.orderNo}">
									<table class="table table-striped">
										<thead>
											<tr>
												<th>#</th>
												<th><spring:message code="allorder.title" /></th>
												<th><spring:message code="description" /></th>
												<th><spring:message code="orderlist.category" /></th>
												<th><spring:message code="order.unitprice" /></th>
												<th><spring:message code="order.quantity" /></th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<c:forEach items="${order.orderItems}" var="orderItem">
													<tr>
														<td>${orderItem.book.id}</td>
														<td>${orderItem.book.title}</td>
														<td>${orderItem.book.description}</td>
														<td>${orderItem.book.category.name}</td>
														<td>${orderItem.book.price}</td>
														<td>${orderItem.quantity}</td>
													</tr>
												</c:forEach>
										</tbody>
									</table>

								</div></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

	</div>

</div>
<%@ include file="../admin/footer.jspf"%>