package Controller;

import java.util.Scanner;

import Bean.AdminPayment;
import Bean.UserPayment;
import Dao.AdminDao;

public class Login
{
	public static AdminPayment AdminLogindetails()
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("\t\tEnter Admin email : ");
		String  email=sc.nextLine();
		System.out.print("\t\tEnter Admin Password : ");
		String  pass=sc.nextLine();
		if(Filter.AdminDetailFilter.checkString(email) && Filter.AdminDetailFilter.checkEmailRegex(email) && Filter.AdminDetailFilter.checkString(pass) && Filter.AdminDetailFilter.checkStringAndNumberRegex(pass))
		{
			int i =Dao.AdminDao.getAdminFromEmailAndPass(email, pass);
			AdminPayment a= Dao.AdminDao.GetAdminDetails(email, pass);
			
			if(i==0 || a==null)
			{
				System.out.println("\n\t\t\tYou are not signed up !!!   OR   you enter wrong details !!!!");
				return null;
			}
			else
			{
				return a;
			}
		}
		else
		{
			System.out.println("\n\t\t\tEntered Details are Invalid !!!");
			return null;
		}
	}
	public static UserPayment UserLogindetails()
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("\t\tEnter User email : ");
		String  email=sc.nextLine();
		System.out.print("\t\tEnter User Password : ");
		String  pass=sc.nextLine();
		if(Filter.UserDetailFilter.checkString(email) && Filter.UserDetailFilter.checkEmailRegex(email) && Filter.UserDetailFilter.checkString(pass) && Filter.UserDetailFilter.checkStringAndNumberRegex(pass))
		{
			int i =Dao.UserDao.getUserFromEmailAndPass(email, pass);
			UserPayment up=Dao.UserDao.GetUserDetails(email, pass);
			if(i==0 || up==null)
			{
				System.out.println("\n\t\t\tYou are not signed up !!!   OR   you enter wrong details !!!!");
				return null;
			}
			else
			{
				return up;
			}
		}
		else
		{
			System.out.println("\n\t\t\tEntered Details are Invalid !!!");
			return null;
		}
	}
}
