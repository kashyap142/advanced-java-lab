<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import = "java.io.*" %>
 <%@page import = "java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order</title>
</head>
<body>
	<%
	String accessories = request.getParameter("accessories");
	String tagline = request.getParameter("tagline");
	String pocket = request.getParameter("pocket");
	String color = request.getParameter("color");
	
	PrintWriter pw = response.getWriter();
	String db = "jdbc:mysql://localhost:3306/pgm14";
	Connection conn = DriverManager.getConnection(db, "root", "root");
	
	PreparedStatement query = conn.prepareStatement("insert into orders" + 
			  "(accessories, tagline, pocket, color) values(?,?,?,?)");
	
	query.setString(1, accessories);
	query.setString(2, tagline);
	query.setString(3, pocket);
	query.setString(4, color);
	
	query.execute();
	
	PreparedStatement fetch = conn.prepareStatement("select * from orders");
	
	ResultSet rs = fetch.executeQuery();
	
	pw.println("<table>");
	pw.println("<tr><th>Order id</th> <th>Accessories</th> <th>Tagline</th> <th>Pocket</th> <th>Color</th> </tr>");
	
	while(rs.next()) {
		int id = Integer.parseInt(rs.getString(1));
		String a = rs.getString(2);
		String t = rs.getString(3);
		String p = rs.getString(4);
		String c = rs.getString(5);
		
		pw.println("<tr><td>" +id + "</td><td>" + a + "</td><td>" + t + "</td><td>" + p + 
				"</td><td>" + c + "</td></tr>");
		
	}
	%>
</body>
</html>
<!-- 
create database pgm14;
use pgm14;
CREATE TABLE orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    accessories VARCHAR(10),
    tagline varchar(200),
    pocket varchar(20),
    color varchar(20)
) AUTO_INCREMENT = 100;

-->
