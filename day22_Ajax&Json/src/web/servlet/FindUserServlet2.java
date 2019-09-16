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

@WebServlet("/findUserServlet2")
public class FindUserServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        String username = request.getParameter("username");
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> map=new HashMap<String, Object>();
        if ("wqs".equals(username)||"wzy".equals(username)){
            map.put("userExist",true);
            map.put("msg","用户名太受欢迎了,请换一个");
        }else {
            map.put("userExist",false);
            map.put("msg","用户名可用");
        }
        mapper.writeValue(response.getWriter(),map);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
