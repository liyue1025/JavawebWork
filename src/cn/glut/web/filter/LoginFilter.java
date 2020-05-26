package cn.glut.web.filter;

import com.sun.deploy.net.HttpRequest;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登录验证过滤器
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        // 1.强转
        HttpServletRequest request = (HttpServletRequest) req;

        // 2.获取资源请求路径
        String uri = request.getRequestURI();

        // 3.判断是否包含登录/注册相关的资源
        if(uri.contains("/userLogin.jsp") || uri.contains("/userLoginServlet") || uri.contains("/administratorLogin.jsp") || uri.contains("/adminLoginServlet") || uri.contains("/register.jsp") || uri.contains("/registerServlet") || uri.contains("/registerSuccess.jsp") || uri.contains("/success.jsp") || uri.contains("/image/")|| uri.contains("/css/") || uri.contains("/js/") || uri.contains("/fonts/ ") ){
            // 包含登录/注册相关的资源
            if((uri.contains("/userLogin.jsp") && request.getSession().getAttribute("user")!=null )||(uri.contains("/administratorLogin.jsp") && request.getSession().getAttribute("admin")!=null)){
                // 用户或管理员已登录的情况下访问登录页面
                // 跳转
                request.getRequestDispatcher("/welcome.jsp").forward(request,resp);
            }else{
                // 放行
                chain.doFilter(req,resp);
            }

        }else{
            // 资源请求路径不包含登录/注册相关的资源
            // 判断是否登录
            HttpSession session = request.getSession();
            if(session.getAttribute("user")!=null){
                // 用户已登录
                // 判断用户访问的资源是否包括管理员才能访问的资源
                if(uri.contains("/adminUpdateUserServlet") || uri.contains("/deleteUserServlet") ||uri.contains("/forwardServlet") ||uri.contains("/userListServlet") ||uri.contains("adminUpdateUser.jsp") || uri.contains("userList.jsp") ){
                    // 跳转
                    request.getRequestDispatcher("/refuse.jsp").forward(request,resp);
                }else{
                    // 放行
                    chain.doFilter(req,resp);
                }
            }else if(session.getAttribute("admin")!=null){ // 用户未登录，管理员已登录
                // 管理员登录
                // 放行
                chain.doFilter(request,resp);
            }else{
                // 无登录对象，没有还登录，转发到登录页面
                request.setAttribute("login_msg","您尚未登录，请先登录！");
                request.getRequestDispatcher("/userLogin.jsp").forward(req,resp);
            }
        }


    }

    public void init(FilterConfig config) throws ServletException {

    }

}
