<%@page import="kr.co.mlec.board.dao.BoardDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.*"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="kr.co.mlec.board.vo.BoardVO"%>
<%@page import="kr.co.mlec.board.dao.BoardDAO"%>
<%@page import="java.net.URLEncoder"%>


<!DOCTYPE html>
<html class="no-js">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Review menu</title>
<meta name="description" content="GARO is a real-estate template">
<meta name="author" content="Kimarotec">
<meta name="keyword"
	content="html5, css, bootstrap, property, real-estate theme , bootstrap template">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,700,800'
	rel='stylesheet' type='text/css'>

<style type="text/css">
.list {
	border-collapse: collapse;
	border-spacing:  3px solid #553830;
}

.list td {
	border-color: black;
	border-style: solid;
	border-width: 1px;
	font-family: Arial, sans-serif;
	font-size: 14px;
	overflow: hidden;
	padding: 10px 5px;
	word-break: normal;
}

.list th {
	
   color: #553830;
    background: #ffcd58;
  	padding: 5px 5px;
	
}

.list .list-9v6y {
	background-color: #ffcd58;
	font-family: Nanum DaHaengCe;
	font-size: 17px;
	text-align: center;
	vertical-align: top
}

.list .list-0lax {
	text-align: center;
	vertical-align: top
}
.panel-body{
	 display: inline-block;
}
.block{
	float: left;
	margin-right: 15px;
}
.search bar{
	float: right;
}
</style>

<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/jquery-latest.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
			$('#writeBtn').click(function() {
				location.href = "${ pageContext.request.contextPath }/board/writeForm.do"
						})
					})

	function doAction(comNo) {
		<c:choose>
		<c:when test="${ not empty userVO }">
		location.href = "${ pageContext.request.contextPath }/board/detail.do?no="
				+ comNo

		</c:when>
		<c:otherwise>
		if (confirm('로그인 서비스가 필요합니다\n로그인페이지로 이동하시겠습니까?')) {
			location.href = '${ pageContext.request.contextPath }/register.do'
		}
		</c:otherwise>
		</c:choose>
	}

	$(document).ready(function() {
		$('#allCheckBox').click(function() {
			if ($("#allCheckBox").prop("checked")) {
				$("input[name=deleteBoardcchk]").prop("checked", true);
			} else {
				$("input[name=deleteBoardcchk]").prop("checked", false);
			}
		})
	})

	function cchkClicked() {
		var allCount = $("input:checkbox[name=deleteBoardcchk]").length;
		var checkedCount = $("input:checkbox[name=deleteBoardcchk]:checked").length;

		if (allCount == ceckedCount) {
			$(".deleteBoardcchk").prop("checked", true);
		} else {
			$("#allCheckBox").prop("checked", false);
		}
	}
	
	$(document).ready(function() {
		$('#adminDeleteBtn').click(function() {
			var boardIdxArray = [];
			var list = $("input:checkbox[name=deleteBoardcchk]");
			
			for(var i = 0; i<list.length; i++){
				if(list[i].checked){
					boardIdxArray.push(list[i].value);
				}
			}

				if (boardIdxArray == "") {
					alert("삭제할 리뷰를 선택해주세요.");
				} else {
					var answer = confirm("선택한 리뷰를 삭제하시겠습니까?");
					if (answer) {
						alert("글 번호 " + ${board.comNo} + " 번의 리뷰를 삭제합니다.");
						$.ajax({
							url : '${pageContext.request.contextPath}/AdminDeleteBoard.do',
							type : 'POST',
							traditional : true,
							data : {
								boardIdxArray : boardIdxArray
							},
							success: function(jdata){
								if(jdata = 1){
									alert("삭제 성공");
								}
								else{
									alert("삭제 실패");
								}
							}
							
						});

					}
				}
		})
	});

