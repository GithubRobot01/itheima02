package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/CookieDemo6")
public class CookieDemo6_Case extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        Cookie[] cookies = request.getCookies();
        Cookie c=null;
        if (cookies!=null&&cookies.length>0){
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if ("lastTime".equals(name)){
                    c=cookie;
                    break;
                }
            }
        }

        if (c!=null){
            String value = c.getValue();
            value= URLDecoder.decode(value,"utf-8");
            response.getWriter().write("欢迎再来!您上次访问的时间为:"+value);
        }else {
            response.getWriter().write("欢迎新用户!");
        }

        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String format = sdf.format(date);
        format=URLEncoder.encode(format,"utf-8");
        Cookie cookie=new Cookie("lastTime",format);
        response.addCookie(cookie);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
