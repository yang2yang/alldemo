package visitorpatterndemo;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by ding on 2017/4/18.
 */
public class ConcreteVisitor implements Visitor {
    //在本方法中,我们实现了对Collection的元素的成功访问
    public void visitCollection(Collection collection) {
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            //这里取出来元素的时候还是一个Object,之后在下面的一步中将Object转换为Visitable对象
            Object o = iterator.next();
            if (o instanceof Visitable)
                ((Visitable) o).accept(this);
        }
    }

    public void visit(StringElement stringE) {
        System.out.println("'" + stringE.getValue() + "'");
    }

    public void visit(FloatElement floatE) {
        System.out.println(floatE.getValue().toString() + "f");
    }
}
