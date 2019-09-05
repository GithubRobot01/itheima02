package web.filter;

import javax.servlet.*;
import java.io.IOException;
//浏览器直接请求index.jsp资源时,该过滤器会被执行
//@WebFilter(value ="/hello.jsp",dispatcherTypes = DispatcherType.REQUEST)
//只有转发访问index时,该过滤器才会被执行
//@WebFilter(value = "/hello.jsp",dispatcherTypes = DispatcherType.FORWARD)
//@WebFilter(value = "/*",dispatcherTypes = {DispatcherType.FORWARD,DispatcherType.REQUEST})
public class FilterDemo4 implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("filterDemo4...");

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {
    }
}
