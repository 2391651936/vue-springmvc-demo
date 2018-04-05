package smart.application.appoint.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import smart.application.appoint.models.EquipmentType;

import java.util.List;

@Mapper
public interface EquipmentTypeMapper extends BaseMapper<EquipmentType> {
    List<EquipmentType> selectEquipmentTypeByPage(@Param("page") int page,
                                                  @Param("maxNumber") int maxNumber);

    boolean existEquipmentTypeByName(String name);

    int countEquipmentType();

    EquipmentType selectEquipmentTypeById(int id);

    EquipmentType selectEquipmentTypeByName(String name);
}
