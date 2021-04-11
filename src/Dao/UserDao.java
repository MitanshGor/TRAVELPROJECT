package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import Bean.AdminPayment;
import Bean.User;
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

}

