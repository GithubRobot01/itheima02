package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CookieDemo3")
public class CookieDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.创建cookie对象
        Cookie c1 = new Cookie("msg", "hello");
        //将cookie持久化到硬盘,30秒后会自动删除cookie文件
        c1.setMaxAge(30);
        Cookie c2 = new Cookie("name", "wqs");
        c2.setMaxAge(-1);
        Cookie c3 = new Cookie("gender", "male");
        c3.setMaxAge(0);
        //2.发送Cookie
        response.addCookie(c1);
        response.addCookie(c2);
        response.addCookie(c3);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
