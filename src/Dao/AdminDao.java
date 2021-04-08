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
			System.out.println("productDao -> getAllProducts()");
			e.printStackTrace();
		}
		return false;
	}
	
	public static int getAdminFormEmailAndPass(String email,String password)
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
				System.out.println(rs.getInt("AdminId"));
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
			
			
			pstmt.setInt(1,a.getAccountNo());
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
			System.out.println("productDao -> getAllProducts()");
			e.printStackTrace();
		}
		return false;
				
	}
}
