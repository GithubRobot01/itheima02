package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Route;

import java.util.List;

public interface RouteDao {
    //查找总记录数
    int findTotalCount(int cid, String rname);
    //查找当前页的数据
    List<Route> findByPage(int cid, int start, int pageSize, String rname);
    //根据rid查找线路详情
    Route findRoute(int rid);
}
