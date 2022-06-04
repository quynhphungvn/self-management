<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.ArrayList, 
		quynh.java.sm.langlearning.english.ipa.model.*
				"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
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
		<div id="player">
			<div class="tab">
				<button class="tab-links active"
					onclick="showSymbolGuide(event, 'symbol-video')">Video</button>
				<button class="tab-links"
					onclick="showSymbolGuide(event, 'symbol-image')">Image</button>
			</div>
			<div id="symbol-video" class="tab-content">
				<iframe id="ipa-player-iframe" width="560" height="315"
					src="https://www.youtube.com/embed/j9E9mMAtoqQ"
					title="YouTube video player" frameborder="0"
					allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
					allowfullscreen></iframe>
				<!-- <video width="100%"controls id="symbol-video" class="tab-content">
                <source src="../src/1.webm" type="video/webm">
            </video> -->
			</div>
			<img src="/SelfManagement/static/images/tien.png" width="100%"
				id="symbol-image" class="tab-content" />

			<h4 id="ipa-exam-word">Exam</h4>
			<h4 id="ipa-exam-phonetic">/Phonetic/</h4>
			<h4><b id="symbol-title"></b><i class="fa fa-eye"></i><b
					id="symbol-view"></b>
			</h4>
		</div>
		<table id="symbols">
			<caption>
				<h3>Symbols</h3>
			</caption>
			<%
			List<IPASymbol> listIPASymbol = (ArrayList<IPASymbol>) request.getAttribute("list-ipa-symbol");
			if (listIPASymbol != null) {

			}
			List<IPASymbol> vowel = new ArrayList<IPASymbol>();
			List<IPASymbol> consonant = new ArrayList<IPASymbol>();
			List<IPASymbol> rColoredVowel = new ArrayList<IPASymbol>();
			List<IPASymbol> diphthong = new ArrayList<IPASymbol>();
			for (int i = 0; i < listIPASymbol.size(); i++) {		
				IPASymbol tempSymbol = listIPASymbol.get(i);			
				if (tempSymbol.getIpaType().equals("vowel")){
					vowel.add(tempSymbol);				
				}
				else if (tempSymbol.getIpaType().equals("consonant")){
					consonant.add(tempSymbol);	
				}
				else if (tempSymbol.getIpaType().equals("r-colored-vowel")) {
					rColoredVowel.add(tempSymbol);				
				}
				else {
					diphthong.add(tempSymbol);					
				}
			}
			%>
			<tbody>
				<tr>
					<th scope="row">Vowel</th>
					<%
					for (int i = 0; i < vowel.size(); i++)
						out.print("<td onclick=\"chooseSymbol(event, '" + vowel.get(i).getId() + "')\"><span>" + vowel.get(i).getSymbol()
						+ "</span></td>");
					%>
				</tr>
				<%
				for (int i = 0; i < consonant.size(); i++) {
					if (i % 10 == 0 && i != 0)
						out.print("</tr>");
					if (i == 0) {
						out.print("<tr>");
						out.print("<th scope=\"row\" rowspan=\"3\">Consonant</th>");
					}
					out.print("<td onclick=\"chooseSymbol(event, '" + consonant.get(i).getId() + "')\"><span>" + consonant.get(i).getSymbol()
					+ "</span></td>");
				}
				out.print("<tr>");
				%>
				<tr>
					<th scope="row">R-Colored</th>
					<%
					for (int i = 0; i < rColoredVowel.size(); i++)
						out.print("<td onclick=\"chooseSymbol(event, '" + rColoredVowel.get(i).getId() + "')\"><span>"
						+ rColoredVowel.get(i).getSymbol() + "</span></td>");
					%>
				</tr>
				<tr>
					<th scope="row">Diphthong</th>
					<%
					for (int i = 0; i < diphthong.size(); i++)
						out.print("<td onclick=\"chooseSymbol(event, '" + diphthong.get(i).getId() + "')\"><span>" + diphthong.get(i).getSymbol()
						+ "</span></td>");
					%>
				</tr>

			</tbody>
		</table>
	</main>
    <script><%@include file="./scripts.js"%></script>
    <script src="/SelfManagement/static/js/common.js"></script>
</body>
</html>