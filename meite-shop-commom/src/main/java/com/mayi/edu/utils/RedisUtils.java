package com.mayi.edu.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtils {

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    /**
     * 设置数据redis
     */
    public boolean setString2String(String key, String value) {
        if(StringUtils.isEmpty(key) && StringUtils.isEmpty(value)){
            return false;
        }
        boolean result=false;
        try {
            stringRedisTemplate.opsForValue().set(key, value);
            result=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 覆盖数据
     *
     *  使用：template.opsForValue().set("key","hello world");
     template.opsForValue().set("key","redis", 6);
     System.out.println("***************"+template.opsForValue().get("key"));
     结果：***************hello redis
     */
    public boolean setString2over(String key, String value,long offset) {
        if (StringUtils.isEmpty(key) && StringUtils.isEmpty(value)) {
            return false;
        }
        boolean result=false;
        try {
            stringRedisTemplate.opsForValue().set(key, value, offset);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 根据key来获取数据
     */
    public String getString2String(String key) {
        if (StringUtils.isEmpty(key)) {
            return null;
        }
        String str = null;
        try {
            str = stringRedisTemplate.opsForValue().get(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * 根据key删除数据
     * @param key
     * @return
     */
    public boolean del2String(String key) {
        if (StringUtils.isEmpty(key)) {
            return false;
        }
        boolean result = false;
        try {
            redisTemplate.delete(key);
            result=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     *
     * @param key
     * @param value
     * @return
     *
     * TimeUnit是java.util.concurrent包下面的一个类，表示给定单元粒度的时间段
    常用的颗粒度
    TimeUnit.DAYS //天
    TimeUnit.HOURS //小时
    TimeUnit.MINUTES //分钟
    TimeUnit.SECONDS //秒
    TimeUnit.MILLISECONDS //毫秒

    使用：redisTemplate.opsForValue().set("name","tom",10, TimeUnit.SECONDS);
    结果：redisTemplate.opsForValue().get("name")由于设置的是10秒失效，十秒之内查询有结果，十秒之后返回为null
     */


    /**
     * 设置key,value有效时间
     */
    public boolean setString2time(String key, String value,int time) {
        if (StringUtils.isEmpty(key) && StringUtils.isEmpty(value)) {
            return false;
        }
        boolean result=false;
        try {
            stringRedisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            result=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }



    /** 设置键的字符串值并返回其旧值
     *
     *  使用：template.opsForValue().set("getSetTest","test");
     System.out.println(template.opsForValue().getAndSet("getSetTest","test2"));
     结果：test
     */
    public String  getAndSet(String key, String value) {
        if (StringUtils.isEmpty(key) && StringUtils.isEmpty(value)) {
            return null;
        }
        String andSet = null;
        try {
            andSet = stringRedisTemplate.opsForValue().getAndSet(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return andSet;
    }


    /**
     * 设置多个数据
     */
    public boolean  setMapMultiSet(Map<String,String> map) {
        boolean result=false;
        if(map.size()==0){
            return false;
        }
        try {
            stringRedisTemplate.opsForValue().multiSet(map);
            result=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 设置获取多个数据
     * @param keys
     * @return
     */
    public boolean  getMapMulti(List<String> keys) {
        boolean result=false;
        if(keys.size()==0){
            return false;
        }
        try {
            stringRedisTemplate.opsForValue().multiGet(keys);
            result=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * SET设置多个数据
     *
     * @param key
     * @param value
     * @return
     */
    public Long  add(Object key,Object ...value) {
        Long result=null;
        try {
            Long add = redisTemplate.opsForSet().add(key, value);
            result=add;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 移除
     */
    public Long  remove(Object key,Object ...value) {
        Long result=null;
        try {
            Long add = redisTemplate.opsForSet().remove(key, value);
            result=add;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 	判断 member 元素是否是集合 key 的成员
     */
    public boolean  isMember(String key,Object ...value) {
        boolean result=false;
        try {
            Boolean add = redisTemplate.opsForSet().isMember(key, value);
            result=add;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 根据key获取集合所有成员
     */
    public Set<Object> isMember(String key){
        if (StringUtils.isEmpty(key)){
            return null;
        }
        Set<Object> members = null;
        try {
            members = redisTemplate.opsForSet().members(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return members;
    }


    /**
     * 判断key是否存在
     * @param key
     * @return
     */
    public boolean  exitKey(String key){
        boolean  result=false;
        if (StringUtils.isEmpty(key)){
            return result;
        }
        try {
            boolean hasKey= redisTemplate.hasKey(key);
            if (hasKey) {
                result=true;
            } else {
                result=hasKey;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
