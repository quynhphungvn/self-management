function showTabContent(evt, tabContentId) {
	let tabcontents, tablinks;
	let tabEl = evt.target;
	while (!tabEl.classList.contains("tab")) {
		tabEl = tabEl.parentNode;
	}
	// Get all elements with class="tabcontent" and hide them
	tabcontents = tabEl.getElementsByClassName("tab-content");
	for (let i = 0; i < tabcontents.length; i++) {
		tabcontents[i].style.display = "none";
	}

	// Get all elements with class="tablinks" and remove the class "active"
	tablinks = tabEl.getElementsByClassName("tab-links");
	for (let i = 0; i < tablinks.length; i++) {
		tablinks[i].className = tablinks[i].className.replace(" active", "");
	}

	// Show the current tab, and add an "active" class to the button that opened the tab
	document.getElementById(tabContentId).style.display = "block";
	evt.currentTarget.className += " active";
}