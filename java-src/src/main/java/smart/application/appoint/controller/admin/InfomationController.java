package smart.application.appoint.controller.admin;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import net.minidev.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import smart.application.appoint.models.Information;
import smart.application.appoint.service.InformationService;
import smart.application.appoint.util.BaseDao;
import smart.application.appoint.util.StaticUtil;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/v1/admin")
@RestController
public class InfomationController {

    @Resource
    private InformationService informationService;

    @Resource
    private BaseDao<Information> baseDao;

    @GetMapping("/informations")
    public List<Information> informations(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "per_page") int perPage
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

    @GetMapping("/information/count")
    public int informationsCount() {
        return informationService.countInformations();
    }
}
