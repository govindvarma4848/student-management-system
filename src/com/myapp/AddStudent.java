package com.myapp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        Connection con = null;
        PreparedStatement pst = null;

        try {

            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String gmail = request.getParameter("gmail");
            String branch = request.getParameter("branch");

            con = DBConnection.getConnection();

            pst = con.prepareStatement(
                    "INSERT INTO students (id, name, gmail, branch) VALUES (?, ?, ?, ?)");

            pst.setInt(1, id);
            pst.setString(2, name);
            pst.setString(3, gmail);
            pst.setString(4, branch);

            int rows = pst.executeUpdate();

            response.setContentType("text/html");

            if (rows > 0) {

                response.getWriter().println("<h2>Student Added Successfully!</h2>");
                response.getWriter().println("<a href='students.jsp'>View Student Details</a>");

            } else {

                response.getWriter().println("<h2>Student Not Added!</h2>");
                response.getWriter().println("<a href='addstudent.jsp'>Try Again</a>");
            }

        } catch (Exception e) {

            response.setContentType("text/html");
            response.getWriter().println("<h2>Error: " + e.getMessage() + "</h2>");
            e.printStackTrace();

        } finally {

            try {
                if (pst != null)
                    pst.close();
            } catch (Exception e) {
            }

            // Don't close the connection here.
            // DBConnection manages it.
        }
    }
}