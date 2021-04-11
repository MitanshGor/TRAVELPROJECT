package Filter;

import java.util.regex.Pattern;

import Bean.Hotel;
import Bean.Transportation;

public class PackageDetailFilter 
{
		public static int ValidationPackage(Transportation t ,Hotel h)
		{
			int empty=0;
			
			if(PackageDetailFilter.checkString(t.getCountry())==false || PackageDetailFilter.checkStringOnlyRegex(t.getCountry())==false)
			{
				System.out.println("Invalid Country : "+t.getCountry());
				empty++;
			}
			if(t.getPeriod_days()==0 )
			{
				System.out.println("Invalid no of periods : "+t.getPeriod_days());
				empty++;
			}
			if(t.getNoOfPeople()==0 )
			{
				System.out.println("Invalid no of people : "+t.getNoOfPeople());
				empty++;
			}
			if(t.getNoOfTicketsAvailable()==0 )
			{
				System.out.println("Invalid no of tickets Available : "+t.getNoOfTicketsAvailable());
				empty++;
			}
			if(t.getModeOfTransportation()==0 || t.getModeOfTransportation()>3)
			{
				System.out.println("Invalid no of mode of transportaions : "+t.getModeOfTransportation());
				empty++;
			}
			if(PackageDetailFilter.checkString(t.getArivalDate())==false || PackageDetailFilter.checkDate(t.getArivalDate())==false)
			{
				System.out.println("Invalid Arrival Date : "+t.getArivalDate());
				empty++;
			}
			if(PackageDetailFilter.checkString(t.getDepartureDate())==false || PackageDetailFilter.checkDate(t.getDepartureDate())==false)
			{
				System.out.println("Invalid Departure Date : "+t.getDepartureDate());
				empty++;
			}
			if(t.getPrice()==0)
			{
				System.out.println("Invalid Price : "+t.getPrice());
				empty++;
			}
			if(PackageDetailFilter.checkString(h.getName())==false || PackageDetailFilter.checkStringOnlyRegex(h.getName())==false)
			{
				System.out.println("Invalid Hotel Name : "+h.getName());
				empty++;
			}
			if(h.getStarType()==0 || h.getStarType()>5)
			{
				System.out.println("Invalid no of Hotel stars : "+h.getStarType());
				empty++;
			}
			if(PackageDetailFilter.checkString(h.getChceckinDate())==false || PackageDetailFilter.checkDate(h.getChceckinDate())==false)
			{
				System.out.println("Invalid check in date : "+h.getChceckinDate());
				empty++;
			}
			if(PackageDetailFilter.checkString(h.getChceckoutDate())==false || PackageDetailFilter.checkDate(h.getChceckoutDate())==false)
			{
				System.out.println("Invalid check out date : "+h.getChceckoutDate());
				empty++;
			}
			if(PackageDetailFilter.checkString(h.getAddress())==false || PackageDetailFilter.checkStringAndNumberRegex(h.getAddress())==false)
			{
				System.out.println("Invalid address : "+h.getAddress());
				empty++;
			}
			if(h.getPricePerNight()==0)
			{
				System.out.println("Invalid Price per night : "+h.getPricePerNight());
				empty++;
			}
			return empty;
			
		}

		

//		REGEX PART AND VALIDATION PART
		
		
	public static boolean checkString(String s)
	{
		if(s.trim().length()==0 || s==null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	public static boolean checkStringOnlyRegex(String s)
	{
		String regex="[a-zA-Z ]+";	
		return Pattern.matches(regex,s)  ;
	}
	public static boolean checkStringAndNumberRegex(String s)
	{
		String regex="[ a-zA-Z0-9\\!@#$%^&*_-]+";	
		return Pattern.matches(regex,s)  ;
	}
	public static boolean checkDate(String s)			
	{
		String regex = 		"^((2000|2400|2800|(19|2[0-9](0[48]|[2468][048]|[13579][26])))-02-29)$" 
		+ "|^(((19|2[0-9])[0-9]{2})-02-(0[1-9]|1[0-9]|2[0-8]))$"
		+ "|^(((19|2[0-9])[0-9]{2})-(0[13578]|10|12)-(0[1-9]|[12][0-9]|3[01]))$" 
		+ "|^(((19|2[0-9])[0-9]{2})-(0[469]|11)-(0[1-9]|[12][0-9]|30))$";
		return Pattern.matches(regex, s);
	}	
}
