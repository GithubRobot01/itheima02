package day23.servlet;

import day23.service.ProvinceService;
import day23.service.ProvinceServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findProvinceServlet")
public class FindProvinceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用service层查询数据
        ProvinceService service=new ProvinceServiceImpl();
        String json = service.findAllJson();
        /*List<Province> list = service.findAll();
        ObjectMapper mapper=new ObjectMapper();
        //将查询到的list集合装换为json格式的字符串
        String json = mapper.writeValueAsString(list);*/
        response.setContentType("application/json;charset=utf-8");
        //将数据发送给服务器
        response.getWriter().write(json);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
