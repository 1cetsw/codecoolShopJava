
init()

function init(){
    document.getElementById("sidenavTrigger").addEventListener("mouseenter", openNav);
}

async function openNav() {
    document.getElementById("sideNavMenu").style.width = "270px";
    let sideNavLinks = document.getElementsByClassName("sidenav-a");
    //await sleep(200)
    for (const sideNavLink of sideNavLinks) {
        /*
        sideNavLink.style.transition = "0.5s";
        sideNavLink.style.transitionTimingFunction = "cubic-bezier(0.18, 0.89, 0.32, 1.28)";
        */
        sideNavLink.style.whiteSpace = "break-spaces";
    }
}

function closeNav() {
    document.getElementById("sideNavMenu").style.width = "0";
    let sideNavLinks = document.getElementsByClassName("sidenav-a");
    for (const sideNavLink of sideNavLinks) {
        sideNavLink.style.whiteSpace = "nowrap";
    }
}

function sleep(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
}