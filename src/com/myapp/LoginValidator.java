package com.myapp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginValidator extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String userName = request.getParameter("username");
            String password = request.getParameter("password");

            DBConnection db = new DBConnection();
            Connection con = db.getConnection();

            PreparedStatement pst = con.prepareStatement(
            	    "select * from users where username=? and password=?");
            pst.setString(1, userName);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

            	RequestDispatcher rd =
            	        request.getRequestDispatcher("home.jsp");
                rd.forward(request, response);

            } else {

                response.getWriter().println(
                        "<h1 align='center'>Invalid Username Or Password</h1>");
                response.getWriter().println(
                        "<a href='Login.jsp'>Login Again</a>");
            }

            rs.close();
            pst.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}