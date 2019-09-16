package day23.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JedisUtils {
    private static JedisPool jedisPool;
    static {
        Properties prop=new Properties();
        InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("jedis.properties");
        try {
            prop.load(is);
            JedisPoolConfig config=new JedisPoolConfig();
            config.setMaxTotal(Integer.parseInt(prop.getProperty("maxTotal")));
            config.setMaxIdle(Integer.parseInt(prop.getProperty("maxIdle")));
            jedisPool=new JedisPool(config,prop.getProperty("host"), Integer.parseInt(prop.getProperty("port")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Jedis getJedis(){
        return jedisPool.getResource();
    }

}
