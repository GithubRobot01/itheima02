package web.request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RequestDemo8")
public class RequestDemo8 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //请求转发
        System.out.println("demo8被访问了...");
        //存储数据到request域中
        request.setAttribute("msg","hello");
        //转发到demo9资源
        /*RequestDispatcher requestDispatcher = request.getRequestDispatcher("/RequestDemo9");
        requestDispatcher.forward(request,response);*/
        request.getRequestDispatcher("/RequestDemo9").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       this.doPost(request,response);
    }
}
