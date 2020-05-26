package cn.glut.web.servlet;

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
 * 用户登录servlet
 */
@WebServlet("/userLoginServlet")
public class UserLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 设置编码
        request.setCharacterEncoding("utf-8");

        // 1.获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 2.调用Service
        Service service = new ServiceImpl();
        User user = service.login(username, password);

       // 3.判断是否登录成功
        if(user!=null){
            // 登录成功
            // 将用户信息存入session
            request.getSession().setAttribute("user",user);
            // 跳转到登录成功页面
            response.sendRedirect(request.getContextPath()+"/userLoginSuccess.jsp");
        }else{
            // 登录失败
            // 提示信息
            request.setAttribute("login_msg","用户名或密码错误！");
            request.setAttribute("username",username);
            // 跳转到登录页面
            request.getRequestDispatcher("/userLogin.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
