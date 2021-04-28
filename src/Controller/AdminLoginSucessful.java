package Controller;

import java.util.ArrayList;
import java.util.Scanner;

import Bean.AdminPayment;
import Bean.Hotel;
import Bean.Package;
import Bean.Transportation;
import Bean.User;
import Bean.UserPackage;
import Bean.UserPayment;
import Dao.PackageDao;
import Dao.UserDao;

public class AdminLoginSucessful 
{
	public static void AdminLoginSucessfulMethod(AdminPayment a)
	{
	
		Scanner sc=new Scanner(System.in);
		WhileLoop: while(true)
		{
			try
			{
					System.out.println("\n\t\t1--------create Package");				/////////////////DONE
					System.out.println("\t\t2--------Edit/Update Package");				////////////////Done
					System.out.println("\t\t3--------Remove Package");					///////////////// DONE	
					System.out.println("\t\t4--------View My Details");				///////////////////////DONE
					System.out.println("\t\t5--------View My Customers");			
					System.out.println("\t\t6--------View My Packages");			////////////////////////DONE
					System.out.println("\t\t7--------Update My details");			//////////////////////Done
					System.out.println("\t\t8--------Go Back");
					System.out.print("\t\tEnter Your choice :");
					int choice;
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
							boolean b =PackageDetails.PackageDetailsData(a.getAdminId());
							if(b==true)
							{
								System.out.println("\n\t\t\t\tPackage Sucessfully enterd into database  !!");
							}
						break;
					case 2:
						
						ArrayList<Bean.Package> ppp = Dao.PackageDao.getAllPackageOfAdminId(a.getAdminId());
						if(ppp.size()!=0)
						{
										System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
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
												System.out.printf("%-12sPricePErNight","");
												System.out.printf("%-12sTotal Price","");
												System.out.printf("%-12sHotelAddress","");
												System.out.println("\n------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
										for(Bean.Package p1 : ppp)
										{
											Transportation t =Dao.transportationDao.getTransportationDetailOfPackage(p1.getPackageId()); 	
											Hotel h =Dao.HotelDao.getHotelDetailOfPackage(p1.getPackageId());
											System.out.printf("%6s%19s%29s%19s%25s%33s%20s%20s%25s%17s%23s%20s%24s%24s%20s%n",p1.getPackageId(),p1.getNoOfTicketsAvailable(),p1.getCountry(),p1.getPeriod_days(),t.getModeOfTransportation(),t.getArivalDate(),t.getDepartureDate(),t.getPrice(),h.getName(),h.getStarType(),h.getChceckinDate(),h.getChceckoutDate(),h.getPricePerNight(),h.getTotalPrice(),h.getAddress());
											}
										System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
										System.out.print("\n\t\t\tEnter PackageId from table which you want to edit : ");
										int EditId;
										ch=sc.next();
										try
										{
										 EditId=Integer.parseInt(ch);
										}
										catch(NumberFormatException e)
										{
											IndexClass.CatchBlockStatement();
											continue;
										}
										boolean ans = PackageDetails.PackageDetailsData(a.getAdminId(),EditId);
						}
						else
						{
							System.out.println("\n\t\t\tno package available to Edit !!!!");
						}
				
						break;
					case 3:

						ArrayList<Bean.Package> pp = Dao.PackageDao.getAllPackageOfAdminId(a.getAdminId());
						ArrayList<Integer> ar=new ArrayList<Integer>();
						if(pp.size()!=0)
						{
										System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
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
												System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
										for(Bean.Package p1 : pp)
										{
											ar.add(p1.getPackageId());
											Transportation t =Dao.transportationDao.getTransportationDetailOfPackage(p1.getPackageId()); 	
											Hotel h =Dao.HotelDao.getHotelDetailOfPackage(p1.getPackageId());
											System.out.printf("%6s%19s%29s%19s%25s%33s%20s%20s%25s%17s%23s%20s%20s%24s%25s%n",p1.getPackageId(),p1.getNoOfTicketsAvailable(),p1.getCountry(),p1.getPeriod_days(),t.getModeOfTransportation(),t.getArivalDate(),t.getDepartureDate(),t.getPrice(),h.getName(),h.getStarType(),h.getChceckinDate(),h.getChceckoutDate(),h.getPricePerNight(),h.getTotalPrice(),h.getAddress());
										}
										System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
						
										System.out.print("\t\t\tEnter package id from Above list which you want to delete : ");
										int PackageID;
										ch=sc.next();
										try
										{
										 PackageID=Integer.parseInt(ch);
										}
										catch(NumberFormatException e)
										{
											IndexClass.CatchBlockStatement();
											continue;
										}
										int flag=0;
										for(int i : ar)
										{
											if(i==PackageID)
											{
												flag=1;
												break;
											}
										}
										if(flag==1)
										{
											Dao.PackageDao.DeleteSpecificPackage(PackageID);
													
										}
										else
										{
											System.out.println("\n\t\t\tPackage ID you entered is not in the Above List .... please enter from above list only");
										}
										
						
						}
						else
						{
							System.out.println("\n\t\t\tNo packages available to delete !!");
						}
						
								
								
					break;
					case 4:
								AdminPayment ap=Dao.AdminDao.GetAdminDetails(a.getAdminId());
								System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
								System.out.printf("%-12sAdminId","");
				
				//				--
								System.out.printf("%12sAdminName","");
								System.out.printf("%-12sDOB","");
								System.out.printf("%-12sEmail","");
								System.out.printf("%12sPassword","");
					//			--
								System.out.printf("%12sPhone","");
								System.out.printf("%-12sGender","");
								System.out.printf("%-12sAddress","");
								System.out.printf("%12sAccountno","");
								System.out.printf("%-12sAccountName","");
								System.out.printf("%-12sBankName","");
						System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
						System.out.printf("%17s%17s%20s%20s%20s%17s%12s%27s%15s%20s%20s%n",a.getAdminId(),ap.getAdminName(),ap.getDOB(),ap.getEmail(),ap.getPassword(),ap.getPhone(),ap.getGender(),ap.getAddress(),ap.getAccountNo(),ap.getAccountName(),ap.getBankName());
						System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
						
											
		
						break;
					case 5:
						ArrayList<Package> packages=PackageDao.getAllPackageOfAdminId(a.getAdminId());
		//				System.out.println("\n"+packages.size()+"  --> "+packages==null);
						if( packages!=null)
						{
							int i=0;
							for(Package p : packages)
							{
								
								ArrayList<UserPackage> userpackages = UserDao.getAllUserPackageDetailbyPackageId(p.getPackageId());
								if(userpackages!=null)
								{
										if(i==0)
										{
										System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
											//						---------------------------------------
											System.out.printf("%-12sPacakgeId","");
											
											//				--
											System.out.printf("%12sName","");
											System.out.printf("%-12sDOB","");
											System.out.printf("%-12sEmail","");
											//--
											System.out.printf("%12sPhone","");
											System.out.printf("%-12sGender","");
											System.out.printf("%-12sAddress","");
											
											System.out.printf("%-12sAccountName","");
											System.out.printf("%-12sBankName","");
											System.out.printf("%-12sNoOfTicket","");
											System.out.printf("%-12stotalPrice","");
											
											System.out.println("\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
											i++;
										}
									for(UserPackage up : userpackages)
									{
										User u = UserDao.GetUserDetails(up.getUserId());
										UserPayment upay = UserDao.GetUserDetails(up.getUserId());
										System.out.printf("%17s%17s%20s%20s%17s%10s%23s%22s%19s%21s%24s%n",p.getPackageId(),u.getUserName(),u.getDob(),u.getEmail(),u.getPhone(),u.getGender(),u.getAddress(),upay.getAccountName(),upay.getBankName(),up.getNoofticket(),up.getTotalprice());
									}
								}
								else
								{
									System.out.println("\n\t\t\tNo customers Found !!");
								}
									
							}
													
						}
						else
						{
							System.out.println("\n\t\t\tYou dont have any packaage , NO users !!");
						}
						break;
					case 6:
							ArrayList<Bean.Package> p = Dao.PackageDao.getAllPackageOfAdminId(a.getAdminId());
							if(p.size()!=0)
							{
											System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------"
													+ "");
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
													System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
											for(Bean.Package p1 : p)
											{
													Transportation t =Dao.transportationDao.getTransportationDetailOfPackage(p1.getPackageId()); 	
													Hotel h =Dao.HotelDao.getHotelDetailOfPackage(p1.getPackageId());
													System.out.printf("%6s%19s%29s%19s%25s%33s%20s%20s%25s%17s%23s%20s%20s%20s%30s%n",p1.getPackageId(),p1.getNoOfTicketsAvailable(),p1.getCountry(),p1.getPeriod_days(),t.getModeOfTransportation(),t.getArivalDate(),t.getDepartureDate(),t.getPrice(),h.getName(),h.getStarType(),h.getChceckinDate(),h.getChceckoutDate(),h.getPricePerNight(),h.getTotalPrice(),h.getAddress());
												}
											System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
							}
							else
							{
								System.out.println("\n\t\t\tYou dont have any packages available please create it   !!!");
							}
						break;	
					case 7:
						AdminEnterDetail aed =new AdminEnterDetail();
						 aed.AdminEnterDetail(a.getAdminId());
						break;
					case 8:
						break WhileLoop;
					default :	System.out.println("\n\t\t\tWrong choice entered");
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

	public static void main(String[] args) {
		AdminPayment a =new AdminPayment();
		a.setAdminId(15);
		AdminLoginSucessful.AdminLoginSucessfulMethod(a);
	}
}