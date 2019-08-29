package case_checkcode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String checkCode = request.getParameter("checkCode");

        HttpSession session = request.getSession();
        String yzm = (String) session.getAttribute("yzm");
        session.removeAttribute("ysm");
        //验证码是否正确,忽略大小写
        if (yzm!=null&&yzm.equalsIgnoreCase(checkCode)){
            if ("wqs".equals(username)&&"123456".equals(password)){
                //重定向
                request.setAttribute("username",username);
                request.getRequestDispatcher("/success.jsp").forward(request,response);
                //response.sendRedirect(request.getContextPath()+"/success.jsp");
            }else {
                request.setAttribute("login_error","用户名或密码错误!");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }

        }else {
            request.setAttribute("cc_error","验证码错误!");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
