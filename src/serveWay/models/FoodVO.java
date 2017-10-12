package serveWay.models;

import java.util.Date;

public class FoodVO {
	private int f_no;
	private String f_name;
	private float f_cal;
	private String meat;
	private int price;
	private String nutrition;
	private String size;
	private String kind;
	
	public int getF_no() {
		return f_no;
	}
	public void setF_no(int f_no) {
		this.f_no = f_no;
	}
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public float getF_cal() {
		return f_cal;
	}
	public void setF_cal(float f_cal) {
		this.f_cal = f_cal;
	}
	public String getMeat() {
		return meat;
	}
	public void setMeat(String meat) {
		this.meat = meat;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getNutrition() {
		return nutrition;
	}
	public void setNutrition(String nutrition) {
		this.nutrition = nutrition;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	@Override
	public String toString() {
		return "FoodVO [f_no=" + f_no + ", f_name=" + f_name + ", f_cal=" + f_cal + ", meat=" + meat + ", price="
				+ price + ", nutrition=" + nutrition + ", size=" + size + ", kind=" + kind + "]";
	}
	
}
