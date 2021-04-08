package Controller;

import java.util.Scanner;

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
							String choic = sc.next();
							adminChoice= Integer.parseInt(choic);
							switch(adminChoice)
							{
							case 1:
											AdminEnterDetail ad=new AdminEnterDetail();
											ad.AdminEnterDetail();
							
											
											// aia jai ne signu up karje
								break;
							case 2:
										// login 
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
										// aia jai ne signu up karje
							break;
						case 2:
									// lo
//						

							
							break;
						case 3:
								break UserWhile; 
						}
					}
					
				break;
				
				case 3 : 
						System.exit(0);
			}
		}
			
	}

}
