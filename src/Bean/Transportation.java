package Bean;

public class Transportation extends Package
{
	int transportId;
	public int getTransportId() {
		return transportId;
	}
	public void setTransportId(int transportId) {
		this.transportId = transportId;
	}
	int modeOfTransportation;
	String arivalDate;
	String departureDate;
	float price;
	
	public int getModeOfTransportation() {
		return modeOfTransportation;
	}
	public void setModeOfTransportation(int modeOfTransportation) {
		this.modeOfTransportation = modeOfTransportation;
	}
	public String getArivalDate() {
		return arivalDate;
	}
	public void setArivalDate(String arivalDate) {
		this.arivalDate = arivalDate;
	}
	public String getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
}
