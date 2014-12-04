package com.ats.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ats.web.shopping.ICart;
import com.ats.web.shopping.MapShoppingCart;
import com.ats.web.shopping.OrderLine;
import com.ats.web.shopping.Product;
import com.ats.web.shopping.FunctionalShoppingCart;

@WebServlet("/goShopping")
public class ShoppingServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ICart cart = (ICart) session.getAttribute("cart");
		PrintWriter pw = response.getWriter();
		pw.print("<html>");
		pw.print("<body>");
		pw.print("<a href='BuyForm.html'> <--- Torna allo shopping!</a><br />");
		if (cart == null) {
			//cart = new FunctionalShoppingCart();
			cart = new MapShoppingCart();
			session.setAttribute("cart", cart);
		}

		String name = request.getParameter("name");
		if (name != null) {
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			Product prod = new Product(name);
			cart.add(prod, quantity);
		}
		if (cart.isEmpty()) {
			pw.println("<h1>Your cart is empty</h1>");
		} else {
			Collection<OrderLine> lines = cart.orderLines();
			pw.println("<table>");

			pw.print("<tr>");
			pw.print("<th>product name</th>");
			pw.print("<th>quantity</th>");
			pw.println("</tr>");

			for (OrderLine line : lines) {
				pw.print("<tr>");
				pw.printf("<td>%s</td>", line.getProduct().getName());
				pw.printf("<td>%s</td>", line.getQuantity());
				pw.println("</tr>");
			}
			pw.println("</table>");
			pw.printf("<h3>Your Total: %.2f</h3>", cart.total());

		}
		pw.print("</body>");
		pw.print("</html>");
	}

}
