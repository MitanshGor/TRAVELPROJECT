package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import Bean.User;
import Bean.UserPayment;
import Util.JDBCConnection;

public class UserDao {
	
	public static boolean setUserTable(User a) {


		try (
				Connection con = JDBCConnection.getConnection();
				PreparedStatement pstmt = con
						.prepareStatement("insert into user(UseName,DOB,email,password,phone,Gender,Address) values(?,?,?,?,?,?,?);");
				PreparedStatement pstmt2 = con
						.prepareStatement("select UserId from user where email='?' and password='?'; ");
			) 
		{
			
			
			pstmt.setString(1,a.getUserName());
			pstmt.setDate(2, (Date) new SimpleDateFormat("dd/MM/yyyy").parse(a.getDob()));
			pstmt.setString(3, a.getEmail());
			pstmt.setString(4, a.getPassword());
			pstmt.setString(5, a.getPhone());
			pstmt.setString(6, a.getGender());
			pstmt.setString(7, a.getAddress());
			// getting the Userid from table and storing it into User class (User)
			ResultSet rs=pstmt2.executeQuery();
			a.setUserId(rs.getInt("UserId"));
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
			System.out.println("productDao -> getAllProducts()");
			e.printStackTrace();
		}
		return false;		
	}
}