package smart.application.appoint.controller.login;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;
import smart.application.appoint.expression.PasswordErrorExpression;
import smart.application.appoint.expression.UsernameNotFoundExpression;
import smart.application.appoint.models.People;
import smart.application.appoint.util.StaticUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "未登录";
    }

    @PostMapping("/v1/login")
    public String login(@RequestBody People people) {
        UsernamePasswordToken token = new UsernamePasswordToken(people.getUsername(), people.getPassword());
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();

        try {
            subject.login(token);
            People dbPeople = (People) subject.getPrincipal();
            session.setAttribute("userId", dbPeople.getUsername());
            return (String) session.getId();
        } catch (UsernameNotFoundExpression e) {
            return StaticUtil.USERNAME_NOT_FOUND;
        } catch (PasswordErrorExpression e) {
            return StaticUtil.PASSWORD_ERROR;
        }
    }
}
