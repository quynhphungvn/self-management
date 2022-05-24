<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
<style>
	* {
		padding: 0;
		margin: 0;
		box-sizing: border-box;
	}
	#wrapper {
		width: 100vw;
		height: 100vh;
		display: grid;
		grid-template-columns: 250px 1fr;
		grid-template-rows: 70px 1fr;
	}
	#l-logo {
		grid-column: 1/2;
		grid-row: 1/2;
		border-bottom: 1px solid #ddd;
		border-right: 1px solid #ddd;
	}
	#l-menutop {
		grid-column: 2/3;
		grid-row: 1/2;
		border-bottom: 1px solid #ddd;
	}
	#l-menuleft {
		grid-column: 1/2;
		grid-row: 2/3;
		overflow: auto;
		border-right: 1px solid #ddd;
	}
	#l-content {
		grid-column: 2/3;
		grid-row: 2/3;
		background-color: #f3f3f3;
	}
</style>
<style><%@include file="/WEB-INF/view/fragment/left-menu/leftmenu-styles.css"%></style>
<style><%@include file="./styles.css"%></style>
</head>
<body>
	<div id="wrapper">
		<div id="l-logo"
			class="d-flex justify-content-center align-items-center">
			<a href="/ss/home"><i class="bi bi-yin-yang"
				style="font-size: 2rem; color: green;"></i></a>
		</div>
		<div id="l-menutop"></div>
		<div id="l-menuleft">
			<jsp:include page="../../../fragment/left-menu/leftmenu.jsp"></jsp:include>
		</div>
		<div id="l-content">
			
		</div>
	</div>
	<!-- JavaScript Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
	<script><%@include file="./scripts.js"%></script>
</body>
</html>