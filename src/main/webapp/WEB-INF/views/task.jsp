<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML >
<html lang="uk">
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/style.css" />">

<link rel="shortcut icon" href="<c:url value="/resources/favico.png"/>"
	type="image/x-icon">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="<c:url value="/resources/js/jquery-1.4.3.js"/>"
	type="text/javascript"></script>
<script src="<c:url value="/resources/js/jquery-1.7.2.min.js"/>"></script>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="<c:url value="/resources/js/script.js"/>"
	type="text/javascript"></script>
<title>Brick| Task</title>



</head>

<body id="regbody">


	<div id="headerReg"></div>
	

<p><h3>Назва:</h3> ${currentTask.getName() }</p>
<p><h3>Категорія:</h3>${currentTask.getCategory() }</p>
<p><h3>Роботодавець:<a href="/brick/user/${boss.getId()} "></h3>${boss.getName()} ${boss.getSurname()}</a></p>
<p><h3>Опубліковано:</h3>${currentTask.getPostDate() }</p>
<p><h3>Дата початку виконання:</h3>${currentTask.getStartDate() }</p>
<p><h3>Кінецвий термін виконання:</h3>${currentTask.getEndDate() }</p>
<p><h3>Про завдання:</h3>${currentTask.getAboutText() }</p>

<a href="/brick/home">Головна</a>
<a href="avaible">Усі завдання</a>
<a href="create">Додати завдання</a>il.c
${editTaskButton}
	</div>
	<div id = "result"></div>
	<div id="footer">BrickByBrick©2014. All rights reserved.</div>
	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
	<script src="js/script.js" type="text/javascript"></script>
</body>
<script src="js/script.js" type="text/javascript"></script>

</html>

