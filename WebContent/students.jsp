<%@ page import="java.sql.*" %>

<html>
<head>
<title>Student Details</title>
</head>
<body>

<h2>Student Details</h2>

<table border="1">
<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Gmail</th>
    <th>Branch</th>
</tr>

<%
try{
    Class.forName("com.mysql.cj.jdbc.Driver");

    Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/studentdb",
        "root",
        "manager"
    );

    Statement st = con.createStatement();

    ResultSet rs = st.executeQuery("select * from students");

    while(rs.next()){
%>

<tr>
    <td><%= rs.getInt(1) %></td>
    <td><%= rs.getString(2) %></td>
    <td><%= rs.getString(3) %></td>
    <td><%= rs.getString(4) %></td>
</tr>

<%
    }

    con.close();

}catch(Exception e){
    out.println(e);
}
%>

</table>

</body>
</html>