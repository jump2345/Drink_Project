package kr.co.mlec.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.mlec.controller.Controller;
import kr.co.mlec.member.service.MemberService;
import kr.co.mlec.member.vo.MemberVO;

public class LoginProcessController implements Controller {
   
   @Override
   public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

      request.setCharacterEncoding("utf-8");
      
      String id = request.getParameter("id");
      String pw = request.getParameter("pw");
      String name = request.getParameter("name");
      String email = request.getParameter("email");
      String tel = request.getParameter("tel");
    
      String type = request.getParameter("type");
   
      MemberVO loginVO = new MemberVO(id, pw, name, email, tel,  type );
      
      System.out.println("loginVO : " + loginVO);
      MemberService service = new MemberService();
      MemberVO userVO = service.login(loginVO);
      
      System.out.println(userVO);
      
      String url = "";
      if(userVO == null) {
         //로그인 실패
         url = "/register.do";
      }else {
         // 로그인 성공(인덱스로 간다)
         url = "";            
         HttpSession session = request.getSession();   
         session.setAttribute("userVO", userVO);
      }
      return "redirect:" + url;
   }
   


}