function createNewWordRef() {
	let subtitle = document.getElementById("input-engtext").value;
	
	/*const requestInfo = {
			url: apiURL.word.getAllWordKnown.url,
			method: apiURL.word.getAllWordKnown.method,
			headers: apiURL.word.getAllWordKnown.headers,
			data: null
	};
	ajaxCall(requestInfo, fetchKnownWordCallback, subtitle);*/
	fetchKnownWordCallback(subtitle);
}
function fetchKnownWordCallback(subtitle) {
	let subArray = subtitle.replace(/\d\d:\d\d\n/g, "").replace(/\r?\n|\r/g, " ").split(" ");	
	let wordHtml = "";
	//let listKnownWord = JSON.parse(listKnownWordText);
	let listKnownWord = [];
	for (let i = 0; i < subArray.length; i++) {
		let word = removeUnexpectChar(subArray[i]);
		let flagKnown = false;
		for (let j = 0; j < listKnownWord.length; j++) {			
			if (word == listKnownWord[j].word) {
				let wordEl = "<span class='px-2 mx-1 rounded' onclick=\"pickWord(this)\">"
				 + subArray[i] + "</span>";
				wordHtml += wordEl;
				flagKnown = true;
				break;
			}		
		}
		if (!flagKnown){
			/*let wordEl = "<span class='bg-warning bg-opacity-25 px-2 mx-1 rounded' onclick=\"pickWord(this)\">"
				 + subArray[i] + "</span>";*/
			let wordEl = "<span class='bg-opacity-25 px-2 mx-1 rounded span-hover' onclick=\"pickWord(this)\">"
				 + subArray[i] + "</span>";
				wordHtml += wordEl;
		}
	}
	document.getElementById("sub-word-content").innerHTML = wordHtml;
	document.getElementById("input-engtext").value = "";
}

function pickWord(spanEl) {
	let word = removeUnexpectChar(spanEl.textContent)
	setWordToInputWord(word);
	setWordToLinkLookup(word);
}
function setWordToInputWord(word) {
	document.getElementById("sub-input-word").value = word;
}
function setWordToLinkLookup(word) {
	let linkYouglish = "https://youglish.com/pronounce/" + word + "/english?";
	let linkGoogle = "https://www.google.com/search?tbm=isch&q=" + word;
	let linkCambridge = "https://dictionary.cambridge.org/vi/dictionary/english/" + word;
	let linkTratu = "http://tratu.coviet.vn/hoc-tieng-anh/tu-dien/lac-viet/A-V/" + word +".html";
	document.getElementById("link-youglish").setAttribute("href", linkYouglish);
	document.getElementById("link-google").setAttribute("href", linkGoogle);
	document.getElementById("link-cambridge").setAttribute("href", linkCambridge);
	document.getElementById("link-tratu").setAttribute("href", linkTratu);
}

function addWordToWordKnown() {
	let word = document.getElementById("sub-input-word").value;
	const requestInfo = {
			url: apiURL.word.addWordToWordKnown.url,
			method: apiURL.word.addWordToWordKnown.method,
			headers: apiURL.word.addWordToWordKnown.headers,
			data: "action=" + apiURL.word.addWordToWordKnown.action
				+"&word=" + word
	};
	ajaxCall(requestInfo, addToWordKnownCallback, word);
}

function addToWordKnownCallback(text, word) {
	changeBackgroundForWord(word, "add");
}
function changeBackgroundForWord(word, action) {
	let subChilds = document.getElementById("sub-word-content").childNodes;
	if (action == "add") {
		for (let i = 0; i < subChilds.length; i++) 
		{
			if (removeUnexpectChar(subChilds[i].textContent) == word)
				subChilds[i].classList.remove("bg-warning");
		}
	}
}