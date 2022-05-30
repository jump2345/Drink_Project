package kr.co.mlec.mention.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.controller.Controller;
import kr.co.mlec.mention.service.MentionService;

public class MentionDeleteController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		  int mentionNo = Integer.parseInt(request.getParameter("mentionNo"));	
		  int comNo= Integer.parseInt(request.getParameter("comNo"));	
		  
		  
		  
		  MentionService service = new MentionService();
		  service.deleteMention(mentionNo);
		
		  return "redirect:/board/detail.do?no=" + comNo;
		 //return "redirect:${pageContext.request.contextPath}/board/detail.do?no="+ comNo;
	}
}

