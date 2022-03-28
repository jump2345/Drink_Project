<%@page import="kr.co.mlec.board.vo.BoardVO"%>
<%@page import="kr.co.mlec.board.dao.BoardDAO"%>
<%@page import="kr.co.mlec.util.JDBCClose"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="kr.co.mlec.util.connectionFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<%--
	http://localhost:9999/Mission-Web/jsp/board/detail.jsp?no=3

	작업순서
	1. 요청 URL의 파라미터 분석 => 게시글 번호 추출?
	2. DB tbl_board에서 추출된 게시글번호의 게시물 조회
	3. HTML에 조회된 게시물을 연결 화면 구성
	
 --%>


<html>
<head>
<meta charset="UTF-8">
<title>게시판 상세 페이지</title>
<style type="text/css">
table.type02 {
  border-collapse: separate;
  border-spacing: 0;
  text-align: left;
  line-height: 1.5;
  border-top: 1px solid #ccc;
  border-left: 1px solid #ccc;
  margin : 20px 10px;
}
table.type02 th {
  width: 150px;
  padding: 10px;
  font-weight: bold;
  vertical-align: top;
  border-right: 1px solid #ccc;
  border-bottom: 1px solid #ccc;
  border-top: 1px solid #fff;
  border-left: 1px solid #fff;
  background: #eee;
  text-align: center;

}
table.type02 td {
  width: 700px;
  padding: 10px;
  vertical-align: top;
  border-right: 1px solid #ccc;
  border-bottom: 1px solid #ccc;
  text-align: center;
}

table.thContent {
 width: 3500px;
}


table.type3 {
  border-collapse: collapse;
  border-spacing: 0;
  text-align: center;
  line-height: 1.5;
  border-top: 1px solid #ccc;
  border-bottom: 1px solid #ccc;
  border-right: 1px solid #ccc;
  border-left: 1px solid #ccc;
  margin : 20px 10px;
}

table.type3 th {

  border-right: 1px solid #ccc;
  border-bottom: 1px solid #ccc;
  border-top: 1px solid #fff;
  border-left: 1px solid #fff;
  

  text-align: center;
}
table.type3 td {

  border-right: 1px solid #ccc;
  border-bottom: 1px solid #ccc;
  text-align: center;
}


</style>

<link rel="stylesheet" href="/Mission-Web/css/layout.css">
<link rel="stylesheet" href="/Mission-Web/css/board.css">
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	function doAction(type) {

		switch (type) {
		case 'R':
			location.href = "${pageContext.request.contextPath}/board/replyForm.do?no=${param.no}"
			break;
		case 'U':
			location.href = "${pageContext.request.contextPath}/board/updateForm.do?comNo=${param.no}"
			break;
		case 'D': 
			location.href = "${pageContext.request.contextPath}/board/delete.do?no=${param.no}"
			break;
		case 'L':
			location.href = "${pageContext.request.contextPath}/board/list.do"
			break;

		case 'A':
			$.ajax({ 
				url : "${pageContext.request.contextPath}/board/like.do",
				cache : false,
				data : {
					'comNo': ${param.no}
				},
													// 파라미터 전송 형태(표준 쿼리형태)로 만들어줌
				success : function(data) { // ajax통신 성공시 넘어오는 데이터 통째 이름 =data
					alert(" 좋아요♥ "); // data중 put한 것의 이름 like
			//		$("#like_result").html(data.like); // id값이 like_result인 html을 찾아서
					location.reload();									// data.like값으로 바꿔준다.
					
				},
				error : function(request, status, error) {
					alert("좋아요 실패 다시 클릭하세요!")
				}
			});
					
		}

	}




//댓글등록
 
	$(document).ready(
					function() {
						$('#writeMention').click(
										function() {
											//location.href = "${ pageContext.request.contextPath }/mentionWrite.do"
											$.ajax({
												'url' : "${ pageContext.request.contextPath }/mentionWrite.do",
												type: 'post',
												data : {
													commentNo : ${ board.comNo },
													mentionID: '${userVO.id}',
													mentionContent: $('#mentionContent').val()
												},
												success : function() {
												
													window.location.reload()
												}
											})
										})
					})
					 


//댓글 수정 					
					
					
					
					
					
