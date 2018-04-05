package smart.application.appoint.models;
/*
信息表
 */

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

public class Information implements Serializable {

    @Getter
    @Setter
    private Integer id;

    /*
    信息类别
     */
    @Getter
    @Setter
    private InformationType informationType;

    /*
    发布时间
     */
    @Getter
    @Setter
    private Date releaseTime;

    /*
    是否发布
     */
    @Getter
    @Setter
    private Boolean isRelease;

    /*
    是否可用
     */
    @Getter
    @Setter
    private Boolean isUse;

    /*
    信息内容
     */
    @Getter
    @Setter
    private String context;

    /*
    题目
     */
    @Getter
    @Setter
    private String title;

    @Override
    public String toString() {
        return "Information{" +
                "id=" + id +
                ", informationType=" + informationType +
                ", releaseTime=" + releaseTime +
                ", isRelease=" + isRelease +
                ", isUse=" + isUse +
                ", context='" + context + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}