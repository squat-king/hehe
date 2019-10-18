package com.attendance.controller;

import com.attendance.bean.UserBean;
import com.attendance.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/UserListServlet")
public class UserListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService service = new UserService();
        List<UserBean> list = service.userList();
        HttpSession session=request.getSession();
        session.setAttribute("list", list);
        System.out.println(request.getContextPath());
//        request.getRequestDispatcher(request.getContextPath()+"/user/userSearch.jsp");

        response.sendRedirect(request.getContextPath()+"/user/userSearch.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
