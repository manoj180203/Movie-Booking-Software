package com.Movie.BookingAPP;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connector 
{
	static String url="jdbc:mysql://localhost:3306/bookingapp";
	static String user ="root";
	static String password = "pentagon";
	static Connection con=null;
	public static Connection requestConnection()
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con= DriverManager.getConnection(url,user,password);
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		return con;
	}
}
