<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.ArrayList, 
				qyn.javaweb.ss.englearn.ipa.model.*
				"%>
<!DOCTYPE html>
<html>
<head>
<style><%@include file="./ipa-styles.css"%></style>
</head>
<body>
	<div id="b-ipa">
		<%
			List<IPASymbol> listIPASymbol = (ArrayList<IPASymbol>)request.getAttribute("list-ipa-symbol");
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
		<button class="btn btn-success m-1" type="button"
			data-bs-toggle="offcanvas" data-bs-target="#ipa-lookup"
			aria-controls="ipa-lookup">IPA</button>

		<div class="offcanvas offcanvas-end" tabindex="-1" id="ipa-lookup"
			aria-labelledby="ipaLookupLabel">
			<div class="offcanvas-header">
				<h5 class="offcanvas-title" id="ipaLookupLabel"></h5>
				<button type="button" class="btn-close text-reset"
					data-bs-dismiss="offcanvas" aria-label="Close"></button>
			</div>
			<div class="offcanvas-body">
				<div id="ipa-lookup-content">
					<div id="ipa-view"
						class="d-flex flex-column align-items-center p-3">
						<div id="ipa-player" class="d-flex justify-content-center">
							<iframe id="ipa-player-iframe" width="560" height="315"
								src="https://www.youtube.com/embed/j9E9mMAtoqQ"
								title="YouTube video player" frameborder="0"
								allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
								allowfullscreen></iframe>
						</div>
						<div id="ipa-imageguide" class="d-flex d-none">
							<img id="ipa-imageguide-img" alt="" src="/ss/static/image/æ.png">
						</div>
						<div id="ipa-view-menu" class="my-3 text-center">
							<button class="btn btn-success" onclick="chooseVideoType()">Video</button>
							<button class="btn btn-success" onclick="chooseImageType()">Image</button>
						</div>
						<div id="ipa-exam"
							class="d-flex flex-column align-items-center mt-3 mb-0">
							<div id="ipa-exam-word"></div>
							<div id="ipa-exam-phonetic"></div>
						</div>
					</div>
					<div id="ipa-source-menu" class="bg-secondary">
						<button class="btn btn-success" onclick="chooseSymbolType()">Symbol</button>
						<!-- <button class="btn btn-success" onclick="chooseVideoPronunType()">Video</button> -->
					</div>
					<div id="ipa-source">
						<div id="ipa-source-symbol" class="d-flex">
							<table class="table">
								<tbody>
									<tr>
										<th scope="row">Vowel</th>
										<%
													for (int i = 0; i < vowel.size(); i++) 															
														out.print("<td><span onclick=\"chooseSymbol('"+vowel.get(i).getId()+"')\">" 
																		+ vowel.get(i).getSymbol()+"</span></td>");												
												%>
									</tr>
									<%
												for (int i = 0; i < consonant.size(); i++) {	
													if (i%10 == 0 && i != 0)
														out.print("</tr>");
													if (i == 0) {
														out.print("<tr>");
														out.print("<th scope=\"row\" rowspan=\"3\">Consonant</th>");
													}
													out.print("<td><span onclick=\"chooseSymbol('" + consonant.get(i).getId() + "')\">"
																+ consonant.get(i).getSymbol()+"</span></td>");	
												}
												out.print("<tr>");
											%>

									<tr>
										<th scope="row">R-Colored</th>
										<%
													for (int i = 0; i < rColoredVowel.size(); i++) 															
														out.print("<td><span onclick=\"chooseSymbol('"+rColoredVowel.get(i).getId()+"')\">"
															+rColoredVowel.get(i).getSymbol()+"</span></td>");												
												%>
									</tr>
									<tr>
										<th scope="row">Diphthong</th>
										<%
													for (int i = 0; i < diphthong.size(); i++) 															
														out.print("<td><span onclick=\"chooseSymbol('"+diphthong.get(i).getId()+"')\">"
															+ diphthong.get(i).getSymbol()+"</span></td>");												
												%>
									</tr>

								</tbody>
							</table>
						</div>
						<div id="ipa-source-videopronun" class="d-flex d-none">VIdeo</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script><%@include file="./ipa-scripts.js"%></script>
</body>
</html>