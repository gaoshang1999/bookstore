<%@ include file="/WEB-INF/views/admin/header.jspf"%>
<link
	href='<spring:url value="/resource/css/orderdetail.css"></spring:url>'
	rel="stylesheet">
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet">


<div class="container">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-md-9">
				<div class="ibox">
					<div class="ibox-title">
						<span class="pull-right">(<strong>5</strong>) books
						</span>
						<h5>Items in your cart</h5>
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
												<a href="#" class="text-navy"> <!-- ${book.name} -->
													order number | date
												</a>
											</h3>
											<dl class="small m-b-none">
												<dt>order contains how many books</dt>
												<dd>
													user and shipping information
													<!-- ${book.description} -->
												</dd>
											</dl>
										</td>
										<td>
											<div class="btn pull-right">
												<a href="#" class="btn btn-primary btn-sm"><i
													class="fa fa-info"></i> details</a>
											</div>
										</td>
									</tr>
								</tbody>
							</table>
							<div class="ibox-content">
								<button class="btn btn-primary pull-right">
									<i class="fa fa fa-arrow-right"></i> Go to cart
								</button>
								<button class="btn btn-white">
									<i class="fa fa-arrow-left"></i> Continue shopping
								</button>

							</div>
						</div>
					</div>
				</div>
				<div class="ibox">
					<div class="ibox-content product-box">
						<div class="product-desc">
							<small class="text-muted">Category</small> <a href="#"
								class="product-name"> Product</a>

							<div class="small m-t-xs">Many desktop publishing packages
								and web page editors now.</div>
							<div class="m-t text-righ">

								<a href="#" class="btn btn-xs btn-outline btn-primary">Info
									<i class="fa fa-long-arrow-right"></i>
								</a>
							</div>
						</div>
					</div>
				</div>
				<div class="ibox">
					<div class="ibox-content product-box">
						<div class="product-desc">
							<small class="text-muted">Category</small> <a href="#"
								class="product-name"> Product</a>

							<div class="small m-t-xs">Many desktop publishing packages
								and web page editors now.</div>
							<div class="m-t text-righ">

								<a href="#" class="btn btn-xs btn-outline btn-primary">Info
									<i class="fa fa-long-arrow-right"></i>
								</a>
							</div>
						</div>
					</div>
				</div>
				<div class="ibox">
					<div class="ibox-content product-box">
						<div class="product-desc">
							<small class="text-muted">Category</small> <a href="#"
								class="product-name"> Product</a>

							<div class="small m-t-xs">Many desktop publishing packages
								and web page editors now.</div>
							<div class="m-t text-righ">

								<a href="#" class="btn btn-xs btn-outline btn-primary">Info
									<i class="fa fa-long-arrow-right"></i>
								</a>
							</div>
						</div>
					</div>
				</div>
				<div class="ibox">
					<div class="ibox-content product-box">
						<div class="product-desc">
							<small class="text-muted">Category</small> <a href="#"
								class="product-name"> Product</a>

							<div class="small m-t-xs">Many desktop publishing packages
								and web page editors now.</div>
							<div class="m-t text-righ">

								<a href="#" class="btn btn-xs btn-outline btn-primary">Info
									<i class="fa fa-long-arrow-right"></i>
								</a>
							</div>
						</div>
					</div>
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
						<h2 class="font-bold">$390,00</h2>

						<hr>
						<span class="text-muted small"> *For United States, France
							and Germany applicable sales tax will be applied </span>
						<div class="m-t-sm">
							<div class="btn-group">
								<a href="#" class="btn btn-primary btn-sm"><i
									class="fa fa-shopping-cart"></i> Checkout</a> <a href="#"
									class="btn btn-white btn-sm"> Cancel</a>
							</div>
						</div>
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
						<div>
							<a href="#" class="product-name"> <!-- ${otherbookone.name} -->Product
								1
							</a>
							<div class="small m-t-xs">
								<!-- ${otherbookone.description} -->
								Many desktop publishing packages and web page editors now.
							</div>
							<div class="m-t text-righ">

								<a href="#" class="btn btn-xs btn-outline btn-primary">Info
									<i class="fa fa-long-arrow-right"></i>
								</a>
							</div>
						</div>
						<hr>
						<div>
							<a href="#" class="product-name"> <!-- ${otherbooktwo.name} -->Product
								2
							</a>
							<div class="small m-t-xs">
								<!-- ${otherbooktwo.description} -->
								Many desktop publishing packages and web page editors now.
							</div>
							<div class="m-t text-righ">

								<a href="#" class="btn btn-xs btn-outline btn-primary">Info
									<i class="fa fa-long-arrow-right"></i>
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/views/admin/footer.jspf"%>