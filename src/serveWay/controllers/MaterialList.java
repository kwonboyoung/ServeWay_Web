package serveWay.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import serveWay.models.AddType;
import serveWay.models.AddVO;
import serveWay.models.MaterialType;
import serveWay.models.MaterialVO;
import serveWay.models.OrderDAO;
import serveWay.models.OrderDAOImpl;
import serveWay.models.Order_detailVO;

public class MaterialList extends AbstractController {

	@Override
	public ModelAndView handleRequestIntenal(HttpServletRequest request, HttpServletResponse response) {

		OrderDAO orderDAO = OrderDAOImpl.getInstance();
		ModelAndView mav = new ModelAndView();

		try {

			List<MaterialVO> b_list = orderDAO.selectMaterial(MaterialType.BREAD);
			List<MaterialVO> v_list = orderDAO.selectMaterial(MaterialType.VEGETABLE);
			List<MaterialVO> s_list = orderDAO.selectMaterial(MaterialType.SOURCE);
			List<AddVO> extra_list = orderDAO.selectAdd(AddType.EXTRA);

			mav.setViewName("/WEB-INF/views/serveWay/material.jsp");
			mav.addObject("b_list", b_list);
			mav.addObject("s_list", s_list);
			mav.addObject("v_list", v_list);
			mav.addObject("extra_list", extra_list);

			logger.info("BreadList : "+b_list);
			logger.info("SourceList : "+s_list);
			logger.info("VegeList : "+v_list);
			logger.info("extra_list : "+extra_list);

		} catch (Exception e) {
			mav.setViewName("/WEB-INF/views/result.jsp");
			e.printStackTrace();
			mav.addObject("msg", "빠진 항목을 체크해 주세요.");
			mav.addObject("url", "javascript:history.back();");
		}
		return mav;
	}

}
