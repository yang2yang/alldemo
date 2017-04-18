package visitorpatterndemo;

import java.util.Collection;

/**
 * Created by ding on 2017/4/18.
 */
public interface Visitor {
    public void visit(StringElement stringE);

    public void visit(FloatElement floatE);

    public void visitCollection(Collection collection);
}
