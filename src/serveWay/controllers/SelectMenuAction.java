package serveWay.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import serveWay.models.FoodVO;
import serveWay.models.Order_detailVO;

public class SelectMenuAction extends AbstractController {

	@Override
	public ModelAndView handleRequestIntenal(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView mav = new ModelAndView();
		
		try {
			int f_no = Integer.parseInt(request.getParameter("f_no"));
			HttpSession session=request.getSession();
			Order_detailVO order_detailVO = (Order_detailVO) session.getAttribute("order");
			order_detailVO.setFood_f_no(f_no);
		
			session.setAttribute("order", order_detailVO);
			System.out.println("selectmenuaction : "+session.getAttribute("order"));
			mav.setViewName("redirect:material");
			
		} catch (Exception e) {
			mav.setViewName("/WEB-INF/views/result.jsp");
			mav.addObject("msg", "메뉴가 선택되지 않았습니다.");
			mav.addObject("url", "javascript:history.back();");
			e.printStackTrace();
		}
		return mav;
	}

}