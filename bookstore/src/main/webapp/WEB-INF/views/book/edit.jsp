

<%@ include file="../admin/header.jspf" %>



<div class="col-sm-10 col-sm-offset-1 main">

   <%@ include file="../common/errors.jspf" %>

  <h2 class="page-header">Edit Book </h2>

  <form:form class="form-horizontal"  modelAttribute="book"  role="form" method="post" action="/bookstore/book/save/${book.id} ">

      <div class="form-group">

      <label for="title" class="col-sm-2 control-label"><span style="color: red">*</span>Title</label>

      <div class="col-sm-9">

        <form:input type="input" class="form-control" path="title" placeholder="title" value="${book.title}"/>

      </div>

    </div>

    <div class="form-group">

      <label for="description" class="col-sm-2 control-label"><span style="color: red">*</span>Description</label>

      <div class="col-sm-9">

        <form:input type="input" class="form-control" path="description" placeholder="description" value="${book.description}"/>

      </div>

    </div>
    
    
    <div class="form-group">

      <label for="price" class="col-sm-2 control-label"><span style="color: red">*</span>Price</label>

      <div class="col-sm-9">

        <form:input type="input" class="form-control" path="price" placeholder="description" value="${book.price}"/>

      </div>

    </div>
    
    <div class="form-group">

      <label for="Category" class="col-sm-2 control-label"><span style="color: red">*</span>Category</label>

      <div class="col-sm-9">
      
      <form:select path="category.id" placeholder="category" class=" form-control">
      <form:option value="0" label="Select Category" />
      <form:options items="${categoryList}" itemValue="id" itemLabel="name"/>
      
      </form:select>

      
      </div>

    </div>
    <%-- 
     <div class="form-group">

      <label for="bookImage" class="col-sm-2 control-label"><span style="color: red">*</span>Book Image</label>

      <div class="col-sm-9">

        <form:input type="file" class="form-control" path="bookImage" placeholder="bookImage" value="${book.bookImage}"/>

      </div>

    </div> --%>
    

    <div class="form-group">

      <div class="col-sm-offset-2 col-sm-10">

        <button type="submit" class="btn btn-primary">Save</button> <button type="button" class="btn btn-primary" onclick="javascript :history.back(-1)">Back</button>

      </div>

    </div>

  </form:form>

</div>



<%@ include file="../admin/footer.jspf" %>