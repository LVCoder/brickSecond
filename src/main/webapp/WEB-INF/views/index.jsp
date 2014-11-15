<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
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

<body>
	<div id="header">
		<span id="head"> <img
			src="<c:url value="/resources/images/headerr.png"/>"
			style="width: 260px; height: 70px;">
		</span> <a id="ent" href="login">Вхід </a> <a id="reg" href="registration">Реєстрація</a>
	</div>
	<div id="main">
		<!--<div id = "enter" >
<form action="jsp/appsdata.jsp" method="post">
 <fieldset class="dop">
      <label for="_email">E-mail</label>
      <input type="email" name="email" id="_email" placeholder="" required />
      
      
	   <label for="_password">Пароль</label>
      <input type="password" name="password" id="_password" required />
	  </fieldset>
	  <fieldset class="bottom">
      <button type="submit" id="ssubmit" >Вхід</button>
    </fieldset>
	</form>
</div>-->
		<div id="right">
			<div id="images">
				<div id="imgblock">
					<img src="<c:url value="/resources/images/search.png"/>"></img>
					<h3>
						<span>1. Знайди завдання</span>
						<p>Серед тисяч завдань знайди таке, яке тобі під силу
							виконати.</p>
						<h3>
				</div>
				<div id="imgblock">
					<img src="<c:url value="/resources/images/clock.png"/>"></img>
					<h3>
						<span>2. Підтвердження</span>
						<p>Почекай кілька хвилин і отримай підтвердження від
							роботодавця.</p>
				</div>
				<div id="imgblock">
					<img src="<c:url value="/resources/images/done1.png"/>"></img>
					<h3>
						<span>3. Виконай роботу</span>
						<p>Отримай підтвердження і приступай до виконання свого
							завдання</p>
					</h3>
				</div>
				<div id="imgblock">
					<img src="<c:url value="/resources/images/Money.png"/>"></img>
					<h3>
						<span>4.Отримай гроші </span>
						<p>Виконай завдання вчасно і правильно та отримай за нього
							зарплатню</p>
					</h3>
				</div>
			</div>
		</div>
	</div>
	</div>
	<div id="down">
		<a href="#" id="example"> <img
			src="<c:url value="/resources/images/oleg.JPG"/>"></img>
			<h1>40грн</h1>
			<button id="doBut">Виконати</button>
			<p>
				<span>Забрати доставку</span> Потрібно забрати черевики, які замовив
				в інтернеті. Сам не можу, бо пари. Черевики доставлять на вул.
				Городоцьку, 103 о 14год.
			</p>
		</a> <a href="#" id="example"> <img
			src="<c:url value="/resources/images/oleg.JPG"/>"></img>
			<h1>40грн</h1>
			<button id="doBut">Виконати</button>
			<p>
				<span>Забрати доставку</span> Потрібно забрати черевики, які замовив
				в інтернеті. Сам не можу, бо пари. Черевики доставлять на вул.
				Городоцьку, 103 о 14год.
			</p>
		</a> <a href="#" id="example"> <img
			src="<c:url value="/resources/images/oleg.JPG"/>"></img>
			<h1>40грн</h1>
			<button id="doBut">Виконати</button>
			<p>
				<span>Забрати доставку</span> Потрібно забрати черевики, які замовив
				в інтернеті. Сам не можу, бо пари. Черевики доставлять на вул.
				Городоцьку, 103 о 14год.
			</p>
		</a>
		<div id="exampleE">
			<p>Замов послугу будь-якого типу!</p>
			<form action="jsp/appsdata.jsp" method="post">
				<fieldset class="dop">
					<label for="_email">Що зробити?</label> <input type="email"
						name="email" id="_email"
						placeholder="Забити поличку, забрати то.." required />
				</fieldset>
				<fieldset class="bottom">
					<button type="submit" id="ssubmit">Замовити</button>
				</fieldset>
			</form>
		</div>
	</div>
	<div id="downleft">
		<h1>Хто ми?</h1>
		<p>Ми - це вебсайт, який дає можливість легко і швидко заробити
			гроші на прогулянку з друзями, чи на похід у кіно з дівчиною. Маєте
			вільну годинку часу? Заходьте на наш сайт, пошукайте чим зайнятись і
			отримайте за елементарні завдання непогані гроші. Ми - це найлегший
			спосіб заробітку.</p>

	</div>
	<div id="downmiddle">
		<h1>Зробити щось за тебе?</h1>
		<p>Не маєш часу, щоб зробити деяку справу? Тоді наш вебсервіс саме
			для тебе! Нехай це зробить хтось з наших працівників. Потрібно
			перенести меблі, забити поличку, збігати за пивом? Кілька кліків і
			все готово, а ти за цей час займаєшся улюбленими справами!</p>
	</div>

	<div id="downright">
		<a href="registration">Реєстрація</a> <a class="try">Спробувати</a>
		<div class="popup">
			<div id="choice">
				<a href="doTask.htm">Хочу підзаробити</a> <a href="doOrder.htm">Маю
					завдання </a>
			</div>
		</div>
		<div class="hover"></div>
	</div>
	<div id="footer">BrickByBrick©2014. All rights reserved.</div>
	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
	<script src="<c:url value="/resources/js/script.js"/>"
		type="text/javascript"></script>
</body>
<script src="<c:url value="/resources/js/script.js"/>"
	type="text/javascript"></script>

</html>