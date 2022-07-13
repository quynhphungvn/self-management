function showLeftMenu() {
    let menu = document.getElementById("left-menu");
    menu.style.left = "0";
}
function closeLeftMenu() {
    let menu = document.getElementById("left-menu");
    menu.style.left = "-300px";
}

function chooseSymbol(evt, id) {
	let tdEls = document.getElementsByTagName("td");
	for (let i = 0; i < tdEls.length; i++) {
		tdEls.item(i).className = tdEls.item(i).className.replace("active", "");
	}
	evt.currentTarget.className += " active";
	const requestInfo = {
		url: "/SelfManagement/langlearning/english/symbol/api/" + "?id=" + id,
		method: "GET",
		headers:[
				{ name: "charset", value: "UTF-8" },
				{ name: "content-type", value: "application/x-www-form-urlencoded" }
		],
		data: null
	};
	ajaxCall(requestInfo, symbolShowContent, null);
}
function symbolShowContent(symbolText) {
	let symbol = JSON.parse(symbolText).data;	
	let iframeVideoEl = document.getElementById("ipa-player-iframe");
	let examWordEl = document.getElementById("ipa-exam-word");
	let examPhoneticEl = document.getElementById("ipa-exam-phonetic");
	examWordEl.innerHTML = "<b style='font-size: 2rem;'>" + symbol.example + "</b>";
	examPhoneticEl.innerHTML = "<i>" + symbol.examplePhonetic + "</i>"
	let videoId = symbol.videoGuideURL.split("v=").pop();
	let videoEmbedGuideLink = "https://www.youtube.com/embed/" + videoId;
	iframeVideoEl.setAttribute("src", videoEmbedGuideLink);
	let imgGuideEl = document.getElementById("symbol-image").getElementsByTagName("img").item(0);
	imgGuideEl.setAttribute("src", "/SelfManagement/static/images/ipa-symbol" + symbol.imgGuideURL);
	document.getElementById("symbol-title").textContent = "/" + symbol.content + "/";
	document.getElementById("symbol-view").textContent = symbol.viewCount;
}
