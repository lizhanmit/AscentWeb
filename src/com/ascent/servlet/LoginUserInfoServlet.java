package com.ascent.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginUserInfoServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		int uid = 0;
		String result = "";
		
		if (username == null) { // if user has logged out or has not logged in
			result = "You have not logged in or have already logged out.";
			
		} else {
			uid = ((Integer) session.getAttribute("uid")).intValue();
			result = "Your info: ID: " + uid + ", User name: " + username + " <a href='logoutServlet'>Log out</a>";
		}
		
		response.setContentType("text/html"); // write this before PrintWriter out = response.getWriter()
		PrintWriter out = response.getWriter();
		
		out.println("<!doctype html public \"-//w3c//dtd html 4.01 transitional//en\">");
		out.println("<html>");
		out.println("<head><title>A Servlet</title></head>");
		out.println("<body>");
		out.println(result);
		out.println("</body>");
		out.println("</html>");
		
		out.flush();
		out.close();		
	}

}
