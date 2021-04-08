package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import Bean.Package;
import Bean.Transportation;
import Util.JDBCConnection;

public class PackageDao {

	
	public static void setPackageTable(Transportation a,String email,String password)
	{
		try (
				Connection con = JDBCConnection.getConnection();
				PreparedStatement pstmt = con
						.prepareStatement("insert into package(TicketsAvailable,Country,noOfPeople,PeriodDay,AdminId) values(?,?,?,?,?)");
				PreparedStatement pstmt2 = con
						.prepareStatement(" select PackageId from package where AdminId=? order by packageID desc limit 1; ");
			) 
		{	
			int adminId=AdminDao.getAdminFormEmailAndPass(email, password);
			
			pstmt.setInt(1,a.getNoOfTicketsAvailable());
			pstmt.setString(2, a.getCountry());
			pstmt.setInt(3, a.getNoOfPeople());
			pstmt.setInt(4, a.getPeriod_days());
			pstmt.setInt(5, adminId);
			int i=pstmt.executeUpdate();
			
				
			pstmt2.setInt(1, adminId);
			ResultSet rs=pstmt2.executeQuery();
			while(rs.next())
			{
				a.setPackageId(rs.getInt("PackageId"));
			}
			
//			if (i == 0) {
//				return a;
//			} else {
//				return null;
//			}	
		} 
		catch (Exception e) {
			System.out.println("productDao -> getAllProducts()");
			e.printStackTrace();
		}
//		return null;
	}
	
}
