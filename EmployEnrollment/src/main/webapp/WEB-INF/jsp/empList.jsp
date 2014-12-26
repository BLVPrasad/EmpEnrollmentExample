<!DOCTYPE html> 

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html lang="en">

<head>
    <title>Employee Page</title>
     <style type="text/css">
        body {
            font-family: verdana;
            font-size: 12px;
            margin: 40px;
        }
        .bookTable, .bookTable td {
            border-collapse: collapse;
            border: 1px solid #aaa;
            margin: 2px;
            padding: 2px 2px 2px 10px;
            font-size: 12px;
        }
        .bookTable th {
            font-weight: bold;
            font-size: 12px;
            background-color: #5C82FF;
            color: white;
        }
        .bookLabel {
            font-family: verdana;
            font-size: 12px;
            font-weight: bold;
        }
        a, a:AFTER {
            color: blue;
        }
    </style>
  <link href="assets/css/bootstrap-united.css" rel="stylesheet" />
</head>
<body>

	<script src="jquery-1.8.3.js">
		
	</script>

	<script src="bootstrap/js/bootstrap.js">
		
	</script>

<div class="navbar navbar-default">

		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-responsive-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>

		<div class="navbar-collapse collapse navbar-responsive-collapse">
			<form class="navbar-form navbar-right">
				<input type="text" class="form-control" placeholder="Search">
			</form>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="index.jsp">Home</a></li>
				<li><a href="signup.html">Signup</a></li>
				<li class="active"><a href="login.html">Login</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">Explore<b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="#">Contact us</a></li>
						<li class="divider"></li>
						<li><a href="#">Further Actions</a></li>
					</ul></li>
			</ul>
		</div>
		<!-- /.nav-collapse -->
	</div>



    <h2>Employees</h2>

      
    <c:if test="${!empty emps}">
    <table class="bookTable">
    <tr>
        <th width="180">User Name </th>
        <th width="80">User Id</th>
        <th width="90">First name</th>
        <th width="90">Last Name</th>
        <th width="100">E-mail</th>
    </tr>
    <c:forEach items="${emps}" var="emp">
        <tr>
            <td>
	  <a href="<c:url value='/edit/${emp.id}' />" >${emp.userName}</a> 
      </td>
            <td>${emp.id}</td>
            <td>${emp.firstName}</td>
            <td>${emp.lastName}</td>
            <td>${emp.emailAddress}</td>
           <%--  <td><img  width="30px" height="30px" src="<c:url value='/images/delete.png' />"
                title="Delete Book"
                onclick="javascript:deleteBook(${emp.id})" />
 		        <a href="<c:url value='/edit/${emp.id}' />"  >
                    <img  width="30px" height="25px" src="<c:url value='/images/insert.png' />" 
          title="Edit Book"/>
                </a>
            </td> --%>
        </tr>
    </c:forEach>
    </table>
</c:if>
    
  <%--   <table class="table-buttons">
        <tr>
            <td>
                <a href="<spring:url value="/vets.xml" htmlEscape="true" />">View as XML</a>
            </td>
            <td>
                <a href="<spring:url value="/vets.atom" htmlEscape="true" />">Subscribe to Atom feed</a>
            </td>
        </tr>
    </table> --%>

   
</div>
</body>

</html>
