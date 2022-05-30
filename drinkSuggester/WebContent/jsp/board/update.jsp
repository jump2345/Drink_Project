<%@page import="kr.co.mlec.board.dao.BoardDAO"%>
<%@page import="kr.co.mlec.board.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	
	//수정할 제목, 작성자, 내용 추출
	String comTitle = request.getParameter("comTitle");
	String id = request.getParameter("id");
	String comContent = request.getParameter("comContent");
	
	int comNo = Integer.parseInt(request.getParameter("comNo"));
	
	BoardVO board = new BoardVO();
	board.setComTitle(comTitle);
	board.setId(id);
	board.setComContent(comContent);
	board.setComNo(comNo);
	
	BoardDAO dao = new BoardDAO();
	dao.updateBoard(board);
%>
<script>
	alert("${ param.no}번 게시물이 수정되었습니다")
	location.href = 'detail.jsp?no=${ param.no} '
		
</script>


    