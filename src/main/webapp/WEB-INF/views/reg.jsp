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
		<h1 id="regh1">Реєстрація</h1>
		<div id="imgblockReg">
			<img src="<c:url value="/resources/images/VK.png"/>"> <img
				src="<c:url value="/resources/images/GP.png"/>"> <img
				src="<c:url value="/resources/images/FB.png"/>">



			<p>Увійди за допомогою своїх улюблених сайтів!</p>
			<span color="red">${errorMessage}</span>
		</div>
	</div>
	<div id="rightReg">
	
		<form method="post" action="registration">
			<fieldset class="main">
				<label for="_name">Ім'я <span>*</span></label> <input type="text"
					name="name" id="_name" placeholder="" required /> <label
					for="_surname">Прізвище <span>*</span>
				</label> <input type="text" name="surname" id="_surname" placeholder=""
					required /> <label for="_number">Телефон <span>*</span>
				</label> <input type="text" name="phone" id="_phone" placeholder="" required />




			</fieldset>

			<fieldset class="dop">
				<span>${emailErrorMessage} </span></span> <label for="_email">E-mail<span>*</span></label>
				<input type="email" name="email" id="_email" placeholder="" required />


				<label for="_password">Пароль<span>*</span></label> <input
					type="password" name="password" id="_password" required /> <label
					for="_repeat">Повторіть пароль<span>*</span></label> <input
					type="password" name="repeat" id="_repeat" required />



			</fieldset>




			<fieldset class="bottom">
				<button type="submit" id="ssubmit" onclick="validate(this.form)">Зареєструватися</button>
			</fieldset>
		</form>

	</div>
	<div id="footer">BrickByBrick©2014. All rights reserved.</div>
	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
	<script src="js/script.js" type="text/javascript"></script>
</body>
<script src="js/script.js" type="text/javascript"></script>

</html>