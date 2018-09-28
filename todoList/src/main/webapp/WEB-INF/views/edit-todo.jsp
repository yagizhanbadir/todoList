<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>


<div class="container">
	Your Edited Action Item:
	<form method="post" action="/NewEditedProject/edit-todo.do">
		<fieldset class="form-group">
			<label>Description:</label> <input name="todo" type="text" autofocus="autofocus"
				class="form-control" value="${todoName}" /> <BR />
		</fieldset>
		<fieldset class="form-group">
			<label>Category:</label> <input name="category" type="text"
				class="form-control" value="${todoCategory}" /> <BR />
		</fieldset>

		<input type="hidden" name="uuid" value="${uuid}" /> <input name="Edited"
			type="submit" class="btn btn-success" value="Edited" />
	</form>
</div>
<%@include file="../common/footer.jspf"%>

<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>

</html>