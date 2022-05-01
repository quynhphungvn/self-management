<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.ArrayList, 
				qyn.javaweb.ss.englearn.model.*,
				qyn.javaweb.ss.note.model.*
				 "%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reading Support</title>
<!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
<!-- Self -->
<link rel="stylesheet" href="/ss/static/css/ss-styles.css">
<script src="/ss/static/js/utils.js"></script><style>
<%@include file="./styles.css"%></style>
</head>
<body>
	<div id="wrapper">
		<div id="l-logo"
			class="d-flex justify-content-center align-items-center">
			<a href="/ss/home"><i class="bi bi-yin-yang"
				style="font-size: 2rem; color: green;"></i></a>
		</div>
		<div id="l-menutop">
			<jsp:include page="../../fragment/top-menu/top-menu.jsp"></jsp:include>
		</div>
		<div id="l-menuleft">
			<jsp:include page="../../fragment/left-menu/leftmenu.jsp"></jsp:include>
		</div>
		<div id="l-content" class="d-flex">
			<div id="b-text-src" class="w-25 p-2 bg-white">
				<div class="mb-3">
					<textarea class="form-control" id="input-engtext"
						rows="30"></textarea>
				</div>
				<div>
					<button class="btn btn-success" onclick="createNewWordRef()">Check</button>
				</div>
			</div>
			<div id="b-text-result" class="w-75 p-5 bg-white">
				<div id="sub-menu" class="d-flex">
					<div class="input-group ms-1">
						<input type="text" id="sub-input-word" class="form-control"
							placeholder="Word" aria-label="Recipient's username"
							aria-describedby="button-addon2">
						<button class="btn btn-outline-secondary" type="button"
							id="sub-btn-addword" onclick="addWordToWordKnown()">
							<i class="bi bi-plus"></i>
						</button>
						<button class="btn btn-outline-secondary" type="button"
							id="sub-btn-delword">
							<i class="bi bi-dash"></i>
						</button>
					</div>
					<div class="d-flex ms-3">
						<a id="link-youglish" target="_blank" class="btn btn-success mx-1">YouGlish</a>
						<a id="link-cambridge" target="_blank"
							class="btn btn-success mx-1">Cambridge</a> <a id="link-google"
							target="_blank" class="btn btn-success mx-1">Google</a> <a
							id="link-tratu" target="_blank" class="btn btn-success mx-1">TraTu</a>
					</div>

				</div>
				<div id="sub-word-content"
					class="d-flex flex-wrap p-3 mt-3 overflow-auto">
					<h3>No Content!</h3>
				</div>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
	<script><%@include file="./scripts.js"%></script>
</body>
</html>
</body>
</html>