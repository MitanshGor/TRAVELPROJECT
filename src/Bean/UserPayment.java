package Bean;

public class UserPayment extends User 
{
	String BankName;
	String AccountNo;
	String AccountName;
	Float Price;
	public String getBankName() {
		return BankName;
	}
	public void setBankName(String bankName) {
		BankName = bankName;
	}
	public String getAccountNo() {
		return AccountNo;
	}
	public void setAccountNo(String accountNo) {
		AccountNo = accountNo;
	}
	public String getAccountName() {
		return AccountName;
	}
	public void setAccountName(String accountName) {
		AccountName = accountName;
	}
	public Float getPrice() {
		return Price;
	}
	public void setPrice(Float price) {
		Price = price;
	}


}
