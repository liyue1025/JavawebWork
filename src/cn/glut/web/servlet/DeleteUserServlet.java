package cn.glut.web.servlet;

import cn.glut.service.Service;
import cn.glut.service.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 1.设置参数
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        // 2.获取参数
        int id = Integer.parseInt(request.getParameter("id"));

        // 3.调用Service
        Service service = new ServiceImpl();
        service.deleteUser(id);

        // 4.跳转
        response.sendRedirect(request.getContextPath()+"/userListServlet");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
