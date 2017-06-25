package com.ascent.util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthorityFilter implements Filter {

	public void destroy() {
		
	}

	// notice the difference between these parameters and the parameters of doGet and doPost in Servlet
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;  // do this in order to get session
		HttpServletResponse response = (HttpServletResponse) resp;
		
		HttpSession session = request.getSession();
		
		String superuser = (String) session.getAttribute("superuser");
		
		if (superuser == null) { // if user has logged out or has not logged in
			response.sendRedirect(request.getContextPath() + "/login.html");
		} else {
			if (superuser.equals("3")) {
				chain.doFilter(req, resp);
			} else {
				response.sendRedirect(request.getContextPath() + "/authError.html");
			}
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
	
	}

}
