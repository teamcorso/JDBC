package com.ats.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddCookies")
public class AddCookieServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie temp= new Cookie("temp_cookie", "i'm_temp_cookie");
		temp.setMaxAge(-1);
		Cookie perm= new Cookie("perm_cookie", "i'm_perm_cookie");
		perm.setMaxAge(60*60*24*7);
		response.addCookie(temp);
		response.addCookie(perm);
		response.sendRedirect("ShowCookies");
	}

}
