package com.Movie.BookingAPP;

import java.util.Scanner;

public class Admin 
{	
	static long OID=18022003;
	static int OPW=1234;
	static Scanner in=new Scanner(System.in);
	public static void Adminmenu()
	{
		System.out.println("Enter Admin ID");
		long ID=in.nextLong();
		System.out.println("Enter Password");
		int PW=in.nextInt();
		if(ID==OID && PW==OPW)
		{
			int choice=0;
			while(choice!=7)
			{
				System.out.println("Welcome to Admin Section");
				System.out.println("----------------------------------------");
				System.out.println("1. Add Movies");
				System.out.println("2. See All Movies");
				System.out.println("3. Put a movie show time");
				System.out.println("4. See all Show Time");
				System.out.println("5. Add Theaters");
				System.out.println("6. To See all Theaters");
				System.out.println("7. Exit");
				System.out.println("----------------------------------------");
				System.out.println();
				System.out.println("Enter your Choice");
				choice=in.nextInt();
				switch(choice)
				{
					case 1:
					{
						Movie.insertMovie();
						break;
					}
					
					case 2:
					{
						Movie.showmovies();
						break;
					}
					
					case 3:
					{
						ShowTimes.insertshowtime();
						break;
					}
					
					case 4:
					{
						ShowTimes.showtime();
						break;
					}
					
					case 5:
					{
						Theaters.inserttheaters();
						break;
					}
					
					case 6:
					{
						Theaters.showtheaters();
						break;
					}
					
					case 7:
					{
						System.out.println("Thank You for Using Book My Show");
						break;
					}
					
					default :
					{
						System.out.println("Wrong Input");
					}
				}
			}
		}
		
		else
		{
			System.out.println("Wrong Admin ID or Password");
		}
	}
}
