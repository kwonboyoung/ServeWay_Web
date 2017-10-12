package serveWay.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstMenu extends AbstractController {

	@Override
	public ModelAndView handleRequestIntenal(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("/WEB-INF/views/serveWay/firstpage.jsp");
	}

}
