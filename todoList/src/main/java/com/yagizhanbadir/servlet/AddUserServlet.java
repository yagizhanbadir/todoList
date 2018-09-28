package com.yagizhanbadir.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.yagizhanbadir.services.UserService;

@WebServlet(urlPatterns = "/add-user.doo")
public class AddUserServlet extends HttpServlet {

	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UserService userService = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		request.getRequestDispatcher("WEB-INF/views/add-user.jsp").forward(request, response);
	 
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		
		//System.out.println("**********: " + IOUtils.toString(request.getReader()));

		userService.addUser(username,password);
		
		response.sendRedirect("/NewEditedProject/login.do");		
	}
}
