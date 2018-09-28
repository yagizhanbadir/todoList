<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>



<div class="container">
	<H1>Welcome ${name}</H1>

	<table class="table table-striped">
		<caption>Your Todos are</caption>
		<thead>
			<th>Description</th>
			<th>Category</th>
			<th>Actions</th>
		</thead>
		<tbody>
			<c:forEach items="${todos }" var="todo">
				<tr>
					<td>${todo.name }</td>
					<td>${todo.category }</td>

					<td><form action="/NewEditedProject/delete-todo.do" method="post">

							<input type="hidden" name="uuid" value="${todo.uuid}" /> <input
								type="submit" value="Delete" class="btn btn-danger" />
						</form></td>

					<td>&nbsp;&nbsp;<a class="btn btn-primary"
						href="/NewEditedProject/edit-todo.do?uuid=${todo.uuid}">Update</a></td>

				</tr>
			</c:forEach>

		</tbody>
	</table>


	<p>
		<font color="red"> ${errorMessage }</font>
	</p>
	<a class="btn btn-success" href="/NewEditedProject/add-todo.do">Add New Todo</a>

</div>

<p>&nbsp;</p>

<%@include file="../common/footer.jspf"%>
