<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Updating </title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">

	<h4> You are updating following records. Click Continue to Update this record.</h4>
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>USERNAME</th>
        <th>PASSWORD</th>
        <th>FULL NAME</th>
        <th>EMAIL </th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>${userDTO.username }</td>
        <td>${userDTO.password }</td>
        <td>${userDTO.name }</td>
        <td> ${userDTO.email } </td>
      </tr>
    </tbody>
  </table>

</div>


<div class="container">
  <h2>Please Enter the information that you want to update to:</h2>
  <form action="updateServlet" method="post">
  
  	<div class="form-group">
  	  <input type="hidden" name="userFrom" value="${userDTO.username }"/>
  	</div>
  	<div class="form-group">
      <label>Username:</label>
      <input type="text" class="form-control" placeholder="Enter username" name="user">
    </div>
    
    <div class="form-group">
      <label>Full Name:</label>
      <input type="text" class="form-control" placeholder="Enter email" name="name">
    </div>
    
    <div class="form-group">
      <label>Email:</label>
      <input type="email" class="form-control" placeholder="Enter email" name="email">
    </div>
    
    <div class="form-group">
      <label> Password:</label>
      <input type="password" class="form-control" placeholder="Enter password" name="pwd">
    </div>
  
    <button type="submit" class="btn btn-primary">Continue</button>
  </form>
  <br>

</div>
	

</body>
</html>