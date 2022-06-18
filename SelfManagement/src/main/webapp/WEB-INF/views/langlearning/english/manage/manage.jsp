<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.ArrayList,quynh.java.sm.langlearning.english.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>English Manage</title>
<style><%@include file="./styles.css"%></style>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="/SelfManagement/static/utils/styles.css">
<script src="/SelfManagement/static/utils/scripts.js"></script>
</head>
<body>
	<%
		List<VideoGroup> listVideoGroup = (List<VideoGroup>)request.getAttribute("listVideoGroup");
	%>
	<header id="header">
        <button onclick="showLeftMenu()"><i class="fa fa-bars"></i></button>   
        <img src="/SelfManagement/static/images/tien.png" width="30px" height="30px"/>
    </header> 
    <aside id="left-menu">
        <header>
            <a href="/home.html" ><i class="fa fa-home"></i></a>
            <button onclick="closeLeftMenu()"><i class="fa fa-close"></i></button>
        </header>  
        <hr />
        <nav>
            <ul>
                <li>
                    <h3>English learning</h3>
                    <ul>
                        <li><a href="/SelfManagement/langlearning/english/symbol/">IPA</a></li>
                        <li><a href="/SelfManagement/langlearning/english/video/">Video Learning</a></li>
                        <li><a href="/SelfManagement/langlearning/english/manage/">Manage</a></li>
                        <li><a href="/document/reading.html">Document Reading</a></li>
                    </ul>
                </li>
                <hr/>
            </ul>
        </nav>
    </aside>
    <main>
		<section id="english-learning">
			<div class="tab">
				<div class="tab-bar">
					<button class="tab-links active"
						onclick="showTabContent(event, 'ipa-tab')">IPA</button>
					<button class="tab-links"
						onclick="showTabContent(event, 'video-tab')">Video learning</button>
				</div>
				<div id="ipa-tab" class="tab-content">ipa</div>
				<div id="video-tab" class="tab-content d-none">
					<div class="border-rounded p-1">
						<div class="d-flex">
							<select id="gform-select-group" onchange="chooseVideoGroupGForm(this)">
								<option value="-1">Choose Group... </option>
								<%
									for (VideoGroup v : listVideoGroup) {
										out.print("<option value='"+ v.getId() +"'>" + v.getName() + "</option>");
									}
								%>
							</select>
							<div class="ml-1">
								<input id="input-video-group" type="text" />
								<button class="btn" onclick="addVideoGroupByName()">+</button>
								<button class="btn" onclick="deleteVideoGroupByName()">-</button>
								<button class="btn" onclick="clearGForm()">Clear</button>
							</div>
						</div>
						<ul id="videos-by-group" class="list-items mt-1">
							
						</ul>
					</div>
					<div class="border-rounded mt-1 p-1">
						<div class="form-group">
							<label>id</label> 
							<input type="text" id="vform-id" disabled/>
						</div>
						<div class="form-group">
							<label>title</label> 
							<input type="text" id="vform-title"/>
						</div>
						<div class="form-group">
							<label>url</label> 
							<input type="text" id="vform-url"/>
						</div>
						<div class="form-group">
							<label>group</label> 
							<select id="vform-select-group">	
								<option value="-1">---</option>
								<%
									for (VideoGroup v : listVideoGroup) {
										out.print("<option value='"+ v.getId() +"'>" + v.getName() + "</option>");
									}
								%>		
							</select>
						</div>
						<div class="form-group">
							<label>subtitle</label>
							<textarea rows="10" cols="40" id="vform-subtitle"></textarea>
						</div>
						<div>
							<button id="btn-add-video" class="btn" onclick="addVideo()">Add</button>
							<button id="btn-update-video" class="btn" onclick="updateVideo()">Update</button>
							<button id="btn-delete-video" class="btn" onclick="deleteVideo()">Delete</button>
							<button class="btn" onclick="clearVForm()">Clear</button>
						</div>
					</div>
				</div>
			</div>
		</section>
	</main>
	<script src="/SelfManagement/static/js/common.js"></script>
	<script><%@include file="./scripts.js"%></script>
</body>
</html>