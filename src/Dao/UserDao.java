package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import Bean.AdminPayment;
import Bean.User;
import Bean.UserPackage;
import Bean.UserPayment;
import Util.JDBCConnection;

public class UserDao {
	
	public static boolean setUserTable(User a) {


		try (
				Connection con = JDBCConnection.getConnection();
				PreparedStatement pstmt = con
						.prepareStatement("insert into user(UserName,DOB,email,password,phone,Gender,Address) values(?,str_to_date(?,'%Y-%m-%d'),?,?,?,?,?);");
				PreparedStatement pstmt2 = con
						.prepareStatement("select UserId from user where email=? and password=?; ");
			) 
		{
			
			
			pstmt.setString(1,a.getUserName());
			pstmt.setString(2, a.getDob());
			pstmt.setString(3, a.getEmail());
			pstmt.setString(4, a.getPassword());
			pstmt.setString(5, a.getPhone());
			pstmt.setString(6, a.getGender());
			pstmt.setString(7, a.getAddress());
			// getting the Userid from table and storing it into User class (User)
			int i=pstmt.executeUpdate();
			
			
			pstmt2.setString(1, a.getEmail());
			pstmt2.setString(2, a.getPassword());
			
			ResultSet rs=pstmt2.executeQuery();
			while(rs.next())
			{
				a.setUserId(rs.getInt("UserId"));
			}
			if (i == 0) {
				return false;
			} else {
				return true;
			}
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean setUserPaymentTable(UserPayment a)
	{
		try (
				Connection con = JDBCConnection.getConnection();
				PreparedStatement pstmt = con
						.prepareStatement("insert into userpayment(AccountNo,UserId,Bankname,Accountname) values(?,?,?,?)");	
				) 
		{
			pstmt.setString(1,a.getAccountNo());
			pstmt.setInt(2,a.getUserId());
			pstmt.setString(3, a.getBankName());
			pstmt.setString(4, a.getAccountName());

			int i=pstmt.executeUpdate();
			if (i == 0) {
				return false;
			} else {
				return true;
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;		
	}
	public static int getUserFromEmailAndPass(String email,String password)
	{
		try
		(
				Connection con=JDBCConnection.getConnection();
				PreparedStatement pstmt =con.prepareStatement("select UserId from user where email=? and password=?");
				)
		{
			pstmt.setString(1,email);
			pstmt.setString(2,password);
			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				return rs.getInt("userId");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}
	public static UserPayment GetUserDetails(String email,String password)
	{
		try(
			Connection con=JDBCConnection.getConnection();
				PreparedStatement pstmt=con.prepareStatement("select * from user where email='?' and password='?'");	
				PreparedStatement pstmt2=con.prepareStatement("select * from userpayment where userId=?");	
			)
		{
			pstmt.setString(1,email);
			pstmt.setString(2,password);
			ResultSet rs=pstmt.executeQuery();
			UserPayment a = new UserPayment();
			while(rs.next())
			{
				a.setUserId(rs.getInt("userId"));
				a.setUserName(rs.getString("userName"));
				
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
			    String strDate = formatter.format(rs.getDate("DOB"));  
			    a.setDob(strDate);
			    a.setEmail(rs.getString("email"));
			    a.setPassword(rs.getString("password"));
			    a.setPhone(rs.getString("phone"));
			    a.setGender(rs.getString("gender"));
			    a.setAddress(rs.getString("address"));
				}
			pstmt2.setInt(1,a.getUserId());
				
			ResultSet rs2=pstmt2.executeQuery();
			while(rs2.next())
			{
				a.setAccountNo(rs2.getString("AccountNo"));
				a.setAccountName(rs2.getString("Accountname"));
				a.setBankName(rs2.getString("BankName"));
			}
			if(a.getUserId()==0)
			{
				return null;
			}
			else
			{
				return a;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	
	
	
	
	
	
	
	public static boolean UpdateUserPackagetable(float total, int userId, int packageId, int noOftickets) 
	{
		try(
				Connection con=JDBCConnection.getConnection();
				PreparedStatement pstmt=con.prepareStatement("update userPackage set totalPrice=totalPrice+?  , noOfTicket=noOfticket+? where packageID=? and userId=?");
			)
		{
			pstmt.setFloat(1,total);
			pstmt.setInt(2,noOftickets);
			pstmt.setInt(3,packageId);
			pstmt.setInt(4,userId);
			int i= pstmt.executeUpdate();
			 if(i>0)
			 {
				 return true;
			 }
			 else
			 {
				 return false;
			 }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public static int getAllUserPackageDetail( int userId , int packageId )
	{
		 try(
				 Connection con=JDBCConnection.getConnection();
				 PreparedStatement pstmt=con.prepareStatement("select * from userpackage where userId=? and packageId=?");
				 )
		 {
			 pstmt.setInt(1, userId);//(userId);
			 pstmt.setInt(2, packageId);//(userId);
			 
			 ResultSet rs=pstmt.executeQuery();
			 int count=0;
			 while(rs.next())
			 {
				 count++;
			 }
			 if(count>0)
			 {
				 return 1;
			 }
			 else
			 {
				 return 0;
			 }
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		return 0;
	}
	public static ArrayList<UserPackage> getAllUserPackageDetail( int userId )
	{
		 try(
				 Connection con=JDBCConnection.getConnection();
				 PreparedStatement pstmt=con.prepareStatement("select * from userpackage where userId=?");
				 )
		 {
			 pstmt.setInt(1, userId);//(userId);
			 
			 ResultSet rs=pstmt.executeQuery();
			 ArrayList<UserPackage> al=new ArrayList<UserPackage>();
			 UserPackage u;
			 while(rs.next())
			 {
				 u=new UserPackage();
				 u.setNoofticket(rs.getInt("noOfTicket"));
				 u.setPackageId(rs.getInt("PackageId"));
				 u.setUserId(rs.getInt("UserId"));
				 u.setTotalprice(rs.getFloat("totalPrice"));
				 
				 al.add(u);
			 }
			 return al;
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		return null;
	}
	public static ArrayList<UserPackage> getAllUserPackageDetailbyPackageId( int packageId)
	{
		 try(
				 Connection con=JDBCConnection.getConnection();
				 PreparedStatement pstmt=con.prepareStatement("select * from userpackage where packageId=?");
				 )
		 {
			 pstmt.setInt(1, packageId);//(userId);
			 
			 ResultSet rs=pstmt.executeQuery();
			 ArrayList<UserPackage> al=new ArrayList<UserPackage>();
			 UserPackage u;
			 while(rs.next())
			 {
				 u=new UserPackage();
				 u.setNoofticket(rs.getInt("noOfTicket"));
				 u.setPackageId(rs.getInt("PackageId"));
				 u.setUserId(rs.getInt("UserId"));
				 u.setTotalprice(rs.getFloat("totalPrice"));
				 
				 al.add(u);
			 }
			 return al;
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		return null;
	}
	public static boolean setUserPackagetable(float total , int userId , int packageId , int noOftickets) {


		try (
				Connection con = JDBCConnection.getConnection();
				PreparedStatement pstmt = con
						.prepareStatement("insert into userpackage(packageId,userId,noOfticket,totalPrice) values(?,?,?,?);");
			) 
		{
			
			
			pstmt.setInt(1,packageId);
			pstmt.setInt(2, userId);
			pstmt.setInt(3, noOftickets);
			pstmt.setFloat(4, total);
			
			int i=pstmt.executeUpdate();
			
			
			if (i == 0) {
				return false;
			} else {
				return true;
			}
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static UserPayment GetUserDetails(int userId) 
	{
		try
			(
					Connection con=JDBCConnection.getConnection();
					PreparedStatement pstmt=con.prepareStatement(" select * from user join userpayment on (user.UserId = userpayment.userId) where user.userId=?");
			)
		{
			pstmt.setInt(1, userId);
			
			ResultSet rs=pstmt.executeQuery();
			
			UserPayment u=new UserPayment();
			while(rs.next())
			{
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
				   String strDate = formatter.format(rs.getDate("DOB"));  
				
				u.setUserId(rs.getInt("UserId"));
				u.setUserName(rs.getString("UserName"));
				u.setDob(strDate);
				u.setEmail(rs.getString("Email"));
				u.setPassword(rs.getString("Password"));
				u.setPhone(rs.getString("phone"));
				u.setGender(rs.getString("Gender"));
				u.setAddress(rs.getString("Address"));
				u.setAccountNo(rs.getString("AccountNo"));
				u.setBankName(rs.getString("BankName"));
				u.setAccountName(rs.getString("AccountName"));
			}
			
			return u;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	
	
	
	public static boolean UpdateUserTable(UserPayment a) 
	{
		try (
				Connection con = JDBCConnection.getConnection();
				PreparedStatement pstmt = con
						.prepareStatement("update user set  UserName=? ,  DOB=? , password=? , Gender=? , Address=? where userId = ?");
			
				) 
		{
			
			pstmt.setString(1,a.getUserName());
			pstmt.setString(2,a.getDob());
			pstmt.setString(3, a.getPassword());
			pstmt.setString(4, a.getGender());
			pstmt.setString(5, a.getAddress());
			pstmt.setInt(6, a.getUserId());
			
			// getting the adminid from table and storing it into admin class (admin)
			//pstmt2.setString(1,a.getEmail());
			//pstmt2.setString(2,a.getPassword());
			int i=pstmt.executeUpdate();
			
			if (i == 0) {
				return false;
			} else {
				return true;
			}
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean UpdateUserPaymentTable(UserPayment a) 
	{

		try (
				Connection con = JDBCConnection.getConnection();
				PreparedStatement pstmt = con
						.prepareStatement("update  userpayment set AccountNo = ? , Bankname = ? , AccountName = ? where  UserId = ?");
				) 
		{
			
			pstmt.setString(1,a.getAccountNo());
			pstmt.setString(2,a.getBankName());
			pstmt.setString(3, a.getAccountName());
			pstmt.setInt(4, a.getUserId());
			//nd storing it into admin class (admin)
			//pstmt2.setString(1,a.getEmail());
			//pstmt2.setString(2,a.getPassword());
			int i=pstmt.executeUpdate();
			
			if (i == 0) {
				return false;
			} else {
				return true;
			}
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static int getUsersTotalPriceAndName(int userId) {
		try(
				Connection con=JDBCConnection.getConnection();
				PreparedStatement pstmt=con.prepareStatement("select totalPrice from userpackage where userId=?");
				)
		{
			pstmt.setInt(1, userId);
			int total=0;
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				total=total+rs.getInt("TotalPrice");
			}
			return total;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}

		
}