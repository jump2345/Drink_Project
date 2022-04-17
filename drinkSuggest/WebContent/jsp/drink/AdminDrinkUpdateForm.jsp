<%@page import="kr.co.mlec.member.vo.MemberVO"%>
<%@page import="kr.co.mlec.member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%    
    request.setCharacterEncoding("UTF-8");
	String dkName = request.getParameter("cchk");	
	String dkName0 = request.getParameter("cchk0");	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 모드 음료 수정</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	

<script>
function doWrite(){
		let f = document.inputForm
		

	if(f.dkStore.value == ''){
		alert('상호명 입력하세요')
		f.dkStore.focus()
		return false
	}
	if(f.dkPrice.value == ''){
		alert('음료 가격을 입력하세요')
		f.dkPrice.focus()
		return false
	}
	
	if ($(':radio[name="dk_f1"]:checked').length<1) {
		alert('Feature 1 을 선택하세요')
		$(':input:radio[name="dk_f1"]:eq(0)').focus();
		return false    
	}
	if ($(':radio[name="dk_f2"]:checked').length<1) {
		alert('Feature 2 를 선택하세요')
		$(':input:radio[name="dk_f2"]:eq(0)').focus();
		return false    
	}
	if ($(':radio[name="dk_f3"]:checked').length<1) {
		alert('Feature 3 를 선택하세요')
		$(':input:radio[name="dk_f3"]:eq(0)').focus();
		return false    
	}
	if ($(':radio[name="dk_f4"]:checked').length<1) {
		alert('Feature 4 를 선택하세요')
		$(':input:radio[name="dk_f4"]:eq(0)').focus();
		return false    
	}
	if ($(':radio[name="dk_f5"]:checked').length<1) {
		alert('Feature 5 를 선택하세요')
		$(':input:radio[name="dk_f5"]:eq(0)').focus();
		return false    
	}
	if ($(':radio[name="dk_f6"]:checked').length<1) {
		alert('Feature 6 를 선택하세요')
		$(':input:radio[name="dk_f6"]:eq(0)').focus();
		return false    
	}
	if ($(':radio[name="dk_f7"]:checked').length<1) {
		alert('Feature 7 을 선택하세요')
		$(':input:radio[name="dk_f7"]:eq(0)').focus();
		return false    
	}
	if ($(':radio[name="dk_f8"]:checked').length<1) {
		alert('Feature 8 을 선택하세요')
		$(':input:radio[name="dk_f8"]:eq(0)').focus();
		return false    
	}
	if ($(':radio[name="dk_f9"]:checked').length<1) {
		alert('Feature 9 을 선택하세요')
		$(':input:radio[name="dk_f9"]:eq(0)').focus();
		return false    
	}
	if ($(':radio[name="dk_f10"]:checked').length<1) {
		alert('Feature 10 을 선택하세요')
		$(':input:radio[name="dk_f10"]:eq(0)').focus();
		return false    
	}
	var answer = confirm("음료 정보를 수정하시하겠습니까?");
	if (answer) {
		return true

	}
			
	}
	
</script>
</head>
<body>
           <!-- Body content -->
        <div class="page-head"> 
            <div class="container">
                <div class="row">
                    <div class="page-head-content">
                        <h1 class="page-title" align="center">음료 정보 수정</h1>               
                    </div>
                </div>
            </div>
        </div>
        <!-- End page header -->
