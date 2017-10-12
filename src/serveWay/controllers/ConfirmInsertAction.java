package serveWay.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import serveWay.models.OrderDAO;
import serveWay.models.OrderDAOImpl;
import serveWay.models.Order_detailVO;
import serveWay.models.FoodVO;

public class ConfirmInsertAction extends AbstractController {

	@Override
	public ModelAndView handleRequestIntenal(HttpServletRequest request, HttpServletResponse response) {
	
		Order_detailVO order_detailVO = (Order_detailVO) request.getSession().getAttribute("order");
		logger.info("order_detailVO : "+order_detailVO);
		OrderDAO orderDAO = OrderDAOImpl.getInstance();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/views/result.jsp");
		System.out.println("confirminsertaction : "+order_detailVO);
		
		try {
			int order_num = orderDAO.selectOrderNum(order_detailVO);
			order_detailVO.setOrder_num(order_num);
			orderDAO.insertOrder(order_detailVO);
			orderDAO.insertOrderList(order_detailVO);
			orderDAO.insertOrderAdd(order_detailVO);
			orderDAO.insertOrderMaterial(order_detailVO);
			mav.addObject("msg", "주문 성공");
			mav.addObject("url", "http://70.12.50.61:90/Chatbot/controller/index.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("/WEB-INF/views/result.jsp");
			mav.addObject("msg", "등록 실패");
			mav.addObject("url", "javascript:history.back();");
		}
		return mav;
	}

}
