<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="header">
		
		<span id="head"> <a href="/brick"><img
				src="<c:url value="/resources/images/headerr.png"/>"
				style="width: 208px; height: 56px;"></a>


		</span> 
		
		<div id="menuItems">
		<a href="/brick/edit">Редагувати профіль </a>
		<a href="/brick/task/create">Створити завдання </a>
		<a href="/brick/task/avaible">Всі завдання</a>
		<a href="/brick/logout">Вийти </a>
		</div>
	</div>