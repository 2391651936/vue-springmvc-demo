package smart.application.appoint.expression;

import org.apache.shiro.authc.AuthenticationException;

/*
账号不存在引发的异常
 */
public class UsernameNotFoundExpression extends AuthenticationException {
    public UsernameNotFoundExpression() {
    }

    public UsernameNotFoundExpression(String messge) {
        super(messge);
    }

    public UsernameNotFoundExpression(Throwable cause) {
        super(cause);
    }

    public UsernameNotFoundExpression(String messge, Throwable cause) {
        super(messge, cause);
    }
}
