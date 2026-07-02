<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Student</title>
</head>

<body>

<center>

<h2>Add Student</h2>

<form action="AddStudent" method="post">

<table>

<tr>
<td>ID</td>
<td><input type="number" name="id" required></td>
</tr>

<tr>
<td>Name</td>
<td><input type="text" name="name" required></td>
</tr>

<tr>
<td>Gmail</td>
<td><input type="email" name="gmail" required></td>
</tr>

<tr>
<td>Branch</td>
<td><input type="text" name="branch" required></td>
</tr>

<tr>
<td colspan="2" align="center">
<input type="submit" value="Add Student">
</td>
</tr>

</table>

</form>

<br>

<a href="home.jsp">Home</a>

</center>

</body>
</html>