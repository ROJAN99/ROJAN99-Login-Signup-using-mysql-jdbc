<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My login page</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
	<h4> ${regMsg }</h4>
  <h2>Please Login</h2>
  <form action="authenticateServlet" method="post">
    <div class="form-group">
      <label> username: </label>
      <input type="text" class="form-control" placeholder="Enter username" name="user">
    </div>
    
    <div class="form-group">
      <label> Password:</label>
      <input type="password" class="form-control" placeholder="Enter password" name="pwd">
    </div>
  
    <button type="submit" class="btn btn-default">Login</button>
   
    <a href="signup.jsp">
    	<button type="button" class="btn btn-info"> SignUp</button>
    </a>
  </form>
  <br>
  
	<h4> ${msg } </h4>
</div>



</body>
</html>