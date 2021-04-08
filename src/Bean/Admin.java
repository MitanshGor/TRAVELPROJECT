package Bean;

import java.util.Date;

public class Admin implements PersonDataInterface
{
	String DOB="";
	String email="";
	 String Password="" ;
	 String phone="";
	 String Gender="";
	 String Address="";
	 
	 int AdminId;
	 String AdminName;

		public String getDOB() {
			return DOB;
		}
		public void setDOB(String dOB) {
			this.DOB = dOB;
		}

	public int getAdminId() {
		return AdminId;
	}
	public void setAdminId(int adminId) {
		AdminId = adminId;
	}
	public String getAdminName() {
		return AdminName;
	}
	public void setAdminName(String adminName) {
		AdminName = adminName;
	}
	
	
	
	public void setPassword(String password) {
		Password=password;
	}

	public String getPassword() {
			return Password;
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
		// TODO Auto-generated method stub
		
	}

	
}
