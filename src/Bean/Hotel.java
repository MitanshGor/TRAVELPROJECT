package Bean;

public class Hotel extends Package
{
	int hotelid;
	public int getHotelid() {
		return hotelid;
	}

	public void setHotelid(int hotelid) {
		this.hotelid = hotelid;
	}

	String name;
	int StarType;
	String chceckinDate;
	String chceckoutDate;
	String address;
	float pricePerNight;
	float totalPrice;
	
	
	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getStarType() {
		return StarType;
	}
	
	public void setStarType(int starType) {
		StarType = starType;
	}
	
	public String getChceckinDate() {
		return chceckinDate;
	}
	
	public void setChceckinDate(String chceckinDate) {
		this.chceckinDate = chceckinDate;
	}
	
	public String getChceckoutDate() {
		return chceckoutDate;
	}
	
	public void setChceckoutDate(String chceckoutDate) {
		this.chceckoutDate = chceckoutDate;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public float getPricePerNight() {
		return pricePerNight;
	}
	
	public void setPricePerNight(float pricePerNight) {
		this.pricePerNight = pricePerNight;
	}
	
	

}
