package kr.co.mlec.drink.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.controller.Controller;
import kr.co.mlec.drink.dao.DrinkDAO;
import kr.co.mlec.drink.vo.DrinkPagingVO;
import kr.co.mlec.drink.vo.DrinkVO;

public class DrinkListGController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int page = 1;

		DrinkDAO dao = new DrinkDAO();
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		int count = dao.getAllCounG();

		DrinkPagingVO paging = new DrinkPagingVO();
		paging.setPage(page);
		paging.setTotalCount(count);
		
		System.out.println(paging);
		
		List<DrinkVO> drinkListG = dao.selectAllGongcha(paging);
		
		request.setAttribute("drinkListG", drinkListG);
		request.setAttribute("paging", paging);

		return "/jsp/drink/gongcha.jsp?page=" + page;
	}
}
