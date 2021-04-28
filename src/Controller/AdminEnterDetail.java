package Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
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

		try
		{
				System.out.print("\n\t********************ADMIN SIGN  UP***************************");
				System.out.print("\n\n\tEnter Name :");
				name=sc.nextLine();
				System.out.print("\tEnter Email :");
				String email = sc.nextLine();
				System.out.print("\tEnter password  [should only have characters from : (a-zA-Z0-9!@#$%^&*()_-) ] :");
				String password = sc.nextLine();
				System.out.print("\tEnter DOB (yyyy-mm-dd):");
				String DOB = sc.nextLine();
				System.out.print("\tEnter Phone :");
				String phone = sc.nextLine();
				System.out.print("\tEnter Address :");
				String address = sc.nextLine();
				System.out.print("\tEnter Gender (M/F):");
				String Gender = sc.nextLine();
				System.out.print("\tEnter Bank Name :");
				String BankName = sc.nextLine();
				System.out.print("\tEnter Account Name :");
				String AccountName = sc.nextLine();
				System.out.print("\tEnter Account Number :");
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
				
					if(AdminDao.getAdminFromEmailAndPass(email)==0 || AdminDao.getAdminFromEmailAndPass(email, password)==0)
					{
						boolean b1 = Dao.AdminDao.setAdminTable(admin);
						boolean b2 = Dao.AdminDao.setAdminPaymentTable(admin);
						
						if(b1==false ||  b2==false)
						{
							System.out.println("\tException occoured !!!. Detail is not enetered into database");
							return false;
						}
						else
						{
	//						System.out.print("\tSucessfull details entered in table sql");
							return true;
						}	
					}
					else
					{
						System.out.println("\tThe email you entered is already signed in !!");
						return false;
					}
				
				}
				else
				{
					System.out.println("\t"+validationCheck+"/10 number of data were INVALID !!!....Please fill valid data");
					return false;
				}
		}
		catch(InputMismatchException e)
		{
			System.out.println("***************************************************");
			System.out.println("\t\tInvalid Input");
			System.out.println("***************************************************");
			return false;
		}
	
	}

















	public void AdminEnterDetail(int AdminId)  
	{
		String name;
		Scanner sc=new Scanner(System.in);
		try
		{
				AdminPayment a = Dao.AdminDao.GetAdminDetails(AdminId);
				System.out.print("\n\t********************ADMIN Update Details***************************\n");
				System.out.print("\n\t\t\tEnter Name ("+a.getAdminName()+")");
				name=sc.nextLine();
		//		System.out.print("\tEnter Email :");
		//		String email = sc.nextLine();
				System.out.print("\t\t\tEnter password ("+a.getPassword()+")  [should only have characters from : (a-zA-Z0-9!@#$%^&*()_-) ] :");
				String password = sc.nextLine();
				System.out.print("\t\t\tEnter DOB ("+a.getDOB()+") (yyyy-mm-dd):");
				String DOB = sc.nextLine();
		//		System.out.print("\tEnter Phone :");
		//		String phone = sc.nextLine();
				System.out.print("\t\t\tEnter Address ("+a.getAddress()+") :");
				String address = sc.nextLine();
				System.out.print("\t\t\tEnter Gender ("+a.getGender()+") (M/F):");
				String Gender = sc.nextLine();
				System.out.print("\t\t\tEnter Bank Name ("+a.getBankName()+"):");
				String BankName = sc.nextLine();
				System.out.print("\t\t\tEnter Account Name ("+a.getAccountName()+") :");
				String AccountName = sc.nextLine();
				System.out.print("\t\t\tEnter Account Number ("+a.getAccountNo()+") :");
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
							System.out.println("\n\t\t\t\tException occoured !!!. Detail is not updated into database");
		//					return false;
						}
						else
						{
							System.out.println("\n\t\t\t\tSucessfull details updated ");
		//					
							
		//					return true;
						}	
					}
					else
					{
						System.out.println("\n\t\t\t\t"+validationCheck+"/10 number of data were INVALID !!!....Please fill valid data");
		//				return false;
					}
		}
		catch(InputMismatchException e)
		{
			System.out.println("***************************************************");
			System.out.println("\t\tInvalid Input");
			System.out.println("***************************************************");
		}
	}

	
	
	public static void main(String[] args) {
		AdminEnterDetail u=new AdminEnterDetail();
		AdminPayment uv=new AdminPayment();
//		uv.setUserId(3);
		u.AdminEnterDetail(16);
	}

}