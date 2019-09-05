package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //强制转换
        HttpServletRequest request=(HttpServletRequest) req;
        HttpServletResponse response=(HttpServletResponse) resp;
        //获取资源请求路径
        String uri = request.getRequestURI();
        //判断是否包含登录相关资源路径
        if (uri.contains("/login.jsp")||uri.contains("loginServlet")||uri.contains("/css/")||uri.contains("/js/")||uri.contains("/fonts/")||uri.contains("/checkCodeServlet")){
            //用户想要登录,放行
            chain.doFilter(req, resp);
        }else {
            //需要验证用户是否已经登录
            //从session中获取admin
            Object Admin = request.getSession().getAttribute("admin");
            if (Admin!=null){
                //已经登录,放行
                chain.doFilter(req,resp);
            }else {
                //没有登录,跳转到登录页面
                request.setAttribute("login_msg","您尚未登录,请登录后进行操作!");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }
        }


    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }
}
