package kr.co.mlec.drink.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.controller.Controller;
import kr.co.mlec.drink.dao.DrinkDAO;
import kr.co.mlec.drink.vo.DrinkVO;

public class SearchMenuController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		String search = request.getParameter("search");
		String search2 = request.getParameter("search2");
		
		
		System.out.println("search : " + search);
		System.out.println("search2 : " + search);
		
		DrinkDAO dao = new DrinkDAO();
		List<DrinkVO> list = dao.DrinkSearchByname(search);
		List<DrinkVO> list2 = dao.DrinkSearchBystore(search);
				
		request.setAttribute("list", list);
		request.setAttribute("list2", list2);
		
		
		
		return "/jsp/search/search.jsp";

	}

}
