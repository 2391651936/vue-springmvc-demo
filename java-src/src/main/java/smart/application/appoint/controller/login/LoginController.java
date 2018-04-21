package smart.application.appoint.controller.login;

import org.springframework.web.bind.annotation.*;
import smart.application.appoint.models.People;
import smart.application.appoint.service.LoginService;
import smart.application.appoint.util.CaptchaUtil;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/v1")
public class LoginController {

    @Resource
    private LoginService loginService;

    @PostMapping("/login")
    public String login(@RequestBody People people) {
        return loginService.login(people);
    }

    @PostMapping("/logout")
    public String logout() {
        return loginService.logout();
    }
}
