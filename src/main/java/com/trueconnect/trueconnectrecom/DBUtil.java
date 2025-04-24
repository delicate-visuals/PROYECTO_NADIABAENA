package com.trueconnect.trueconnectrecom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // registrar el driver
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver JDBC no encontrado", e);
        }

        String url = "jdbc:mysql://localhost:3306/trueconnect_bbdd";
        String user = "root";
        String password = "Admin123";
        return DriverManager.getConnection(url, user, password);
    }
}


