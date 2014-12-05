<%@ page errorPage="ComputationalError.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Advanced Computational Physics</title>
</head>
<body>
    <%
      String str1 = request.getParameter("num1");
      String str2 = request.getParameter("num2");
      if(str1 != null && str2 != null) {
    	  int i1 = Integer.parseInt(str1);
    	  int i2 = Integer.parseInt(str2);
    	  request.setAttribute("result", i1/i2);
      }
    
    %>
    
    <form>
    <input type="number" name = "num1" value = "1"> / <input type="number" name="num2" value = "1"> = ${result}<br />
    <input type="submit" value="calcola">
    </form>
</body>
</html>