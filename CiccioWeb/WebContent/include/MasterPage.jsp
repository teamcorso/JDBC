<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Master Page</title>
<link rel="stylesheet" type="text/css" href="../css/style.css">
</head>
<body>
  <% 
     int numComp1 = 8;
     int numComp2 = 7;
  
     request.setAttribute("num1", 6);
     request.setAttribute("num2", 7);
   %>
  <h1>I am the Master Page</h1>
  <section id = "sec1">
    <jsp:include page="simpleHTML.html"/>
  </section>
   
  <section id = "sec2">
     <%@include file="../WEB-INF/hidden/simpleJSP.jsp" %>
  </section>
</body>
</html>