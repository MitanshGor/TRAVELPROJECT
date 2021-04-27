package Filter;

import java.util.regex.Pattern;

import Bean.User;
import Bean.UserPayment;

public class UserDetailFilter {
	public static int validationUser(UserPayment a)
	{
		int empty=0;
		if(UserDetailFilter.checkString(a.getPassword())==false  || UserDetailFilter.checkStringAndNumberRegex(a.getPassword())==false)
		{
			System.out.println("\t\t\t\tInvalid  Password = "+a.getPassword());
					empty ++;
		}
		if(UserDetailFilter.checkString(a.getUserName())==false || UserDetailFilter.checkStringOnlyRegex(a.getUserName())==false)
		{
			System.out.println("\t\t\t\tInvalid  Username = "+a.getUserName());
			empty ++;
		}
		if(UserDetailFilter.checkString(a.getEmail())==false || UserDetailFilter.checkEmailRegex(a.getEmail())==false)
		{	System.out.println("\t\t\t\tInvalid  Email = "+a.getEmail());
		
			empty ++;
		}	
		if(UserDetailFilter.checkString(a.getDob())==false || UserDetailFilter.checkDate(a.getDob())==false)
		{	System.out.println("\t\t\t\tInvalid  DOB = " + a.getDob());
			empty ++;
		}
		if(UserDetailFilter.checkString(a.getPhone())==false || UserDetailFilter.checkMobileRegex(a.getPhone())==false)
		{	System.out.println("\t\t\t\tInvalid  Phone = " + a.getPhone());
		
			empty ++;
		}
		if(UserDetailFilter.checkString(a.getGender())==false || UserDetailFilter.checkGenderRegex(a.getGender())==false)
		{	System.out.println("\t\t\t\tInvalid  Gender = "+a.getGender());
		
			empty ++;
		}
		if(UserDetailFilter.checkString(a.getAddress())==false || UserDetailFilter.checkStringAndNumberRegex(a.getAddress().replaceAll("/", "\\"))==false)
		{
		System.out.println("\t\t\t\tInvalid Address = "+a.getAddress());
			empty ++;
		}
		if(UserDetailFilter.checkString(a.getBankName())==false || UserDetailFilter.checkStringOnlyRegex(a.getBankName())==false)
		{	System.out.println("\t\t\t\tInvalid  Bank name = "+a.getBankName());
		
			empty ++;
		}
		if(UserDetailFilter.checkString(a.getAccountNo())==false  || UserDetailFilter.checkStringAndNumberRegex(a.getAccountNo())==false)
		{
			System.out.println("\t\t\t\tInvalid  AccountNo = "+a.getAccountNo());
			empty ++;
		}
		if(UserDetailFilter.checkString(a.getAccountName())==false|| UserDetailFilter.checkStringOnlyRegex(a.getAccountName())==false )
		{	System.out.println("\t\t\t\tInvalid  Account nmae = "+a.getAccountName());
		
			empty ++;
		}
//		if(a.getBooktickets()<1)
//		{
//			System.out.println("\t\t\t\tInvalid Book Tickets = "+a.getBooktickets());
//			empty ++;
//		}
		return empty;
	}



	
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
	public static boolean checkEmailRegex(String s)
	{
		String regex="^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
		return Pattern.matches(regex,s);
	}	
		
	public static boolean checkMobileRegex(String s)
	{
		String regex="[0-9]{10}";
		return Pattern.matches(regex,s);
		
	}
	public static boolean checkGenderRegex(String s)
	{
		
		return s.toUpperCase().equals("M") || s.toUpperCase().equals("F");
		
	}
	public static void main(String[] args) {
		UserDetailFilter a=new UserDetailFilter();
		System.out.println(a.checkStringOnlyRegex("Mitansh"));
		System.out.println(a.checkString("Mitansh"));
	}
}
