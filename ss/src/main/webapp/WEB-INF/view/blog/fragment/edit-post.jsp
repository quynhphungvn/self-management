<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.ArrayList, 
				qyn.javaweb.ss.blog.dto.* "%>
<html>
<head>
</head>
<body>
	<%
		List<TagDTO> lTagDTO = (ArrayList<TagDTO>) request.getAttribute("list-all-tag-dto");
	%>
	<button type="button" class="btn btn-primary" data-bs-toggle="modal"
		data-bs-target="#staticBackdrop">
		<i class="bi bi-pencil-square"></i>
	</button>

	<!-- Modal -->
	<div class="modal fade" id="staticBackdrop" data-bs-backdrop="static"
		data-bs-keyboard="false" tabindex="-1"
		aria-labelledby="staticBackdropLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="staticBackdropLabel">Post Edit</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<div class="mb-3">
						<div id="edit-post-filter"
							class="d-flex justify-content-between border-bottom mb-2">
							<div class="form-group mb-3">
								<div class="input-group">
									<input type="text" id="input-tagfilter-editpost"
										class="form-control" placeholder="Tag filter"
										aria-label="Tag filter" aria-describedby="basic-addon1"
										onkeyup="filterTagInEditPost()">
								</div>
							</div>
							<div class="form-group mb-3">
								<div class="input-group">
									<input type="text" class="form-control" placeholder="Add Tag"
										aria-label="Recipient's username with two button addons">
									<button class="btn btn-outline-secondary" type="button">+</button>
									<button class="btn btn-outline-secondary" type="button">-</button>
								</div>
							</div>
						</div>
						<div id="b-editpost-tag" class="overflow-auto">
							<%
											for (int i = 0; i < lTagDTO.size(); i++) {
												out.print("	<div id=\"__" + lTagDTO.get(i).getTagName()
												+ "\" class=\"js-tag-editpost form-check mx-3 d-inline-block\">"
												+ "<input class=\"js-input-editpost form-check-input\" type=\"checkbox\" value=\"" + lTagDTO.get(i).getTagId() + "\" id=\""
												+ lTagDTO.get(i).getTagId() + "\"> " + "<label class=\"form-check-label\" for=\"flexCheckDefault\">"
												+ lTagDTO.get(i).getTagName() + "</label>" + "</div>");
											}
											%>
						</div>
					</div>
					<div class="mb-3">
						<label for="input-title" class="form-label">Title</label> <input
							type="text" class="form-control" id="input-title"
							placeholder="title here">
					</div>
					<div class="mb-3">
						<label for="textarea-postcontent" class="form-label">Post
							Content</label>
						<div id="editor"></div>
					</div>
					<div id="addpost-control">
						<button class="btn btn-success" onclick="addPost()">Add</button>
						<button class="btn btn-success" onclick="updatePost()">Update</button>
						<button class="btn btn-success" disabled>Delete</button>
						<button class="btn btn-success" onclick="clearEditPostModal()">Clear</button>
					</div>
				</div>
				<div class="modal-footer"></div>
			</div>
		</div>
	</div>
	<script><%@include file="./edit-post.js" %></script>
</body>
</html>