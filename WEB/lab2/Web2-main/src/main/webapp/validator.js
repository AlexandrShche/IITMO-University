document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("button").addEventListener("click", submit);
    const canvas = document.querySelector('canvas')
    canvas.addEventListener('click', function (e) {
        handleCanvasClick(canvas, e)
    })
});

let submit = function (e) {
    let y = document.getElementById("Y_field");
    y.value = y.value.trim().substr(0, 12);
    let x = document.getElementsByName("X_field").checked = true;
    x.value = x.value.trim().substr(0, 12);
    let r = document.getElementsByName("R_field").checked = true;
    r.value = r.value.trim().substr(0, 12);
    if (!check(x.value, y.value, r.value))
        e.preventDefault();
}

function check(x, y, r) {
    let names = new Map()
    names.set(x, "X")
    names.set(y, "Y")
    names.set(r, "R")
    for(let it of names.keys()) {
        let name = names.get(it)
        if (it.trim() === "") {
            displayError(`You must select the ${name}!`);
            return false;
        }
        if (!isFinite(it.replace(',', '.'))) {
            displayError(`${name} must be a number!`);
            return false;
        }
    }
    if (y.replace(',', '.') >= 5 || y.replace(',', '.') <= -3) {
        displayError("Y must be in range (-3; 5)");
        return false;
    }
    if (x.replace(',', '.') > 2 || x.replace(',', '.') < -2) {
        displayError("X must be in range [-2; 2]");
        return false;
    }
    if (r.replace(',', '.') > 5 || r.replace(',', '.') < 1) {
        displayError("R must be in range [1; 5]");
        return false;
    }
    return true
}

function displayError(msg) {
    let err = document.getElementById("err_msg")
    err.innerText = msg
    err.hidden = false
    setTimeout(() => {
        err.hidden = true
    }, 3000)
}