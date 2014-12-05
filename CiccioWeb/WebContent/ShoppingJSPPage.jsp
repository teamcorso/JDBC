<%@ page import="com.ats.web.shopping.*"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shopping Cart</title>
</head>
<body>
	<%
		ICart cart = (ICart) session.getAttribute("cart");
		if (cart == null) {
			cart = new FunctionalShoppingCart();
			session.setAttribute("cart", cart);
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
	<%
		}
     %>


</body>
</html>