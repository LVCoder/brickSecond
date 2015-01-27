<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML >
<html lang="uk">






	<div id="left">
		
		<h1 id="regh1">Редагування профілю</h1>
		
	</div>
	<div id="rightReg">
	
		<form method="post" action="edit"  enctype="multipart/form-data">
			<fieldset class="main">
				<label for="_name">Ім'я <span>*</span></label> <input type="text"
					name="name" id="_name" value="${current_user.getName() }" required /> <label
					for="_surname">Прізвище <span>*</span>
				</label> <input type="text" name="surname" id="_surname" value="${current_user.getSurname() }"
					required /> <label for="_number">Телефон <span>*</span>
				</label> <input type="text" name="phone" id="_phone" value="${current_user.getPhone() }" required />




			</fieldset>

			<fieldset class="dop">
				<span>${emailErrorMessage} </span></span> <label for="_email">E-mail<span>*</span></label>
				<input type="email" name="email" id="_email" value="${current_user.getEmail() }" required />

 <fieldset>
        Виберіть фото <input type="file" name="file"><br /> 
      
     
    
</fieldset>

			</fieldset>




			<fieldset class="bottom">
				<button type="submit" id="ssubmit" onclick="validate(this.form)">Зберегти зміни</button>
			</fieldset>
		</form>
</form>
	</div>
	
	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
	<script src="js/script.js" type="text/javascript"></script>

<script src="js/script.js" type="text/javascript"></script>

</html>