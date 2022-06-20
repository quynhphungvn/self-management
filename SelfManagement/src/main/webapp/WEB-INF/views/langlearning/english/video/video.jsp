<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.ArrayList,quynh.java.sm.langlearning.english.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style><%@include file="./styles.css"%></style>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="/SelfManagement/static/utils/styles.css">
<script src="/SelfManagement/static/utils/scripts.js"></script>
</head>
<body>
	<%
		List<VideoGroup> listVideoGroup = (List<VideoGroup>) request.getAttribute("listVideoGroup");
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
        <section id="player">
           <iframe width="560" height="315" src="https://www.youtube.com/embed/7bRfgy25cNA" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>             
        </section>
        <section id="bonus-info">
            <div class="tab">
                <button class="tab-links active" onclick="showBonusInfo(event, 'video-list')">Video List</button>
                <button class="tab-links" onclick="showBonusInfo(event, 'video-sub')">Subtitle</button>
            </div>
            <div id="video-list" class="tab-content">
                <select id="select-video-group" onchange="getVideosOfGroup()">
                	<option value="-1">Choose Group...</option>
                    <%
                    	for (VideoGroup vg : listVideoGroup) {
                    		out.print("<option value='"+vg.getId()+"'>"+vg.getName()+"</option>");
                    	}
                    %>
                </select>
                <ul id="videos-of-group">
                 
                </ul>
            </div>
            <div id="video-sub" class="tab-content">
                <div class="sub-menu">
                    <div>
                        <input type="text" id="input-lookup"/>
                        <button class="btn" onclick="addWordToWordKnown()">+</button>
                        <button class="btn" onclick="removeWordFromWordKnown()">-</button>                      
                    </div>
                    <div>
                        <a id="link-google" target="_blank" href="#">Goog</a>
                        <a id="link-cambridge" target="_blank" href="#">Camb</a>
                        <a id="link-youglish" target="_blank" href="#">Youg</a>
                        <a id="link-tratu" target="_blank" href="#">Tratu</a>                      
                    </div>
                </div>
                <ul id="subtitle" class="sub-list">
            
                </ul>
            </div>
        </section>
    </main>
	<script><%@include file="./scripts.js"%></script>
    <script src="/SelfManagement/static/js/common.js"></script>
</body>
</html>