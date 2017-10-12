package serveWay.models;

public class AddVO {
	private int add_no;
	private String add_name;
	private float add_cal;
	private int add_price;
	private int add_type_no;
	
	public int getAdd_no() {
		return add_no;
	}
	public void setAdd_no(int add_no) {
		this.add_no = add_no;
	}
	public String getAdd_name() {
		return add_name;
	}
	public void setAdd_name(String add_name) {
		this.add_name = add_name;
	}
	public float getAdd_cal() {
		return add_cal;
	}
	public void setAdd_cal(float add_cal) {
		this.add_cal = add_cal;
	}
	public int getAdd_price() {
		return add_price;
	}
	public void setAdd_price(int add_price) {
		this.add_price = add_price;
	}
	public int getAdd_type_no() {
		return add_type_no;
	}
	public void setAdd_type_no(int add_type_no) {
		this.add_type_no = add_type_no;
	}
	
	@Override
	public String toString() {
		return "AddVO [add_no=" + add_no + ", add_name=" + add_name + ", add_cal=" + add_cal + ", add_price="
				+ add_price + ", add_type_no=" + add_type_no + "]";
	}
	
	
}
