package com.example.demo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "mvcMemberFormServlet",urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 보여줄 view 경로
        String viewPath = "/WEB-INF/views/new-form.jsp";
        // 경로를 dispatcher 에 넣음.
        RequestDispatcher dispatcher = req.getRequestDispatcher(viewPath);
        // req, resp 를 가지고 다른 서블릿이나 jsp 로 이동.
        dispatcher.forward(req,resp);
    }
}
