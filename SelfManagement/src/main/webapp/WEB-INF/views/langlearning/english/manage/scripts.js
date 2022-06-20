function showLeftMenu() {
	let menu = document.getElementById("left-menu");
	menu.style.left = "0";
}
function closeLeftMenu() {
	let menu = document.getElementById("left-menu");
	menu.style.left = "-300px";
}
///////////////////////////////////////////////////////////////////////////////////////
var currentVideo = null;
////////////////////////////** Common **////////////////////////////////////////////////
function getGroupNameFromInput() {
	return document.querySelector("#input-video-group").value;
}
function clearGForm() {
	document.querySelector("#gform-select-group").value = -1;
	document.querySelector("#input-video-group").value = "";
	document.querySelector("#videos-by-group").innerHTML = "";
}
function clearVForm() {
	document.querySelector("#vform-id").value = "";
	document.querySelector("#vform-title").value = "";
	document.querySelector("#vform-url").value = "";
	document.querySelector("#vform-select-group").value = -1;
	document.querySelector("#vform-subtitle").value = "";
	document.querySelector("#btn-add-video").disabled = false;
	document.querySelector("#btn-update-video").disabled = true;
	document.querySelector("#btn-delete-video").disabled = true;
}
function showMessageFail(resultObj) {
	alert(resultObj.data);
}
function showMessageSuccess() {
	alert("Success!");
}
/////////////////////////////** Add group **//////////////////////////////////////////////
function addVideoGroupByName() {
	let groupName = getGroupNameFromInput();
	if (groupName.trim() == "")
		alert("Group name empty!");
	else if (checkGroupNameExisted(groupName)) {
		alert("Group name existed!");
	} else {
		requestAddVideoGroupByName(groupName);
	}
}

function checkGroupNameExisted(groupName) {
	let selChildNodes = document.querySelector("#gform-select-group").childNodes;
	for (let i = 0; i < selChildNodes.length; i++) {
		let content = selChildNodes[i].textContent;
		if (content === groupName) {
			return true;
		}
	}
	return false;
}
function requestAddVideoGroupByName(groupName) {
	const requestInfo = {
		url: apiURL.videoGroup.addGroup.url,
		method: apiURL.videoGroup.addGroup.method,
		headers: apiURL.videoGroup.addGroup.headers,
		data: "action=" + Action.ADD_VIDEO_GROUP + "&" + "groupName=" + groupName
	};
	ajaxCall(requestInfo, updateGuiAfterAddVideoGroup, null);
}
function updateGuiAfterAddVideoGroup(result) {
	let resultObj = JSON.parse(result);
	if (resultObj.status === MessageStatus.SUCCESS) {
		updateAddVideoGroupGForm(resultObj.data);
		updateAddVideoGroupVForm(resultObj.data);
		clearGForm();
		showMessageSuccess();
	}
	else
		showMessageFail(resultObj.data);
}
function updateAddVideoGroupGForm(group) {
	let selectEl = document.querySelector("#gform-select-group");
	let newGroupEl = document.createElement("option");
	newGroupEl.setAttribute("value", group.id);
	newGroupEl.innerHTML = group.name;
	selectEl.appendChild(newGroupEl);
	selectEl.value = -1;
}
function updateAddVideoGroupVForm(group) {
	let selectEl = document.querySelector("#vform-select-group");
	let newGroupEl = document.createElement("option");
	newGroupEl.setAttribute("value", group.id);
	newGroupEl.innerHTML = group.name;
	selectEl.appendChild(newGroupEl);
	selectEl.value = -1;
}

/////////////////////////////** End add group **//////////////////////////////////////////

