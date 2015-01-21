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
<title>Brick| Підтрвердження email</title>
</head>
<body>



	<form method="post" action="confirm">
		<fieldset class="main">
			<label for="_confirm">Введіть код вказаний у листі: <span>*</span></label> <input type="text"
				name="confirmCode"  required /> 
				
				 <button type="submit" id="ssubmit" onclick="validate(this.form)">Підтвердити</button>




		</fieldset>
		<div id="footer">BrickByBrick©2014. All rights reserved.</div>
</body>
</html>