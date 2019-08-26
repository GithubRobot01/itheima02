package web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ResponseDemo3")
public class ResponseDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //告诉浏览器,服务器发送的消息体数据的编码.建议浏览器使用该编码解码
        //response.setHeader("content-type","text/html;charset=utf-8");
        //简单的形式,设置编码
        response.setContentType("text/html;charset=utf-8" );

        //获取字符输出流
        PrintWriter pw = response.getWriter();
        //输出数据
        pw.write("<font color='red' size='10px'>你好!</font>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
