package kafkademo;

/**
 * Created by jack on 2018/3/13.
 */
public class Stats {

    private Long currentTime;

    private Long messageNumber;

    public Stats(Long currentTime,Long messageNumber) {
        this.currentTime = currentTime;
        this.messageNumber = messageNumber;
    }

    public Long getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Long currentTime) {
        this.currentTime = currentTime;
    }

    public Long getMessageNumber() {
        return messageNumber;
    }

    public void setMessageNumber(Long messageNumber) {
        this.messageNumber = messageNumber;
    }
}
