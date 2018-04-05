package smart.application.appoint.models;
/*
设备参数表
 */

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class EquipmentParam implements Serializable {

    @Getter
    @Setter
    private Integer id;

    /*
    所属设备
     */
    @Getter
    @Setter
    private Equipment equipment;

    /*
    key 值
     */
    @Getter
    @Setter
    private String key;

    /*
    value 值
     */
    @Getter
    @Setter
    private String value;

    /*
    是否可用
     */
    @Getter
    @Setter
    private Boolean isUse;

    @Override
    public String toString() {
        return "EquipmentParam{" +
                "id=" + id +
                ", equipment=" + equipment +
                ", key='" + key + '\'' +
                ", value='" + value + '\'' +
                ", isUse=" + isUse +
                '}';
    }
}