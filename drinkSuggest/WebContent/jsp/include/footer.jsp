<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- Footer -->
	<div class="footer-area">

		<div class=" footer">
			<div class="container">
				<div class="row">


					<div class="col-md-3 col-sm-6 wow fadeInRight animated">
						<div class="single-footer">
							<h4>음료 ABOUT US</h4>
							<div class="footer-title-line"></div>

							<img src="${pageContext.request.contextPath}/assets/img/drinklogo2.jpeg" alt="" class="wow pulse"
								data-wow-delay="1s">
							<p>모두가 맛있는 음료를 찾는 그 날까지...</p>
							<ul class="footer-adress">
								<li><i class="pe-7s-map-marker strong"> </i> 서울시</li>
								<li><i class="pe-7s-mail strong"> </i>
									aboutdrink@gmail.com</li>
								<li><i class="pe-7s-call strong"> </i> 02)1234-5678</li>
							</ul>
						</div>
					</div>




					<div class="col-md-3 col-sm-6 wow fadeInRight animated">
						<div class="single-footer">
							<h4>빠른 메뉴</h4>
							<div class="footer-title-line"></div>
							<ul class="footer-menu">
								<li><a href="${pageContext.request.contextPath }/drinkMenu.do">음료 메뉴</a></li>
								<li><a href="${ pageContext.request.contextPath}/board/list.do">리뷰 쓰기</a></li>
								
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="footer-copy text-center">
			<div class="container">
				<div class="row">
					<div class="pull-left">
						<span> (C) <a href="http://www.KimaroTec.com">4조 음료이야기</a>
							, 4조 2022
						</span>
					</div>
					<div class="bottom-menu pull-right">
						<ul>
							<li><a class="wow fadeInUp animated" href="${pageContext.request.contextPath}/index.jsp"
								data-wow-delay="0.2s">첫 화면</a></li>
							<li><a class="wow fadeInUp animated" href="#"
								data-wow-delay="0.3s">맨 위로</a></li>
								
								
								
						
								
								
						</ul>
					</div>
				</div>
			</div>
		</div>

	</div>


	<script src="${pageContext.request.contextPath }/assets/js/modernizr-2.6.2.min.js"></script>

	<script src="${pageContext.request.contextPath }/assets/js/jquery-1.10.2.min.js"></script>
	<script src="${pageContext.request.contextPath }/bootstrap/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath }/assets/js/bootstrap-select.min.js"></script>
	<script src="${pageContext.request.contextPath }/assets/js/bootstrap-hover-dropdown.js"></script>

	<script src="${pageContext.request.contextPath }/assets/js/easypiechart.min.js"></script>
	<script src="${pageContext.request.contextPath }/assets/js/jquery.easypiechart.min.js"></script>

	<script src="${pageContext.request.contextPath }/assets/js/owl.carousel.min.js"></script>

	<script src="${pageContext.request.contextPath }/assets/js/wow.js"></script>

	<script src="${pageContext.request.contextPath }/assets/js/icheck.min.js"></script>
	<script src="${pageContext.request.contextPath }/assets/js/price-range.js"></script>


	<script src="${pageContext.request.contextPath }/assets/js/jquery.ba-cond.min.js"></script>
	<script src="${pageContext.request.contextPath }/assets/js/jquery.slitslider.js"></script>

	<script src="${pageContext.request.contextPath }/assets/js/main.js"></script>

	<script type="text/javascript">
		$(function() {

			var Page = (function() {

				var $nav = $('#nav-dots > span'), slitslider = $('#slider')
						.slitslider({
							onBeforeChange : function(slide, pos) {

								$nav.removeClass('nav-dot-current');
								$nav.eq(pos).addClass('nav-dot-current');

							}
						}), init = function() {

					initEvents();

				}, initEvents = function() {

					$nav.each(function(i) {

						$(this).on('click', function(event) {

							var $dot = $(this);

							if (!slitslider.isActive()) {

								$nav.removeClass('nav-dot-current');
								$dot.addClass('nav-dot-current');

							}

							slitslider.jump(i + 1);
							return false;

						});

					});

				};

				return {
					init : init
				};

			})();

			Page.init();

			/**
			 * Notes: 
			 * 
			 * example how to add items:
			 */

			/*
			 
			 var $items  = $('<div class="sl-slide sl-slide-color-2" data-orientation="horizontal" data-slice1-rotation="-5" data-slice2-rotation="10" data-slice1-scale="2" data-slice2-scale="1"><div class="sl-slide-inner bg-1"><div class="sl-deco" data-icon="t"></div><h2>some text</h2><blockquote><p>bla bla</p><cite>Margi Clarke</cite></blockquote></div></div>');
			 
			 // call the plugin's add method
			 ss.add($items);
			 
			 */

		});
	</script>
</body>
</html>

