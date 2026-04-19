package com.project.util;

import java.sql.*;

public class DBConnection {

	private static final String URL =
"jdbc:mysql://nozomi.proxy.rlwy.net:51710/railway?useSSL=true&requireSSL=true&verifyServerCertificate=false";
    private static final String USER = "root";
    private static final String PASSWORD = "iFSnpKgquoInHmazfylAwwUxqEWJptoI";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
                throw new RuntimeException("DB CONNECTION FAILED", e);
}
    }
}
