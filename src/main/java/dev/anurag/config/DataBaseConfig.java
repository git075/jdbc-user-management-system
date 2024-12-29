package dev.anurag.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConfig {
public static Connection connection = null;
	
	public static Connection getConnection() {
		String dbUrl = "jdbc:mysql://localhost:3306/studyeasy?useSSL=false";
		String user = "root";
		String pass = "#Strong@01";
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");  //one application can be connected to the multiple databases. Make differnt files for Myconnection
            connection = DriverManager.getConnection(dbUrl, user, pass);//If you are connecting to the remote db then use the url of remote db inplace of localhost
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
	}
	
	

}
