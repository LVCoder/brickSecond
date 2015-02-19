<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML >
<html lang="uk">
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/stylehome.css" />">

<link rel="shortcut icon" href="<c:url value="/resources/favico.png"/>"
	type="image/x-icon">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script src="<c:url value="/resources/js/jquery-1.4.3.js"/>"
	type="text/javascript"></script>
<script src="<c:url value="/resources/js/jquery-1.7.2.min.js"/>"></script>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="<c:url value="/resources/js/script.js"/>"
	type="text/javascript"></script>
<title>Brick| Створити завдання</title>
</head>
<body>



	<form method="post" action="create">
		<fieldset class="main">
			<label for="_name">Назва: <span>*</span></label> 
			<input type="text"	name="name" id="_name" required /> 
			<label for="_surname">Категорія<span>*</span></label>
			<select id="_name" name="category" required />
			<option>Послуги домашнього майстра
			<option>Сантехнічні роботи
			<option>Електромонтажні роботи
			<option>Ремонтні роботи
			<option>Побутові послуги
			<option>Клінігові компанії
			<option>Ремонт побутової техніки
			<option>Фото і відео
			<option>Все для свята
			<option>Перевезення
			<option>Транспортні послуги </select> <label for="_surname">Початок
					<span>*</span>
				</label> <input type="text" name="startDate" id="_surname" required /> <label
					for="_surname">Кінець <span>*</span>
				</label> <input type="text" name="endDate" id="_surname" required /> <label
					for="_surname">Про завдання <span>*</span>
				</label> <input type="text" name="aboutText" id="_surname" required />
				<button type="submit" id="ssubmit" onclick="validate(this.form)">Створити</button>
		</fieldset>
</body>
</html>