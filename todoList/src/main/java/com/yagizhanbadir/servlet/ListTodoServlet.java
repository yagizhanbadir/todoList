package com.yagizhanbadir.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yagizhanbadir.services.TodoService;

@WebServlet(urlPatterns = "/list-todos.do")
public class ListTodoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TodoService todoService = new TodoService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("todos",
				todoService.retrieveTodos((String) request.getSession().getAttribute("userUuid")));

		request.getRequestDispatcher("WEB-INF/views/list-todos.jsp").forward(request, response);

	}
	/*
	 * @Override protected void doPost(HttpServletRequest request,
	 * HttpServletResponse response) throws ServletException, IOException {
	 * 
	 * String newTodo = request.getParameter("todo"); todoService.addTodo(new
	 * Todo(newTodo)); response.sendRedirect("/list-todos.do");
	 * 
	 * }
	 */
}
