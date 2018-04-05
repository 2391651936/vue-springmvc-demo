package smart.application.appoint.models;
/*
人员类别表
 */

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class PeopleType implements Serializable {

    @Getter
    @Setter
    private Integer id;

    /*
    类别名称
     */
    @Getter
    @Setter
    private String name;

    @Override
    public String toString() {
        return "PeopleType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}