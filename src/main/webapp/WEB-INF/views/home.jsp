<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   <%@ page import="com.pmi.brick.domain.User" %>
    <%@ page import="java.io.*,java.util.*" %>

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/stylehome.css" />">
<% User user=new User();
user=(User)request.getAttribute("current_user");

%>


	<div id="content">
	${emailConfirmSuccessful}
	<%if(user.getIsEmailConfirm()==false){ %><h2>Ваш Email не є підтвердженим.</h2><a href="/brick/confirm">Підвердити email</a><%} %>
		<div id="left">

			<a class="ico" href="home.htm" title="Me"></a> <a class="ico1"
				href="home.htm" title="Massages"></a> <a class="ico2"
				href="home.htm" title="News"></a> <a class="ico3" href="home.htm"
				title="Add a gossip"></a>

		</div>

		

		<div id="middle">
			<div id="ava">
				<img src="<c:url value="/files/${current_user.getId()}.jpg"/>">


				<p><%=user.getName()%>  <%=user.getSurname() %> <%=user.getGender().name() %></p>
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
					На сайті: <span></span>
				</p>
				<p>
					Виконаних завдань: <span></span>
				</p>
				<p>
					Рік народження: <span> ${current_user.getDob().getYear()}</span>
				</p>
				<p>
					Місто: <span> ${current_user.getCity()}</span>
				</p>
				<p>Телефон:<span> ${current_user.getPhone()}</span>
				<p>
					Категорії завдань: <span> переклад, допомога з ПК, доставка</span>
				</p>
				<p>
					Про себе: <span> ${current_user.getAboutUser()} </span>
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
	
	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
	<script src="<c:url value="/resources/js/script.js"/>"
		type="text/javascript"></script>

<script src="<c:url value="/resources/js/script.js"/>"
	type="text/javascript"></script>

</html>