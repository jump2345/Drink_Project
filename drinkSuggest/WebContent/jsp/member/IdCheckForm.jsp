<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>idCheckForm</title>
<script>
	window.onload = function() {
		opener.document.regForm.flag = false
	}
</script>
</head>
<body>
	<div style="text-align: center">
		<h3>아이디 중복체크 </h3>
		
		<%
	 request.setCharacterEncoding("utf-8");
		%>
		<form method="post" 
		     action="${pageContext.request.contextPath}/idCheckPro.do"
			onsubmit="return blankCheck(this)">
			아이디 : <input type="text" name="id" maxlength="10" autofocus>
			<input type="submit" value="중복체크">
		</form>
	</div>
	<script>
		function blankCheck(f) {
			var id = f.id.value;
			id = id.trim();
			if (id.length < 2) {
				alert("아이디는 2자 이상~10자 이내로 입력해주십시오.");
				return false;
			}
			return true;
		}
	</script>
</body>
</html>
