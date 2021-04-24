package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import Bean.Package;
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

	public static Transportation getTransportationDetailOfPackage(int packageId) 
	{
		try(
				Connection con=JDBCConnection.getConnection();
				PreparedStatement pstmt=con.prepareStatement("select * from transportation where packageId=?");
				)
		{
			pstmt.setInt(1, packageId);
			
			Transportation t=new Transportation();
			ResultSet rs =pstmt.executeQuery();
			while(rs.next())
			{
				
				SimpleDateFormat givenDate = new SimpleDateFormat("yyyy-MM-dd");
				String adate = givenDate.format(rs.getDate("ArrivalDate"));
				String ddate = givenDate.format(rs.getDate("DeparturDate"));

						t.setTransportId(rs.getInt("TransportId"));
						t.setModeOfTransportation(rs.getInt("modeOftransportation"));
						t.setArivalDate(adate);
						t.setDepartureDate(ddate);
						t.setPrice(rs.getFloat("price"));
						t.setPackageId(packageId);
						
			}
			return t;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public static int DeleteSpecificTransportation(int packageID) {
		try(
				Connection con=JDBCConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("delete from transportation where packageId=?;");
				)
		{
			pstmt.setInt(1,packageID);
			int i = pstmt.executeUpdate();
//			System.out.println(i);
			return i;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}

	public static Transportation getTransportationFromPackageID(int pId) 
	{
				try (
						Connection con = JDBCConnection.getConnection();
						PreparedStatement pstmt = con
								.prepareStatement("select * from Transportation where packageId=?");
					) 
				{	
					//int adminId=AdminDao.getAdminFromEmailAndPass(email, password);
					Transportation a =new Transportation();
					pstmt.setInt(1, pId);
				ResultSet rs=pstmt.executeQuery();
				while(rs.next())
				{
					SimpleDateFormat givenDate = new SimpleDateFormat("yyyy-MM-dd");
					String adate = givenDate.format(rs.getDate("ArrivalDate"));
					String ddate = givenDate.format(rs.getDate("DeparturDate"));

					a.setModeOfTransportation(rs.getInt("modeOfTransportation"));
					a.setArivalDate(adate);
					a.setDepartureDate(ddate);
					a.setPrice(rs.getFloat("price"));
				}
						
				return a;	
					
			} 
				catch (Exception e) {
					e.printStackTrace();
				}
			return null;	
	}

	public static boolean UpdateTransportationDetailsSql(Transportation t,int packageId)
	{
		try(
				Connection con=JDBCConnection.getConnection();
				PreparedStatement pstmt1=con.prepareStatement("update transportation set modeOfTransportation=? , ArrivalDate=str_to_date(?,'%Y-%m-%d') , DeparturDate=str_to_date(?,'%Y-%m-%d') , price=? where packageId=?");
			)
		{
			pstmt1.setInt(1,t.getModeOfTransportation());
			pstmt1.setString(2, t.getArivalDate());
			pstmt1.setString(3,t.getDepartureDate());
			pstmt1.setDouble(4,t.getPrice());
			pstmt1.setInt(5,packageId);
				
			int i=pstmt1.executeUpdate();
			if(i==0)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
}

