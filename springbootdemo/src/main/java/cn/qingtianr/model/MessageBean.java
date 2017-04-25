package cn.qingtianr.model;

/**
 * Created by ding on 2017/4/25.
 */

/**
 * Json返回值
 */
public class MessageBean {

    /**
     * 状态
     */
    private boolean success;

    /**
     * 提示说明
     */
    private String message;

    /**
     * 内容
     */
    private Object content;

    public MessageBean(){

    }

    public MessageBean(boolean success){
        this.success = success;
    }

    public MessageBean(boolean success, String message){
        this.success = success;
        this.message = message;
    }


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
