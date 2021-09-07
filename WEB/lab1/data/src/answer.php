<?php

@session_start();
if (!isset($_SESSION["tableRows"])) $_SESSION["tableRows"] = array();
$x = (float) $_POST["x"];
$y = (float) $_POST["y"];
$r = (float) $_POST["r"];

if(checkData($x, $y, $r)){
    $coordsStatus = checkCoordinates($x, $y, $r);
    $currentTime = date("H : i : s");
    $benchmarkTime = microtime(true) - $_SERVER["REQUEST_TIME_FLOAT"];
    array_push($_SESSION["tableRows"], "<tr>
    <td>$x</td>
    <td>$y</td>
    <td>$r</td>
    <td>$coordsStatus</td>
    <td>$currentTime</td>
    <td>$benchmarkTime</td>
    </tr>");
    echo "<table id='outputTable'>
        <tr>
            <th>x</th>
            <th>y</th>
            <th>r</th>
            <th>Точка входит в ОДЗ</th>
            <th>Текущее время</th>
            <th>Время работы скрипта</th>
        </tr>";
    foreach ($_SESSION["tableRows"] as $tableRow) echo $tableRow;
    echo "</table>";
}

function checkData($x, $y, $r) {
    return is_numeric($x) && ($x > -3 && $y < 5) &&
        is_numeric($y) && ($y > -3 && $y < 5) &&
        in_array($r, array( 1, 2, 3, 4, 5));
    }

function checkCoordinates($x, $y, $r) {
    if ((($x >= 0) && ($y <= 0) && ($x <= $r)  && ($y >= -$r)) ||
        (($x >= 0) && ($y >= 0) && ($x**2 + $y**2) <= (($r**2)/2)) ||
        (($x <= 0) && ($y <= 0) && ($x + $y*2 >= r))) return "да";
    else {
        return "нет";
    }
}
