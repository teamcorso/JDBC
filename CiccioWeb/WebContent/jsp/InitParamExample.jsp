<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Jsp che legge parametri di inizializzazione(o almeno ci prova...)</title>
</head>
<body>
   <h1>Jsp che legge parametri di inizializzazione(o almeno ci prova...)</h1>
    URL:  <%= getServletConfig().getInitParameter("URL") %><br />
    User: <%= config.getInitParameter("user") %><br />
    Password: <%= getInitParameter("password") %><br />
   
    <%
      String x =  getInitParameter("URL");
      out.print(x);
    
    %>
   
   
</body>
</html>