package com.Movie.BookingAPP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Scanner;

public class Tickets 
{
	static Scanner in= new Scanner(System.in);
	public static void booktickets()
	{
		System.out.println("Enter Your Phno no.");
		long Phone=in.nextLong();
		ShowTimes.showtime();
		System.out.println();
		System.out.println("Choose your Show Time ID");
		int ch=in.nextInt();
		Connection con = Connector.requestConnection();
		if(ch>0)
		{
			String query= "INSERT INTO TICKETS(PHONE,TITLE,SHOWTIMEID,THEATERNAME,SHOWTIME) VALUES (?,?,?,?,?)";
			int res=0;
			try 
			{
				PreparedStatement ps=con.prepareStatement(query);
				ps.setLong(1,Phone);
				ps.setString(2,data1(ch));
				ps.setInt(3,data2(ch));
				ps.setString(4,data3(ch));
				ps.setTimestamp(5,data5(ch));
				res=ps.executeUpdate();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			if(res > 0)
			{
				System.out.println("Tickets Booked Sucessfully");
				getbid(Phone);
			}
			else
			{
				System.out.println("Something went wrong, Try Again!!!");
			}
		}
		else
		{
			System.out.println("Now Shows Found");
		}
	}
	
	public static void getbid(long Phone)
	{
		Statement st=null;
		String query="SELECT * FROM TICKETS WHERE PHONE="+Phone;
		Connection con = Connector.requestConnection();
		try
		{
			st=con.createStatement();
			ResultSet rs= st.executeQuery(query);
			while(rs.next())
				{
					System.out.println();
					System.out.println("Booking ID: "+rs.getInt(1));
					System.out.println("Phone num: "+rs.getLong(2));
					System.out.println("Movie Name: "+rs.getString(3));
					System.out.println("Show ID: "+rs.getInt(4));
					System.out.println("TheaterName: "+rs.getString(5));
					System.out.println("Time (in date hrs:min:sec): "+rs.getTimestamp(6));
					System.out.println("----------------------------------------------------");
				}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void viewtickets()
	{
		System.out.println("Enter Booking ID");
		int BookID=in.nextInt();
			Statement st=null;
			String query="SELECT * FROM TICKETS WHERE TICKETID="+BookID;
			Connection con = Connector.requestConnection();
			try
			{
				st=con.createStatement();
				ResultSet rs= st.executeQuery(query);
				while(rs.next())
					{
						System.out.println();
						System.out.println("Booking ID: "+rs.getInt(1));
						System.out.println("Phone num: "+rs.getLong(2));
						System.out.println("Movie Name: "+rs.getString(3));
						System.out.println("Show ID: "+rs.getInt(4));
						System.out.println("TheaterName: "+rs.getString(5));
						System.out.println("Time (in date hrs:min:sec): "+rs.getTimestamp(6));
						System.out.println("----------------------------------------------------");
					}
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
	}
	
	public static void canceltickets()
	{
		System.out.println("Enter Booking ID");
		int BookID=in.nextInt();
		
			PreparedStatement ps=null;
			String query="DELETE FROM TICKETS WHERE TICKETID="+BookID;
			Connection con = Connector.requestConnection();
			try
			{
				ps=con.prepareStatement(query);
				ps.executeUpdate();
				System.out.println("Tickets Cancelled");
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
	}
	
	public static int data2(int ch)
	{
		Connection con = Connector.requestConnection();
		String display= "SELECT * FROM SHOWTIMES WHERE SHOWTIMEID="+ch;
		Statement st=null;
		ResultSet rs=null;
		int si = 0;
		try 
		{
			st = con.createStatement();
			rs= st.executeQuery(display);
			rs.next();
			si=rs.getInt(1);
			rs.close();
			st.close();	
		} 
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return si;
	} 
		
	public static String data1(int ch)
	{
		Connection con = Connector.requestConnection();
		String display= "SELECT * FROM SHOWTIMES WHERE SHOWTIMEID="+ch;
		Statement st=null;
		ResultSet rs=null;
		String mn="";
		try 
		{
			st = con.createStatement();
			rs= st.executeQuery(display);
			rs.next();
			mn=rs.getString(2);
			rs.close();
			st.close();	
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return mn;
	} 
	
	public static String data3(int ch)
	{
		Connection con = Connector.requestConnection();
		String display= "SELECT * FROM SHOWTIMES WHERE SHOWTIMEID="+ch;
		Statement st=null;
		ResultSet rs=null;
		String tn="";
		try 
		{
			st = con.createStatement();
			rs= st.executeQuery(display);
			rs.next();
			tn=rs.getString(3);
			rs.close();
			st.close();	
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tn;
	} 
	
	public static Timestamp data5(int ch)
	{
		Connection con = Connector.requestConnection();
		String display= "SELECT * FROM SHOWTIMES WHERE SHOWTIMEID="+ch;
		Statement st=null;
		ResultSet rs=null;
		Timestamp ts = null;
		try 
		{
			st = con.createStatement();
			rs= st.executeQuery(display);
			rs.next();
			ts=rs.getTimestamp(4);
			rs.close();
			st.close();	
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return ts;
	} 
}








