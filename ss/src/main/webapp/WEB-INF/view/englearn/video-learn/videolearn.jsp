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
<title>English Learning</title>
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
		<div id="l-content">
			<div id="lookup" class="position-fixed end-0 d-flex flex-column p-2">
				<jsp:include page="../fragment/ipa/ipa.jsp"></jsp:include>
				<jsp:include page="../fragment/video-editor/video-editor.jsp"></jsp:include>
			</div>
			<div id="englearn" class="py-2">
				<div id="englearn-player"
					class="bg-light d-flex justify-content-center align-items-center">
					<iframe id="iframe-englearn-player" width="100%" height="100%"
						src="https://www.youtube.com/embed/hbywQEEcRcM"
						title="YouTube video player" frameborder="0"
						allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
						allowfullscreen></iframe>
				</div>
				<div id="englearn-videolist"
					class="bg-light d-flex flex-column justify-content-evenly px-2">
					<div id="videolist-group" class="d-flex">
						<select id="select-group-video" class="form-select form-select-sm"
							onchange="chooseGroupVideo(this)">
							<option selected value="-1">Choose Group</option>
							<%
							List<VideoLearnGroup> lGroup = (ArrayList<VideoLearnGroup>) request.getAttribute("video-groups");
							for (int i = 0; i < lGroup.size(); i++)
								out.print("<option value=\"" + lGroup.get(i).getId() + "\">" + lGroup.get(i).getName() + "</option>");
							%>
						</select>
						<jsp:include page="../fragment/video-subtitle/video-subtitle.jsp"></jsp:include>
					</div>
					<div id="videolist" class="list-group"></div>
				</div>
				<div id="englearn-currentsub" class="bg-warning"></div>
				<div id="englearn-listsub" class="bg-success"></div>
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