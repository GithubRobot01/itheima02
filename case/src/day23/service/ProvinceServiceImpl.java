package day23.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import day23.dao.ProvinceDao;
import day23.dao.ProvinceDaoImpl;
import day23.domain.Province;
import day23.util.JedisUtils;
import redis.clients.jedis.Jedis;

import java.util.List;

public class ProvinceServiceImpl implements ProvinceService{
    private ProvinceDao dao=new ProvinceDaoImpl();
    @Override
    public List<Province> findAll() {
        return dao.findAll();
    }

    public String findAllJson(){
        Jedis jedis = JedisUtils.getJedis();
        String province_json = null;
        //从缓存中取出键为province的数据
        province_json = jedis.get("province");
        //缓存中不存在键为province的数据
        if (province_json==null||province_json.length()==0){
            System.out.println("缓存中无数据...");
            //从数据库中取出数据
            List<Province> list = dao.findAll();
            ObjectMapper mapper=new ObjectMapper();
            try {
                province_json = mapper.writeValueAsString(list);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            //将province及数据存入缓存
            jedis.set("province",province_json);
        }else {
            System.out.println("缓存中有数据...");
        }
        jedis.close();

        return province_json;
    }
}
