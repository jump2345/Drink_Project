<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%    

String dkF1 = request.getParameter("dk_f1");
String strResult1 = String.format("%s",dkF1);

String dkF2 = request.getParameter("dk_f2");
String strResult2 = String.format("%s",dkF2);

String dkF3 = request.getParameter("dk_f3");
String strResult3 = String.format("%s",dkF3);

String dkF4 = request.getParameter("dk_f4");
String strResult4 = String.format("%s",dkF4);

String dkF5 = request.getParameter("dk_f5");
String strResult5 = String.format("%s",dkF5);

String dkF6 = request.getParameter("dk_f6");
String strResult6 = String.format("%s",dkF6);

String dkF7 = request.getParameter("dk_f7");
String strResult7 = String.format("%s",dkF7);

String dkF8 = request.getParameter("dk_f8");
String strResult8 = String.format("%s",dkF8);

String dkF9 = request.getParameter("dk_f9");
String strResult9 = String.format("%s",dkF9);

String dkF10 = request.getParameter("dk_f10");
String strResult10 = String.format("%s",dkF10);

%>
<!DOCTYPE html>


<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>음료 추천</title>
<meta name="description" content="GARO is a real-estate template">
<meta name="author" content="Kimarotec">
<meta name="keyword"
   content="html5, css, bootstrap, property, real-estate theme , bootstrap template">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link
   href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,700,800'
   rel='stylesheet' type='text/css'>

<jsp:include page="/jsp/include/topMenu.jsp" />

<script>
var strResult1 = <%=strResult1 %>
if(<%=strResult1 %> == "" || <%=strResult1 %> == null || <%=strResult1 %> == 'null'){
	
	var strResult1 = ${"아무것도 선택되지 않음"};
}




</script>

</head>

<body>
<c:set var="dkF1" value="<%=dkF1 %>"/>
<c:set var="dkF2" value="<%=dkF2 %>"/>
<c:set var="dkF3" value="<%=dkF3 %>"/>
<c:set var="dkF4" value="<%=dkF4 %>"/>
<c:set var="dkF5" value="<%=dkF5 %>"/>
<c:set var="dkF6" value="<%=dkF6 %>"/>
<c:set var="dkF7" value="<%=dkF7 %>"/>
<c:set var="dkF8" value="<%=dkF8 %>"/>
<c:set var="dkF9" value="<%=dkF9 %>"/>
<c:set var="dkF10" value="<%=dkF10 %>"/>

   <!-- End of nav bar -->

   <div class="page-head">
      <div class="container">
         <div class="row">
            <div class="page-head-content">
               <h1 class="page-title">옵션 결과창</h1>
            </div>
         </div>
      </div>
   </div>
   <!-- End page header -->
   <!-- drink suggest Result list -->
 	<br>
		 <div align="center"
			class="panel panel-default sidebar-menu wow  fadeInRight animated animated"
			style="visibility: visible; animation-name: fadeInRight;">
	    	<div class="panel-heading">
				<h5 class="panel-title">옵션에 따른 음료 추천 결과</h5>
			</div>
		</div>
	
		
		<div align ="center" class="row">
			<c:forEach items="${ drinks }" var="drink">
				<div class="col-xs-3">
					<strong> ${fn:substring(drink, 0, fn:length(drink)-2) }</strong><br>
				</div>
			</c:forEach>
	   </div>
	   <br>
	   
   <!-- option list -->
   <hr>
   <div align="center"
		class="panel panel-default sidebar-menu wow  fadeInRight animated animated"
		style="visibility: visible; animation-name: fadeInRight;">
    	<div class="panel-heading">
			<h5 class="panel-title">선택한 옵션 목록</h5>
		</div>
	</div>
	<div class="option">
  			  <h4 align="center">
			
			<c:if test="${ not empty dkF1 }">
				${ dkF1 } <br>
			</c:if>
			<c:if test="${ not empty dkF2 }">
				${ dkF2 } <br> 
			</c:if>
			<c:if test="${ not empty dkF3 }">
				${ dkF3 } <br> 
			</c:if>
			<c:if test="${ not empty dkF4 }">
				${ dkF4 } <br> 
			</c:if>
			<c:if test="${ not empty dkF5 }">
				${ dkF5 } <br> 
			</c:if>
			<c:if test="${ not empty dkF6 }">
				${ dkF6 } <br> 
			</c:if>
			<c:if test="${ not empty dkF7 }">
				${ dkF7 } <br> 
			</c:if>
			<c:if test="${ not empty dkF8 }">
				${ dkF8 } <br> 
			</c:if>
			<c:if test="${ not empty dkF9 }">
				${ dkF9 } <br> 
			</c:if>
			<c:if test="${ not empty dkF10 }">
				${ dkF10 } <br>
			</c:if>
 
  </h4>
   ${ result }
   </div>
 
   
   <!-- Footer area-->
<footer>
		<jsp:include page="/jsp/include/footer.jsp" />
</footer>

</body>
</html>
