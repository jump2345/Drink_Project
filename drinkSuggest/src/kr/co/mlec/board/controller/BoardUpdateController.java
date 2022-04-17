package kr.co.mlec.board.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.board.service.BoardService;
import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.controller.Controller;

public class BoardUpdateController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		    request.setCharacterEncoding("utf-8");
		
			int comNo = Integer.parseInt(request.getParameter("comNo"));	
			String comTitle = request.getParameter("comTitle");
			String id = request.getParameter("id");
			String comContent = request.getParameter("comContent");
			
			BoardVO board = new BoardVO();
			board.setComNo(comNo);
			board.setComTitle(comTitle);
			board.setId(id);
			board.setComContent(comContent);
			
			BoardService service = new BoardService();
			service.updateBoard(board);
			
			
		return "redirect:/board/detail.do?no=" + comNo;

	}

}