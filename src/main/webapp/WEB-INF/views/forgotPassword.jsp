<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML >
<html lang="uk">



</head>
${emailSendingFailed }
<form method="post" action="forgotPassword">
		<fieldset class="main">
			<label for="_newPassword">Введіть ваш e-mail<span>*</span></label> <input type="text"
				name="email"  required /> 
				
				 <button type="submit" id="ssubmit" onclick="validate(this.form)">Підтвердити</button>




		</fieldset>
	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
	<script src="js/script.js" type="text/javascript"></script>

<script src="js/script.js" type="text/javascript"></script>

</html>
