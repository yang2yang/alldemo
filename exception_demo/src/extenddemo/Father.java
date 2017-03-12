package extenddemo;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
**  author:jack 2017年03月2017/3/9日
*/
public class Father {

    public String value = "fathervalue";

    public void printFather(){
        System.out.println("Father");
    }

    public void fatherNoExtend(){
        System.out.println("NoExtend");
    }
}
