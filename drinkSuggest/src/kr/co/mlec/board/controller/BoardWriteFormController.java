package kr.co.mlec.board.controller;


import kr.co.mlec.controller.Controller;

public class BoardWriteFormController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		return "/jsp/board/writeForm.jsp";	//절대경로
	}
}
