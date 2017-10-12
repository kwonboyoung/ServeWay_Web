package serveWay.models;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ibatis.sqlmap.client.SqlMapClient;

import serveWay.ibatis.QueryHandler;


public class OrderDAOImpl implements OrderDAO {
	private static OrderDAOImpl articleDAO = null;
	
	private static Logger logger = LoggerFactory.getLogger(OrderDAOImpl.class);
	
	private DataSource ds =null;
	
	private OrderDAOImpl() {
		Connection cn = null;
		try{
			Context context = new InitialContext();
			this.ds = (DataSource)context.lookup("java:/comp/env/jdbc/mydbcp");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(cn!=null) try{cn.close();}catch(Exception e){}
		}
		
	}
	
	private Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
	
	public static OrderDAOImpl getInstance() {
		if (articleDAO == null) {
			articleDAO = new OrderDAOImpl();
		}
		return articleDAO;
	}
	
	@Override
	public List<TypeVO> selectType() throws Exception {
		SqlMapClient sqlMap = QueryHandler.getInstance();
		List<TypeVO> t_list = null; 
		t_list = sqlMap.queryForList("serveWay.selectType");
		logger.info(t_list.toString());
		return t_list;
	}

	@Override
	public List<FoodVO> selectFood() throws Exception {
		SqlMapClient sqlMap = QueryHandler.getInstance();
		List<FoodVO> f_list = null; 
		f_list = sqlMap.queryForList("serveWay.selectFood");
		logger.info(f_list.toString());
		return f_list;
	}
	
	@Override
	public List<FoodVO> selectFood1() throws Exception {
		SqlMapClient sqlMap = QueryHandler.getInstance();
		List<FoodVO> f_list1 = null; 
		f_list1 = sqlMap.queryForList("serveWay.selectFood1");
		logger.info(f_list1.toString());
		return f_list1;
	}
	
	@Override
	public List<FoodVO> selectFood2() throws Exception {
		SqlMapClient sqlMap = QueryHandler.getInstance();
		List<FoodVO> f_list2 = null; 
		f_list2 = sqlMap.queryForList("serveWay.selectFood2");
		logger.info(f_list2.toString());
		return f_list2;
	}
	
	@Override
	public List<MaterialVO> selectMaterial(MaterialType material_type_no) throws Exception {
		SqlMapClient sqlMap = QueryHandler.getInstance();
		List<MaterialVO> m_list = null; 
		logger.info("material_type_no :"+material_type_no.getCode()+"");
		m_list = sqlMap.queryForList("serveWay.selectMaterial", material_type_no.getCode());
		logger.info(m_list.toString());
		return m_list;
	}
	
	@Override
	public List<AddVO> selectAdd(AddType add_type_no) throws Exception {
		SqlMapClient sqlMap = QueryHandler.getInstance();
		List<AddVO> add_list = null; 
		logger.info("add_type_no :"+add_type_no.getCode());
		add_list = sqlMap.queryForList("serveWay.selectAdd", add_type_no.getCode());
		logger.info(add_list.toString());
		return add_list;
	}


	@Override
	public void insertOrder(Order_detailVO order_detailVO) throws Exception {
		SqlMapClient sqlmap = QueryHandler.getInstance();
		sqlmap.insert("serveWay.insertOrder", order_detailVO);
	}
	
	@Override
	public void insertOrderList(Order_detailVO order_detailVO) throws Exception{
		SqlMapClient sqlmap = QueryHandler.getInstance();
		sqlmap.insert("serveWay.insertOrderList", order_detailVO);
	}
	
	@Override
	public List<AddVO> selectAdditions(Order_detailVO order_detailVO) throws Exception {
		SqlMapClient sqlmap = QueryHandler.getInstance();
		return sqlmap.queryForList("serveWay.selectAdditions", order_detailVO);	
	}

	@Override
	public List<MaterialVO> selectMaterials(Order_detailVO order_detailVO) throws Exception {
		SqlMapClient sqlmap = QueryHandler.getInstance();
		 return sqlmap.queryForList("serveWay.selectMaterials", order_detailVO);
	}

	@Override
	public FoodVO selectFood_NAME(int food_f_no) throws Exception {
		SqlMapClient sqlmap = QueryHandler.getInstance();
		 return (FoodVO) sqlmap.queryForObject("serveWay.selectFood_NAME", food_f_no);
	}
	
	@Override
	public void insertOrderAdd(Order_detailVO order_detailVO) throws Exception {
		SqlMapClient sqlmap = QueryHandler.getInstance();
		Map<String, Integer> map = new HashMap<>();
		map.put("order_num", order_detailVO.getOrder_num());
		List<Integer> list = order_detailVO.getAdds();
		for(Integer n:list){
			map.put("add_add_no", n);
			sqlmap.insert("serveWay.insertOrderAdd", map);	
			map.remove("add_add_no");
		}
	}
	
	@Override
	public void insertOrderMaterial(Order_detailVO order_detailVO) throws Exception {
		SqlMapClient sqlmap = QueryHandler.getInstance();
		Map<String, Integer> map = new HashMap<>();
		map.put("order_num", order_detailVO.getOrder_num());
		List<Integer> list = order_detailVO.getMaterials();
		for(Integer n:list){
			map.put("material_material_no", n);
			sqlmap.insert("serveWay.insertOrderMaterial", map);	
			map.remove("material_material_no");
		}
	}
	
	@Override
	public int selectOrderNum(Order_detailVO order_detailVO) throws Exception {
		SqlMapClient sqlmap = QueryHandler.getInstance();
		return (int) sqlmap.queryForObject("serveWay.selectOrderNum", order_detailVO);	
	}
	
	@Override
	public int selectFood_cal(Order_detailVO order_detailVO) throws Exception {
		SqlMapClient sqlmap = QueryHandler.getInstance();
		return (int) sqlmap.queryForObject("serveWay.selectFood_cal", order_detailVO);
	}
	@Override
	public int selectFood_price(Order_detailVO order_detailVO) throws Exception {
		SqlMapClient sqlmap = QueryHandler.getInstance();
		return (int) sqlmap.queryForObject("serveWay.selectFood_price", order_detailVO);
	}
	@Override
	public int addPrice(int object) throws Exception {
		SqlMapClient sqlmap = QueryHandler.getInstance();
		return (int) sqlmap.queryForObject("serveWay.addPrice", object);
	}
	@Override
	public int addCal(int material_no) throws Exception {
		SqlMapClient sqlmap = QueryHandler.getInstance();
		return (int) sqlmap.queryForObject("serveWay.addCal", material_no);
	}
	
	@Override
	public int addCalorie(int add_no) throws Exception {
		SqlMapClient sqlmap = QueryHandler.getInstance();
		return (int) sqlmap.queryForObject("serveWay.addCalorie", add_no);
	}
	@Override
	public int subCal(int material_no) throws Exception {
		SqlMapClient sqlmap = QueryHandler.getInstance();
		return (int) sqlmap.queryForObject("serveWay.subCal", material_no);
	}
	

}
