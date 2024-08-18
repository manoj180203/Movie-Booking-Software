package com.Movie.BookingAPP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Movie 
{
	static Scanner in= new Scanner(System.in);
	private static String title;
	private static String genere;
	private static String rating;
	private static String duration;

	

	public Movie(String title, String genere, String rating, String duration) 
	{
		Movie.title = title;
		Movie.genere = genere;
		Movie.rating = rating;
		Movie.duration = duration;

	}
	
	public static void insertMovie()
	{	
		String query="INSERT INTO MOVIES(TITLE,GENERE,RATING,DURATION) VALUES(?,?,?,?)";
		
		Connection con=Connector.requestConnection();
		try
		{
			int res=0;
			PreparedStatement ps=con.prepareStatement(query);
			System.out.println("Enter Title");
			title=in.nextLine();
			System.out.println("Enter Genere");
			genere=in.next();
			System.out.println("Enter Rating");
			rating=in.next();
			System.out.println("Enter Duration");
			duration=in.next();
			
			ps.setString(1, title);
			ps.setString(2, genere);
			ps.setString(3, rating);
			ps.setString(4, duration);
			res = ps.executeUpdate();
			if(res > 0)
			{
				System.out.println("Movie inserted Sucessfully");
			}
			else
			{
				System.out.println("Movie was not Inserted");
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void showmovies() 
	{
		Statement st=null;
		String query="SELECT * FROM MOVIES";
		Connection con = Connector.requestConnection();
		try
		{
			st=con.createStatement();
			ResultSet rs= st.executeQuery(query);
			while(rs.next())
				{
					System.out.println();
					System.out.println("Movie ID: "+rs.getInt(1));
					System.out.println("Title: "+rs.getString(2));
					System.out.println("Genere: "+rs.getString(3));
					System.out.println("Rating: "+rs.getString(4));
					System.out.println("Duration (in min) : "+rs.getString(5));
					System.out.println("----------------------------------------");
				}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	} 
}

