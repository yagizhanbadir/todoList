package com.yagizhanbadir.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns= "*.do")
public class LoginRequiredFilter implements Filter{

	
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	

	
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
			

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		//System.out.println(request.getRequestURI());

		   Enumeration<String> names = request.getHeaderNames();
		    
		    while (names.hasMoreElements()) {
		        String name = (String) names.nextElement();
		        Enumeration<String> values = request.getHeaders(name);
		        if (values != null) {
		            while (values.hasMoreElements()) {
		              String value = (String) values.nextElement();
		              System.out.println(name + ": " + value);
		          
		            }
		          }   	    
		    }
		    System.out.println("**********************");	
		
		if (request.getSession().getAttribute("name") != null){
			chain.doFilter(servletRequest, servletResponse);
		}else{
			request.getRequestDispatcher("/login.do").forward(servletRequest, servletResponse);
		}
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
