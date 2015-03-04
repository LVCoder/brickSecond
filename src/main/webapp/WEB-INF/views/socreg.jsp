<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML >
<html lang="uk">






	<div id="left">
		
		<h1 id="regh1">Завершення Реєстарції</h1>
		
	</div>
	<div id="rightReg">
	
		<form method="post" action="socreg"  enctype="multipart/form-data">
			<fieldset class="main">
				<label for="_name">Ім'я <span>*</span></label> <input type="text"
					name="name" id="_name" value="${socialUser.getName() }" required /> 
					<label for="_surname">Прізвище <span>*</span>
				</label>
				 <input type="text" name="surname" id="_surname" value="${socialUser.getSurname() }"required /> 
				 <label for="_city">Місто <span>*</span>
				</label>
				 <input type="text" name="city" id="_City" value="${socialUser.getCity()}"required /> 
					<label for="_number">Телефон <span>*</span></label> 
				<input type="text" name="phone" id="_phone" value="" required />




			</fieldset>

			<fieldset class="dop">
				<span>${emailErrorMessage} </span></span> <label for="_email">E-mail<span>*</span></label>
				<input type="email" name="email" id="_email" value="${socialUser.getEmail() }" required />

            </fieldset>
			<fieldset class="bottom">
				<button type="submit" id="ssubmit" onclick="validate(this.form)">Зберегти зміни</button>
			</fieldset>
		</form>

	</div>
	
	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
	<script src="js/script.js" type="text/javascript"></script>

<script src="js/script.js" type="text/javascript"></script>

</html>