<%@page import="kr.co.mlec.board.vo.BoardVO"%>
<%@page import="kr.co.mlec.board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>



<html>
<head>
<meta charset="UTF-8">
<title>글 수정 페이지</title>

<style type="text/css">
table.type02 {
	border-collapse: separate;
	border-spacing: 0;
	text-align: left;
	line-height: 1.5;
	border-top: 1px solid #ccc;
	border-left: 1px solid #ccc;
	margin: 20px 10px;
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
}

table.type02 td {
	width: 350px;
	padding: 10px;
	vertical-align: top;
	border-right: 1px solid #ccc;
	border-bottom: 1px solid #ccc;
}
</style>











<script>
	function doWrite() {
		let f = document.inputForm

		if (f.comTitle.value == '') {
			alert('제목을 입력하세요')
			f.comTitle.focus()
			return false
		}
		if (f.id.value == '') {
			alert('글쓴이를 입력하세요')
			f.id.focus()
			return false
		}
		if (f.comContent.value == '') {
			alert('내용을 입력하세요')
			f.comContent.focus()
			return false
		}
		return true
	}
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

	<div align="center">
		<hr>
		<h2>수정</h2>
		<hr>
		<br>
		<form action="${ pageContext.request.contextPath }/board/update.do"
			method="post" name="inputForm" onsubmit="return doWrite()">
			<input type="hidden" name="comNo" value="${ param.comNo }" />
			<%-- <input type="hidden" name="comNo" value="${ param.comNo }" /> --%>
			<%-- 	<input type="hidden" name="id" value="${ userVO.id }"> --%>


			<table class="type02">
				<tr>
					<th width="100px" class="tg-ltmv"
						style="text-align: center; font: bold;">번호</th>
					<td width="500px" style="padding-left: 10px">${ param.comNo }</td>

				</tr>
				<tr>
					<th width="100px" class="tg-ltmv"
						style="text-align: center; font: bold;">제목</th>
					<td width="500px" style="padding-left: 10px"><input
						type="text" name="comTitle"
						value="<c:out value='${ board.comTitle }'/>" /></td>
				</tr>
				<tr>
					<th width="100px" class="tg-ltmv"
						style="text-align: center; font: bold;">글쓴이</th>
					<td width="500px" style="padding-left: 10px">${ userVO.id }</td>
				</tr>
				<tr>
					<th width="100px" class="tg-ltmv"
						style="text-align: center; font: bold;">내용</th>
					<td width="500px" style="padding-left: 10px"><textarea
							name="comContent" rows="7" cols="60"> ${ board.comContent}</textarea>
					</td>
				</tr>
			</table>
			<br> <input type="submit" value="수정">
		</form>
	</div>
	<footer>
		<%@ include file="/jsp/include/footer.jsp"%>
	</footer>
</body>
</html>