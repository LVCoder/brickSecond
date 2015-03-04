<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.pmi.brick.domain.*"%>
<%@ page import="com.pmi.brick.service.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ taglib prefix="dd" uri="/WEB-INF/tlds/FormatDate"%>
<fmt:setLocale value="uk" />
<!DOCTYPE HTML >
<html lang="uk">


</head>







<p>
<h3>Назва:</h3>
${currentTask.name}
</p>
<p>
<h3>Категорія:</h3>${currentTask.category}</p>
<p>
<h3>
	Роботодавець:<a href="/brick/user/${boss.id} ">
</h3>${boss.name}
${boss.surname}
</a>
</p>
<p>
<h3>Опубліковано:</h3>${currentTask.postDate}</p>
<p>
<h3>Дата початку виконання:</h3>
<fmt:formatDate value="${currentTask.startDate}"
	pattern="yyyy/MM/dd HH:mm" />
</p>
<p>
<h3>Кінецвий термін виконання:</h3>
<fmt:formatDate value="${currentTask.endDate}"
	pattern="yyyy/MM/dd HH:mm" />
${dd:formatDate(currentTask.endDate)}
</p>
<p>
<h3>Про завдання:</h3>${currentTask.aboutText }</p>
<h3>Статус:</h3>${taskStatusText}</p>
<c:if test="${not empty worker}">
	<p>
	<h3>Виконавець:</h3>
	<a href="/brick/user/${worker.id}">${worker.name} ${worker.surname}</a>
	</p>us
</c:if>

<c:if test="${not empty taskRequestAndWorkersMap}">

Список виконавців, які подали заявку на виконання завдання:
<ol>

		<c:forEach var="entry" items="${taskRequestAndWorkersMap}">
     ${entry.value.name} ${entry.value.surname}  ${dd:formatDate(entry.key.date)}   <a href="/brick/task/setWorker/${entry.key.taskId}/${entry.value.id}">Підтвердити</a>
			<br>
		</c:forEach>
	</ol>
</c:if>
<a href="/brick/home">Головна</a>
<a href="avaible">Усі завдання</a>
<a href="myTasks">Мої завдання</a>
<a href="create">Додати завдання</a> ${editTaskButton} ${takeTaskButton}
${requestMessage} ${requestStatusText}

</div>



<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="js/script.js" type="text/javascript"></script>

<script src="js/script.js" type="text/javascript"></script>

</html>

