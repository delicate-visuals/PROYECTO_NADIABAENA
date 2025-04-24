package com.trueconnect.trueconnectrecom.BBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class BBDDConnector {
    private static BBDDConnector instance = null;
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/trueconnect_bbdd?autoReconnect=true&useSSL=false";
    private Connection connection;


    public BBDDConnector(){
        Properties prop = new Properties();
        prop.put("user", "root");
        prop.put("password", "Admin123");

        try {
            /*Class.forName("com.mysql.cj.jdbc.Driver");*/
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL, prop);

            System.out.println("Conexion exitosa");
        }catch (SQLException e){
            System.out.println("Fallo de conexion");
            System.out.println(e.getStackTrace());
        } /*catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }*/ catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static BBDDConnector GetInstance(){
        if(instance == null){
            instance = new BBDDConnector();

            System.out.println("Instancia creada");
            System.out.println(instance.connection != null);
        }

        return instance;
    }

    public Connection GetConnection(){
        return this.connection;
    }
}
