package com.myapp;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static Connection con = null;

    public static Connection getConnection() {

        try {

            if (con == null || con.isClosed()) {

                Class.forName("com.mysql.cj.jdbc.Driver");

                con = DriverManager.getConnection(
                        "jdbc:mysql://hayabusa.proxy.rlwy.net:34489/railway",
                        "root",
                        "zlJqmywveDZqsuDTZVTQGVyVbLpIYdJz"
                );

                System.out.println("Connected to Railway MySQL successfully!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}