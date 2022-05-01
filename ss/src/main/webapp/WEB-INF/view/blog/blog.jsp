<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.ArrayList, 
				qyn.javaweb.ss.blog.dto.*
				 "%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Blog</title>
<!-- Quill editor -->
<link rel="stylesheet" href="//cdn.quilljs.com/1.3.6/quill.bubble.css">
<link href="https://cdn.quilljs.com/1.3.6/quill.snow.css" rel="stylesheet">
<!-- highlight.js -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.4.0/styles/default.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.4.0/highlight.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.4.0/languages/go.min.js"></script>
<!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
<!-- self css -->
<script src="/ss/static/js/utils.js"></script>
<link rel="stylesheet" href="/ss/static/css/ss-styles.css">
<style><%@include file="./styles.css"%></style>
</head>
<body>
	<%
			List<TagDTO> lTagDTO = (ArrayList<TagDTO>) request.getAttribute("list-all-tag-dto");
	%>
	<div id="wrapper">
		<div id="l-logo"
			class="d-flex justify-content-center align-items-center">
			<a href="/ss/home"><i class="bi bi-yin-yang"
				style="font-size: 2rem; color: green;"></i></a>
		</div>
		<div id="l-menutop">
			<jsp:include page="../fragment/top-menu/top-menu.jsp"></jsp:include>
		</div>
		<div id="l-menuleft">
			<jsp:include page="../fragment/left-menu/leftmenu.jsp"></jsp:include>
		</div>
		<div id="l-content" class="d-flex">
			<div id="l-list-post" class="d-flex flex-column bg-white">
				<div id="b-search-post"
					class="border-bottom d-flex align-items-center px-2">
					<div class="form-group">
						<div class="input-group">
							<input type="text" id="input-tagfilter" class="form-control"
								placeholder="Tag filter" aria-label="Username"
								aria-describedby="basic-addon1" onkeyup="filterTagInPostList()">
						</div>
					</div>
				</div>
				<div id="b-list-post" class="overflow-auto p-1">
					<%
					for (int i = 0; i < lTagDTO.size(); i++) {
						List<PostInfoDTO> lPostInfoDTO = lTagDTO.get(i).getlPostInfoDTO();
						if (lPostInfoDTO != null) {
							out.print("<div id=\"_" + lTagDTO.get(i).getTagName() + "\" class=\"js-tag-postlist\">");
							out.print("<div class=\"tag-header p-2\"" + "data-bs-toggle=\"collapse\"" + "data-bs-target=\"#idtag"
							+ lTagDTO.get(i).getTagId() + "\"" + "aria-expanded=\"false\" aria-controls=\"collapseExample\">");
							out.print("<span>" + lTagDTO.get(i).getTagName() + " (" + lPostInfoDTO.size() + ")</span>");
							out.print("</div>");
							out.print("<div class=\"collapse\" id=\"idtag" + lTagDTO.get(i).getTagId() + "\">");
							out.print("<div class=\"list-group\">");
							for (int j = 0; j < lPostInfoDTO.size(); j++) {
						out.print("<button type=\"button\" class=\"list-group-item list-group-item-action\" aria-current=\"true\""
								+ "onclick=\"getPostContentById(" + lPostInfoDTO.get(j).getPostId() + ")\">");
						out.print(lPostInfoDTO.get(j).getPostTitle());
						out.print("</button>");
							}
							out.print("</div></div>");
							out.print("</div>");
						}
					}
					%>
				</div>
				<div id="b-list-footer"
					class="d-flex justify-content-end align-items-center bg-light border-top">
					<jsp:include page="./fragment/edit-post.jsp"></jsp:include>
				</div>
			</div>
			<div id="l-post-content" class="overflow-auto">
				<div id="b-post" class="bg-white rounded">
					<div id="c-post-header" class="p-4 bg-light border-bottom">
						<span id="c-post-title" class="fs-4"></span>
					</div>
					<div id="c-post"></div>
				</div>
			</div>
		</div>
	</div>
	<script src="https://cdn.quilljs.com/1.3.6/quill.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
	<script><%@include file="./lib-conf.js"%></script>
	<script><%@include file="./scripts.js"%></script>
</body>
</html>