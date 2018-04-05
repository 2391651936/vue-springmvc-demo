package smart.application.appoint.models;
/*
申请表
 */

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

public class Application implements Serializable {
    @Getter
    @Setter
    private Integer id;

    /*
    申请的设备
     */
    @Getter
    @Setter
    private Equipment equipment;

    /*
    申请人
     */
    @Getter
    @Setter
    private People applyPeople;

    /*
    由哪个管理员同意的
     */
    @Getter
    @Setter
    private People adminPeople;

    /*
    违规原因
     */
    @Getter
    @Setter
    private Violation violation;

    /*
    提交时间
     */
    @Getter
    @Setter
    private Date applyTime;

    /*
    开始时间
     */
    @Getter
    @Setter
    private Date startTime;

    /*
    结束时间
     */
    @Getter
    @Setter
    private Date endTime;

    /*
    是否同意
     */
    @Getter
    @Setter
    private Boolean isAgree;

    /*
    是否可用
     */
    @Getter
    @Setter
    private Boolean isUse;

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", equipment=" + equipment +
                ", applyPeople=" + applyPeople +
                ", adminPeople=" + adminPeople +
                ", violation=" + violation +
                ", applyTime=" + applyTime +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", isAgree=" + isAgree +
                ", isUse=" + isUse +
                '}';
    }
}