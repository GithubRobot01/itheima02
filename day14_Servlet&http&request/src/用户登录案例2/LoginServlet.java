package 用户登录案例2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);

        //System.out.println(user);

        UserDao dao=new UserDao();
        //将输入的信息封装为User对象,调用UserDao类中的login方法
        //如果存在相应的用户信息则返回,否则返回为空
        User user1 = dao.login(user);
        if (user1==null){
            request.getRequestDispatcher("/FailServlet1").forward(request, response);
        }else {
            request.setAttribute("user",user1);
            request.getRequestDispatcher("/SuccessServlet").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
