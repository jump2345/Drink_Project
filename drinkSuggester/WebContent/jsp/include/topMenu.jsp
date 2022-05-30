
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html class="no-js">
<!--<![endif]-->
<head>
<meta charset="utf-8">

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>커피와 빵</title>
<meta name="description" content="GARO is a real-estate template">
<meta name="author" content="Kimarotec">
<meta name="keyword"
	content="html5, css, bootstrap, property, real-estate theme , bootstrap template">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,700,800'
	rel='stylesheet' type='text/css'>

<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
<link rel="icon" href="favicon.ico" type="image/x-icon">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/normalize.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/fontello.css">
<link
	href="${pageContext.request.contextPath}/assets/fonts/icon-7-stroke/css/pe-icon-7-stroke.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/assets/fonts/icon-7-stroke/css/helper.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/assets/css/animate.css"
	rel="stylesheet" media="screen">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/bootstrap-select.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/icheck.min_all.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/price-range.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/owl.carousel.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/owl.theme.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/owl.transitions.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/responsive.css">


<nav class="navbar navbar-default ">
	<div class="container">
		<!-- 스크롤 되서 메뉴 보여줌 삭제 x -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navigation">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>


			<!-- 로고 넣어야함 =>이미지 -->
			<a class="navbar-brand" href="${ pageContext.request.contextPath }"><img
				src="${ pageContext.request.contextPath }/assets/img/drinklogo2.jpeg"
				alt=""></a>

		</div>
		<!-- 로그인 미완이-->
      <div class="collapse navbar-collapse yamm" id="navigation">

         <div class="button navbar-right">

            <%-- 버튼아닌애
                <a href="${pageContext.request.contextPath }/logout.do">로그아웃</a> --%>
            
            <c:if test="${ empty userVO }">
               <button class="navbar-btn nav-button wow bounceInRight login"
                  onclick="location.href =('${pageContext.request.contextPath}/register.do')"      
                  data-wow-delay="0.45s">로그인</button>
               
            </c:if>
            
            

            <c:if test="${ not empty userVO }">
          [${ userVO.id }님] 환영합니다!
               <a href="${pageContext.request.contextPath }/logout.do">
                  <button type="submit"
                     onclick=" location.href =('${pageContext.request.contextPath}/logout.do')"   
                     data-wow-delay="0.45s">로그아웃</button>
               </a>
            </c:if>
                       
                       <!-- 링크넣기 admin으로 로그인했을때만 뜸 -->
                        <%-- onclick=" location.href =('${pageContext.request.contextPath}/logout.do')"    --%>
                  <c:if test="${  userVO.type == 'S' }">
                 <a href="${pageContext.request.contextPath }/AdminMemberList.do">                
                 <button type="submit" data-wow-delay="0.45s">관리자모드  회원관리</button>
                 </a>
                 <a href="${pageContext.request.contextPath }/AdminDrinkList.do">                
                 <button type="submit" data-wow-delay="0.45s">관리자모드  음료관리</button>
                 </a>
				</c:if>
         </div>
      </div>

		<!-- 메뉴 부분 적기! -->

		<ul class="main-nav nav navbar-nav navbar-right">
			<li class="dropdown ymm-sw " data-wow-delay="0.1s"><a
				href="${pageContext.request.contextPath }/drinkMenu.do" class="dropdown-toggle active"
				data-toggle="dropdown" data-hover="dropdown" data-delay="200">
					메뉴 보기 <b class="caret"></b>
			</a>
				<ul class="dropdown-menu navbar-nav">
					<li><a
						href="${ pageContext.request.contextPath }/drinkMenu.do">음료</a></li>
				</ul></li>

			<li class="wow fadeInDown" data-wow-delay="0.2s"><a class=""
				href="${ pageContext.request.contextPath}/board/list.do">리뷰 게시판</a></li>



			<li class="wow fadeInDown" data-wow-delay="0.2s">
			<a class=""
				href="${ pageContext.request.contextPath }/drinkSuggest.do">음료 추천 </a></li>
				
				
				

			<li class="wow fadeInDown" data-wow-delay="0.5s">
			<a href="${ pageContext.request.contextPath }/brandContact.do">음료 사이트 소개</a></li>
		</ul>
	</div>
	<!-- /.navbar-collapse -->
	
</nav>
<!-- End of nav bar -->
