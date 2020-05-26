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

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 1.设置编码
        request.setCharacterEncoding("utf-8");

        // 2.获取map
        Map<String, String[]> map = request.getParameterMap();

        // 3.封装对象
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        // 判断用户名或密码是否为空
        if(user.getUsername() != null && user.getPassword() != null && !"".equals(user.getUsername()) && !"".equals(user.getPassword())){
            // 用户名和密码不为空
            //判断用户名是否已经被注册
            Service service = new ServiceImpl();
            if(service.findUserByUsername(user.getUsername()) == null){
                // 用户名未被注册，可以注册

                // 4.调用Service
                service.addUser(user);

                // 5.跳转到注册成功页面
                request.setAttribute("msg","注册");
                request.getRequestDispatcher("/success.jsp").forward(request,response);
            }else{
                // 用户名已被注册
                // 存储提示信息，跳转注册页面
                request.setAttribute("reg_msg2","该用户名已被注册");
                request.getRequestDispatcher("/register.jsp").forward(request,response);
            }
        }else{
            // 用户名或密码为空
            // 存储提示信息，跳转注册页面
            request.setAttribute("reg_msg","用户名或密码为空！");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
