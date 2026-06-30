<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOGIN PAGE</title>
</head>

<body bgcolor="cyan" text="red">

<h1 align="center">LOGIN Form</h1>

<hr size="10" width="80%" color="green">

<form action="LoginValidator" method="post">

<table align="center" bgcolor="yellow">

<tr>
    <td>Enter Username:</td>
    <td><input type="text" name="username"></td>
</tr>

<tr>
    <td>Enter Password:</td>
    <td><input type="password" name="password"></td>
</tr>

<tr>
    <td><input type="submit" value="Login"></td>
    <td><input type="reset" value="Reset"></td>
</tr>

</table>

</form>

</body>
</html>