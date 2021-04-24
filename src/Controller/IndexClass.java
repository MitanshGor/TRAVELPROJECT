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
		{	System.out.println("-----------------------------------------------------------------------------------------");
			System.out.println("1-----Admin ");
			System.out.println("2-----User ");
			System.out.println("3-----Exit App ");
			int choice = sc.nextInt();
			
			switch(choice)
			{
				case 1:
						AdminWhile: while(true)
						{
							System.out.println("-----------------------------------------------------------------------------------------");
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
											AdminPayment a=Login.AdminLogindetails();
											if(a==null)
											{
												System.out.println("Login Details Invalid");
											}
											else
											{
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
										System.out.println("Signup Sucessful");
									}
									else
									{
										System.out.println("Signup Un-Sucessful");	
									}
							break;
						case 2:
									UserPayment a = Login.UserLogindetails();
							
									if(a==null)
									{
										System.out.println("Login details Invalid");	
									}
									else
									{
										UserLoginSucessFull.UserLoginSucessfulMethod(a);
									}
										
							break;
						case 3:
								break UserWhile; 
						}
					}	
				break;
			
				case 3 : 
					System.out.println("***************************************************************");
					System.out.println("*******************Thanks for Using ***************************");
					System.out.println("***************************************************************");
						System.exit(0);
			}
		}	
	}
}
