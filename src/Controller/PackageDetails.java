package Controller;

import java.util.Scanner;

import Bean.Hotel;
import Bean.Transportation;
//import Bean.Trtportation;

public class PackageDetails 
{
	public void PackageDetailsData()
	{
		Scanner sc=new Scanner(System.in);
		
		

		System.out.print("Enter Admin EmailId : ");
		String adminEmail=sc.next();
		System.out.print("Enter Admin Password : ");
		String adminPassword=sc.next();
		
		
		System.out.println("Enter Country  : ");          //
		String Country=sc.next();
		System.out.println("Enter No of Days  : ");          //
		int noOfDays=sc.nextInt();
		System.out.println("Enter No of People  : ");          //
		int noOfPeople=sc.nextInt();
		System.out.println("No of Tickets Available : ");          //
		int ticketsAvailable=sc.nextInt();

		Transportation t=new Transportation();
		
		
		// country noOfPeople noOfDays  ticketsAvailable
		t.setNoOfTicketsAvailable(ticketsAvailable);
		t.setCountry(Country);
		t.setNoOfPeople(noOfPeople);
		//t.setPackageId(noOfPeople);
		t.setPeriod_days(noOfDays);
	
		
		System.out.println("Enter Mode Of Transportation : ");
		int modeOfTrtportation=sc.nextInt();
		System.out.println("Enter Arrival_Date (YYYY-MM-DD): ");
		String ArrivalDate=sc.next();
		System.out.println("Enter Departure_Date (YYYY-MM-DD) : ");
		String DepartureDate=sc.next();
		System.out.println("Enter Price : ");
		float price=sc.nextFloat();
		
		
		t.setArivalDate(ArrivalDate);
		t.setDepartureDate(DepartureDate);
		t.setModeOfTransportation(modeOfTrtportation);
		t.setPrice(price);
		
		
		System.out.println("Enter Hotel Name : ");
		String Hotelname=sc.next();
		System.out.println("Enter Star Type : ");
		int StarType=sc.nextInt();
		System.out.println("Enter CheckIn : ");
		String CheckIn=sc.next();
		System.out.println("Enter CheckOut : ");
		String CheckOut=sc.next();
		System.out.println("Enter Address : ");
		String Address=sc.next();
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
	Dao.PackageDao.setPackageTable(t, adminEmail, adminPassword);
//	System.out.println(t.getPackageId());
	Dao.transportationDao.setTransportationDetailsSql(t,t.getPackageId());
	System.out.println("----------------------Hurrre--------------------");
	
	
	Dao.HotelDao.setHotelDetailsSql(h,t.getPackageId());
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
	public static void main(String[] args) {
		PackageDetails p=new PackageDetails();
		p.PackageDetailsData();
	}
}