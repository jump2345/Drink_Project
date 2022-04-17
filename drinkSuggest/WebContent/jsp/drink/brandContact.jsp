<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Contact</title>
<meta name="description" content="GARO is a real-estate template">
<meta name="author" content="Kimarotec">
<meta name="keyword"
	content="html5, css, bootstrap, property, real-estate theme , bootstrap template">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,700,800'
	rel='stylesheet' type='text/css'>
<jsp:include page="/jsp/include/topMenu.jsp" />
<style type="text/css">
#map {
  width: 400px;
  height: 400px;
  margin: 0 auto;
}
</style>
</head>

<body>

        <!-- Body content -->
        <div class="page-head"> 
            <div class="container">
                <div class="row">
                    <div class="page-head-content">
                        <h1 class="page-title">음료이야기 소개</h1>               
                    </div>
                </div>
            </div>
        </div>
    <!-- End page header -->
        
	<!-- 맵 -->
	<br>
	<div align="center"
		class="panel panel-default sidebar-menu wow  fadeInRight animated animated"
		style="visibility: visible; animation-name: fadeInRight;">
    	<div class="panel-heading">
			<h5 class="panel-title">맵 </h5>
		</div>
	</div>
	
	<!-- 실제 맵 표시  -->
	<div id="map" style="width:800px; height:350px;"></div>
		<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=fc1decdc61a022daf1035880a8c89526"></script>
		<script>
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
	    	mapOption = { 
		        center: new kakao.maps.LatLng(37.472383, 126.896012), // 지도의 중심좌표
		        level: 3 // 지도의 확대 레벨
		    };
	
		var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
		 
		// 마커를 표시할 위치와 title 객체 배열입니다 
		var positions = [
		    {
		        title: '새싹', 
		        latlng: new kakao.maps.LatLng(37.472383, 126.896012)
		    },
		    {
		        title: '스타벅스 독산사거리점', 
		        latlng: new kakao.maps.LatLng(37.4716967, 126.8980181)
		    },
		    {
		        title: '공차 금천독산점', 
		        latlng: new kakao.maps.LatLng(37.46951, 126.8948208)
		    },
		   
		];
	
		// 마커 이미지의 이미지 주소입니다
		var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 
		    
		for (var i = 0; i < positions.length; i ++) {
		    
		    // 마커 이미지의 이미지 크기 입니다
		    var imageSize = new kakao.maps.Size(24, 35); 
		    
		    // 마커 이미지를 생성합니다    
		    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
		    
		    // 마커를 생성합니다
		    var marker = new kakao.maps.Marker({
		        map: map, // 마커를 표시할 지도
		        position: positions[i].latlng, // 마커를 표시할 위치
		        title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
		        image : markerImage // 마커 이미지 
		    });
		}
		</script>
		<hr>
		
		<!-- 맵 -->
		<br>
		<div align="center"
			class="panel panel-default sidebar-menu wow  fadeInRight animated animated"
			style="visibility: visible; animation-name: fadeInRight;">
	    	<div class="panel-heading">
				<h5 class="panel-title">contact us </h5>
			</div>
		</div>

        <!-- property area -->
        <div class="content-area recent-property padding-top-40" style="background-color: #FFF;">
            <div class="container">  
                <div class="row">
                    <div class="col-md-8 col-md-offset-2"> 
                        <div class="" id="contact1">                        
                            <div class="row">
                                <div class="col-sm-4">
                                    <h3><i class="fa fa-map-marker"></i> 주소</h3>
                                    <p>새싹...
                                        <br>금천구 가산로 70...
                                        <br>
                                        <strong>구로디지털단지......</strong>
                                        <br>사실은 6번버스를 타야 올 수 있는..
                                        <br>도보 30분 거리
                                    </p>
                                </div>
                                <!-- /.col-sm-4 -->
                                <div class="col-sm-4">
                                    <h3><i class="fa fa-phone"></i> 소개된 음료</h3>
                                    <p class="text-muted">
                                    <a href="https://www.starbucks.co.kr/index.do" target='_blank'><strong><h5>스타벅스 공식사이트 바로가기</h5></strong></a>
                                    <a href="https://www.starbucks.co.kr/store/store_map.do?disp=quick" target='_blank'><h5>스타벅스 매장 찾기</h5></a>
                                    <p class="text-muted">
                                    <hr><a href="https://www.gong-cha.co.kr/brand/" target='_blank'><strong><h5>공차 공식사이트 바로가기</h5></strong></a>
                                    <a href="https://www.gong-cha.co.kr/brand/store/search.php" target='_blank'><h5>공차 매장 찾기</h5></a>

                                </div>
                                <!-- /.col-sm-4 -->
                                <div class="col-sm-4">
                                    <h3><i class="fa fa-envelope"></i> 음료이야기</h3>
                                    <p class="text-muted">음료이야기는 여러분의 이야기를 기다립니다. 사이트 이용 건의사항 및 회원 이용 문의는 이메일로 연락주세요.</p>
                                    <ul>
                                        <li><strong><a href="mailto:">aboutdrink@gmail.com</a></strong>   </li>
                                    </ul>
                                </div>
                            </div>
                            <hr>
                        </div>
                    </div>    
                </div>
            </div>
        </div>
      <footer>
		<jsp:include page="/jsp/include/footer.jsp" />
	</footer>
</body>
</html>




