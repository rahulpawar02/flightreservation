<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
    <%@page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
        rel="stylesheet">
</head>
<body>
<form action="login" method="POST">
<center>
<div class="container container-small">
<form action="saveloc" method="post">
<pre>
<div class="form-group">
<h2>Login</h2>
User Name:<input type="text" name="email"/><br>
Password:<input type="text" name="password"/><br>
<input type="submit" value="login"/><br>
${msg}



<div></div>
</center>
</form>
</body>
</html>