<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.ArrayList,quynh.java.sm.langlearning.english.video.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style><%@include file="./styles.css"%></style>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
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
            <video width="100%"controls>
                <source src="" type="video/webm" id="video-src">
            </video>              
        </section>
        <section id="bonus-info">
            <div class="tab">
                <button class="tab-links active" onclick="showBonusInfo(event, 'video-list')">Video List</button>
                <button class="tab-links" onclick="showBonusInfo(event, 'video-sub')">Subtitle</button>
            </div>
            <div id="video-list" class="tab-content">
                <select>
                    <option>Group 1</option>
                    <option>Group 2</option>
                </select>
                <ul>
                    <li class="active"><span>Video 1</span><span><i class="fa fa-eye"></i> 10</span></li>
                    <li><span>Video 1</span><span><i class="fa fa-eye"></i> 10</span></li>
                    <li><span>Video 1</span><span><i class="fa fa-eye"></i> 10</span></li>
                    <li><span>Video 1</span><span><i class="fa fa-eye"></i> 10</span></li>
                    <li><span>Video 1</span><span><i class="fa fa-eye"></i> 10</span></li>
                    <li><span>Video 1</span><span><i class="fa fa-eye"></i> 10</span></li>
                    <li><span>Video 1</span><span><i class="fa fa-eye"></i> 10</span></li>
                    <li><span>Video 1</span><span><i class="fa fa-eye"></i> 10</span></li>
                    <li><span>Video 1</span><span><i class="fa fa-eye"></i> 10</span></li>
                    <li><span>Video 1</span><span><i class="fa fa-eye"></i> 10</span></li>
                    <li><span>Video 1</span><span><i class="fa fa-eye"></i> 10</span></li>
                    <li><span>Video 1</span><span><i class="fa fa-eye"></i> 10</span></li>
                    <li><span>Video 1</span><span><i class="fa fa-eye"></i> 10</span></li>
                    <li><span>Video 1</span><span><i class="fa fa-eye"></i> 10</span></li>
                    <li><span>Video 1</span><span><i class="fa fa-eye"></i> 10</span></li>
                    <li><span>Video 1</span><span><i class="fa fa-eye"></i> 10</span></li>
                    <li><span>Video 1</span><span><i class="fa fa-eye"></i> 10</span></li>
                    <li><span>Video 1</span><span><i class="fa fa-eye"></i> 10</span></li>
                    <li><span>Video 1</span><span><i class="fa fa-eye"></i> 10</span></li>
                    <li><span>Video 1</span><span><i class="fa fa-eye"></i> 10</span></li>
                </ul>
            </div>
            <div id="video-sub" class="tab-content">
                <div class="sub-menu">
                    <div>
                        <input type="text"/>
                        <button class="btn">+</button>
                        <button class="btn">-</button>                      
                    </div>
                    <div>
                        <a href="#">Goog</a>
                        <a href="#">Camb</a>
                        <a href="#">Youg</a>
                        <a href="#">Tratu</a>                      
                    </div>
                </div>
                <ul class="sub-list">
                    <li class="active">
                        <time>0:00</time>
                        <div>
                            <span>Mom,</span><span style="background-color: #aaa;">Dad,</span><span>I</span> found cigarettes
                            in Greg's jacket.</span>
                        </div>
                    </li>
                    <li>
                        <time>0:10</time>
                        <div><span>Greg,</span><span> were</span> <span>you</span> smoking cigarettes?
                            - No, Dad. He's lying. There's no doubt about that.</span>
                        </div>
                    </li>
                    <li>
                        <time>0:15</time>      
                        <div><span>He's lying. There's no doubt about that.</span></div>
                    </li>
                    <li>
                        <time>0:33</time>
                        <div><span>Greg, I'm afraid your punishment
                            will be four hours in the snakepit.</span></div>
                    </li>
                </ul>
            </div>
        </section>
    </main>
	<script><%@include file="./scripts.js"%></script>
    <script src="/SelfManagement/static/js/common.js"></script>
</body>
</html>