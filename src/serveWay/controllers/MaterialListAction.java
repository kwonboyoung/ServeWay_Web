package serveWay.controllers;

import java.util.ArrayList;
//breadlist= ordermenuinsert
//breadlistAction=OrdermenuinsertAction
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import serveWay.models.MaterialVO;
import serveWay.models.Order_detailVO;

public class MaterialListAction extends AbstractController {

	@Override
	public ModelAndView handleRequestIntenal(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		try {

			HttpSession session = request.getSession();
			Order_detailVO order_detailVO = (Order_detailVO) session.getAttribute("order");

			String b_no = request.getParameter("bread");
			String[] selectedVege = request.getParameterValues("vegetable");
			String[] selectedSource = request.getParameterValues("source");
			String[] selectedAdd = request.getParameterValues("addition");
			String content = request.getParameter("content");
			System.out.println(selectedSource);
			
			List<Integer> materials = new ArrayList<Integer>();
			List<Integer> adds = new ArrayList<Integer>();

			
			logger.info("b_no :"+b_no);
			logger.info("selectedVege :"+selectedVege);
			logger.info("selectedSource :"+selectedSource);
			logger.info("selectedAdd :"+selectedAdd);
			logger.info("content :"+content);
			logger.info("materials :"+materials);
			logger.info("adds :"+adds);
			
			
			if(b_no != null) {
				materials.add(Integer.parseInt(b_no));
			}

			if(selectedVege != null) {
				for (int i = 0; i < selectedVege.length; i++) {
					materials.add(Integer.parseInt(selectedVege[i]));
				}
			}
			
			if(selectedSource!= null) {
				for (int i = 0; i < selectedSource.length; i++) {
					materials.add(Integer.parseInt(selectedSource[i]));
				}
			}
			
			if(selectedAdd!= null) {
				for (int i = 0; i < selectedAdd.length; i++) {
					adds.add(Integer.parseInt(selectedAdd[i]));
				}
			}
			
			order_detailVO.setMaterials(materials);
    		order_detailVO.setAdds(adds);
			
			if (content != null) {
				order_detailVO.setRequest_msg(content);
			}
			
			session.setAttribute("order", order_detailVO);
			mav.setViewName("redirect:setmenu");
			
			System.out.println("materiallistaction : "+session.getAttribute("order"));

		} catch (Exception e) {
			mav.setViewName("/WEB-INF/views/result.jsp");
			mav.addObject("msg", "빠진 항목을 체크해주세요.");
			mav.addObject("url", "javascript:history.back();");
			e.printStackTrace();
		}
		return mav;
	}

}
