package com.Priv;

import javax.servlet.*;
import java.io.IOException;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.attendance.bean.UserBean;
import com.attendance.dao.UserDao;
import com.attendance.service.UserService;
import common.util.CookieUitl;
@WebFilter("/login.jsp")
public class PrivFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        if(request.getRequestURI().contains("LoginServlet")) {//如果访问login
            chain.doFilter(request, response);
            return;
        }else {
            String name = CookieUitl.getCookieValByKey("userId", request);
            if(name!=null) {
                String val = CookieUitl.getCookieValByKey("autoLogin", request);
                if(val!=null) {
                    String pass = CookieUitl.getCookieValByKey("password", request);

                    if(new UserDao().ifExist(new UserBean(name,pass))) {
                        request.getSession().setAttribute("username", name);
                        UserBean userBean = new UserBean();
                        userBean.setE_NO(name);
                        userBean.setE_PASSWD(pass);

                        UserService service = new UserService();
                        UserBean user = service.getUserById(userBean);
                        request.getSession().setAttribute("level", user.e_ISADMIN);
                        response.sendRedirect(request.getContextPath() + "/index.jsp");
//                       response.sendRedirect("main.jsp");
//                        chain.doFilter(request, response);
                        return;
                    }else {
                        chain.doFilter(request, response);
                    }
                }else {
                    chain.doFilter(request, response);
                }
            }else {
                chain.doFilter(request, response);
                return;
            }
        }
    }

    @Override
    public void destroy() {

    }
}
