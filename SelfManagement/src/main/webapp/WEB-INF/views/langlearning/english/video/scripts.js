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
	const requestInfo = {
		url: apiURL.video.getVideosByGroupId.url + "?action="+ Action.GETS +"&groupId=" + groupId,
		method: apiURL.video.getVideosByGroupId.method,
		headers: apiURL.video.getVideosByGroupId.headers,
		data: null
	};
	ajaxCall(requestInfo, callbackGetVideosByGroupId, null);
}
function callbackGetVideosByGroupId(response) {
	let data = JSON.parse(response).data;
	let listVideoEl = document.querySelector("#list-video-of-group");
	let htmlContent = "";
	for (let i = 0; i < data.length; i++) {
		htmlContent = htmlContent + "<li>"+ data[i].title +"<span><i class=\"fa fa-eye\"></i>&nbsp" + data[i].viewCount + "</span></li>";
	}
	listVideoEl.innerHTML = htmlContent;
}