package kr.co.mlec.member.controller;

	import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import kr.co.mlec.controller.Controller;
import kr.co.mlec.member.service.MemberService;

	public class AdminDeleteMemberController implements Controller {

		 /*
		  * 관리자용
		  * 멤버 삭제
		  * post 지정되어있는지.....?
		  */
		      
		  @Override
		   public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
				
				request.setCharacterEncoding("utf-8");
				
			  
			String[] memberIds = request.getParameterValues("chkSeq");

			System.out.println("delet컨트롤러 : " + Arrays.toString(memberIds));
			 
			
			MemberService service = new MemberService();
			 service.deleteMember(memberIds);
			  

			 request.setAttribute("size", memberIds.length);
			 
			 return "/jsp/member/AdminDeleteResult.jsp";   
	      
	   }
	}
