<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML >
<html lang="uk">



</head>

<form method="post" action="${userId}">
		<fieldset class="main">
			<label for="_newPassword">Введіть новий пароль<span>*</span></label> <input type="text"
				name="password"  required /> 
				
				 <button type="submit" id="ssubmit" onclick="validate(this.form)">Підтвердити</button>




		</fieldset>


</html>