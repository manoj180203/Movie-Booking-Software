package com.Movie.BookingAPP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Scanner;

public class ShowTimes 
{
	private static Timestamp showtime;
	
	public ShowTimes(Timestamp showtime) 
	{
		ShowTimes.showtime = showtime;
	}
	
	static Scanner in=new Scanner(System.in);
	
	public static void insertshowtime()
	{
		String query="INSERT INTO SHOWTIMES(Title,TheaterName,Showtime) VALUES(?,?,?)";
		Connection con=Connector.requestConnection();
		try
		{
			int res=0;
			PreparedStatement ps=con.prepareStatement(query);
			showmovie();
			System.out.println("Enter Movie ID");
			int movieid=in.nextInt();
			showtheater();
			System.out.println("Enter Theater ID");
			int theaterid=in.nextInt();
			System.out.println("Enter hour and min");
			int hour=in.nextInt();
			int min=in.nextInt();

			LocalDateTime ld= LocalDateTime.now().withHour(hour).withMinute(min).withSecond(0);
			showtime= Timestamp.from(ld.atZone(ZoneId.systemDefault()).toInstant());
			
			ps.setString(1, getmovie(movieid));
			ps.setString(2, gettheater(theaterid));
			ps.setTimestamp(3, showtime);
			
			res = ps.executeUpdate();
			if(res > 0)
			{
				System.out.println("Show is set Sucessfully");
			}
			else
			{
				System.out.println("Show was not added");
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void showtime() 
	{
		Statement st=null;
		String query="SELECT * FROM SHOWTIMES";
		Connection con = Connector.requestConnection();
		try
		{
			st=con.createStatement();
			ResultSet rs= st.executeQuery(query);
			while(rs.next())
				{
					System.out.println();
					System.out.println("Show ID: "+rs.getInt(1));
					System.out.println("Movie Name: "+rs.getString(2));
					System.out.println("Theater Name: "+rs.getString(3));
					System.out.println("Time (in date hrs:min:sec): "+rs.getTimestamp(4));
					System.out.println("----------------------------------------------------");
				}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public static String getmovie(int movieid)
	{
		Statement st=null;
		String query="SELECT * FROM MOVIES WHERE MOVIEID = "+movieid;
		Connection con = Connector.requestConnection();
		String Title = null;
		try
		{
			st=con.createStatement();
			ResultSet rs= st.executeQuery(query);
			rs.next();
			Title= rs.getString(2);
			System.out.println(Title);
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return Title;
	}
	
	public static String gettheater(int theaterid)
	{
		Statement st=null;
		String query="SELECT * FROM THEATER WHERE THEATERID = "+theaterid;
		Connection con = Connector.requestConnection();
		String Theatername = null;
		try
		{
			st=con.createStatement();
			ResultSet rs= st.executeQuery(query);
			rs.next();
			Theatername= rs.getString(2);
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return Theatername;
	}
	
	public static void showmovie()
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
					System.out.print("Movie ID: "+rs.getInt(1));
					System.out.print("Title: "+rs.getString(2));
					System.out.println("Duration (in min) : "+rs.getString(5));
					System.out.println("----------------------------------------");
				}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void showtheater() 
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
					System.out.println("----------------------------------------");
				}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	} 
}
