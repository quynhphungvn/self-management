function showLeftMenu() {
    let menu = document.getElementById("left-menu");
    menu.style.left = "0";
}
function closeLeftMenu() {
    let menu = document.getElementById("left-menu");
    menu.style.left = "-300px";
}
function showBonusInfo(evt, tabName) {
    let bonusInfoEl = document.getElementById("bonus-info");
    var i, tabcontent, tablinks;

  // Get all elements with class="tabcontent" and hide them
  tabcontent = bonusInfoEl.getElementsByClassName("tab-content");
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  }

  // Get all elements with class="tablinks" and remove the class "active"
  tablinks = bonusInfoEl.getElementsByClassName("tab-links");
  for (i = 0; i < tablinks.length; i++) {
    tablinks[i].className = tablinks[i].className.replace(" active", "");
  }

  // Show the current tab, and add an "active" class to the button that opened the tab
  document.getElementById(tabName).style.display = "block";
  evt.currentTarget.className += " active";
}