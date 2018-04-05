package smart.application.appoint.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/*
人员表
 */
@AllArgsConstructor
@NoArgsConstructor
public class People implements Serializable {

    @Getter
    @Setter
    private Integer id;

    /*
    人员类别
     */
    @Getter
    @Setter
    private PeopleType peopleType;

    /*
    账号
     */
    @Getter
    @Setter
    private String username;

    /*
    密码
     */
    @Getter
    @Setter
    private String password;

    /*
    姓名
     */
    @Getter
    @Setter
    private String name;

    /*
    电话
     */
    @Getter
    @Setter
    private String phone;

    /*
    邮箱
     */
    @Getter
    @Setter
    private String email;

    /*
    是否可用
     */
    @Getter
    @Setter
    private Boolean isUse;

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", peopleType=" + peopleType +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", isUse=" + isUse +
                '}';
    }
}