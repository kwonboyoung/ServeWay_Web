package serveWay.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import serveWay.models.OrderDAOImpl;

public abstract class AbstractController {
	protected static Logger logger = LoggerFactory.getLogger(AbstractController.class);
	public abstract ModelAndView handleRequestIntenal(HttpServletRequest request, HttpServletResponse response);

}
