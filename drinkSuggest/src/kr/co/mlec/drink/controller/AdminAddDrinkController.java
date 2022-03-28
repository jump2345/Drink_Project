package kr.co.mlec.drink.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.controller.Controller;
import kr.co.mlec.drink.service.DrinkService;
import kr.co.mlec.drink.vo.DrinkVO;

public class AdminAddDrinkController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("utf-8");

		String dk_name = request.getParameter("dkName");
		String dk_f1 = request.getParameter("dkF1");
		String dk_f2 = request.getParameter("dkF2");
		String dk_f3 = request.getParameter("dkF3");
		String dk_f4 = request.getParameter("dkF4");
		String dk_f5 = request.getParameter("dkF5");
		String dk_f6 = request.getParameter("dkF6");
		String dk_f7 = request.getParameter("dkF7");
		String dk_f8 = request.getParameter("dkF8");
		String dk_f9 = request.getParameter("dkF9");
		String dk_f10 = request.getParameter("dkF10");
		String dk_store = request.getParameter("dkStore");
		String dk_price = request.getParameter("dkPrice");
		
		DrinkVO drink = new DrinkVO();
		drink.setDk_name(dk_name);
		drink.setDk_f1(dk_f1);
		drink.setDk_f2(dk_f2);
		drink.setDk_f3(dk_f3);
		drink.setDk_f4(dk_f4);
		drink.setDk_f5(dk_f5);
		drink.setDk_f6(dk_f6);
		drink.setDk_f7(dk_f7);
		drink.setDk_f8(dk_f8);
		drink.setDk_f9(dk_f9);
		drink.setDk_f10(dk_f10);
		drink.setDk_store(dk_store);
		drink.setDk_price(dk_price);
		
		System.out.println("add컨트롤러 : " + drink);
		
		DrinkService service = new DrinkService();
		service.insertDrink(drink);

//		return "redirect:/AdminDrinkList.do";
		return "/jsp/drink/AdminAddResult.jsp";
	}
}
