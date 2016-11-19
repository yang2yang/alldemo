package cn.qingtianr.demo.service;

import org.springframework.stereotype.Service;

/**
 * Hessian的接口，定义在这个包中其实不是很好
**  author:jack 2016年11月2016/11/19日
*/
@Service
public interface SpitterService {
    /**
     * 返回一个字符串
     * @return
     */
    String SayHello();
}
