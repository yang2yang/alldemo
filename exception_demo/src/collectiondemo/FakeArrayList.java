package collectiondemo;

import sun.invoke.empty.Empty;

/**
**  author:jack 2017年02月2017/2/28日
*/
public class FakeArrayList {
    /**
     * Shared empty array instance used for empty instances.
     */
    private static final Object[] EMPTY_ELEMENTDATA = {};

    /**
     * Shared empty array instance used for default sized empty instances. We
     * distinguish this from EMPTY_ELEMENTDATA to know how much to inflate when
     * first element is added.
     */
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    /**
     * The array buffer into which the elements of the ArrayList are stored.
     * The capacity of the ArrayList is the length of this array buffer. Any
     * empty ArrayList with elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA
     * will be expanded to DEFAULT_CAPACITY when the first element is added.
     */
    transient Object[] elementData;

    public FakeArrayList(){
        elementData = EMPTY_ELEMENTDATA;
    }

    public static void main(String[] args) {
        FakeArrayList fakeArrayList = new FakeArrayList();
        if(fakeArrayList.elementData == fakeArrayList.EMPTY_ELEMENTDATA){
            System.out.println(11);
        }
        if(fakeArrayList.elementData == fakeArrayList.DEFAULTCAPACITY_EMPTY_ELEMENTDATA){
            System.out.println(22);
        }
    }
}
