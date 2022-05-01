function filterTagInEditPost() {
	let inputFilterValue = document.getElementById("input-tagfilter-editpost").value;
	let bEditPostTag = document.getElementById("b-editpost-tag");
	let listTag = bEditPostTag.getElementsByClassName("js-tag-editpost");
	if (!inputFilterValue)
		for (let i = 0; i < listTag.length; i++) {
			listTag.item(i).classList.remove("d-none");
		}
	else {
		for (let i = 0; i < listTag.length; i++) {
			let tag = listTag.item(i);
			if (tag.id.includes(inputFilterValue))				
				tag.classList.remove("d-none");
			else
				tag.classList.add("d-none");
		}
	}
}
function addPost() {
	let post = collectPostContent();
	if (post.title == false || post.content == false || post.tags.length == 0)
	{
		alert("Invalid Input");
		return;
	}
	const requestInfo = {
		url: apiURL.blog.addPost.url,
		method: apiURL.blog.addPost.method,
		headers: apiURL.blog.addPost.headers,
		data: "action=" + apiURL.blog.addPost.action
			+ "&title=" + post.title
			+ "&tagId=" + post.tags
			+ "&postContent=" + post.content
	};
	ajaxCall(requestInfo, addPostCallback, null);
}
function collectPostContent() {
	let title = document.getElementById("input-title").value;
	let content = JSON.stringify(quill.getContents());
	content = encodeURIComponent(content);
	let tagEls = document.getElementById("b-editpost-tag").getElementsByTagName("input");
	let tags = [];
	for (let i = 0; i < tagEls.length; i++) {
		if (tagEls.item(i).checked) {
			tags.push(tagEls.item(i).value);
		}
	}
	let post = {
		title: title,
		content: content,
		tags: tags.toString()
	};
	return post;
}
function addPostCallback(messageText) {
	let serverMessage = JSON.parse(messageText);
	if (serverMessage.status == "ADD_SUCCESS"){
		alert(serverMessage.status);
		location.reload();
	}
	else {
		alert(serverMessage.code);
	}
}
function clearEditPostModal() {
	document.getElementById("input-title").value = "";
	quill.setContents("");
	let inputTagEls = document.getElementsByClassName("js-input-editpost");
	for (let i = 0; i < inputTagEls.length; i++) {
		inputTagEls.item(i).checked = false;
	}
}
function addNewTag() {
	
}
function updatePost() {
	let post = collectPostContent();
	if (post.title == false || post.content == false || post.tags.length == 0)
	{
		alert("Invalid Input");
		return;
	}
	const requestInfo = {
		url: apiURL.blog.updatePost.url,
		method: apiURL.blog.updatePost.method,
		headers: apiURL.blog.updatePost.headers,
		data: "action=" + apiURL.blog.updatePost.action
			+ "&id=" + currentPost.postId
			+ "&title=" + post.title
			+ "&tagId=" + post.tags
			+ "&postContent=" + post.content
	};
	ajaxCall(requestInfo, updatePostCallback, null);
}
function updatePostCallback(messageText) {
	let serverMessage = JSON.parse(messageText);
	if (serverMessage.status == "UPDATE_SUCCESS"){
		alert(serverMessage.status);
		location.reload();
	}
	else {
		alert(serverMessage.status);
	}
}
































