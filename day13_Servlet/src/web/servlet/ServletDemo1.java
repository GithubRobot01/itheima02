package web.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/demo1")
public class ServletDemo1 implements Servlet {
    /**
     * 初始化方法
     * 在Servlet被创建是,执行.只会执行一次
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    /**
     * 获取ServletConfig对象--Servlet的配置对象
     * @return
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 提供服务方法
     * 每一次Servlet被访问时,执行.执行多次
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Servlet3.0...");
    }

    /**
     * 获取Servlet的一些信息,版本,作者等待...
     * @return
     */
    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     *销毁方法
     * 在服务器正常关闭时执行一次
     */
    @Override
    public void destroy() {

    }
}
