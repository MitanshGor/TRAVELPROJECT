package Controller;

import java.util.Scanner;

import Bean.AdminPayment;

public class AdminLoginSucessful 
{
	public static void AdminLoginSucessfulMethod(AdminPayment a)
	{
		Scanner sc=new Scanner(System.in);
		WhileLoop: while(true)
		{
			System.out.println("1--------create Package");
			System.out.println("2--------Edit/Update Package");
			System.out.println("3--------Remove Package");
			System.out.println("4--------View My Details");
			System.out.println("5--------View My Customers");
			System.out.println("6--------View My Packages");
			System.out.println("7--------Go Back");
			System.out.println("Enter Your choice :");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:
					boolean b =Controller.PackageDetails.PackageDetailsData(a.getAdminId());
					if(b==true)
					{
						System.out.println("Package Sucessfully enterd into database  !!");
					}
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break WhileLoop;
			default :	System.out.println("Wrong choice entered");
			}
		}
		sc.close();
	}
	
	public static void main(String[] args) {
		AdminPayment a=new AdminPayment();
		a.setAdminId(16);
		AdminLoginSucessfulMethod(a);
	}
}