package Controller;

import java.util.Scanner;

import Bean.AdminPayment;
import Bean.UserPayment;

public class IndexClass {

	public static void main(String[] args) 
	{
		int  adminChoice;
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			System.out.println("1-----Admin ");
			System.out.println("2-----User ");
			int choice = sc.nextInt();
			
			switch(choice)
			{
				case 1:
						AdminWhile: while(true)
						{
							System.out.println("1-----Admin Signup ");
							System.out.println("2-----Admin Login ");
							System.out.println("3-----Go back");
							adminChoice=  sc.nextInt();
							switch(adminChoice)
							{
							case 1:
											AdminEnterDetail ad=new AdminEnterDetail();
											boolean b= ad.AdminEnterDetail();
											if(b==true) 
											{
												System.out.println("Signup Sucessful");
											}
											else
											{
												System.out.println("Signup Un-Sucessful");	
											}	
							break;
							case 2:
											if(Login.AdminLogindetails()==null)
											{
												System.out.println("Login Details Invalid");
											}
											else
											{
												AdminPayment a=Login.AdminLogindetails();
												
											}
							break;
							case 3:
									break AdminWhile; 
							}
						}
				break;
				case 2:
					UserWhile: while(true)
					{
						System.out.println("1-----User Signup ");
						System.out.println("2-----User Login ");
						System.out.println("3-----Go back");
						int userChoice= sc.nextInt();
						switch(userChoice)
						{
						case 1:
									UserEnterDetails ud=new UserEnterDetails();
									boolean b=ud.UserEnterDetail();
									if(b==true) 
									{
										System.out.println("Login Sucessful");
									}
									else
									{
										System.out.println("Login Un-Sucessful");	
									}
							break;
						case 2:
									if(Login.UserLogindetails()==null)
									{
										System.out.println("Loged perfefectly User");	
									}
									else
									{
										UserPayment a = Login.UserLogindetails();
									}
										
							break;
						case 3:
								break UserWhile; 
						}
					}	
				break;
			
				case 3 : 
					sc.close();
						System.exit(0);
			}
		}	
	}
}
