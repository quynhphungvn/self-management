function showLeftMenu() {
	let menu = document.getElementById("left-menu");
	menu.style.left = "0";
}
function closeLeftMenu() {
	let menu = document.getElementById("left-menu");
	menu.style.left = "-300px";
}
function showBonusInfo(evt, tabName) {
	let bonusInfoEl = document.getElementById("bonus-info");
	var i, tabcontent, tablinks;

	// Get all elements with class="tabcontent" and hide them
	tabcontent = bonusInfoEl.getElementsByClassName("tab-content");
	for (i = 0; i < tabcontent.length; i++) {
		tabcontent[i].style.display = "none";
	}

	// Get all elements with class="tablinks" and remove the class "active"
	tablinks = bonusInfoEl.getElementsByClassName("tab-links");
	for (i = 0; i < tablinks.length; i++) {
		tablinks[i].className = tablinks[i].className.replace(" active", "");
	}

	// Show the current tab, and add an "active" class to the button that opened the tab
	document.getElementById(tabName).style.display = "block";
	evt.currentTarget.className += " active";
}

function getVideosOfGroup() {
	let groupId = document.querySelector("#select-video-group").value;
	if (groupId == -1) {
		document.querySelector("#videos-of-group").innerHTML = "";
	}
	else {
		const requestInfo = {
			url: apiURL.video.getVideosByGroupId.url + "?action=" + Action.GET_VIDEOS_BY_GROUP_ID + "&groupId=" + groupId,
			method: apiURL.video.getVideosByGroupId.method,
			headers: apiURL.video.getVideosByGroupId.headers,
			data: null
		};
		ajaxCall(requestInfo, callbackGetVideosOfGroup, null);
	}
}
function callbackGetVideosOfGroup(response) {
	let rmes = JSON.parse(response);
	if (rmes.status == "SUCCESS") {
		let data = rmes.data;
		let htmlContent = "";
		for (let i = 0; i < data.length; i++) {
			htmlContent = htmlContent + "<li onclick='playVideo(this)' data-vid='" + data[i].id +"'>" 
			+ data[i].title 
			+ "<span><i class=\"fa fa-eye\"></i>&nbsp<b>" + data[i].viewCount + "</b></span></li>";
		}
		document.querySelector("#videos-of-group").innerHTML = htmlContent;
	}
}
function playVideo(el) {
	const requestInfo = {
		url: apiURL.video.getVideoById.url + "?action=GET_VIDEO_BY_ID&videoId=" + el.dataset.vid,
		method: apiURL.video.getVideoById.method,
		headers: apiURL.video.getVideoById.headers,
		data: null
	};
	ajaxCall(requestInfo, setVideo, el);
}
function setVideo(response, el) {
	let rmes = JSON.parse(response);
	
	if (rmes.status == "SUCCESS") {
		setActiveClass(el);
		let ytId = rmes.data.url.split("v=").pop();
		let iframeEl = document.getElementsByTagName("iframe").item(0);
		iframeEl.setAttribute("src", "https://www.youtube.com/embed/" + ytId);
		addVideoViewCount(el);
		setSubtitlePanel(rmes.data.subtitle);
	}
} 
function addVideoViewCount(el) {
	const requestInfo = {
		url: apiURL.video.updateViewCount.url,
		method: apiURL.video.updateViewCount.method,
		headers: apiURL.video.updateViewCount.headers,
		data: "action=" + Action.UPDATE_VIDEO_VIEW_COUNT
			+ "&videoId=" + el.dataset.vid
	};
	ajaxCall(requestInfo, updateGUIViewCount, el);
}
function updateGUIViewCount(response, el) {
	let rmes = JSON.parse(response);
	if (rmes.status == "SUCCESS")
		el.getElementsByTagName("b").item(0).innerHTML = rmes.data;
}
function setSubtitlePanel(subtitle) {
	const requestInfo = {
		url: apiURL.word.getWordKnowns.url + "?action=GET_WORDKNOWNS",
		method: apiURL.word.getWordKnowns.method,
		headers: apiURL.word.getWordKnowns.headers,
		data: null
	};
	ajaxCall(requestInfo, buildHtmlSubtitle, subtitle);
}

function buildHtmlSubtitle(response, subtitle) {
	let rmes = JSON.parse(response);
	
	if (rmes.status = "SUCCESS") {
		let wordKnowns = rmes.data;
		let lines = subtitle.split("\n");
		let videoSubHtml = "";
		for (let i = 0; i < lines.length; i++) {
			let temp = "";
			if (i % 2 == 0) {
				//line contains the time content
				temp = "<li><time>" + lines[i] + "</time>";
			} else {
				//line contains subs
				let htmlForAllWords = "";
				let allWordInLine = lines[i].split(" ");
				for (let i = 0; i < allWordInLine.length; i++) {					
					htmlForAllWords = htmlForAllWords + createHtmlForWord(allWordInLine[i], wordKnowns);				
				}
				temp = "<div>" + htmlForAllWords + "</div></li>";
			}
			videoSubHtml = videoSubHtml + temp;
		}
		document.querySelector("#subtitle").innerHTML = videoSubHtml;
	}
}
function createHtmlForWord(word, wordKnowns) {
	let pureWord = removeUnexpectChar(word.toLowerCase());
	if (wordKnowns.includes(" "+ pureWord + " ")) {
		return "<span onclick=\"chooseWord(this)\">" + word + "</span>";
	} else {
		return "<span class=\"word-unknown\" onclick=\"chooseWord(this)\">" + word + "</span>";
	}
}
function chooseWord(el) {
	let word = removeUnexpectChar(el.textContent.toLowerCase());
	document.querySelector("#input-lookup").value = word;
	setWordToLinkLookup(word);
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
	let word = document.getElementById("input-lookup").value;
	const requestInfo = {
			url: apiURL.word.addWordToWordKnown.url,
			method: apiURL.word.addWordToWordKnown.method,
			headers: apiURL.word.addWordToWordKnown.headers,
			data: "action=" + Action.ADD_WORD_TO_WORD_KNOWN
				+"&word=" + word
	};
	ajaxCall(requestInfo, addToWordKnownCallback, word);
}
function addToWordKnownCallback(response, word) {
	let rmes = JSON.parse(response);
	if (rmes.status == "SUCCESS") {
		changeBackgroundForWord(word, "add"); 	
	}
	else 
		alert(rmes.data);
}
function changeBackgroundForWord(word, action) {
	let subEl = document.querySelector("#subtitle");
	let wordEls = subEl.getElementsByTagName("span");
	if (action == "add") {
		for (let i = 0; i < wordEls.length; i++) {
			if (removeUnexpectChar(wordEls[i].textContent) == word)
				wordEls[i].classList.remove("word-unknown");
		}
	}
	else if (action == "remove") {
		for (let i = 0; i < wordEls.length; i++) {
			if (removeUnexpectChar(wordEls[i].textContent) == word)
				wordEls[i].classList.add("word-unknown");
		}
	}
}







