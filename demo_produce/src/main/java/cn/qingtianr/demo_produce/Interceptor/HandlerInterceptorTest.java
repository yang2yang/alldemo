/**
 * ChangCai.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package cn.qingtianr.demo_produce.Interceptor;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author dingqingli
 * @version HandlerInterceptorTest.java, v 0.1 2017/1/12 15:05 dingqingli Exp $
 */
//@Service
public class HandlerInterceptorTest extends HandlerInterceptorAdapter{

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("===========HandlerInterceptor1 preHandle");
        return true;
    }

}
