package smart.application.appoint.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import smart.application.appoint.dao.InformationMapper;
import smart.application.appoint.models.Information;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class InformationService implements InformationMapper {

    @Resource
    private InformationMapper informationMapper;


    @Override
    public List<Information> selectInformationByInformationTypeIdAndIsUseAndIsRelease(int id, boolean isUse, boolean isRelease) {
        return informationMapper.selectInformationByInformationTypeIdAndIsUseAndIsRelease(id, isUse, isRelease);
    }

    @Override
    public Information selectInformationOne(int id) {
        return informationMapper.selectInformationOne(id);
    }

    @Override
    public List<Information> selectInformationByPage(int page, int per_page) {
        return informationMapper.selectInformationByPage(page * per_page, per_page);
    }

    @Override
    public void save(Information information) {
        informationMapper.save(information);
    }

    @Override
    public void deleteById(int id) {
        informationMapper.deleteById(id);
    }

    @Override
    public void update(Information information) {
        informationMapper.update(information);
    }
}
