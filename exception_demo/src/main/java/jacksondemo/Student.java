package jacksondemo;

import java.util.Date;

/**
 * Created by ding on 2017/4/26.
 */
public class Student {
    private int id;
    private String name;
    private Date birthDay;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public String toString() {
        return "Student [birthDay=" + birthDay + ", id=" + id + ", name="
                + name + "]";
    }

}
