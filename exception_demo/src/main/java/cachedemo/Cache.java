/**
 * ChangCai.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package cachedemo;

import java.util.HashMap;
import java.util.Map;

/**
 * 缓存实现类
 * @author dingqingli
 * @version Cache.java, v 0.1 2017/1/24 13:35 dingqingli Exp $
 */
public class Cache {
    private static final Map<String,Object> cache = new HashMap<>();

    /**
     * 把对象添加到缓存中去
     * @param key
     * @param value
     */
    public void checkIn(String key,Object value){
        if(!cache.containsKey(key)){
            cache.put(key,value);
        }
    }

    /**
     * 从缓存中找对象
     * @param key
     * @return
     */
    public Object checkOut(String key){
        if(cache.containsKey(key)){
            return cache.get(key);
        }
        return null;
    }

    /**
     * 在方法执行前清除缓存
     */
    public void clearCacheBeforeMethod(){
        cache.clear();
    }

    /**
     * 在方法执行后清除缓存
     */
    public void clearCacheAfterMethod(){
        cache.clear();
    }
}
