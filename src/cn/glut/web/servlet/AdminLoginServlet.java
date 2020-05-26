package cn.glut.web.servlet;

import cn.glut.domain.Administrator;
import cn.glut.domain.User;
import cn.glut.service.Service;
import cn.glut.service.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 管理员servlet
 */
@WebServlet("/adminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 设置编码
        request.setCharacterEncoding("utf-8");

        // 1.获取参数
        String adminame = request.getParameter("adminame");
        String password = request.getParameter("password");

        // 2.调用Service
        Service service = new ServiceImpl();
        Administrator admin = service.adminLogin(adminame, password);

       // 3.判断是否登录成功
        if(admin!=null){
            // 登录成功
            // 存储信息跳转userListServlet
            request.getSession().setAttribute("admin",admin);
            response.sendRedirect(request.getContextPath()+"/userListServlet");
        }else{
            System.out.println("登录失败");
            // 登录失败
            // 提示信息
            request.setAttribute("login_msg","账号或密码错误！");
            // 跳转到登录页面
            request.getRequestDispatcher("/administratorLogin.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
