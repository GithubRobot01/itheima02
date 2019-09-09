package web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        String username = request.getParameter("username");
        Map<String,Object> map=new HashMap<>();

        if ("rose".equals(username)||"jack".equals(username)){
            map.put("userExsit",true);
            map.put("msg","此用户名太受欢迎,请更换一个");
        }else {
            map.put("userExsit",false);
            map.put("msg","此用户名可用");
        }
        ObjectMapper mapper = new ObjectMapper();
        //将map转为json,并且传递给客户端
        mapper.writeValue(response.getWriter(),map);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
