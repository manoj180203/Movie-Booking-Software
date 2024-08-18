package com.Movie.BookingAPP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Theaters 
{
	private static String TheaterName;
	private static String Location;
	private static int SeatingCapacity;
	
	public Theaters(String TheaterName,String Location,int SeatingCapacity)
	{
		Theaters.TheaterName=TheaterName;
		Theaters.Location=Location;
		Theaters.SeatingCapacity=SeatingCapacity;
	}
	
	static Scanner in=new Scanner(System.in);
	
	public static void inserttheaters()
	{
		String query="INSERT INTO THEATER(TheaterName,LOCATION,SeatingCapacity) VALUES(?,?,?)";
		Connection con=Connector.requestConnection();
		try
		{
			int res=0;
			PreparedStatement ps=con.prepareStatement(query);
			System.out.println("Enter Theater Name");
			TheaterName=in.nextLine();
			System.out.println("Enter Location");
			Location=in.nextLine();
			System.out.println("Enter Seating Capacity");
			SeatingCapacity=in.nextInt();
			
			ps.setString(1, TheaterName);
			ps.setString(2, Location);
			ps.setInt(3, SeatingCapacity);
			
			res = ps.executeUpdate();
			if(res > 0)
			{
				System.out.println("Theater added Sucessfully");
			}
			else
			{
				System.out.println("Theater was not added");
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void showtheaters() 
	{
		Statement st=null;
		String query="SELECT * FROM THEATER";
		Connection con = Connector.requestConnection();
		try
		{
			st=con.createStatement();
			ResultSet rs= st.executeQuery(query);
			while(rs.next())
				{
					System.out.println();
					System.out.println("Theater ID: "+rs.getInt(1));
					System.out.println("Theater Name: "+rs.getString(2));
					System.out.println("Location: "+rs.getString(3));
					System.out.println("Seating Capacity: "+rs.getInt(4));
					System.out.println("----------------------------------------");
				}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	} 
}
