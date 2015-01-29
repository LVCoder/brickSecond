<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML >
<html lang="uk">



</head>




	
	

<p><h3>Назва:</h3> ${currentTask.getName() }</p>
<p><h3>Категорія:</h3>${currentTask.getCategory() }</p>
<p><h3>Роботодавець:<a href="/brick/user/${boss.getId()} "></h3>${boss.getName()} ${boss.getSurname()}</a></p>
<p><h3>Опубліковано:</h3>${currentTask.getPostDate() }</p>
<p><h3>Дата початку виконання:</h3><fmt:formatDate value="${currentTask.getStartDate()}" pattern="yyyy/MM/dd HH:mm" /></p>
<p><h3>Кінецвий термін виконання:</h3><fmt:formatDate value="${currentTask.getEndDate()}" pattern="yyyy/MM/dd HH:mm" /></p>
<p><h3>Про завдання:</h3>${currentTask.getAboutText() }</p>

<a href="/brick/home">Головна</a>
<a href="avaible">Усі завдання</a>
<a href="create" >Додати завдання</a>
${editTaskButton}
${takeTaskButton}
${requestMessage}
	</div>


	
	<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
	<script src="js/script.js" type="text/javascript"></script>

<script src="js/script.js" type="text/javascript"></script>

</html>

