package Controller;
import java.util.Scanner;

import Bean.Admin;
import Bean.AdminPayment;
import Bean.UserPayment;
import Dao.AdminDao;
import Dao.UserDao;

public class UserEnterDetails 
{	
	public boolean UserEnterDetail() 
	{
		String name;
		Scanner sc=new Scanner(System.in);

		
		System.out.print("\t\n********************USER SIGN  UP***************************");
		System.out.print("\n\n\tEnter Name :");
		name=sc.nextLine();
		System.out.print("\tEnter Email :");
		String email = sc.nextLine();
		System.out.print("\tEnter password [should only have characters from : (a-zA-Z0-9!@#$%^&*()_-) ] :");
		String password = sc.nextLine();
		System.out.print("\tEnter DOB (YYYY-MM-DD):");
		String DOB = sc.nextLine();
		System.out.print("\tEnter Phone :");
		String phone = sc.nextLine();
		System.out.print("\tEnter Address :");
		String address = sc.nextLine();
		System.out.print("\tEnter Gender  (M/F):");
		String Gender = sc.nextLine();
		System.out.print("\tEnter Bank Name :");
		String BankName = sc.nextLine();
		System.out.print("\tEnter Account Number :");
		String AccountNumber = sc.nextLine();
		System.out.print("\tEnter Account Name :");
		String AccountName = sc.nextLine();
		
			
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
//		sc.close();
		
		
		int validationCheck =Filter.UserDetailFilter.validationUser(admin);
		if(validationCheck==0)
		{
			if(UserDao.getUserFromEmailAndPass(email)==0 || UserDao.getUserFromEmailAndPass(email, password)==0)
			{
					boolean b1 = Dao.UserDao.setUserTable(admin);
					boolean b2 = Dao.UserDao.setUserPaymentTable(admin);
					if(b1==false ||  b2==false)
					{
						System.out.println("\n\t\tException occoured !!!. Detail is not enetered into database");
						return false;
					}
					else
					{
		//				System.out.print("Sucessfull details entered in table sql");
						return true;
					}
			}
			else
			{
				System.out.println("\n\t\tThe email you entered is already signed in !!");
				return false;
			}
		}
		else
		{
			System.out.println("\n\t\t"+validationCheck+"/10 number of data were INVALID !!!....Please fill valid data");
			return false;	
		}
	}
//	  /////////////////////////////////////////
//	  /////////////////////////////////////////
//	  /////////////////////////////////////////
//	  /////////////////////////////////////////
//	  /////////////////////////////////////////
//	  /////////////////////////////////////////
//	  /////////////////////////////////////////
//	  /////////////////////////////////////////
	
	public void UserEnterDetail(int userId) 
	{
		
		Scanner sc=new Scanner(System.in);

		UserPayment a = Dao.UserDao.GetUserDetails(userId);
		System.out.print("\n\t********************USER UPDATE CHANGES***************************");
		System.out.print("\n\n\t\t\tEnter Name ("+a.getUserName()+") :");
		String name=sc.nextLine();
//		System.out.print("Enter Email :");
//		String email = sc.nextLine();
		System.out.print("\t\t\tEnter password ("+a.getPassword()+")  [should only have characters from : (a-zA-Z0-9!@#$%^&*()_-) ] :");
		String password = sc.nextLine();
		System.out.print("\t\t\tEnter DOB ("+a.getDob()+") (yyyy-mm-dd):");
		String DOB = sc.nextLine();
//		System.out.print("Enter Phone :");
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
		
		

		UserPayment user=new UserPayment();
		
		
		user.setUserName(name);
		user.setAddress(address);
		user.setPassword(password);
		user.setUserId(userId);
		
		user.setDob(DOB);
		user.setEmail(a.getEmail());
		user.setGender(Gender);
		user.setPhone(a.getPhone());
		user.setBankName(BankName);
		user.setAccountName(AccountName);
		user.setAccountNo(AccountNumber);
//		System.out.print("-------------------------?>" + user.getUserId()+"   " + user.getUserName());
		int validationCheck = Filter.UserDetailFilter.validationUser(user);


		if(validationCheck==0)
			{
			
				boolean b1 = Dao.UserDao.UpdateUserTable(user);
				boolean b2 = Dao.UserDao.UpdateUserPaymentTable(user);
				
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
	

	
	public static void main(String[] args) {
		UserEnterDetails u=new UserEnterDetails();
		UserPayment uv=new UserPayment();
//		uv.setUserId(3);
		u.UserEnterDetail(3);
	}
}
