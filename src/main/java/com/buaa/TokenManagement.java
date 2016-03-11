package com.buaa;

import com.buaa.utils.JedisUtills;
import redis.clients.jedis.Jedis;

/**
 * Created by stupid-coder on 3/10/16.
 */
public class TokenManagement {

    public static void Put(String key, String value) {
        Jedis jedis = JedisUtills.getReids();
        jedis.set(key,value);
        JedisUtills.returnRedis(jedis);

    }

    public static void Put(String key, String value, Integer timeout) {
        Jedis jedis = JedisUtills.getReids();
        jedis.set(key,value);
        jedis.expire(key,timeout);
        JedisUtills.returnRedis(jedis);
    }

    public static void Expire(String key, Integer timeout) {
        Jedis jedis = JedisUtills.getReids();
        jedis.expire(key,timeout);
        JedisUtills.returnRedis(jedis);
    }

    public static String Get(String key) {
        Jedis jedis = JedisUtills.getReids();
        String value = jedis.get(key);
        JedisUtills.returnRedis(jedis);
        return value;
    }

    public static String GetAndDel(String key) {
        Jedis jedis = JedisUtills.getReids();
        String value = jedis.get(key);
        jedis.del(key);
        JedisUtills.returnRedis(jedis);
        return value;
    }

    public static void Del(String key) {
        Jedis jedis = JedisUtills.getReids();
        jedis.del(key);
        JedisUtills.returnRedis(jedis);
    }
}
