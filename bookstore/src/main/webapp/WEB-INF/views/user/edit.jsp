

<%@ include file="../admin/header.jspf" %>



<div class="col-sm-10 col-sm-offset-1 main">

   <%@ include file="../common/errors.jspf" %>

  <h2 class="page-header"> <c:if test="${user.id==0}">New</c:if>  <c:if test="${user.id>0}">Edit</c:if> User </h2>
  


  <form:form class="form-horizontal" modelAttribute="user"  role="form" method="post" action="/bookstore/user/save/${user.id} ">
   <spring:hasBindErrors name="user">
	<div class="alert alert-danger">
		<form:errors path="*" element="div" />
	</div>
</spring:hasBindErrors>

      <div class="form-group">

      <label for="username" class="col-sm-2 control-label"><span style="color: red">*</span>Username</label>

      <div class="col-sm-9">

        <form:input type="input" class="form-control" path="username" placeholder="username" value="${user.username}" />
        
 		<form:input type="hidden" class="form-control" path="id"  value="${user.id}"/>
      </div>

    </div>
    <c:if test="${user.id==0}">
   <div class="form-group">

      <label for="password" class="col-sm-2 control-label"><span style="color: red">*</span>Password</label>

      <div class="col-sm-9">

        <form:input type="password" class="form-control" path="password" placeholder="password" value="${user.password}" />

      </div>

    </div>
  </c:if>  
  <c:if test="${user.id>0}"><form:input type="hidden" class="form-control" path="password"  value="${user.password}"/></c:if> 
    <div class="form-group">

      <label for="lastName" class="col-sm-2 control-label"><span style="color: red">*</span>Last Name</label>

      <div class="col-sm-9">

        <form:input type="input" class="form-control" path="lastName" placeholder="lastName" value="${user.lastName}" />

      </div>

    </div>

    <div class="form-group">

      <label for="firstName" class="col-sm-2 control-label"><span style="color: red">*</span>First Name</label>

      <div class="col-sm-9">

        <form:input type="input" class="form-control" path="firstName" placeholder="firstName" value="${user.firstName}" />

      </div>

    </div>

   

    <div class="form-group">

      <label for="address" class="col-sm-2 control-label"><span style="color: red">*</span>Address</label>

      <div class="col-sm-9">

        <form:input type="input" class="form-control" path="address" placeholder="address" value="${user.address}" />

      </div>

    </div>
    
     <div class="form-group">

      <label for="zipcode" class="col-sm-2 control-label"><span style="color: red">*</span>Zipcode</label>

      <div class="col-sm-9">

        <form:input type="number" class="form-control" path="zipcode" placeholder="zipcode" value="${user.zipcode}" />

      </div>

    </div>
    
    
     <div class="form-group">

      <label for="phone" class="col-sm-2 control-label"><span style="color: red">*</span>Phone</label>

      <div class="col-sm-9">

        <form:input type="phone" class="form-control" path="phone" placeholder="phone" value="${user.phone}" />

      </div>

    </div>
    
    
   <div class="form-group">

      <label for="role" class="col-sm-2 control-label"><span style="color: red">*</span>Role</label>

      <div class="col-sm-9">

        
        <form:select path="role" class="form-control">
        	<form:option value="0">Admin</form:option>
        	<form:option value="1">User</form:option>
        </form:select>

      </div>

    </div>


    <div class="form-group">

      <div class="col-sm-offset-2 col-sm-10">

        <button type="submit" class="btn btn-primary">Save</button> 
        <button type="button" class="btn btn-primary" onclick="javascript :history.back(-1)">Back</button>

      </div>

    </div>



  </form:form>

</div>



<%@ include file="../admin/footer.jspf" %>