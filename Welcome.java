package com.Movie.BookingAPP;

import java.util.Scanner;

public class Welcome 
{
	public static void main(String[] args) 
	{
		try (Scanner in = new Scanner(System.in)) 
		{
			int ch=0;
			System.out.println("Hello");
			while(ch!=3)
			{
				System.out.println("Choose an Option");
				System.out.println("1. Admin");
				System.out.println("2. User");
				System.out.println("3. Exit");
				ch=in.nextInt();
				switch(ch)
				{
					case 1:
					{
						Admin.Adminmenu();
						break;
					}
					
					case 2:
					{
						User.UserLogin();
						break;
					}
					
					case 3:
					{
						User.deleteuser();
						System.out.println("Closing Book My Show!!!");
						break;
					}
					
					default:
					{
						System.out.println("Invalid Input, Try Again");
						System.out.println();
					}
				}
			}
		}
	}
}

