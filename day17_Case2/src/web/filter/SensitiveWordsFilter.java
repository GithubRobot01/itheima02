package web.filter;

import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@WebFilter("/*")
public class SensitiveWordsFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //创建代理对象,增强getParameter方法
        ServletRequest proxy_req = (ServletRequest) Proxy.newProxyInstance(req.getClass().getClassLoader(), req.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] args) throws Throwable {
                //判断是否是getParameter方法
                if ((method.getName()).equals("getParameter")){
                    //增强返回值
                    String para = (String) method.invoke(req, args);
                    if (para!=null){
                        for (String str : list) {
                            if (para.contains(str)){
                                para=para.replaceAll(str,"**");
                            }
                        }
                    }
                    return para;
                }
                return method.invoke(req,args);
            }
        });
        //放行
        chain.doFilter(proxy_req, resp);

    }
    private List<String> list=new ArrayList<>(); //敏感词汇集合

    public void init(FilterConfig config) throws ServletException {
        try {
            ServletContext servletContext = config.getServletContext();
            String realPath = servletContext.getRealPath("/WEB-INF/classes/敏感词汇.txt");
            BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(new File(realPath)),"utf-8"));
            String line=null;
            while ((line=br.readLine())!=null){
                list.add(line);
            }
            br.close();
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
    }
}
