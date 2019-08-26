package web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RequestDemo4")
public class RequestDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String referer = request.getHeader("referer");
        System.out.println(referer);
        if (referer!=null){
            if (referer.contains("/day14")){
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("播放电影......");
                //System.out.println("允许访问!");
            }else {
                //盗链
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("禁止观看......");
                //System.out.println("禁止访问!");
            }
        }
    }
}
