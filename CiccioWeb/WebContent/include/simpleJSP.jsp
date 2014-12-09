<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Computational Physics Again</title>
</head>
<body>
   <% 
     request.setAttribute("num1", 6);
     request.setAttribute("num2", 7);
   %>
   <p>Il risultato e'..... ${num1 * num2}</p>
   
</body>
</html>