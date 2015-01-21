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
<title>Brick| Welcome</title>


</head>

<body id="regbody">


	<div id="headerReg"></div>
	<div id="left">
		<a href="/brick"><img
			src="<c:url value="/resources/images/headerReg.png"/>" id="regImg"></a>
		<h1 id="regh1">Редагування Завдання</h1>
		
	</div>
	<div id="rightReg">
	
		<form method="post" action="${task.getId() }">
			<fieldset class="main">
				<label for="_name">Назва <span>*</span></label> <input type="text"
					name="name" id="_name" value="${task.getName() }" required /> 
					<label for="_name">Категорія <span>*</span></label> <input type="text"
					name="category" id="_name" value="${task.getCategory() }" required /> 
					<label for="_name">Початок<span>*</span></label> <input type="text"
					name="startDate" id="_name" value="${task.getStartDate() }" required />
					<label for="_name">Кінець <span>*</span></label> <input type="text"
					name="endDate" id="_name" value="${task.getEndDate() }" required /> 
					<label for="_name">Про завдання <span>*</span></label> <input type="text"
					name="aboutText" id="_name" value="${task.getAboutText() }" required />  



			<fieldset class="bottom">
				<button type="submit" id="ssubmit" onclick="validate(this.form)">Зберегти зміни</button>
			</fieldset>
		</form>

	</div>
	<div id = "result"></div>
	<div id="footer">BrickByBrick©2014. All rights reserved.</div>
	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
	<script src="js/script.js" type="text/javascript"></script>
</body>
<script src="js/script.js" type="text/javascript"></script>

</html>