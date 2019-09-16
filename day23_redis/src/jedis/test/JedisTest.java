package jedis.test;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Jedis的测试类
 */
public class JedisTest {
    @Test
    public void test1(){
        //获取连接
        Jedis jedis=new Jedis();
        jedis.set("username","wqs");
        String username = jedis.get("username");
        System.out.println(username);
        jedis.close();
    }
    @Test
    public void test2(){
        //String数据结构操作
        Jedis jedis=new Jedis();
        jedis.setex("code",20,"643925");
        jedis.close();
    }
    @Test
    public void test3(){
        //获取连接
        Jedis jedis=new Jedis();
        jedis.hset("user","name","wqs");
        jedis.hset("user","age","23");
        jedis.hset("user","gender","male");
        Map<String, String> map = jedis.hgetAll("user");
        Set<String> set = map.keySet();
        for (String key : set) {
            String value=map.get(key);
            System.out.println(key+"->"+value);
        }
        jedis.close();
    }
    @Test
    public void test4(){
        //获取连接
        Jedis jedis=new Jedis();
        jedis.lpush("list","a","b","c");
        jedis.rpush("list","a","b","c");
        List<String> list = jedis.lrange("list", 0, -1);
        System.out.println(list);
        jedis.close();
    }
    @Test
    public void test5(){
        //获取连接
        Jedis jedis=new Jedis();
        jedis.sadd("myset","a","b","a","c");
        Set<String> myset = jedis.smembers("myset");
        System.out.println(myset);
        jedis.close();
    }
    @Test
    public void test6(){
        //获取连接
        Jedis jedis=new Jedis();
        jedis.zadd("mysort",100,"wzy");
        jedis.zadd("mysort",99,"wqs");
        jedis.zadd("mysort",98,"dl");
        Set<String> mysort = jedis.zrange("mysort", 0, -1);
        System.out.println(mysort);
        jedis.close();
    }
}
