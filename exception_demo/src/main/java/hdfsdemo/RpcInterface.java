package hdfsdemo;

/**
 * Created by jack on 2017/8/3.
 */
public interface RpcInterface {

    long versionID = 10010;

    /**
     * 一个普通的借口
     * @param s
     * @return
     */
    String saySomething(String s);
}
