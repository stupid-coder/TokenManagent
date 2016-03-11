package com.buaa.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

/**
 * Created by stupid-coder on 3/10/16.
 */
public class JedisUtills {

    private static JedisPool jedisPool;

    static {
        JedisPoolConfig config = new JedisPoolConfig();

        try {
            ResourceBundle bundle = ResourceBundle.getBundle("jedis");
            config.setMaxTotal(Integer.valueOf(bundle.getString("redis.pool.maxActive")));
            config.setMaxIdle(Integer.valueOf(bundle.getString("redis.pool.maxIdle")));
            config.setMaxWaitMillis(Integer.valueOf(bundle.getString("redis.pool.maxWait")));
            config.setTestOnBorrow(Boolean.valueOf(bundle.getString("redis.pool.testOnBorrow")));
            config.setTestOnReturn(Boolean.valueOf(bundle.getString("redis.pool.testOnReturn")));
            jedisPool = new JedisPool(config, bundle.getString("redis.ip"), Integer.valueOf(bundle.getString("redis.port")));
        } catch ( Exception ex ) {
            System.out.print("failure init jedis properties");
        }
    }

    public static Jedis getReids() {
        if ( jedisPool != null && !jedisPool.isClosed() ) {
            return jedisPool.getResource();
        } else {
            return null;
        }
    }

    public static void returnRedis(Jedis redis) {
        if ( jedisPool != null && !jedisPool.isClosed() ) {
            jedisPool.returnResource(redis);
        }
    }

}
