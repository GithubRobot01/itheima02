package web.filter;

import javax.servlet.*;
import java.io.IOException;

//@WebFilter("/*")
public class FilterDemo2 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        System.out.println("filterDemo2被执行了...");

        //放行
        chain.doFilter(req, resp);

        System.out.println("filterDemo2又被执行了...");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
