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

@WebServlet("/case1")
public class CookieDemo4_Case1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        boolean flag=false;

        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yy年MM月dd日 HH:mm:ss");
        String format = sdf.format(date);

        Cookie[] cookies = request.getCookies();
        if (cookies!=null&&cookies.length!=0){
            for (Cookie cookie : cookies) {
                String name=cookie.getName();

                //判断是否为第一次访问
                if("lastTime".equals(name)){
                    flag=true;
                    //URL编码
                    format= URLEncoder.encode(format,"utf-8");
                    cookie.setValue(format);
                    cookie.setMaxAge(60);
                    response.addCookie(cookie);
                    String value = cookie.getValue();

                    //URL解码
                    value= URLDecoder.decode(value,"utf-8");
                    response.getWriter().write("<h1>欢迎回来，您上次访问时间为:"+value+"</h1>");

                    break;
                }
            }
        }

        if (cookies==null||cookies.length==0||flag==false){
            format= URLEncoder.encode(format,"utf-8");
            Cookie cookie=new Cookie("lastTime",format);
            cookie.setMaxAge(60);
            response.addCookie(cookie);
            response.getWriter().write("<h1>欢迎您首次来到本网站!</h1>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
