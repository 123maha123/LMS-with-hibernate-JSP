package com.lms.util;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection 
{
	//Provides connection to the database
	public static Connection getConnection() throws SQLException
	{
		Connection con=null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		    con=DriverManager.getConnection("jdbc:oracle:thin:@172.25.192.71:1521:javadb","HJA15ORAUSER4D","tcshyd") ;
		    
		    
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
	
	//closes connection to the dataabase
	public static void CloseConnection(Connection con)
	{
		if(con!=null)
		{
			try{
				con.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}

}

