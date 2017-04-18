package visitorpatterndemo;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by ding on 2017/4/18.
 */
public class Test {
    public static void main(String[] args) {
        Visitor visitor = new ConcreteVisitor();

        StringElement stringE = new StringElement("I am a String");
        visitor.visit(stringE);

        Collection list = new ArrayList();
        list.add(new StringElement("I am a String1"));
        list.add(new StringElement("I am a String2"));
        list.add(new FloatElement(new Float(12)));
        list.add(new StringElement("I am a String3"));
        visitor.visitCollection(list);
    }
}
