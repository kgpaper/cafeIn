//Naver Map

				var mapOptions = {
					center: new naver.maps.LatLng(35.136683, 129.1005749),
					zoom: 17,
					scaleControl: false,
					logoControl: false,
					mapDataControl: false,
					zoomControl: true
				};

				const markerOptions = {
					position: new naver.maps.LatLng(35.136683, 129.1005749),
					map: map
				};

				var map = new naver.maps.Map('map', mapOptions);

				var marker = new naver.maps.Marker({
					position: new naver.maps.LatLng(35.136683, 129.1005749),
					map: map
				});

				function onSuccessGeolocation(position) {
					var location = new naver.maps.LatLng(position.coords.latitude,
							position.coords.longitude);

					map.setCenter(location); // 얻은 좌표를 지도의 중심으로 설정
					map.setZoom(17); // 지도의 줌 레벨을 변경

					console.log('Coordinates: ' + location.toString());
				}

				function onErrorGeolocation() {
					var center = map.getCenter();

					infowindow.setContent('<div style="padding:20px;">' +
							'<h5 style="margin-bottom:5px;color:#f00;">Geolocation failed!</h5>'+ "latitude: "+ center.lat() +"<br />longitude: "+ center.lng() +'</div>');

					infowindow.open(map, center);
				}

				$(window).on("load", function() {
					if (navigator.geolocation) {
						/**
						 * navigator.geolocation 은 Chrome 50 버젼 이후로 HTTP 환경에서 사용이 Deprecate 되어 HTTPS 환경에서만 사용 가능 합니다.
						 * http://localhost 에서는 사용이 가능하며, 테스트 목적으로, Chrome 의 바로가기를 만들어서 아래와 같이 설정하면 접속은 가능합니다.
						 * chrome.exe --unsafely-treat-insecure-origin-as-secure="http://example.com"
						 */
						navigator.geolocation.getCurrentPosition(onSuccessGeolocation, onErrorGeolocation);
					} else {
						var center = map.getCenter();
						infowindow.setContent('<div style="padding:20px;"><h5 style="margin-bottom:5px;color:#f00;">위치정보를 파악할 수 없습니다</h5></div>');
						infowindow.open(map, center);
					}
				});

					var contentString = [
					'<div class="iw_inner">',
					'   <h3>경성대 할리스 1호점</h3>',
					'   <p>부산 남구 용소로 7 청라빌딩<br /></p>',
					'	<img src="images/hollys1.jpeg" width="140" height="120" alt="경성대 할리스 1호점1" class="thumb" /><br />',
					'   <p><a href="#">예약하기</a></p>',
					'</div>'
				].join('');

				var infowindow = new naver.maps.InfoWindow({
					content: contentString
				});

				naver.maps.Event.addListener(marker, "click", function(e) {
					if (infowindow.getMap()) {
						infowindow.close();
					} else {
						infowindow.open(map, marker);
					}
				});