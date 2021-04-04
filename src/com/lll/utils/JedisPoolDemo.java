package com.lll.utils;

// JedisPoolConfig

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolDemo {
    public static void main(String[] args) {
//        // 构建连接池配置信息
//        JedisPoolConfig config = new JedisPoolConfig();
//        //最大能够保持idle的数量，控制一个pool最多有多少个状态为idle的jedis实例
//        config.setMaxIdle(50);
//        //在容器中的最小的闲置连接数
//        config.setMinIdle(30);
//        //最大连接数
//        config.setMaxTotal(100);
//        //当连接池内的连接耗尽时，getBlockWhenExhausted为true时，连接会阻塞，超过了阻塞的时间（设定的maxWaitMillis，单位毫秒）时会报错
//        config.setMaxWaitMillis(100*1000);
//        //在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；默认是true
//        config.setTestOnBorrow(true);
//        // 构建连接池
//        JedisPool jedisPool = new JedisPool(config, "127.0.0.1", 6379);
//        // 从连接池中获取连接
//        Jedis jedis = jedisPool.getResource();
        RedisService.initPool();
        Jedis jedis = RedisService.getJedis();
        String name = jedis.get("name");
        if (name == null) {
            System.out.println("redis中没有key为name的数据，将数据存入");
            jedis.set("name", "LiMing");
        } else {
            // 读取数据
            System.out.println("redis中有key为name的数据，为：" + jedis.get("name"));
        }
        // 将连接还回到连接池中
        // 释放连接池
        RedisService.close(jedis);
    }
}
