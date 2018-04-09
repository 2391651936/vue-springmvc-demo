package smart.application.appoint.controller.login;

import org.springframework.web.bind.annotation.*;
import smart.application.appoint.models.People;
import smart.application.appoint.service.LoginService;

import javax.annotation.Resource;

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
