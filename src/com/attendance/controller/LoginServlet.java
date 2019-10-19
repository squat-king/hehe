package com.attendance.controller;

import com.attendance.bean.UserBean;
import com.attendance.service.UserService;
import common.util.CookieUitl;


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


        doLogin(request,response);

    }
    public void remove(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//清除session
        request.getSession().setAttribute("user", null);
//清除登录cookie
        String autoLogin   = CookieUitl.getCookieValByKey("autoLogin", request);
        Cookie autoLoginCookie =new Cookie("autoLogin",autoLogin);
          if (null != autoLoginCookie) {
            autoLoginCookie.setPath(request.getContextPath() + "/");
            autoLoginCookie.setMaxAge(0);
            response.addCookie(autoLoginCookie);
        }
//重定向到首页
        response.sendRedirect(request.getContextPath());
    }

    public void doLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        String rememberPwd = request.getParameter("rememberPwd");
        String autoLogin=request.getParameter("autoLogin");
        UserBean userBean = new UserBean();
        userBean.setE_NO(userId);
        userBean.setE_PASSWD(password);

        UserService service = new UserService();
        UserBean user = service.getUserById(userBean);

        if (user != null) {
           if(rememberPwd.equals("yes")){
                Cookie idCookie=new Cookie("userId",userId);
                idCookie.setMaxAge(60 * 60 * 24 * 3);
                Cookie pwdCookie=new Cookie("password",password);
                pwdCookie.setMaxAge(60 * 60 * 24 * 3);
                Cookie autCookie=new Cookie("autoLogin",autoLogin);
                response.addCookie(idCookie);
                response.addCookie(pwdCookie);
                response.addCookie(autCookie);
            }

            request.getSession().setAttribute("level", user.e_ISADMIN);
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        } else {
            request.setAttribute("msg", "<font color='red'>用户名或密码错误，请重新登录！</font>");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

}
