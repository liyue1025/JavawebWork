package cn.glut.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 注销
 */
@WebServlet("/logoffServlet")
public class LogoffServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        // 获取Session
        HttpSession session = request.getSession();

        // 将Session域里的User对象删除
        if(session.getAttribute("user") != null){
            session.removeAttribute("user");
        }
        // 将Session域里的Admin对象删除
        if(session.getAttribute("admin") != null){
            session.removeAttribute("admin");
        }

        // 重定向到登录页面
        response.sendRedirect(request.getContextPath()+"/userLogin.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
