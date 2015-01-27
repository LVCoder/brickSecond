<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML >





	<div id="left">
		<a href="/brick"><img
			src="<c:url value="/resources/images/headerReg.png"/>" id="regImg"></a>
		<h1 id="regh1">Редагування Завдання</h1>
		
	</div>
	<div id="rightReg">
	
		<form method="post" action="${task.getId() }">
			<fieldset class="main">
				<label for="_name">Назва <span>*</span></label> <input type="text"
					name="name" id="_name" value="${task.getName() }" required /> 
					<label for="_name">Категорія <span>*</span></label> <input type="text"
					name="category" id="_name" value="${task.getCategory() }" required /> 
					<label for="_name">Початок<span>*</span></label> <input type="text"
					name="startDate" id="_name" value="<fmt:formatDate value="${task.getStartDate()}" pattern="yyyy/MM/dd HH:mm" />" required />
					<label for="_name">Кінець <span>*</span></label> <input type="text"
					name="endDate" id="_name" value="<fmt:formatDate value="${task.getEndDate()}" pattern="yyyy/MM/dd HH:mm" />" required /> 
					<label for="_name">Про завдання <span>*</span></label> <input type="text"
					name="aboutText" id="_name" value="${task.getAboutText() }" required />  

</fieldset>

			<fieldset class="bottom">
				<button type="submit" id="ssubmit" onclick="validate(this.form)">Зберегти зміни</button>
			</fieldset>
		</form>

	</div>


	

</html>