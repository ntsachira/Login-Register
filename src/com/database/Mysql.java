
package com.database;

import java.sql.*;

public class Mysql {
    
    private static Connection connection;
   
    private static String DATABASE = "db1";
    private static String USERNAME = "root";
    private static String PASSWORD = "ntsachira";
    
    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+DATABASE, USERNAME, PASSWORD);            
        } catch (Exception e) {
            //handle exceptions
        }
        
    }
    
    public static ResultSet execute(String query) throws SQLException{
        Statement statement = connection.createStatement();
        
        if(query.startsWith("SELECT")){
            //search query
            ResultSet resultset = statement.executeQuery(query);
            return resultset;
        }else{
            //insert,update,delete
            statement.executeUpdate(query);
        }
        return null;
    }
   
}
