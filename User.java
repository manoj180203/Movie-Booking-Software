package com.Movie.BookingAPP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class User 
{	
	static Scanner in = new Scanner(System.in);
	static long phone;
	static int ch=0;
	public static void UserLogin()
	{
		Connection con = Connector.requestConnection();
		PreparedStatement ps= null;
		System.out.println("Enter Phone num");
		phone=in.nextLong();
		System.out.println("Login Sucessfull");
		getuserid(phone);
		String query="INSERT INTO USERS(PHONE) VALUES(?)";
		try 
		{
			ps= con.prepareStatement(query);
			ps.setLong(1, phone);
			ps.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("Welcome to Book my Show");
		while(ch!=4)
		{
			System.out.println("----------------------------------------");
			System.out.println("1. To book a Ticket");
			System.out.println("2. See Ticket Booking");
			System.out.println("3. To cancel a booking");
			System.out.println("4. Exit");
			System.out.println("----------------------------------------");
			System.out.println();
			System.out.println("Enter your Choice");
			ch=in.nextInt();
			switch(ch)
			{
				case 1:
				{
					Tickets.booktickets();
					break;
				}
				
				case 2:
				{
					Tickets.viewtickets();
					break;
				}
				
				case 3:
				{
					Tickets.canceltickets();
					break;
				}
				
				case 4:
				{
					System.out.println("Thank You for Using Book My Show");
					break;
				}
				
				default:
				{
					System.out.println("Wrong Input");
				}
			}
		}	
	}
	
	public static void getuserid(long phnoe)
	{
		Connection con = Connector.requestConnection();
		Statement st =null;
		ResultSet rs= null;
		String query="SELECT * FROM USERS WHERE PHONE="+phnoe;
		try 
		{
			st=con.createStatement();
			rs=st.executeQuery(query);
			while(rs.next())
			{
				System.out.println("Your User ID is: "+rs.getInt(1));
				System.out.println("----------------------------------------");
				
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void deleteuser()
	{
		Connection con = Connector.requestConnection();
		PreparedStatement ps =null;
		String query="DELETE FROM USERS";
		try 
		{
			ps=con.prepareStatement(query);
			ps.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
