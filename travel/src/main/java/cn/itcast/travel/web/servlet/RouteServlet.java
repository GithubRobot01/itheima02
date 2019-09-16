package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.FavoriteService;
import cn.itcast.travel.service.RouteService;
import cn.itcast.travel.service.impl.FavoriteServiceImpl;
import cn.itcast.travel.service.impl.RouteServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/route/*")
public class RouteServlet extends BaseServlet {
    private RouteService routeService=new RouteServiceImpl();
    private FavoriteService favoriteService=new FavoriteServiceImpl();
    //分页查找
    public void pageQuery(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String cidstr = request.getParameter("cid");
        String currentPagestr = request.getParameter("currentPage");
        String pageSizestr = request.getParameter("pageSize");
        //搜索条件
        String rname = request.getParameter("rname");
        //设置默认的当前页与每页条数
        int currentPage=1;
        int pageSize=5;
        int cid=5;
        if (currentPagestr!=null&&currentPagestr.length()>0){
            currentPage=Integer.parseInt(currentPagestr);
        }
        if (pageSizestr!=null&&pageSizestr.length()>0){
            pageSize=Integer.parseInt(pageSizestr);
        }
        if (cidstr!=null&&cidstr.length()>0&&!"null".equals(cidstr)){
            cid=Integer.parseInt(cidstr);
        }
        //<Route>表示List存储类型
        PageBean<Route> pb=routeService.pageQuery(cid,currentPage,pageSize,rname);
        writeValue(pb,response);
    }
    //查找路线详情
    public void findDetail(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取线路id
        String rid = request.getParameter("rid");
        Route route = routeService.findDetail(rid);
        writeValue(route,response);
    }
    //判断是否收藏
    public void isFavorite(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取线路id
        String rid = request.getParameter("rid");
        //获取当前登录用户
        User user = (User) request.getSession().getAttribute("user");
        int uid=0;
        if (user!=null){
            uid=user.getUid();
        }
        boolean flag = favoriteService.isFavorite(rid, uid);
        //写回客户端
        writeValue(flag,response);
    }
    public void addFavorite(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取线路id
        String rid = request.getParameter("rid");
        //获取当前登录用户
        User user = (User) request.getSession().getAttribute("user");
        int uid;
        if (user==null){
            return;
        }else {
            uid=user.getUid();
        }
        favoriteService.addFavorite(rid,uid);
    }
}