function drawCanvas() {
    let canvas = document.getElementById("canvas");
    let context = canvas.getContext("2d");
    canvas.width = 500;
    canvas.height = 500;
    context.fillStyle = "#4a50f8"       //цвет заполнения фигур

    context.fillRect(50, 250, 200, 200);
    context.beginPath();
    context.moveTo(250, 250);
    context.lineTo(450, 250);
    context.lineTo(250, 150);
    context.fill();
    context.moveTo(250, 250);
    context.arc(250, 250, 100, 0, Math.PI * -3/2, false);
    context.fill();

    context.beginPath();
    context.strokeStyle = "#000000";
    context.lineWidth = 2;
    context.moveTo(0, 250);
    context.lineTo(500, 250);
    context.stroke();
    context.beginPath();
    context.strokeStyle = "#000000";
    context.lineWidth = 2;
    context.moveTo(250, 500);
    context.lineTo(250, 0);
    context.stroke();

    context.font='15pt Arial'
    context.fillStyle = "#000000";
    context.fillText("R/2", 340, 245);
    context.fillText("-R/2", 255, 350);
    context.fillText("-R/2", 150, 245);
    context.fillText("R/2", 255, 150);

    context.fillText("R", 445, 245);
    context.fillText("R", 255, 50);
    context.fillText("-R", 50, 245);
    context.fillText("R", 255, 450);

    context.fillText("Y", 255, 18);
    context.fillText("X", 485, 245);

    context.fillText("-", 246.5, 55);
    context.fillText("-", 246.5, 155);
    context.fillText("-", 246.5, 355);
    context.fillText("-", 246.5, 455);

    context.font='10pt Arial'
    context.fillText("l", 49, 255);
    context.fillText("l", 150, 255);
    context.fillText("l", 349, 255);
    context.fillText("l", 448, 255);
    drawPoints();
}

function drawPoints() {
    let Xs = Array.from(document.getElementsByClassName("the_X")).map(v => v.innerHTML);
    let Ys = Array.from(document.getElementsByClassName("the_Y")).map(v => v.innerHTML);
    let Rs = Array.from(document.getElementsByClassName("the_R")).map(v => v.innerHTML);
    let Results = Array.from(document.getElementsByClassName("the_Result")).map(v => v.innerHTML);
    for (let i = 0; i < Xs.length; i++) {
        drawRawPoint(Xs[i], Ys[i], Rs[i], Results[i])
    }
}

function drawPoint(x, y, result) {
    let canvas = document.getElementById("canvas"),
        context = canvas.getContext("2d");
    context.strokeStyle = "#ffffff";
    if (result.toString().trim() === 'false') {
        context.fillStyle = "#FF2A1F";
    } else {
        context.fillStyle = "#5FFF33";
    }
    context.beginPath();
    context.arc(x, y, 5, 0, 2 * Math.PI);
    context.fill();
    context.stroke();
    context.closePath();
}

function drawRawPoint(x, y, r, res) {
    drawPoint(x / r * 400 / 2 + 250, y / r * (-400) / 2 + 250, res);
}

function handleCanvasClick(canvas, event) {
    const rect = canvas.getBoundingClientRect()
    const clickX = event.clientX - rect.left
    const clickY = event.clientY - rect.top

    let radios = document.querySelectorAll('input[name="R_field"]')
    let Rs;
    for (let radio of radios) {
        console.log("radios length = " + radios.length)
        console.log("radio = " + radio.value);
        if (radio.checked) {
            Rs = radio.value;
            console.log("присвоили Rs" + radio.value);
        }
    }
    if(Rs === undefined){
        alert("Вы не выбрали R");
    }
    console.log("r =" + Rs);

    console.log("click x = " + clickX.toString());
    console.log("click y = " + clickY.toString());
    let Xs = (clickX - 250) * Rs/ 200
    console.log("x = " + Xs);
    let Ys = (-1) * (clickY - 250) * Rs/ 200
    console.log("y=" + Ys);

        if (check(Xs.toString(), Ys.toString(), Rs.toString()))
            $.ajax({
                url: 'controllerServlet',
                type: 'GET',
                dataType: "json",
                data: {
                    'X_field': Xs.toString(),
                    'Y_field': Ys.toString(),
                    'R_field': Rs.toString(),
                    'Canvas_clicked': true
                }
            })
                .then(response => {
                    console.log(response)
                    let res = response['result']
                    let x = response['x']
                    let y = response['y']
                    let r = response['r']
                    let time = response['clock']['dateString']
                    drawRawPoint(x, y, r, res)
                    addToTable(x, y, r, res, time)
                })
                .catch(() => {
                    alert("Your params didn't pass the validation.\nPlease, check that X is in [-2; 2], Y is in (-3, 5)")
                });
    }


function addToTable(x, y, r, res, time) {
    let row =
        '<tr><th class=\'the_X\'>' + x +
        '</th><th class=\'the_Y\'>' + y +
        '</th><th class=\'the_R\'>' + r +
        '</th><th class=\'the_Result\' style=\'color:' + (res ? "lime" : "red") + '\'>' + res +
        '</th><th>' + time + '</th></tr>'
    $('.result_table tbody').prepend(row)
}