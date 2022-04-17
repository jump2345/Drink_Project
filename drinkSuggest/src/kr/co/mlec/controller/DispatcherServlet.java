package kr.co.mlec.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {		
	//DispatcherServlet: 유일한 서블릿 클래스로서 모든 클라이언트의 요청을 가장 먼저 처리하는 Front Controller

	private HandlerMapping mappings = null;
	//HandlerMapping: 클라이언트의 요청을 처리할 Controller(java)를 매핑
	//매핑이란 해당 값이 다른 값을 가리키도록 하는 것이다.
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		//config :  환경 설정 // throws: ㅇㅖ외를 던져
		//서블렛 요청 호출 순서 -> init(메소드 사용하여 초기화 작업 수행),service, destroy
		String propLoc =config.getInitParameter("propLocation");		
		mappings = new HandlerMapping(propLoc);
	}
	
	
	//controller 재정의 
	@Override
	           //사용자 요청에 대한 실제 응답 처리 (요청,응답 객체)
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//uri: identify  
		                     //응답을 받아와야하니까..
		String uri = request.getRequestURI();
		String context = request.getContextPath();
		uri = uri.substring(context.length());
		System.out.println("요청 URI : " + uri);
        
		
		try {	//session 떄매 
			Controller control = mappings.getController(uri);
			
			String callPage = control.handleRequest(request, response);
			
			
			//forward or sendRedirect 선택
			if(callPage.startsWith("redirect:")) {
				callPage = callPage.substring("redirect:".length());
				response.sendRedirect(request.getContextPath() + callPage);
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(callPage);
				dispatcher.forward(request, response); //jsp에 넘겨주려고 forward
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
	}
}