/////////////////////////////** Delete video group **/////////////////////////////////////
function deleteVideoGroupByName() {
	let groupName = getGroupNameFromInput();
	if (groupName.trim() == "")
		alert("Group name empty!");
	else if (!checkGroupNameExisted(groupName)) {
		alert("Group name not existed!");
	} else {
		if (confirm("Are you sure?") == true)
			requestDeleteVideoGroupByName(groupName);
		else {
			document.querySelector("#gform-select-group").value = -1;
			clearGForm();
		}
	}
}
function requestDeleteVideoGroupByName(groupName) {
	const requestInfo = {
		url: apiURL.videoGroup.deleteGroup.url,
		method: apiURL.videoGroup.deleteGroup.method,
		headers: apiURL.videoGroup.deleteGroup.headers,
		data: "action=" + Action.DELETE_VIDEO_GROUP + "&" + "groupName=" + groupName
	};
	ajaxCall(requestInfo, updateGuiAfterDelVideoGroup, groupName);
}
function updateGuiAfterDelVideoGroup(result, groupName) {
	let resultObj = JSON.parse(result);
	if (resultObj.status === MessageStatus.SUCCESS) {
		updateDelVideoGroupGForm(groupName);
		updateDelVideoGroupVForm(groupName);
		clearGForm();
		showMessageSuccess();
		document.querySelector("#videos-by-group").innerHTML = "";
	}
	else
		showMessageFail();
}
function updateDelVideoGroupGForm(groupName) {
	let selectEl = document.querySelector("#gform-select-group");
	let childNodeSelect = selectEl.childNodes;
	for (let i = 0; i < childNodeSelect.length; i++) {
		if (childNodeSelect[i].innerHTML === groupName) {
			selectEl.removeChild(childNodeSelect[i]);
			break;
		}
	}
	selectEl.value = -1;
}
function updateDelVideoGroupVForm(groupName) {
	let selectEl = document.querySelector("#vform-select-group");
	let childNodeSelect = selectEl.childNodes;
	for (let i = 0; i < childNodeSelect.length; i++) {
		if (childNodeSelect[i].innerHTML === groupName) {
			selectEl.removeChild(childNodeSelect[i]);
			break;
		}
	}
	selectEl.value = -1;
}
/////////////////////////////** End delete video group **////////////////////////////////////

/////////////////////////////**   show video of group  **////////////////////////////////////
function chooseVideoGroupGForm(selEl) {
	clearVForm();
	if (selEl.value == -1) {
		clearGForm();
	}
	else {
		document.querySelector("#input-video-group").value = selEl.options[selEl.selectedIndex].text;
		getVideosByGroupId(selEl.value);
	}
}
function getVideosByGroupId(groupId) {
	const requestInfo = {
		url: apiURL.video.getVideosByGroupId.url + "?action=" + Action.GET_VIDEOS_BY_GROUP_ID + "&groupId=" + groupId,
		method: apiURL.video.getVideosByGroupId.method,
		headers: apiURL.video.getVideosByGroupId.headers,
		data: null
	};
	ajaxCall(requestInfo, updateGuiAfterChooseSelectGroup, null);
}
function updateGuiAfterChooseSelectGroup(response) {
	let res = JSON.parse(response);
	if (res.status == "SUCCESS") {
		let listVideo = res.data;
		if (listVideo != null) {
			let ulElListVideo = document.querySelector("#videos-by-group");
			let listVideoHTML = "";
			for (let i = 0; i < listVideo.length; i++) {
				listVideoHTML = listVideoHTML + "<li class=\"item\" data-vid=\" " + listVideo[i].id + "\" onclick=\"getVideoInfoById(this, '" + listVideo[i].id + "')\">" + listVideo[i].title + "</li>";
			}
			ulElListVideo.innerHTML = listVideoHTML;
		}
	}
}

