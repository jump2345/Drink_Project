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
<style>  
body { background: #fff; }
.list {
  border-collapse: collapse;
  border-top: 3px solid #553830;
}  
.list th {
  color: #553830;
  background: #ffcd58;
}
.list th, .list td {
  padding: 10px;
  border: 1px solid #ddd;
}
.list th:first-child, .list td:first-child {
  border-left: 0;
}
.list th:last-child, .list td:last-child {
  border-right: 0;
}
</style>
<jsp:include page="/jsp/include/topMenu.jsp" />

</head>
<body>
	<div class="page-head">
		<div class="container">
			<div class="row">
				<div class="page-head-content">
					<h1 class="page-title">Gongcha/ 공차 메뉴 </h1>
				</div>
			</div>
		</div>
	</div>
	<!-- End page header -->
	<br>
	<br>
 	<div align="center">
    <table border="1" class="list">
    <div align="center"
			class="panel panel-default sidebar-menu wow  fadeInRight animated animated"
			style="visibility: visible; animation-name: fadeInRight;">
    		<div class="panel-heading">
				<h5 class="panel-title">공차 메뉴</h5>
			</div>
		</div>
            <tr>
	               <th width="20%">&nbsp; ◻ ︎메뉴 이름 </th>
	               <th width="7%">&nbsp; ◻ 아이스/핫 </th>  
	               <th width="7%">&nbsp; ◻ 커피 </th>
	               <th width="7%">&nbsp; ◻ 물 or 우유 </th>           
	               <th width="7%">&nbsp; ◻ 티 </th>            
	               <th width="7%">&nbsp; ◻ 콜드브루 종류 </th>            
	               <th width="7%">&nbsp; ◻ 블렌디드  </th>            
	               <th width="7%">&nbsp; ◻ 토핑 </th>            
	               <th width="7%">&nbsp; ◻ 시럽 </th>            
	               <th width="7%">&nbsp; ◻ 펄  </th>            
	               <th width="7%">&nbsp; ◻ 병음료 </th>            
	               <th width="7%">&nbsp; ◻ 가격 </th>            
	            </tr>
            <c:forEach items="${ drinkListG }" var ="drinkListG">
             	<tr>
                  <td>${ fn:substring(drinkListG.dk_name, 0, fn:length(drinkListG.dk_name)-2) }</td>   <!-- drinkList.뒤에는 sql의 컬럼명을 사용함 -->
                  <td>${ drinkListG.dk_f1 }</td>
                  <td>${ drinkListG.dk_f2 }</td>
                  <td>${ drinkListG.dk_f3 }</td>              	
                  <td>${ drinkListG.dk_f4 }</td>
                  <td>${ drinkListG.dk_f5 }</td>              	
                  <td>${ drinkListG.dk_f6 }</td>
                  <td>${ drinkListG.dk_f7 }</td>              	
                  <td>${ drinkListG.dk_f8 }</td>
                  <td>${ drinkListG.dk_f9 }</td>              	
                  <td>${ drinkListG.dk_f10 }</td>
                  <td>${ drinkListG.dk_price}</td>              	
               </tr>
  			</c:forEach>
  			</table>
  			<br>
 	       <jsp:include page="/jsp/drink/gongchaPaging.jsp">
	            <jsp:param value="${paging.page}" name="page" />
	            <jsp:param value="${paging.beginPage}" name="beginPage" />
	            <jsp:param value="${paging.endPage}" name="endPage" />
	            <jsp:param value="${paging.prev}" name="prev" />
	            <jsp:param value="${paging.next}" name="next" />
         	</jsp:include>
         <br>
   </div>
	<br>
	<br>

<footer>
		<jsp:include page="/jsp/include/footer.jsp" />
	</footer>
</body>
</html>
