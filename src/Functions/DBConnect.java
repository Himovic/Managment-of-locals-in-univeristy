/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author lenovo
 */
public class DBConnect {
    public static Connection connection = null;
    public static String URL = "jdbc:postgresql://localhost:5432/gestionlocaux";
    public static String HOSTNAME = "postgres";
    public static String PASSWORD = "androps";
    public static Connection ConnectDB() throws SQLException, ClassNotFoundException{
    Class.forName("org.postgresql.Driver");   
    //DriverManager.registerDriver(new org.postgresql.Driver());
    connection = DriverManager.getConnection(URL,HOSTNAME,PASSWORD);
    //connection.setAutoCommit(false);
        
        return connection;
    }
   
}
