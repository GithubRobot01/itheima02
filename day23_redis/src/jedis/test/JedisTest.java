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
        Jedis jedis=new Jedis("localhost", 6379);
        jedis.set("username","zhangsan");
        jedis.close();
    }
    @Test
    public void test2(){
        //String数据结构操作
        Jedis jedis=new Jedis();
        jedis.set("username","zhangsan");
        String username = jedis.get("username");
        jedis.setex("hsg",20,"hsg");
        System.out.println(username);
        jedis.close();
    }
    @Test
    public void test3(){
        //获取连接
        Jedis jedis=new Jedis();
        jedis.hset("user","name","wqs");
        jedis.hset("user","pass","123456");
        jedis.hset("user","age","23");
        Map<String, String> map = jedis.hgetAll("user");
        Set<String> set = map.keySet();
        for (String s : set) {
            System.out.println(s+"->"+map.get(s));
        }
        jedis.close();
    }
    @Test
    public void test4(){
        //获取连接
        Jedis jedis=new Jedis();
        jedis.lpush("mylist","2","1");
        jedis.rpush("mylist","3");
        List<String> mylist = jedis.lrange("mylist", 0, -1);
        System.out.println(mylist);
        System.out.println(jedis.lpop("mylist"));
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
