package day16;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获取表单中输入的数据
        String checkCode=request.getParameter("checkCode");

        /*String username = request.getParameter("username");
        String password=request.getParameter("password");

        User user=new User();
        user.setUsername(username);
        user.setPassword(password);*/

        Map<String, String[]> map = request.getParameterMap();
        User user=new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        UserDao dao=new UserDao();
        //在数据库中查询用户信息,查询成功返回用户信息,否则返回null
        User loginuser = dao.login(user);
        //获取随机生成的验证码
        String yzm = (String) request.getSession().getAttribute("yzm");
        if (loginuser==null){ //用户名错误
            request.setAttribute("name_error","用户名错误!");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }else {
            if (!(loginuser.getPassword().equals(user.getPassword()))){ //密码错误
                request.setAttribute("pass_error","密码错误!");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }else {
                if (yzm.equalsIgnoreCase(checkCode)){
                    request.setAttribute("user",user);
                    request.getRequestDispatcher("success.jsp").forward(request,response);
                }else {
                    request.setAttribute("cc_error","验证码错误");
                    request.getRequestDispatcher("/login.jsp").forward(request,response);
                }
            }
        }

        /*if (yzm.equalsIgnoreCase(checkCode)){
            if (loginuser!=null){
                //todo
                request.setAttribute("username",loginuser.getUsername());
                request.getRequestDispatcher("/success.jsp").forward(request,response);
            }else {
                request.setAttribute("login_error","用户名或密码错误!");
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }
        }else {
            request.setAttribute("cc_error","验证码错误!");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }*/
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
