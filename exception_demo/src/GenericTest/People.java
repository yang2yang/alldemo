/**
 * ChangCai.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package GenericTest;


import java.util.List;

/**
 * @author dingqingli
 * @version People.java, v 0.1 2017/1/10 12:51 dingqingli Exp $
 */
public class People implements PeopeoInterface{
    private String name;
    private Integer age;
    private List<Integer> years;

    public String toString(){
        return this.name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Integer> getYears() {
        return years;
    }

    public void setYears(List<Integer> years) {
        this.years = years;
    }
}
