package jedis.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * JedisPool工具类
 * 加载配置文件,配置连接池的参数
 * 提供获取连接的方法
 */

public class JedisPoolUtils {
    private static JedisPool jedisPool;
    static {
        Properties prop=new Properties();
        //读取配置文件
        InputStream is = JedisPoolUtils.class.getClassLoader().getResourceAsStream("jedis.properties");
        try {
            prop.load(is);
        } catch (IOException e) {
            //e.printStackTrace();
        }
        //获取数据,设置到JedisPoolConfig
        JedisPoolConfig config=new JedisPoolConfig();
        config.setMaxTotal(Integer.parseInt(prop.getProperty("maxTotal")));
        config.setMaxIdle(Integer.parseInt(prop.getProperty("maxIdle")));
        //初始化JedisPool
        jedisPool=new JedisPool(config,prop.getProperty("host"), Integer.parseInt(prop.getProperty("port")));
    }

    public static Jedis getJedis(){
        return jedisPool.getResource();
    }
}