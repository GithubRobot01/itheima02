package session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/SessionDemo3")
public class SessionDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        System.out.println(session);
        //创建Cookie,键为JSESSIONID,设置最大存活时间,让cookie持久化保存
        //此时客户端关闭,服务器不关闭,两次获取的session为同一个
        Cookie c=new Cookie("JSESSIONID",session.getId());
        c.setMaxAge(30);
        response.addCookie(c);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
