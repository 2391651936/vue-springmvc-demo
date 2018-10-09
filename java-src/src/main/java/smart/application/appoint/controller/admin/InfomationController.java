package smart.application.appoint.controller.admin;

import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smart.application.appoint.models.Information;
import smart.application.appoint.service.InformationService;
import smart.application.appoint.util.BaseDao;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RequestMapping("/v1/admin")
@RestController
public class InfomationController {

    @Resource
    private InformationService informationService;

    @Resource
    private BaseDao<Information> baseDao;

    @GetMapping("/information/count")
    public int informationsCount() {
        return informationService.countInformations();
    }


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

    @DeleteMapping("/informations")
    public String deleteInformations(@RequestParam("id") int id) {
        return baseDao.deleteById(informationService, id);
    }

    @PutMapping("/informations")
    public String updateInformations(@RequestBody Information information) {
        return baseDao.update(informationService, information);
    }
}
