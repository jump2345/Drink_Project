<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>

<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>drinkSuggest</title>
<meta name="description" content="GARO is a real-estate template">
<meta name="author" content="Kimarotec">
<meta name="keyword"
	content="html5, css, bootstrap, property, real-estate theme , bootstrap template">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,700,800'
	  rel='stylesheet' type='text/css'>

<jsp:include page="/jsp/include/topMenu.jsp" />
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/jquery-latest.js"></script>

<style>
.absolute {
	position: relative;
	left: 500px;
	bottom: 120px;
	width: 200px;
	height: 100px;

}
</style>

<script type="text/javascript">


	function CheckForm() {

		var chk1 = $("input:checkbox[name='dk_f1']").is(":checked");
		var chk2 = $("input:checkbox[name='dk_f2']").is(":checked");
		var chk3 = $("input:checkbox[name='dk_f3']").is(":checked");
		var chk4 = $("input:checkbox[name='dk_f4']").is(":checked");
		var chk5 = $("input:checkbox[name='dk_f5']").is(":checked");
		var chk6 = $("input:checkbox[name='dk_f6']").is(":checked");
		var chk7 = $("input:checkbox[name='dk_f7']").is(":checked");
		var chk8 = $("input:checkbox[name='dk_f8']").is(":checked");
		var chk9 = $("input:checkbox[name='dk_f9']").is(":checked");
		var chk10 = $("input:checkbox[name='dk_f10']").is(":checked");

		if(chk1 && chk2 && chk3 && chk4 && chk5 && chk6 && chk7 && chk8 && chk9 && chk10){
			alert("이렇게 많이 선택했군요!")
		}

		if (!chk1 && !chk2 && !chk3 && !chk4 && !chk5 && !chk6 && !chk7 && !chk8 && !chk9 && !chk10) {
			
			alert("항목을 선택해주세요!")
			return false;
			
		}else {

			return true;
			}
		}
	
	
</script>
</head>

