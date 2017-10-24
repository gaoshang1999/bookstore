

<%@ include file="../admin/header.jspf"%>



<div class="col-sm-10 col-sm-offset-1 main">

	<%@ include file="../common/errors.jspf"%>

	<h2 class="page-header">
		</span>
		<spring:message code="category.top.comment" />
	</h2>
	Language : <a href="?language=en_US">English</a>|<a
		href="?language=nl_NL">Duch</a>
	<form:form class="form-horizontal" modelAttribute="category"
		role="form" method="post"
		action="/bookstore/category/save/${category.id} ">

		<form:errors path="*" cssStyle="color:red" />
		<div class="form-group">

			<label for="name" class="col-sm-2 control-label"><span
				style="color: red">*</span>
			<spring:message code="category.name" text="default text" /></label>

			<div class="col-sm-9">

				<form:input type="input" class="form-control" path="name"
					placeholder="name" value="${category.name}" />

			</div>

		</div>

		<div class="form-group">

			<label for="description" class="col-sm-2 control-label"><span
				style="color: red">*</span>
			<spring:message code="category.description" text="default text" /></label>

			<div class="col-sm-9">

				<form:input type="input" class="form-control" path="description"
					placeholder="description" value="${category.description}" />

			</div>

		</div>

		<div class="form-group">

			<div class="col-sm-offset-2 col-sm-10">

				<button type="submit" class="btn btn-primary">Save</button>
				<button type="button" class="btn btn-primary"
					onclick="javascript :history.back(-1)">Back</button>

			</div>

		</div>

	</form:form>

</div>



<%@ include file="../admin/footer.jspf"%>