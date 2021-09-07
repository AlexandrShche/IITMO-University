(function() {
    "use strict"

    const canvas = document.getElementById("profile-pic")
    const image = new Image()
    image.src = "resources/images/profile.png"
    image.onload = () => resetImage(canvas, image)
    canvas.onmouseover = () => {
        chromaticAberration(canvas, between(0, 10), between(0, 2))
        setTimeout(() => chromaticAberration(canvas, between(0, 10), between(0, 2)),600);
        setTimeout(() => chromaticAberration(canvas, between(0, 10), between(0, 2)),1200);
    }
    canvas.onmouseout = () => resetImage(canvas, image)

    /**
     * Reset image from canvas to default.
     * @param canvas - field for image
     * @param image
     */
    function resetImage(canvas, image) { canvas.getContext("2d").drawImage(image, 0, 0, canvas.width, canvas.height) }

    /**
     * Applies the effect of chromatic aberration of the lens to canvas.
     * @param canvas - field for image
     * @param intensity - power of effect (bias)
     * @param phase - phase of effect (colors)
     */
    function chromaticAberration(canvas, intensity, phase) {
        const ctx = canvas.getContext("2d")
        const imageData = ctx.getImageData(0, 0, canvas.width, canvas.height)
        const data = imageData.data
        for (let i = phase % 4; i < data.length; i += 4) data[i] = data[i + 4 * intensity]
        ctx.putImageData(imageData, 0, 0)
    }

    /**
     * Returns a random number between
     * @param min (inclusive) and
     * @param max (inclusive)
     * @returns {number} - result of generation.
     */
    function between(min, max) { return Math.floor(Math.random() * (max - min + 1) + min) }
})()