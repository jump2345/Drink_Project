package kr.co.mlec.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.board.service.BoardService;
import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.controller.Controller;

public class BoardSearchController implements Controller{
@Override
public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
	
	String searchType_ = request.getParameter("ST");
	String boardsearch_ = request.getParameter("SW");
	
	BoardService service = new BoardService();
	List<BoardVO> list = null;
	switch(searchType_) {
	case "comTitle" : 
		list = service.BoardSearchByTitle(boardsearch_);
		break;
	case "comContent" : 
		list = service.BoardSearchByContent(boardsearch_);
		break;
	case "id" :
		list = service.BoardSearchById(boardsearch_);
		break;
	}
	
	for(BoardVO vo : list) {
		System.out.println(vo);
	}
	
	request.setAttribute("list", list);
	
	
	return "/jsp/search/searchReview.jsp?searchBoard=" + boardsearch_;

	
	
}
}
