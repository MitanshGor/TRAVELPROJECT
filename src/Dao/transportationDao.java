package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Bean.Transportation;
import Util.JDBCConnection;

public class transportationDao {

	
	public static Transportation setTransportationDetailsSql(Transportation a, int packageId)
	{
		try(
				Connection con=JDBCConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("insert into transportation (modeOfTransportation,ArrivalDate,DeparturDate,price,packageId) values (?,str_to_date(?,'%Y-%m-%d'),str_to_date(?,'%Y-%m-%d'),?,?);");
				PreparedStatement pstmt2 = con.prepareStatement("select TransportId from transportation where packageid=? ");
				)
		{
			pstmt.setInt(1, a.getModeOfTransportation());
			pstmt.setString(2, a.getArivalDate());
			pstmt.setString(3, a.getDepartureDate());
			pstmt.setFloat(4, a.getPrice());
			pstmt.setInt(5, packageId);
			int i=pstmt.executeUpdate();
		
			pstmt2.setInt(1,packageId);
			ResultSet rs=pstmt2.executeQuery();
			while(rs.next()) {
			a.setTransportId(rs.getInt("TransportId"));
			}
			if(i==0)
			{
				return null;
			}
			return a;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
