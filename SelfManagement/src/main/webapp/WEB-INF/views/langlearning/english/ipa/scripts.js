function showLeftMenu() {
    let menu = document.getElementById("left-menu");
    menu.style.left = "0";
}
function closeLeftMenu() {
    let menu = document.getElementById("left-menu");
    menu.style.left = "-300px";
}
function showSymbolGuide(evt, tabContentId) {
    let tabLinks = document.getElementsByClassName("tab-links");
    for (let i = 0; i < tabLinks.length; i++) 
        tabLinks.item(i).className = tabLinks.item(i).className.replace("active", "");
    let tabContents = document.getElementsByClassName("tab-content");
    for (let i = 0; i < tabContents.length; i++) 
        tabContents.item(i).style.display = "none";
    document.getElementById(tabContentId).style.display = "flex";
    evt.currentTarget.className += " active";
}
function chooseSymbol(evt, id) {
	let tdEls = document.getElementsByTagName("td");
	for (let i = 0; i < tdEls.length; i++) {
		tdEls.item(i).className = tdEls.item(i).className.replace("active", "");
	}
	evt.currentTarget.className += " active";
	const requestInfo = {
		url: apiURL.ipaSymbol.getById.url + "?id=" + id,
		method: apiURL.ipaSymbol.getById.method,
		headers: apiURL.ipaSymbol.getById.headers,
		data: null
	};
	ajaxCall(requestInfo, symbolShowContent, null);
}
function symbolShowContent(symbolText) {
	console.log(symbolText);
	let symbol = JSON.parse(symbolText);	
	let iframeVideoEl = document.getElementById("ipa-player-iframe");
	let examWordEl = document.getElementById("ipa-exam-word");
	let examPhoneticEl = document.getElementById("ipa-exam-phonetic");
	examWordEl.innerHTML = "<b style='font-size: 2rem;'>" + symbol.example + "</b>";
	examPhoneticEl.innerHTML = "<i>" + symbol.examplePhonetic + "</i>"
	let videoId = symbol.videoGuideURL.split("v=").pop();
	let videoEmbedGuideLink = "https://www.youtube.com/embed/" + videoId;
	iframeVideoEl.setAttribute("src", videoEmbedGuideLink);
	let imgGuideEl = document.getElementById("symbol-image");
	imgGuideEl.setAttribute("src", "/SelfManagement/static/images/ipa-symbol" + symbol.imgGuideURL);
	document.getElementById("symbol-title").textContent = "/" + symbol.symbol + "/";
	document.getElementById("symbol-view").textContent = symbol.viewCount;
}
