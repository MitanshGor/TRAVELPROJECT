package Controller;
import java.util.Scanner;

import Bean.Admin;
import Bean.AdminPayment;
import Bean.UserPayment;

public class UserEnterDetails 
{	
	public void AdminEnterDetail() 
	{
		String name;
		Scanner sc=new Scanner(System.in);

		
		System.out.println("********************USER SIGN  UP***************************");
		System.out.println("Enter Name :");
		name=sc.next();
		System.out.println("Enter Email :");
		String email = sc.next();
		System.out.println("Enter password :");
		String password = sc.next();
		System.out.println("Enter DOB :");
		String DOB = sc.next();
		System.out.println("Enter Phone :");
		String phone = sc.next();
		System.out.println("Enter Address :");
		String address = sc.next();
		System.out.println("Enter Gender :");
		String Gender = sc.next();
		System.out.println("Enter Bank Name :");
		String BankName = sc.next();
		System.out.println("Enter Account Number :");
		String AccountNumber = sc.next();
		System.out.println("Enter Account Name :");
		String AccountName = sc.next();
		
			
		UserPayment admin=new UserPayment();
		admin.setAddress(address);
		//admin.setUserName(name);
		//admin.setPhone(name);
		//admin.setAdminId();
		admin.setPassword(password);
		admin.setUserName(name);
		admin.setDob(DOB);
		admin.setEmail(email);
		admin.setGender(Gender);
		admin.setPhone(phone);
		
		admin.setBankName(BankName);
		admin.setAccountName(AccountName);
		admin.setAccountNo(AccountNumber);
		
		
		boolean b1 = Dao.UserDao.setUserTable(admin);
		boolean b2 = Dao.UserDao.setUserPaymentTable(admin);
	
	}
}
