package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Bean.Hotel;
import Bean.Transportation;
import Util.JDBCConnection;

public class HotelDao {

	public static void setHotelDetailsSql(Hotel a, int packageId)
	{
		try(
				Connection con=JDBCConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("insert into hotel (Hotelname,startype,checkin,checkout,hotelAddress,pricePerNight,packageId) values (?,?,str_to_date(?,'%Y-%m-%d'),str_to_date(?,'%Y-%m-%d'),?,?,?);");
				PreparedStatement pstmt2 = con.prepareStatement("select hotelid from hotel where packageid=? ");
				)
		{
		
			pstmt.setString(1, a.getName());
			pstmt.setInt(2, a.getStarType());
			pstmt.setString(3, a.getChceckinDate());
			pstmt.setString(4, a.getChceckoutDate());
			pstmt.setString(5, a.getAddress());
			pstmt.setFloat(6, a.getPricePerNight());
			pstmt.setInt(7, packageId);
			int i=pstmt.executeUpdate();
		
			//System.out.println("------------>"+a.getPackageId());
			pstmt2.setInt(1,packageId);
			ResultSet rs=pstmt2.executeQuery();
			while(rs.next()) {
				//System.out.println("--------------->"+ rs.getInt("HotelId"));
			a.setHotelid(rs.getInt("HotelId"));
			}
//			if(i==0)
//			{
//				return null;
//			}
//			return a;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
//		return null;
	}

}
