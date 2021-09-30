let x : string | number | boolean,
    y: string | number | boolean,
    r: string | number | boolean
let flag: boolean;

let elemLeft;
let checkButton = document.getElementById("checkButton");

function checkResponse(response:any) {

    if (response.status != 200) {
        alert("Что-то не так, код:" + response.status);
        return "Результат должен быть здесь, но что-то не так";
    }
    return response.text();
}

// @ts-ignore
checkButton.onclick = function () {

    if (validateX() && validateY()) {
        // @ts-ignore
        r = document.querySelector("select[name=R-input]").value;
        fetch("answer.php", {
            method: "POST",
            headers: {"Content-Type": "application/x-www-form-urlencoded; charset=UTF-8"},
            body: "x=" + encodeURIComponent(x) + "&y=" + encodeURIComponent(y) + "&r=" + encodeURIComponent(r)
        }).then(response => checkResponse(response)).then(function (serverAnswer){
            // @ts-ignore
            document.getElementById("outputContainer").innerHTML = serverAnswer;
        }).catch(err => alert(err));
    }
}
function validateX(){

    // @ts-ignore
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

    // @ts-ignore
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
function isNumeric(n:any) {
    return !isNaN(parseFloat(n)) && isFinite(n);
}

runOnKeys(
    () => {
        if(flag) {
            // @ts-ignore
            checkButton.innerHTML = "не-а)))";
            // @ts-ignore
            checkButton.onmousemove = handler;
        } else {
            // @ts-ignore
            checkButton.innerHTML = "Проверить";
            // @ts-ignore
            checkButton.style.transform = "translate(0px, 0px)";
            // @ts-ignore
            checkButton.onmousemove = null;
        }
    },
    "KeyQ",
    "KeyW"
);

function runOnKeys(func:any, ...codes:any) {

    // @ts-ignore
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
    // @ts-ignore
    checkButton.style.transform = "translate(" + elemLeft  + 'px, 0px)'
}
