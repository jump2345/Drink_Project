package kr.co.mlec.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.mlec.board.service.BoardService;
import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.controller.Controller;


public class BoardUpdateFormController implements Controller {

	
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
	
		
		try {
			int no = Integer.parseInt(request.getParameter("comNo"));
			
			BoardService service = new BoardService();
			BoardVO board = service.selectBoard(no);
			
			request.setAttribute("board", board);
			//HttpSession session = request.getSession();   
			//session.setAttribute("board", board);
			//System.out.println(board);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "/jsp/board/updateForm.jsp";	//절대경로
	}
	
}
