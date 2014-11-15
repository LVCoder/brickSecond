<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML >

<html lang="uk">
<head>
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
<title>Brick| Welcome</title>
</head>

<body>
	<div id="header">
		<form>
			<input type="text" placeholder="Пошук..." required> <input
				type="button" value="Знайти">
		</form>
		<span id="head"> <a href="/brick"><img
				src="<c:url value="/resources/images/headerr.png"/>"
				style="width: 208px; height: 56px;"></a>


		</span> <a href="j_spring_security_logout">logout </a>
	</div>

	<div id="content">
		<div id="left">

			<a class="ico" href="home.htm" title="Me"></a> <a class="ico1"
				href="home.htm" title="Massages"></a> <a class="ico2"
				href="home.htm" title="News"></a> <a class="ico3" href="home.htm"
				title="Add a gossip"></a>

		</div>

		<div id="right"></div>

		<div id="middle">
			<div id="ava">
				<img src="<c:url value="/resources/images/rondo1.jpg"/>">


				<p>${current_user.getName()}${current_user.getSurname()}</p>
				<div id="stars">
					<img src="<c:url value="/resources/images/stars.png"/>"> <img
						src="<c:url value="/resources/images/stars.png"/>"> <img
						src="<c:url value="/resources/images/stars.png"/>"> <img
						src="<c:url value="/resources/images/stars.png"/>"> <img
						src="<c:url value="/resources/images/stars1.png"/>">
				</div>
			</div>
			<div id="middleR">
				<p>
					На сайті: <span> 19 міс</span>
				</p>
				<p>
					Виконаних завдань: <span> 50</span>
				</p>
				<p>
					Рік народження: <span> 1995</span>
				</p>
				<p>
					Місто: <span> Пустомити</span>
				</p>
				<p>Телефон:
				<p>
					Категорії завдань: <span> переклад, допомога з ПК, доставка</span>
				</p>
				<p>
					Про себе: <span> Молодий не жонатий студент з великою
						фантазією і мріями. Вкрай відповідальний і пунктуальний. Можете на
						мене розраховувати! Часами надто амбітний, тому можу виконувати
						роботу дуже довго але досконало. </span>
				</p>

			</div>

			<h1>Цікаві для вас завдання</h1>
			<a href="#" id="intTasks"> <img
				src="<c:url value="/resources/images/nazar.jpg"/>">
				<h3>Забрати доставку</h3>

				<p>Потрібно забрати черевики, які замовив в інтернеті. Сам не
					можу, бо пари. Черевики доставлять на вул. Городоцьку, 103 о 14год.</p>
				<h2>250грн</h2>
			</a> <a href="#" id="intTasks"> <img
				src="<c:url value="/resources/images/oleg.JPG"/>">
				<h3>Забрати доставку</h3>

				<p>Потрібно забрати черевики, які замовив в інтернеті. Сам не
					можу, бо пари. Черевики доставлять на вул. Городоцьку, 103 о 14год.</p>
				<h2>250грн</h2>
			</a> <a href="#" id="intTasks"> <img
				src="<c:url value="/resources/images/rondo1.jpg"/>">
				<h3>Забрати доставку</h3>

				<p>Потрібно забрати черевики, які замовив в інтернеті. Сам не
					можу, бо пари. Черевики доставлять на вул. Городоцьку, 103 о 14год.</p>
				<h2>250грн</h2>
			</a>
		</div>

	</div>
	<div id="footer">BrickByBrick©2014. All rights reserved.</div>
	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
	<script src="<c:url value="/resources/js/script.js"/>"
		type="text/javascript"></script>
</body>
<script src="<c:url value="/resources/js/script.js"/>"
	type="text/javascript"></script>

</html>