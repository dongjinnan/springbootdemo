$(function(){
	getCity();
	$('#seCity').change(function(){
		getWeather($(this).val())
	});
});

// 获取城市
function getCity() {
	$.ajax({
		type: 'get',
		url: '/city/',
		dataType: 'JSON',
		contentType: "application/json",
		success: function(result) {
			var citySelect = $('#seCity');
			if (result.data != null && result.data != '') {
				var cityList = result.data.split(",");
				if (cityList != null && cityList.length > 0) {
					for (var i in cityList) {
						citySelect.append("<option value='" + cityList[i] + "'>" + cityList[i] + "</option>");
					}
				}
			} else {
				citySelect.append("<option value='Dalian'>Dalian</option>");
			}
			getWeather(citySelect.val());
		}
	});
}

// 获取城市的天气状况
function getWeather(city){
    var param = {
        'city': city
    };

    $.ajax({
        type: 'get',
        url: '/weather/',
		dataType: 'JSON',
        data : param,
        success: function(result) {
			if (result.message == "success") {
				var data = JSON.parse(result.data);
				$(".alert-danger").css("display", "none");
				$('#city_name').text(data['name']);
				$('#update_time').text(timestampToTime(data['dt']));
				$('#weather').text(data['weather'][0]['description']);
				$('#temperature').text(data['main']['temp'] + '°C');
				$('#wind').text(data['wind']['speed'] + '米/秒');
			} else {
				$(".alert-danger").css("display", "block");
			}
        }
    });
}

// 解析时间戳
function timestampToTime(timestamp) {
	var date = new Date(timestamp*1000);
	var Y = date.getFullYear() + '-';
	var M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
	var D = (date.getDate() < 10 ? '0'+date.getDate() : date.getDate()) + ' ';
	var h = (date.getHours() < 10 ? '0'+date.getHours() : date.getHours()) + ':';
	var m = (date.getMinutes() < 10 ? '0'+date.getMinutes() : date.getMinutes()) + ':';
	var s = (date.getSeconds() < 10 ? '0'+date.getSeconds() : date.getSeconds());

	var strDate = Y+M+D+h+m+s;
	return strDate;
}