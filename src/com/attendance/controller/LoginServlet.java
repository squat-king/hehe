package com.attendance.controller;

import com.attendance.bean.UserBean;
import com.attendance.service.UserService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    //查看
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String rememberPwd = request.getParameter("rememberPwd");
        String autoLogin=request.getParameter("autoLogin");
        if(rememberPwd.equals("yes")){
            String userId = request.getParameter("userId");
            String password = request.getParameter("password");
            Cookie idCookie=new Cookie("userId",userId);
            idCookie.setMaxAge(60 * 60 * 24 * 3);
            Cookie pwdCookie=new Cookie("password",password);
            pwdCookie.setMaxAge(60 * 60 * 24 * 3);
            response.addCookie(idCookie);
            response.addCookie(pwdCookie);
        }

        doLogin(request,response);

    }


    public void doLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");

        UserBean userBean = new UserBean();
        userBean.setE_NO(userId);
        userBean.setE_PASSWD(password);

        UserService service = new UserService();
        UserBean user = service.getUserById(userBean);

        if (user != null) {

            request.getSession().setAttribute("level", user.e_ISADMIN);
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        } else {
            request.setAttribute("msg", "<font color='red'>用户名或密码错误，请重新登录！</font>");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

}