</script>
</head>
<body>
	<!-- header part -->
	<header>
		<jsp:include page="/jsp/include/topMenu.jsp" />
	</header>

	<!-- Body content -->
	<div class="page-head">
		<div class="container">
			<div class="row">
				<div class="page-head-content">
					<h1 class="page-title">리뷰이야기</h1>
				</div>
			</div>
		</div>
	</div>
	<!-- End page header -->

	<section>
		<div align="center">
			<hr>
			<h2>리뷰 목록</h2>
			<hr>
			<br>
			<table border="1" class="list">
				<tr>
					<c:if test="${ userVO.type == 'S'}">
						<th><label class="checkbox-inline"> <input
								type="checkbox" id="allCheckBox">
						</label></th>
					</c:if>
					<th align="center" width="50px" class="list-9v6y">번호</th>
					<th align="center" width="500px" class="list-9v6y">제목</th>
					<th align="center" width="80px" class="list-9v6y">글쓴이</th>
					<th align="center" width="70px" class="list-9v6y">좋아요</th>
					<th align="center" width="150px" class="list-9v6y">등록일</th>
					<th align="center" width="70px" class="list-9v6y">조회수</th>
				</tr>

				<c:forEach items="${ list }" var="board">
					<tr>
						<c:if test="${ userVO.type == 'S'}">
							<td><label class="checkbox-inline"> <input
									type="checkbox" name="deleteBoardcchk" value="deleteComNo" onclick="cchkClicked()">
							</label></td>
						</c:if>
						<td align="center">${ board.comNo }</td>
						<td><a href="javascript:doAction(${ board.comNo })"> <c:out
									value="${ board.comTitle }" />
						</a></td>
						<td align="center">${ board.id }</td>
						<td align="center">${ board.viewCnt }</td>
						<td align="center">${ board.regDate }</td>
						<td align="center">${ board.comLikeCnt }</td>

					</tr>
				</c:forEach>
			</table>
			<br>
			<jsp:include page="/jsp/board/paging.jsp">
				<jsp:param value="${paging.page}" name="page" />
				<jsp:param value="${paging.beginPage}" name="beginPage" />
				<jsp:param value="${paging.endPage}" name="endPage" />
				<jsp:param value="${paging.prev}" name="prev" />
				<jsp:param value="${paging.next}" name="next" />
			</jsp:include>
			<br>
			<c:if test="${ not empty userVO }">
				<button id="writeBtn">새글등록</button>
			</c:if>
			<c:if test="${ userVO.type == 'S'}">
				<input type="submit" name="btn" value="리뷰삭제" id="adminDeleteBtn" style="width:60pt; height:22pt; text-align:center; font-size:14px; padding: 0px;">
			</c:if>
		</div>


		<%
		request.setCharacterEncoding("utf-8");

		String searchType = "";
		String searchBoard = "";

		if (request.getParameter("searchBoard") != null) {
			searchBoard = request.getParameter("searchBoard");
		}
		if (request.getParameter("searchType") != null) {
			searchType = request.getParameter("searchType");
		}
		%>

		<%
		ArrayList<BoardVO> boardSearch1 = new ArrayList<BoardVO>();
		ArrayList<BoardVO> boardSearch2 = new ArrayList<BoardVO>();
		ArrayList<BoardVO> boardSearch3 = new ArrayList<BoardVO>();

		boardSearch1 = new BoardDAO().BoardSearchByContent(searchBoard);
		boardSearch2 = new BoardDAO().BoardSearchByContent(searchBoard);
		boardSearch3 = new BoardDAO().BoardSearchById(searchBoard);

		if (boardSearch1 != null)
			for (int i = 0; i < boardSearch1.size(); i++) {
				BoardVO bs = boardSearch1.get(i);
			}

		if (boardSearch2 != null)
			for (int i = 0; i < boardSearch2.size(); i++) {
				BoardVO bs = boardSearch2.get(i);
			}

		if (boardSearch3 != null)
			for (int i = 0; i < boardSearch3.size(); i++) {
				BoardVO bs = boardSearch3.get(i);
			}
		%>

	<!-- review search  -->
		<div align="center"
			class="panel panel-default sidebar-menu wow  fadeInRight animated animated"
			style="visibility: visible; animation-name: fadeInRight;">
			<div class="panel-heading">
				<h3 class="panel-title">리뷰 검색</h3>
			</div>
			<div class="panel-body">

				<form action="${ pageContext.request.contextPath }/searchBoard.do"
					method="get" class=" form-inline" role="search">
					<div style="width: 100px;" class="block">
						<select name="ST" class="form-control mx-1 mt-2">
							<option ${(param.ST == "comTitle")? "selected" : "" }
								value="comTitle">글제목</option>
							<option ${(param.ST == "comContent")? "selected" : "" }
								value="comContent">글내용</option>
							<option ${(param.ST == "id")? "selected" : "" } value="id">글쓴이</option>
						</select>
					</div>
						<div class="input-group" class="search bar">
							<input class="form-control" placeholder="리뷰게시글을 검색해보세요"
								type="text" name="SW" Value="${param.SW}"> <span
								class="input-group-btn">
								<button type="submit" class="btn btn-smal">
									<i class="fa fa-search"></i>
								</button>
							</span>
						</div>
				</form>

			</div>
		</div>
	</section>
	<!-- footer part -->
	<footer>
		<%@ include file="/jsp/include/footer.jsp"%>
	</footer>
</body>
</html>
