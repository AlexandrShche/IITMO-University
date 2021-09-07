

function checkResponse(response:): string {
    if (response.status != 200) {
        alert("Что-то не так");
        return "Результат должен быть здесь, но что-то не так";
    }
    return response.text();
}

document.getElementById("checkButton").onclick = function () {
    if (validateX() && validateY()) {
        r = document.querySelector("select[name=R-input]").value;
        fetch("answer.php", {
            method: "POST",
            headers: {"Content-Type": "application/x-www-form-urlencoded; charset=UTF-8"},
            body: "x=" + encodeURIComponent(x) + "&y=" + encodeURIComponent(y) + "&r=" + encodeURIComponent(r)
        }).then(response => checkResponse(response)).then(function (serverAnswer){
            document.getElementById("outputContainer").innerHTML = serverAnswer;
        }).catch(err => alert(err));
    }
} 

function validateX(): boolean{
    x = document.querySelector("input[name=X-input]");
    if(x === undefined){
        alert("х не введён");
        return false;
    } else if (!isNumeric(x)){
        alert("x не число");
        return false;
    } else if((x > 5) || (x < -3)){
        alert("x не подходит");
        return false;
    } 
    return true;
}

function validateY(): boolean{
    y = document.querySelector("input[name=Y-input]").value.replace(",", ".");
    if(y === undefined){
        alert("y не введён");
        return false;
    } else if (!isNumeric(x)){
        alert("y не число");
        return false;
    } else if((y > 5) || (y < -3)){
        alert("y не подходит");
        return false;
    } 
    return true;
}

function isNumeric(n): boolean {
    return !isNaN(parseFloat(n)) && isFinite(n);
}

