<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.ArrayList,
				qyn.javaweb.ss.englearn.model.*
				 "%>
<!DOCTYPE html>
<html>
<head>
	<style><%@include file="./video-editor-styles.css"%></style>
</head>
<body>
	<div id="b-video-editor">
		<%
		List<VideoLearnGroup> lGroup = (ArrayList<VideoLearnGroup>) request.getAttribute("video-groups");
	%>
		<button class="btn btn-success m-1" type="button"
			data-bs-toggle="offcanvas" data-bs-target="#offcanvas-editvideo"
			aria-controls="offcanvasExample">
			<i class="bi bi-pencil-square"></i>
		</button>

		<div class="offcanvas offcanvas-end" tabindex="-1"
			id="offcanvas-editvideo" aria-labelledby="offcanvasExampleLabel">
			<div class="offcanvas-header">
				<h5 class="offcanvas-title" id="offcanvasExampleLabel">Edit</h5>
				<button type="button" class="btn-close text-reset"
					data-bs-dismiss="offcanvas" aria-label="Close"></button>
			</div>
			<div class="offcanvas-body">
				<div id="b-edit-group" class="d-flex flex-row">
					<select id="select-edit-group-video"
						class="form-select form-select-sm"
						onchange="chooseEditGroupVideo(this.value)">
						<option selected value="-1">Choose Group ...</option>
						<%						
										for (int i = 0; i < lGroup.size(); i++)
											out.print("<option value=\"" + lGroup.get(i).getId() + "\">" + lGroup.get(i).getName() + "</option>");
										%>
					</select>
					<div class="input-group ms-1">
						<input type="text" id="input-group" class="form-control"
							placeholder="Group name" aria-label="Recipient's username"
							aria-describedby="button-addon2">
						<button class="btn btn-outline-secondary" type="button"
							id="button-addgroup" onclick="addVideoGroup()">
							<i class="bi bi-plus"></i>
						</button>
						<button class="btn btn-outline-secondary" type="button"
							id="button-delgroup">
							<i class="bi bi-dash"></i>
						</button>
					</div>
				</div>
				<div id="b-edit-listvideo" class="list-group my-1"></div>
				<div id="b-edit-videocontent"
					class="my-3 bg-secondary bg-opacity-25 p-3 rounded">
					<div class="mb-1">
						<label for="input-videoname" class="form-label">Video Name
							(*)</label> <input id="input-videoname" type="text" class="form-control"
							placeholder="name">
					</div>
					<div class="mb-1">
						<label for="input-videotitle" class="form-label">Video
							Title</label> <input id="input-videotitle" type="text"
							class="form-control" placeholder="title">
					</div>
					<div class="mb-1">
						<label for="input-videolink" class="form-label">Video Link
							(*)</label> <input id="input-videolink" type="text" class="form-control"
							placeholder="link">
					</div>

					<select id="select-add-group-video"
						class="form-select form-select-sm my-4">
						<option selected value="-1">Choose Group (*)</option>
						<%						
										for (int i = 0; i < lGroup.size(); i++)
											out.print("<option value=\"" + lGroup.get(i).getId() + "\">" + lGroup.get(i).getName() + "</option>");
										%>
					</select>


					<div class="mb-1">
						<label for="input-videosubcription" class="form-label">Subtitle</label>
						<textarea class="form-control" id="input-videosubtitle" rows="5"></textarea>
					</div>
					<div class="d-flex justify-content-end">
						<button class="btn btn-success mx-3 mt-2"
							onclick="addVideoLearn()">Add</button>
						<button class="btn btn-success mx-3 mt-2"
							onclick="updateVideoEdit()">Update</button>
						<button class="btn btn-success mx-3 mt-2">Delete</button>
						<button class="btn btn-success mx-3 mt-2"
							onclick="clearFormEdit()">Clear</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script><%@include file="./video-editor-scripts.js"%></script>
</body>
</html>