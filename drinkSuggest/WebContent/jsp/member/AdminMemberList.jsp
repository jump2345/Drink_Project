<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자모드 | 회원관리</title>
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
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,700,800'
	rel='stylesheet' type='text/css'>
<script
src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script type="text/javascript">
</script>
<script>


	function deleteMember() {
  
		var boardIdxArray = [];
		
  	  if($("input:checkbox[name=cchk]:checked").each(function(){
			boardIdxArray.push($(this).val());	  
	  }))
	  
  		  if (boardIdxArray == ""){
  		  alert("삭제할 회원을 선택해주세요.")
  	  } else{
		var answer = confirm("선택한 회원을 삭제하시겠습니까?");
		if (answer) {		
			
  		  
  		  var checkbox = $("input:checkbox[name='cchk']:checked");
  		  var seqArr = new Array();
  		  var chklist = $("input[name='cchk']");
  		  var data = '';
  		  
  		  for(var i=0; i<chklist.length; i++){
  			  if(chklist[i].checked){
  				  seqArr.push(chklist[i].value);
  				  if(data != '') data += '&'
  				  data += 'chkSeq=' + chklist[i].value; 
  			  }
  		  }
  		  console.log(seqArr, data);
  		  
  		  var params={
  				  "chkSeq":seqArr
  		  }
  		  
  		  $.ajax({
  	             
  	            type : "POST",
  	            url : "${pageContext.request.contextPath}/AdminDeleteMember.do",
  	            data : data,
	//  	          contentType: "application/json; charset=utf-8",
  	            error : function(){
  	                alert('통신실패!!');
  	            },
  	            success : function(data){
  	              alert('총 ' + data.trim() + '명의 회원이 삭제되었습니다')
  	              location.href="${pageContext.request.contextPath }/AdminMemberList.do"
  	            }
  	             
  	        });
		}
  	  }
	}
</script>
</head>
<body>
	<header>
		<jsp:include page="/jsp/include/topMenu.jsp" />
	</header>

	<!-- Body content -->
	<div class="page-head">
		<div class="container">
			<div class="row">
				<div class="page-head-content">
					<h1 class="page-title"><strong>관리자모드 회원 관리</strong></h1>
			</div>
		</div>
	</div>
</div>
	<!-- End page header -->

	<section>
		<div align="center">
			<div class="page-head-content" align="center">
				<hr>
				<h1 class="page-title">회원 목록</h1>
				<hr>
				<table border="1" class="list">
					<tr id="tr1">
						<th width="7%"></th>
						<th width="20%">아이디</th>
						<th width="20%">이름</th>
						<th width="20%">비밀번호</th>						
						<th width="20%">이메일</th>
						<th width="20%">전화번호</th>
					</tr>



					<c:forEach items="${ allMemberlist }" var="memberlist"  varStatus="status">
						<tr id="tr2">
						<td id="td1">
							<label class="checkbox-inline"> 
							<input type="checkbox" name="cchk" onclick="cchkClicked()" value="${ memberlist.id }">
							</label> 
						</td>
							<td id="td2"><input type="text" value="${ memberlist.id }"
								name=id/></td>
							<td id="td3"><input type="text" value="${ memberlist.name }"
								name="name" /></td>
							<td id="td4"><input type="text" value="${ memberlist.pw }"
								name="name" /></td>
							<td id="td5"><input type="text" value="${ memberlist.email }"
								name="email" /></td>
							<td id="td6"><input type="text"
								value="${ memberlist.tel }"
								name="tel" /></td>
							<td><input type="hidden" value="${ memberlist.id }" name=id${status.index} /></td>
								
						</tr>
					</c:forEach>
				</table>
			</div>

		</div>
		<button type="button" onclick="deleteMember()">회원 삭제</button>
		<br> <br>
		<jsp:include page="/jsp/member/AdminMemberPaging.jsp">
			<jsp:param value="${paging.page}" name="page" />
			<jsp:param value="${paging.beginPage}" name="beginPage" />
			<jsp:param value="${paging.endPage}" name="endPage" />
			<jsp:param value="${paging.prev}" name="prev" />
			<jsp:param value="${paging.next}" name="next" />
		</jsp:include>
		<br>


</section>
		<footer>
			<%@ include file="/jsp/include/footer.jsp"%>
		</footer>
</body>
</html>



