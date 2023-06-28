<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Greetings</title>
    <link rel="stylesheet" href="static/css/style.css">
    <link rel="stylesheet" href="static/css/styleForIndex.css">
</head>
<body>

<h1 class="animate-character">Пролог</h1>

<h2 class="animate-character">Вы просыпаетесь в незнакомом для вас месте. Встаёте и идёте по тропинке.
    Вы наталкиваетесь на НЛО, что же вы будете делать???</h2>


<div class="form__group">
    <form action="/logic" method="post">
        <input type="input" class="type-1" name="name" id="name" placeholder="Впишите своё имя:" required/>
    </form>
</div>


</body>
</html>