<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!-- 첫화면 검색창에서 검색 시 넘어오는 화면. -->
<html class="no-js">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title> Search Drink</title>
<meta name="description" content="GARO is a real-estate template">
<meta name="author" content="Kimarotec">
<meta name="keyword"
	content="html5, css, bootstrap, property, real-estate theme , bootstrap template">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,700,800'
	rel='stylesheet' type='text/css'>

<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
}

.tg td {
	border-color: black;
	border-style: solid;
	border-width: 1px;
	font-family: Arial, sans-serif;
	font-size: 14px;
	overflow: hidden;
	padding: 10px 5px;
	word-break: normal;
}

.tg th {
	border-color: black;
	border-style: solid;
	border-width: 1px;
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	overflow: hidden;
	padding: 10px 5px;
	word-break: normal;
}

.tg .tg-m9r4 {
	background-color: #ffcd58;
	text-align: left;
	vertical-align: top
}

.tg .tg-0lax {
	text-align: left;
	vertical-align: top
}
</style>


</head>

<body>

	<jsp:include page="/jsp/include/topMenu.jsp" />
	<section>
		<div align="center" class="container">
			<hr>
			<h2>검색 목록</h2>
			<hr>
			<br>
				<table class="table table-striped">
				<tr>
					<th width="40%" class="tg-m9r4" style="text-align: center">제품명</th>
					<th width="20%" class="tg-m9r4" style="text-align: center">브랜드</th>
					<th width="20%" class="tg-m9r4" style="text-align: center">가격</th>

				</tr>

				<c:forEach items="${ list }" var="search">
					<tr>
						<td style="text-align: center" >
						<a href="javascript:doAction()"> 
						<c:out value="${ fn:substring(search.dk_name, 0,fn:length(search.dk_name)-2) }" />
						</a></td>
						<td style="text-align: center">${ search.dk_store }</td>
						<td style="text-align: center">${ search.dk_price }</td>

					</tr>
				</c:forEach>

				<c:forEach items="${ list2 }" var="search">
					<tr>

						<td style="text-align: center">${ fn:substring(search.dk_name, 0,fn:length(search.dk_name)-2) }</td>
						<td style="text-align: center"><a
							href="javascript:doAction()"> <c:out
									value="${ search.dk_store }" />
						</a></td>

						<td style="text-align: center">${ search.dk_price }</td>

					</tr>
				</c:forEach>


			</table>
			</div>
			</section>
			
			<br>
			<footer>
				<%@ include file="/jsp/include/footer.jsp"%>
			</footer>
</body>
</html>
