<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>답글 등록 페이지</title>
<style>

 	hr, table {
 		width: 80%
 	}
 </style>
 <script>
 	function doWrite(){
 		let f = document.inputForm
 		
 		if(f.title.value == ''){
 			alert('제목을 입력하세요')
 			f.title.focus()
 			return false
 			}
		if(f.writer.value == ''){
			alert('글쓴이를 입력하세요')
			f.writer.focus()
			return false
		}
		if(f.content.value == ''){
			alert('내용을 입력하세요')
			f.content.focus()
			return false
		}
 			return true
 	}
 </script> 
 <%/* 
 //게시글 읽기에서 답변 클릭하면 넘겨주는 데이터들을 받는다
 	int comNo = Integer.parseInt(request.getParameter("no"));
 	int groupNo = Integer.parseInt(request.getParameter("group_no"));
 	int reNo = Integer.parseInt(request.getParameter("re_no"));
 	int reLevel = Integer.parseInt(request.getParameter("re_level")); */
  %>
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
                        <h1 class="page-title">리뷰이야기</h1>               
                    </div>
                </div>
            </div>
        </div>
        <!-- End page header -->
   
	<section>
	<div align = "center">
		<hr>
		<h2>답글등록</h2>
		<hr>
		<br>
		<form action ="${ pageContext.request.contextPath }/board/reply.do" method="post" name = "inputForm"  onsubmit = "return doWrite()"
		enctype ="multipart/form-data">	
			<input type="hidden" name="id" value="${userVO.id }">
			<input type="hidden" name="comNo" value="${param.no }">
			<table border = "1">
			<tr>
				<th width ="25%">제목</th>
				<td>
					<input type ="text" name = "comTitle" value= "RE : ${ board.comTitle }">
				</td>
			</tr>
			<tr>
				<th width = "25%">글쓴이</th>
				<td>
					${ userVO.id }	
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<textarea name ="comContent" rows ="7" cols="60" required></textarea>
				</td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td>
					<input type ="file" name ="attachfile1"><br>
					<input type ="file" name ="attachfile2"><br>
				</td>
			</tr>
			</table>
			<br>
			<input type = "submit" value = "답글 등록">
		</form>
	</div>
	</section>
	<footer>
		<%@ include file="/jsp/include/footer.jsp" %>
	</footer>
</body>
</html>






