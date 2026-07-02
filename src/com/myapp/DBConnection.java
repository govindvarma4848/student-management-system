package com.myapp;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static Connection con;

    public static Connection getConnection() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                "jdbc:mysql://hayabusa.proxy.rlwy.net:34489/railway",
                "root",
                "zlJqmywveDZqsuDTZVTQGVyVbLpIYdJz"
            );

        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}