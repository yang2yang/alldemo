/**
 * ChangCai.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package cachedemo;

/**
 * @author dingqingli
 * @version DaoProxy.java, v 0.1 2017/1/24 13:35 dingqingli Exp $
 */
public class DaoProxy implements Dao{

    private Cache cache;

    private Dao daoImpl;

    @Override
    public Object select() {
        Object obj = cache.checkOut("DaoProxy.select");
        boolean hasCache = false;

        if(obj != null){
            hasCache = true;
            return obj;
        }

        obj = daoImpl.select();

        if(!hasCache){
            cache.checkIn("DaoProxy.select",obj);
        }
        return obj;
    }

    /**
     * 为什么这个save要在执行方法之前和执行方法之后都要清除缓存啊?
     * @param object
     */
    @Override
    public void save(Object object) {
        //在执行方法前清除缓存
        cache.clearCacheBeforeMethod();
        daoImpl.save(object);
        //在执行方法后清除缓存
        cache.clearCacheAfterMethod();
    }

    public void setCache(Cache cache) {
        this.cache = cache;
    }

    public void setDaoImpl(Dao daoImpl) {
        this.daoImpl = daoImpl;
    }
}
