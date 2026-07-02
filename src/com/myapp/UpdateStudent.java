package com.myapp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateStudent")
public class UpdateStudent extends HttpServlet {

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
                    "UPDATE students SET name=?, gmail=?, branch=? WHERE id=?");

            pst.setString(1, name);
            pst.setString(2, gmail);
            pst.setString(3, branch);
            pst.setInt(4, id);

            int rows = pst.executeUpdate();

            response.setContentType("text/html");

            if (rows > 0) {

                response.getWriter().println("<html><body>");
                response.getWriter().println("<h2>Student Updated Successfully!</h2>");
                response.getWriter().println("<br>");
                response.getWriter().println("<a href='students.jsp'>View Student Details</a>");
                response.getWriter().println("</body></html>");

            } else {

                response.getWriter().println("<html><body>");
                response.getWriter().println("<h2>Student ID Not Found!</h2>");
                response.getWriter().println("<br>");
                response.getWriter().println("<a href='updatestudent.jsp'>Try Again</a>");
                response.getWriter().println("</body></html>");
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

            // Do NOT close the connection.
            // DBConnection manages and reuses it.
        }
    }
}