<body>
	<div class="page-head">
		<div class="container">
			<div class="row">
				<div class="page-head-content">
					<h1 class="page-title">추천 받기</h1>
				</div>
			</div>
		</div>
	</div>
	<!-- End page header -->


	<!-- 선택창 -->
	<div class="properties-area recent-property"
		style="background-color: #FFF;">
		<div class="container">
			<div class="row  pr0 padding-top-40 properties-page">
				<div class="col-md-12 padding-bottom-40 large-search">
					<div class="search-form wow pulse">
						<form action="${pageContext.request.contextPath}/drinkSuggestResult.do"
							class=" form-inline" 
							name="selectForm"
							onSubmit="return CheckForm(this)">
								<input type ="hidden" name ="result" value = "${ result }">
							<!-- 안쪽...  -->

							<%-- <button type="submit"
									onclick=" window.open('${pageContext.request.contextPath}/drinkSuggestResult.do')">결과보기!!!!!
								</button> --%>
				<div align="center"
					 class="panel panel-default sidebar-menu wow  fadeInRight animated animated"
					 style="visibility: visible; animation-name: fadeInRight;">
    				<div class="panel-heading">
						<h5 class="panel-title">나만의 메뉴 선택하기</h5>
					</div>
				</div>

							<!-- 선택 옵션 창  -->
							<!-- <form class="search-row"> -->
							<div class="col-sm-3">
								<hr>
								<h6>
									1. Ice/Hot
									</h6>
									<div class="checkbox" name="dk_f1">
										<label> <input type="checkbox" value="ice"
											name="dk_f1"> ice
										</label> &nbsp; &nbsp; <label> <input type="checkbox"
											value="hot" name="dk_f1"> hot
										</label>
									</div>
									<hr>
							</div>

							<!-- End of  -->

							<div class="col-sm-3">
								<hr>
								<h6>
									2. Coffee
									</h6>
									<div class="checkbox" name="dk_f2">
										<label> <input type="checkbox" value="coffee"
											name="dk_f2"> coffee
										</label> &nbsp; &nbsp; <label> <input type="checkbox"
											value="non_coffee" name="dk_f2"> non-coffee
										</label>
									</div>
									<hr>
							</div>
							<!-- End of  -->
							<div class="col-sm-3">
								<hr>
								<h6>
									3. Water or Milk
									</h6>
									<div class="checkbox" name="dk_f3">
										<label> <input type="checkbox" name="dk_f3"
											value="water"> water
										</label> &nbsp; &nbsp; <label> <input type="checkbox"
											name="dk_f3" value="milk"> milk
										</label>

									</div>
									<hr>
							</div>
							<!-- End of  -->
							<div class="col-sm-3">
								<hr>
								<h6>
									4. Tea
									</h6>
									<div class="checkbox" name="dk_f4">
										<label> <input type="checkbox" name="dk_f4"
											value="teabag"> teabag
										</label> &nbsp; &nbsp; <label> <input type="checkbox"
											name="dk_f4" value="no_teabag"> no_teabag
										</label>
									</div>
									<hr>
							</div>
							<!-- End of  -->


							<!-- End of  -->

							<div class="col-sm-3">
								<hr>
								<h6>
									5. Blended
									</h6>
									<div class="checkbox" name="dk_f6">
										<label> <input type="checkbox" name="dk_f6"
											value="blended"> blended
										</label> &nbsp; &nbsp; <label> <input type="checkbox"
											name="dk_f6" value="no_blended"> no_blended
										</label>
									</div>
									<hr>
							</div>
							
							<div class="col-sm-3">
								<hr>
								<h6>
									6. syrup
									</h6>
									<div class="checkbox" name="dk_f8">
										<label> <input type="checkbox" name="dk_f8"
											value="syrup"> syrup
										</label> &nbsp; &nbsp; <label> <input type="checkbox"
											name="dk_f8" value="no_syrup"> no_syrup
										</label>
									</div>
									<hr>
							</div>

							<div class="col-sm-3">
								<hr>
								<h6>
									7. pearl
									</h6>

									<div class="checkbox" name="dk_f9">
										<label> <input type="checkbox" name="dk_f9"
											value="pearl"> pearl
										</label> &nbsp; &nbsp; <label> <input type="checkbox"
											name="dk_f9" value="no_pearl"> no_pearl
										</label>

									</div>
									<hr>
							</div>
							<div class="col-sm-3">
								<hr>
								<h6>6. Bottle</h6>
								<div class="checkbox" name="dk_f10">
									<label> <input type="checkbox" name="dk_f10"
										value="bottle"> bottle
									</label> &nbsp; &nbsp; <label> <input type="checkbox"
										name="dk_f10" value="no_bottle"> no_bottle
									</label>

								</div>
								<hr>
							</div>

							<div class="col-sm-3">
								<hr>
								<h6>
									9. topping(음료 위 토핑)
									</h6>
									<div class="checkbox" name="dk_f7">
										<label> <input type="checkbox" name="dk_f7"
											value="no_topping"> no_topping
										</label> &nbsp; &nbsp;<label> <input type="checkbox"
											name="dk_f7" value="chip"> chip
										</label> &nbsp; &nbsp; <label> <input type="checkbox"
											name="dk_f7" value="whipping"> whipping
										</label> &nbsp; &nbsp; <label> <input type="checkbox"
											name="dk_f7" value="oreo"> oreo
										</label>

									</div>
									<hr>
							</div>
							<div class="col-sm-3">
								<hr>
								<h6>
									10. brew
									</h6>
									<div class="checkbox" name="dk_f5">
										<label> <input type="checkbox" name="dk_f5"
											value="coldbrew"> coldbrew
										</label> &nbsp; &nbsp; <label> <input type="checkbox"
											name="dk_f5" value="hotbrew"> hotbrew
										</label> &nbsp; &nbsp; <label> <input type="checkbox"
											name="dk_f5" value="nonbrew"> nonbrew
										</label>
									</div>

									<hr>
									<button type="submit" class="absolute"><h4>결과 확인하기</h4></button>
							</div>
						</form>
						<!-- End of  -->
					</div>
				</div>
			</div>

		</div>
	</div>



	<!-- Footer area-->

	<footer>
		<jsp:include page="/jsp/include/footer.jsp" />
	</footer>
</body>
</html>

