package serveWay.models;

import java.util.List;

public interface OrderDAO {

	public List<TypeVO> selectType() throws Exception;
	public List<FoodVO> selectFood1() throws Exception;
	public List<FoodVO> selectFood() throws Exception;
	public List<FoodVO> selectFood2() throws Exception;
	public List<MaterialVO> selectMaterial(MaterialType material_type_no) throws Exception;
	public List<AddVO> selectAdd(AddType add_type_no) throws Exception;
	
	public void insertOrder(Order_detailVO order_detailVO) throws Exception;
	public List<MaterialVO> selectMaterials(Order_detailVO order_detailVO) throws Exception;
	public List<AddVO> selectAdditions(Order_detailVO order_detailVO) throws Exception;
	public FoodVO selectFood_NAME(int food_f_no) throws Exception;
	public void insertOrderList(Order_detailVO order_detailVO) throws Exception;
	public void insertOrderAdd(Order_detailVO order_detailVO) throws Exception;
	public void insertOrderMaterial(Order_detailVO order_detailVO) throws Exception;
	public int selectOrderNum(Order_detailVO order_detailVO) throws Exception;
	public int selectFood_cal(Order_detailVO order_detailVO) throws Exception;
	public int selectFood_price(Order_detailVO order_detailVO) throws Exception;
	public int addPrice(int object) throws Exception;
	public int addCal(int material_no) throws Exception;
	public int addCalorie(int add_no) throws Exception;
	public int subCal(int material_no) throws Exception;

	
}
