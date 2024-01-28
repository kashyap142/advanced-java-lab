<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.io.*" %>
<%@ page import = "java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	String dateOfAdm = request.getParameter("date");
	String doctor = request.getParameter("doctor");
	String cause = request.getParameter("cause");
	String treatment = request.getParameter("treatment");
	
	String db = "jdbc:mysql://localhost:3306/pgm13";
	String dbUser = "root";
	String dbPwd = "root";
	
	Connection conn = DriverManager.getConnection(db, dbUser, dbPwd);
	PreparedStatement query = conn.prepareStatement("insert into patient values(?,?,?,?,?,?,?)");
	
	query.setString(1, id);
	query.setString(2, name);
	query.setString(3, age);
	query.setString(4, dateOfAdm);
	query.setString(5, doctor);
	query.setString(6, cause);
	query.setString(7, treatment);
	
	query.executeUpdate();
	
	PrintWriter pw = response.getWriter();
	// pw.println(id + name + age + dateOfAdm + doctor + cause + treatment);
	
	PreparedStatement fetch = conn.prepareStatement("select * from patient");
	
	String res = "";
	ResultSet rs = fetch.executeQuery();
	while(rs.next()) {
		res += rs.getString(1) + "<br>";
	}
	pw.println(res);
	pw.close();
	%>
</body>
</html>