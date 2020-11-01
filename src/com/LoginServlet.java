package com;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//给浏览器响应一个字符串
		//获取一个打印流
		PrintWriter writer = response.getWriter();
		if("admin".equals(username) && "123456".equals(password))
		{
			writer.print("Login Success!");
		}else{
			writer.print("username("+username+") or password is Invalid.");
		}
	}
}