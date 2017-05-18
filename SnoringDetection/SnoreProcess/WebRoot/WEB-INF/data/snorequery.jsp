<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>您的鼾声记录</title>
		<style type="text/css">
			#pic {
				width: 800px;
			}
			
			#container {
				margin: auto;
				text-align: center;
			}
			
			#textcon {
				background: gold;
			}
			
			#title {
				color: orangered;
			}
			
		</style>
	</head>

	<body>
		<div id="container">
			<div id="textcon">
				<br />
				<br />
				<h1 id="title">尊敬的Admin用户您好，您的呼噜已经成功被捕捉</h1>
				<h4>请输入您要查询的日期</h4>
				<form action="data" method="post">
					<label for="meeting">查询日期：</label><input id="startdate" name="date" type="date" value="2017-05-18" />&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="submit" class="btn" value="查&nbsp询" />
				</form>
				<br />
				<br />
			</div>

			<br />
			<img src="image/Snoreill.png" / id="pic">
		</div>

	</body>

</html>