<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<h3> Congratulations ${ username } , you are logged in!</h3>

 
<div class="container">

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
  
  <a href="fetchAllRecords">
  	<button type= "button" class="btn btn-info">Show all Records</button>
  </a>
</div>


 



</body>
</html>