package com.nucleus.connection;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connectionclass {
	Connection con =null;
	
	public Connection getDBConnection() 
	{
		try {
			
			
			/*FileReader filereader = new FileReader("db.properties");                     
			Properties properties = new Properties();                                    
			properties.load(filereader);                                                 
			Class.forName(properties.getProperty("drivername"));                        
			con = DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("username"),properties.getProperty("password"));*/
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@10.1.50.198:1521:orcl","sh","sh");
			
			
			} 
		    /*catch (FileNotFoundException e1) {
			
			e1.printStackTrace();
		    }
		    catch (IOException e) {
			
				e.printStackTrace();
			}*/
			catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
			catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		return con;
		
	}
	
	
	public void closeDBConnection()
	{
		if(con!=null)
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
