	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>

	function like(boardNo) {
		$.ajax({
			url : "${pageContext.request.contextPath}/like.do",
			cache : false,
			data : {
				'comNo': boardNo
			},
												// 파라미터 전송 형태(표준 쿼리형태)로 만들어줌
			success : function(data) { // ajax통신 성공시 넘어오는 데이터 통째 이름 =data
				alert("'좋아요'가 반영되었습니다!"); // data중 put한 것의 이름 like
				//$("#like_result").html(data.like); // id값이 like_result인 html을 찾아서
													// data.like값으로 바꿔준다.
			},
			error : function(request, status, error) {
				alert("ajax실패")
			}
		});
	}


</script>

</head>
<form id="like_form">
	<table id="list">
		<tr>
			<input type="button" value="좋아요♥" onclick="like('comNo')">
		</tr>
		<tr>
			<div id="like_result">${board.like}</div>
		</tr>
	</table>
</form>


<body>
</body>
</html>

