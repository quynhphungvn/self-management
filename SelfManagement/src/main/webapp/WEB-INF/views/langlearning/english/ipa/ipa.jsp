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
        <img src="/images/tien.png" width="30px" height="30px"/>
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
                        <li><a href="/ipa/ipa.html">IPA</a></li>
                        <li><a href="/video/watching.html">Video Watching</a></li>
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
                <button class="tab-links active" onclick="showSymbolGuide(event, 'symbol-video')">Video</button>
                <button class="tab-links" onclick="showSymbolGuide(event, 'symbol-image')">Image</button>
            </div>
            <video width="100%"controls id="symbol-video" class="tab-content">
                <source src="../src/1.webm" type="video/webm">
            </video>
            <img src="../src/tien.png" width="100%" id="symbol-image" class="tab-content"/>
            <h3>Exam</h3>
        </div>
		<table id="symbols">
			<caption>
				<h3>Symbols</h3>
			</caption>
			<%
			List<IPASymbol> listIPASymbol = (ArrayList<IPASymbol>)request.getAttribute("list-ipa-symbol");
			if (listIPASymbol != null) {
				
			}
			List<IPASymbol> vowel = new ArrayList<IPASymbol>();
			List<IPASymbol> consonant = new ArrayList<IPASymbol>();
			List<IPASymbol> rColoredVowel = new ArrayList<IPASymbol>();
			List<IPASymbol> diphthong = new ArrayList<IPASymbol>();
			for (int i = 0; i < listIPASymbol.size(); i++) {
				if (listIPASymbol.get(i).getIpaType().equals("vowel"))
					vowel.add(listIPASymbol.get(i));
				else if (listIPASymbol.get(i).getIpaType().equals("consonant"))
					consonant.add(listIPASymbol.get(i));
				else if (listIPASymbol.get(i).getIpaType().equals("r-colored-vowel"))
					rColoredVowel.add(listIPASymbol.get(i));
				else {
					diphthong.add(listIPASymbol.get(i));
				}
			}
			%>
			<tbody>
				<tr>
					<th scope="row">Vowel</th>
					<%
					for (int i = 0; i < vowel.size(); i++)
						out.print("<td><span onclick=\"chooseSymbol('" + vowel.get(i).getId() + "')\">" + vowel.get(i).getSymbol()
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
					out.print("<td><span onclick=\"chooseSymbol('" + consonant.get(i).getId() + "')\">" + consonant.get(i).getSymbol()
					+ "</span></td>");
				}
				out.print("<tr>");
				%>
				<tr>
					<th scope="row">R-Colored</th>
					<%
					for (int i = 0; i < rColoredVowel.size(); i++)
						out.print("<td><span onclick=\"chooseSymbol('" + rColoredVowel.get(i).getId() + "')\">"
						+ rColoredVowel.get(i).getSymbol() + "</span></td>");
					%>
				</tr>
				<tr>
					<th scope="row">Diphthong</th>
					<%
					for (int i = 0; i < diphthong.size(); i++)
						out.print("<td><span onclick=\"chooseSymbol('" + diphthong.get(i).getId() + "')\">" + diphthong.get(i).getSymbol()
						+ "</span></td>");
					%>
				</tr>

			</tbody>
		</table>
	</main>
    <script><%@include file="./scripts.js"%></script>
</body>
</html>