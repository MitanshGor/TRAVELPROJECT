package Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Bean.Admin;
import Bean.AdminPayment;
import Dao.AdminDao;
import Util.JDBCConnection;

public class AdminEnterDetail 
{
	public void AdminEnterDetail()  
	{
		String name;
		Scanner sc=new Scanner(System.in);

		
		System.out.println("********************ADMIN SIGN  UP***************************");
		System.out.println("Enter Name :");
		name=sc.next();
		System.out.println("Enter Email :");
		String email = sc.next();
		System.out.println("Enter password :");
		String password = sc.next();
		System.out.println("Enter DOB (yyyy-mm-dd):");
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
		int AccountNumber = sc.nextInt();
		System.out.println("Enter Account Name :");
		String AccountName = sc.next();
		
		

		AdminPayment admin=new AdminPayment();
		admin.setAddress(address);
		admin.setPassword(password);
		//admin.setAdminId();
		admin.setAdminName(name);
		admin.setDOB(DOB);
		admin.setEmail(email);
		admin.setGender(Gender);
		admin.setPhone(phone);
		admin.setBankName(BankName);
		admin.setAccountName(AccountName);
		admin.setAccountNo(AccountNumber);
		sc.close();
		
		boolean b1 = Dao.AdminDao.setAdminTable(admin);
		boolean b2 = Dao.AdminDao.setAdminPaymentTable(admin);
		
		if(b1==false ||  b2==false)
		{
			System.out.println("Exception occoured !!!. Detail is not enetered in tablee sql");
		}
		else
		{
			System.out.println("Sucessfull details entered in table sql");
		}
		}
}
