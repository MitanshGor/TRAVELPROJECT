package Bean;

public class Package 
{
	public int getAdminId() {
		return AdminId;
	}
	public void setAdminId(int adminId) {
		AdminId = adminId;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	
	
	int AdminId;
	int UserId;
	
	int PackageId;
	String Country;
	int Period_days;
	int noOfTicketsAvailable;


	

	
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
