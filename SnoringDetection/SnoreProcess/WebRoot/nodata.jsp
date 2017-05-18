<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>您的数据</title>
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

		</div>

	</body>

</html>