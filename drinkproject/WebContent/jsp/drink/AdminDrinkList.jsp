<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자모드 | 음료관리</title>

<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,700,800'
	rel='stylesheet' type='text/css'>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
	function doAction(type) {

		switch (type) {
		case 'A':

			var boardIdxArray = [];

			if ($("input:checkbox[name=cchk]:checked").each(function() {
				boardIdxArray.push($(this).val());
			}))

				if (boardIdxArray != "") {
					alert("체크박스가 선택되어있습니다. 해제 후 음료를 추가하세요.")
				} else {

					window
							.open(
									"${pageContext.request.contextPath }/AdminAddDrinkForm.do",
									'window',
									'width=900, height=500, menubar=no, status=no, toolbar=no , left=500, top=50');
				}

			break;
		}
		switch (type) {
		case 'U':

			var boardIdxArray = [];

			if ($("input:checkbox[name=cchk]:checked").each(function() {
				boardIdxArray.push($(this).val());
			}))

				if (boardIdxArray.length > 1) {
					alert("수정할 항목을 하나만 선택하세요")
					return false
				}

			if (boardIdxArray == "") {
				alert("수정할 항목을 선택해주세요.")
			} else {

				var checkbox = $("input:checkbox[name='cchk']:checked");
				var seqArr = new Array();
				var chklist = $("input[name='cchk']");

				for (var i = 0; i < chklist.length; i++) {
					if (chklist[i].checked) {
						seqArr = chklist[i].value;
					}
				}
				console.log(seqArr);

				var params = {
					"chkSeq" : seqArr
				}
				alert("수정할 음료 : " + seqArr)
				window
						.open(
								"${pageContext.request.contextPath }/AdminUpdateDrinkForm.do?dk_name="
										+ seqArr, 'window',
								'width=900, height=500, menubar=no, status=no, toolbar=no');
			}
			break;

		}
		switch (type) {
		case 'D':
			var boardIdxArray = [];

			if ($("input:checkbox[name=cchk]:checked").each(function() {
				boardIdxArray.push($(this).val());
			}))

				if (boardIdxArray == "") {
					alert("삭제할 항목을 선택해주세요.")
				} else {
					var answer = confirm("선택한 음료를 삭제하시겠습니까?");
					if (answer) {

						var checkbox = $("input:checkbox[name='cchk']:checked");
						var seqArr = new Array();
						var chklist = $("input[name='cchk']");
						var data = '';
						for (var i = 0; i < chklist.length; i++) {
							if (chklist[i].checked) {
								seqArr.push(chklist[i].value);
								if (data != '')
									data += '&'
								data += 'chkSeq=' + chklist[i].value;
							}
						}
						console.log(seqArr, data);

						var params = {
							"chkSeq" : seqArr
						}

						$
								.ajax({

									type : "POST",
									url : "${pageContext.request.contextPath }/AdminDeleteDrink.do",
									data : data,
									error : function() {
										alert('통신실패!!');
									},
									success : function(data) {
										//  alert("삭제할 음료 이름 : " + data) ;
										alert('총 ' + data.trim()
												+ '개 음료 삭제되었습니다')
										location.href = "${pageContext.request.contextPath }/AdminDrinkList.do"
									}

								});
					}
				}
			break;
		}
	}
<%%>
	
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
					<h1 class="page-title">관리자모드 음료 관리</h1>
				</div>
			</div>
		</div>
	</div>
	<!-- End page header -->


	<section>
		<form>
			<input type="hidden" name="dk_name" value="${ drink.dk_name }" />
			<div align="center" class="container">
				<div class="page-head-content" align="center">
					<hr>
					<h1 class="page-title">음료 목록</h1>
					<hr>
					 <table class="table table-striped">
						<tr>
							<th width="3%"></th>
							<th width="9%">메뉴 이름</th>
							<th width="4%">아이스/핫</th>
							<th width="7%">커피</th>
							<th width="7%">물 or 우유</th>
							<th width="7%">티</th>
							<th width="7%">콜드브루 종류</th>
							<th width="7%">블렌디드</th>
							<th width="7%">토핑</th>
							<th width="7%">시럽</th>
							<th width="7%">펄</th>
							<th width="7%">병음료</th>
							<th width="7%">브랜드</th>
							<th width="7%">가격</th>
						</tr>

						<c:forEach items="${ allDrinkList }" var="drink">
							<tr>
								<td><label class="checkbox-inline"> <input
										type="checkbox" name="cchk" onclick="cchkClicked()"
										value="${ drink.dk_name }">
								</label></td>
								<td><input type="text" value="${ drink.dk_name }"
									name="cchk" /></td>
								<td><input type="text" value="${ drink.dk_f1 }" name="cchk" /></td>
								<td><input type="text" value="${ drink.dk_f2 }" name="cchk" /></td>
								<td><input type="text" value="${ drink.dk_f3 }" name="cchk" /></td>
								<td><input type="text" value="${ drink.dk_f4 }" name="cchk" /></td>
								<td><input type="text" value="${ drink.dk_f5 }" name="cchk" /></td>
								<td><input type="text" value="${ drink.dk_f6 }" name="cchk" /></td>
								<td><input type="text" value="${ drink.dk_f7 }" name="cchk" /></td>
								<td><input type="text" value="${ drink.dk_f8 }" name="cchk" /></td>
								<td><input type="text" value="${ drink.dk_f9 }" name="cchk" /></td>
								<td><input type="text" value="${ drink.dk_f10 }"
									name="cchk" /></td>
								<td><input type="text" value="${ drink.dk_store }"
									name="cchk" /></td>
								<td><input type="text" value="${ drink.dk_price} 원"
									name="cchk" /></td>
							</tr>
						</c:forEach>
					</table>
				</div>

			</div>
			<button type="button" onclick="doAction('A')">음료 추가</button>
			<button type="button" onclick="doAction('U')">음료 수정</button>
			<button type="button" onclick="doAction('D')">음료 삭제</button>


			<br>
			<jsp:include page="/jsp/drink/AdminDrinkPaging.jsp">
				<jsp:param value="${paging.page}" name="page" />
				<jsp:param value="${paging.beginPage}" name="beginPage" />
				<jsp:param value="${paging.endPage}" name="endPage" />
				<jsp:param value="${paging.prev}" name="prev" />
				<jsp:param value="${paging.next}" name="next" />
			</jsp:include>
			<br>

		</form>
	</section>
	<footer>
		<%@ include file="/jsp/include/footer.jsp"%>
	</footer>
</body>
</html>
