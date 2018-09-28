package com.yagizhanbadir.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yagizhanbadir.model.Todo;
import com.yagizhanbadir.services.TodoService;

@WebServlet(urlPatterns = "/edit-todo.do")
public class EditTodoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TodoService todoService = new TodoService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uuid = request.getParameter("uuid");

		if (uuid == null) {
			request.getRequestDispatcher("WEB-INF/views/edit-todo.jsp").forward(request, response);
		} else {
			Todo todo = todoService.getTodoWithId(uuid);
			if (todo != null) {
				String todoName = todo.getName();
				String todoCategory = todo.getCategory();
				request.setAttribute("uuid", uuid);
				request.setAttribute("todoName", todoName);
				request.setAttribute("todoCategory", todoCategory);

			}
			request.getRequestDispatcher("WEB-INF/views/edit-todo.jsp").forward(request, response);
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uuid = request.getParameter("uuid");
		String todo = request.getParameter("todo");
		String category = request.getParameter("category");

		if (!todo.trim().equals("") & !category.trim().equals("")) {
			todoService.updateTodo(uuid, todo, category);

		}

		response.sendRedirect("/NewEditedProject/list-todos.do");

	}

}
