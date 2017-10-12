package serveWay.models;

import java.util.Date;
import java.util.List;

public class Order_detailVO {
	private int order_num;
	private int type_type_no;
	private int food_f_no;
	private String request_msg;
	private int price;
	private float total_cal;
	private Date date;
	private int customer_id;
	
	private List<Integer> materials;
	private List<Integer> adds;
	
	public int getOrder_num() {
		return order_num;
	}
	public void setOrder_num(int order_num) {
		this.order_num = order_num;
	}
	public int getType_type_no() {
		return type_type_no;
	}
	public void setType_type_no(int type_type_no) {
		this.type_type_no = type_type_no;
	}
	public int getFood_f_no() {
		return food_f_no;
	}
	public void setFood_f_no(int food_f_no) {
		this.food_f_no = food_f_no;
	}
	public String getRequest_msg() {
		return request_msg;
	}
	public void setRequest_msg(String request_msg) {
		this.request_msg = request_msg;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public float getTotal_cal() {
		return total_cal;
	}
	public void setTotal_cal(float total_cal) {
		this.total_cal = total_cal;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public List<Integer> getMaterials() {
		return materials;
	}
	public void setMaterials(List<Integer> materials) {
		this.materials = materials;
	}
	public List<Integer> getAdds() {
		return adds;
	}
	public void setAdds(List<Integer> adds) {
		this.adds = adds;
	}
	@Override
	public String toString() {
		final int maxLen = 10;
		return "Order_detailVO [order_num=" + order_num + ", type_type_no=" + type_type_no + ", food_f_no=" + food_f_no
				+ ", request_msg=" + request_msg + ", price=" + price + ", total_cal=" + total_cal + ", date=" + date
				+ ", customer_id=" + customer_id + ", materials="
				+ (materials != null ? materials.subList(0, Math.min(materials.size(), maxLen)) : null) + ", adds="
				+ (adds != null ? adds.subList(0, Math.min(adds.size(), maxLen)) : null) + "]";
	}
	
	

}
