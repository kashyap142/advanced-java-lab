<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import = "java.sql.*" %>
<%@page import = "java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String fname = request.getParameter("fname");
	String lname = request.getParameter("lname");
	String age = request.getParameter("age");
	String city = request.getParameter("city");
	String email = request.getParameter("email");
	
	String db = "jdbc:mysql://localhost:3306/pgm12";
	String dbUser = "root";
	String dbPwd = "root";
	
	Connection conn = DriverManager.getConnection(db, dbUser, dbPwd);
	
	PreparedStatement query = conn.prepareStatement("insert into details values(?,?,?,?,?);");
	
	query.setString(1, fname);
	query.setString(2, lname);
	query.setString(3, age);
	query.setString(4, city);
	query.setString(5, email);
	
	query.executeUpdate();
	
	PrintWriter pw = response.getWriter();
	
	pw.println("added");
	
	%>
</body>
</html>