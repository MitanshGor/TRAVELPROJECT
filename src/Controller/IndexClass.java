package Controller;

import java.util.Scanner;

import Bean.AdminPayment;
import Bean.UserPayment;

public class IndexClass {

	public static void main(String[] args) 
	{
//		int  adminChoice;
		Scanner sc=new Scanner(System.in);
		
		System.out.println("\t\t\t\t-----------------------------------------------------------------------------------------");
		System.out.println("\t\t\t\t-----------------------------------------------------------------------------------------");
		System.out.println("\t\t\t\t-----------------------------------------------------------------------------------------");
		System.out.println("\t\t\t\t-------------------------------------TRAVELPEDIA-----------------------------------------");
		System.out.println("\t\t\t\t--------------------------------Awaken To A Different World.-----------------------------");
		System.out.println("\t\t\t\t-----------------------------------------------------------------------------------------");
		System.out.println("\t\t\t\t-----------------------------------------------------------------------------------------");
		System.out.println("\t\t\t\t-----------------------------------------------------------------------------------------");
			
		while(true)
		{
			System.out.println();
			System.out.println();
				
			System.out.println("1-----Admin ");
			System.out.println("2-----User ");
			System.out.println("3-----Exit App ");
			System.out.print("Enter Your choice :");
			int choice;
			String ch=sc.next();
			try
			{
			 choice=Integer.parseInt(ch);
			}
			catch(NumberFormatException e)
			{
				CatchBlockStatement();
				continue;
			}
			System.out.println();
			switch(choice)
			{
				case 1:
						AdminWhile: while(true)
						{
							System.out.println();
							System.out.println();
						
//							System.out.println("-----------------------------------------------------------------------------------------");
							System.out.println("\t1-----Admin Signup ");
							System.out.println("\t2-----Admin Login ");
							System.out.println("\t3-----Go back");
							System.out.print("\tEnter Your choice :");
							int adminChoice;
							String ch1=sc.next();
							try
							{
							 adminChoice=Integer.parseInt(ch1);
							}
							catch(NumberFormatException e)
							{
								CatchBlockStatement();
								continue;
							}
							System.out.println();
							switch(adminChoice)
							{
							case 1:
											AdminEnterDetail ad=new AdminEnterDetail();
											boolean b= ad.AdminEnterDetail();
											if(b==true) 
											{
												System.out.println("\n\t\t\tSignup Sucessful");
											}
											else
											{
												System.out.println("\n\t\t\tSignup Un-Sucessful");	
											}	
							break;
							case 2:
											AdminPayment a=Login.AdminLogindetails();
											if(a==null)
											{
												System.out.println("\n\t\t\tLogin Details Invalid");
											}
											else
											{
												System.out.println("\n\t\t\tLogin sucessful\n");
												AdminLoginSucessful.AdminLoginSucessfulMethod(a);
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
						System.out.println();
						System.out.println();
						
						System.out.println("\t1-----User Signup ");
						System.out.println("\t2-----User Login ");
						System.out.println("\t3-----Go back");
						System.out.print("\tEnter Your choice :");
						int userChoice= sc.nextInt();
						String ch3=sc.next();
						try
						{
						 userChoice=Integer.parseInt(ch3);
						}
						catch(NumberFormatException e)
						{
							CatchBlockStatement();
							continue;
						}
						System.out.println();
						switch(userChoice)
						{
						case 1:
									UserEnterDetails ud=new UserEnterDetails();
									boolean b=ud.UserEnterDetail();
									if(b==true) 
									{
										System.out.println("\n\t\t\tSignup Sucessful");
									}
									else
									{
										System.out.println("\n\t\t\tSignup Un-Sucessful");	
									}
							break;
						case 2:
									UserPayment a = Login.UserLogindetails();
							
									if(a==null)
									{
										System.out.println("\n\t\t\tLogin details Invalid");	
									}
									else
									{
										System.out.println("\n\t\t\tLogin sucessful\n");
										UserLoginSucessFull.UserLoginSucessfulMethod(a);
									}
										
							break;
						case 3:
								break UserWhile; 
						}
					}	
				break;
			
				case 3 : 
					System.out.println("\t\t\t\t-----------------------------------------------------------------------------------------");
					System.out.println("\t\t\t\t----------------------------Thanks for Using TRAVELPEDIA---------------------------------");
					System.out.println("\t\t\t\t-----------------------------------------------------------------------------------------");
						System.exit(0);
			}
			
		}	
		}
		

	public static void CatchBlockStatement()
	{
		System.out.println("\n\n***************************************************");
		System.out.println("\t\tInvalid Input");
		System.out.println("***************************************************");
	
	}
}