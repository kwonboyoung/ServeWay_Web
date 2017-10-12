package serveWay.models;

public class CustomerVO {
	private double customer_id;
	private double pw;
	private String h_p;
	private String address;
	
	public double getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(double customer_id) {
		this.customer_id = customer_id;
	}
	public double getPw() {
		return pw;
	}
	public void setPw(double pw) {
		this.pw = pw;
	}
	public String getH_p() {
		return h_p;
	}
	public void setH_p(String h_p) {
		this.h_p = h_p;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "CustomerVO [customer_id=" + customer_id + ", pw=" + pw + ", h_p=" + h_p + ", address=" + address + "]";
	}
	
	
}
