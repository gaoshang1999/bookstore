

<%@ include file="../admin/header.jspf" %>



<div class="col-sm-10 col-sm-offset-1 main">

   <%@ include file="../common/errors.jspf" %>

  <h2 class="page-header"><spring:message code="product.top.comment"/> </h2> 
  Language : <a href="?language=en_US">English</a>|<a href="?language=nl_NL">Duch</a>
  <br>

  <form:form class="form-horizontal"  modelAttribute="book"  role="form" method="post" action="/bookstore/book/save/${book.id} ">

     <form:errors path="*" cssStyle="color:red"/>
      <div class="form-group">

      <label for="title" class="col-sm-2 control-label"><span style="color: red">*</span><spring:message code="product.title"/></label>

      <div class="col-sm-9">

        <form:input type="input" class="form-control" path="title" placeholder="title" value="${book.title}"/>

      </div>

    </div>

    <div class="form-group">

      <label for="description" class="col-sm-2 control-label"><span style="color: red">*</span><spring:message code="product.description"/></label>

      <div class="col-sm-9">

        <form:input type="input" class="form-control" path="description" placeholder="description" value="${book.description}"/>

      </div>

    </div>
    
    
    <div class="form-group">

      <label for="price" class="col-sm-2 control-label"><span style="color: red">*</span><spring:message code="product.price"/></label>

      <div class="col-sm-9">

        <form:input type="input" class="form-control" path="price" placeholder="description" value="${book.price}"/>

      </div>

    </div>
    
    <div class="form-group">

      <label for="Category" class="col-sm-2 control-label"><span style="color: red">*</span><spring:message code="product.category"/></label>

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