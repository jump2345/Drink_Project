package kr.co.mlec.board.controller;


import kr.co.mlec.board.dao.BoardDAO;
import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.board.vo.PagingVO;
import kr.co.mlec.controller.Controller;

public class BoardListController implements Controller {	

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{		//String으로 받는 이유는 jsp주소값으로 받기 때문에 
		
	int page = 1;
		
	    BoardDAO dao = new BoardDAO();    
	        if(request.getParameter("page")!=null){
	            page = Integer.parseInt(request.getParameter("page"));
	        }
	        
	        int count = dao.getAllCount();
	        
	        PagingVO paging = new PagingVO();
	        paging.setPage(page);
	        paging.setTotalCount(count);
	        System.out.println(paging);
	        
	        
	        List<BoardVO> list = dao.selectAllboard(paging);
	        request.setAttribute("list", list);
	        request.setAttribute("paging", paging);
	       
	        return "/jsp/board/list.jsp?page=" + page;
	}
	
}
