package smart.application.appoint.mapper;

import smart.application.appoint.entity.PeopleType;

public interface PeopleTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PeopleType record);

    int insertSelective(PeopleType record);

    PeopleType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PeopleType record);

    int updateByPrimaryKey(PeopleType record);
}