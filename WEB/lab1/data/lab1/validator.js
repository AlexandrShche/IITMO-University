"use strict";

let x, y, r;
let flag;

let elemLeft;
let checkButton = document.getElementById("checkButton");

function checkResponse(response) {

    if (response.status != 200) {
        alert("Что-то не так, код:" + response.status);
        return "Результат должен быть здесь, но что-то не так";
    }
    return response.text();
}

checkButton.onclick = function () {
    if (validateX() && validateY()) {
        r = document.querySelector("select[name=R-input]").value;
        fetch("answer.php", {
            method: "POST",
            // headers: {"Content-Type": "application/x-www-form-urlencoded; charset=UTF-8"},
            body: "x=" + encodeURIComponent(x) + "&y=" + encodeURIComponent(y) + "&r=" + encodeURIComponent(r)
        }).then(response => checkResponse(response)).then(function (serverAnswer){
            document.getElementById("outputContainer").innerHTML = serverAnswer;
        }).catch(err => alert(err));
    }
}
function validateX(){
    x = document.querySelector("input[name=X-input]").value.replace(",", ".");
    if(x === undefined){
        alert("х не введён");
        return false;
    } else if (!isNumeric(x)){
        alert("x не число");
        return false;
    } else if((x >= 5) || (x <= -3)){
        alert("x не подходит");
        return false;
    }
    return true;
}
function validateY(){
    y = document.querySelector("input[name=Y-input]").value.replace(",", ".");
    if(y === undefined){
        alert("y не введён");
        return false;
    } else if (!isNumeric(y)){
        alert("y не число");
        return false;
    } else if((y >= 5) || (y <= -3)){
        alert("y не подходит");
        return false;
    }
    return true;
}

function isNumeric(n) {
    return !isNaN(parseFloat(n)) && isFinite(n);
}

runOnKeys(
    () => {
        if(flag) {
            checkButton.innerHTML = "не-а)))";
            checkButton.onmousemove = handler;
        } else {
            checkButton.innerHTML = "Проверить";
            checkButton.style.transform = "translate(0px, 0px)";
            checkButton.onmousemove = null;
        }
    },
    "KeyQ",
    "KeyW"
);

function runOnKeys(func, ...codes) {

    let pressed = new Set();
    document.addEventListener('keydown', function(event) {
        pressed.add(event.code);
        for (let code of codes) {
            if (!pressed.has(code)) {
                return;
            }
        }
        flag = !flag;
        pressed.clear();
        func();
    });

    document.addEventListener('keyup', function(event) {
        pressed.delete(event.code);
    });
}

function handler() {
    elemLeft = Math.random() * 500 - 250;
    checkButton.style.transform = "translate(" + elemLeft  + 'px, 0px)'
}
