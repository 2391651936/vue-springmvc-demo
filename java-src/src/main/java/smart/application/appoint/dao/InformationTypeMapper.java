package smart.application.appoint.dao;

import org.apache.ibatis.annotations.Mapper;
import smart.application.appoint.models.InformationType;

import java.util.List;

@Mapper
public interface InformationTypeMapper {
    List<InformationType> selectInformationTypeAll();
}
