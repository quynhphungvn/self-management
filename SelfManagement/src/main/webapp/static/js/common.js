var Action = {
	ADD_POST: "ADD_POST",
	UPDATE_POST: "UPDATE_POST",
	DELETE_POST: "DELETE_POST",
	GET_ALL_POST_INFO: "GET_ALL_POST_INFO",
	GET_POST_CONTENT_BY_ID: "GET_POST_CONTENT_BY_ID",
	ADD_NOTE: "ADD_NOTE",
	DELETE_NOTE: "DELETE_NOTE",
	GET_ALL_WORD_KNOWN: "GET_ALL_WORD_KNOWN",
	ADD_WORD_TO_WORD_KNOWN: "ADD_WORD_TO_WORD_KNOWN"
}
var Status = {
	PARAM_INVALID: "PARAM_INVALID",
	GET_SUCCESS: "GET_SUCCESS",
	GET_FAIL: "GET_FAIL",
	ADD_SUCCESS: "ADD_SUCCESS",
	UPDATE_SUCCESS: "UPDATE_SUCCESS",
	DELETE_SUCCESS: "DELETE_SUCCESS",
	RECORD_DUPLICATE: "RECORD_DUPLICATE",
	RECORD_NOT_EXIST: "RECORD_NOT_EXIST",
	ADD_FAIL: "ADD_FAIL",
	UPDATE_FAIL: "UPDATE_FAIL",
	DELETE_FAIL: "DELETE_FAIL"
}

var apiURL = {
	ipaSymbol: {
		getById: {
			url: "/SelfManagement/langlearning/english/api/symbol/",
			method: "GET",
			headers: [{ name: "charset", value: "UTF-8" }]
		}
	},
	videoLearn: {
		getByGroupId: {
			url: "/ss/englearn/api/video-learns/",
			method: "GET",
			headers: [{ name: "charset", value: "UTF-8" }]
		},
		updateVideoById: {
			action: "updatevideo",
			url: "/ss/englearn/api/video-learns/",
			method: "POST",
			headers: [
				{ name: "charset", value: "UTF-8" },
				{ name: "content-type", value: "application/x-www-form-urlencoded" }
			]
		},
		addVideo: {
			action: "addvideo",
			url: "/ss/englearn/api/video-learns/",
			method: "POST",
			headers: [
				{ name: "charset", value: "UTF-8" },
				{ name: "content-type", value: "application/x-www-form-urlencoded" }
			]
		}
	},
	videoLearnGroup: {
		addGroup: {
			url: "/ss/englearn/api/video-learn-groups/",
			method: "POST",
			headers: [
				{ name: "charset", value: "UTF-8" },
				{ name: "content-type", value: "application/x-www-form-urlencoded" }
			]
		}
	},
	word: {
		getAllWordKnown: {
			action: Action.GET_ALL_WORD_KNOWN,
			url: "/ss/englearn/word-known/api/?action=" + Action.GET_ALL_WORD_KNOWN,
			method: "GET",
			headers: [
				{ name: "charset", value: "UTF-8" },
				{ name: "content-type", value: "application/x-www-form-urlencoded" }
			]
		},
		addWordToWordKnown: {
			action: Action.ADD_WORD_TO_WORD_KNOWN,
			url: "/ss/englearn/word-known/api/",
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
	console.time();
	const xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			console.timeEnd();
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