////////////////////////////////** Add Video **///////////////////////////////////////
function addVideo() {
	let title = document.querySelector("#vform-title").value;
	let url = document.querySelector("#vform-url").value;
	let groupId = document.querySelector("#vform-select-group").value;
	let subtitle = document.querySelector("#vform-subtitle").value;
	if (!title || !url || groupId == -1) {
		alert("form member blank!");
	}
	else {
		const requestInfo = {
			url: apiURL.video.add.url,
			method: apiURL.video.add.method,
			headers: apiURL.video.add.headers,
			data: "action=" + Action.ADD_VIDEO
				+ "&title=" + title
				+ "&url=" + url
				+ "&groupId=" + groupId
				+ "&subtitle=" + subtitle
		};
		ajaxCall(requestInfo, callBackAddVideo, groupId);
	}
}
function callBackAddVideo(response, groupId) {
	let rmes = JSON.parse(response);
	if (rmes.status == "SUCCESS") {
		alert(rmes.status);
		clearVForm();
		let videoSelectEl = document.querySelector("#gform-select-group");
		let videoListEl = document.querySelector("#videos-by-group");
		if (videoSelectEl.value == groupId) {
			let liEl = document.createElement("li");
			liEl.setAttribute("data-vid", rmes.data.id);
			liEl.addEventListener("click",function () {getVideoInfoById(liEl, rmes.data.id);});
			liEl.classList.add("item");
			liEl.textContent = rmes.data.title;
			videoListEl.appendChild(liEl);
		}
	}
	else {
		alert(rmes.status);
	}
}
///////////////////////////////////////** Get video info **//////////////////////////////////
function getVideoInfoById(el, videoId) {
	const requestInfo = {
		url: apiURL.video.getVideoById.url + "?action=GET_VIDEO_BY_ID&videoId=" + videoId,
		method: apiURL.video.getVideoById.method,
		headers: apiURL.video.getVideoById.headers,
		data: null
	};
	ajaxCall(requestInfo, showVideoInfo, el);
}
function showVideoInfo(response, el) {
	let mes = JSON.parse(response);
	if (mes.status == "SUCCESS") {
		if (mes.data != null) {
			document.querySelector("#vform-id").value = mes.data.id;
			document.querySelector("#vform-title").value = mes.data.title;
			document.querySelector("#vform-url").value = mes.data.url;
			document.querySelector("#vform-select-group").value = mes.data.groupId;
			document.querySelector("#vform-subtitle").value = mes.data.subtitle;
			setActiveClass(el);
			currentVideo = mes.data;
		}
		document.querySelector("#btn-add-video").disabled = true;
		document.querySelector("#btn-update-video").disabled = false;
		document.querySelector("#btn-delete-video").disabled = false;
	}
}
////////////////////////////////////////** Update ** //////////////////////////////////////////
function updateVideo() {
	let video = {};
	video.id = document.querySelector("#vform-id").value;
	if (!video.id) {
		alert("Video not valid");
	} else {
		video.title = document.querySelector("#vform-title").value;
		video.url = document.querySelector("#vform-url").value;
		video.groupId = document.querySelector("#vform-select-group").value;
		video.subtitle = document.querySelector("#vform-subtitle").value;
		sendRequestUpdateVideo(video);
	}
}
function sendRequestUpdateVideo(video) {
	const requestInfo = {
		url: apiURL.video.update.url,
		method: apiURL.video.update.method,
		headers: apiURL.video.update.headers,
		data: "action=" + Action.UPDATE_VIDEO
			+ "&id=" + video.id
			+ "&title=" + video.title
			+ "&url=" + video.url
			+ "&groupId=" + video.groupId
			+ "&subtitle=" + video.subtitle
	};
	ajaxCall(requestInfo, updateVideoCallback, null);
}
function updateVideoCallback(response) {
	let rmes = JSON.parse(response);
	if (rmes.status == "SUCCESS") {
		alert("Update successfully");
		clearVForm();
		clearActiveClass(document.querySelector("#videos-by-group"));
	}
	else
		alert("Update fail");
}
function deleteVideo() {
	let id = document.querySelector("#vform-id").value;
		if (confirm("Do you want to delete this video?") == true) {
		if (!id) {
			alert("Id not exist");
		} else {
			const requestInfo = {
				url: apiURL.video.delete.url,
				method: apiURL.video.delete.method,
				headers: apiURL.video.delete.headers,
				data: "action=" + Action.DELETE_VIDEO
					+"&id=" + id
			};
			ajaxCall(requestInfo, deleteVideoCallback, null);
		}
	}
}
function deleteVideoCallback(response) {
	let rmes = JSON.parse(response);
	if (rmes.status == "SUCCESS") {
		alert("Delete successfully");
		clearVForm();
		let listVideo = document.querySelector("#videos-by-group");
		let videoItemEls = listVideo.childNodes;
		for (let i = 0; i < videoItemEls.length; i++) {
			if (videoItemEls[i].dataset.vid == rmes.data) {
				listVideo.removeChild(videoItemEls[i]);
				break;
			}
		}
	}
	else
		alert("Delete fail");
}
