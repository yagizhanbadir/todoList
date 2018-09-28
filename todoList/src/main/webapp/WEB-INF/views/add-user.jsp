<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New User</title>
<style type="text/css" media="all">
body {
    background: #69A3D6;
}
.form_table {
	text-align: center;
	max-width: 300px;
    margin: auto;
    background: white;
    padding: 10px;
}
</style>
</head>

<body>
	<div class="form_table">
		<form action="/NewEditedProject/add-user.doo" method="POST">
			<p>
				<font color="yellow">${errorMessage }</font>
			</p>
			<h3 style="color: DodgerBlue;">Enter your name:</h3>

			<input type="text" name="username" autofocus="autofocus">
			<h3 style="color: tomato;">Enter your password:</h3>

			<input type="password" name="password">

			<h3>
				<input type="submit" value="Sign Up">
			</h3>
			<br />
		</form>

	</div>
</body>
</html>