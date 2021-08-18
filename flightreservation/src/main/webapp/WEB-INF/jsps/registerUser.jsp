<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register user</title>
</head>

<body>

<form action="registerUser" method="post">
<center>
<h3>--Registration--</h3>
<pre>

First Name:<input type="text" name="firstName"/>  <!-- name="fistName" is map with entites or model class in firstName object  -->
Last Name:<input type="text" name="lastName"/>   <!-- name="lastName" is map with model class in lastName -->
User Name:<input type="text" name="email"/>
Password:<input type="text" name="password"/>
Confirm Password:<input type="text" name="confirmPassword"/>


<input type="submit" value="register"/>
</pre>
</center>
</form>
</body>
</html>