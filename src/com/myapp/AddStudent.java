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

        try {

            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String gmail = request.getParameter("gmail");
            String branch = request.getParameter("branch");

            Connection con = DBConnection.getConnection();

            PreparedStatement pst = con.prepareStatement(
                    "insert into students values(?,?,?,?)");

            pst.setInt(1, id);
            pst.setString(2, name);
            pst.setString(3, gmail);
            pst.setString(4, branch);

            int i = pst.executeUpdate();

            if (i > 0) {

                response.setContentType("text/html");

                response.getWriter().println(
                        "<h1>Student Added Successfully</h1>");
                response.getWriter().println(
                        "<a href='students.jsp'>View Students</a>");

            } else {

                response.getWriter().println(
                        "<h1>Student Not Added</h1>");
            }

            pst.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}