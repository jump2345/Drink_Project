
package kr.co.mlec.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.board.dao.BoardDAO;
import kr.co.mlec.board.service.BoardService;
import kr.co.mlec.controller.Controller;

public class AdminDeleteBoardController implements Controller {
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String[] comNos = request.getParameterValues("deleteBoardcchk");
		String btn = request.getParameter("btn");
		
		if(btn.equals("리뷰 삭제")) {
			BoardDAO dao = new BoardDAO();
			BoardService service = new BoardService();
			
			int[] nos = new int[comNos.length];
			for(int i=0; i<comNos.length; i++) {
				nos[i] = Integer.parseInt(comNos[i]);
			}
			service.adminDeleteBoard(nos);
			System.out.println("admindelete 컨트롤러에서 번호: " + nos);
			int result = dao.adminDeleteBoard(nos);
			System.out.println("admindelete 컨트롤러 result: " + result);
		}
		
		return "redirect:/board/list.do";

		
	}
}

