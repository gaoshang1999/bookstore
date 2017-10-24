<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>

<html lang="en">

<head>

<meta charset="utf-8">

<meta http-equiv="X-UA-Compatible" content="IE=edge">

<meta name="viewport" content="width=device-width, initial-scale=1">



<title>Online Book store</title>


<meta name="keywords" content="your, awesome, keywords, here" />


<meta name="author" content="YQ" />



<meta name="description"
	content="Lorem ipsum dolor sit amet, nihil fabulas et sea, nam posse menandri scripserit no, mei." />



<!-- Bootstrap core CSS -->

<link href="<spring:url value='/resource/css/bootstrap.min.css' />"
	rel="stylesheet">

<!-- Custom styles for this template -->

<link href="<spring:url value='/resource/css/dashboard.css' /> "
	rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->

<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->

<!--[if lt IE 9]>

    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>

    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

    <![endif]-->



</head>

<body>

	<nav class="navbar navbar-default navbar-inverse navbar-fixed-top">

		<div class="container">

			<div class="navbar-header">

				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">

					<span class="sr-only">Toggle Navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>

				</button>

				<a class="navbar-brand" href="{{ url('index') }}">BookStore</a>

			</div>

			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">


				<ul class="nav navbar-nav">

					<li><a href="<spring:url value='/user' />">User</a></li>

					<li><a href="<spring:url value='/category' />">Category</a></li>

					<li><a href="<spring:url value='/book' />">Book</a></li>

					<li><a href="<spring:url value='/order' />">Order</a></li>

				</ul>


				<ul class="nav navbar-nav navbar-right">



					<li class="{{ (Request::is('auth/login') ? 'active' : '') }}">

						<a href="{{ url('auth/login') }}"><i class="fa fa-sign-in"></i>
							Login</a>

					</li>

					<li class="{{ (Request::is('auth/register') ? 'active' : '') }}">

						<a href="{{ url('auth/register') }}">Register</a>

					</li>




				</ul>

			</div>

		</div>

	</nav>





	<div class="container"></div>

	<script src="<spring:url value='/resource/js/jquery-2.1.4.min.js' />"></script>

	<script src="<spring:url value='/resource/js/bootstrap.min.js' />"></script>

	<!-- Scripts -->

	<script>

    $('#flash-overlay-modal').modal();

    $('div.alert').not('.alert-danger').delay(3000).slideUp(300);

</script>




</body>

</html>