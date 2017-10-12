package serveWay.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import serveWay.models.AddType;
import serveWay.models.AddVO;
import serveWay.models.OrderDAO;
import serveWay.models.OrderDAOImpl;

public class SetMenuList extends AbstractController {

	@Override
	public ModelAndView handleRequestIntenal(HttpServletRequest request, HttpServletResponse response) {

		OrderDAO orderDAO = OrderDAOImpl.getInstance();
		ModelAndView mav = new ModelAndView();

		try {
			List<AddVO> c_list = orderDAO.selectAdd(AddType.COOKIE);
			List<AddVO> d_list = orderDAO.selectAdd(AddType.DRINK);

			mav.setViewName("/WEB-INF/views/serveWay/setmenu.jsp");
			mav.addObject("c_list", c_list);
			mav.addObject("d_list", d_list);

		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("/WEB-INF/views/result.jsp");
			mav.addObject("msg", "빠진 항목을 체크해 주세요");
			mav.addObject("url", "javascript:history.back();");
		}
		return mav;
	}

}