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

@WebServlet("/updataPasswordServlet")
public class UpdataPasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 设置编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        // 1.获取值
        String op = request.getParameter("oldPassword");
        String np1 = request.getParameter("newPassword1");
        String np2 = request.getParameter("newPassword2");

        // 2.判断输入是否合法
        if(op==null || np1==null || np2==null || "".equals(op) || "".equals(np1) || "".equals(np2)){
            // 输入为空
            // 保存提示信息，转发
            request.setAttribute("up_msg","输入不能为空！");
            request.getRequestDispatcher("/updatePassword.jsp").forward(request,response);

        }else if(!np1.equals(np2)){
            // 两次输入密码不相等
            // 保存提示信息，转发
            request.setAttribute("up_msg","两次输入的新密码不同！");
            request.getRequestDispatcher("/updatePassword.jsp").forward(request,response);

        }else{
            // 3.输入合法，验证输入的旧密码是否正确
            User user = (User) request.getSession().getAttribute("user");
            if(op.equals(user.getPassword())){
                // 输入的旧密码正确

                // 获取当前登录得用户id
                int id = user.getId();

                // 4.调用Service
                Service service = new ServiceImpl();
                service.updataPassword(id,np1);

                // 5.删除Session中的user
                request.getSession().removeAttribute("user");

                // 6.存储提示信息，跳转成功页面
                request.setAttribute("msg","修改密码");
                request.getRequestDispatcher("/success.jsp").forward(request,response);

            }else{
                // 输入的旧密码错误
                // 保存提示信息，转发
                request.setAttribute("up_msg","输入的旧密码错误！");
                request.getRequestDispatcher("/updatePassword.jsp").forward(request,response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
