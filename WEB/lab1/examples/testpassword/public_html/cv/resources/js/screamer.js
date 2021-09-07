/**
 * Doing screamer on web page.
 */
class Screamer {

    _counter = 0

    /**
     * Create object instance.
     * @param element - trigger for screamer
     * @param picture - scary picture
     * @param audio - scary sound
     * @param maxCount - amount of clicks on the element required to call the screamer
     */
    constructor(element, picture, audio, maxCount) {
        this.element = element
        this.element.onclick = () => {
            this._counter++
            if (this._counter === this.maxCount) this._scream()
        }
        this.picture = picture
        this.audio = audio
        this.maxCount = maxCount
    }

    _scream() {
        const root = document.documentElement
        root.innerHTML = ""
        root.style.backgroundColor = "black"
        root.requestFullscreen().then(r => {
            const canvas = document.createElement("canvas")
            const width = root.clientWidth - 15
            const height = root.clientHeight - 15
            canvas.width = width
            canvas.height = height
            canvas.getContext("2d").drawImage(this.picture, 0, 0, width, height)
            this.audio.play()
            root.appendChild(canvas)
        })
    }
}

(function() {
    "use strict"

    const trigger = document.getElementById("name")
    const pic = new Image()
    const sound = new Audio("resources/audio/nmh_scream.wav")
    pic.src = "resources/images/scary-face.jpg"
    new Screamer(trigger, pic, sound, 4)
})()