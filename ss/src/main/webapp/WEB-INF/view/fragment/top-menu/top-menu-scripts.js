function showAddNotePanel() {
	let btnAddNote = document.getElementById("btn-add-note");
	let btnManageNote = document.getElementById("btn-manage-note");
	let addBlock = document.getElementById("b-add-note");
	let manageBlock = document.getElementById("b-manage-note");
	addBlock.classList.remove("d-none");
	manageBlock.classList.add("d-none");
	btnAddNote.classList.add("active");
	btnManageNote.classList.remove("active");
}
function showManageNotePanel() {
	let btnAddNote = document.getElementById("btn-add-note");
	let btnManageNote = document.getElementById("btn-manage-note");
	let addBlock = document.getElementById("b-add-note");
	let manageBlock = document.getElementById("b-manage-note");
	addBlock.classList.add("d-none");
	manageBlock.classList.remove("d-none");
	btnAddNote.classList.remove("active");
	btnManageNote.classList.add("active");
}
function addNote() {
	let priorityId = document.getElementById("note-select-priority").value;
	let noteTypeId = document.getElementById("note-select-notetype").value;
	let noteContent = document.getElementById("note-add-content").value;
	if (!noteContent) {
		alert("Empty Content");
		return;
	}
	let noteComment = document.getElementById("note-add-comment").value;
	const requestInfo = {
			url: apiURL.note.addNote.url,
			method: apiURL.note.addNote.method,
			headers: apiURL.note.addNote.headers,
			data: "action=" + apiURL.note.addNote.action
				+"&priorityId=" + priorityId 
				+"&noteTypeId=" + noteTypeId
				+"&noteContent=" + noteContent 
				+"&noteComment=" + noteComment
	};
	ajaxCall(requestInfo, addNoteCallback, null);
}
function addNoteCallback(messageText) {
	console.log(messageText);
	let message = JSON.parse(messageText);
	alert(message.status);
	location.reload();
}
function deleteNote(id) {
	const requestInfo = {
			url: apiURL.note.deleteNote.url,
			method: apiURL.note.deleteNote.method,
			headers: apiURL.note.deleteNote.headers,
			data: "action=" + apiURL.note.deleteNote.action
				+"&id=" + id
	};
	ajaxCall(requestInfo, deleteNoteCallback, null);
}
function deleteNoteCallback(messageText) {
	let message = JSON.parse(messageText);
	alert(message.status);
	location.reload();
}