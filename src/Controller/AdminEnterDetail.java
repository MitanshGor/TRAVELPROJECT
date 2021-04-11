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
	public boolean AdminEnterDetail()  
	{
		String name;
		Scanner sc=new Scanner(System.in);

		
		System.out.println("********************ADMIN SIGN  UP***************************");
		System.out.println("Enter Name :");
		name=sc.nextLine();
		System.out.println("Enter Email :");
		String email = sc.nextLine();
		System.out.println("Enter password  [should only have characters from : (a-zA-Z0-9!@#$%^&*()_-) ] :");
		String password = sc.nextLine();
		System.out.println("Enter DOB (yyyy-mm-dd):");
		String DOB = sc.nextLine();
		System.out.println("Enter Phone :");
		String phone = sc.nextLine();
		System.out.println("Enter Address :");
		String address = sc.nextLine();
		System.out.println("Enter Gender (M/F):");
		String Gender = sc.nextLine();
		System.out.println("Enter Bank Name :");
		String BankName = sc.nextLine();
		System.out.println("Enter Account Name :");
		String AccountName = sc.nextLine();
		System.out.println("Enter Account Number :");
		String AccountNumber = sc.nextLine();
		
		

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
		
		int validationCheck = Filter.AdminDetailFilter.ValidationAdmin(admin);

		sc.close();	
		if(validationCheck==0)
			{
				boolean b1 = Dao.AdminDao.setAdminTable(admin);
				boolean b2 = Dao.AdminDao.setAdminPaymentTable(admin);
				
				if(b1==false ||  b2==false)
				{
					System.out.println("Exception occoured !!!. Detail is not enetered into database");
					return false;
				}
				else
				{
//					System.out.println("Sucessfull details entered in table sql");
					return true;
				}	
			}
			else
			{
				System.out.println(validationCheck+"/10 number of data were INVALID !!!....Please fill valid data");
				return false;
			}
		}
}