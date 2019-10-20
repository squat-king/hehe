package com.attendance.controller;

import com.attendance.bean.PageBean;
import com.attendance.bean.UserBean;
import com.attendance.dao.ProductDao;
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

    ProductDao productDao=new ProductDao();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int p=1;
        request.setCharacterEncoding("utf-8");

        if (request.getParameter("page")!=null) {
            System.out.println(request.getParameter("page")+"1111");
            p = Integer.parseInt(request.getParameter("page"));
        }

        PageBean pb=new PageBean();
        pb.setAllRows(ProductDao.getAllRows("EMPLOYEE"));
        pb.setCurrentPage(p);

        productDao.splitPage(pb);
        HttpSession session=request.getSession();
        session.setAttribute("pb",pb);
        response.sendRedirect(request.getContextPath()+"/user/userSearch.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
