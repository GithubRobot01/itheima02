package web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 重定向
 */

@WebServlet("/ResponseDemo1")
public class ResponseDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Demo1被访问...");

        /*

        //访问/responseDemo,会自动跳转到/responDemo2资源
        //1.设置状态码为302
        response.setStatus(302);
        //设置响应头location
        response.setHeader("location","/day15/ResponseDemo2");

        */

        String contextPath = request.getContextPath();
        //简单的重定向方法
        response.sendRedirect(contextPath+"/ResponseDemo2");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
