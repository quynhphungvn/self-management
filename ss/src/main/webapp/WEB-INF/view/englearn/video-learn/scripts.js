function chooseVideoType() {
	let videoPlayer = document.getElementById("ipa-player");
	let imageGuide = document.getElementById("ipa-imageguide");
	videoPlayer.classList.remove("d-none");
	imageGuide.classList.add("d-none");
}
function chooseImageType() {
	let videoPlayer = document.getElementById("ipa-player");
	let imageGuide = document.getElementById("ipa-imageguide");
	videoPlayer.classList.add("d-none");
	imageGuide.classList.remove("d-none");
}
function chooseSymbolType() {
	let symbolType = document.getElementById("ipa-source-symbol");
	let videoPronunType = document.getElementById("ipa-source-videopronun");
	videoPronunType.classList.add("d-none");
	symbolType.classList.remove("d-none");
}
function chooseVideoPronunType() {
	let symbolType = document.getElementById("ipa-source-symbol");
	let videoPronunType = document.getElementById("ipa-source-videopronun");
	videoPronunType.classList.remove("d-none");
	symbolType.classList.add("d-none");
}
function chooseAddNote() {
	let addNote = document.getElementById("note-add");
	let manageNote = document.getElementById("note-manage");
	addNote.classList.remove("d-none")
	manageNote.classList.add("d-none");
}
function chooseManageNote() {
	let addNote = document.getElementById("note-add");
	let manageNote = document.getElementById("note-manage");
	addNote.classList.add("d-none")
	manageNote.classList.remove("d-none");
}
///////////////////////////////////////////////////////////////
let listVideoOfGroup = [];
let listEditVideoOfGroup = [];
let currentPlayingVideo = null;
let currentVideoEdit = null;
////////////////////////////////////////////////////
function chooseGroupVideo(selectGroupEl) {
	/*let selectGroupEl = document.getElementById("select-group-video");*/
	let groupId = selectGroupEl.value;
	if (groupId == -1) {
		document.getElementById("videolist").innerHTML = null;
	}
	else{
		const requestInfo = {
			url: apiURL.videoLearn.getByGroupId.url + "?groupid=" + groupId,
			method: apiURL.videoLearn.getByGroupId.method,
			headers: apiURL.videoLearn.getByGroupId.headers,
			data: null
		};
		ajaxCall(requestInfo, showVideoLearnList, null);
	}
}
function showVideoLearnList(listVideoJsonText) {
	let listVideo = JSON.parse(listVideoJsonText);
	listVideoOfGroup = listVideo;
	let tempListVideoEl = "";
	for (let i = 0; i < listVideo.length; i++) {
		let btn = '<button type="button" id="video-learn-'+listVideo[i].id
						+'" class="list-group-item list-group-item-action list-group-item-light d-flex justify-content-between"'
						+ 'onclick="chooseVideoLearn('+listVideo[i].id+')">'
						+listVideo[i].name+'</button>';
		tempListVideoEl = tempListVideoEl + btn;
	}
	let pageVideoListEl = document.getElementById("videolist");
	pageVideoListEl.innerHTML = tempListVideoEl;
}
function chooseVideoLearn(videoId) {
	let iframeEl = document.getElementById("iframe-englearn-player");
	for (let i = 0; i < listVideoOfGroup.length; i++) {
		if(listVideoOfGroup[i].id == videoId) {
			let currentItemEl = document.getElementById("video-learn-" + videoId);
			if (currentPlayingVideo) {
				currentPlayingVideo.classList.remove("videolearn-active");
				currentPlayingVideo = currentItemEl;
				currentPlayingVideo.classList.add("videolearn-active");
			} else {			
				currentPlayingVideo = currentItemEl;
				currentPlayingVideo.classList.add("videolearn-active");
			}
			if(listVideoOfGroup[i].subcription == null)
				tryToGetSubcriptionFromYt();
			let videoYtId = listVideoOfGroup[i].link.split("v=").pop();
			iframeEl.setAttribute("src", "https://www.youtube.com/embed/" + videoYtId);
			createNewWordRef(listVideoOfGroup[i].subtitle);
			break;
		}
	}
 }
function tryToGetSubcriptionFromYt() {}
 //////////////////////////////////////////



