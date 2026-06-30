package com.myapp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.annotation.WebServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteStudent")
public class DeleteStudent extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        try {

            int id = Integer.parseInt(request.getParameter("id"));

            Connection con = DBConnection.getConnection();

            PreparedStatement pst =
                    con.prepareStatement(
                    "delete from students where id=?");

            pst.setInt(1, id);

            int i = pst.executeUpdate();

            if(i > 0) {

                response.getWriter().println(
                    "<h1>Student Deleted Successfully</h1>");

                response.getWriter().println(
                    "<a href='students.jsp'>View Students</a>");

            } else {

                response.getWriter().println(
                    "<h1>Student ID Not Found</h1>");
            }

            pst.close();
            con.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}