(function($) {
    "use strict"

    $('a.js-scroll-trigger[href*="#"]:not([href="#"])').click(() => {
        if (location.pathname.replace(/^\//, "") === this.pathname.replace(/^\//, "") &&
            location.hostname === this.hostname) {
            let target = $(this.hash)
            target = target.length ? target : $("[name=${this.hash.slice(1)}]")
            if (target.length) {
                $('html, body').animate({ scrollTop: (target.offset().top - 48) }, 1000, "easeInOutExpo")
                return false
            }
        }
    })
    $(".js-scroll-trigger").click(() => $(".navbar-collapse").collapse("hide"))
    $("body").scrollspy({ target: "#mainNav", offset: 54 })
    const selector = "#mainNav"
    const navBarCollapse = function() {
        if ($(selector).offset().top > 100) $(selector).addClass("navbar-shrink")
        else $(selector).removeClass("navbar-shrink")
    }
    navBarCollapse()
    $(window).scroll(navBarCollapse)
})(jQuery)