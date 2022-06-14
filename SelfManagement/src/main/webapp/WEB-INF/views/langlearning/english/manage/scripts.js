function showLeftMenu() {
	let menu = document.getElementById("left-menu");
	menu.style.left = "0";
}
function closeLeftMenu() {
	let menu = document.getElementById("left-menu");
	menu.style.left = "-300px";
}
////////////////////////////** Common **////////////////////////////////////////////////
function getGroupNameFromInput() {
	return document.querySelector("#input-video-group").value;
}
function clearInputGroupGForm() {
	document.querySelector("#input-video-group").value = "";
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
	ajaxCall(requestInfo, updateGuiAfterAddVideoGroup, groupName);
}
function updateGuiAfterAddVideoGroup(result, groupName) {
	let resultObj = JSON.parse(result);
	if (resultObj.status === MessageStatus.SUCCESS) {
		updateAddVideoGroupGForm(groupName);
		updateAddVideoGroupVForm(groupName);
		clearInputGroupGForm();
		showMessageSuccess();
	}
	else
		showMessageFail(resultObj);
}
function updateAddVideoGroupGForm(groupName) {
	let selectEl = document.querySelector("#gform-select-group");
	let newGroupEl = document.createElement("option");
	newGroupEl.innerHTML = groupName;
	selectEl.appendChild(newGroupEl);
	selectEl.value = -1;
}
function updateAddVideoGroupVForm(groupName) {
	let selectEl = document.querySelector("#vform-select-group");
	let newGroupEl = document.createElement("option");
	newGroupEl.innerHTML = groupName;
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
			clearInputGroupGForm();
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
		clearInputGroupGForm();
		showMessageSuccess();
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
	if (selEl.value == -1) {
		document.querySelector("#input-video-group").value = "";
	}
	else {
		document.querySelector("#input-video-group").value = selEl.options[selEl.selectedIndex].text;
		getVideosByGroupId(selEl.value);
	}
}
function getVideosByGroupId(groupId) {
	const requestInfo = {
		url: apiURL.video.getVideosByGroupId.url + "?action=" + Action.GETS + "&groupId=" + groupId,
		method: apiURL.video.getVideosByGroupId.method,
		headers: apiURL.video.getVideosByGroupId.headers,
		data: null
	};
	ajaxCall(requestInfo, callbackGetVideosByGroupId, null);
}
function callbackGetVideosByGroupId(message) {
	let mes = JSON.parse(message);
	console.log(mes);
	let listVideo = mes.data;
	let ulElListVideo = document.querySelector("#videos-by-group");
	let listVideoHTML = "";
	for (let i = 0; i < listVideo.length; i++) {
		listVideoHTML = listVideoHTML + "<li>" + listVideo[i].title + "</li>";
	}
	ulElListVideo.innerHTML = listVideoHTML;
}

////////////////////////////////** Add Video **///////////////////////////////////////
function addVideo() {
	let title = document.querySelector("#vform-title").value;
	let url = document.querySelector("#vform-url").value;
	let groupId = document.querySelector("#vform-select-group").value;
	let subtitle = document.querySelector("#vform-subtitle").value;
	if (!title || !url || !groupId) {
		alert("form member blank!");
	}
	else {
		const requestInfo = {
			url: apiURL.video.add.url,
			method: apiURL.video.add.method,
			headers: apiURL.video.add.headers,
			data: "action=" + Action.ADD
				+ "&title=" + title
				+ "&url=" + url
				+ "&groupId=" + groupId
				+ "&subtitle=" + subtitle
		};
		ajaxCall(requestInfo, callBackAddVideo, null);
	}
}
function callBackAddVideo(mes) {
	let message = JSON.parse(mes);
	console.log(message.status);
}
function updateVideo() { }
function deleteVideo() { }
function clearContent() { }
