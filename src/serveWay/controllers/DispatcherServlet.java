package serveWay.controllers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Servlet implementation class DispatcherServlet
 * WebServlet("/DispatcherServlet")
 */

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	                               
	private static Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);
	
	private static Map<String, AbstractController> controllerMap = new HashMap<String,AbstractController>();
	
	
	/**
	 * 생성자가 호출된 후 자동 호출됨 
	 * 설정파일(dispatcher-servlet.properties) 을 읽어 action 과 인트턴스를 미리 생성하도록함
	 * new 되는 부분을 제거 할 수 있음 (이미 만들어진 인스턴스를 씀)
	 */
	@Override
	public void init() throws ServletException {
		logger.info("-- Dispatcherservlet.init() ------------- ");
		InputStream is = null;
		Properties pr = new Properties();
		String filePath = this.getClass().getResource("").getPath();
		try {
			is = new FileInputStream(filePath+"dispatcher-servlet.properties");
			pr.load(is);
			
			for(Object obj:pr.keySet()){
				String key = ((String)obj).trim();
				String classPath = (pr.getProperty(key)).trim();
				
				try{
					Class className = Class.forName(classPath);
					controllerMap.put(key, (AbstractController)className.newInstance());
					logger.info("loaded : "+key);
				}catch (Exception e) {
					e.printStackTrace();
					logger.info("failure : "+key);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(is!=null)try{is.close();}catch(Exception e){}
		}
	}
	
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		AbstractController controller = null; 
		ModelAndView mav = null;
		String contextPath = request.getContextPath();
		String action = request.getRequestURI().trim().substring(contextPath.length());
		
		logger.info("action : "+request.getRequestURI());
		logger.info("action : "+action);
		
		controller = controllerMap.get(action);
		if(controller == null){
			logger.info(action + " 수행할 액션이 없습니다.");
			return;
		}
		mav = controller.handleRequestIntenal(request, response);
				
		if(mav != null){
			//페이지 전환
			if(mav.getViewName().substring(0,9).equals("redirect:")) {
				response.sendRedirect(mav.getViewName().substring(9));
				return;
			}
			/*
			 * OrderDAO.insertArticle(articleVO);
			 * mav.setViewNmae("redirect:list"); 
			 */
			
			for(String key:mav.getModel().keySet()){
				request.setAttribute(key, mav.getModel().get(key));
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher(mav.getViewName());
			dispatcher.forward(request, response);
			return;
		} else {
			logger.info("Dispatcher Servlet 에서 길을 잃었다네");
		}
		
	}

}
