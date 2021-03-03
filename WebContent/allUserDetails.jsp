<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All users Info</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>


<div class="container">

  <table class="table table-bordered">
    <thead>
      <tr>
        <th>USERNAME</th>
        <th>PASSWORD</th>
        <th>FULL NAME</th>
        <th>EMAIL
        	
        	<div class="dropdown">
  				<button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
   				Sort
 				</button>
  			<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
   			 	<a class="dropdown-item" href="ascendByEmail">Ascending</a>
   				<a class="dropdown-item" href="descendByEmail">Descending</a>
  			</div>
			</div>
        
        </th>
        <th> ACTION </th>
      </tr>
    </thead>
    <tbody>
    	<c:forEach items="${listOfUsers}" var="usr">
    		<tr>    
    			<td>${usr.username }</td>			
    			<td>${usr.password } </td>
    			<td>${usr.name } </td>
    			<td>${usr.email } </td> 
    			<td>
<!--     					goes to deleteRecord servlet with value of username using variable username
 -->    				
 					<a href="deleteServlet?username=${usr.username}">
    					<button type="button" class="btnm btn-info"> Delete</button>
    				</a>
    				<a href="fetchRecord?username=${usr.username}">
    					<button type="button" class="btnm btn-info"> Update</button>
    				</a>
    			</td>
    		</tr>
    	</c:forEach>
    </tbody>
  </table>
   <h4>${deleteMsg } </h4> 
    <h4>${updateMsg } </h4> 
</div>


 
 
</body>
</html>