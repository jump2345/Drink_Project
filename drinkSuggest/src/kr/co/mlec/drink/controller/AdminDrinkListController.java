package kr.co.mlec.drink.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.controller.Controller;
import kr.co.mlec.drink.dao.DrinkDAO;
import kr.co.mlec.drink.vo.DrinkPagingVO;
import kr.co.mlec.drink.vo.DrinkVO;

public class AdminDrinkListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		/*
		 * 관리자용
		 * 음료 목록 보이기
		 */
		int page = 1;

		DrinkDAO dao = new DrinkDAO();
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		int count = dao.getAllCounA();

		DrinkPagingVO paging = new DrinkPagingVO();
		paging.setPage(page);
		paging.setTotalCount(count);
		
		System.out.println(paging);
		
		List<DrinkVO> allDrinkList = dao.selectAllDrink(paging);
		
		System.out.println("list 컨트롤러 : " + allDrinkList);
		
		request.setAttribute("allDrinkList", allDrinkList);
		request.setAttribute("paging", paging);

		return "/jsp/drink/AdminDrinkList.jsp?page=" + page;
	}
	
}
