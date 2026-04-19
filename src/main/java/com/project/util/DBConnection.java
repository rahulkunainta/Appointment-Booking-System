package com.project.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Read environment variables (Render / Railway)
            String host = System.getenv("mysql.railway.internal");
            String port = System.getenv("3306");
            String db   = System.getenv("railway");
            String user = System.getenv("root");
            String pass = System.getenv("iFSnpKgquoInHmazfylAwwUxqEWJptoI");

            // Debug (remove later)
            System.out.println("HOST=" + host);
            System.out.println("PORT=" + port);
            System.out.println("DB=" + db);
            System.out.println("USER=" + user);

            // Fallback for LOCAL testing only
            if (host == null || host.isEmpty()) {
                host = "localhost";
                port = "3306";
                db   = "doctor_db";
                user = "root";
                pass = "";
                System.out.println("⚠️ Using LOCAL database");
            }

            // JDBC URL
            String url = "jdbc:mysql://" + host + ":" + port + "/" + db
                    + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

            // Connect
            con = DriverManager.getConnection(url, user, pass);

            System.out.println("✅ Database Connected Successfully");

        } catch (Exception e) {
            System.out.println("❌ Database Connection Failed");
            e.printStackTrace();
        }

        return con;
    }
}
