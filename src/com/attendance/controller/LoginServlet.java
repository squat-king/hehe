package com.attendance.controller;

import com.attendance.model.User;
import com.attendance.service.LoginService;
import com.attendance.service.UserService;
import com.attendance.service.impl.LoignServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login_do")
public class LoginServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getParameter("method");
		if ("login".equals(method)) {
			doLogin(request, response);
		}

	}


	public void doLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserService serive = new UserService();
		User user = serive.login(username, password);
		if(user!=null) {
			request.getSession().setAttribute("user", user);

			if(user.isAdmin()) {
//				resp.sendRedirect( "/admin/goods_list.jsp");
//				request.getRequestDispatcher("/admin/goods_list").forward(req, resp);
				response.sendRedirect(request.getContextPath() +"/index.jsp");
			}else {
				request.getRequestDispatcher("/").forward(request, response);
			}
		}else {
			request.setAttribute("msg", "<font color='red'>用户名或密码错误，请重新登录！</font>");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

}
