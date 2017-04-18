package visitorpatterndemo;

/**
 * Created by ding on 2017/4/18.
 */
public interface Visitable {
    public void accept(Visitor visitor);
}
