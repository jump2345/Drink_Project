<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 모드 음료 추가</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	function doWrite() {
		let f = document.inputForm

		if (f.dkName.value == '') {
			alert('음료 이름 입력하세요')
			f.dkName.focus()
			return false
		}

		if (f.dkStore.value == '') {
			alert('상호명 입력하세요')
			f.dkStore.focus()
			return false
		}
		if (f.dkPrice.value == '') {
			alert('음료 가격을 입력하세요')
			f.dkPrice.focus()
			return false
		}

		if ($(':radio[name="dkF1"]:checked').length < 1) {
			alert('Feature 1 을 선택하세요')
			$(':input:radio[name="dkF1"]:eq(0)').focus();
			return false
		}
		if ($(':radio[name="dkF2"]:checked').length < 1) {
			alert('Feature 2 를 선택하세요')
			$(':input:radio[name="dkF2"]:eq(0)').focus();
			return false
		}
		if ($(':radio[name="dkF3"]:checked').length < 1) {
			alert('Feature 3 를 선택하세요')
			$(':input:radio[name="dkF3"]:eq(0)').focus();
			return false
		}
		if ($(':radio[name="dkF4"]:checked').length < 1) {
			alert('Feature 4 를 선택하세요')
			$(':input:radio[name="dkF4"]:eq(0)').focus();
			return false
		}
		if ($(':radio[name="dkF5"]:checked').length < 1) {
			alert('Feature 5 를 선택하세요')
			$(':input:radio[name="dkF5"]:eq(0)').focus();
			return false
		}
		if ($(':radio[name="dkF6"]:checked').length < 1) {
			alert('Feature 6 를 선택하세요')
			$(':input:radio[name="dkF6"]:eq(0)').focus();
			return false
		}
		if ($(':radio[name="dkF7"]:checked').length < 1) {
			alert('Feature 7 을 선택하세요')
			$(':input:radio[name="dkF7"]:eq(0)').focus();
			return false
		}
		if ($(':radio[name="dkF8"]:checked').length < 1) {
			alert('Feature 8 을 선택하세요')
			$(':input:radio[name="dkF8"]:eq(0)').focus();
			return false
		}
		if ($(':radio[name="dkF9"]:checked').length < 1) {
			alert('Feature 9 을 선택하세요')
			$(':input:radio[name="dkF9"]:eq(0)').focus();
			return false
		}
		if ($(':radio[name="dkF10"]:checked').length < 1) {
			alert('Feature 10 을 선택하세요')
			$(':input:radio[name="dkF10"]:eq(0)').focus();
			return false
		}
		var answer = confirm("음료를 추가하시겠습니까?");
		if (answer) {
			//opener.window.location.reload();
	//		window.close();
			return true
  			//location.href = "${pageContext.request.contextPath }/AdminDrinkList.do"
		}
		return false
	}
</script>
</head>
<body>
	<!-- Body content -->
	<div class="page-head">
		<div class="container">
			<div class="row">
				<div class="page-head-content">
					<h1 class="page-title" align="center">음료 추가</h1>
				</div>
			</div>
		</div>
	</div>
	<!-- End page header -->


	<section>
		<div align="center">
			<form action="${ pageContext.request.contextPath }/AdminAddDrink.do"
				method="post" name="inputForm" onsubmit="return doWrite()">
				음료 이름<br> <br>
				<hr width="50%">
				<input type="text" id="dkName" name="dkName" size="20"
					placeholder="음료 이름 입력"><br>
				
				<br> Feature 1 <hr width="50%">
				<input type="radio" id="ice" name="dkF1" value="ice"> ice <br>
				<input type="radio" id="hot" name="dkF1" value="hot"> hot <br>
				
				<br>Feature 2 <br>
				<hr width="50%">

				<input type="radio" id="coffee" name="dkF2" value="coffee">
				coffee <br> <input type="radio" id="non_coffee" name="dkF2"
					value="non_coffee"> non_coffee <br>
				
				<br>Feature 3 <br>
				<hr width="50%">

				<input type="radio" id="water" name="dkF3" value="water">
				water <br> <input type="radio" id="milk" name="dkF3"
					value="milk"> milk <br>
			
				<br>Feature 4 <br> <hr width="50%">

				<input type="radio" id="teabag" name="dkF4" value="teabag">
				teabag <br> <input type="radio" id="no_teabag" name="dkF4"
					value="no_teabag"> no_teabag <br>
				
				<br>Feature 5 <br> <hr width="50%">

				<input type="radio" id="coldbrew" name="dkF5" value="coldbrew">
				coldbrew <br> <input type="radio" id="hotbrew" name="dkF5"
					value="hotbrew"> hotbrew <br> <input type="radio"
					id="nonbrew" name="dkF5" value="nonbrew"> nonbrew <br>
			
				<br>Feature 6 <br> <hr width="50%">

				<input type="radio" id="blended" name="dkF6" value="blended">
				blended <br> <input type="radio" id="no_blended" name="dkF6"
					value="no_blended"> no_blended <br>
				
				<br>Feature 7 <br><hr width="50%">
				<input type="radio" id="no_topping" name="dkF7" value="no_topping">
				no_topping <br> <input type="radio" id="chip" name="dkF7"
					value="chip"> chip <br> <input type="radio"
					id="whipping" name="dkF7" value="whipping"> whipping <br>
				<input type="radio" id="oreo" name="dkF7" value="oreo"> oreo
				<br>
				
				<br>Feature 8 <br><hr width="50%">

				<input type="radio" id="syrup" name="dkF8" value="syrup">
				syrup <br> <input type="radio" id="no_syrup" name="dkF8"
					value="no_syrup"> no_syrup <br>
				
				<br>Feature 9 <br> <hr width="50%">

				<input type="radio" id="pearl" name="dkF9" value="pearl">
				pearl <br> <input type="radio" id="no_pearl" name="dkF9"
					value="no_pearl"> no_pearl <br>
				
				<br>Feature 10 <br> <hr width="50%">

				<input type="radio" id="bottle" name="dkF10" value="bottle">
				bottle <br> <input type="radio" id="no_bottle" name="dkF10"
					value="no_bottle"> no_bottle <br>
				
				<br>상호명 <br><hr width="50%">
				<input type="text" id="dkStore" name="dkStore" size="20"
					placeholder="상호명 입력"><br>
				
				<br>음료가격<br><hr width="50%">
				<input type="text" id="dkPrice" name="dkPrice" size="20"
					placeholder="음료 가격 입력"> 원<br>
				
				<br> <br> <input type="submit" value="음료 추가 하기"> <br>
				<br> <br> <br> <br>
			</form>
		</div>
	</section>
</body>
</html>
