<%@ include file="../common/header.jspf"%>

	<div class="container">
		<form action="/NewEditedProject/login.do" method="POST">
			<p>
				<font color="yellow">${errorMessage }</font>
			</p>
			<h3 style="color: DodgerBlue;">Enter your name:</h3>

			<input type="text" name="name" autofocus="autofocus">

			<h3 style="color: tomato;">Enter your password:</h3>

			<input type="password" name="password">
			<h3>
				<input type="submit" value="Sign In"> <input type="reset"
					value="Reset">
			</h3>
			<br />
		</form>

		<h3>
			<a href="/NewEditedProject/add-user.doo"> <input type="submit"
				value="Sign Up" class="btn btn-success">
		</h3>
		</form>
	</div>

	<%@include file="../common/footer.jspf"%>
