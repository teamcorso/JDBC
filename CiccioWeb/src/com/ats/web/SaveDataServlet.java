package com.ats.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/readMyData")
public class SaveDataServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		Enumeration<String> headerNames = request.getHeaderNames();
		pw.println("<h1>Request Headers:</h1>");
		while (headerNames.hasMoreElements()) {
			String name = headerNames.nextElement();
			Enumeration<String> headerValues = request.getHeaders(name);
			pw.printf("Header Name: %s<br />", name);
			while (headerValues.hasMoreElements()) {
				String headerValue = headerValues.nextElement();
				pw.printf("Header Value: %s<br />", headerValue);
			}
		}
		String programmerName = request.getParameter("name");
		String programmerLastname = request.getParameter("lastname");
		String sex = request.getParameter("sex");
		String[] licences = request.getParameterValues("driverLicence");
		String[] skills = request.getParameterValues("skills");

		pw.printf("<p>You are %s %s and are %s</p>%n", programmerName,
				programmerLastname,
				sex.equals("M") ? "Male" : sex.equals("F") ? "Female"
						: "seriously perturbed by this java class");
		pw.println("<h4>You can Drive:</h4>");
		pw.println("<ul>");
		for (String v : licences) {
			pw.printf("<li>%s</li>", v);
			pw.print("<li>" + v + "</li>");
		}
		pw.println("</ul>");

		pw.println("<h4>You have these Skills:</h4>");
		pw.println("<ul>");
		for (String sk : skills) {
			pw.printf("<li>%s</li>", sk);
		}
		pw.println("</ul>");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
