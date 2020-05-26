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

@WebServlet("/updataUserServlet")
public class UpdataUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 设置编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        // 1.获取map
        Map<String, String[]> map = request.getParameterMap();

        // 2.封装对象,使用BeanUtils
        User newUser = new User();
        try {
            BeanUtils.populate(newUser,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        // 3.调用Servic
        Service service = new ServiceImpl();
        service.updataUser(newUser);

        // 4.更新Session域中user信息
        request.getSession().setAttribute("user",service.findUserById(newUser.getId()));

        // 5.跳转到userL;oginSuccess
        request.getRequestDispatcher("/userLoginSuccess.jsp").forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
