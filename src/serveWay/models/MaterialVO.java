package serveWay.models;

public class MaterialVO {
	private int material_no;
	private String material_name;
	private String material_exp;
	private float material_cal;
	private int material_type_no;
	public int getMaterial_no() {
		return material_no;
	}
	public void setMaterial_no(int material_no) {
		this.material_no = material_no;
	}
	public String getMaterial_name() {
		return material_name;
	}
	public void setMaterial_name(String material_name) {
		this.material_name = material_name;
	}
	public String getMaterial_exp() {
		return material_exp;
	}
	public void setMaterial_exp(String material_exp) {
		this.material_exp = material_exp;
	}
	public float getMaterial_cal() {
		return material_cal;
	}
	public void setMaterial_cal(float material_cal) {
		this.material_cal = material_cal;
	}
	public int getMaterial_type_no() {
		return material_type_no;
	}
	public void setMaterial_type_no(int material_type_no) {
		this.material_type_no = material_type_no;
	}
	@Override
	public String toString() {
		return "MaterialVO [material_no=" + material_no + ", material_name=" + material_name + ", material_exp="
				+ material_exp + ", material_cal=" + material_cal + ", material_type_no=" + material_type_no + "]";
	}
	
	
}
