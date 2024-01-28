<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order</title>
</head>
<body>
	<h1>Online TShirt Order</h1>
	<form action="Server.jsp">
		<label>Choose accessories </label>
		<label><input type = 'checkbox' name = "accessories" value='cap'>Cap</label>
		<label><input type = 'checkbox' name = "accessories" value='belt'>Belt</label>
		<label><input type = 'checkbox' name = "accessories" value='hairband'>Hair Band</label>
		<br><br>
		
		<label>TagLine</label>
		<input name="tagline" type = "text"> <br><br>
		
		<label>Pocket</label>
		<label><input type='radio' name='pocket' value="yes">Yes</label>
		<label><input type='radio' name='pocket' value="no">No</label>
		
		<br><br>
		
		<label>Choose color</label>
		<select name="color">
		<option value='red'>Red</option>
		<option value='blue'>Blue</option>
		<option value='white'>White</option>
		</select>
		
		<br><br>
		<input type="submit" value="click me">
	</form>

</body>
</html>