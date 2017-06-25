<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*, com.ascent.bean.Usr, java.sql.*, com.ascent.util.DataAccess" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>My JSP 'registerHandler.jsp' starting page</title>
</head>
<body>
	<jsp:useBean id="user" class="com.ascent.bean.Usr" scope="session" />
	<jsp:setProperty property="*" name="user" />  <%-- assign parameters in register.jsp form to the user object created by the above line --%>
	<%
		boolean flag = false; // represents if the user register successfully
		Connection con =null;
		PreparedStatement ps = null;
		try {
			con = DataAccess.getConnection();
			con.setAutoCommit(false);
			String sql = "insert into usr (username, password, fullname, title, superuser) values (?, ?, ?, ?, 1)";
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFullname());
			ps.setString(4, user.getTitle());
			ps.executeUpdate();
			con.commit();
			flag = true;
			ps.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
		if (flag) {
			out.println("Register successfully. The info of the user has been saved into session. The info displayed below is from internal session object.<br>");
			Usr p = (Usr) session.getAttribute("user");
			out.println("User name: " + p.getUsername() + " Title: " + p.getTitle());
		} else {
			out.println("Register unsuccessfully.");
		}
	%>
</body>
</html>