package smart.application.appoint.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.springframework.util.DigestUtils;

public class CredentialsMatcher extends SimpleCredentialsMatcher {

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) throws IncorrectCredentialsException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String inPassword = new String(usernamePasswordToken.getPassword());
        inPassword = DigestUtils.md5DigestAsHex(inPassword.getBytes());
        String dbPassword = (String) info.getCredentials();
        if (inPassword.equals(dbPassword)) {
            return true;
        } else {
            throw new IncorrectCredentialsException();
        }
    }
}
