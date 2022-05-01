var currentPost = null;
function filterTagInPostList() {
	let inputFilterValue = document.getElementById("input-tagfilter").value;
	let bListPostEl = document.getElementById("b-list-post");
	let listTagPost = bListPostEl.getElementsByClassName("js-tag-postlist");
	console.log(inputFilterValue);
	if (!inputFilterValue)
		for (let i = 0; i < listTagPost.length; i++) {
			listTagPost.item(i).classList.remove("d-none");
		}
	else {
		for (let i = 0; i < listTagPost.length; i++) {
			let tagpostEl = listTagPost.item(i);
			if (tagpostEl.id.includes(inputFilterValue))
				tagpostEl.classList.remove("d-none");
			else
				tagpostEl.classList.add("d-none");
		}
	}
}
function getPostContentById(id) {
	const requestInfo = {
		url: apiURL.blog.getPostContentById.url
			+ "?action=" + apiURL.blog.getPostContentById.action
			+ "&id=" + id,
		method: apiURL.blog.getPostContentById.method,
		headers: apiURL.blog.getPostContentById.headers,
		data: null
	};
	ajaxCall(requestInfo, getPostContentByIdCallback, null);
}
function getPostContentByIdCallback(messageText) {
	console.log(messageText);
	let response = JSON.parse(messageText);
	let quillPostView = new Quill('#c-post', {
		modules: {
			syntax: false
		},
		theme: 'bubble'
	});
	if (response.status == Status.GET_FAIL)
		alert(Status.GET_FAIL);
	else {
		let post = response.data;
		currentPost = post;
		document.getElementById("c-post-title").innerText = post.postTitle;
		quillPostView.setContents(JSON.parse(post.postContent));
		quillPostView.disable();
		setEditPostPanel(post, quill);
	}	
}
function setEditPostPanel(post, quill) {
	let inputTagEls = document.getElementsByClassName("js-input-editpost");
	document.getElementById("input-title").value = post.postTitle;
	quill.setContents(JSON.parse(post.postContent));
	let tags = post.listTag;
	for (let i = 0; i < inputTagEls.length; i++) {
		inputTagEls.item(i).checked = false;
		for(let j = 0; j < tags.length; j++) {
			if (inputTagEls.item(i).value == tags[j].tagId)	{
				inputTagEls.item(i).checked = true;
				break;
			}
		}
		
	}
}