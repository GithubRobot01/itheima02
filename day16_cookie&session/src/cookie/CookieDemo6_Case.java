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

@WebServlet("/CookieDemo5")
public class CookieDemo5_Case extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        boolean flag=false;
        Cookie[] cookies = request.getCookies();
        if (cookies!=null&&cookies.length>0){
            for (Cookie cookie : cookies) {
                String name=cookie.getName();
                if ("lastTime".equals(name)){
                    flag=true;

                    String value = cookie.getValue();
                    value= URLDecoder.decode(value,"utf-8");
                    response.getWriter().write("<h1>欢迎回来!您上一次访问的时间为:"+value+"</h1>");

                    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String format = sdf.format(new Date());

                    format = URLEncoder.encode(format,"utf-8");

                    cookie.setValue(format);
                    cookie.setMaxAge(30);
                    response.addCookie(cookie);
                    break;
                }
            }
        }
        if (cookies==null||cookies.length==0||flag==false){
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
            String format = sdf.format(new Date());

            format= URLDecoder.decode(format,"utf-8");

            Cookie c=new Cookie("lastTime",format);
            c.setMaxAge(30);
            response.addCookie(c);
            response.getWriter().write("<h1>欢迎您首次访问!</h1>");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
