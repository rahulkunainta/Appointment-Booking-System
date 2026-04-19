package com.project.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String host = System.getenv("MYSQLHOST");
            String port = System.getenv("MYSQLPORT");
            String db   = System.getenv("MYSQLDATABASE");
            String user = System.getenv("MYSQLUSER");
            String pass = System.getenv("MYSQLPASSWORD");

            // fallback for LOCAL testing only
            if (host == null || host.isEmpty()) {
                host = "mysql.railway.internal";
                port = "3306";
                db   = "railway";
                user = "root";
                pass = "iFSnpKgquoInHmazfylAwwUxqEWJptoI";
            }

            String url = "jdbc:mysql://" + host + ":" + port + "/" + db +
                    "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

            con = DriverManager.getConnection(url, user, pass);

            System.out.println("✅ Database Connected");

        } catch (Exception e) {
            System.out.println("❌ DB Connection Failed");
            e.printStackTrace();
        }

        return con;
    }
}
