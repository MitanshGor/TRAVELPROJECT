package Controller;


import java.util.ArrayList;
import java.util.Scanner;

import Bean.AdminPayment;
import Bean.Hotel;
import Bean.Package;
import Bean.Transportation;
import Bean.UserPackage;
import Bean.UserPayment;
import Dao.HotelDao;
import Dao.PackageDao;
import Dao.UserDao;
import Dao.transportationDao;

public class UserLoginSucessFull 
{
	public static void UserLoginSucessfulMethod(UserPayment a)
	{
		Scanner sc=new Scanner(System.in);
		
			UserWhile: while(true)
			{
				try
				{
						System.out.println("\n\t\t1-----------------Pacakge");
						System.out.println("\t\t2-----------------view my detail");
						System.out.println("\t\t3-----------------Update my detail");
						System.out.println("\t\t4-----------------My history packages");
						System.out.println("\t\t5-----------------My All transaction Total ");
						System.out.println("\t\t6-----------------Exit  User!");
						System.out.print("\t\tEnter your choice :");
						int choice ;
						String ch=sc.next();
						try
						{
						 choice=Integer.parseInt(ch);
						}
						catch(NumberFormatException e)
						{
							IndexClass.CatchBlockStatement();
							continue;
						}
						switch(choice)
						{
							case 1:
								System.out.println("\n\t\t\t1-----------------All Pacakges");
								System.out.println("\t\t\t2----------------Country");
								System.out.println("\t\t\t3-----------------Back");
								System.out.print("\t\t\tEnter your choice :");
				
								int subchoice;
								 ch=sc.next();
								try
								{
								 subchoice=Integer.parseInt(ch);
								}
								catch(NumberFormatException e)
								{
									IndexClass.CatchBlockStatement();
									continue;
								}
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
												
													System.out.print("\n\n\t\t\tWant to select any package ? (1 - yes | 2 - No) : ");
													int choose;
													ch=sc.next();
													try
													{
													 choose=Integer.parseInt(ch);
													}
													catch(NumberFormatException e)
													{
														IndexClass.CatchBlockStatement();
														continue;
													}
													if(choose==1)
													{
														System.out.print("\n\t\t\tEnter packageId from table which you  want to select : ");
														int packId;
														ch=sc.next();
														try
														{
														 packId=Integer.parseInt(ch);
														}
														catch(NumberFormatException e)
														{
															IndexClass.CatchBlockStatement();
															continue;
														}
														Package pack =PackageDao.getPacakgeFromPackageID(packId);
														
														if(pack!=null )
														{
															System.out.print("\t\t\tEnter no of tickets for the package : ");
															int noofTic;
															ch=sc.next();
															try
															{
															 noofTic=Integer.parseInt(ch);
															}
															catch(NumberFormatException e)
															{
																IndexClass.CatchBlockStatement();
																continue;
															}
															if(pack.getNoOfTicketsAvailable()>=noofTic && noofTic>0)
															{
																AddUserPackage.AddUserPackage(a.getUserId(), packId, noofTic);
															}
															else
															{
																if(noofTic<0)
																{
																	System.out.print("\n\t\t\t\t Number of tickets cannot be Negative  \n");
																}
																else
																{
																	System.out.print("\n\t\t\t\t Number of ticket("+noofTic+") is greater than Tickets available by Package("+pack.getNoOfTicketsAvailable()+")  \n");	
																}
															}
														}
														else
														{
															System.out.print("\n\t\t\t\t Invalid Package Id \n");
														}
													}
									}
									else
									{
										System.out.println("\n\t\t\t\tWe dont have any packages available !!!");
									}
									break;
								case 2:
									System.out.print("\t\t\t\tEnter country You want to search  for -");
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
													System.out.print("\n\n\t\t\tWant to select aany package ? (1 - yes | 2 - No) : ");
													int choose;
													ch=sc.next();
													try
													{
													 choose=Integer.parseInt(ch);
													}
													catch(NumberFormatException e)
													{
														IndexClass.CatchBlockStatement();
														continue;
													}
													if(choose==1)
													{
														System.out.print("\n\t\t\tEnter packageId from table which you  want to select : ");
														int packId;
														 ch=sc.next();
														try
														{
														 packId=Integer.parseInt(ch);
														}
														catch(NumberFormatException e)
														{
															IndexClass.CatchBlockStatement();
															continue;
														}
														System.out.print("\t\t\tEnter no of tickets for the package : ");
														int noofTic;
														ch=sc.next();
														try
														{
														 noofTic=Integer.parseInt(ch);
														}
														catch(NumberFormatException e)
														{
															IndexClass.CatchBlockStatement();
															continue;
														}
														AddUserPackage.AddUserPackage(a.getUserId(), packId, noofTic);
													}
									}
									else
									{
										System.out.println("\n\t\t\t\t\tWe dont have any packages available of "+country+" !!!");
									}
									break;
								default : System.out.println("\n\t\t\t\tInvalid choice !!!");
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
								ArrayList<UserPackage>  up=UserDao.getAllUserPackageDetail(a.getUserId());
								if(up!=null)
								{
									System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
									System.out.printf("%-12sCountry","");
					
									System.out.printf("%12sPeriodOfDays","");
									System.out.printf("%-12sModeOfTransportation","");
									System.out.printf("%-12sArrival","");
									System.out.printf("%12sDeparture","");
		
									System.out.printf("%12sTransportPrice","");
									System.out.printf("%-12sHotelName","");
									System.out.printf("%-12sHotelAddress","");
									System.out.printf("%12sCheckIn","");
									System.out.printf("%-12sCheckOut","");
									System.out.printf("%-12sHotelPrice","");
									System.out.printf("%-12sNoOfTicket","");
									System.out.printf("%-12sTotalPrice","");
									
							System.out.println("\n----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
												
									for(UserPackage u : up)
									{
		//								System.out.println("---------->"+u.getPackageId()+"\n");
										Package p = PackageDao.getPacakgeFromPackageID(u.getPackageId());
										Transportation t = transportationDao.getTransportationDetailOfPackage(u.getPackageId());
										Hotel h=HotelDao.getHotelFromPackageID(u.getPackageId());
										
										System.out.printf("%17s%23s%25s%31s%20s%23s%23s%23s%19s%20s%20s%22s%23s%n",p.getCountry(),p.getPeriod_days(),t.getModeOfTransportation(),t.getArivalDate(),t.getDepartureDate(),t.getPrice(),h.getName(),h.getAddress(),h.getChceckinDate(),h.getChceckoutDate(),h.getTotalPrice(),u.getNoofticket(),u.getTotalprice());
									}
									System.out.println("\n----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
														 
								}
								else
								{
									System.out.println("\n\t\t\tYou dont have any packages !!!");
								}
							break;
						case 5:
								int i = UserDao.getUsersTotalPriceAndName(a.getUserId());
								if(i>0)
								{
									System.out.println("\n\t\t\t"+a.getUserName() + " , You  have booked packges of worth " + i + "/. Rs .");
								}
								else
								{
									System.out.println("\n\t\t\t"+a.getUserName() + " , You  have not added any package to your cart !!");
								}
							break;
						case 6 :
							break UserWhile;
						}
			}
			catch(NumberFormatException e)
			{
				System.out.println("\n***************************************************");
				System.out.println("\t\tInvalid Input");
				System.out.println("***************************************************\n");
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