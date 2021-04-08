package Bean;

public class AdminPayment extends Admin
{
	private String BankName;
	private int AccountNo;
	private String AccountName;
	private float Price;
	
	public String getBankName() {
		return BankName;
	}
	public void setBankName(String bankName) {
		BankName = bankName;
	}
	public int getAccountNo() {
		return AccountNo;
	}
	public void setAccountNo(int accountNo) {
		AccountNo = accountNo;
	}
	public String getAccountName() {
		return AccountName;
	}
	public void setAccountName(String accountName) {
		AccountName = accountName;
	}
	public float getPrice() {
		return Price;
	}
	public void setPrice(float price) {
		Price = price;
	}
}



// insert into package () values();
// select packageid from package(); 

//