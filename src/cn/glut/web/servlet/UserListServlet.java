package cn.glut.web.servlet;

import cn.glut.domain.Page;
import cn.glut.service.Service;
import cn.glut.service.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/userListServlet")
public class UserListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 1.设置编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        // 2.获取参数
        String s_pageNumber = request.getParameter("pageNumber");
        String s_rows = request.getParameter("rows");
        Map<String, String[]> map = request.getParameterMap();

        // 3.检查pageNumber和rows是否为空，若为空则赋默认值
        if(s_pageNumber == null || "".equals(s_pageNumber)){
            s_pageNumber = "1";
        }
        if(s_rows == null || "".equals(s_rows)){
            s_rows = "5";
        }

        // 4.拆箱
        int pageNumber = Integer.parseInt(s_pageNumber);
        int rows = Integer.parseInt(s_rows);

        // 4.调用Service
        Service service = new ServiceImpl();
        Page page = service.userList(pageNumber,rows,map);

        // 5.将page和map存入request域
        request.setAttribute("page",page);
        request.setAttribute("map",map);


        // 6.转发
        request.getRequestDispatcher("userList.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
