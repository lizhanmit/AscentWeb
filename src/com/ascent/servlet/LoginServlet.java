package com.ascent.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ascent.util.DataAccess;

public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/**
		 * 1. get request parameters from form
		 */
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		/**
		 * 2. use JDBC to process request 
		 */
		boolean flag = false; // flag represents if log in successfully, false means unsuccessfully
		int uid = 0; 
		String superuser = "";
		
		Connection con = null; 
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DataAccess.getConnection();
			ps = con.prepareStatement("select * from usr where username = ? and password = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next()) {
				flag = true; // log in successfully
				uid = rs.getInt("id");
				superuser = rs.getString("superuser");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				} 
				if (ps != null) {
					ps.close();
				} 
				if (con != null) {
					con.close();
				} 
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		/**
		 * 3. response based on the result of flag in 2.
		 * save data and do redirection
		 */
		response.setContentType("text/html"); // write this before PrintWriter out = response.getWriter()
		PrintWriter out = response.getWriter();
		
		out.println("<!doctype html public \"-//w3c//dtd html 4.01 transitional//en\">");
		out.println("<html>");
		out.println("<head><title>A Servlet</title></head>");
		out.println("<body>");
		
		if (flag) { // if log in successfully
			HttpSession session = request.getSession();
			session.setAttribute("uid", new Integer(uid));
			session.setAttribute("username", username);
			session.setAttribute("superuser", superuser);
			
			if ("1".equals(superuser)) {
				out.println("Log in successfully. You are an ordinary user. Your info has been saved in session. Please open userInfo.html to check it out. ");
			} else if ("2".equals(superuser)) {
				out.println("Log in successfully. You are a manager user. Your info has been saved in session. Please open userInfo.html to check it out. ");
			} else {
				out.println("Log in successfully. You are a admin user. Your info has been saved in session. Please open userInfo.html to check it out. ");
			}
		} else {
			out.println("The username or password is incorrect. Log in unsuccessfully.");
		}
		out.println("<a href='userInfo.html'>Go to userInfo.html</a>");
		out.println("</body>");
		out.println("</html>");
		
		out.flush();
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
