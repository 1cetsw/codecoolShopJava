main();



function main() {
    window.addEventListener("scroll", () => checkTop());
}

function checkTop() {
    let scroller = window.pageYOffset;
    let navbar = document.getElementsByClassName("jumbotron text-center")[0];
    navbar.style.transition = "0.5s";
    navbar.style.transitionTimingFunction = "cubic-bezier(0.18, 0.89, 0.32, 1.28)";
    if (scroller === 0) {
        navbar.style.padding = "4rem 2rem";
    } else {
        navbar.style.padding = "1rem .5rem";
    }
}