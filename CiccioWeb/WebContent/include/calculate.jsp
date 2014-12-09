<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

  <%
     int x = Integer.parseInt(request.getParameter("num1"));
     int y = Integer.parseInt(request.getParameter("num2"));
     
     request.setAttribute("result", x*y);
  %>
  
  <jsp:forward page="showResult.jsp"/>
