package Filter;

import java.util.Scanner;
import java.util.regex.Pattern;

import Bean.AdminPayment;

public class AdminDetailFilter {

	
	public static int ValidationAdmin(AdminPayment a)
	{
		int empty=0;
//		int date=0;
		if(AdminDetailFilter.checkString(a.getAddress())==false || AdminDetailFilter.checkStringAndNumberRegex(a.getAddress().replaceAll("/", "\\")
				)==false)
		{
		System.out.println("\t\t\t\tInvalid Address = "+a.getAddress());
			empty ++;
		}
		if(AdminDetailFilter.checkString(a.getPassword())==false  || AdminDetailFilter.checkStringAndNumberRegex(a.getPassword())==false)
		{
			System.out.println("\t\t\t\tInvalid  Password = "+a.getPassword());
					empty ++;
		}
		if(AdminDetailFilter.checkString(a.getAdminName())==false  || AdminDetailFilter.checkStringOnlyRegex(a.getAdminName())==false)
		{
			System.out.println("\t\t\t\tInvalid  AdmiNname = "+a.getAdminName());
			empty ++;
		}
		
		if(AdminDetailFilter.checkString(a.getEmail())==false || AdminDetailFilter.checkEmailRegex(a.getEmail())==false)
		{	System.out.println("\t\t\t\tInvalid  Email = "+a.getEmail());
		
			empty ++;
		}
		if(AdminDetailFilter.checkString(a.getBankName())==false || AdminDetailFilter.checkStringOnlyRegex(a.getBankName())==false)
		{	System.out.println("\t\t\t\tInvalid  Bank name = "+a.getBankName());
		
			empty ++;
		}
		if(AdminDetailFilter.checkString(a.getAccountName())==false|| AdminDetailFilter.checkStringOnlyRegex(a.getAccountName())==false )
		{	System.out.println("\t\t\t\tInvalid  Account nmae = "+a.getAccountName());
		
			empty ++;
		}
										//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
										//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
										//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		if(AdminDetailFilter.checkString(a.getGender())==false || AdminDetailFilter.checkGenderRegex(a.getGender())==false)
		{	System.out.println("\t\t\t\tInvalid  Gender = "+a.getGender());
		
			empty ++;
		}
		if(AdminDetailFilter.checkString(a.getPhone())==false || AdminDetailFilter.checkMobileRegex(a.getPhone())==false)
		{	System.out.println("\t\t\t\tInvalid  Phone = " + a.getPhone());
		
			empty ++;
		}
		if(AdminDetailFilter.checkString(a.getDOB())==false || AdminDetailFilter.checkDate(a.getDOB())==false)
		{	System.out.println("\t\t\t\tInvalid  DOB = " + a.getDOB());
			empty ++;
		}
		
		if(AdminDetailFilter.checkStringAndNumberRegex(a.getAccountNo())==false && AdminDetailFilter.checkString(a.getAccountNo())==false)
		{	System.out.println("\t\t\t\tInvalid  Account number = " +a.getAccountNo());
		
			empty ++;
		}
		return empty;
	}
	
	
//											REGEX PART AND VALIDATION PART
	
	
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
		AdminDetailFilter a=new AdminDetailFilter();
		System.out.println(a.checkStringAndNumberRegex("34554"));
	}
}