//댓글삭제
 
	$(document).ready(
					function() {
						$('.deleteMention').click(function(){
							var no = $(this).attr("data");
							
							location.href="${pageContext.request.contextPath}/mentionDelete.do?mentionNo=" + no+"&comNo=${param.no}";
							
						});
					});
					
					
</script>
</head>
<body>
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
			<h2>&emsp;&emsp;리뷰 상세 보기</h2>
			<hr>
			<br>
			<table class="type02">
				<tr>
					<th >번호</th>
					<td style="padding-left: 10px">${ board.comNo }</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td style="padding-left: 10px">${ board.id }</td>
				</tr>
				<tr>
					<th>제목</th>
					<td style="padding-left: 10px">${ board.comTitle }</td>
				</tr>

				<tr>
					<th height="200px"><br><br><br>내용</th2>
					<td style="padding-left: 10px" >${ board.comContent }</td>
				</tr>
				<tr>
					<th>조회수</th>
					<td style="padding-left: 10px">${ board.viewCnt + 1 }</td>
				</tr>
				<tr>
					<th>등록일</th>
					<td  style="padding-left: 10px">${ board.regDate }</td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td style="padding-left: 10px"><c:forEach
							items="${ fileList }" var="file">
							<a
								href="${ pageContext.request.contextPath}/upload/${file.fileSaveName}">
								${ file.fileOriName } </a>
							(${ file.fileSize } bytes)<br>
						</c:forEach></td>
				</tr>
				<tr>
					<th width="100px" class="tg-ltmv" style="text-align: center;">좋아요
						수</th>
					<td width="500px" style="padding-left: 10px">${ board.comLikeCnt }</td>
				</tr>
			</table>

			<br>
			<button onclick="doAction('R')">답글</button>&emsp; 
			<c:if test="${ board.id eq userVO.id }">
				<button onclick="doAction('U')">수정</button>&emsp; 
			</c:if>
			<c:if test="${ board.id eq userVO.id || userVO.type == 'S'}">
				<button onclick="doAction('D')">삭제</button>&emsp; 
			</c:if>
			<button onclick="doAction('L')">목록</button>&emsp; 
			<c:if test="${ board.id ne userVO.id}">
				<button onclick="doAction('A')" id="like">좋아요</button>
			</c:if>

			<!-- 댓글  -->
			<hr>
		<h2>&nbsp;댓글</h2> <hr>

	

 <div class="container">
			<div id="mention">
				<table class="type3" >
					<!-- 댓글 목록 -->
					<!-- 공유영역 등록 ..했나..? -->
					<c:if test="${not empty requestScope.mentionList }">
						<c:forEach var="mention" items="${requestScope.mentionList}">

							<tr>
								<!-- 아이디, 작성날짜 -->
								<td>
									<div>
										${mention.mentionId}<br>${mention.regDate}</font>
									</div>
								</td>
								<!-- 본문내용 -->
								<td>
									<div>${mention.mentionContent}</div>
								</td>
							
								<!-- 버튼 -->
								<td>
									
										<!-- 댓글 작성자만 수정, 삭제 가능하도록 -->
										<c:if test="${mention.mentionId == sessionScope.userVO.id || userVO.type == 'S' }">
										

											<button class="updateMention" data="${mention.mentionNo }" >수정</button>
											<button class="deleteMention" data="${mention.mentionNo }" >삭제</button>
										</c:if>
									
								</td>
							</tr>
						</c:forEach>
					</c:if>


					<!-- 로그인 했을 경우만 댓글 작성가능 -->
					<c:if test="${sessionScope.userVO !=null}">
						<tr bgcolor="#F5F5F5">
						
								
									<!-- 아이디 뜨는 부분 -->
								<td width="155px">
									<div>${sessionScope.userVO.id}</div>

								</td>
								<!-- 댓글 적는 부분-->
								<td width="550px">
									<div>
										<textarea name="mentionContent" id="mentionContent" rows="4" cols="70" ></textarea>
									</div>
								</td>
								<!-- 댓글 등록 버튼 -->
								<td width="155px">
									<div id="btn" style="text-align: center;">
										<p>
											<button id="writeMention" >댓글등록</button>	
											<!-- type="submit" -->
										</p>
									</div>
								</td>
							
						</tr>
					</c:if>

				</table>
				<br>
			</div>
		</div>
		</div>





	</section>
	<footer>
		<%@ include file="/jsp/include/footer.jsp"%>
	</footer>
</body>
</html>