function chooseEditGroupVideo(groupId) {
	clearFormEdit();
	/*let selectGroupEl = document.getElementById("select-group-video");*/
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
		ajaxCall(requestInfo, showEditVideoLearnList, null);
	}
}
function showEditVideoLearnList(listVideoJsonText) {
	let listVideo = JSON.parse(listVideoJsonText);
	listEditVideoOfGroup = listVideo;
	let tempListVideoEl = "";
	for (let i = 0; i < listVideo.length; i++) {
		let btn = '<button type="button" class="list-group-item list-group-item-action"'
						+ 'onclick="chooseEditVideoLearn('+listVideo[i].id+')">'
						+listVideo[i].name+'</button>';
		tempListVideoEl = tempListVideoEl + btn;
	}
	let pageEditVideoListEl = document.getElementById("b-edit-listvideo");
	pageEditVideoListEl.innerHTML = tempListVideoEl;
}
function chooseEditVideoLearn(videoId) {
	let videoNameEl = document.getElementById("input-videoname");
	let videoTitleEl = document.getElementById("input-videotitle");
	let videoLinkEl = document.getElementById("input-videolink");
	let videoSubtitleEl = document.getElementById("input-videosubtitle");
	let videoGroupEl = document.getElementById("select-add-group-video");
	clearFormEdit();
	for (let i = 0; i < listEditVideoOfGroup.length; i++) {
		if (listEditVideoOfGroup[i].id == videoId) {
			currentVideoEdit = listEditVideoOfGroup[i];
			videoNameEl.value = listEditVideoOfGroup[i].name;
			if (listEditVideoOfGroup[i].title)
			videoTitleEl.value = listEditVideoOfGroup[i].title;
			if (listEditVideoOfGroup[i].link)
			videoLinkEl.value = listEditVideoOfGroup[i].link;
			if (listEditVideoOfGroup[i].subtitle)
			videoSubtitleEl.value = listEditVideoOfGroup[i].subtitle; 
			videoGroupEl.value = listEditVideoOfGroup[i].groupId;
			break;
		}
	}
}
function clearFormEdit() {
	let videoNameEl = document.getElementById("input-videoname");
	let videoTitleEl = document.getElementById("input-videotitle");
	let videoLinkEl = document.getElementById("input-videolink");
	let videoSubtitleEl = document.getElementById("input-videosubtitle");
	let videoGroupEl = document.getElementById("select-add-group-video");
	videoNameEl.value = "";
	videoTitleEl.value = "";
	videoLinkEl.value = "";
	videoSubtitleEl.value = "";
	videoGroupEl.value = "-1";
}
function updateVideoEdit() {
	let videoName = document.getElementById("input-videoname").value;
	let videoTitle = document.getElementById("input-videotitle").value;
	let videoLink = document.getElementById("input-videolink").value;
	let videoSubtitle = document.getElementById("input-videosubtitle").value;
	const dataUpdate = "action=update&id=" + currentVideoEdit.id
					+ "&name="+ videoName
					+ "&title=" + videoTitle
					+ "&link=" + videoLink
					+ "&subtitle=" + videoSubtitle;
	const requestInfo = {
		url: apiURL.videoLearn.updateVideoById.url,
		method: apiURL.videoLearn.updateVideoById.method,
		headers: apiURL.videoLearn.updateVideoById.headers,
		data: dataUpdate
	};
	ajaxCall(requestInfo, showUpdateMessage, null);
}
function showUpdateMessage() {
	let groupId = document.getElementById("select-edit-group-video").value;
	chooseEditGroupVideo(groupId);
	clearFormEdit();
}
function addVideoGroup() {
	let groupName = document.getElementById("input-group").value;
	if (groupName != null && groupName != "") {
		const requestInfo = {
				url: apiURL.videoLearnGroup.addGroup.url,
				method: apiURL.videoLearnGroup.addGroup.method,
				headers: apiURL.videoLearnGroup.addGroup.headers,
				data: "action=addgroup&groupName=" + groupName
		};
		ajaxCall(requestInfo, addGroupCallback, null);
	}
}
function addGroupCallback() {
	
}
function addVideoLearn() {
	let videoNameEl = document.getElementById("input-videoname");
	let videoTitleEl = document.getElementById("input-videotitle");
	let videoLinkEl = document.getElementById("input-videolink");
	let videoSubtitleEl = document.getElementById("input-videosubtitle");
	let videoGroupEl = document.getElementById("select-add-group-video");
	if (videoGroupEl != -1) {
		let videoData = "action=" + apiURL.videoLearn.addVideo.action 
						+ "&name=" + videoNameEl.value
						+ "&title=" + videoTitleEl.value
						+ "&link=" + videoLinkEl.value
						+ "&subtitle=" + videoSubtitleEl.value
						+ "&groupId=" + videoGroupEl.value;
		const requestInfo = {
			url: apiURL.videoLearn.updateVideoById.url,
			method: apiURL.videoLearn.updateVideoById.method,
			headers: apiURL.videoLearn.updateVideoById.headers,
			data: videoData
		};
		ajaxCall(requestInfo, addVideoLearnCallback, null);
	}
}
function addVideoLearnCallback() {
	
}