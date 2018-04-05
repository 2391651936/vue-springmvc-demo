package smart.application.appoint.models;
/*
信息类别
 */

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class InformationType implements Serializable {

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
        return "InformationType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}