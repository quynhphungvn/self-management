function chooseSymbol(id) {
	const requestInfo = {
		url: apiURL.ipaSymbol.getById.url + "?id=" + id,
		method: apiURL.ipaSymbol.getById.method,
		headers: apiURL.ipaSymbol.getById.headers,
		data: null
	};
	ajaxCall(requestInfo, symbolShowContent, null);
}
function symbolShowContent(symbolText) {
	let symbol = JSON.parse(symbolText);	
	let iframeVideoEl = document.getElementById("ipa-player-iframe");
	let examWordEl = document.getElementById("ipa-exam-word");
	let examPhoneticEl = document.getElementById("ipa-exam-phonetic");
	examWordEl.innerHTML = "<b style='font-size: 2rem;'>" + symbol.example + "</b>";
	examPhoneticEl.innerHTML = "<i>" + symbol.examplePhonetic + "</i>"
	let videoId = symbol.videoGuideLink.split("v=").pop();
	let videoEmbedGuideLink = "https://www.youtube.com/embed/" + videoId;
	iframeVideoEl.setAttribute("src", videoEmbedGuideLink);
	let imgGuideEl = document.getElementById("ipa-imageguide-img");
	imgGuideEl.setAttribute("src", symbol.imgGuideLink);
}