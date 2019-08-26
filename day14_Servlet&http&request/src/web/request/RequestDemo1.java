package web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RequestDemo1")
public class RequestDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求方式
        String method = request.getMethod();
        System.out.println("请求方式:"+method);
        //获取虚拟目录
        String contextPath = request.getContextPath();
        System.out.println("虚拟目录:"+contextPath);
        //获取Servlet路径
        String servletPath = request.getServletPath();
        System.out.println("Servlet路径:"+servletPath);
        //获取请求参数
        String queryString = request.getQueryString();
        System.out.println("请求参数"+queryString);
        //获取请求URI
        String requestURI = request.getRequestURI();
        StringBuffer requestURL = request.getRequestURL();
        System.out.println("请求URI:"+requestURI);
        System.out.println("请求URL:"+requestURL);
        //获取协议及版本
        String protocol = request.getProtocol();
        System.out.println("协议及版本:"+protocol);
        //获取客户机ip
        String remoteAddr = request.getRemoteAddr();
        System.out.println("客户机ip:"+remoteAddr);

    }
}
