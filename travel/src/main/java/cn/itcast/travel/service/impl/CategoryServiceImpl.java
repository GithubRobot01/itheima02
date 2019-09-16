package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.CategoryDao;
import cn.itcast.travel.dao.impl.CategoryDaoImpl;
import cn.itcast.travel.domain.Category;
import cn.itcast.travel.service.CategoryService;
import cn.itcast.travel.util.JedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CategoryServiceImpl implements CategoryService {
    private CategoryDao dao=new CategoryDaoImpl();
    @Override
    public List<Category> findAll() {
        return dao.findAll();
    }

    @Override
    public List<Category> findJson() {
        Jedis jedis = JedisUtil.getJedis();
        List<Category> list=null;
        //从redis中查询是否有category
        Set<Tuple> categorys = jedis.zrangeWithScores("category", 0, -1);
        //缓冲中没有数据
        if (categorys==null||categorys.size()==0){
            System.out.println("从数据库中查询...");
            list = findAll();
            for (int i = 0; i < list.size(); i++) {
                jedis.zadd("category",list.get(i).getCid(),list.get(i).getCname());
            }
        }else {
            System.out.println("从缓存中查询...");
            //缓存中有数据
            list=new ArrayList<>();
            for (Tuple tuple : categorys) {
                Category c=new Category();
                c.setCid((int) tuple.getScore());
                c.setCname(tuple.getElement());
                list.add(c);
            }
            /*Iterator<Tuple> iterator=categorys.iterator();
            while (iterator.hasNext()){
                Tuple tuple = iterator.next();
                int cid= (int) tuple.getScore();
                String cname=tuple.getElement();
                Category c=new Category();
                c.setCid(cid);
                c.setCname(cname);
                list.add(c);
            }*/
        }
        return list;
    }

}
