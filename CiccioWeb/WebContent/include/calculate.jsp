<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>IYou will never see this</title>
</head>
<body>
  <%
     int x = Integer.parseInt(request.getParameter("num1"));
     int y = Integer.parseInt(request.getParameter("num2"));
     
     request.setAttribute("result", x*y);
  %>
  
  <jsp:forward page="showResult.jsp"/>
</body>
</html>