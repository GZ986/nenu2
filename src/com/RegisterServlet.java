package com;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RegisterServlet() {
    }

    public void init() throws ServletException {
        System.out.println("init");
    }

    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        System.out.println("service");
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        String method = request.getMethod();
        if (method.equals("GET")) {
            this.doGet(request, response);
        } else if (method.equals("POST")) {
            this.doPost(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Get");
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("Post");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");
        PrintWriter writer = response.getWriter();
        if (!"admin".equals(username) && password.equals(repassword)) {
            writer.print("Register Success!");
        } else if (!password.equals(repassword)) {
            writer.print("Please enter the same password!");
        } else {
            writer.print("Username already exists!");
        }

    }

    public void destroy() {
        System.out.println("destory");
    }


}
