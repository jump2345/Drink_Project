package kr.co.mlec.drink.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kr.co.mlec.controller.Controller;
import kr.co.mlec.drink.service.DrinkService;
import kr.co.mlec.drink.vo.DrinkVO;

public class AdminUpdateDrinkFormController implements Controller {

	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{

		
		
		try {
			String dk_name = request.getParameter("dk_name");
			System.out.println("dkanme" + dk_name);
			
			DrinkService service = new DrinkService();
			DrinkVO drink = service.selectDrink(dk_name);
			
			request.setAttribute("drink", drink);
			//HttpSession session = request.getSession();   
			//session.setAttribute("board", board);
			//System.out.println(board);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "/jsp/drink/AdminDrinkUpdateForm.jsp";

}
}
