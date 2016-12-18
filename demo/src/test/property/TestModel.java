package property;

import java.util.Date;

/**
 * *  author:jack 2016年12月2016/12/17日
 */
public class TestModel {
    private int age;
    private Date birth;
    private String name;
    private boolean good;
    private long times;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGood() {
        return good;
    }

    public void setGood(boolean good) {
        this.good = good;
    }

    public long getTimes() {
        return times;
    }

    public void setTimes(long times) {
        this.times = times;
    }

    public String toString(){
        return "age = "+this.getAge()+" birth = "+this.getBirth()+" name = "+this.getName()+" times = "+this.getTimes()+" good = "+this.isGood();
    }
}
