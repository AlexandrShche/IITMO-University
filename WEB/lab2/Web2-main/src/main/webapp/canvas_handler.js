function drawCanvas() {
    let canvas = document.getElementById("canvas");
    let context = canvas.getContext("2d");
    canvas.width = 500;
    canvas.height = 500;

    //фигуры
    context.fillStyle = "#4a50f8"       //цвет заполнения фигур
    context.fillRect(canvas.width * 0.1, canvas.height/2, canvas.width * 0.4, canvas.height * 0.4);
    context.beginPath();
    context.moveTo(canvas.width/2, canvas.height/2);
    context.lineTo(canvas.width - canvas.width * 0.1, canvas.height/2);
    context.lineTo(canvas.width/2, canvas.height*0.3);
    context.fill();
    context.moveTo(canvas.width/2, canvas.height/2);
    context.arc(canvas.width/2, canvas.height/2, 100, 0, Math.PI * -3/2, false);
    context.fill();

    // линии
    context.beginPath();
    context.strokeStyle = "#000000";
    context.lineWidth = 2;
    context.moveTo(0, canvas.height/2);
    context.lineTo(canvas.width, canvas.height/2);
    context.stroke();
    context.beginPath();
    context.strokeStyle = "#000000";
    context.lineWidth = 2;
    context.moveTo(canvas.width/2, canvas.height);
    context.lineTo(canvas.width/2, 0);
    context.stroke();

    context.font='15pt Arial'
    context.fillStyle = "#000000";
    context.fillText("R/2", canvas.width * 0.68, canvas.height/2 - 5);
    context.fillText("-R/2", canvas.width/2 + 5,  canvas.height * 0.7);
    context.fillText("-R/2", canvas.width * 0.3, canvas.height/2 - 5);
    context.fillText("R/2", canvas.width/2 + 5, canvas.height * 0.3);

    context.fillText("R", canvas.width * 0.9, canvas.height/2 - 5);
    context.fillText("R", canvas.width/2 + 5, canvas.height * 0.1);
    context.fillText("-R", canvas.width * 0.1, canvas.height/2 - 5);
    context.fillText("R", canvas.width/2 + 5, canvas.height * 0.9);

    context.fillText("Y", canvas.width/2 + 5, 18);
    context.fillText("X", canvas.width * 0.95, canvas.height/2 - 5);

    // правая стрелочка
    context.beginPath();
    context.lineWidth = 2;
    context.moveTo(canvas.width*0.99, canvas.height * 0.51);
    context.lineTo(canvas.width*0.995, canvas.height/2);
    context.lineTo(canvas.width*0.99, canvas.height * 0.49);
    context.stroke();

    // верхняя стрелочка
    context.beginPath();
    context.lineWidth = 2;
    context.moveTo(canvas.width * 0.51, canvas.height * 0.01);
    context.lineTo(canvas.width/2, canvas.height * 0.005);
    context.lineTo(canvas.width * 0.49, canvas.height * 0.01);
    context.stroke();

    //отмеченные точки на вертикальной прямой
    context.beginPath();
    context.lineWidth = 2;
    context.moveTo(canvas.width/2 * 0.99 , canvas.height * 0.1);
    context.lineTo(canvas.width/2 * 1.01 , canvas.height * 0.1);
    context.moveTo(canvas.width/2 * 0.99 , canvas.height * 0.3);
    context.lineTo(canvas.width/2 * 1.01 , canvas.height * 0.3);
    context.moveTo(canvas.width/2 * 0.99 , canvas.height * 0.7);
    context.lineTo(canvas.width/2 * 1.01 , canvas.height * 0.7);
    context.moveTo(canvas.width/2 * 0.99 , canvas.height * 0.9);
    context.lineTo(canvas.width/2 * 1.01 , canvas.height * 0.9);
    context.stroke();

    //отмеченные точки на горизонтальной прямой
    context.beginPath();
    context.moveTo(canvas.width * 0.1, canvas.height/2 * 0.99);
    context.lineTo(canvas.width * 0.1, canvas.height/2 * 1.01);
    context.moveTo(canvas.width * 0.3, canvas.height/2 * 0.99);
    context.lineTo(canvas.width * 0.3, canvas.height/2 * 1.01);
    context.moveTo(canvas.width * 0.7, canvas.height/2 * 0.99);
    context.lineTo(canvas.width * 0.7, canvas.height/2 * 1.01);
    context.moveTo(canvas.width * 0.9, canvas.height/2 * 0.99);
    context.lineTo(canvas.width * 0.9, canvas.height/2 * 1.01);
    context.stroke();
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