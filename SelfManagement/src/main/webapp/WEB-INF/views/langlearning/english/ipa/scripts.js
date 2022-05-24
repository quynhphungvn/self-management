function showLeftMenu() {
    let menu = document.getElementById("left-menu");
    menu.style.left = "0";
}
function closeLeftMenu() {
    let menu = document.getElementById("left-menu");
    menu.style.left = "-300px";
}
function showSymbolGuide(evt, tabContentId) {
    let tabLinks = document.getElementsByClassName("tab-links");
    for (let i = 0; i < tabLinks.length; i++) 
        tabLinks.item(i).className = tabLinks.item(i).className.replace("active", "");
    let tabContents = document.getElementsByClassName("tab-content");
    for (let i = 0; i < tabContents.length; i++) 
        tabContents.item(i).style.display = "none";
    document.getElementById(tabContentId).style.display = "block";
    evt.currentTarget.className += " active";
}