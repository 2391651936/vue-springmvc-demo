package smart.application.appoint.controller.admin;

import org.springframework.web.bind.annotation.*;
import smart.application.appoint.models.People;
import smart.application.appoint.models.PeopleType;
import smart.application.appoint.service.PeopleService;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/v1/admin")
@RestController
public class PeopleController {

    @Resource
    private PeopleService peopleService;

    @GetMapping("/people/count")
    public int peopleCount(@RequestParam(value = "peopleType", defaultValue = "0") int peopleType) {
        return peopleService.countPeopleByPeopleType(peopleType);
    }

    @GetMapping("/people")
    public List<People> getPeople(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "per_page", defaultValue = "10") int per_page,
            @RequestParam(value = "peopleType", defaultValue = "0") int peopleType
    ) {
        return peopleService.selectPeopleByPage(page - 1, per_page, peopleType);
    }

    @GetMapping("/people/{id}")
    public People getPeopleById(@PathVariable("id") int id) {
        return peopleService.selectPeopleById(id);
    }

    @PostMapping("/people")
    public String savePeople(@RequestBody People people) {
        return peopleService.savePeople(people);
    }

    @PutMapping("/people")
    public String updatePeople(@RequestBody People people) {
        return peopleService.updatePeople(people);
    }

    @GetMapping("/peopleTypes")
    public List<PeopleType> getPeopleType() {
        return peopleService.selectPeopleType();
    }
}
