<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Starbucks menu</title>
<meta name="description" content="GARO is a real-estate template">
<meta name="author" content="Kimarotec">
<meta name="keyword"
	content="html5, css, bootstrap, property, real-estate theme , bootstrap template">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,700,800'
	rel='stylesheet' type='text/css'>

<jsp:include page="/jsp/include/topMenu.jsp" />
</head>
<body>
	<div class="page-head">
		<div class="container">
			<div class="row">
				<div class="page-head-content">
					<h1 class="page-title">Starbucks menu/ 스타벅스 메뉴 </h1>
				</div>
			</div>
		</div>
	</div>
	<!-- End page header -->
	<br>
	<br>
 	
 	<div align="center" class="container">
    <table class="table table-striped">
    	<div align="center"
			class="panel panel-default sidebar-menu wow  fadeInRight animated animated"
			style="visibility: visible; animation-name: fadeInRight;">
    		<div class="panel-heading">
				<h5 class="panel-title">스타벅스 메뉴</h5>
			</div>
		</div>
				<tr>
	              <th> ◻ ︎메뉴 이름 </th>
	               <th> ◻ 아이스/핫 </th>  
	               <th> ◻ 커피 </th>
	               <th> ◻ 물 or 우유 </th>           
	               <th> ◻ 티 </th>            
	               <th> ◻ 콜드브루 종류 </th>            
	               <th> ◻ 블렌디드  </th>            
	               <th> ◻ 토핑 </th>            
	               <th> ◻ 시럽 </th>            
	               <th> ◻ 펄  </th>            
	               <th> ◻ 병음료 </th>            
	               <th> ◻ 가격 </th>             
	            </tr>

            	<c:forEach items="${ drinkList }" var ="drinkList">
	             	<tr> 
	              	  <td>${ fn:substring(drinkList.dk_name, 0, fn:length(drinkList.dk_name)-2) }</td>  <!-- drinkList.뒤에는 sql의 컬럼명을 사용함 -->
	                  <td>${ drinkList.dk_f1 }</td>
	                  <td>${ drinkList.dk_f2 }</td>
	                  <td>${ drinkList.dk_f3 }</td>              	
	                  <td>${ drinkList.dk_f4 }</td>
	                  <td>${ drinkList.dk_f5 }</td>              	
	                  <td>${ drinkList.dk_f6 }</td>
	                  <td>${ drinkList.dk_f7 }</td>              	
	                  <td>${ drinkList.dk_f8 }</td>
	                  <td>${ drinkList.dk_f9 }</td>              	
	                  <td>${ drinkList.dk_f10 }</td>
	                  <td>${ drinkList.dk_price}</td>              	
	               </tr>
	  			</c:forEach>
  			</table>
  		<!-- 페이징 영역  -->
  			<br>
 	       <jsp:include page="/jsp/drink/starbucksPaging.jsp">
	            <jsp:param value="${paging.page}" name="page" />
	            <jsp:param value="${paging.beginPage}" name="beginPage" />
	            <jsp:param value="${paging.endPage}" name="endPage" />
	            <jsp:param value="${paging.prev}" name="prev" />
	            <jsp:param value="${paging.next}" name="next" />
         	</jsp:include>
   </div>
		<br>
	<!--footer 영역 -->
	<footer>
		<jsp:include page="/jsp/include/footer.jsp" />
	</footer>
</body>
</html>
