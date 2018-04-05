package smart.application.appoint.models;
/*
设备类别表
 */

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class EquipmentType implements Serializable {

    @Getter
    @Setter
    private Integer id;

    /*
    设备类别名称
     */
    @Getter
    @Setter
    private String name;

    @Override
    public String toString() {
        return "EquipmentType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}