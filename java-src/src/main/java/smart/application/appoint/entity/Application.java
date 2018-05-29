package smart.application.appoint.entity;

import java.util.Date;

public class Application {
    private Integer id;

    private Integer equipmentId;

    private Integer applyPeopleId;

    private Integer adminPeopleId;

    private Integer violationId;

    private Date applyTime;

    private Date startTime;

    private Date endTime;

    private Byte isAgree;

    private Byte isUse;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    public Integer getApplyPeopleId() {
        return applyPeopleId;
    }

    public void setApplyPeopleId(Integer applyPeopleId) {
        this.applyPeopleId = applyPeopleId;
    }

    public Integer getAdminPeopleId() {
        return adminPeopleId;
    }

    public void setAdminPeopleId(Integer adminPeopleId) {
        this.adminPeopleId = adminPeopleId;
    }

    public Integer getViolationId() {
        return violationId;
    }

    public void setViolationId(Integer violationId) {
        this.violationId = violationId;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Byte getIsAgree() {
        return isAgree;
    }

    public void setIsAgree(Byte isAgree) {
        this.isAgree = isAgree;
    }

    public Byte getIsUse() {
        return isUse;
    }

    public void setIsUse(Byte isUse) {
        this.isUse = isUse;
    }
}