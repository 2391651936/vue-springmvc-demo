package smart.application.appoint.models;
/*
违规原因表
 */

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class Violation implements Serializable {

    @Getter
    @Setter
    private Integer id;

    /*
    违规原因名称
     */
    @Getter
    @Setter
    private String name;

    @Override
    public String toString() {
        return "Violation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}