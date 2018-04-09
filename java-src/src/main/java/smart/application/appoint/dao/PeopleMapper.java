package smart.application.appoint.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import smart.application.appoint.models.People;
import smart.application.appoint.models.PeopleType;

import java.util.List;

@Mapper
public interface PeopleMapper extends BaseMapper<People> {
    People selectPeopleByUsername(String username);

    People selectPeopleById(int id);

    int countPeopleByPeopleType(@Param("peopleType") int peopleType);

    List<People> selectPeopleByPage(@Param("page") int page,
                                    @Param("maxNumber") int maxNumber,
                                    @Param("peopleType") int peopleType);

    List<PeopleType> selectPeopleType();

    boolean existPeopleByUsername(String username);
}
