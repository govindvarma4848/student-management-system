package com.myapp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteStudent")
public class DeleteStudent extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        Connection con = null;
        PreparedStatement pst = null;

        try {

            int id = Integer.parseInt(request.getParameter("id"));

            con = DBConnection.getConnection();

            pst = con.prepareStatement(
                    "DELETE FROM students WHERE id=?");

            pst.setInt(1, id);

            int rows = pst.executeUpdate();

            response.setContentType("text/html");

            if (rows > 0) {

                response.getWriter().println(
                        "<h2>Student Deleted Successfully!</h2>");

                response.getWriter().println(
                        "<a href='students.jsp'>View Student Details</a>");

            } else {

                response.getWriter().println(
                        "<h2>Student ID Not Found!</h2>");

                response.getWriter().println(
                        "<a href='deletestudent.jsp'>Try Again</a>");
            }

        } catch (Exception e) {

            response.setContentType("text/html");
            response.getWriter().println(
                    "<h2>Error: " + e.getMessage() + "</h2>");

            e.printStackTrace();

        } finally {

            try {
                if (pst != null)
                    pst.close();
            } catch (Exception e) {
            }

            // Don't close the connection.
            // DBConnection manages it.
        }
    }
}