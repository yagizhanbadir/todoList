package com.yagizhanbadir.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yagizhanbadir.services.UserService;

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UserService userService = new UserService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response); // JSP-Servlet
																							// baðlantýsý
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String password = request.getParameter("password");

		boolean isUserValid = userService.isUserValid(name, password);
		if (isUserValid) {

			request.getSession().setAttribute("name", name);
			request.getSession().setAttribute("userUuid", userService.getUserId(name));
			response.sendRedirect("/NewEditedProject/list-todos.do");

		} else {
			String message = "Invalid Credentials";
			request.setAttribute("errorMessage", message);
			request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
		}
	}
}