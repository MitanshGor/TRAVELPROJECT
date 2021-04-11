package Bean;

public class Package 
{
	int PackageId;
	String Country;
	int Period_days;
	int noOfTicketsAvailable;
	
	String PackageName;
	
	public String getPackageName() 
	{
		return PackageName;
	}
	public void setPackageName(String packageName) 
	{
		PackageName = packageName;
	}


	
	
	public int getNoOfTicketsAvailable() {
		return noOfTicketsAvailable;
	}
	public void setNoOfTicketsAvailable(int noOfTicketsAvailable) {
		this.noOfTicketsAvailable = noOfTicketsAvailable;
	}
	public int getPackageId() 
	{
		return PackageId;
	}
	public void setPackageId(int packageId) 
	{
		PackageId = packageId;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public int getPeriod_days() {
		return Period_days;
	}
	public void setPeriod_days(int period_days) {
		Period_days = period_days;
	}
//	public int getNoOfPeople() {
//		return noOfPeople;
//	}
//	public void setNoOfPeople(int noOfPeople) {
//		this.noOfPeople = noOfPeople;
//	}
}
