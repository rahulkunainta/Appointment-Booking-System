package com.project.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            
            con = DriverManager.getConnection("jdbc:mysql://mysql.railway.internal:3306/railway","root" , iFSnpKgquoInHmazfylAwwUxqEWJptoI);

            

        } catch (Exception e) {
            System.out.println("❌ DB Connection Failed");
            e.printStackTrace();
        }

        return con;
    }
}
