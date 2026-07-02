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

        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {

            String userName = request.getParameter("username");
            String password = request.getParameter("password");

            con = DBConnection.getConnection();

            pst = con.prepareStatement(
                    "SELECT * FROM users WHERE username=? AND password=?");

            pst.setString(1, userName);
            pst.setString(2, password);

            rs = pst.executeQuery();

            if (rs.next()) {

                RequestDispatcher rd =
                        request.getRequestDispatcher("home.jsp");
                rd.forward(request, response);

            } else {

                response.setContentType("text/html");

                response.getWriter().println(
                        "<h2 align='center'>Invalid Username or Password</h2>");
                response.getWriter().println(
                        "<center><a href='Login.jsp'>Login Again</a></center>");
            }

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            try {
                if (rs != null)
                    rs.close();
            } catch (Exception e) {
            }

            try {
                if (pst != null)
                    pst.close();
            } catch (Exception e) {
            }

            // Do NOT close the connection here because DBConnection
            // reuses it across the application.
        }
    }
}