package Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Bean.Admin;
import Bean.AdminPayment;
import Bean.UserPayment;
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
//		sc.close();
		
		int validationCheck = Filter.AdminDetailFilter.ValidationAdmin(admin);

//		sc.close();	
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

















	public void AdminEnterDetail(int AdminId)  
	{
		String name;
		Scanner sc=new Scanner(System.in);

		AdminPayment a = Dao.AdminDao.GetAdminDetails(AdminId);
		System.out.println("********************ADMIN SIGN  UP***************************");
		System.out.println("Enter Name ("+a.getAdminName()+")");
		name=sc.nextLine();
//		System.out.println("Enter Email :");
//		String email = sc.nextLine();
		System.out.println("Enter password ("+a.getPassword()+")  [should only have characters from : (a-zA-Z0-9!@#$%^&*()_-) ] :");
		String password = sc.nextLine();
		System.out.println("Enter DOB ("+a.getDOB()+") (yyyy-mm-dd):");
		String DOB = sc.nextLine();
//		System.out.println("Enter Phone :");
//		String phone = sc.nextLine();
		System.out.println("Enter Address ("+a.getAddress()+") :");
		String address = sc.nextLine();
		System.out.println("Enter Gender ("+a.getGender()+") (M/F):");
		String Gender = sc.nextLine();
		System.out.println("Enter Bank Name ("+a.getBankName()+"):");
		String BankName = sc.nextLine();
		System.out.println("Enter Account Name ("+a.getAccountName()+") :");
		String AccountName = sc.nextLine();
		System.out.println("Enter Account Number ("+a.getAccountNo()+") :");
		String AccountNumber = sc.nextLine();
		
		

		AdminPayment admin=new AdminPayment();
		admin.setAddress(address);
		admin.setPassword(password);
		admin.setAdminId(AdminId);
		admin.setAdminName(name);
		admin.setDOB(DOB);
		admin.setEmail(a.getEmail());
		admin.setGender(Gender);
		admin.setPhone(a.getPhone());
		admin.setBankName(BankName);
		admin.setAccountName(AccountName);
		admin.setAccountNo(AccountNumber);
		
		int validationCheck = Filter.AdminDetailFilter.ValidationAdmin(admin);


		if(validationCheck==0)
			{
				boolean b1 = Dao.AdminDao.UpdateAdminTable(admin);
				boolean b2 = Dao.AdminDao.UpdateAdminPaymentTable(admin);
				
				if(b1==false ||  b2==false)
				{
					System.out.println("Exception occoured !!!. Detail is not updated into database");
//					return false;
				}
				else
				{
					System.out.println("Sucessfull details updated ");
//					
					
//					return true;
				}	
			}
			else
			{
				System.out.println(validationCheck+"/10 number of data were INVALID !!!....Please fill valid data");
//				return false;
			}
		}

	
	
	public static void main(String[] args) {
		AdminEnterDetail u=new AdminEnterDetail();
		AdminPayment uv=new AdminPayment();
//		uv.setUserId(3);
		u.AdminEnterDetail(16);
	}

}