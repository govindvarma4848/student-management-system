<%@ page import="java.sql.*" %>
<%@ page import="com.myapp.DBConnection" %>

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
Connection con = null;
Statement st = null;
ResultSet rs = null;

try {

    con = DBConnection.getConnection();

    st = con.createStatement();

    rs = st.executeQuery("SELECT * FROM students");

    while (rs.next()) {
%>

<tr>
    <td><%= rs.getInt("id") %></td>
    <td><%= rs.getString("name") %></td>
    <td><%= rs.getString("gmail") %></td>
    <td><%= rs.getString("branch") %></td>
</tr>

<%
    }

} catch (Exception e) {
%>

<tr>
    <td colspan="4" style="color:red;">
        <%= e.getMessage() %>
    </td>
</tr>

<%
} finally {

    try {
        if (rs != null)
            rs.close();
    } catch (Exception e) {
    }

    try {
        if (st != null)
            st.close();
    } catch (Exception e) {
    }

    // Do not close the connection.
    // DBConnection manages and reuses it.
}
%>

</table>

</body>
</html>