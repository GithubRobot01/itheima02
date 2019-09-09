package jedis.test;

import jedis.util.JedisPoolUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Jedis连接池的使用
 */
public class JedisPoolDemo {
    @Test
    public void test(){
        //创建配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(50);
        config.setMaxIdle(10);
        //创建Jedis连接池对象
        JedisPool jedisPool = new JedisPool(config,"localhost",6379);
        //获取连接
        Jedis jedis = jedisPool.getResource();
        jedis.set("lala","haha");
        //归还到连接池中
        jedis.close();
    }

    @Test
    public void utilTest(){
        Jedis jedis = JedisPoolUtils.getJedis();
        jedis.set("gender","male");
        String gender = jedis.get("gender");
        System.out.println(gender);
        jedis.close();
    }
}
