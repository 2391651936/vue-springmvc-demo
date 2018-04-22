package smart.application.appoint.controller.admin;

import org.springframework.web.bind.annotation.*;
import smart.application.appoint.models.EquipmentType;
import smart.application.appoint.service.EquipmentTypeService;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/v1/admin")
@RestController
public class EquipmentTypeController {

    @Resource
    private EquipmentTypeService equipmentTypeService;

    @GetMapping("/equipmentType")
    public List<EquipmentType> equipmentType(
            @RequestParam("page") int page,
            @RequestParam("maxNumber") int maxNumber
    ) {
        return equipmentTypeService.selectEquipmentTypeByPage(page - 1, maxNumber);
    }

    @GetMapping("/equipmentType/count")
    public int equipmentTypeCount() {
        return equipmentTypeService.countEquipmentType();
    }

    @GetMapping("/equipmentType/{id}")
    public EquipmentType getEquipmentType(@PathVariable("id") int id) {
        return equipmentTypeService.selectEquipmentTypeById(id);
    }

    @PostMapping("/equipmentType")
    public String saveEquipmentType(@RequestBody EquipmentType equipmentType) {
        return equipmentTypeService.saveEquipmentType(equipmentType);
    }

    @PutMapping("/equipmentType")
    public String updateEquipmentType(@RequestBody EquipmentType equipmentType) {
        return equipmentTypeService.updateEquipmentType(equipmentType);
    }

    @DeleteMapping("/equipmentType")
    public String deleteEquipmentType(@RequestParam("id") int id) {
        return equipmentTypeService.deleteEquipmentType(id);
    }
}
