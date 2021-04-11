package Controller;

import java.util.Scanner;

import Bean.Hotel;
import Bean.Transportation;
//import Bean.Trtportation;

public class PackageDetails 
{
	public static boolean PackageDetailsData(int adminId)
	{
		Scanner sc=new Scanner(System.in);
		
		

		
		System.out.println("********************Package Details***************************\n");
		System.out.println("Enter Country  : ");          //
		String Country=sc.nextLine();
		System.out.println("Enter No of Days  : ");          //
		int noOfDays=sc.nextInt();
		System.out.println("No of Tickets Available : ");          //
		int ticketsAvailable=sc.nextInt();

		Transportation t=new Transportation();
		
		
		// country noOfPeople noOfDays  ticketsAvailable
		t.setNoOfTicketsAvailable(ticketsAvailable);
		t.setCountry(Country);
		//t.setPackageId(noOfPeople);
		t.setPeriod_days(noOfDays);
		System.out.println("********************USER Transportation***************************\n");
		
		System.out.println("Enter Mode Of Transportation (1---Bus | 2--Train | 3--Flight ) : ");
		int modeOfTrtportation=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Arrival_Date (YYYY-MM-DD): ");
		String ArrivalDate=sc.nextLine();
		System.out.println("Enter Departure_Date (YYYY-MM-DD) : ");
		String DepartureDate=sc.nextLine();
		System.out.println("Enter Price : ");
		float price=sc.nextFloat();
		
		
		t.setArivalDate(ArrivalDate);
		t.setDepartureDate(DepartureDate);
		t.setModeOfTransportation(modeOfTrtportation);
		t.setPrice(price);
		
		System.out.println("********************Enter Hotel***************************\n");
		System.out.println("Enter Star Type ( /5): ");
		int StarType=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Hotel Name : ");
		String Hotelname=sc.nextLine();
		System.out.println("Enter CheckIn (YYYY-MM-DD): ");
		String CheckIn=sc.nextLine();
		System.out.println("Enter CheckOut (YYYY-MM-DD): ");
		String CheckOut=sc.nextLine();
		System.out.println("Enter Address of Hotel : ");
		String Address=sc.nextLine();
		System.out.println("Enter Price per Night : ");
		float PricePerNight=sc.nextFloat();
		
		Hotel h=new Hotel();
		h.setPackageId(t.getPackageId());
		h.setName(Hotelname);
		h.setStarType(StarType);
		h.setChceckinDate(CheckIn);
		h.setChceckoutDate(CheckOut);
		h.setAddress(Address);
		h.setPricePerNight(PricePerNight);
		
//	Trtportation t=new Trtportation();
	
		
		

	
	sc.close();
	
	int n = Filter.PackageDetailFilter.ValidationPackage(t, h);
	if(n==0)
	{
		
		int packageId=Dao.PackageDao.setPackageTable(t, adminId);
		Dao.transportationDao.setTransportationDetailsSql(t,packageId);	
		Dao.HotelDao.setHotelDetailsSql(h,packageId);

		if(packageId==0)
		{
			System.out.println("Exception occoured !!!. Detail is not enetered into database");
			return false;
		}
		else
		{
			return true;
		}	
	}
	else
	{
		System.out.println(n+"/15 number of data were INVALID !!!....Please fill valid data");
		return false;	
	
	}
	//	System.out.println(t.getPackageId());
//	System.out.println(t.getNoOfTicketsAvailable());
//	System.out.println(t.getCountry());
//	System.out.println(t.getNoOfPeople());
//	System.out.println(t.getPeriod_days());
//	System.out.println(t.getTransportId());
//	System.out.println(t.getModeOfTransportation());
//	System.out.println(t.getArivalDate());
//	System.out.println(t.getDepartureDate());
//	System.out.println(t.getPrice());
	}
}