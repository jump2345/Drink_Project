<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 첫화면 검색창에서 검색 시 넘어오는 화면. -->
<html class="no-js">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>coffee</title>
<meta name="description" content="GARO is a real-estate template">
<meta name="author" content="Kimarotec">
<meta name="keyword"
	content="html5, css, bootstrap, property, real-estate theme , bootstrap template">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,700,800'
	rel='stylesheet' type='text/css'>
<style>
	table.list td {
		padding: 5px;
	}
	table.list th {
		padding: 5px;
	}
</style>
</head>

<body>

	<jsp:include page="/jsp/include/topMenu.jsp" />
	<section>
		<div align="center">
			<hr>
			<h2>게시판 검색 목록</h2>
			<hr>
			<br>
			<table border="1" class="list  property-th-list">
				<tr>
					<th width="20%">글쓴이</th>
					<th width="30%">글제목</th>
					<th width="60%">글내용</th>
					<th width="20%">등록일</th>
					<th width="20%">조회수</th>
					<th width="20%">좋아요수</th>
					

				</tr>
					
				<c:forEach items="${ list }" var="searchBoard">
					<tr>
						<td>
						<c:if test="${param.ST eq 'id' }">
							<a href="javascript:doAction()">
						 		<c:out value="${ searchBoard.id }" />
							</a>
							</c:if>
							<c:if test="${param.ST ne 'id' }">
								<c:out value="${ searchBoard.id }" />
							</c:if>
						</td>
						<td>
							<c:if test="${param.ST eq 'comTitle' }">
							<a href="javascript:doAction()">
						 		<c:out value="${ searchBoard.comTitle }" />
							</a>
							</c:if>
							<c:if test="${param.ST ne 'comTitle' }">
								<c:out value="${ searchBoard.comTitle }" />
							</c:if>
						</td>
						<td>
						<c:if test="${param.ST eq 'comContent' }">
							<a href="javascript:doAction()">
						 		<c:out value="${ searchBoard.comContent }" />
							</a>
							</c:if>
							<c:if test="${param.ST ne 'comContent' }">
								<c:out value="${ searchBoard.comContent }" />
							</c:if>
						</td>
						<td>${ searchBoard.regDate }</td>
						<td>${ searchBoard.viewCnt }</td>
						<td>${ searchBoard.comLikeCnt }</td>

					</tr>
				</c:forEach>
	
				
			</table>

			<footer>
				<%@ include file="/jsp/include/footer.jsp"%>
			</footer>
</body>
</html>

