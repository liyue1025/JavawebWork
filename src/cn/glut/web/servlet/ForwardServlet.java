package cn.glut.web.servlet;

import cn.glut.domain.User;
import cn.glut.service.Service;
import cn.glut.service.ServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/forwardServlet")
public class ForwardServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 设置编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        // 1.获取id
        int id = Integer.parseInt(request.getParameter("id"));

        // 2.调用Service获取对应id的用户信息
        User user = new ServiceImpl().findUserById(id);


        // 3.存入request并转发到adminUpdateUser.jsp
        request.setAttribute("user",user);
        request.getRequestDispatcher("/adminUpdateUser.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
