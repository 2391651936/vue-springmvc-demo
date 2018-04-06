package smart.application.appoint.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import smart.application.appoint.expression.UsernameNotFoundExpression;
import smart.application.appoint.models.People;
import smart.application.appoint.service.PeopleService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class AuthRealm extends AuthorizingRealm {

    @Resource
    private PeopleService peopleService;

    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        People people = (People) principalCollection.getPrimaryPrincipal();
        List<String> permissions = new ArrayList<>();
        permissions.add(people.getPeopleType().getName());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(permissions);  // 将权限放入 shiro 中
        return info;
    }

    // 认证、登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws UsernameNotFoundExpression {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        People people = peopleService.selectPeopleByUsername(username);
        if (people != null) {
            return new SimpleAuthenticationInfo(people, people.getPassword(), this.getClass().getName());
        } else {
            throw new UsernameNotFoundExpression();
        }
    }
}
