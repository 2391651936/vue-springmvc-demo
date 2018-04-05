package smart.application.appoint.models;
/*
设备表
 */

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

public class Equipment implements Serializable {

    @Getter
    @Setter
    private Integer id;

    /*
    所属类别
     */
    @Getter
    @Setter
    private EquipmentType equipmentType;

    /*
    检修人员
     */
    @Getter
    @Setter
    private People overhaulPeople;

    /*
    联系人
     */
    @Getter
    @Setter
    private People contactPeople;

    /*
    设备名称
     */
    @Getter
    @Setter
    private String name;

    /*
    设备特点
     */
    @Getter
    @Setter
    private String characteristic;

    /*
    设备用途
     */
    @Getter
    @Setter
    private String purpose;

    /*
    注意事项
     */
    @Getter
    @Setter
    private String beCareful;

    /*
    图片路径
     */
    @Getter
    @Setter
    private String imageUrl;

    /*
    生产厂家
     */
    @Getter
    @Setter
    private String manufacturer;

    /*
    设备型号
     */
    @Getter
    @Setter
    private String model;

    /*
    购买时间
     */
    @Getter
    @Setter
    private Date buyTime;

    /*
    共享方式
     */
    @Getter
    @Setter
    private Boolean shareWay;

    /*
    是否检修
     */
    @Getter
    @Setter
    private Boolean isOverhaul;

    /*
    是否可以预约
     */
    @Getter
    @Setter
    private Boolean isApplay;

    /*
    是否可用
     */
    @Getter
    @Setter
    private Boolean isUse;

    @Override
    public String toString() {
        return "Equipment{" +
                "id=" + id +
                ", equipmentType=" + equipmentType +
                ", overhaulPeople=" + overhaulPeople +
                ", contactPeople=" + contactPeople +
                ", name='" + name + '\'' +
                ", characteristic='" + characteristic + '\'' +
                ", purpose='" + purpose + '\'' +
                ", beCareful='" + beCareful + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", buyTime=" + buyTime +
                ", shareWay=" + shareWay +
                ", isOverhaul=" + isOverhaul +
                ", isApplay=" + isApplay +
                ", isUse=" + isUse +
                '}';
    }
}