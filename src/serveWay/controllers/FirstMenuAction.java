package serveWay.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import serveWay.models.Order_detailVO;
import serveWay.models.TypeVO;

public class FirstMenuAction extends AbstractController{

	@Override
	public ModelAndView handleRequestIntenal(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView mav = new ModelAndView();
		
		try {
			int type_no = Integer.parseInt(request.getParameter("type_no"));
			
			/*logger.info("type_no : "+ type_no);*/
			if (type_no!=1 && type_no!=2) throw new RuntimeException("메뉴가 선택되지 않았습니다.");
			
			Order_detailVO order_detailVO = new Order_detailVO(); 
			order_detailVO.setCustomer_id(20170724);
			order_detailVO.setType_type_no(type_no);
			
			HttpSession session=request.getSession();
			session.setAttribute("order", order_detailVO);
			mav.setViewName("redirect:selectmenu");
			
			System.out.println("firstmenuaction : "+session.getAttribute("order"));
			
		} catch (Exception e) {
			mav.setViewName("/WEB-INF/views/result.jsp");
			mav.addObject("msg", "메뉴가 선택되지 않았습니다.");
			mav.addObject("url", "javascript:history.back();");
			e.printStackTrace();
		}
		return mav;
	}

}
