package serveWay.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import serveWay.models.AddVO;
import serveWay.models.OrderDAO;
import serveWay.models.OrderDAOImpl;
import serveWay.models.Order_detailVO;

public class SetMenuListAction extends AbstractController {

	@Override
	public ModelAndView handleRequestIntenal(HttpServletRequest request, HttpServletResponse response) {

		OrderDAO orderDAO = OrderDAOImpl.getInstance();
		ModelAndView mav = new ModelAndView();

		try {
			AddVO addVO = new AddVO();

			HttpSession session = request.getSession();
			Order_detailVO order_detailVO = (Order_detailVO) session.getAttribute("order");
			/*order_detailVO = (Order_detailVO) session.getAttribute("order");

			String[] selectedAdd = request.getParameterValues("addition");
*/			
			String[] selectedAdd = request.getParameterValues("chk_cookie");
			String[] selectedAdd2 = request.getParameterValues("chk_drink");
			
			System.out.println(selectedAdd);
			List<Integer> adds = order_detailVO.getAdds();

			order_detailVO.setAdds(adds);

			if (selectedAdd != null) {
				for (int i = 0; i < selectedAdd.length; i++) {
					adds.add(Integer.parseInt(selectedAdd[i]));
				}
			}
			
			if(selectedAdd2!=null){
				for ( String temp : selectedAdd2) {
					adds.add(Integer.parseInt(temp));
				}
			}

			session.setAttribute("order", order_detailVO);
			System.out.println("setmenuaction : "+session.getAttribute("order"));
			mav.setViewName("redirect:confirm");

		} catch (Exception e) {
			mav.setViewName("/WEB-INF/views/result.jsp");
			e.printStackTrace();
			mav.addObject("msg", "빠진 항목을 체크해 주세요");
			mav.addObject("url", "javascript:history.back();");
		}
		return mav;
	}

}