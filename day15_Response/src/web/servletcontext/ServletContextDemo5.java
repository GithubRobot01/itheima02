package web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servletContextDemo5")
public class ServletContextDemo5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //通过HttpServlet获取
        ServletContext context = this.getServletContext();
        //获取文件的服务器路径
        String realPathb = context.getRealPath("/b.txt"); //web目录下的资源访问
        System.out.println(realPathb);
        String realPathc = context.getRealPath("/WEB-INF/c.txt"); //WEB-INF目录下的资源访问
        System.out.println(realPathc);
        String realPatha = context.getRealPath("/WEB-INF/classes/a.txt");//src目录下的资源访问
        System.out.println(realPatha);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
