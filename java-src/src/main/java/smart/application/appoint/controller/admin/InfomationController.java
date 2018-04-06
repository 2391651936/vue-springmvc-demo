package smart.application.appoint.controller.admin;

import org.springframework.web.bind.annotation.*;
import smart.application.appoint.models.Information;
import smart.application.appoint.service.InformationService;
import smart.application.appoint.util.BaseDao;
import smart.application.appoint.util.StaticUtil;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RequestMapping("/v1/admin")
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class InfomationController {

    @Resource
    private InformationService informationService;

    @Resource
    private BaseDao<Information> baseDao;

    @GetMapping("/informations")
    public List<Information> informations(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "per_page", defaultValue = "10") int perPage
    ) {
        return informationService.selectInformationByPage(page - 1, perPage);
    }

    @GetMapping("/informations/{id}")
    public Information information(@PathVariable("id") int id) {
        return informationService.selectInformationOne(id);
    }

    @PostMapping("/informations")
    public String addInformation(@RequestBody Information information) {
        information.setReleaseTime(new Date());
        information.setIsUse(true);
        return baseDao.save(informationService, information);
    }
}
