package serveWay.controllers;

import java.util.Date;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import serveWay.models.AddVO;
import serveWay.models.FoodVO;
import serveWay.models.MaterialVO;
import serveWay.models.OrderDAO;
import serveWay.models.OrderDAOImpl;
import serveWay.models.Order_detailVO;
import serveWay.models.TypeVO;

public class ConfirmInsert extends AbstractController {

	@Override
	public ModelAndView handleRequestIntenal(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session=request.getSession();
		Order_detailVO order_detailVO = (Order_detailVO) session.getAttribute("order");
		
		logger.info(order_detailVO+"");
		
	
		OrderDAO orderDAO = OrderDAOImpl.getInstance();
		ModelAndView mav = new ModelAndView();
		
		try {
/***************************/			
//for test
			/*order_detailVO.setType_type_no(1);
			order_detailVO.setFood_f_no(6);
			order_detailVO.setRequest_msg("없습니다.");
			order_detailVO.setPrice(5000);
			order_detailVO.setTotal_cal(400.0f);
			
			Date date = new Date();
			order_detailVO.setDate(date);
			
			List<Integer> material = new ArrayList();
			material.add(1);
			material.add(2);
			material.add(3);
			order_detailVO.setMaterials(material);

			List<Integer> add = new ArrayList();
			add.add(1);
			add.add(2);
			add.add(3);
			order_detailVO.setAdds(add);*/
			
/***************************/			
			
			
			List<MaterialVO> materials = orderDAO.selectMaterials(order_detailVO);
			List<AddVO> addition = orderDAO.selectAdditions(order_detailVO);
		
			logger.info("materials "+ materials);
			logger.info("addition "+ addition);
			logger.info("order_detailVO "+ order_detailVO);
			
			Date date = new Date();
			order_detailVO.setDate(date);
			
			float food_cal = orderDAO.selectFood_cal(order_detailVO); // 음식 칼로리 
			int food_price = orderDAO.selectFood_price(order_detailVO); // 음식 가격
			
			ArrayList additionlist = (ArrayList) order_detailVO.getAdds();// extra, 음료, 쿠키 선택된 리스트
			ArrayList materiallist = (ArrayList) order_detailVO.getMaterials();// 빵, 야채, 소스 선택된 리스트
			
			// add된 리스트 가격 더하기
			if(additionlist!=null){
				for(int i=0; i< additionlist.size(); i++){
					int add_no = (int) additionlist.get(i);
					food_price += orderDAO.addPrice(add_no);
				}
			}
			order_detailVO.setPrice(food_price);
		
			if(order_detailVO.getType_type_no()==1&order_detailVO.getMaterials().contains(13)){//샌드위치에 wheat 빵 선택했으면
				for(int i=1; i< materiallist.size(); i++){
					int material_no = (int) materiallist.get(i);
					food_cal += orderDAO.addCal(material_no);
				}
				if(additionlist!=null){
					for(int i=0; i< additionlist.size(); i++){
						int add_no = (int) additionlist.get(i);
						food_cal += orderDAO.addCalorie(add_no);
					}
				}
				
			}else if(order_detailVO.getType_type_no()==1&!(order_detailVO.getMaterials().contains(13))){ // 샌드위치에 wheat빵 선택안했으면
				for(int i=0; i< materiallist.size(); i++){
					int material_no = (int) materiallist.get(i);
					food_cal += orderDAO.addCal(material_no);
				}
				food_cal -= 210;
				if(additionlist!=null){
					for(int i=0; i< additionlist.size(); i++){
						int add_no = (int) additionlist.get(i);
						food_cal += orderDAO.addCalorie(add_no);
					}
				}
				
			}else{
				for(int i=0; i< materiallist.size(); i++){
					int material_no = (int) materiallist.get(i);
					food_cal += orderDAO.addCal(material_no);
				}
				if(additionlist!=null){
					for(int i=0; i< additionlist.size(); i++){
						int add_no = (int) additionlist.get(i);
						food_cal += orderDAO.addCalorie(add_no);
					}
				}
				food_cal -= 210;
			}
			order_detailVO.setTotal_cal(food_cal);
			
			FoodVO food = orderDAO.selectFood_NAME(order_detailVO.getFood_f_no());
			String f_name = food.getF_name();

			mav.setViewName("/WEB-INF/views/serveWay/confirm.jsp");
			
			mav.addObject("detailVO", order_detailVO);
			if(materials != null){
				mav.addObject("material", materials);
			}else{
				mav.addObject("material", "");
			}
			
			if(addition != null){
				mav.addObject("addition", addition);	
			}else{
				mav.addObject("addition", "");
			}
			
			mav.addObject("f_name", f_name);
			
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("/WEB-INF/views/result.jsp");
			mav.addObject("msg", "등록 실패");
			mav.addObject("url", "javascript:history.back();");
			
		}
		return mav;
	
	}
}
