package smart.application.appoint.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import smart.application.appoint.models.Information;

import java.util.List;

@Mapper
public interface InformationMapper extends BaseMapper<Information> {
    List<Information> selectInformationByInformationTypeIdAndIsUseAndIsRelease(@Param("id") int id,
                                                                               @Param("isUse") boolean isUse,
                                                                               @Param("isRelease") boolean isRelease);

    Information selectInformationOne(int id);

    List<Information> selectInformationByPage(@Param("page") int page,
                                              @Param("per_page") int per_page);

    int countInformations();
}
