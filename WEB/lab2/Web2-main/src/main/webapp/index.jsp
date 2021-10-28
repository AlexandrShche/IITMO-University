<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <meta content="Web programming second lab" name="description">
    <title>Web programming - lab 2</title>
    <link rel="stylesheet" href="style.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>

<body onload="drawCanvas()">

<script src="canvas_handler.js"></script>
<script src="validator.js"></script>

<header>
    <header>
        <h1> Веб-программирование, Лабораторная работа №2. Вариант № 10386  </h1>
        <h2>Щербаков Александр Р3210</h2>
    </header>
</header>

<br>
<br>
<br>

<table class="page_table">
    <tr>
        <td>
            <canvas id="canvas"></canvas>
        </td>
    </tr>
    <tr>
        <td>
            <p hidden id="err_msg">Something went wrong!</p>
        </td>
    </tr>

    <tr>
        <td>
            <p id="enter-text">Enter values:</p>
        </td>
    </tr>
    <tr>
        <td>
            <div class="vars_table">
                <form id="form" method="get" action="controllerServlet">
                    <p>X=
                        <input type="radio" id="x-3" name="X_field" value="-3">
                        <label for="x-3">-3</label>

                        <input type="radio" id="x-2" name="X_field" value="-2">
                        <label for="x-2">-2</label>

                        <input type="radio" id="x-1" name="X_field" value="-1">
                        <label for="x-1">-1</label>

                        <input type="radio" id="x0" name="X_field" value="0">
                        <label for="x0">0</label>

                        <input type="radio" id="x1" name="X_field" value="1">
                        <label for="x1">1</label>

                        <input type="radio" id="x2" name="X_field" value="2">
                        <label for="x2">2</label>

                        <input type="radio" id="x3" name="X_field" value="3">
                        <label for="x3">3</label>

                        <input type="radio" id="x4" name="X_field" value="4">
                        <label for="x4">4</label>

                        <input type="radio" id="x5" name="X_field" value="5">
                        <label for="x5">5</label>

                    </p>
                    <p class="variable">Y=
                        <label for="Y_field"></label>
                        <input id="Y_field" type="text" name="Y_field" placeholder="Enter y:">
                    </p>

                    <p>R=</p>
                    <input type="radio" id="r1" name="R_field" value="1">
                    <label for="r1">1</label>
                    <input type="radio" id="r2" name="R_field" value="2">
                    <label for="r2">2</label>

                    <input type="radio" id="r3" name="R_field" value="3">
                    <label for="r3">3</label>

                    <input type="radio" id="r4" name="R_field" value="4">
                    <label for="r4">4</label>

                    <input type="radio" id="r5" name="R_field" value="5">
                    <label for="r5">5</label>
                    <p>
                        <button id="button" type="submit"></button>
                    </p>
                </form>
            </div>
        </td>
    </tr>
    <tr>
        <td>
            <jsp:include page="all_table.jsp"/>
        </td>
    </tr>
</table>

</body>
</html>
