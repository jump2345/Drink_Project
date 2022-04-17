package kr.co.mlec.member.controller;

	
	import java.util.List;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import kr.co.mlec.controller.Controller;
import kr.co.mlec.member.dao.MemberDAO;
import kr.co.mlec.member.vo.MemberPagingVO;
import kr.co.mlec.member.vo.MemberVO;


	public class AdminMemberListController implements Controller {
		  @Override
		   public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
	

		/*
		 * 관리자용
		 * 멤버 목록 불러오기
		 */
		int page = 1;
		
		MemberDAO dao = new MemberDAO();		 
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		int count = dao.getAllCountA();
		
		MemberPagingVO paging = new MemberPagingVO();	   
		paging.setPage(page);
		paging.setTotalCount(count);
		

			  List<MemberVO> allMemberList = dao.selectAllMember(paging);
			 
			  System.out.println("List 컨트롤러 : " +  allMemberList);

			  
			  request.setAttribute("allMemberlist", allMemberList);
			  request.setAttribute("paging", paging);
			  

		      return "/jsp/member/AdminMemberList.jsp?page=" + page;

		      
	      
	   }
	}
