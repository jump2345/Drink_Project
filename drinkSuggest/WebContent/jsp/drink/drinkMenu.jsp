<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!-- 첫화면 탑메뉴에서 메뉴보기 누르고 커피 눌렀을 때 넘어오는 화면입니다. -->
<html class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>coffee</title>
        <meta name="description" content="GARO is a real-estate template">
        <meta name="author" content="Kimarotec">
        <meta name="keyword" content="html5, css, bootstrap, property, real-estate theme , bootstrap template">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,700,800' rel='stylesheet' type='text/css'>
		<jsp:include page="/jsp/include/topMenu.jsp" />
    </head>
    
    <body>
           <!-- Body content -->
        <div class="page-head"> 
            <div class="container">
                <div class="row">
                    <div class="page-head-content">
                        <h1 class="page-title">음료 이야기 </h1>               
                    </div>
                </div>
            </div>
        </div>
        <!-- End page header -->
        <!-- property area -->
        <div class="content-area recent-property" style="background-color: #FCFCFC; padding-bottom: 55px;">
            <div class="container">
                <div class="row">
                    <div class="col-md-10 col-md-offset-1 col-sm-12 text-center page-title">
                        <!-- /.feature title -->
                        <h2> 음료 상세보기</h2>
                        <p>음료 메뉴를 자세히 살펴볼 수 있습니다. </p>
                    </div>
                </div>

                <div class="row">
                    <div class="proerty-th">
                        <div class="col-sm-6 col-md-3 p0">
                            <div class="box-two proerty-item">
                                <div class="item-thumb">
                                    <a href="${pageContext.request.contextPath}/starbucks.do" ><img src="${pageContext.request.contextPath}/assets/img/demo/starbucks.jpg"></a>
                                </div>
                                <div class="item-entry overflow">
                               
                                    <h5><a href="property-1.html" > 스타벅스(StarBucks) </a></h5>
                                    <div class="dot-hr"></div>
                                    <span class="pull-left"><b>coffee & non_coffee </b> -----  </span>
                                    <span class="proerty-price pull-right">자세한 정보는 사진을 클릭하세요</span>
                                </div>
                            </div> 
                        </div>

                        <div class="col-sm-6 col-md-3 p0">
                            <div class="box-two proerty-item">
                                <div class="item-thumb">
                                    <a href="${pageContext.request.contextPath}/gongcha.do" ><img src="${pageContext.request.contextPath}/assets/img/demo/gong-cha.jpg"></a>
                                </div>
                                <div class="item-entry overflow">
                                    <h5><a href="property-2.html" > 공차(gong-cha) </a></h5>
                                    <div class="dot-hr"></div>
                                    <span class="pull-left"><b>tea & pearl</b> -----  </span>
                                    <span class="proerty-price pull-right">자세한 정보는 사진을 클릭하세요</span>
                                </div>
                            </div>
                        </div>

                         <div class="col-sm-6 col-md-3 p0">
                            <div class="box-tree more-proerty text-center">
                                <div class="item-tree-icon">
                                    <i class="fa fa-th"></i>
                                </div>
                                <div class="more-entry overflow">
                                    <h5><a href="${pageContext.request.contextPath }/drinkSuggest.do" > 특별한 메뉴를 원하세요? </a></h5>
                                    <h5 class="tree-sub-ttl">추천 페이지를 이용해보세요 아주 맘에 들것입니다</h5>
                                    <button class="btn border-btn more-black" value="All properties"
                                    type ="submit"
	                                 onclick ="location.href ='${pageContext.request.contextPath }/drinkSuggest.do'">
                                     추천 받기 </button>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
 
    </body>
	<footer>
		<jsp:include page="/jsp/include/footer.jsp" />
	</footer>

</body>
</html>

