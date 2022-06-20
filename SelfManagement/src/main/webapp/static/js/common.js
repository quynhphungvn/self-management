var Action = {
	GET: "GET",
	GETS: "GETS",
	ADD: "ADD",
	ADDS: "ADDS",
	DELETE: "DELETE",
	DELETES: "DELETES",
	UPDATE: "UPDATE",
	UPDATES: "UPDATES",
	ADD_VIDEO_GROUP: "ADD_VIDEO_GROUP",
	DELETE_VIDEO_GROUP: "DELETE_VIDEO_GROUP",
	GET_VIDEOS_BY_GROUP_ID: "GET_VIDEOS_BY_GROUP_ID",
	ADD_VIDEO: "ADD_VIDEO",
	GET_VIDEO_BY_ID: "GET_VIDEO_INFO_BY_ID",
	UPDATE_VIDEO: "UPDATE_VIDEO",
	DELETE_VIDEO: "DELETE_VIDEO",
	GET_WORDKNOWNS: "GET_WORDKNOWNS",
	ADD_WORD_TO_WORD_KNOWN: "ADD_WORD_TO_WORD_KNOWN",
	UPDATE_VIDEO_VIEW_COUNT: "UPDATE_VIDEO_VIEW_COUNT"
}
var MessageStatus = {
	SUCCESS: "SUCCESS",
	FAIL: "FAIL",
}
var ErrorStatus = {
	PARAM_INVALID: "PARAM_INVALID",
	RECORD_DUPLICATE: "RECORD_DUPLICATE",
	RECORD_NOT_EXIST: "RECORD_NOT_EXIST",
}
var apiURL = {
	symbol: {
		getById: {
			url: "/SelfManagement/langlearning/english/symbol/api/",
			method: "GET",
			headers: [{ name: "charset", value: "UTF-8" }]
		}
	},
	video: {
		getVideosByGroupId: {
			url: "/SelfManagement/langlearning/english/video/api/",
			method: "GET",
			headers: [{ name: "charset", value: "UTF-8" }]
		},
		getVideoById: {
			url: "/SelfManagement/langlearning/english/video/api/",
			method: "GET",
			headers: [{ name: "charset", value: "UTF-8" }]
		},
		update: {
			url: "/SelfManagement/langlearning/english/video/api/",
			method: "POST",
			headers: [
				{ name: "charset", value: "UTF-8" },
				{ name: "content-type", value: "application/x-www-form-urlencoded" }
			]
		},
		add: {
			url: "/SelfManagement/langlearning/english/video/api/",
			method: "POST",
			headers: [
				{ name: "charset", value: "UTF-8" },
				{ name: "content-type", value: "application/x-www-form-urlencoded" }
			]
		},
		delete: {
			url: "/SelfManagement/langlearning/english/video/api/",
			method: "POST",
			headers: [
				{ name: "charset", value: "UTF-8" },
				{ name: "content-type", value: "application/x-www-form-urlencoded" }
			]
		},
		updateViewCount: {
			url: "/SelfManagement/langlearning/english/video/api/",
			method: "POST",
			headers: [
				{ name: "charset", value: "UTF-8" },
				{ name: "content-type", value: "application/x-www-form-urlencoded" }
			]
		}
	},
	videoGroup: {
		addGroup: {
			url: "/SelfManagement/langlearning/english/video-group/api/",
			method: "POST",
			headers: [
				{ name: "charset", value: "UTF-8" },
				{ name: "content-type", value: "application/x-www-form-urlencoded" }
			]
		},
		deleteGroup: {
			url: "/SelfManagement/langlearning/english/video-group/api/",
			method: "POST",
			headers: [
				{ name: "charset", value: "UTF-8" },
				{ name: "content-type", value: "application/x-www-form-urlencoded" }
			]
		}
	},
	word: {
		getWordKnowns: {
			url: "/SelfManagement/langlearning/english/word/api/",
			method: "GET",
			headers: [
				{ name: "charset", value: "UTF-8" },
				{ name: "content-type", value: "application/x-www-form-urlencoded" }
			]
		},
		addWordToWordKnown: {
			action: Action.ADD_WORD_TO_WORD_KNOWN,
			url: "/SelfManagement/langlearning/english/word/api/",
			method: "POST",
			headers: [
				{ name: "charset", value: "UTF-8" },
				{ name: "content-type", value: "application/x-www-form-urlencoded" }
			]
		}
	},
	note: {
		addNote: {
			action: Action.ADD_NOTE,
			url: "/ss/note/api/",
			method: "POST",
			headers: [
				{ name: "charset", value: "UTF-8" },
				{ name: "content-type", value: "application/x-www-form-urlencoded" }
			]
		},
		deleteNote: {
			action: Action.DELETE_NOTE,
			url: "/ss/note/api/",
			method: "POST",
			headers: [
				{ name: "charset", value: "UTF-8" },
				{ name: "content-type", value: "application/x-www-form-urlencoded" }
			]
		}
	},
	blog: {
		getPostContentById: {
			action: Action.GET_POST_CONTENT_BY_ID,
			url: "/ss/blog/api/",
			method: "GET",
			headers: []
		},
		addPost: {
			action: Action.ADD_POST,
			url: "/ss/blog/api/",
			method: "POST",
			headers: [
				{ name: "charset", value: "UTF-8" },
				{ name: "content-type", value: "application/x-www-form-urlencoded" }
			]
		},
		updatePost: {
			action: Action.UPDATE_POST,
			url: "/ss/blog/api/",
			method: "POST",
			headers: [
				{ name: "charset", value: "UTF-8" },
				{ name: "content-type", value: "application/x-www-form-urlencoded" }
			]
		},
		getAllPostInfo: {
			action: Action.GET_ALL_POST_INFO,
			url: "/ss/blog/api/",
			method: "GET",
			headers: []
		}
	}
}
function removeUnexpectChar(word) {
	let result = word
		.replace(/\./g, "")
		.replace(/\-/g, "")
		.replace(",", "")
		.replace("\'\!", "")
		.replace(/\!/g, "")
		.replace(/\~/g, "")
		.replace("\'\?", "")
		.replace("?", "")
		.replace(":", "")
		.replace(";", "")
		.replace(/\"/g, "")
		.replace("(", "")
		.replace(")", "")
		.replace("[", "")
		.replace("]", "")
		.replace("'ll", "")
		.replace("'d", "")
		.replace("'ve", "")
		.replace("'re", "")
		.replace("'m", "")
		.replace("'s", "")
		.trim()
		.toLowerCase();
	return result;
}
function ajaxCall(requestInfo, callback, callbackParam) {
	const xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			if (callbackParam == null)
				callback(this.responseText);
			else
				callback(this.responseText, callbackParam);
		}
	};
	xhttp.open(requestInfo.method, requestInfo.url);
	for (let i = 0; i < requestInfo.headers.length; i++)
		xhttp.setRequestHeader(requestInfo.headers[i].name, requestInfo.headers[i].value);
	if (requestInfo.data)
		xhttp.send(requestInfo.data);
	else xhttp.send();
}
function clearActiveClass(el) {
	let children = el.children;
	for (let i = 0; i < children.length; i++) {
		children[i].className = children[i].className.replace("active", "");
	}
}
function setActiveClass(el) {
	let parent = el.parentElement;
	clearActiveClass(parent);
	el.className = el.className + " active";
}