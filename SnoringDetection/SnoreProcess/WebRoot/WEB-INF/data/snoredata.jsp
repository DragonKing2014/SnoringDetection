<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>您的数据</title>
		<script src="js/jquery-3.2.1.min.js"></script>
		<script src="js/highcharts.js"></script>
		<script src="js/highcharts-3d.js"></script>
		<style type="text/css">
			#data {
				color: deepskyblue;
			}
			
			#container {
				text-align: center;
			}
			
			#topbar {
				background-color: gold;
			}
			
			#welcome {
				color: orangered;
			}
		</style>
	</head>

	<body>
		<div id="container">
			<div id="topbar">
				<br />
				<h1 id="welcome">${welcome}!</h1>
				<br />
			</div>
			<br />

			<div id="databar">
				<h4>您当天一共开启了${count}次鼾声监测</h4>
				<!--<c:forEach items="${datas}" var="data">
					<div id="data">${data.startTime}</div>
				</c:forEach>-->
				<hr />
				<c:forEach items="${pageDatas}" var="pageData">
					
					<div style="font-size: 20px;font-weight: bolder;">${pageData.startDetectTime}时间开启第${pageData.id}次监测</div>
					<br /><br />
					
					<div id="pageData">监测到最大响度鼾声开始时刻：${pageData.snoreMaxMoment}</div>
					<div>监测到打鼾的总时长为：${pageData.snoreTime}秒</div>
					<div>监测到鼾声较大的时长为：${pageData.snoreBigTime}秒</div>
					<div>监测到正常打鼾的时长为：${pageData.snoreNormalTime}秒</div>
					<div>检测到本次睡眠的总时间是：${pageData.sleepTime}秒</div>
					<br />
					<div class="container1" style="width: 550px; height: 400px; margin: 0 auto"></div>
					<hr />
				</c:forEach>
			</div>
			
			

		</div>

	</body>
			<script language="JavaScript">
			$(document).ready(function() {
				var chart = {
					type: 'pie',
					options3d: {
						enabled: true,
						alpha: 45
					}
				};
				var title = {
					text: '打鼾时间统计'
				};
				var subtitle = {
					text: '您一共睡眠10min'
				};

				var plotOptions = {
					pie: {
						innerSize: 100,
						depth: 45
					}
				};
				var series = [{
					name: '时间/h',
					data: [
						['正常睡眠时间', 156],
						['正常打鼾时间', 149],
						['不正常打鼾时间', 7],
					]
				}];

				var json = {};
				json.chart = chart;
				json.title = title;
				json.subtitle = subtitle;
				json.plotOptions = plotOptions;
				json.series = series;
				$('.container1').highcharts(json);
			});
		</script>

</html>