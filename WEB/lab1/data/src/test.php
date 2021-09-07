<?php

echo 'и че?';

var_dump($_POST);

echo ' что тут?  ';

var_dump($_GET);

?>

<html lang="en">

<head>
    <title>PHP</title>
</head>

<body>
<div>
    <table>
        <tr>
            <td>
                <b>X</b>
            </td>
            <td>
                <b>Y</b>
            </td>
            <td>
                <b>R</b>
            </td>
            <td>
                <b>Result</b>
            </td>
            <td>
                <b>Current time</b>
            </td>
            <td>
                <b>Benchmark</b>
            </td>
        </tr>

        <?php
        echo "$TABLE";
        ?>
    </table>

    <form method="POST" action="" class = "left-form">
        <input type="submit" name="submit-button" value = "Reset">
    </form>

    <form method="GET" action="index.html" class = "right-form">
        <input type="submit" name="submit-button" value = "Back">
    </form>
</div>
</body>

</html>

<style>
    body {
        margin: auto;
        background: #FFFFFF;
    }

    table {
        margin: 100px auto auto;
    }

    form {
        text-align: center;
        margin: 20px;
    }

    .left-form {
        float: left;
        margin-left: 40vw;
    }

    .right-form {
        float: right;
        margin-right: 40vw;
    }

    input{
        font-size: 18px;
        padding: 15px;
        margin-top: 25px;
        background: #1946BA;
        color: #FFFFFF;
        border-radius: 4px;
        margin-bottom: 50px;
        transition: 0.3s ease-in;
    }

    table,
    tr,
    td {
        text-align: center;
        border: 2px solid #00008B;
        border-collapse: collapse;
    }
</style>