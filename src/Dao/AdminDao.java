package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import Bean.Admin;
import Bean.AdminPayment;
import Util.JDBCConnection;

public class AdminDao {

	
	public static boolean setAdminTable(Admin a) {


		try (
				Connection con = JDBCConnection.getConnection();
				PreparedStatement pstmt = con
						.prepareStatement("insert into admin(AdminName,DOB,email,password,phone,Gender,Address) values(?,str_to_date(?,'%Y-%m-%d'),?,?,?,?,?)");
			
				PreparedStatement pstmt2 = con
						.prepareStatement("select AdminId from admin where email='"+a.getEmail()+"' and password='"+a.getPassword()+"'");
			
				) 
		{
			
			pstmt.setString(1,a.getAdminName());
			pstmt.setString(2,a.getDOB());
			pstmt.setString(3, a.getEmail());
			pstmt.setString(4, a.getPassword());
			pstmt.setString(5, a.getPhone());
			pstmt.setString(6, a.getGender());
			pstmt.setString(7, a.getAddress());
			// getting the adminid from table and storing it into admin class (admin)
			//pstmt2.setString(1,a.getEmail());
			//pstmt2.setString(2,a.getPassword());
			int i=pstmt.executeUpdate();
			
			ResultSet rs=pstmt2.executeQuery();
			while(rs.next()) 
			{
				a.setAdminId(rs.getInt("AdminId"));
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

	public static int getAdminFromEmailAndPass(String email,String password)
	{
		try
		(
				Connection con=JDBCConnection.getConnection();
				PreparedStatement pstmt =con.prepareStatement("select AdminId from admin where email=? and password=?");
		)
		{
			pstmt.setString(1,email);
			pstmt.setString(2,password);
			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				return rs.getInt("AdminId");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}
//	public static void main(String[] args) {
//		AdminPayment a = new AdminPayment();
//		a.setEmail("sdgh");
//		a.setPassword("sdgh");
//		
//		AdminPayment ap = getAdminIdFromSql(a);
//		System.out.println(ap.getAdminId()+ap.getEmail());
//		
//	}
//	
	public static boolean setAdminPaymentTable(AdminPayment a)
	{
		try (
				Connection con = JDBCConnection.getConnection();
				PreparedStatement pstmt = con
						.prepareStatement("insert into adminpayment(AccountNo,AdminId,Bankname,Accountname) values(?,?,?,?)");	
				) 
		{	
			pstmt.setString(1,a.getAccountNo());
			pstmt.setInt(2,a.getAdminId());
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
	
	
	public static AdminPayment GetAdminDetails(String email,String password)
	{
		try(
			Connection con=JDBCConnection.getConnection();
				PreparedStatement pstmt=con.prepareStatement("select * from admin where email=? and password=?");	
				PreparedStatement pstmt2=con.prepareStatement("select * from adminpayment where adminId=?");	
			)
		{
			pstmt.setString(1,email);
			pstmt.setString(2,password);
			ResultSet rs=pstmt.executeQuery();
			AdminPayment a = new AdminPayment();
			while(rs.next())
			{
				a.setAdminId(rs.getInt("AdminId"));
				a.setAdminName(rs.getString("AdminName"));
				
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
			    String strDate = formatter.format(rs.getDate("DOB"));  
			    a.setDOB(strDate);
			    a.setEmail(rs.getString("email"));
			    a.setPassword(rs.getString("password"));
			    a.setPhone(rs.getString("phone"));
			    a.setGender(rs.getString("gender"));
			    a.setAddress(rs.getString("address"));
				}
			pstmt2.setInt(1,a.getAdminId());
				
			ResultSet rs2=pstmt2.executeQuery();
			while(rs2.next())
			{
				a.setAccountNo(rs2.getString("AccountNo"));
				a.setAccountName(rs2.getString("Accountname"));
				a.setBankName(rs2.getString("BankName"));
			}
			if(a.getAdminId()==0)
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
	public static AdminPayment GetAdminDetails(int AdminId)
	{
		try(
			Connection con=JDBCConnection.getConnection();
				PreparedStatement pstmt=con.prepareStatement(" select * from admin join adminpayment on (admin.AdminId = adminpayment.AdminId) where admin.adminId=?");	
			)
		{
			pstmt.setInt(1,AdminId);
			ResultSet rs=pstmt.executeQuery();
			AdminPayment a = new AdminPayment();
			while(rs.next())
			{
						a.setAdminId(rs.getInt("AdminId"));
						a.setAdminName(rs.getString("AdminName"));
						SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
//					   System.out.println("fsdgsgksjdggnkjdngsjdnflandlgjnaljnldn");
					
					   String strDate = formatter.format(rs.getDate("DOB"));  
//					   System.out.println(rs.getDate("DOB"));
						
					   a.setDOB(strDate);
					    a.setEmail(rs.getString("email"));
					    a.setPassword(rs.getString("password"));
					    a.setPhone(rs.getString("phone"));
					    a.setGender(rs.getString("gender"));
					    a.setAddress(rs.getString("address"));
						a.setAccountNo(rs.getString("AccountNo"));
						a.setAccountName(rs.getString("Accountname"));
						a.setBankName(rs.getString("BankName"));
				}
			
			if(a.getAdminId()==0)
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

	public static boolean UpdateAdminTable(AdminPayment a) 
	{
		try (
				Connection con = JDBCConnection.getConnection();
				PreparedStatement pstmt = con
						.prepareStatement("update admin set  AdminName=? ,  DOB=? , password=? , Gender=? , Address=? where adminId = ?");
			
				) 
		{
			
			pstmt.setString(1,a.getAdminName());
			pstmt.setString(2,a.getDOB());
			pstmt.setString(3, a.getPassword());
			pstmt.setString(4, a.getGender());
			pstmt.setString(5, a.getAddress());
			pstmt.setInt(6, a.getAdminId());
			
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

	public static boolean UpdateAdminPaymentTable(AdminPayment a) 
	{

		try (
				Connection con = JDBCConnection.getConnection();
				PreparedStatement pstmt = con
						.prepareStatement("update  adminpayment set AccountNo = ? , Bankname = ? , AccountName = ? where  AdminId = ?");
				) 
		{
			
			pstmt.setString(1,a.getAccountNo());
			pstmt.setString(2,a.getBankName());
			pstmt.setString(3, a.getAccountName());
			pstmt.setInt(4, a.getAdminId());
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
	
}
