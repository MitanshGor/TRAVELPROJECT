package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import Bean.Hotel;
import Bean.Transportation;
import Util.JDBCConnection;

public class HotelDao {

	public static void setHotelDetailsSql(Hotel a, int packageId)
	{
		try(
				Connection con=JDBCConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("insert into hotel (Hotelname,startype,checkin,checkout,hotelAddress,pricePerNight,packageId,totalPrice) values (?,?,str_to_date(?,'%Y-%m-%d'),str_to_date(?,'%Y-%m-%d'),?,?,?,DATEDIFF(str_to_date(?,'%Y-%m-%d'), str_to_date(?,'%Y-%m-%d'))*?);");
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
			
			pstmt.setString(8,a.getChceckoutDate());
			pstmt.setString(9, a.getChceckinDate());
			pstmt.setFloat(10, a.getPricePerNight());
			
			
			int i=pstmt.executeUpdate();
		
			//System.out.println("------------>"+a.getPackageId());
			if(i==1)
			{
				pstmt2.setInt(1,packageId);
				ResultSet rs=pstmt2.executeQuery();
				while(rs.next()) 
				{
					//System.out.println("--------------->"+ rs.getInt("HotelId"));
				a.setHotelid(rs.getInt("HotelId"));
				}
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

	public static Hotel getHotelDetailOfPackage(int packageId) 
	{
			try(
					Connection con=JDBCConnection.getConnection();
					PreparedStatement pstmt=con.prepareStatement("select * from hotel where packageId=?");
					)
			{
				pstmt.setInt(1, packageId);
				
				Hotel t=new Hotel();
				ResultSet rs =pstmt.executeQuery();
				while(rs.next())
				{
					
					
					SimpleDateFormat givenDate = new SimpleDateFormat("yyyy-MM-dd");
					String cidate = givenDate.format(rs.getDate("checkin"));
					String codate = givenDate.format(rs.getDate("checkout"));
		
							t.setHotelid(rs.getInt("HotelId"));
							t.setName(rs.getString("HotelName"));
							t.setStarType(rs.getInt("starType"));
							t.setChceckinDate(cidate);
							t.setChceckoutDate(codate);
							t.setAddress(rs.getString("HotelAddress"));
							t.setTotalPrice(rs.getFloat("totalPrice"));
							t.setPricePerNight(rs.getFloat("pricePErNight"));
							
							
				}
				return t;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return null;
			}
	}
	
	public static int DeleteSpecificHotel(int packageID) 
	{
		try(
				Connection con=JDBCConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("delete from hotel where packageId=?;");
				)
		{
			pstmt.setInt(1,packageID);
			int i = pstmt.executeUpdate();
			return i;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}

	public static Hotel getHotelFromPackageID(int pId) 
	{
		try (
				Connection con = JDBCConnection.getConnection();
				PreparedStatement pstmt = con
						.prepareStatement("select * from hotel where packageId=?");
			) 
		{	
			//int adminId=AdminDao.getAdminFromEmailAndPass(email, password);
			Hotel a =new Hotel();
			pstmt.setInt(1, pId);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next())
		{
			SimpleDateFormat givenDate = new SimpleDateFormat("yyyy-mm-dd");
			
			
			String cidate = givenDate.format(rs.getDate("checkin"));
			String codate = givenDate.format(rs.getDate("checkout"));

			a.setName(rs.getString("HotelName"));
			a.setStarType(rs.getInt("starType"));
			a.setChceckinDate(cidate);
			a.setChceckoutDate(codate);
			a.setPricePerNight(rs.getFloat("pricePerNight"));
			a.setTotalPrice(rs.getFloat("totalPrice"));
			a.setAddress(rs.getString("HotelAddress"));
		}
				
		return a;	
			
	} 
		catch (Exception e) {
			e.printStackTrace();
		}
	return null;	
	}
	


	public static boolean UpdateHotelDetailsSql(Hotel t,int packageId)
	{
		try(
				Connection con=JDBCConnection.getConnection();
				PreparedStatement pstmt1=con.prepareStatement(
						"update hotel set  HotelName=? , "
						+ "startype=? , "
						+ "checkin=str_to_date(?,'%Y-%m-%d') , "
						+ "checkOut=str_to_date(?,'%Y-%m-%d') , "
						+ "HotelAddress=? , "
						+ "pricePerNight=? , "
						+ "totalPrice=DATEDIFF(str_to_date(?,'%Y-%m-%d'), str_to_date(?,'%Y-%m-%d'))*? where packageId=?");
			)
		{
			pstmt1.setString(1,t.getName());
			pstmt1.setInt(2, t.getStarType());
			pstmt1.setString(3,t.getChceckinDate());
			pstmt1.setString(4,t.getChceckoutDate());
			pstmt1.setString(5,t.getAddress());
			pstmt1.setDouble(6,t.getPricePerNight());
			
	
			pstmt1.setString(7,t.getChceckoutDate());
			pstmt1.setString(8, t.getChceckinDate());
			pstmt1.setFloat(9, t.getPricePerNight());
			
			pstmt1.setInt(10,packageId);
			
			
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
