package visitorpatterndemo;

/**
 * Created by ding on 2017/4/18.
 */
public class StringElement implements Visitable {

    private String value;

    public StringElement(String string) {
        value = string;
    }

    public String getValue() {
        return value;
    }

    //定义accept的具体内容 这里是很简单的一句调用
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
