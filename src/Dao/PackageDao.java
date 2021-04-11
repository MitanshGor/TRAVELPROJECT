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

	
	public static int setPackageTable(Transportation a ,int adminId)
	{
		try (
				Connection con = JDBCConnection.getConnection();
				PreparedStatement pstmt = con
						.prepareStatement("insert into package(TicketsAvailable,Country,PeriodDay,AdminId) values(?,?,?,?)");
				PreparedStatement pstmt2 = con
						.prepareStatement(" select PackageId from package where AdminId=? order by packageID desc limit 1; ");
			) 
		{	
			//int adminId=AdminDao.getAdminFromEmailAndPass(email, password);
			
			pstmt.setInt(1,a.getNoOfTicketsAvailable());
			pstmt.setString(2, a.getCountry());
			pstmt.setInt(3, a.getPeriod_days());
			pstmt.setInt(4, adminId);
			int i=pstmt.executeUpdate();
			
				
			pstmt2.setInt(1, adminId);
			ResultSet rs=pstmt2.executeQuery();
			while(rs.next())
			{
				a.setPackageId(rs.getInt("PackageId"));
				return  rs.getInt("PackageId");
			}
			
	} 
		catch (Exception e) {
			e.printStackTrace();
		}
	return 0;
	}	
}
