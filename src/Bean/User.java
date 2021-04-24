package Bean;

public class User  implements PersonDataInterface
{
	String dob = "";
	 String email="";
	 String phone="";
	 String password="";
	 String Gender="";
	 String Address="";
	 int Booktickets;

	 public int getBooktickets() {
		return Booktickets;
	}

	public void setBooktickets(int booktickets) {
		Booktickets = booktickets;
	}

	int UserId;
	 String UserName;
	
	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}


	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	@Override
	public String getEmail() {
		return email;
	}
	@Override
	public void setEmail(String email) 
	{
		this.email=email;
	}
	@Override
	public String getPhone() {
		// TODO Auto-generated method stub
		return phone;
	}
	@Override
	public void setPhone(String phone) 
	{
		this.phone=phone;
	}
	@Override
	public String getGender() {
		return Gender;
		}
	@Override
	public void setGender(String gender) {
		this.Gender=gender;
	}
	@Override
	public String getAddress() {
		return Address;
	}
	@Override
	public void setAddress(String address) {
		this.Address=address;
	}

	public void setPassword(String password) {
		// TODO Auto-generated method stub
		this.password=password;
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}
}