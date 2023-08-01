package com.savemysaving.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDb {
    String url = "jdbc:postgresql://localhost/savemysaving";
    String username = "postgres";
    String password = "hjhxn78++";

    public Connection startConnect() {

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Successfully Connected");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
       return connection;
    }

}
