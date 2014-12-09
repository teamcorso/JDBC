<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dog Registration</title>

<%
  session.setAttribute("newDog", new com.ats.web.veterinary.Dog());
%>

<jsp:useBean id="newDog" scope="session" class="com.ats.web.veterinary.Dog" />

<jsp:setProperty name="newDog" property="*" />
</head>
<body>
   Name:  <jsp:getProperty property="name" name="newDog"/><br />
   Age :  <jsp:getProperty property="age" name="newDog"/><br />
   Color: <jsp:getProperty property="color" name="newDog"/><br />
   Breed: <jsp:getProperty property="breed" name="newDog"/><br />
</body>
</html>