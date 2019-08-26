package web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/RequestDemo6")
public class RequestDemo6 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*String username = request.getParameter("username");
        System.out.println("post");
        System.out.println(username);*/

        /*String[] hobbies = request.getParameterValues("hobby");
        for (String hobby : hobbies) {
            System.out.println(hobby);
        }*/

        /*Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()){
            String name=parameterNames.nextElement();
            String value=request.getParameter(name);
            System.out.println(name+"->"+value);
        }
        System.out.println("-----------------");*/

        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<String> keyset = parameterMap.keySet();
        for (String s : keyset) {
            String[] values = parameterMap.get(s);
            for (int i = 0; i < values.length; i++) {
                System.out.println(s+"->"+values[i]);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        System.out.println("get");
        System.out.println(username);
    }
}
