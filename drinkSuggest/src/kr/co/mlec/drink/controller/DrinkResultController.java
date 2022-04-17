package kr.co.mlec.drink.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kr.co.mlec.controller.Controller;
import kr.co.mlec.drink.service.DrinkService;
import kr.co.mlec.drink.vo.DrinkVO;

public class DrinkResultController implements Controller {

   @Override
   public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
 
	   request.setCharacterEncoding("utf-8");
	   
	   System.out.println(request.getParameter("dk_f1"));
	   String dk_f1 = request.getParameter("dk_f1");
	   String dk_f2 = request.getParameter("dk_f2");
	   String dk_f3 = request.getParameter("dk_f3");
	   String dk_f4 = request.getParameter("dk_f4");
	   String dk_f5 = request.getParameter("dk_f5");
	   String dk_f6 = request.getParameter("dk_f6");
	   String dk_f7 = request.getParameter("dk_f7");
	   String dk_f8 = request.getParameter("dk_f8");
	   String dk_f9 = request.getParameter("dk_f9");
	   String dk_f10 = request.getParameter("dk_f10");
	   
	   DrinkVO drinkVO = new DrinkVO();
	   if(dk_f1 != null)
		   drinkVO.setDk_f1(dk_f1);
	   if(dk_f2 != null)
		   drinkVO.setDk_f2(dk_f2);
	   if(dk_f3 != null)
		   drinkVO.setDk_f3(dk_f3);
	   if(dk_f4 != null)
		   drinkVO.setDk_f4(dk_f4);
	   if(dk_f5 != null)
		   drinkVO.setDk_f5(dk_f5);
	   if(dk_f6 != null)
		   drinkVO.setDk_f6(dk_f6);
	   if(dk_f7 != null)
		   drinkVO.setDk_f7(dk_f7);
	   if(dk_f8 != null)
		   drinkVO.setDk_f8(dk_f8);
	   if(dk_f9 != null)
		   drinkVO.setDk_f9(dk_f9);
	   if(dk_f10 != null)
		   drinkVO.setDk_f10(dk_f10);
	   
	   System.out.println(drinkVO);
	   
	   DrinkService service = new DrinkService();
	   List<String> recommandDrinks = service.guessDrink(drinkVO);
	   
//	   for(String drink : recommandDrinks) {
//		   System.out.println(drink);
//	   }
	   
	   
	   request.setAttribute("drinks", recommandDrinks);
	   
      return "/jsp/drink/suggestResult.jsp";
   }

}









