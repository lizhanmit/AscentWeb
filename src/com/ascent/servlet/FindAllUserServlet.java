package com.ascent.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ascent.bean.Usr;
import com.ascent.dao.UserManagerDAO;

public class FindAllUserServlet extends HttpServlet {
       
    public FindAllUserServlet() {
        super();
    }

    public void destroy() {
    	super.destroy();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); // write this before PrintWriter out = response.getWriter()
		PrintWriter out = response.getWriter();
		
		out.println("<!doctype html public \"-//w3c//dtd html 4.01 transitional//en\">");
		out.println("<html>");
		out.println("<head><title>A Servlet</title></head>");
		out.println("<body><center><table border=1>");
		out.println("<tr><td>NO</td><td>User Name</td><td>Title</td></tr>");
		
		UserManagerDAO dao = new UserManagerDAO();
		List<Usr> usrs = dao.getAllProductUser();
		for (Usr u : usrs) {
			out.println("<tr><td>" + u.getId() + "</td><td>" + u.getUsername() + "</td><td>" + u.getTitle() + "</td></tr>");
		}
		out.println("</table></center></body>");
		out.println("</html>");
		
		out.flush();
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
