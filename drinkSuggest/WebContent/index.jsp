<%@page import="kr.co.mlec.drink.vo.DrinkVO"%>
<%@page import="kr.co.mlec.drink.dao.DrinkDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.net.URLEncoder"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html class="no-js">
<head>
<meta charset="utf-8">

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>음료와 추천... 그 사이...</title>
<meta name="description" content="GARO is a real-estate template">
<meta name="author" content="Kimarotec">
<meta name="keyword"
	content="html5, css, bootstrap, property, real-estate theme , bootstrap template">
<meta name="viewport" content="width=device-width, initial-scale=1">


</head>
<body>
<%

 request.setCharacterEncoding("utf-8");
 
	String search= "";
	
	if(request.getParameter("search") != null){
		search = request.getParameter("search");
	}
%>

	<jsp:include page="/jsp/include/topMenu.jsp" />


	<div class="slider-area">
		<div class="slider">
			<div id="bg-slider" class="owl-carousel owl-theme">

				<div class="item">
					<img src="assets/img/slide1/cafepic3.png" alt="GTA V">
				</div>
				<div class="item">
					<img src="assets/img/slide1/cafepic2.png" alt="The Last of us">
				</div>
				<div class="item">
					<img src="assets/img/slide1/coffee02.jpeg" alt="GTA V">
				</div>

			</div>
		</div>


<%


	
	ArrayList<DrinkVO> drinklist = new ArrayList<DrinkVO>();
	ArrayList<DrinkVO> drinklist2 = new ArrayList<DrinkVO>();

	drinklist = new DrinkDAO().DrinkSearchByname(search);
	drinklist2 = new DrinkDAO().DrinkSearchBystore(search);
	
	if(drinklist !=null)
		for(int i = 0; i<drinklist.size(); i++){
			DrinkVO search2 = drinklist.get(i); 
		}
	
	if(drinklist2 !=null)
		for(int i = 0; i<drinklist2.size(); i++){
			DrinkVO search2 = drinklist2.get(i); 
		}	
	
	

%>

		<div class="slider-content">
			<div class="row">
				<div
					class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1 col-sm-12">
					<h2>검색창</h2>
					<p>당신의 음료를 찾으세요!</p>

					<div class="search-form wow pulse" data-wow-delay="0.8s">

						<form action="${ pageContext.request.contextPath }/searchMenu.do" method="get" class=" form-inline">


							<button class="btn toggle-btn" type="button">
								<i class="fa fa-bars"></i>
								<!--= 이거 생기는거  -->
							</button>

							<div class="form-group">
								<input type="text" name="search" class="form-control"
									placeholder="검색할 메뉴나 가게명을 입력하세요!">
							</div>



							<button class="btn search-btn" type="submit">
								<i class="fa fa-search"></i>
							</button>
							<div style="display: none;" class="search-toggle"></div>


						</form>
					</div>
				</div>
			</div>
		</div>



		<!-- property area -->
		<div class="content-area home-area-1 recent-property"
			style="background-color: #FCFCFC; padding-bottom: 55px;">
			<div class="container">
				<div class="row">
					<div
						class="col-md-10 col-md-offset-1 col-sm-12 text-center page-title">
						<!-- /.feature title -->
						<h2>음료 추천 & 리뷰 확인 하기</h2>
						<p> 음료 고민 될 때 아래의 메뉴를 이용하세요 도움이 될겁니다.</p>
					</div>
				</div>
				<div class="row" >
					<div class="proerty-th">
					
						<div class="col-sm-6 col-md-3 p0" >
							<div class="box-two proerty-item">
								<div class="item-thumb">
									<a href="${pageContext.request.contextPath }/drinkSuggest.do">
										<img src="assets/img/demo/cafepic4.png">
									</a>
								</div>
								<div class="item-entry overflow">
									<h5>
									<a href="${pageContext.request.contextPath }/drinkSuggest.do">음료 탐색 시작 </a>				
									</h5>
									<div class="dot-hr"></div>
									<span class="pull-left"> 커피메뉴 </span> <span
										class="proerty-price pull-right">목록 보기</span>
								</div>
							</div>
						</div>

				
				
						<div class="col-sm-6 col-md-3 p0">
							<div class="box-tree more-proerty text-center">
								<div class="item-tree-icon">
									<i class="fa fa-th"></i>
								</div>
								<div class="more-entry overflow">
									<h5>
										<a href="${ pageContext.request.contextPath}/board/list.do"> 리뷰를 확인해 보세요! </a>
									</h5>
									<h5 class="tree-sub-ttl">더 나은 선택을 위해...</h5>
									<button class="btn border-btn more-black" value="All properties"
									 type ="submit"
									 onclick ="location.href ='${pageContext.request.contextPath }/drinkSuggest.do'">
									                     
									 추천받기</button>
								</div>
							</div>
						</div>



					</div>
				</div>
			</div>
		</div>

		<!--다른부분-->
		<div class="testimonial-area recent-property"
			style="background-color: #FCFCFC; padding-bottom: 15px;">
			<div class="container">
				<div class="row">
					<div
						class="col-md-10 col-md-offset-1 col-sm-12 text-center page-title">


						<!-- /.feature title -->
						<h2>F4 구성원 소개</h2>
					</div>
				</div>

				<div class="row">
					<div class="row testimonial">
						<div class="col-md-12">
							<div id="testimonial-slider">
								<div class="item">
									<div class="client-text">
										<p>F4 리더 구준표</p>
										<h4>
											<strong>이신혜 </strong><i>Web developer</i>
										</h4>
									</div>
									<div class="client-face wow fadeInRight" data-wow-delay=".9s">
										<img src="assets/img/liger.jpg" alt="">
									</div>
								</div>
								<div class="item">
									<div class="client-text">
										<p>F4 프린스송</p>
										<h4>
											<strong>최현정</strong><i>Web developer</i>
										</h4>
									</div>
									<div class="client-face">
										<img src="assets/img/kkangkkang2.png" alt="">
									</div>
								</div>
								<div class="item">
									<div class="client-text">
										<p>F4 이정선배</p>
										<h4>
											<strong>원윤서</strong><i>Web developer</i>
										</h4>
									</div>
									<div class="client-face">
										<img src="assets/img/geoji.png" alt="">
									</div>
								</div>
								<div class="item">
									<div class="client-text">
										<p>F4 명예소방관</p>
										<h4>
											<strong>최윤선</strong><i>Web Developer</i>
										</h4>
									</div>
									<div class="client-face">
										<img src="assets/img/gwangsu.jpg" alt="">
									</div>
								</div>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>


	<footer>
		<jsp:include page="/jsp/include/footer.jsp" />
	</footer>
		
</body>
</html>