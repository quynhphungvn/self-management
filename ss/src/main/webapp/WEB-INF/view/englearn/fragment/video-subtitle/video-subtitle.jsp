<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style><%@include file="./video-subtitle-styles.css"%></style>
</head>
<body>
	<div id="b-subtitle">
		<button class="btn btn-success ms-1" type="button"
			data-bs-toggle="offcanvas" data-bs-target="#sub-lookup"
			aria-controls="sub-lookup">
			<i class="bi bi-clipboard2-check"></i>
		</button>

		<div class="offcanvas offcanvas-end" tabindex="-1" id="sub-lookup"
			aria-labelledby="subLookupLabel">
			<div class="offcanvas-header">
				<h5 class="offcanvas-title" id="subLookupLabel">Subtitle</h5>
				<button type="button" class="btn-close text-reset"
					data-bs-dismiss="offcanvas" aria-label="Close"></button>
			</div>
			<div class="offcanvas-body">
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
	<script><%@include file="./video-subtitle-scripts.js"%></script>
</body>
</html>