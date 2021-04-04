package com.lll.utils;

import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.cache.CacheException;
import org.apache.log4j.Logger;
import redis.clients.jedis.Jedis;

import java.io.Serializable;
import java.util.Properties;
import java.util.concurrent.locks.ReadWriteLock;

public class RedisCache implements Cache {

    private final String redisIp = PropertiesUtils.getProperty("redis.host");
    private final int redisPort = Integer.valueOf(PropertiesUtils.getProperty("redis.port")).intValue();

    private final String id;

    private Jedis cache = new Jedis(redisIp, redisPort);

    public RedisCache(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    //返回缓存所有键值对的数量
    public int getSize() {
        Long dbSize = cache.dbSize();
        return dbSize.intValue();
    }

    @Override
    //向缓存中存入数据
    public void putObject(Object key, Object value) {
        System.out.println("key:" + key);
        //将对象序列化成字节数组  引入commens-lang3工具包
        byte[] keyBs = SerializeUtils.serialize((Serializable) key);
        byte[] valueBs = SerializeUtils.serialize((Serializable) value);

        cache.set(keyBs, valueBs);
    }

    @Override
    //从缓存中获取数据
    public Object getObject(Object key) {
        byte[] keyBs = SerializeUtils.serialize((Serializable) key);
        byte[] valueBs = cache.get(keyBs);
        if (valueBs != null) { // 第一次到缓存找数据的时候 , 返回的是null
            return SerializeUtils.unserialize(valueBs);
        }
        return null;
    }

    @Override
    //清除缓存
    public Object removeObject(Object key) {
        // 先获取一下删除的对象
        byte[] keyBs = SerializeUtils.serialize((Serializable) key);
        byte[] valueBs = cache.get(keyBs);
        Object obj = SerializeUtils.unserialize(valueBs);
        cache.del(keyBs);// 执行删除操作
        return obj;
    }

    @Override
    //清空缓存
    public void clear() {
        cache.flushDB();
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (getId() == null) {
            throw new CacheException("Cache instances require an ID.");
        }
        if (this == o) {
            return true;
        }
        if (!(o instanceof Cache)) {
            return false;
        }

        Cache otherCache = (Cache) o;
        return getId().equals(otherCache.getId());
    }

    @Override
    public int hashCode() {
        if (getId() == null) {
            throw new CacheException("Cache instances require an ID.");
        }
        return getId().hashCode();
    }

}