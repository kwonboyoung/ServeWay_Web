package serveWay.controllers;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import serveWay.models.FoodVO;
import serveWay.models.OrderDAO;
import serveWay.models.OrderDAOImpl;

public class SelectMenu extends AbstractController{

	@Override
	public ModelAndView handleRequestIntenal(HttpServletRequest request, HttpServletResponse response) {
	
		OrderDAO orderDAO = OrderDAOImpl.getInstance();
		ModelAndView mav = new ModelAndView();
		
		try {
			
			List<FoodVO> f_list = orderDAO.selectFood();
			/*List<FoodVO> f_list1 = orderDAO.selectFood1();
			List<FoodVO> f_list2 = orderDAO.selectFood2();*/
			
			/*List<String> menus = Arrays.asList("CLASSICS", "FAVORITES");*/
			List<String> menus = Arrays.asList("CLASSICS", "FAVORITES","SIGNATURE", "PREMIUM");
			List<String> menus2 = Arrays.asList("SIGNATURE", "PREMIUM");
			mav.setViewName("/WEB-INF/views/serveWay/selectmenu.jsp");
			mav.addObject("f_list", f_list);
			/*mav.addObject("f_list1", f_list1);
			mav.addObject("f_list2", f_list2);*/
			mav.addObject("menus", menus);
			mav.addObject("menus2", menus2);
			
			
		} catch (Exception e) {
			mav.setViewName("/WEB-INF/views/result.jsp");
			e.printStackTrace();
			mav.addObject("msg", "메뉴가 선택되지 않았습니다.");
			mav.addObject("url", "selectmenu");
		} 
		return mav;
	}
	
}

