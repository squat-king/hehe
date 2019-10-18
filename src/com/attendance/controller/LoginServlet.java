package com.attendance.controller;

import com.attendance.bean.UserBean;
import com.attendance.service.UserService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login_do")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    //查看
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String method = request.getParameter("method");
        System.out.println(method);
        if ("login".equals(method)) {
            doLogin(request, response);
        }

    }


    public void doLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");

        UserBean userBean=new UserBean();
        userBean.setE_NO(userId);
        userBean.setE_PASSWD(password);

        UserService service = new UserService();
        UserBean user = service.getUserById(userBean);

        if (user != null) {
            request.getSession().setAttribute("user", user);

            if (user.getE_ISADMIN().equals("1")) {
//				resp.sendRedirect( "/admin/goods_list.jsp");
//				request.getRequestDispatcher("/admin/goods_list").forward(req, resp);
                response.sendRedirect(request.getContextPath() + "/index.jsp");
            } else {
                request.getRequestDispatcher("/").forward(request, response);
            }
        } else {
            request.setAttribute("msg", "<font color='red'>用户名或密码错误，请重新登录！</font>");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

}
