package com.ats.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ShowCookies")
public class ShowCookiesServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.println("<html>");
		pw.println("<body>");
		pw.println("<table>");

		pw.println("<tr>");
		pw.println("<th>nome cookie</th>");
		pw.println("<th>valore cookie</th>");
		pw.println("</tr>");

		Cookie[] cs = request.getCookies();
		for (Cookie c : cs) {
			pw.print("<tr>");
			pw.printf("<td>%s</td>",c.getName());
			pw.printf("<td>%s</td>", c.getValue());
			pw.println("</tr>");
		}

		pw.println("</table>");
		pw.println("</body>");
		pw.println("</html>");

	}

}
