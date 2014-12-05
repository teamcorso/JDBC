<%@ page import="com.ats.web.shopping.*"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shopping Cart</title>
</head>
<body>
	<a href="BuyForm.html"> Torna all'acquisto</a>
	<%
		ICart cart = (ICart) session.getAttribute("cart");
		if (cart == null) {
			cart = new FunctionalShoppingCart();
			session.setAttribute("cart", cart);
		}
		String name = request.getParameter("name");
		String clear = request.getParameter("clear");
		if (name!= null ){
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			cart.add(new Product(name), quantity);
			
		}
		else if (clear != null){
			cart.clear();
		}
		if (cart.isEmpty()) {
	%>
	<h1>Il tuo carrello è vuoto... :(</h1>
	<%
		} else {
	%>
	<table>
		<tr>
			<th>Nome Prodotto</th>
			<th>Quantità Prodotto</th>
		</tr>
		<%
			for (OrderLine ol : cart.orderLines()) {
		%>
		<tr>
			<td><%=ol.getProduct().getName()%></td>
			<td><%=ol.getQuantity()%></td>
		</tr>
		<%
			}
		%>
	</table>
	<p>il totale della tua spesa è <%=  String.format("%.2f", cart.total()) %></p>
	<%
		}
     %>
     

	<form method = "POST">
	<input type = "Submit" name = "clear" value = "Svuota carrello">
	
	</form>
</body>
</html>