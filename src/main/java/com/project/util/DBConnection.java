package com.project.util;

import java.sql.*;

public class DBConnection {

    public static Connection getConnection() {
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://" 
                       + System.getenv("MYSQLHOST") + ":" 
                       + System.getenv("MYSQLPORT") + "/" 
                       + System.getenv("MYSQLDATABASE")
                       + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

            String user = System.getenv("MYSQLUSER");
            String pass = System.getenv("MYSQLPASSWORD");

            con = DriverManager.getConnection(url, user, pass);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}
