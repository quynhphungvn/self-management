<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                        <li><a href="/SelfManagement/langlearning/english/ipa/">IPA</a></li>
                        <li><a href="/SelfManagement/langlearning/english/videolearning/">Video Learning</a></li>
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
						<div>
							<select>
								<option>Group 1</option>
								<option>Group 2</option>
							</select>
							<div>
								<input type="text" />
								<button class="btn">+</button>
								<button class="btn">-</button>
							</div>
						</div>

						<ul>
							<li>video 1 of group</li>
							<li>video 1 of group</li>
							<li>video 1 of group</li>
							<li>video 1 of group</li>
							<li>video 1 of group</li>
							<li>video 1 of group</li>
						</ul>
					</div>
					<div class="border-rounded mt-1 p-1">
						<div>
							<label>id</label> <input type="text" />
						</div>
						<div>
							<label>title</label> <input type="text" />
						</div>
						<div>
							<label>url</label> <input type="text" />
						</div>
						<div>
							<label>group</label> <select>
								<option>Group 1</option>
								<option>Group 2</option>
							</select>
						</div>
						<div>
							<label>subtitle</label>
							<textarea rows="10" cols="40"></textarea>
						</div>
						<div>
							<button class="btn">Add</button>
							<button class="btn">Update</button>
							<button class="btn">Delete</button>
							<button class="btn">Clear</button>
						</div>
					</div>
				</div>
			</div>
		</section>
	</main>
	<script><%@include file="./scripts.js"%></script>
</body>
</html>