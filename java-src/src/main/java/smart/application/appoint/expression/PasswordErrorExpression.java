package smart.application.appoint.expression;
/*
密码不正确异常
 */
import org.apache.shiro.authc.AuthenticationException;

public class PasswordErrorExpression extends AuthenticationException {
    public PasswordErrorExpression() {
    }

    public PasswordErrorExpression(String message) {
        super(message);
    }

    public PasswordErrorExpression(Throwable cause) {
        super(cause);
    }

    public PasswordErrorExpression(String message, Throwable cause) {
        super(message, cause);
    }
}
