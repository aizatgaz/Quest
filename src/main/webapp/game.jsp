<%--
  Created by IntelliJ IDEA.
  User: yande
  Date: 25.06.2023
  Time: 18:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Game</title>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <link rel="stylesheet" href="static/css/style.css">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>

<c:set var="win" value="win"/>
<c:set var="lose" value="lose"/>

<%--Это вопрос, который задаётся пользователю--%>
<div class="animate-character">
    ${bigQuestion}
</div>
<div class="animate-character">
    ${question}
</div>

<br>

<div class="container">
    <%--Тут я использую переменную, чтобы при победе или проигрыше, кнопки не высвечивались.
        К кнопкам input type... , я не нашёл как применить к ним css --%>
        <c:if test="${buttonOne != win && buttonOne != lose}">
        <%--        <input type="button" onclick="window.location='logic?button=${buttonOne}'" value="${buttonOne}">--%>
        <a href="#" class="btn" onclick="window.location='logic?button=${buttonOne}'">${buttonOne}</a>
        <%--        <input type="button" onclick="window.location='logic?button=${buttonTwo}'" value="${buttonTwo}">--%>
        <a href="#" class="btn" onclick="window.location='logic?button=${buttonTwo}'">${buttonTwo}</a>
    </c:if>
</div>

<br>

<%--RESTART--%>
<a href="restart" class="btn" id="bottomRight">Начать заново</a>

<div id="bottomLeft">
    Статистика:<br>
    IP address: ${ipAddress}<br>
    Имя пользователя: ${name}<br>
    Количество игр: ${gameCounter}<br>
</div>
</body>
</html>
