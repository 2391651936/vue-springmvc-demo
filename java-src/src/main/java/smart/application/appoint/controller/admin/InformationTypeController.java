package smart.application.appoint.controller.admin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import smart.application.appoint.models.InformationType;
import smart.application.appoint.service.InformationTypeService;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/v1/admin")
@RestController
public class InformationTypeController {

    @Resource
    private InformationTypeService informationTypeService;

    @GetMapping("/informationTypes")
    public List<InformationType> informationTypes() {
        return informationTypeService.selectInformationTypeAll();
    }
}