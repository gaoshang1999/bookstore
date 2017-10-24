

<%@ include file="../admin/header.jspf" %>



<div class="col-sm-12 main">

  <%@ include file="../common/errors.jspf" %>

  <h2 class="sub-header">Order List

   <a class="btn btn-primary pull-right" href="<spring:url value="/book/new" />" tabindex="4">New </a>

     

   <form class="search_form pull-right form-inline" role="form" method="get" action="<spring:url value="/book/query" />" >    

    <button class="btn btn-primary pull-right" type="submit" tabindex="3">Search</button>

    <input class="form-control pull-right" type="text" placeholder="" name ="q" value="" tabindex="2"/>  

  </form>

  </h2>

  <div class="table-responsive">

    <table class="table table-striped">

      <thead>

        <tr>

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

        <tr>

           <td>${order.id}</td>
          <td>${order.orderNo}</td>

          <td> ${order.time} </td>

          <td>${order.user.username}</td>
           <td>${order.address}</td>
           <td>${order.zipcode}</td>
            <td>${order.phone}</td>


         
 

        </tr>

        </c:forEach>

      </tbody>

    </table>



  </div>

</div>



<%@ include file="../admin/footer.jspf" %>