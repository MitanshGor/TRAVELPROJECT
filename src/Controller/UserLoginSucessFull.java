package Controller;


import java.util.ArrayList;
import java.util.Scanner;

import Bean.AdminPayment;
import Bean.Hotel;
import Bean.Package;
import Bean.Transportation;
import Bean.UserPayment;
import Dao.UserDao;

public class UserLoginSucessFull 
{
	public static void UserLoginSucessfulMethod(UserPayment a)
	{
			
				Scanner sc=new Scanner(System.in);
			while(true)
			{
				System.out.println("1-----------------Pacakge");
													//1-----All packages
													//1-----Country
													//1-----Modeof transportation
													//1-----TicketsAvailable
						
				System.out.println("2-----------------view my detail");
				System.out.println("3-----------------Update my detail");
				System.out.println("4-----------------My history packages");
				System.out.println("5-----------------My All transaction Total ");
				System.out.println("6-----------------Exit  User!");
				System.out.println("Enter your choice :");
				int choice = sc.nextInt();
				switch(choice)
				{
					case 1:
						System.out.println("1-----------------All Pacakges");
						System.out.println("2----------------Country");
						System.out.println("3-----------------Back");
						System.out.println("Enter your choice :");
		
						int subchoice=sc.nextInt();
						switch(subchoice)
						{
						case 1:
							ArrayList<Bean.Package> p=Dao.PackageDao.getAllPackageOfAdminId();
							if(p.size()!=0)
							{
											System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
													System.out.printf("PackageId%-10sTicketsAvailable","");
													System.out.printf("%12sCountry","");
													System.out.printf("%-12sPeriodOfDays","");
													
									//				--
													System.out.printf("%12sModeOFTransportation","");
													System.out.printf("%-12sArrivalDate","");
													System.out.printf("%-12sDepartureDate","");
													System.out.printf("%12sPrice","");
										//			--
													System.out.printf("%12sHotelName","");
													System.out.printf("%-12sStarType","");
													System.out.printf("%-12sCheckin","");
													System.out.printf("%12sCheckOut","");
													System.out.printf("%-12sPricePerNight","");
													System.out.printf("%-12sTotalPrice","");
													System.out.printf("%-12sHotelAddress","");
													System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
											for(Bean.Package p1 : p)
											{
													Transportation t =Dao.transportationDao.getTransportationDetailOfPackage(p1.getPackageId()); 	
													Hotel h =Dao.HotelDao.getHotelDetailOfPackage(p1.getPackageId());
													System.out.printf("%6s%19s%29s%19s%25s%33s%20s%20s%25s%17s%23s%20s%20s%20s%35s%n",p1.getPackageId(),p1.getNoOfTicketsAvailable(),p1.getCountry(),p1.getPeriod_days(),t.getModeOfTransportation(),t.getArivalDate(),t.getDepartureDate(),t.getPrice(),h.getName(),h.getStarType(),h.getChceckinDate(),h.getChceckoutDate(),h.getPricePerNight(),h.getTotalPrice(),h.getAddress());
												}
											System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
							}
							else
							{
								System.out.println("You dont have any packages available please create it   !!!");
							}
							break;
						case 2:
							System.out.println("Enter country You want to search  for -");
							String country=sc.next();
							ArrayList<Bean.Package> p2=Dao.PackageDao.getAllPackageOfCountry(country);
							if(p2.size()!=0)
							{
											System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
													System.out.printf("PackageId%-10sTicketsAvailable","");
													System.out.printf("%12sCountry","");
													System.out.printf("%-12sPeriodOfDays","");
													
									//				--
													System.out.printf("%12sModeOFTransportation","");
													System.out.printf("%-12sArrivalDate","");
													System.out.printf("%-12sDepartureDate","");
													System.out.printf("%12sPrice","");
										//			--
													System.out.printf("%12sHotelName","");
													System.out.printf("%-12sStarType","");
													System.out.printf("%-12sCheckin","");
													System.out.printf("%12sCheckOut","");
													System.out.printf("%-12sPricePerNight","");
													System.out.printf("%-12sTotalPrice","");
													System.out.printf("%-12sHotelAddress","");
													System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
											for(Bean.Package p1 : p2)
											{
													Transportation t =Dao.transportationDao.getTransportationDetailOfPackage(p1.getPackageId()); 	
													Hotel h =Dao.HotelDao.getHotelDetailOfPackage(p1.getPackageId());
													System.out.printf("%6s%19s%29s%19s%25s%33s%20s%20s%25s%17s%23s%20s%20s%20s%24s%n",p1.getPackageId(),p1.getNoOfTicketsAvailable(),p1.getCountry(),p1.getPeriod_days(),t.getModeOfTransportation(),t.getArivalDate(),t.getDepartureDate(),t.getPrice(),h.getName(),h.getStarType(),h.getChceckinDate(),h.getChceckoutDate(),h.getPricePerNight(),h.getTotalPrice(),h.getAddress());
												}
											System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
							}
							else
							{
								System.out.println("You dont have any packages available please create it   !!!");
							}
							break;
						case 3:
							break;
						default : System.out.println("Invalid choice !!!");
						}
						if(subchoice<=2)
						{
							System.out.println("Want to select aany package ? (1 - yes | 2 - No)");
							int choose=sc.nextInt();
							if(choose==1)
							{
								System.out.println("Enter packageId from table which you  want to select : ");
								int packId=sc.nextInt();
								System.out.println("Enter no of tickets for the package : ");
								int noofTic=sc.nextInt();
								AddUserPackage.AddUserPackage(a.getUserId(), packId, noofTic);
							}
						}
				break;
				case 2:
					
					UserPayment ap=Dao.UserDao.GetUserDetails(a.getUserId());
					System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
					System.out.printf("%-12sAdminId","");
	
					System.out.printf("%12sAdminName","");
					System.out.printf("%-12sDOB","");
					System.out.printf("%-12sEmail","");
					System.out.printf("%12sPassword","");

					System.out.printf("%12sPhone","");
					System.out.printf("%-12sGender","");
					System.out.printf("%-12sAddress","");
					System.out.printf("%12sAccountno","");
					System.out.printf("%-12sAccountName","");
					System.out.printf("%-12sBankName","");
			System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.printf("%17s%17s%20s%20s%20s%17s%12s%27s%15s%20s%20s%n",a.getUserId(),ap.getUserName(),ap.getDob(),ap.getEmail(),ap.getPassword(),ap.getPhone(),ap.getGender(),ap.getAddress(),ap.getAccountNo(),ap.getAccountName(),ap.getBankName());
			System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			
		
				break;
				case 3:
					UserEnterDetails aed =new UserEnterDetails();
					 aed.UserEnterDetail(a.getUserId());
					
					break;
				case 4:
					
					break;
				case 5:
						int i = UserDao.getUsersTotalPriceAndName(a.getUserId());
						if(i>0)
						{
							System.out.println(a.getUserName() + " , You  have invested " + i + " Rs in travelAgency .");
						}
						else
						{
							System.out.println(a.getUserName() + " , You  have added any package to your cart !!");
						}
					break;
			}
		}
	}	
	public static void main(String[] args) 
	{
		UserPayment a =new UserPayment();
		a.setUserId(3);
		a.setUserName("MitanshGor");
		UserLoginSucessFull.UserLoginSucessfulMethod(a);
	}
}
