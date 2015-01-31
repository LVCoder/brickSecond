<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML >


<body id="regbody">
	
	<div id="left">
		<a href="/brick/"> <img
			src="<c:url value="/resources/images/headerReg.png"/>" id="regImg">
		</a>
		<h1 id="regh1">Вхід</h1>
		<div id="imgblockReg">
			<img src="<c:url value="/resources/images/VK.png"/>"> <img
				src="<c:url value="/resources/images/GP.png"/>"> <img
				src="<c:url value="/resources/images/FB.png"/>">



			<p>Увійди за допомогою своїх улюблених сайтів!</p>

		</div>
	</div>
	<div id="rightReg">
		<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
			<font color="red"> Відулась помилка під час логування.
				Спробуйте ще раз. <br />
			<br /> <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />.
			</font>
		</c:if>
		
		<form method="post" action='j_spring_security_check'>


			<fieldset class="dop">
				<label for="_email">E-mail<span>*</span></label> <input type="email"
					name='j_username' id="_email" placeholder="" required /> <label
					for="_password">Пароль<span>*</span></label> <input type="password"
					name='j_password' id="_password" required />





			</fieldset>




			<fieldset class="bottom">
				<button type="submit" id="ssubmit" onclick="validate(this.form)">Увійти</button>
			</fieldset>
		</form>
		<a href="forgotPassword">Забули пароль</a>
</div>
	
	
	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
	<script src="js/script.js" type="text/javascript"></script>
</body>
<script src="js/script.js" type="text/javascript"></script>

</html>