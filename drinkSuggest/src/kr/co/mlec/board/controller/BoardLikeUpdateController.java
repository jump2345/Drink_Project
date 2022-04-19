package kr.co.mlec.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import kr.co.mlec.board.dao.BoardDAO;
import kr.co.mlec.controller.Controller;

public class BoardLikeUpdateController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int lno = Integer.parseInt(request.getParameter("comNo"));
		
		BoardDAO bDao = new BoardDAO();
		bDao.updateLike(lno);
		
		int like = bDao.selectLike(lno);
		System.out.println(" like 개수:" + like);
		
		JSONObject obj = new JSONObject();
		obj.put("like", like);
		// request.setAttribute("json", json);
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(obj);

		return "/jsp/board/like.jsp";
	}
}

