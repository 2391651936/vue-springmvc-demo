package smart.application.appoint.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import smart.application.appoint.dao.InformationTypeMapper;
import smart.application.appoint.models.InformationType;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class InformationTypeService implements InformationTypeMapper {

    @Resource
    private InformationTypeMapper informationTypeMapper;


    @Override
    public List<InformationType> selectInformationTypeAll() {
        return informationTypeMapper.selectInformationTypeAll();
    }
}
