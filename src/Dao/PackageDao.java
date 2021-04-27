package Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

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

public static ArrayList<Package> getAllPackageOfAdminId(int adminId) {
		
		try(
				
				Connection con=JDBCConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("select * from package where adminId=? order by packageId asc");
				)
		{
			pstmt.setInt(1,adminId);
			ResultSet rs=pstmt.executeQuery();
			
			ArrayList<Package>  alPack =new ArrayList<Package>();
			Package p =null;
//			System.out.println(",ashfkashbgkasfgbkaushgalsfglsfgbasfgh");
			int flag=0;
			while(rs.next())
			{
				flag=1;
//				System.out.println("safgasfgafsgsfdsdghaksfjghkasghkasghkasyg");
				 p = new Package();

			
				p.setPackageId(rs.getInt("Packageid"));
				p.setNoOfTicketsAvailable(rs.getInt("TicketsAvailable"));
				p.setCountry(rs.getString("country"));
				p.setPeriod_days(rs.getInt("PeriodDay"));
				
				alPack.add(p);
				
			}
			if(flag==0)
			{
				alPack = null;
			}
			return alPack;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		return null;
	}

public static ArrayList<Package> getAllPackageOfAdminId() {
	
	try(
			
			Connection con=JDBCConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from package");
			)
	{
//		pstmt.setInt(1,adminId);
		ResultSet rs=pstmt.executeQuery();
		
		ArrayList<Package>  alPack =new ArrayList<Package>();
		Package p ;
		while(rs.next())
		{
			 p = new Package();


			p.setPackageId(rs.getInt("Packageid"));
			p.setNoOfTicketsAvailable(rs.getInt("TicketsAvailable"));
			p.setCountry(rs.getString("country"));
			p.setPeriod_days(rs.getInt("PeriodDay"));
			
			alPack.add(p);
			
		}
		return alPack;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		
	}
	return null;
}
public static ArrayList<Package> getAllPackageOfCountry(String country) {
	
	try(
			
			Connection con=JDBCConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from package where country =? ");
			)
	{
		pstmt.setString(1,country);
		ResultSet rs=pstmt.executeQuery();
		
		ArrayList<Package>  alPack =new ArrayList<Package>();
		Package p ;
		while(rs.next())
		{
			 p = new Package();


			p.setPackageId(rs.getInt("Packageid"));
			p.setNoOfTicketsAvailable(rs.getInt("TicketsAvailable"));
			p.setCountry(rs.getString("country"));
			p.setPeriod_days(rs.getInt("PeriodDay"));
			
			alPack.add(p);
			
		}
		return alPack;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		
	}
	return null;
}
public static ArrayList<Package> getAllPackageOfModeofTransportation(int mot) {
	
	try(
			
			Connection con=JDBCConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from package where country =? ");
			)
	{
		pstmt.setInt(1,mot);
		ResultSet rs=pstmt.executeQuery();
		
		ArrayList<Package>  alPack =new ArrayList<Package>();
		Package p ;
		while(rs.next())
		{
			 p = new Package();


			p.setPackageId(rs.getInt("Packageid"));
			p.setNoOfTicketsAvailable(rs.getInt("TicketsAvailable"));
			p.setCountry(rs.getString("country"));
			p.setPeriod_days(rs.getInt("PeriodDay"));
			
			alPack.add(p);
			
		}
		return alPack;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		
	}
	return null;
}
public static ArrayList<Package> getAllPackageOfTicketAvailable() {
	
	try(
			
			Connection con=JDBCConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from package where TicketsAvailable > 0 ");
			)
	{
//		pstmt.setInt(1,);
		ResultSet rs=pstmt.executeQuery();
		
		ArrayList<Package>  alPack =new ArrayList<Package>();
		Package p ;
		while(rs.next())
		{
			 p = new Package();


			p.setPackageId(rs.getInt("Packageid"));
			p.setNoOfTicketsAvailable(rs.getInt("TicketsAvailable"));
			p.setCountry(rs.getString("country"));
			p.setPeriod_days(rs.getInt("PeriodDay"));
			
			alPack.add(p);
			
		}
		return alPack;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		
	}
	return null;
}


	public static void DeleteSpecificPackage(int packageID) 
	{
		int b = 0;
		int a = 0;
		a=Dao.transportationDao.DeleteSpecificTransportation(packageID);
		if(a==1)
		{
		 b= Dao.HotelDao.DeleteSpecificHotel(packageID);
		}
		if(a==1 && b==1)
		{
				try(
						Connection con=JDBCConnection.getConnection();
						PreparedStatement pstmt = con.prepareStatement("delete from package where packageId=?;");
					)
				{
					pstmt.setInt(1,packageID);
					int i = pstmt.executeUpdate();
					if(i==1)
					{
						System.out.println("\n\t\t\t\tPacakge deleted Sucessfully !!");	
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
		}
		else
		{
			System.out.println("Data is not deleted please try again !!");
		}
	}

	public static Package getPacakgeFromPackageID(int pId) 
	{
		
		try (
				Connection con = JDBCConnection.getConnection();
				PreparedStatement pstmt = con
						.prepareStatement("select * from package where packageId=?");
			) 
		{	
			//int adminId=AdminDao.getAdminFromEmailAndPass(email, password);
			Package a =new Package();
			pstmt.setInt(1, pId);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next())
		{
			a.setNoOfTicketsAvailable(rs.getInt("ticketsAvailable"));
			a.setCountry(rs.getString("country"));
			a.setPeriod_days(rs.getInt("PeriodDay"));
		}
				
		return a;	
			
	} 
		catch (Exception e) {
			e.printStackTrace();
		}
	return null;	
	}	


	public static boolean UpdatePackageDetailsSql(Transportation t,int packageId)
	{
		
		try(
				Connection con=JDBCConnection.getConnection();
				PreparedStatement pstmt1=con.prepareStatement("update package set TicketsAvailable=? ,  Country=?   ,  PeriodDay=?  where packageId=?");
			)
		{
			pstmt1.setInt(1,t.getNoOfTicketsAvailable());
			pstmt1.setString(2, t.getCountry());
			pstmt1.setInt(3,t.getPeriod_days());
			pstmt1.setInt(4,packageId);
			
			
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
	
	
	

	public static void UpdateTicketsFromPackage(int noOfTicekts,int packageId)
	{
		try(
				Connection con=JDBCConnection.getConnection();
				PreparedStatement pstmt1=con.prepareStatement("update package set TicketsAvailable=TicketsAvailable-?   where packageId=?");
			)
		{
			
			pstmt1.setInt(1,noOfTicekts);
			pstmt1.setInt(2,packageId);
			
			int i=pstmt1.executeUpdate();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
