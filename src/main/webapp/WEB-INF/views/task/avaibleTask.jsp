<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ page import="com.pmi.brick.domain.Task" %>
    <%@ page import="java.io.*,java.util.*" %>

<!DOCTYPE html >
<html>

<% 
List<Task> tasks=(List<Task>)request.getAttribute("taskObj");
int pagesCount=Integer.parseInt(request.getAttribute("pagesCount").toString());
int thisPageNumber=Integer.parseInt(request.getAttribute("thisPageNumber").toString());
%>



<ol start="<%=thisPageNumber*10-9%>">

<%
int maxCount=thisPageNumber*10;
if(maxCount>tasks.size())
		maxCount=tasks.size();
	
for(int i=thisPageNumber*10-10;i<maxCount;i++){ %>

<li><a href="/brick/task/<%=tasks.get(i).getId()%>" ><c:out value="<%=tasks.get(i).getName()%>"/></a></li>

<%} %>
</ol>


<p>Сторінки</p>

<%for(int i=1;i<=pagesCount;i++){ %><a href="<%=i%>"><%=i%> </a><%} %>


</html>