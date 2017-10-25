<%@ include file="../admin/header.jspf"%>


<div class="col-sm-12 main">
	<%@ include file="../common/errors.jspf"%>
	<h2 class="sub-header">Order List</h2>
	<div class="table-responsive">
		<div class="col-sm-12 main"></div>


		<div class="panel-body">
			<table class="table table-condensed table-striped"
				style="border-collapse: collapse;">

				<thead>
					<tr>
						<th>&nbsp;</th>
						<th>#</th>
						<th>Number</th>
						<th>Date</th>
						<th>User Name</th>
						<th>Shipping Address</th>
						<th>ZipCode</th>
						<th>Phone</th>
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
												<th>Title</th>
												<th>Description</th>
												<th>Category</th>
												<th>Price</th>
												<th>Quantity</th>
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