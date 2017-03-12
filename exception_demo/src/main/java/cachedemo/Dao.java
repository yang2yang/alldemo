/**
 * ChangCai.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package cachedemo;

/**
 * 简单的dao接口
 * @author dingqingli
 * @version Dao.java, v 0.1 2017/1/24 13:34 dingqingli Exp $
 */
public interface Dao {
    Object select();
    void save(Object object);
}
