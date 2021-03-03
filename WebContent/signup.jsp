<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>


<div class="container">
  <h2>Please sign up</h2>
  <form action="registrationServlet" method="post">
  
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
  
    <button type="submit" class="btn btn-default">Sign Up</button>
  </form>
  <br>
  ${msg }
</div>

</body>
</html>