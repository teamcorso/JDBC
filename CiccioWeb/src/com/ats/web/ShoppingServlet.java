package com.ats.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletContext;
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
		if (cart == null) {
			cart = new MapShoppingCart();
			//cart = new FunctionalShoppingCart();
			session.setAttribute("cart", cart);
		}
		String clear = request.getParameter("clear");
		String name = request.getParameter("name");
		if( clear != null)
		{
			cart.clear();
		// ServletContext application = this.getServletContext().setAttribute(arg0, arg1);
		}
		else if (name != null) {
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			Product prod = new Product(name);
			cart.add(prod, quantity);
		}
		PrintWriter pw = response.getWriter();
		pw.print("<html>");
		pw.print("<body>");
		pw.print("<a href='BuyForm.html'> <--- Torna allo shopping!</a><br />");
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
		pw.println("<form method='POST'>");
		pw.print("<input type='submit' name='clear' value ='clear cart'>");
		pw.println("</form>");
		
		pw.print("</body>");
		pw.print("</html>");
	}

}
