

<%@ include file="../admin/header.jspf" %>



<div class="col-sm-10 col-sm-offset-1 main">

   <%@ include file="../common/errors.jspf" %>

  <h2 class="page-header">Edit Category </h2>

  <form:form class="form-horizontal" modelAttribute="category"  role="form" method="post" action="/bookstore/category/save/${category.id} ">

      <div class="form-group">

      <label for="name" class="col-sm-2 control-label"><span style="color: red">*</span>Name</label>

      <div class="col-sm-9">

        <form:input type="input" class="form-control" path="name" placeholder="name" value="${category.name}"/>

      </div>

    </div>

    <div class="form-group">

      <label for="description" class="col-sm-2 control-label"><span style="color: red">*</span>Description</label>

      <div class="col-sm-9">

        <form:input type="input" class="form-control" path="description" placeholder="description" value="${category.description}"/>

      </div>

    </div>

    <div class="form-group">

      <div class="col-sm-offset-2 col-sm-10">

        <button type="submit" class="btn btn-primary">Save</button> <button type="button" class="btn btn-primary" onclick="javascript :history.back(-1)">Back</button>

      </div>

    </div>

  </form:form>

</div>



<%@ include file="../admin/footer.jspf" %>