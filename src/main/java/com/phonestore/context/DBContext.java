package com.phonestore.context;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBContext {

    public Connection getConnection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/product?allowPublicKeyRetrieval=true&useSSL=false";
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(url, userID, password);
    }

    private final String userID = "root";
    private final String password = "admin";
}
