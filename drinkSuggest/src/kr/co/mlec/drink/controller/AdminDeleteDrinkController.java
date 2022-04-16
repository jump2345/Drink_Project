package kr.co.mlec.drink.controller;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.controller.Controller;
import kr.co.mlec.drink.service.DrinkService;

public class AdminDeleteDrinkController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("utf-8");
		
		String[] dkNames = request.getParameterValues("chkSeq");
		
		System.out.println("delete 컨트롤러 : " + Arrays.toString(dkNames));
		
		DrinkService service = new DrinkService();
		service.deleteDrink(dkNames);

//		return "redirect:/AdminDrinkList.do";
		request.setAttribute("size", dkNames.length);
		return "/jsp/drink/AdminDeleteResult.jsp";
	}
}

