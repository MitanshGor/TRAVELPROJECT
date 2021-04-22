package Controller;

import Bean.Hotel;
import Bean.Transportation;
import Dao.HotelDao;
import Dao.PackageDao;
import Dao.UserDao;
import Dao.transportationDao;

public class AddUserPackage {

	
	public static void AddUserPackage(int userId,int packageId , int noOftickets)
	{
		
		Hotel h  = HotelDao.getHotelFromPackageID(packageId);
		Transportation t = transportationDao.getTransportationFromPackageID(packageId);
		System.out.println("userId : " + userId);
//		System.out.println("h = " +h.getTotalPrice());
//		System.out.println("t = " +t.getPrice());
		float total =noOftickets*(h.getTotalPrice() + t.getPrice());
		
		int i=UserDao.getAllUserPackageDetail(userId, packageId);
		if(i==1)					/// detail aready exist so, just updateing it
		{
			boolean b= UserDao.UpdateUserPackagetable(total ,userId ,packageId ,noOftickets);
			if(b==false)
			{
				System.out.println("Booking is not confirmed please try again !!!!");
			}
			else
			{
				PackageDao.UpdateTicketsFromPackage(noOftickets,packageId);
				System.out.println("Booking is sucessfully confirmed .. thank you !!");
			}
		}
		else if(i==0)     ///// detail doesnot exist so inserting it
		{
			boolean b= UserDao.setUserPackagetable(total ,userId ,packageId ,noOftickets);
			if(b==false)
			{
				System.out.println("Booking is not confirmed please try again !!!!");
				
			}
			else
			{
				PackageDao.UpdateTicketsFromPackage(noOftickets,packageId);
				System.out.println("Booking is sucessfully confirmed .. thank you !!");
			}
		}
	}


}
