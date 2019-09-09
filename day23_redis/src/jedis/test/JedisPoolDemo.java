package jedis.test;

import org.junit.Test;

/**
 * Jedis连接池的使用
 */
public class JedisPool {
    @Test
    public void test(){
        JedisPool jedisPool = new JedisPool();
        jedisPool.getResource();
    }
}
