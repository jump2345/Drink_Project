package kr.co.mlec.mention.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import kr.co.mlec.controller.Controller;
import kr.co.mlec.mention.dao.MentionDAO;
import kr.co.mlec.mention.service.MentionService;
import kr.co.mlec.mention.vo.MentionVO;

import kr.co.mlec.board.vo.BoardVO;

//댓글다는 컨트롤러
public class MentionWriteController implements Controller{

	   @Override
	   public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
	      
		   request.setCharacterEncoding("utf-8");
		   
		   
		    MentionDAO dao = MentionDAO.getInstance();
		
	        // 파리미터 값을 가져온다.
	        int commentNo = Integer.parseInt(request.getParameter("commentNo"));	        
	        String mentionID = request.getParameter("mentionID");
	        String mentionContent = request.getParameter("mentionContent");
	        
	        System.out.println("멘션 컨트롤러" + commentNo);
	        System.out.println("멘션 컨트롤러" + mentionID);
	        System.out.println("멘션 컨트롤러" + mentionContent);
	        
	        
	        MentionVO mentionVO = new MentionVO();
	        mentionVO.setMentionNo(dao.selectMentionSeq());    // 댓글 번호는 시퀀스값으로
	        mentionVO.setCommentNo(commentNo);
	        mentionVO.setMentionId(mentionID);
	        mentionVO.setMentionContent(mentionContent);
	        
	        
	        System.out.println("멘션 컨트롤러" + mentionVO);
	        
	        
	        
		       // System.out.println("ㅠㅠ"+commentNo);
	        //?....
			/*
			 * int comNo =Integer.parseInt(request.getParameter("comNo")); BoardVO board =
			 * new BoardVO(); board.setComNo(comNo);
			 */
	     
	        /* 
	        int comNo = Integer.parseInt(request.getParameter("comNo"));	
	        BoardVO board = new BoardVO();
			board.setComNo(comNo);*/
	        /*
	        boolean result = dao.insertMention(mentionVO);
	 
	        if(result){
	            response.setContentType("text/html;charset=euc-kr");
	            PrintWriter out = response.getWriter();
	            out.println("1");
	            out.close();
	        }
	        
	        */
	        
	        MentionService service = new MentionService();
	        service.insertMention(mentionVO);
			
	        //?...
//	        return "redirect:/board/detail.do?no=" + commentNo;
	        return "/jsp/board/replyResult.jsp";


	   }
}