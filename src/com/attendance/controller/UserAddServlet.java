package com.attendance.controller;

import com.attendance.bean.UserBean;
import com.attendance.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/UserAddServlet")
public class UserAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String password1=req.getParameter("password");
        String passwordConfirm =req.getParameter("passwordConfirm");

        if(!password1.equals(passwordConfirm)){
//返回一个提示信息到页面上
        }
        String userId=req.getParameter("userId");
        String userName=req.getParameter("userName");
        String dept=req.getParameter("dept");
        String job=req.getParameter("job");
        String sex=req.getParameter("sex");
        String phone=req.getParameter("phone");
        String birthday=req.getParameter("birthday");
        String email=req.getParameter("email");

        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-mm-dd hh-mm");
        String registTime=simpleDateFormat.format(date);

        UserBean userBean=new UserBean(userId,userName,password1,dept,job,registTime,sex,phone,birthday,email,"0");

        UserService userService=new UserService();
        if(userService.userAdd(userBean)){
            resp.sendRedirect(req.getContextPath()+"/UserListServlet");
        }
    }
}