<div align="center">
<hr><br>
<h2>수정할 음료 : ${ drink.dk_name } </h2>
		<br><hr>
		
	<form action="${ pageContext.request.contextPath }/AdminUpdateDrink.do"
		method="post" name = "inputForm" onsubmit = "return doWrite()">
	<input type="hidden" name="dk_name" value="${ drink.dk_name }" />
		<br>Feature 1 <br> 
				이전 선택 : ${drink.dk_f1 } <br><hr width="50%">
		<input type="radio" id="ice" name="dk_f1"
			value="ice"> ice <br> <input type="radio" id="hot"
			name="dk_f1" value="hot"> hot <br>
		
		<br>Feature 2 <br>
						이전 선택 : ${drink.dk_f2 } <br><hr width="50%">
		
		 <input type="radio" id="coffee"
			name="dk_f2" value="coffee"> coffee <br> <input
			type="radio" id="non_coffee" name="dk_f2" value="non_coffee">
		non_coffee <br>
	
		<br>Feature 3 <br>
						이전 선택 : ${drink.dk_f3 } <br><hr width="50%">
		
		 <input type="radio" id="water"
			name="dk_f3" value="water"> water <br> <input
			type="radio" id="milk" name="dk_f3" value="milk"> milk <br>
	
		<br>Feature 4 <br> 
						이전 선택 : ${drink.dk_f4 } <br><hr width="50%">
		
		<input type="radio" id="teabag"
			name="dk_f4" value="teabag"> teabag <br> <input
			type="radio" id="no_teabag" name="dk_f4" value="no_teabag">
		no_teabag <br>
		
		<br>Feature 5 <br>
						이전 선택 : ${drink.dk_f5 } <br><hr width="50%">
		
		 <input type="radio" id="coldbrew"
			name="dk_f5" value="coldbrew"> coldbrew <br> <input
			type="radio" id="hotbrew" name="dk_f5" value="hotbrew">
		hotbrew <br> <input type="radio" id="nonbrew" name="dk_f5"
			value="nonbrew"> nonbrew <br>
	
		<br>Feature 6 <br>
						이전 선택 : ${drink.dk_f6 } <br><hr width="50%">
		
		 <input type="radio" id="blended"
			name="dk_f6" value="blended"> blended <br> <input
			type="radio" id="no_blended" name="dk_f6" value="no_blended">
		no_blended <br>
	
		<br>Feature 7 <br>
						이전 선택 : ${drink.dk_f7 } <br><hr width="50%">
		
		 <input type="radio" id="no_topping"
			name="dk_f7" value="no_topping"> no_topping <br> <input
			type="radio" id="chip" name="dk_f7" value="chip"> chip <br>
		<input type="radio" id="whipping" name="dk_f7" value="whipping">
		whipping <br> <input type="radio" id="oreo" name="dk_f7"
			value="oreo"> oreo <br>
	
		<br>Feature 8 <br>
						이전 선택 : ${drink.dk_f8 } <br><hr width="50%">
		
		
		<input type="radio" id="syrup" name="dk_f8" value="syrup">
		syrup <br>
		<input type="radio" id="no_syrup" name="dk_f8" value="no_syrup">
		no_syrup <br>

		<br>Feature 9 <br>
		
						이전 선택 : ${drink.dk_f9 } <br><hr width="50%">
		
		<input type="radio" id="pearl" name="dk_f9" value="pearl">
		pearl <br>
		<input type="radio" id="no_pearl" name="dk_f9" value="no_pearl">
		no_pearl <br>

		<br>Feature 10 <br>
						이전 선택 : ${drink.dk_f10 } <br><hr width="50%">
		
		
		<input type="radio" id="bottle" name="dk_f10" value="bottle">
		bottle <br>
		<input type="radio" id="no_bottle" name="dk_f10" value="no_bottle">
		no_bottle <br>

		상호명 <br> 
		이전 상호명 : ${drink.dk_store } <br><hr width="50%">
		<input type="text" id="dk_store" name="dk_store" size="20"
			placeholder="상호명 입력"><br>

		음료가격<br> 
		이전 가격 : ${drink.dk_price } 원<br><hr width="50%">
		<input type="text" id="dk_price" name="dk_price" size="20"
			placeholder="음료 가격 입력"><br>

		<br> <br>


		<input type = "submit" value="음료 수정하기">
		<br>
		<br>
		<br>
		<br>
		<br>
	</form>
	</div>
</body>
</html>
