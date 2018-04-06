package smart.application.appoint.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.springframework.util.DigestUtils;
import smart.application.appoint.expression.PasswordErrorExpression;

public class CredentialsMatcher extends SimpleCredentialsMatcher {

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) throws PasswordErrorExpression {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String inPassword = new String(usernamePasswordToken.getPassword());
        inPassword = DigestUtils.md5DigestAsHex(inPassword.getBytes());
        String dbPassword = (String) info.getCredentials();
        if (inPassword.equals(dbPassword)) {
            return true;
        } else {
            throw new PasswordErrorExpression();
        }
    }
}
